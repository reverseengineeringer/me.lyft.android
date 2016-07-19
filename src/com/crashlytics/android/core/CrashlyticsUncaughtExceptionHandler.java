package com.crashlytics.android.core;

import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Environment;
import com.crashlytics.android.core.internal.models.SessionEventData;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Logger;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.common.IdManager;
import io.fabric.sdk.android.services.persistence.FileStore;
import io.fabric.sdk.android.services.settings.SessionSettingsData;
import io.fabric.sdk.android.services.settings.Settings;
import io.fabric.sdk.android.services.settings.SettingsData;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class CrashlyticsUncaughtExceptionHandler
  implements Thread.UncaughtExceptionHandler
{
  static final FilenameFilter ANY_SESSION_FILENAME_FILTER;
  private static final String[] INITIAL_SESSION_PART_TAGS = { "SessionUser", "SessionApp", "SessionOS", "SessionDevice" };
  static final Comparator<File> LARGEST_FILE_NAME_FIRST;
  private static final Map<String, String> SEND_AT_CRASHTIME_HEADER;
  static final FilenameFilter SESSION_FILE_FILTER = new FilenameFilter()
  {
    public boolean accept(File paramAnonymousFile, String paramAnonymousString)
    {
      return (paramAnonymousString.length() == ".cls".length() + 35) && (paramAnonymousString.endsWith(".cls"));
    }
  };
  private static final Pattern SESSION_FILE_PATTERN;
  static final Comparator<File> SMALLEST_FILE_NAME_FIRST;
  private final CrashlyticsCore crashlyticsCore;
  private final Thread.UncaughtExceptionHandler defaultHandler;
  private final DevicePowerStateListener devicePowerStateListener;
  private final AtomicInteger eventCounter = new AtomicInteger(0);
  private final CrashlyticsExecutorServiceWrapper executorServiceWrapper;
  private final FileStore fileStore;
  private final IdManager idManager;
  private final AtomicBoolean isHandlingException;
  private final LogFileManager logFileManager;
  private final String unityVersion;
  
  static
  {
    LARGEST_FILE_NAME_FIRST = new Comparator()
    {
      public int compare(File paramAnonymousFile1, File paramAnonymousFile2)
      {
        return paramAnonymousFile2.getName().compareTo(paramAnonymousFile1.getName());
      }
    };
    SMALLEST_FILE_NAME_FIRST = new Comparator()
    {
      public int compare(File paramAnonymousFile1, File paramAnonymousFile2)
      {
        return paramAnonymousFile1.getName().compareTo(paramAnonymousFile2.getName());
      }
    };
    ANY_SESSION_FILENAME_FILTER = new FilenameFilter()
    {
      public boolean accept(File paramAnonymousFile, String paramAnonymousString)
      {
        return CrashlyticsUncaughtExceptionHandler.SESSION_FILE_PATTERN.matcher(paramAnonymousString).matches();
      }
    };
    SESSION_FILE_PATTERN = Pattern.compile("([\\d|A-Z|a-z]{12}\\-[\\d|A-Z|a-z]{4}\\-[\\d|A-Z|a-z]{4}\\-[\\d|A-Z|a-z]{12}).+");
    SEND_AT_CRASHTIME_HEADER = Collections.singletonMap("X-CRASHLYTICS-SEND-FLAGS", "1");
  }
  
  CrashlyticsUncaughtExceptionHandler(Thread.UncaughtExceptionHandler paramUncaughtExceptionHandler, CrashlyticsExecutorServiceWrapper paramCrashlyticsExecutorServiceWrapper, IdManager paramIdManager, UnityVersionProvider paramUnityVersionProvider, FileStore paramFileStore, CrashlyticsCore paramCrashlyticsCore)
  {
    defaultHandler = paramUncaughtExceptionHandler;
    executorServiceWrapper = paramCrashlyticsExecutorServiceWrapper;
    idManager = paramIdManager;
    crashlyticsCore = paramCrashlyticsCore;
    unityVersion = paramUnityVersionProvider.getUnityVersion();
    fileStore = paramFileStore;
    isHandlingException = new AtomicBoolean(false);
    paramUncaughtExceptionHandler = paramCrashlyticsCore.getContext();
    logFileManager = new LogFileManager(paramUncaughtExceptionHandler, paramFileStore);
    devicePowerStateListener = new DevicePowerStateListener(paramUncaughtExceptionHandler);
  }
  
  private void closeOpenSessions(File[] paramArrayOfFile, int paramInt1, int paramInt2)
  {
    Fabric.getLogger().d("CrashlyticsCore", "Closing open sessions.");
    while (paramInt1 < paramArrayOfFile.length)
    {
      File localFile = paramArrayOfFile[paramInt1];
      String str = getSessionIdFromSessionFile(localFile);
      Fabric.getLogger().d("CrashlyticsCore", "Closing session: " + str);
      writeSessionPartsToSessionFile(localFile, str, paramInt2);
      paramInt1 += 1;
    }
  }
  
  private void closeWithoutRenamingOrLog(ClsFileOutputStream paramClsFileOutputStream)
  {
    if (paramClsFileOutputStream == null) {
      return;
    }
    try
    {
      paramClsFileOutputStream.closeInProgressStream();
      return;
    }
    catch (IOException paramClsFileOutputStream)
    {
      Fabric.getLogger().e("CrashlyticsCore", "Error closing session file stream in the presence of an exception", paramClsFileOutputStream);
    }
  }
  
  private static void copyToCodedOutputStream(InputStream paramInputStream, CodedOutputStream paramCodedOutputStream, int paramInt)
    throws IOException
  {
    byte[] arrayOfByte = new byte[paramInt];
    paramInt = 0;
    while (paramInt < arrayOfByte.length)
    {
      int i = paramInputStream.read(arrayOfByte, paramInt, arrayOfByte.length - paramInt);
      if (i < 0) {
        break;
      }
      paramInt += i;
    }
    paramCodedOutputStream.writeRawBytes(arrayOfByte);
  }
  
  private void deleteLegacyInvalidCacheDir()
  {
    File localFile = new File(crashlyticsCore.getSdkDirectory(), "invalidClsFiles");
    if (!localFile.exists()) {
      return;
    }
    if (localFile.isDirectory())
    {
      File[] arrayOfFile = localFile.listFiles();
      int j = arrayOfFile.length;
      int i = 0;
      while (i < j)
      {
        arrayOfFile[i].delete();
        i += 1;
      }
    }
    localFile.delete();
  }
  
  private void deleteSessionPartFilesFor(String paramString)
  {
    paramString = listSessionPartFilesFor(paramString);
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      paramString[i].delete();
      i += 1;
    }
  }
  
  private void doCloseSessions(boolean paramBoolean)
    throws Exception
  {
    if (paramBoolean) {}
    File[] arrayOfFile;
    for (int i = 1;; i = 0)
    {
      trimOpenSessions(i + 8);
      arrayOfFile = listSortedSessionBeginFiles();
      if (arrayOfFile.length > i) {
        break;
      }
      Fabric.getLogger().d("CrashlyticsCore", "No open sessions to be closed.");
      return;
    }
    writeSessionUser(getSessionIdFromSessionFile(arrayOfFile[i]));
    Object localObject = crashlyticsCore;
    localObject = CrashlyticsCore.getSessionSettingsData();
    if (localObject == null)
    {
      Fabric.getLogger().d("CrashlyticsCore", "Unable to close session. Settings are not loaded.");
      return;
    }
    closeOpenSessions(arrayOfFile, i, maxCustomExceptionEvents);
  }
  
  private void doOpenSession()
    throws Exception
  {
    Date localDate = new Date();
    String str = new CLSUUID(idManager).toString();
    Fabric.getLogger().d("CrashlyticsCore", "Opening an new session with ID " + str);
    writeBeginSession(str, localDate);
    writeSessionApp(str);
    writeSessionOS(str);
    writeSessionDevice(str);
    logFileManager.setCurrentSession(str);
  }
  
  /* Error */
  private void doWriteNonFatal(Date paramDate, Thread paramThread, Throwable paramThrowable)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 220	com/crashlytics/android/core/CrashlyticsUncaughtExceptionHandler:getCurrentSessionId	()Ljava/lang/String;
    //   4: astore 12
    //   6: aload 12
    //   8: ifnonnull +18 -> 26
    //   11: invokestatic 249	io/fabric/sdk/android/Fabric:getLogger	()Lio/fabric/sdk/android/Logger;
    //   14: ldc -5
    //   16: ldc_w 391
    //   19: aconst_null
    //   20: invokeinterface 292 4 0
    //   25: return
    //   26: aload 12
    //   28: invokestatic 394	com/crashlytics/android/core/CrashlyticsCore:recordLoggedExceptionEvent	(Ljava/lang/String;)V
    //   31: aconst_null
    //   32: astore 6
    //   34: aconst_null
    //   35: astore 8
    //   37: aconst_null
    //   38: astore 11
    //   40: aconst_null
    //   41: astore 10
    //   43: aconst_null
    //   44: astore 9
    //   46: aconst_null
    //   47: astore 7
    //   49: aload 11
    //   51: astore 4
    //   53: aload 6
    //   55: astore 5
    //   57: invokestatic 249	io/fabric/sdk/android/Fabric:getLogger	()Lio/fabric/sdk/android/Logger;
    //   60: ldc -5
    //   62: new 265	java/lang/StringBuilder
    //   65: dup
    //   66: invokespecial 266	java/lang/StringBuilder:<init>	()V
    //   69: ldc_w 396
    //   72: invokevirtual 272	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: aload_3
    //   76: invokevirtual 399	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   79: ldc_w 401
    //   82: invokevirtual 272	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: aload_2
    //   86: invokevirtual 406	java/lang/Thread:getName	()Ljava/lang/String;
    //   89: invokevirtual 272	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: invokevirtual 275	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   95: invokeinterface 259 3 0
    //   100: aload 11
    //   102: astore 4
    //   104: aload 6
    //   106: astore 5
    //   108: aload_0
    //   109: getfield 138	com/crashlytics/android/core/CrashlyticsUncaughtExceptionHandler:eventCounter	Ljava/util/concurrent/atomic/AtomicInteger;
    //   112: invokevirtual 410	java/util/concurrent/atomic/AtomicInteger:getAndIncrement	()I
    //   115: invokestatic 416	io/fabric/sdk/android/services/common/CommonUtils:padWithZerosToMaxIntWidth	(I)Ljava/lang/String;
    //   118: astore 13
    //   120: aload 11
    //   122: astore 4
    //   124: aload 6
    //   126: astore 5
    //   128: new 265	java/lang/StringBuilder
    //   131: dup
    //   132: invokespecial 266	java/lang/StringBuilder:<init>	()V
    //   135: aload 12
    //   137: invokevirtual 272	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: ldc_w 418
    //   143: invokevirtual 272	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: aload 13
    //   148: invokevirtual 272	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: invokevirtual 275	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   154: astore 13
    //   156: aload 11
    //   158: astore 4
    //   160: aload 6
    //   162: astore 5
    //   164: new 283	com/crashlytics/android/core/ClsFileOutputStream
    //   167: dup
    //   168: aload_0
    //   169: invokespecial 226	com/crashlytics/android/core/CrashlyticsUncaughtExceptionHandler:getFilesDir	()Ljava/io/File;
    //   172: aload 13
    //   174: invokespecial 419	com/crashlytics/android/core/ClsFileOutputStream:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   177: astore 6
    //   179: aload 10
    //   181: astore 4
    //   183: aload 9
    //   185: astore 5
    //   187: aload 6
    //   189: invokestatic 423	com/crashlytics/android/core/CodedOutputStream:newInstance	(Ljava/io/OutputStream;)Lcom/crashlytics/android/core/CodedOutputStream;
    //   192: astore 7
    //   194: aload 7
    //   196: astore 4
    //   198: aload 7
    //   200: astore 5
    //   202: aload_0
    //   203: aload 7
    //   205: aload_1
    //   206: aload_2
    //   207: aload_3
    //   208: ldc_w 425
    //   211: iconst_0
    //   212: invokespecial 429	com/crashlytics/android/core/CrashlyticsUncaughtExceptionHandler:writeSessionEvent	(Lcom/crashlytics/android/core/CodedOutputStream;Ljava/util/Date;Ljava/lang/Thread;Ljava/lang/Throwable;Ljava/lang/String;Z)V
    //   215: aload 7
    //   217: ldc_w 431
    //   220: invokestatic 435	io/fabric/sdk/android/services/common/CommonUtils:flushOrLog	(Ljava/io/Flushable;Ljava/lang/String;)V
    //   223: aload 6
    //   225: ldc_w 437
    //   228: invokestatic 441	io/fabric/sdk/android/services/common/CommonUtils:closeOrLog	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   231: aload_0
    //   232: aload 12
    //   234: bipush 64
    //   236: invokespecial 445	com/crashlytics/android/core/CrashlyticsUncaughtExceptionHandler:trimSessionEventFiles	(Ljava/lang/String;I)V
    //   239: return
    //   240: astore_1
    //   241: invokestatic 249	io/fabric/sdk/android/Fabric:getLogger	()Lio/fabric/sdk/android/Logger;
    //   244: ldc -5
    //   246: ldc_w 447
    //   249: aload_1
    //   250: invokeinterface 292 4 0
    //   255: return
    //   256: astore_3
    //   257: aload 8
    //   259: astore_2
    //   260: aload 7
    //   262: astore_1
    //   263: aload_1
    //   264: astore 4
    //   266: aload_2
    //   267: astore 5
    //   269: invokestatic 249	io/fabric/sdk/android/Fabric:getLogger	()Lio/fabric/sdk/android/Logger;
    //   272: ldc -5
    //   274: ldc_w 449
    //   277: aload_3
    //   278: invokeinterface 292 4 0
    //   283: aload_1
    //   284: astore 4
    //   286: aload_2
    //   287: astore 5
    //   289: aload_3
    //   290: aload_2
    //   291: invokestatic 455	com/crashlytics/android/core/ExceptionUtils:writeStackTraceIfNotNull	(Ljava/lang/Throwable;Ljava/io/OutputStream;)V
    //   294: aload_1
    //   295: ldc_w 431
    //   298: invokestatic 435	io/fabric/sdk/android/services/common/CommonUtils:flushOrLog	(Ljava/io/Flushable;Ljava/lang/String;)V
    //   301: aload_2
    //   302: ldc_w 437
    //   305: invokestatic 441	io/fabric/sdk/android/services/common/CommonUtils:closeOrLog	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   308: goto -77 -> 231
    //   311: astore_1
    //   312: aload 4
    //   314: ldc_w 431
    //   317: invokestatic 435	io/fabric/sdk/android/services/common/CommonUtils:flushOrLog	(Ljava/io/Flushable;Ljava/lang/String;)V
    //   320: aload 5
    //   322: ldc_w 437
    //   325: invokestatic 441	io/fabric/sdk/android/services/common/CommonUtils:closeOrLog	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   328: aload_1
    //   329: athrow
    //   330: astore_1
    //   331: aload 6
    //   333: astore 5
    //   335: goto -23 -> 312
    //   338: astore_3
    //   339: aload 6
    //   341: astore_2
    //   342: aload 5
    //   344: astore_1
    //   345: goto -82 -> 263
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	348	0	this	CrashlyticsUncaughtExceptionHandler
    //   0	348	1	paramDate	Date
    //   0	348	2	paramThread	Thread
    //   0	348	3	paramThrowable	Throwable
    //   51	262	4	localObject1	Object
    //   55	288	5	localObject2	Object
    //   32	308	6	localClsFileOutputStream	ClsFileOutputStream
    //   47	214	7	localCodedOutputStream	CodedOutputStream
    //   35	223	8	localObject3	Object
    //   44	140	9	localObject4	Object
    //   41	139	10	localObject5	Object
    //   38	119	11	localObject6	Object
    //   4	229	12	str1	String
    //   118	55	13	str2	String
    // Exception table:
    //   from	to	target	type
    //   231	239	240	java/lang/Exception
    //   57	100	256	java/lang/Exception
    //   108	120	256	java/lang/Exception
    //   128	156	256	java/lang/Exception
    //   164	179	256	java/lang/Exception
    //   57	100	311	finally
    //   108	120	311	finally
    //   128	156	311	finally
    //   164	179	311	finally
    //   269	283	311	finally
    //   289	294	311	finally
    //   187	194	330	finally
    //   202	215	330	finally
    //   187	194	338	java/lang/Exception
    //   202	215	338	java/lang/Exception
  }
  
  private File[] ensureFileArrayNotNull(File[] paramArrayOfFile)
  {
    File[] arrayOfFile = paramArrayOfFile;
    if (paramArrayOfFile == null) {
      arrayOfFile = new File[0];
    }
    return arrayOfFile;
  }
  
  private String getCurrentSessionId()
  {
    File[] arrayOfFile = listSortedSessionBeginFiles();
    if (arrayOfFile.length > 0) {
      return getSessionIdFromSessionFile(arrayOfFile[0]);
    }
    return null;
  }
  
  private File getFilesDir()
  {
    return fileStore.getFilesDir();
  }
  
  private String getPreviousSessionId()
  {
    File[] arrayOfFile = listSortedSessionBeginFiles();
    if (arrayOfFile.length > 1) {
      return getSessionIdFromSessionFile(arrayOfFile[1]);
    }
    return null;
  }
  
  private String getSessionIdFromSessionFile(File paramFile)
  {
    return paramFile.getName().substring(0, 35);
  }
  
  private File[] getTrimmedNonFatalFiles(String paramString, File[] paramArrayOfFile, int paramInt)
  {
    File[] arrayOfFile = paramArrayOfFile;
    if (paramArrayOfFile.length > paramInt)
    {
      Fabric.getLogger().d("CrashlyticsCore", String.format(Locale.US, "Trimming down to %d logged exceptions.", new Object[] { Integer.valueOf(paramInt) }));
      trimSessionEventFiles(paramString, paramInt);
      arrayOfFile = listFilesMatching(new FileNameContainsFilter(paramString + "SessionEvent"));
    }
    return arrayOfFile;
  }
  
  private UserMetaData getUserMetaData(String paramString)
  {
    if (isHandlingException()) {
      return new UserMetaData(crashlyticsCore.getUserIdentifier(), crashlyticsCore.getUserName(), crashlyticsCore.getUserEmail());
    }
    return new MetaDataStore(getFilesDir()).readUserData(paramString);
  }
  
  private void handleUncaughtException(Date paramDate, Thread paramThread, Throwable paramThrowable)
    throws Exception
  {
    crashlyticsCore.createCrashMarker();
    writeFatal(paramDate, paramThread, paramThrowable);
    doCloseSessions();
    doOpenSession();
    trimSessionFiles();
    if (!crashlyticsCore.shouldPromptUserBeforeSendingCrashReports()) {
      sendSessionReports();
    }
  }
  
  private File[] listCompleteSessionFiles()
  {
    return listFilesMatching(SESSION_FILE_FILTER);
  }
  
  private File[] listFilesMatching(FilenameFilter paramFilenameFilter)
  {
    return ensureFileArrayNotNull(getFilesDir().listFiles(paramFilenameFilter));
  }
  
  private File[] listSessionPartFilesFor(String paramString)
  {
    return listFilesMatching(new SessionPartFileFilter(paramString));
  }
  
  private File[] listSortedSessionBeginFiles()
  {
    File[] arrayOfFile = listSessionBeginFiles();
    Arrays.sort(arrayOfFile, LARGEST_FILE_NAME_FIRST);
    return arrayOfFile;
  }
  
  private void sendSessionReports()
  {
    File[] arrayOfFile = listCompleteSessionFiles();
    int j = arrayOfFile.length;
    int i = 0;
    while (i < j)
    {
      File localFile = arrayOfFile[i];
      executorServiceWrapper.executeAsync(new SendSessionRunnable(crashlyticsCore, localFile));
      i += 1;
    }
  }
  
  /* Error */
  private void synthesizeSessionFile(File paramFile1, String paramString, File[] paramArrayOfFile, File paramFile2)
  {
    // Byte code:
    //   0: aload 4
    //   2: ifnull +250 -> 252
    //   5: iconst_1
    //   6: istore 5
    //   8: aconst_null
    //   9: astore 7
    //   11: aconst_null
    //   12: astore 10
    //   14: aconst_null
    //   15: astore 6
    //   17: aconst_null
    //   18: astore 12
    //   20: aconst_null
    //   21: astore 11
    //   23: aconst_null
    //   24: astore 9
    //   26: new 283	com/crashlytics/android/core/ClsFileOutputStream
    //   29: dup
    //   30: aload_0
    //   31: invokespecial 226	com/crashlytics/android/core/CrashlyticsUncaughtExceptionHandler:getFilesDir	()Ljava/io/File;
    //   34: aload_2
    //   35: invokespecial 419	com/crashlytics/android/core/ClsFileOutputStream:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   38: astore 8
    //   40: aload 12
    //   42: astore 6
    //   44: aload 11
    //   46: astore 7
    //   48: aload 8
    //   50: invokestatic 423	com/crashlytics/android/core/CodedOutputStream:newInstance	(Ljava/io/OutputStream;)Lcom/crashlytics/android/core/CodedOutputStream;
    //   53: astore 9
    //   55: aload 9
    //   57: astore 6
    //   59: aload 9
    //   61: astore 7
    //   63: invokestatic 249	io/fabric/sdk/android/Fabric:getLogger	()Lio/fabric/sdk/android/Logger;
    //   66: ldc -5
    //   68: new 265	java/lang/StringBuilder
    //   71: dup
    //   72: invokespecial 266	java/lang/StringBuilder:<init>	()V
    //   75: ldc_w 561
    //   78: invokevirtual 272	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: aload_2
    //   82: invokevirtual 272	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: invokevirtual 275	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   88: invokeinterface 259 3 0
    //   93: aload 9
    //   95: astore 6
    //   97: aload 9
    //   99: astore 7
    //   101: aload 9
    //   103: aload_1
    //   104: invokestatic 565	com/crashlytics/android/core/CrashlyticsUncaughtExceptionHandler:writeToCosFromFile	(Lcom/crashlytics/android/core/CodedOutputStream;Ljava/io/File;)V
    //   107: aload 9
    //   109: astore 6
    //   111: aload 9
    //   113: astore 7
    //   115: aload 9
    //   117: iconst_4
    //   118: new 364	java/util/Date
    //   121: dup
    //   122: invokespecial 365	java/util/Date:<init>	()V
    //   125: invokevirtual 569	java/util/Date:getTime	()J
    //   128: ldc2_w 570
    //   131: ldiv
    //   132: invokevirtual 575	com/crashlytics/android/core/CodedOutputStream:writeUInt64	(IJ)V
    //   135: aload 9
    //   137: astore 6
    //   139: aload 9
    //   141: astore 7
    //   143: aload 9
    //   145: iconst_5
    //   146: iload 5
    //   148: invokevirtual 579	com/crashlytics/android/core/CodedOutputStream:writeBool	(IZ)V
    //   151: aload 9
    //   153: astore 6
    //   155: aload 9
    //   157: astore 7
    //   159: aload_0
    //   160: aload 9
    //   162: aload_2
    //   163: invokespecial 583	com/crashlytics/android/core/CrashlyticsUncaughtExceptionHandler:writeInitialPartsTo	(Lcom/crashlytics/android/core/CodedOutputStream;Ljava/lang/String;)V
    //   166: aload 9
    //   168: astore 6
    //   170: aload 9
    //   172: astore 7
    //   174: aload 9
    //   176: aload_3
    //   177: aload_2
    //   178: invokestatic 587	com/crashlytics/android/core/CrashlyticsUncaughtExceptionHandler:writeNonFatalEventsTo	(Lcom/crashlytics/android/core/CodedOutputStream;[Ljava/io/File;Ljava/lang/String;)V
    //   181: iload 5
    //   183: ifeq +18 -> 201
    //   186: aload 9
    //   188: astore 6
    //   190: aload 9
    //   192: astore 7
    //   194: aload 9
    //   196: aload 4
    //   198: invokestatic 565	com/crashlytics/android/core/CrashlyticsUncaughtExceptionHandler:writeToCosFromFile	(Lcom/crashlytics/android/core/CodedOutputStream;Ljava/io/File;)V
    //   201: aload 9
    //   203: astore 6
    //   205: aload 9
    //   207: astore 7
    //   209: aload 9
    //   211: bipush 11
    //   213: iconst_1
    //   214: invokevirtual 591	com/crashlytics/android/core/CodedOutputStream:writeUInt32	(II)V
    //   217: aload 9
    //   219: astore 6
    //   221: aload 9
    //   223: astore 7
    //   225: aload 9
    //   227: bipush 12
    //   229: iconst_3
    //   230: invokevirtual 594	com/crashlytics/android/core/CodedOutputStream:writeEnum	(II)V
    //   233: aload 9
    //   235: ldc_w 596
    //   238: invokestatic 435	io/fabric/sdk/android/services/common/CommonUtils:flushOrLog	(Ljava/io/Flushable;Ljava/lang/String;)V
    //   241: iconst_0
    //   242: ifeq +16 -> 258
    //   245: aload_0
    //   246: aload 8
    //   248: invokespecial 598	com/crashlytics/android/core/CrashlyticsUncaughtExceptionHandler:closeWithoutRenamingOrLog	(Lcom/crashlytics/android/core/ClsFileOutputStream;)V
    //   251: return
    //   252: iconst_0
    //   253: istore 5
    //   255: goto -247 -> 8
    //   258: aload 8
    //   260: ldc_w 600
    //   263: invokestatic 441	io/fabric/sdk/android/services/common/CommonUtils:closeOrLog	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   266: return
    //   267: astore 4
    //   269: aload 10
    //   271: astore_3
    //   272: aload 9
    //   274: astore_1
    //   275: aload_1
    //   276: astore 6
    //   278: aload_3
    //   279: astore 7
    //   281: invokestatic 249	io/fabric/sdk/android/Fabric:getLogger	()Lio/fabric/sdk/android/Logger;
    //   284: ldc -5
    //   286: new 265	java/lang/StringBuilder
    //   289: dup
    //   290: invokespecial 266	java/lang/StringBuilder:<init>	()V
    //   293: ldc_w 602
    //   296: invokevirtual 272	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: aload_2
    //   300: invokevirtual 272	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: invokevirtual 275	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   306: aload 4
    //   308: invokeinterface 292 4 0
    //   313: aload_1
    //   314: astore 6
    //   316: aload_3
    //   317: astore 7
    //   319: aload 4
    //   321: aload_3
    //   322: invokestatic 455	com/crashlytics/android/core/ExceptionUtils:writeStackTraceIfNotNull	(Ljava/lang/Throwable;Ljava/io/OutputStream;)V
    //   325: aload_1
    //   326: ldc_w 596
    //   329: invokestatic 435	io/fabric/sdk/android/services/common/CommonUtils:flushOrLog	(Ljava/io/Flushable;Ljava/lang/String;)V
    //   332: iconst_1
    //   333: ifeq +9 -> 342
    //   336: aload_0
    //   337: aload_3
    //   338: invokespecial 598	com/crashlytics/android/core/CrashlyticsUncaughtExceptionHandler:closeWithoutRenamingOrLog	(Lcom/crashlytics/android/core/ClsFileOutputStream;)V
    //   341: return
    //   342: aload_3
    //   343: ldc_w 600
    //   346: invokestatic 441	io/fabric/sdk/android/services/common/CommonUtils:closeOrLog	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   349: return
    //   350: astore_1
    //   351: aload 6
    //   353: ldc_w 596
    //   356: invokestatic 435	io/fabric/sdk/android/services/common/CommonUtils:flushOrLog	(Ljava/io/Flushable;Ljava/lang/String;)V
    //   359: iconst_0
    //   360: ifeq +11 -> 371
    //   363: aload_0
    //   364: aload 7
    //   366: invokespecial 598	com/crashlytics/android/core/CrashlyticsUncaughtExceptionHandler:closeWithoutRenamingOrLog	(Lcom/crashlytics/android/core/ClsFileOutputStream;)V
    //   369: aload_1
    //   370: athrow
    //   371: aload 7
    //   373: ldc_w 600
    //   376: invokestatic 441	io/fabric/sdk/android/services/common/CommonUtils:closeOrLog	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   379: goto -10 -> 369
    //   382: astore_1
    //   383: aload 8
    //   385: astore 7
    //   387: goto -36 -> 351
    //   390: astore 4
    //   392: aload 8
    //   394: astore_3
    //   395: aload 7
    //   397: astore_1
    //   398: goto -123 -> 275
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	401	0	this	CrashlyticsUncaughtExceptionHandler
    //   0	401	1	paramFile1	File
    //   0	401	2	paramString	String
    //   0	401	3	paramArrayOfFile	File[]
    //   0	401	4	paramFile2	File
    //   6	248	5	bool	boolean
    //   15	337	6	localObject1	Object
    //   9	387	7	localObject2	Object
    //   38	355	8	localClsFileOutputStream	ClsFileOutputStream
    //   24	249	9	localCodedOutputStream	CodedOutputStream
    //   12	258	10	localObject3	Object
    //   21	24	11	localObject4	Object
    //   18	23	12	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   26	40	267	java/lang/Exception
    //   26	40	350	finally
    //   281	313	350	finally
    //   319	325	350	finally
    //   48	55	382	finally
    //   63	93	382	finally
    //   101	107	382	finally
    //   115	135	382	finally
    //   143	151	382	finally
    //   159	166	382	finally
    //   174	181	382	finally
    //   194	201	382	finally
    //   209	217	382	finally
    //   225	233	382	finally
    //   48	55	390	java/lang/Exception
    //   63	93	390	java/lang/Exception
    //   101	107	390	java/lang/Exception
    //   115	135	390	java/lang/Exception
    //   143	151	390	java/lang/Exception
    //   159	166	390	java/lang/Exception
    //   174	181	390	java/lang/Exception
    //   194	201	390	java/lang/Exception
    //   209	217	390	java/lang/Exception
    //   225	233	390	java/lang/Exception
  }
  
  private void trimOpenSessions(int paramInt)
  {
    HashSet localHashSet = new HashSet();
    File[] arrayOfFile = listSortedSessionBeginFiles();
    int i = Math.min(paramInt, arrayOfFile.length);
    paramInt = 0;
    while (paramInt < i)
    {
      localHashSet.add(getSessionIdFromSessionFile(arrayOfFile[paramInt]));
      paramInt += 1;
    }
    logFileManager.discardOldLogFiles(localHashSet);
    arrayOfFile = listFilesMatching(new AnySessionPartFileFilter(null));
    i = arrayOfFile.length;
    paramInt = 0;
    while (paramInt < i)
    {
      File localFile = arrayOfFile[paramInt];
      String str = localFile.getName();
      Matcher localMatcher = SESSION_FILE_PATTERN.matcher(str);
      localMatcher.matches();
      if (!localHashSet.contains(localMatcher.group(1)))
      {
        Fabric.getLogger().d("CrashlyticsCore", "Trimming open session file: " + str);
        localFile.delete();
      }
      paramInt += 1;
    }
  }
  
  private void trimSessionEventFiles(String paramString, int paramInt)
  {
    Utils.capFileCount(getFilesDir(), new FileNameContainsFilter(paramString + "SessionEvent"), paramInt, SMALLEST_FILE_NAME_FIRST);
  }
  
  /* Error */
  private void writeBeginSession(String paramString, Date paramDate)
    throws Exception
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 7
    //   6: aconst_null
    //   7: astore_3
    //   8: aconst_null
    //   9: astore 9
    //   11: aconst_null
    //   12: astore 8
    //   14: aconst_null
    //   15: astore 6
    //   17: new 283	com/crashlytics/android/core/ClsFileOutputStream
    //   20: dup
    //   21: aload_0
    //   22: invokespecial 226	com/crashlytics/android/core/CrashlyticsUncaughtExceptionHandler:getFilesDir	()Ljava/io/File;
    //   25: new 265	java/lang/StringBuilder
    //   28: dup
    //   29: invokespecial 266	java/lang/StringBuilder:<init>	()V
    //   32: aload_1
    //   33: invokevirtual 272	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: ldc_w 649
    //   39: invokevirtual 272	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: invokevirtual 275	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: invokespecial 419	com/crashlytics/android/core/ClsFileOutputStream:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   48: astore 5
    //   50: aload 9
    //   52: astore_3
    //   53: aload 8
    //   55: astore 4
    //   57: aload 5
    //   59: invokestatic 423	com/crashlytics/android/core/CodedOutputStream:newInstance	(Ljava/io/OutputStream;)Lcom/crashlytics/android/core/CodedOutputStream;
    //   62: astore 6
    //   64: aload 6
    //   66: astore_3
    //   67: aload 6
    //   69: astore 4
    //   71: aload 6
    //   73: aload_1
    //   74: getstatic 474	java/util/Locale:US	Ljava/util/Locale;
    //   77: ldc_w 651
    //   80: iconst_1
    //   81: anewarray 4	java/lang/Object
    //   84: dup
    //   85: iconst_0
    //   86: aload_0
    //   87: getfield 146	com/crashlytics/android/core/CrashlyticsUncaughtExceptionHandler:crashlyticsCore	Lcom/crashlytics/android/core/CrashlyticsCore;
    //   90: invokevirtual 654	com/crashlytics/android/core/CrashlyticsCore:getVersion	()Ljava/lang/String;
    //   93: aastore
    //   94: invokestatic 486	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   97: aload_2
    //   98: invokevirtual 569	java/util/Date:getTime	()J
    //   101: ldc2_w 570
    //   104: ldiv
    //   105: invokestatic 659	com/crashlytics/android/core/SessionProtobufHelper:writeBeginSession	(Lcom/crashlytics/android/core/CodedOutputStream;Ljava/lang/String;Ljava/lang/String;J)V
    //   108: aload 6
    //   110: ldc_w 661
    //   113: invokestatic 435	io/fabric/sdk/android/services/common/CommonUtils:flushOrLog	(Ljava/io/Flushable;Ljava/lang/String;)V
    //   116: aload 5
    //   118: ldc_w 663
    //   121: invokestatic 441	io/fabric/sdk/android/services/common/CommonUtils:closeOrLog	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   124: return
    //   125: astore 5
    //   127: aload 7
    //   129: astore_2
    //   130: aload 6
    //   132: astore_1
    //   133: aload_1
    //   134: astore_3
    //   135: aload_2
    //   136: astore 4
    //   138: aload 5
    //   140: aload_2
    //   141: invokestatic 455	com/crashlytics/android/core/ExceptionUtils:writeStackTraceIfNotNull	(Ljava/lang/Throwable;Ljava/io/OutputStream;)V
    //   144: aload_1
    //   145: astore_3
    //   146: aload_2
    //   147: astore 4
    //   149: aload 5
    //   151: athrow
    //   152: astore_1
    //   153: aload_3
    //   154: ldc_w 661
    //   157: invokestatic 435	io/fabric/sdk/android/services/common/CommonUtils:flushOrLog	(Ljava/io/Flushable;Ljava/lang/String;)V
    //   160: aload 4
    //   162: ldc_w 663
    //   165: invokestatic 441	io/fabric/sdk/android/services/common/CommonUtils:closeOrLog	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   168: aload_1
    //   169: athrow
    //   170: astore_1
    //   171: aload 5
    //   173: astore 4
    //   175: goto -22 -> 153
    //   178: astore_3
    //   179: aload 5
    //   181: astore_2
    //   182: aload 4
    //   184: astore_1
    //   185: aload_3
    //   186: astore 5
    //   188: goto -55 -> 133
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	191	0	this	CrashlyticsUncaughtExceptionHandler
    //   0	191	1	paramString	String
    //   0	191	2	paramDate	Date
    //   7	147	3	localObject1	Object
    //   178	8	3	localException1	Exception
    //   1	182	4	localObject2	Object
    //   48	69	5	localClsFileOutputStream	ClsFileOutputStream
    //   125	55	5	localException2	Exception
    //   186	1	5	localException3	Exception
    //   15	116	6	localCodedOutputStream	CodedOutputStream
    //   4	124	7	localObject3	Object
    //   12	42	8	localObject4	Object
    //   9	42	9	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   17	50	125	java/lang/Exception
    //   17	50	152	finally
    //   138	144	152	finally
    //   149	152	152	finally
    //   57	64	170	finally
    //   71	108	170	finally
    //   57	64	178	java/lang/Exception
    //   71	108	178	java/lang/Exception
  }
  
  /* Error */
  private void writeExternalCrashEvent(SessionEventData paramSessionEventData)
    throws IOException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: aconst_null
    //   7: astore 9
    //   9: aconst_null
    //   10: astore 8
    //   12: aconst_null
    //   13: astore 7
    //   15: aconst_null
    //   16: astore 6
    //   18: aload 9
    //   20: astore_2
    //   21: aload 4
    //   23: astore_3
    //   24: aload_0
    //   25: invokespecial 665	com/crashlytics/android/core/CrashlyticsUncaughtExceptionHandler:getPreviousSessionId	()Ljava/lang/String;
    //   28: astore 10
    //   30: aload 10
    //   32: ifnonnull +38 -> 70
    //   35: aload 9
    //   37: astore_2
    //   38: aload 4
    //   40: astore_3
    //   41: invokestatic 249	io/fabric/sdk/android/Fabric:getLogger	()Lio/fabric/sdk/android/Logger;
    //   44: ldc -5
    //   46: ldc_w 667
    //   49: aconst_null
    //   50: invokeinterface 292 4 0
    //   55: aconst_null
    //   56: ldc_w 661
    //   59: invokestatic 435	io/fabric/sdk/android/services/common/CommonUtils:flushOrLog	(Ljava/io/Flushable;Ljava/lang/String;)V
    //   62: aconst_null
    //   63: ldc_w 669
    //   66: invokestatic 441	io/fabric/sdk/android/services/common/CommonUtils:closeOrLog	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   69: return
    //   70: aload 9
    //   72: astore_2
    //   73: aload 4
    //   75: astore_3
    //   76: aload 10
    //   78: invokestatic 672	com/crashlytics/android/core/CrashlyticsCore:recordFatalExceptionEvent	(Ljava/lang/String;)V
    //   81: aload 9
    //   83: astore_2
    //   84: aload 4
    //   86: astore_3
    //   87: new 283	com/crashlytics/android/core/ClsFileOutputStream
    //   90: dup
    //   91: aload_0
    //   92: invokespecial 226	com/crashlytics/android/core/CrashlyticsUncaughtExceptionHandler:getFilesDir	()Ljava/io/File;
    //   95: new 265	java/lang/StringBuilder
    //   98: dup
    //   99: invokespecial 266	java/lang/StringBuilder:<init>	()V
    //   102: aload 10
    //   104: invokevirtual 272	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: ldc_w 674
    //   110: invokevirtual 272	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: invokevirtual 275	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   116: invokespecial 419	com/crashlytics/android/core/ClsFileOutputStream:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   119: astore 4
    //   121: aload 8
    //   123: astore_2
    //   124: aload 7
    //   126: astore_3
    //   127: aload 4
    //   129: invokestatic 423	com/crashlytics/android/core/CodedOutputStream:newInstance	(Ljava/io/OutputStream;)Lcom/crashlytics/android/core/CodedOutputStream;
    //   132: astore 5
    //   134: aload 5
    //   136: astore_2
    //   137: aload 5
    //   139: astore_3
    //   140: new 508	com/crashlytics/android/core/MetaDataStore
    //   143: dup
    //   144: aload_0
    //   145: invokespecial 226	com/crashlytics/android/core/CrashlyticsUncaughtExceptionHandler:getFilesDir	()Ljava/io/File;
    //   148: invokespecial 511	com/crashlytics/android/core/MetaDataStore:<init>	(Ljava/io/File;)V
    //   151: aload 10
    //   153: invokevirtual 678	com/crashlytics/android/core/MetaDataStore:readKeyData	(Ljava/lang/String;)Ljava/util/Map;
    //   156: astore 6
    //   158: aload 5
    //   160: astore_2
    //   161: aload 5
    //   163: astore_3
    //   164: aload_1
    //   165: new 171	com/crashlytics/android/core/LogFileManager
    //   168: dup
    //   169: aload_0
    //   170: getfield 146	com/crashlytics/android/core/CrashlyticsUncaughtExceptionHandler:crashlyticsCore	Lcom/crashlytics/android/core/CrashlyticsCore;
    //   173: invokevirtual 169	com/crashlytics/android/core/CrashlyticsCore:getContext	()Landroid/content/Context;
    //   176: aload_0
    //   177: getfield 156	com/crashlytics/android/core/CrashlyticsUncaughtExceptionHandler:fileStore	Lio/fabric/sdk/android/services/persistence/FileStore;
    //   180: aload 10
    //   182: invokespecial 681	com/crashlytics/android/core/LogFileManager:<init>	(Landroid/content/Context;Lio/fabric/sdk/android/services/persistence/FileStore;Ljava/lang/String;)V
    //   185: aload 6
    //   187: aload 5
    //   189: invokestatic 687	com/crashlytics/android/core/NativeCrashWriter:writeNativeCrash	(Lcom/crashlytics/android/core/internal/models/SessionEventData;Lcom/crashlytics/android/core/LogFileManager;Ljava/util/Map;Lcom/crashlytics/android/core/CodedOutputStream;)V
    //   192: aload 5
    //   194: ldc_w 661
    //   197: invokestatic 435	io/fabric/sdk/android/services/common/CommonUtils:flushOrLog	(Ljava/io/Flushable;Ljava/lang/String;)V
    //   200: aload 4
    //   202: ldc_w 669
    //   205: invokestatic 441	io/fabric/sdk/android/services/common/CommonUtils:closeOrLog	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   208: return
    //   209: astore_1
    //   210: aload 5
    //   212: astore 4
    //   214: aload_1
    //   215: astore 5
    //   217: aload 6
    //   219: astore_1
    //   220: aload_1
    //   221: astore_2
    //   222: aload 4
    //   224: astore_3
    //   225: invokestatic 249	io/fabric/sdk/android/Fabric:getLogger	()Lio/fabric/sdk/android/Logger;
    //   228: ldc -5
    //   230: ldc_w 689
    //   233: aload 5
    //   235: invokeinterface 292 4 0
    //   240: aload_1
    //   241: astore_2
    //   242: aload 4
    //   244: astore_3
    //   245: aload 5
    //   247: aload 4
    //   249: invokestatic 455	com/crashlytics/android/core/ExceptionUtils:writeStackTraceIfNotNull	(Ljava/lang/Throwable;Ljava/io/OutputStream;)V
    //   252: aload_1
    //   253: ldc_w 661
    //   256: invokestatic 435	io/fabric/sdk/android/services/common/CommonUtils:flushOrLog	(Ljava/io/Flushable;Ljava/lang/String;)V
    //   259: aload 4
    //   261: ldc_w 669
    //   264: invokestatic 441	io/fabric/sdk/android/services/common/CommonUtils:closeOrLog	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   267: return
    //   268: astore_1
    //   269: aload_2
    //   270: ldc_w 661
    //   273: invokestatic 435	io/fabric/sdk/android/services/common/CommonUtils:flushOrLog	(Ljava/io/Flushable;Ljava/lang/String;)V
    //   276: aload_3
    //   277: ldc_w 669
    //   280: invokestatic 441	io/fabric/sdk/android/services/common/CommonUtils:closeOrLog	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   283: aload_1
    //   284: athrow
    //   285: astore_1
    //   286: aload 4
    //   288: astore_3
    //   289: goto -20 -> 269
    //   292: astore 5
    //   294: aload_3
    //   295: astore_1
    //   296: goto -76 -> 220
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	299	0	this	CrashlyticsUncaughtExceptionHandler
    //   0	299	1	paramSessionEventData	SessionEventData
    //   20	250	2	localObject1	Object
    //   23	272	3	localObject2	Object
    //   1	286	4	localObject3	Object
    //   4	242	5	localObject4	Object
    //   292	1	5	localException	Exception
    //   16	202	6	localMap	Map
    //   13	112	7	localObject5	Object
    //   10	112	8	localObject6	Object
    //   7	75	9	localObject7	Object
    //   28	153	10	str	String
    // Exception table:
    //   from	to	target	type
    //   24	30	209	java/lang/Exception
    //   41	55	209	java/lang/Exception
    //   76	81	209	java/lang/Exception
    //   87	121	209	java/lang/Exception
    //   24	30	268	finally
    //   41	55	268	finally
    //   76	81	268	finally
    //   87	121	268	finally
    //   225	240	268	finally
    //   245	252	268	finally
    //   127	134	285	finally
    //   140	158	285	finally
    //   164	192	285	finally
    //   127	134	292	java/lang/Exception
    //   140	158	292	java/lang/Exception
    //   164	192	292	java/lang/Exception
  }
  
  /* Error */
  private void writeFatal(Date paramDate, Thread paramThread, Throwable paramThrowable)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 8
    //   6: aconst_null
    //   7: astore 11
    //   9: aconst_null
    //   10: astore 10
    //   12: aconst_null
    //   13: astore 9
    //   15: aconst_null
    //   16: astore 7
    //   18: aload 11
    //   20: astore 4
    //   22: aload 6
    //   24: astore 5
    //   26: aload_0
    //   27: invokespecial 220	com/crashlytics/android/core/CrashlyticsUncaughtExceptionHandler:getCurrentSessionId	()Ljava/lang/String;
    //   30: astore 12
    //   32: aload 12
    //   34: ifnonnull +40 -> 74
    //   37: aload 11
    //   39: astore 4
    //   41: aload 6
    //   43: astore 5
    //   45: invokestatic 249	io/fabric/sdk/android/Fabric:getLogger	()Lio/fabric/sdk/android/Logger;
    //   48: ldc -5
    //   50: ldc_w 691
    //   53: aconst_null
    //   54: invokeinterface 292 4 0
    //   59: aconst_null
    //   60: ldc_w 661
    //   63: invokestatic 435	io/fabric/sdk/android/services/common/CommonUtils:flushOrLog	(Ljava/io/Flushable;Ljava/lang/String;)V
    //   66: aconst_null
    //   67: ldc_w 669
    //   70: invokestatic 441	io/fabric/sdk/android/services/common/CommonUtils:closeOrLog	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   73: return
    //   74: aload 11
    //   76: astore 4
    //   78: aload 6
    //   80: astore 5
    //   82: aload 12
    //   84: invokestatic 672	com/crashlytics/android/core/CrashlyticsCore:recordFatalExceptionEvent	(Ljava/lang/String;)V
    //   87: aload 11
    //   89: astore 4
    //   91: aload 6
    //   93: astore 5
    //   95: new 283	com/crashlytics/android/core/ClsFileOutputStream
    //   98: dup
    //   99: aload_0
    //   100: invokespecial 226	com/crashlytics/android/core/CrashlyticsUncaughtExceptionHandler:getFilesDir	()Ljava/io/File;
    //   103: new 265	java/lang/StringBuilder
    //   106: dup
    //   107: invokespecial 266	java/lang/StringBuilder:<init>	()V
    //   110: aload 12
    //   112: invokevirtual 272	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: ldc_w 674
    //   118: invokevirtual 272	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: invokevirtual 275	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   124: invokespecial 419	com/crashlytics/android/core/ClsFileOutputStream:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   127: astore 6
    //   129: aload 10
    //   131: astore 4
    //   133: aload 9
    //   135: astore 5
    //   137: aload 6
    //   139: invokestatic 423	com/crashlytics/android/core/CodedOutputStream:newInstance	(Ljava/io/OutputStream;)Lcom/crashlytics/android/core/CodedOutputStream;
    //   142: astore 7
    //   144: aload 7
    //   146: astore 4
    //   148: aload 7
    //   150: astore 5
    //   152: aload_0
    //   153: aload 7
    //   155: aload_1
    //   156: aload_2
    //   157: aload_3
    //   158: ldc_w 693
    //   161: iconst_1
    //   162: invokespecial 429	com/crashlytics/android/core/CrashlyticsUncaughtExceptionHandler:writeSessionEvent	(Lcom/crashlytics/android/core/CodedOutputStream;Ljava/util/Date;Ljava/lang/Thread;Ljava/lang/Throwable;Ljava/lang/String;Z)V
    //   165: aload 7
    //   167: ldc_w 661
    //   170: invokestatic 435	io/fabric/sdk/android/services/common/CommonUtils:flushOrLog	(Ljava/io/Flushable;Ljava/lang/String;)V
    //   173: aload 6
    //   175: ldc_w 669
    //   178: invokestatic 441	io/fabric/sdk/android/services/common/CommonUtils:closeOrLog	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   181: return
    //   182: astore_3
    //   183: aload 8
    //   185: astore_2
    //   186: aload 7
    //   188: astore_1
    //   189: aload_1
    //   190: astore 4
    //   192: aload_2
    //   193: astore 5
    //   195: invokestatic 249	io/fabric/sdk/android/Fabric:getLogger	()Lio/fabric/sdk/android/Logger;
    //   198: ldc -5
    //   200: ldc_w 695
    //   203: aload_3
    //   204: invokeinterface 292 4 0
    //   209: aload_1
    //   210: astore 4
    //   212: aload_2
    //   213: astore 5
    //   215: aload_3
    //   216: aload_2
    //   217: invokestatic 455	com/crashlytics/android/core/ExceptionUtils:writeStackTraceIfNotNull	(Ljava/lang/Throwable;Ljava/io/OutputStream;)V
    //   220: aload_1
    //   221: ldc_w 661
    //   224: invokestatic 435	io/fabric/sdk/android/services/common/CommonUtils:flushOrLog	(Ljava/io/Flushable;Ljava/lang/String;)V
    //   227: aload_2
    //   228: ldc_w 669
    //   231: invokestatic 441	io/fabric/sdk/android/services/common/CommonUtils:closeOrLog	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   234: return
    //   235: astore_1
    //   236: aload 4
    //   238: ldc_w 661
    //   241: invokestatic 435	io/fabric/sdk/android/services/common/CommonUtils:flushOrLog	(Ljava/io/Flushable;Ljava/lang/String;)V
    //   244: aload 5
    //   246: ldc_w 669
    //   249: invokestatic 441	io/fabric/sdk/android/services/common/CommonUtils:closeOrLog	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   252: aload_1
    //   253: athrow
    //   254: astore_1
    //   255: aload 6
    //   257: astore 5
    //   259: goto -23 -> 236
    //   262: astore_3
    //   263: aload 6
    //   265: astore_2
    //   266: aload 5
    //   268: astore_1
    //   269: goto -80 -> 189
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	272	0	this	CrashlyticsUncaughtExceptionHandler
    //   0	272	1	paramDate	Date
    //   0	272	2	paramThread	Thread
    //   0	272	3	paramThrowable	Throwable
    //   20	217	4	localObject1	Object
    //   24	243	5	localObject2	Object
    //   1	263	6	localClsFileOutputStream	ClsFileOutputStream
    //   16	171	7	localCodedOutputStream	CodedOutputStream
    //   4	180	8	localObject3	Object
    //   13	121	9	localObject4	Object
    //   10	120	10	localObject5	Object
    //   7	81	11	localObject6	Object
    //   30	81	12	str	String
    // Exception table:
    //   from	to	target	type
    //   26	32	182	java/lang/Exception
    //   45	59	182	java/lang/Exception
    //   82	87	182	java/lang/Exception
    //   95	129	182	java/lang/Exception
    //   26	32	235	finally
    //   45	59	235	finally
    //   82	87	235	finally
    //   95	129	235	finally
    //   195	209	235	finally
    //   215	220	235	finally
    //   137	144	254	finally
    //   152	165	254	finally
    //   137	144	262	java/lang/Exception
    //   152	165	262	java/lang/Exception
  }
  
  private void writeInitialPartsTo(CodedOutputStream paramCodedOutputStream, String paramString)
    throws IOException
  {
    String[] arrayOfString = INITIAL_SESSION_PART_TAGS;
    int j = arrayOfString.length;
    int i = 0;
    if (i < j)
    {
      String str = arrayOfString[i];
      File[] arrayOfFile = listFilesMatching(new FileNameContainsFilter(paramString + str));
      if (arrayOfFile.length == 0) {
        Fabric.getLogger().e("CrashlyticsCore", "Can't find " + str + " data for session ID " + paramString, null);
      }
      for (;;)
      {
        i += 1;
        break;
        Fabric.getLogger().d("CrashlyticsCore", "Collecting " + str + " data for session ID " + paramString);
        writeToCosFromFile(paramCodedOutputStream, arrayOfFile[0]);
      }
    }
  }
  
  private static void writeNonFatalEventsTo(CodedOutputStream paramCodedOutputStream, File[] paramArrayOfFile, String paramString)
  {
    Arrays.sort(paramArrayOfFile, CommonUtils.FILE_MODIFIED_COMPARATOR);
    int j = paramArrayOfFile.length;
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        File localFile = paramArrayOfFile[i];
        try
        {
          Fabric.getLogger().d("CrashlyticsCore", String.format(Locale.US, "Found Non Fatal for session ID %s in %s ", new Object[] { paramString, localFile.getName() }));
          writeToCosFromFile(paramCodedOutputStream, localFile);
          i += 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Fabric.getLogger().e("CrashlyticsCore", "Error writting non-fatal to session.", localException);
          }
        }
      }
    }
  }
  
  /* Error */
  private void writeSessionApp(String paramString)
    throws Exception
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 5
    //   5: aconst_null
    //   6: astore_2
    //   7: aconst_null
    //   8: astore 8
    //   10: aconst_null
    //   11: astore 7
    //   13: aconst_null
    //   14: astore 6
    //   16: new 283	com/crashlytics/android/core/ClsFileOutputStream
    //   19: dup
    //   20: aload_0
    //   21: invokespecial 226	com/crashlytics/android/core/CrashlyticsUncaughtExceptionHandler:getFilesDir	()Ljava/io/File;
    //   24: new 265	java/lang/StringBuilder
    //   27: dup
    //   28: invokespecial 266	java/lang/StringBuilder:<init>	()V
    //   31: aload_1
    //   32: invokevirtual 272	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: ldc 122
    //   37: invokevirtual 272	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: invokevirtual 275	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   43: invokespecial 419	com/crashlytics/android/core/ClsFileOutputStream:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   46: astore 4
    //   48: aload 8
    //   50: astore_1
    //   51: aload 7
    //   53: astore_2
    //   54: aload 4
    //   56: invokestatic 423	com/crashlytics/android/core/CodedOutputStream:newInstance	(Ljava/io/OutputStream;)Lcom/crashlytics/android/core/CodedOutputStream;
    //   59: astore_3
    //   60: aload_3
    //   61: astore_1
    //   62: aload_3
    //   63: astore_2
    //   64: aload_3
    //   65: aload_0
    //   66: getfield 144	com/crashlytics/android/core/CrashlyticsUncaughtExceptionHandler:idManager	Lio/fabric/sdk/android/services/common/IdManager;
    //   69: invokevirtual 713	io/fabric/sdk/android/services/common/IdManager:getAppIdentifier	()Ljava/lang/String;
    //   72: aload_0
    //   73: getfield 146	com/crashlytics/android/core/CrashlyticsUncaughtExceptionHandler:crashlyticsCore	Lcom/crashlytics/android/core/CrashlyticsCore;
    //   76: invokevirtual 716	com/crashlytics/android/core/CrashlyticsCore:getApiKey	()Ljava/lang/String;
    //   79: aload_0
    //   80: getfield 146	com/crashlytics/android/core/CrashlyticsUncaughtExceptionHandler:crashlyticsCore	Lcom/crashlytics/android/core/CrashlyticsCore;
    //   83: invokevirtual 719	com/crashlytics/android/core/CrashlyticsCore:getVersionCode	()Ljava/lang/String;
    //   86: aload_0
    //   87: getfield 146	com/crashlytics/android/core/CrashlyticsUncaughtExceptionHandler:crashlyticsCore	Lcom/crashlytics/android/core/CrashlyticsCore;
    //   90: invokevirtual 722	com/crashlytics/android/core/CrashlyticsCore:getVersionName	()Ljava/lang/String;
    //   93: aload_0
    //   94: getfield 144	com/crashlytics/android/core/CrashlyticsUncaughtExceptionHandler:idManager	Lio/fabric/sdk/android/services/common/IdManager;
    //   97: invokevirtual 725	io/fabric/sdk/android/services/common/IdManager:getAppInstallIdentifier	()Ljava/lang/String;
    //   100: aload_0
    //   101: getfield 146	com/crashlytics/android/core/CrashlyticsUncaughtExceptionHandler:crashlyticsCore	Lcom/crashlytics/android/core/CrashlyticsCore;
    //   104: invokevirtual 728	com/crashlytics/android/core/CrashlyticsCore:getInstallerPackageName	()Ljava/lang/String;
    //   107: invokestatic 734	io/fabric/sdk/android/services/common/DeliveryMechanism:determineFrom	(Ljava/lang/String;)Lio/fabric/sdk/android/services/common/DeliveryMechanism;
    //   110: invokevirtual 737	io/fabric/sdk/android/services/common/DeliveryMechanism:getId	()I
    //   113: aload_0
    //   114: getfield 154	com/crashlytics/android/core/CrashlyticsUncaughtExceptionHandler:unityVersion	Ljava/lang/String;
    //   117: invokestatic 740	com/crashlytics/android/core/SessionProtobufHelper:writeSessionApp	(Lcom/crashlytics/android/core/CodedOutputStream;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V
    //   120: aload_3
    //   121: ldc_w 742
    //   124: invokestatic 435	io/fabric/sdk/android/services/common/CommonUtils:flushOrLog	(Ljava/io/Flushable;Ljava/lang/String;)V
    //   127: aload 4
    //   129: ldc_w 744
    //   132: invokestatic 441	io/fabric/sdk/android/services/common/CommonUtils:closeOrLog	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   135: return
    //   136: astore_1
    //   137: aload 5
    //   139: astore 4
    //   141: aload_1
    //   142: astore 5
    //   144: aload 6
    //   146: astore_1
    //   147: aload_1
    //   148: astore_2
    //   149: aload 4
    //   151: astore_3
    //   152: aload 5
    //   154: aload 4
    //   156: invokestatic 455	com/crashlytics/android/core/ExceptionUtils:writeStackTraceIfNotNull	(Ljava/lang/Throwable;Ljava/io/OutputStream;)V
    //   159: aload_1
    //   160: astore_2
    //   161: aload 4
    //   163: astore_3
    //   164: aload 5
    //   166: athrow
    //   167: astore_1
    //   168: aload_3
    //   169: astore 4
    //   171: aload_1
    //   172: astore_3
    //   173: aload_2
    //   174: astore_1
    //   175: aload_1
    //   176: ldc_w 742
    //   179: invokestatic 435	io/fabric/sdk/android/services/common/CommonUtils:flushOrLog	(Ljava/io/Flushable;Ljava/lang/String;)V
    //   182: aload 4
    //   184: ldc_w 744
    //   187: invokestatic 441	io/fabric/sdk/android/services/common/CommonUtils:closeOrLog	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   190: aload_3
    //   191: athrow
    //   192: astore_3
    //   193: goto -18 -> 175
    //   196: astore 5
    //   198: aload_2
    //   199: astore_1
    //   200: goto -53 -> 147
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	203	0	this	CrashlyticsUncaughtExceptionHandler
    //   0	203	1	paramString	String
    //   6	193	2	localObject1	Object
    //   1	190	3	localObject2	Object
    //   192	1	3	localObject3	Object
    //   46	137	4	localObject4	Object
    //   3	162	5	str	String
    //   196	1	5	localException	Exception
    //   14	131	6	localObject5	Object
    //   11	41	7	localObject6	Object
    //   8	41	8	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   16	48	136	java/lang/Exception
    //   16	48	167	finally
    //   152	159	167	finally
    //   164	167	167	finally
    //   54	60	192	finally
    //   64	120	192	finally
    //   54	60	196	java/lang/Exception
    //   64	120	196	java/lang/Exception
  }
  
  /* Error */
  private void writeSessionDevice(String paramString)
    throws Exception
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 13
    //   3: aconst_null
    //   4: astore 15
    //   6: aconst_null
    //   7: astore 12
    //   9: aconst_null
    //   10: astore 18
    //   12: aconst_null
    //   13: astore 17
    //   15: aconst_null
    //   16: astore 16
    //   18: new 283	com/crashlytics/android/core/ClsFileOutputStream
    //   21: dup
    //   22: aload_0
    //   23: invokespecial 226	com/crashlytics/android/core/CrashlyticsUncaughtExceptionHandler:getFilesDir	()Ljava/io/File;
    //   26: new 265	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 266	java/lang/StringBuilder:<init>	()V
    //   33: aload_1
    //   34: invokevirtual 272	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: ldc 126
    //   39: invokevirtual 272	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: invokevirtual 275	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: invokespecial 419	com/crashlytics/android/core/ClsFileOutputStream:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   48: astore 14
    //   50: aload 18
    //   52: astore_1
    //   53: aload 17
    //   55: astore 12
    //   57: aload 14
    //   59: invokestatic 423	com/crashlytics/android/core/CodedOutputStream:newInstance	(Ljava/io/OutputStream;)Lcom/crashlytics/android/core/CodedOutputStream;
    //   62: astore 13
    //   64: aload 13
    //   66: astore_1
    //   67: aload 13
    //   69: astore 12
    //   71: aload_0
    //   72: getfield 146	com/crashlytics/android/core/CrashlyticsUncaughtExceptionHandler:crashlyticsCore	Lcom/crashlytics/android/core/CrashlyticsCore;
    //   75: invokevirtual 169	com/crashlytics/android/core/CrashlyticsCore:getContext	()Landroid/content/Context;
    //   78: astore 15
    //   80: aload 13
    //   82: astore_1
    //   83: aload 13
    //   85: astore 12
    //   87: new 746	android/os/StatFs
    //   90: dup
    //   91: invokestatic 751	android/os/Environment:getDataDirectory	()Ljava/io/File;
    //   94: invokevirtual 754	java/io/File:getPath	()Ljava/lang/String;
    //   97: invokespecial 755	android/os/StatFs:<init>	(Ljava/lang/String;)V
    //   100: astore 17
    //   102: aload 13
    //   104: astore_1
    //   105: aload 13
    //   107: astore 12
    //   109: aload_0
    //   110: getfield 144	com/crashlytics/android/core/CrashlyticsUncaughtExceptionHandler:idManager	Lio/fabric/sdk/android/services/common/IdManager;
    //   113: invokevirtual 758	io/fabric/sdk/android/services/common/IdManager:getDeviceUUID	()Ljava/lang/String;
    //   116: astore 16
    //   118: aload 13
    //   120: astore_1
    //   121: aload 13
    //   123: astore 12
    //   125: invokestatic 761	io/fabric/sdk/android/services/common/CommonUtils:getCpuArchitectureInt	()I
    //   128: istore_2
    //   129: aload 13
    //   131: astore_1
    //   132: aload 13
    //   134: astore 12
    //   136: invokestatic 767	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   139: invokevirtual 770	java/lang/Runtime:availableProcessors	()I
    //   142: istore_3
    //   143: aload 13
    //   145: astore_1
    //   146: aload 13
    //   148: astore 12
    //   150: invokestatic 773	io/fabric/sdk/android/services/common/CommonUtils:getTotalRamInBytes	()J
    //   153: lstore 5
    //   155: aload 13
    //   157: astore_1
    //   158: aload 13
    //   160: astore 12
    //   162: aload 17
    //   164: invokevirtual 776	android/os/StatFs:getBlockCount	()I
    //   167: i2l
    //   168: lstore 7
    //   170: aload 13
    //   172: astore_1
    //   173: aload 13
    //   175: astore 12
    //   177: aload 17
    //   179: invokevirtual 779	android/os/StatFs:getBlockSize	()I
    //   182: i2l
    //   183: lstore 9
    //   185: aload 13
    //   187: astore_1
    //   188: aload 13
    //   190: astore 12
    //   192: aload 15
    //   194: invokestatic 783	io/fabric/sdk/android/services/common/CommonUtils:isEmulator	(Landroid/content/Context;)Z
    //   197: istore 11
    //   199: aload 13
    //   201: astore_1
    //   202: aload 13
    //   204: astore 12
    //   206: aload_0
    //   207: getfield 144	com/crashlytics/android/core/CrashlyticsUncaughtExceptionHandler:idManager	Lio/fabric/sdk/android/services/common/IdManager;
    //   210: invokevirtual 786	io/fabric/sdk/android/services/common/IdManager:getDeviceIdentifiers	()Ljava/util/Map;
    //   213: astore 17
    //   215: aload 13
    //   217: astore_1
    //   218: aload 13
    //   220: astore 12
    //   222: aload 15
    //   224: invokestatic 790	io/fabric/sdk/android/services/common/CommonUtils:getDeviceState	(Landroid/content/Context;)I
    //   227: istore 4
    //   229: aload 13
    //   231: astore_1
    //   232: aload 13
    //   234: astore 12
    //   236: aload 13
    //   238: aload 16
    //   240: iload_2
    //   241: getstatic 795	android/os/Build:MODEL	Ljava/lang/String;
    //   244: iload_3
    //   245: lload 5
    //   247: lload 7
    //   249: lload 9
    //   251: lmul
    //   252: iload 11
    //   254: aload 17
    //   256: iload 4
    //   258: getstatic 798	android/os/Build:MANUFACTURER	Ljava/lang/String;
    //   261: getstatic 801	android/os/Build:PRODUCT	Ljava/lang/String;
    //   264: invokestatic 804	com/crashlytics/android/core/SessionProtobufHelper:writeSessionDevice	(Lcom/crashlytics/android/core/CodedOutputStream;Ljava/lang/String;ILjava/lang/String;IJJZLjava/util/Map;ILjava/lang/String;Ljava/lang/String;)V
    //   267: aload 13
    //   269: ldc_w 806
    //   272: invokestatic 435	io/fabric/sdk/android/services/common/CommonUtils:flushOrLog	(Ljava/io/Flushable;Ljava/lang/String;)V
    //   275: aload 14
    //   277: ldc_w 808
    //   280: invokestatic 441	io/fabric/sdk/android/services/common/CommonUtils:closeOrLog	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   283: return
    //   284: astore_1
    //   285: aload 15
    //   287: astore 14
    //   289: aload_1
    //   290: astore 15
    //   292: aload 16
    //   294: astore_1
    //   295: aload_1
    //   296: astore 12
    //   298: aload 14
    //   300: astore 13
    //   302: aload 15
    //   304: aload 14
    //   306: invokestatic 455	com/crashlytics/android/core/ExceptionUtils:writeStackTraceIfNotNull	(Ljava/lang/Throwable;Ljava/io/OutputStream;)V
    //   309: aload_1
    //   310: astore 12
    //   312: aload 14
    //   314: astore 13
    //   316: aload 15
    //   318: athrow
    //   319: astore_1
    //   320: aload 13
    //   322: astore 14
    //   324: aload_1
    //   325: astore 13
    //   327: aload 12
    //   329: astore_1
    //   330: aload_1
    //   331: ldc_w 806
    //   334: invokestatic 435	io/fabric/sdk/android/services/common/CommonUtils:flushOrLog	(Ljava/io/Flushable;Ljava/lang/String;)V
    //   337: aload 14
    //   339: ldc_w 808
    //   342: invokestatic 441	io/fabric/sdk/android/services/common/CommonUtils:closeOrLog	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   345: aload 13
    //   347: athrow
    //   348: astore 13
    //   350: goto -20 -> 330
    //   353: astore 15
    //   355: aload 12
    //   357: astore_1
    //   358: goto -63 -> 295
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	361	0	this	CrashlyticsUncaughtExceptionHandler
    //   0	361	1	paramString	String
    //   128	113	2	i	int
    //   142	103	3	j	int
    //   227	30	4	k	int
    //   153	93	5	l1	long
    //   168	80	7	l2	long
    //   183	67	9	l3	long
    //   197	56	11	bool	boolean
    //   7	349	12	localObject1	Object
    //   1	345	13	localObject2	Object
    //   348	1	13	localObject3	Object
    //   48	290	14	localObject4	Object
    //   4	313	15	localObject5	Object
    //   353	1	15	localException	Exception
    //   16	277	16	str	String
    //   13	242	17	localObject6	Object
    //   10	41	18	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   18	50	284	java/lang/Exception
    //   18	50	319	finally
    //   302	309	319	finally
    //   316	319	319	finally
    //   57	64	348	finally
    //   71	80	348	finally
    //   87	102	348	finally
    //   109	118	348	finally
    //   125	129	348	finally
    //   136	143	348	finally
    //   150	155	348	finally
    //   162	170	348	finally
    //   177	185	348	finally
    //   192	199	348	finally
    //   206	215	348	finally
    //   222	229	348	finally
    //   236	267	348	finally
    //   57	64	353	java/lang/Exception
    //   71	80	353	java/lang/Exception
    //   87	102	353	java/lang/Exception
    //   109	118	353	java/lang/Exception
    //   125	129	353	java/lang/Exception
    //   136	143	353	java/lang/Exception
    //   150	155	353	java/lang/Exception
    //   162	170	353	java/lang/Exception
    //   177	185	353	java/lang/Exception
    //   192	199	353	java/lang/Exception
    //   206	215	353	java/lang/Exception
    //   222	229	353	java/lang/Exception
    //   236	267	353	java/lang/Exception
  }
  
  private void writeSessionEvent(CodedOutputStream paramCodedOutputStream, Date paramDate, Thread paramThread, Throwable paramThrowable, String paramString, boolean paramBoolean)
    throws Exception
  {
    Object localObject2 = crashlyticsCore.getContext();
    long l1 = paramDate.getTime() / 1000L;
    float f = CommonUtils.getBatteryLevel((Context)localObject2);
    int j = CommonUtils.getBatteryVelocity((Context)localObject2, devicePowerStateListener.isPowerConnected());
    boolean bool = CommonUtils.getProximitySensorEnabled((Context)localObject2);
    int k = getResourcesgetConfigurationorientation;
    long l2 = CommonUtils.getTotalRamInBytes();
    long l3 = CommonUtils.calculateFreeRamInBytes((Context)localObject2);
    long l4 = CommonUtils.calculateUsedDiskSpaceInBytes(Environment.getDataDirectory().getPath());
    ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = CommonUtils.getAppProcessInfo(((Context)localObject2).getPackageName(), (Context)localObject2);
    LinkedList localLinkedList = new LinkedList();
    StackTraceElement[] arrayOfStackTraceElement = paramThrowable.getStackTrace();
    String str1 = crashlyticsCore.getBuildId();
    String str2 = idManager.getAppIdentifier();
    if (paramBoolean)
    {
      localObject1 = Thread.getAllStackTraces();
      paramDate = new Thread[((Map)localObject1).size()];
      int i = 0;
      Iterator localIterator = ((Map)localObject1).entrySet().iterator();
      for (;;)
      {
        localObject1 = paramDate;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject1 = (Map.Entry)localIterator.next();
        paramDate[i] = ((Thread)((Map.Entry)localObject1).getKey());
        localLinkedList.add(((Map.Entry)localObject1).getValue());
        i += 1;
      }
    }
    Object localObject1 = new Thread[0];
    if (!CommonUtils.getBooleanResourceValue((Context)localObject2, "com.crashlytics.CollectCustomKeys", true)) {
      paramDate = new TreeMap();
    }
    for (;;)
    {
      SessionProtobufHelper.writeSessionEvent(paramCodedOutputStream, l1, paramString, paramThrowable, paramThread, arrayOfStackTraceElement, (Thread[])localObject1, localLinkedList, paramDate, logFileManager, localRunningAppProcessInfo, k, str2, str1, f, j, bool, l2 - l3, l4);
      return;
      localObject2 = crashlyticsCore.getAttributes();
      paramDate = (Date)localObject2;
      if (localObject2 != null)
      {
        paramDate = (Date)localObject2;
        if (((Map)localObject2).size() > 1) {
          paramDate = new TreeMap((Map)localObject2);
        }
      }
    }
  }
  
  /* Error */
  private void writeSessionOS(String paramString)
    throws Exception
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 5
    //   5: aconst_null
    //   6: astore_2
    //   7: aconst_null
    //   8: astore 8
    //   10: aconst_null
    //   11: astore 7
    //   13: aconst_null
    //   14: astore 6
    //   16: new 283	com/crashlytics/android/core/ClsFileOutputStream
    //   19: dup
    //   20: aload_0
    //   21: invokespecial 226	com/crashlytics/android/core/CrashlyticsUncaughtExceptionHandler:getFilesDir	()Ljava/io/File;
    //   24: new 265	java/lang/StringBuilder
    //   27: dup
    //   28: invokespecial 266	java/lang/StringBuilder:<init>	()V
    //   31: aload_1
    //   32: invokevirtual 272	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: ldc 124
    //   37: invokevirtual 272	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: invokevirtual 275	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   43: invokespecial 419	com/crashlytics/android/core/ClsFileOutputStream:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   46: astore 4
    //   48: aload 8
    //   50: astore_1
    //   51: aload 7
    //   53: astore_2
    //   54: aload 4
    //   56: invokestatic 423	com/crashlytics/android/core/CodedOutputStream:newInstance	(Ljava/io/OutputStream;)Lcom/crashlytics/android/core/CodedOutputStream;
    //   59: astore_3
    //   60: aload_3
    //   61: astore_1
    //   62: aload_3
    //   63: astore_2
    //   64: aload_3
    //   65: aload_0
    //   66: getfield 146	com/crashlytics/android/core/CrashlyticsUncaughtExceptionHandler:crashlyticsCore	Lcom/crashlytics/android/core/CrashlyticsCore;
    //   69: invokevirtual 169	com/crashlytics/android/core/CrashlyticsCore:getContext	()Landroid/content/Context;
    //   72: invokestatic 923	io/fabric/sdk/android/services/common/CommonUtils:isRooted	(Landroid/content/Context;)Z
    //   75: invokestatic 926	com/crashlytics/android/core/SessionProtobufHelper:writeSessionOS	(Lcom/crashlytics/android/core/CodedOutputStream;Z)V
    //   78: aload_3
    //   79: ldc_w 928
    //   82: invokestatic 435	io/fabric/sdk/android/services/common/CommonUtils:flushOrLog	(Ljava/io/Flushable;Ljava/lang/String;)V
    //   85: aload 4
    //   87: ldc_w 930
    //   90: invokestatic 441	io/fabric/sdk/android/services/common/CommonUtils:closeOrLog	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   93: return
    //   94: astore_1
    //   95: aload 5
    //   97: astore 4
    //   99: aload_1
    //   100: astore 5
    //   102: aload 6
    //   104: astore_1
    //   105: aload_1
    //   106: astore_2
    //   107: aload 4
    //   109: astore_3
    //   110: aload 5
    //   112: aload 4
    //   114: invokestatic 455	com/crashlytics/android/core/ExceptionUtils:writeStackTraceIfNotNull	(Ljava/lang/Throwable;Ljava/io/OutputStream;)V
    //   117: aload_1
    //   118: astore_2
    //   119: aload 4
    //   121: astore_3
    //   122: aload 5
    //   124: athrow
    //   125: astore 4
    //   127: aload_2
    //   128: astore_1
    //   129: aload_1
    //   130: ldc_w 928
    //   133: invokestatic 435	io/fabric/sdk/android/services/common/CommonUtils:flushOrLog	(Ljava/io/Flushable;Ljava/lang/String;)V
    //   136: aload_3
    //   137: ldc_w 930
    //   140: invokestatic 441	io/fabric/sdk/android/services/common/CommonUtils:closeOrLog	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   143: aload 4
    //   145: athrow
    //   146: astore_2
    //   147: aload 4
    //   149: astore_3
    //   150: aload_2
    //   151: astore 4
    //   153: goto -24 -> 129
    //   156: astore 5
    //   158: aload_2
    //   159: astore_1
    //   160: goto -55 -> 105
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	163	0	this	CrashlyticsUncaughtExceptionHandler
    //   0	163	1	paramString	String
    //   6	122	2	localObject1	Object
    //   146	13	2	localObject2	Object
    //   1	149	3	localObject3	Object
    //   46	74	4	localObject4	Object
    //   125	23	4	localObject5	Object
    //   151	1	4	localObject6	Object
    //   3	120	5	str	String
    //   156	1	5	localException	Exception
    //   14	89	6	localObject7	Object
    //   11	41	7	localObject8	Object
    //   8	41	8	localObject9	Object
    // Exception table:
    //   from	to	target	type
    //   16	48	94	java/lang/Exception
    //   16	48	125	finally
    //   110	117	125	finally
    //   122	125	125	finally
    //   54	60	146	finally
    //   64	78	146	finally
    //   54	60	156	java/lang/Exception
    //   64	78	156	java/lang/Exception
  }
  
  private void writeSessionPartsToSessionFile(File paramFile, String paramString, int paramInt)
  {
    Fabric.getLogger().d("CrashlyticsCore", "Collecting session parts for ID " + paramString);
    Object localObject = listFilesMatching(new FileNameContainsFilter(paramString + "SessionCrash"));
    boolean bool1;
    boolean bool2;
    if ((localObject != null) && (localObject.length > 0))
    {
      bool1 = true;
      Fabric.getLogger().d("CrashlyticsCore", String.format(Locale.US, "Session %s has fatal exception: %s", new Object[] { paramString, Boolean.valueOf(bool1) }));
      File[] arrayOfFile = listFilesMatching(new FileNameContainsFilter(paramString + "SessionEvent"));
      if ((arrayOfFile == null) || (arrayOfFile.length <= 0)) {
        break label277;
      }
      bool2 = true;
      label159:
      Fabric.getLogger().d("CrashlyticsCore", String.format(Locale.US, "Session %s has non-fatal exceptions: %s", new Object[] { paramString, Boolean.valueOf(bool2) }));
      if ((!bool1) && (!bool2)) {
        break label289;
      }
      arrayOfFile = getTrimmedNonFatalFiles(paramString, arrayOfFile, paramInt);
      if (!bool1) {
        break label283;
      }
      localObject = localObject[0];
      label225:
      synthesizeSessionFile(paramFile, paramString, arrayOfFile, (File)localObject);
    }
    for (;;)
    {
      Fabric.getLogger().d("CrashlyticsCore", "Removing session part files for ID " + paramString);
      deleteSessionPartFilesFor(paramString);
      return;
      bool1 = false;
      break;
      label277:
      bool2 = false;
      break label159;
      label283:
      localObject = null;
      break label225;
      label289:
      Fabric.getLogger().d("CrashlyticsCore", "No events present for session ID " + paramString);
    }
  }
  
  /* Error */
  private void writeSessionUser(String paramString)
    throws Exception
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 6
    //   6: aconst_null
    //   7: astore_3
    //   8: aconst_null
    //   9: astore 9
    //   11: aconst_null
    //   12: astore 8
    //   14: aconst_null
    //   15: astore 7
    //   17: new 283	com/crashlytics/android/core/ClsFileOutputStream
    //   20: dup
    //   21: aload_0
    //   22: invokespecial 226	com/crashlytics/android/core/CrashlyticsUncaughtExceptionHandler:getFilesDir	()Ljava/io/File;
    //   25: new 265	java/lang/StringBuilder
    //   28: dup
    //   29: invokespecial 266	java/lang/StringBuilder:<init>	()V
    //   32: aload_1
    //   33: invokevirtual 272	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: ldc 120
    //   38: invokevirtual 272	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: invokevirtual 275	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   44: invokespecial 419	com/crashlytics/android/core/ClsFileOutputStream:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   47: astore 5
    //   49: aload 9
    //   51: astore_3
    //   52: aload 8
    //   54: astore 4
    //   56: aload 5
    //   58: invokestatic 423	com/crashlytics/android/core/CodedOutputStream:newInstance	(Ljava/io/OutputStream;)Lcom/crashlytics/android/core/CodedOutputStream;
    //   61: astore 6
    //   63: aload 6
    //   65: astore_3
    //   66: aload 6
    //   68: astore 4
    //   70: aload_0
    //   71: aload_1
    //   72: invokespecial 953	com/crashlytics/android/core/CrashlyticsUncaughtExceptionHandler:getUserMetaData	(Ljava/lang/String;)Lcom/crashlytics/android/core/UserMetaData;
    //   75: astore_1
    //   76: aload 6
    //   78: astore_3
    //   79: aload 6
    //   81: astore 4
    //   83: aload_1
    //   84: invokevirtual 956	com/crashlytics/android/core/UserMetaData:isEmpty	()Z
    //   87: istore_2
    //   88: iload_2
    //   89: ifeq +20 -> 109
    //   92: aload 6
    //   94: ldc_w 958
    //   97: invokestatic 435	io/fabric/sdk/android/services/common/CommonUtils:flushOrLog	(Ljava/io/Flushable;Ljava/lang/String;)V
    //   100: aload 5
    //   102: ldc_w 960
    //   105: invokestatic 441	io/fabric/sdk/android/services/common/CommonUtils:closeOrLog	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   108: return
    //   109: aload 6
    //   111: astore_3
    //   112: aload 6
    //   114: astore 4
    //   116: aload 6
    //   118: aload_1
    //   119: getfield 963	com/crashlytics/android/core/UserMetaData:id	Ljava/lang/String;
    //   122: aload_1
    //   123: getfield 966	com/crashlytics/android/core/UserMetaData:name	Ljava/lang/String;
    //   126: aload_1
    //   127: getfield 969	com/crashlytics/android/core/UserMetaData:email	Ljava/lang/String;
    //   130: invokestatic 972	com/crashlytics/android/core/SessionProtobufHelper:writeSessionUser	(Lcom/crashlytics/android/core/CodedOutputStream;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   133: aload 6
    //   135: ldc_w 958
    //   138: invokestatic 435	io/fabric/sdk/android/services/common/CommonUtils:flushOrLog	(Ljava/io/Flushable;Ljava/lang/String;)V
    //   141: aload 5
    //   143: ldc_w 960
    //   146: invokestatic 441	io/fabric/sdk/android/services/common/CommonUtils:closeOrLog	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   149: return
    //   150: astore_1
    //   151: aload 6
    //   153: astore 5
    //   155: aload_1
    //   156: astore 6
    //   158: aload 7
    //   160: astore_1
    //   161: aload_1
    //   162: astore_3
    //   163: aload 5
    //   165: astore 4
    //   167: aload 6
    //   169: aload 5
    //   171: invokestatic 455	com/crashlytics/android/core/ExceptionUtils:writeStackTraceIfNotNull	(Ljava/lang/Throwable;Ljava/io/OutputStream;)V
    //   174: aload_1
    //   175: astore_3
    //   176: aload 5
    //   178: astore 4
    //   180: aload 6
    //   182: athrow
    //   183: astore_1
    //   184: aload_3
    //   185: ldc_w 958
    //   188: invokestatic 435	io/fabric/sdk/android/services/common/CommonUtils:flushOrLog	(Ljava/io/Flushable;Ljava/lang/String;)V
    //   191: aload 4
    //   193: ldc_w 960
    //   196: invokestatic 441	io/fabric/sdk/android/services/common/CommonUtils:closeOrLog	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   199: aload_1
    //   200: athrow
    //   201: astore_1
    //   202: aload 5
    //   204: astore 4
    //   206: goto -22 -> 184
    //   209: astore 6
    //   211: aload 4
    //   213: astore_1
    //   214: goto -53 -> 161
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	217	0	this	CrashlyticsUncaughtExceptionHandler
    //   0	217	1	paramString	String
    //   87	2	2	bool	boolean
    //   7	178	3	localObject1	Object
    //   1	211	4	localObject2	Object
    //   47	156	5	localObject3	Object
    //   4	177	6	localObject4	Object
    //   209	1	6	localException	Exception
    //   15	144	7	localObject5	Object
    //   12	41	8	localObject6	Object
    //   9	41	9	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   17	49	150	java/lang/Exception
    //   17	49	183	finally
    //   167	174	183	finally
    //   180	183	183	finally
    //   56	63	201	finally
    //   70	76	201	finally
    //   83	88	201	finally
    //   116	133	201	finally
    //   56	63	209	java/lang/Exception
    //   70	76	209	java/lang/Exception
    //   83	88	209	java/lang/Exception
    //   116	133	209	java/lang/Exception
  }
  
  private static void writeToCosFromFile(CodedOutputStream paramCodedOutputStream, File paramFile)
    throws IOException
  {
    if (!paramFile.exists())
    {
      Fabric.getLogger().e("CrashlyticsCore", "Tried to include a file that doesn't exist: " + paramFile.getName(), null);
      return;
    }
    Object localObject = null;
    try
    {
      localFileInputStream = new FileInputStream(paramFile);
      CommonUtils.closeOrLog(paramCodedOutputStream, "Failed to close file input stream.");
    }
    finally
    {
      try
      {
        copyToCodedOutputStream(localFileInputStream, paramCodedOutputStream, (int)paramFile.length());
        CommonUtils.closeOrLog(localFileInputStream, "Failed to close file input stream.");
        return;
      }
      finally
      {
        FileInputStream localFileInputStream;
        paramCodedOutputStream = localFileInputStream;
      }
      paramFile = finally;
      paramCodedOutputStream = (CodedOutputStream)localObject;
    }
    throw paramFile;
  }
  
  void cacheKeyData(final Map<String, String> paramMap)
  {
    executorServiceWrapper.executeAsync(new Callable()
    {
      public Void call()
        throws Exception
      {
        String str = CrashlyticsUncaughtExceptionHandler.this.getCurrentSessionId();
        new MetaDataStore(CrashlyticsUncaughtExceptionHandler.this.getFilesDir()).writeKeyData(str, paramMap);
        return null;
      }
    });
  }
  
  void cacheUserData(final String paramString1, final String paramString2, final String paramString3)
  {
    executorServiceWrapper.executeAsync(new Callable()
    {
      public Void call()
        throws Exception
      {
        String str = CrashlyticsUncaughtExceptionHandler.this.getCurrentSessionId();
        new MetaDataStore(CrashlyticsUncaughtExceptionHandler.this.getFilesDir()).writeUserData(str, new UserMetaData(paramString1, paramString2, paramString3));
        return null;
      }
    });
  }
  
  void cleanInvalidTempFiles()
  {
    executorServiceWrapper.executeAsync(new Runnable()
    {
      public void run()
      {
        doCleanInvalidTempFiles(CrashlyticsUncaughtExceptionHandler.this.listFilesMatching(ClsFileOutputStream.TEMP_FILENAME_FILTER));
      }
    });
  }
  
  void doCleanInvalidTempFiles(File[] paramArrayOfFile)
  {
    deleteLegacyInvalidCacheDir();
    int k = paramArrayOfFile.length;
    int i = 0;
    while (i < k)
    {
      final Object localObject = paramArrayOfFile[i];
      Fabric.getLogger().d("CrashlyticsCore", "Found invalid session part file: " + localObject);
      localObject = getSessionIdFromSessionFile((File)localObject);
      FilenameFilter local13 = new FilenameFilter()
      {
        public boolean accept(File paramAnonymousFile, String paramAnonymousString)
        {
          return paramAnonymousString.startsWith(localObject);
        }
      };
      Fabric.getLogger().d("CrashlyticsCore", "Deleting all part files for invalid session: " + (String)localObject);
      localObject = listFilesMatching(local13);
      int m = localObject.length;
      int j = 0;
      while (j < m)
      {
        local13 = localObject[j];
        Fabric.getLogger().d("CrashlyticsCore", "Deleting session file: " + local13);
        local13.delete();
        j += 1;
      }
      i += 1;
    }
  }
  
  void doCloseSessions()
    throws Exception
  {
    doCloseSessions(false);
  }
  
  boolean finalizeSessions()
  {
    ((Boolean)executorServiceWrapper.executeSyncLoggingException(new Callable()
    {
      public Boolean call()
        throws Exception
      {
        if (isHandlingException.get())
        {
          Fabric.getLogger().d("CrashlyticsCore", "Skipping session finalization because a crash has already occurred.");
          return Boolean.FALSE;
        }
        Fabric.getLogger().d("CrashlyticsCore", "Finalizing previously open sessions.");
        SessionEventData localSessionEventData = crashlyticsCore.getExternalCrashEventData();
        if (localSessionEventData != null) {
          CrashlyticsUncaughtExceptionHandler.this.writeExternalCrashEvent(localSessionEventData);
        }
        CrashlyticsUncaughtExceptionHandler.this.doCloseSessions(true);
        Fabric.getLogger().d("CrashlyticsCore", "Closed all previously open sessions");
        return Boolean.TRUE;
      }
    })).booleanValue();
  }
  
  boolean isHandlingException()
  {
    return isHandlingException.get();
  }
  
  File[] listSessionBeginFiles()
  {
    return listFilesMatching(new FileNameContainsFilter("BeginSession"));
  }
  
  void openSession()
  {
    executorServiceWrapper.executeAsync(new Callable()
    {
      public Void call()
        throws Exception
      {
        CrashlyticsUncaughtExceptionHandler.this.doOpenSession();
        return null;
      }
    });
  }
  
  void trimSessionFiles()
  {
    Utils.capFileCount(getFilesDir(), SESSION_FILE_FILTER, 4, SMALLEST_FILE_NAME_FIRST);
  }
  
  /* Error */
  public void uncaughtException(final Thread paramThread, final Throwable paramThrowable)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 163	com/crashlytics/android/core/CrashlyticsUncaughtExceptionHandler:isHandlingException	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   6: iconst_1
    //   7: invokevirtual 1032	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   10: invokestatic 249	io/fabric/sdk/android/Fabric:getLogger	()Lio/fabric/sdk/android/Logger;
    //   13: ldc -5
    //   15: new 265	java/lang/StringBuilder
    //   18: dup
    //   19: invokespecial 266	java/lang/StringBuilder:<init>	()V
    //   22: ldc_w 1034
    //   25: invokevirtual 272	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: aload_2
    //   29: invokevirtual 399	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   32: ldc_w 401
    //   35: invokevirtual 272	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: aload_1
    //   39: invokevirtual 406	java/lang/Thread:getName	()Ljava/lang/String;
    //   42: invokevirtual 272	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: invokevirtual 275	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   48: invokeinterface 259 3 0
    //   53: aload_0
    //   54: getfield 183	com/crashlytics/android/core/CrashlyticsUncaughtExceptionHandler:devicePowerStateListener	Lcom/crashlytics/android/core/DevicePowerStateListener;
    //   57: invokevirtual 1037	com/crashlytics/android/core/DevicePowerStateListener:dispose	()V
    //   60: new 364	java/util/Date
    //   63: dup
    //   64: invokespecial 365	java/util/Date:<init>	()V
    //   67: astore_3
    //   68: aload_0
    //   69: getfield 142	com/crashlytics/android/core/CrashlyticsUncaughtExceptionHandler:executorServiceWrapper	Lcom/crashlytics/android/core/CrashlyticsExecutorServiceWrapper;
    //   72: new 24	com/crashlytics/android/core/CrashlyticsUncaughtExceptionHandler$5
    //   75: dup
    //   76: aload_0
    //   77: aload_3
    //   78: aload_1
    //   79: aload_2
    //   80: invokespecial 1039	com/crashlytics/android/core/CrashlyticsUncaughtExceptionHandler$5:<init>	(Lcom/crashlytics/android/core/CrashlyticsUncaughtExceptionHandler;Ljava/util/Date;Ljava/lang/Thread;Ljava/lang/Throwable;)V
    //   83: invokevirtual 1019	com/crashlytics/android/core/CrashlyticsExecutorServiceWrapper:executeSyncLoggingException	(Ljava/util/concurrent/Callable;)Ljava/lang/Object;
    //   86: pop
    //   87: invokestatic 249	io/fabric/sdk/android/Fabric:getLogger	()Lio/fabric/sdk/android/Logger;
    //   90: ldc -5
    //   92: ldc_w 1041
    //   95: invokeinterface 259 3 0
    //   100: aload_0
    //   101: getfield 140	com/crashlytics/android/core/CrashlyticsUncaughtExceptionHandler:defaultHandler	Ljava/lang/Thread$UncaughtExceptionHandler;
    //   104: aload_1
    //   105: aload_2
    //   106: invokeinterface 1043 3 0
    //   111: aload_0
    //   112: getfield 163	com/crashlytics/android/core/CrashlyticsUncaughtExceptionHandler:isHandlingException	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   115: iconst_0
    //   116: invokevirtual 1032	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   119: aload_0
    //   120: monitorexit
    //   121: return
    //   122: astore_3
    //   123: invokestatic 249	io/fabric/sdk/android/Fabric:getLogger	()Lio/fabric/sdk/android/Logger;
    //   126: ldc -5
    //   128: ldc_w 1045
    //   131: aload_3
    //   132: invokeinterface 292 4 0
    //   137: invokestatic 249	io/fabric/sdk/android/Fabric:getLogger	()Lio/fabric/sdk/android/Logger;
    //   140: ldc -5
    //   142: ldc_w 1041
    //   145: invokeinterface 259 3 0
    //   150: aload_0
    //   151: getfield 140	com/crashlytics/android/core/CrashlyticsUncaughtExceptionHandler:defaultHandler	Ljava/lang/Thread$UncaughtExceptionHandler;
    //   154: aload_1
    //   155: aload_2
    //   156: invokeinterface 1043 3 0
    //   161: aload_0
    //   162: getfield 163	com/crashlytics/android/core/CrashlyticsUncaughtExceptionHandler:isHandlingException	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   165: iconst_0
    //   166: invokevirtual 1032	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   169: goto -50 -> 119
    //   172: astore_1
    //   173: aload_0
    //   174: monitorexit
    //   175: aload_1
    //   176: athrow
    //   177: astore_3
    //   178: invokestatic 249	io/fabric/sdk/android/Fabric:getLogger	()Lio/fabric/sdk/android/Logger;
    //   181: ldc -5
    //   183: ldc_w 1041
    //   186: invokeinterface 259 3 0
    //   191: aload_0
    //   192: getfield 140	com/crashlytics/android/core/CrashlyticsUncaughtExceptionHandler:defaultHandler	Ljava/lang/Thread$UncaughtExceptionHandler;
    //   195: aload_1
    //   196: aload_2
    //   197: invokeinterface 1043 3 0
    //   202: aload_0
    //   203: getfield 163	com/crashlytics/android/core/CrashlyticsUncaughtExceptionHandler:isHandlingException	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   206: iconst_0
    //   207: invokevirtual 1032	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   210: aload_3
    //   211: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	212	0	this	CrashlyticsUncaughtExceptionHandler
    //   0	212	1	paramThread	Thread
    //   0	212	2	paramThrowable	Throwable
    //   67	11	3	localDate	Date
    //   122	10	3	localException	Exception
    //   177	34	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   10	87	122	java/lang/Exception
    //   2	10	172	finally
    //   87	119	172	finally
    //   137	169	172	finally
    //   178	212	172	finally
    //   10	87	177	finally
    //   123	137	177	finally
  }
  
  void writeNonFatalException(final Thread paramThread, final Throwable paramThrowable)
  {
    final Date localDate = new Date();
    executorServiceWrapper.executeAsync(new Runnable()
    {
      public void run()
      {
        if (!isHandlingException.get()) {
          CrashlyticsUncaughtExceptionHandler.this.doWriteNonFatal(localDate, paramThread, paramThrowable);
        }
      }
    });
  }
  
  void writeToLog(final long paramLong, String paramString)
  {
    executorServiceWrapper.executeAsync(new Callable()
    {
      public Void call()
        throws Exception
      {
        if (!isHandlingException.get()) {
          logFileManager.writeToLog(paramLong, val$msg);
        }
        return null;
      }
    });
  }
  
  private static class AnySessionPartFileFilter
    implements FilenameFilter
  {
    public boolean accept(File paramFile, String paramString)
    {
      return (!CrashlyticsUncaughtExceptionHandler.SESSION_FILE_FILTER.accept(paramFile, paramString)) && (CrashlyticsUncaughtExceptionHandler.SESSION_FILE_PATTERN.matcher(paramString).matches());
    }
  }
  
  static class FileNameContainsFilter
    implements FilenameFilter
  {
    private final String string;
    
    public FileNameContainsFilter(String paramString)
    {
      string = paramString;
    }
    
    public boolean accept(File paramFile, String paramString)
    {
      return (paramString.contains(string)) && (!paramString.endsWith(".cls_temp"));
    }
  }
  
  private static final class SendSessionRunnable
    implements Runnable
  {
    private final CrashlyticsCore crashlyticsCore;
    private final File fileToSend;
    
    public SendSessionRunnable(CrashlyticsCore paramCrashlyticsCore, File paramFile)
    {
      crashlyticsCore = paramCrashlyticsCore;
      fileToSend = paramFile;
    }
    
    public void run()
    {
      if (!CommonUtils.canTryConnection(crashlyticsCore.getContext())) {}
      Object localObject;
      do
      {
        return;
        Fabric.getLogger().d("CrashlyticsCore", "Attempting to send crash report at time of crash...");
        localObject = Settings.getInstance().awaitSettingsData();
        localObject = crashlyticsCore.getCreateReportSpiCall((SettingsData)localObject);
      } while (localObject == null);
      new ReportUploader((CreateReportSpiCall)localObject).forceUpload(new SessionReport(fileToSend, CrashlyticsUncaughtExceptionHandler.SEND_AT_CRASHTIME_HEADER));
    }
  }
  
  static class SessionPartFileFilter
    implements FilenameFilter
  {
    private final String sessionId;
    
    public SessionPartFileFilter(String paramString)
    {
      sessionId = paramString;
    }
    
    public boolean accept(File paramFile, String paramString)
    {
      if (paramString.equals(sessionId + ".cls")) {}
      while ((!paramString.contains(sessionId)) || (paramString.endsWith(".cls_temp"))) {
        return false;
      }
      return true;
    }
  }
}

/* Location:
 * Qualified Name:     com.crashlytics.android.core.CrashlyticsUncaughtExceptionHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */