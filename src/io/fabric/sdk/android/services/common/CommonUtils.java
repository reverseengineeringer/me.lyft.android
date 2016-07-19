package io.fabric.sdk.android.services.common;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.hardware.SensorManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Debug;
import android.os.StatFs;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Logger;
import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class CommonUtils
{
  public static final Comparator<File> FILE_MODIFIED_COMPARATOR = new Comparator()
  {
    public int compare(File paramAnonymousFile1, File paramAnonymousFile2)
    {
      return (int)(paramAnonymousFile1.lastModified() - paramAnonymousFile2.lastModified());
    }
  };
  private static final char[] HEX_VALUES;
  private static Boolean clsTrace = null;
  private static long totalRamInBytes;
  
  static
  {
    HEX_VALUES = new char[] { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
    totalRamInBytes = -1L;
  }
  
  public static long calculateFreeRamInBytes(Context paramContext)
  {
    ActivityManager.MemoryInfo localMemoryInfo = new ActivityManager.MemoryInfo();
    ((ActivityManager)paramContext.getSystemService("activity")).getMemoryInfo(localMemoryInfo);
    return availMem;
  }
  
  public static long calculateUsedDiskSpaceInBytes(String paramString)
  {
    paramString = new StatFs(paramString);
    long l = paramString.getBlockSize();
    return l * paramString.getBlockCount() - l * paramString.getAvailableBlocks();
  }
  
  public static boolean canTryConnection(Context paramContext)
  {
    if (checkPermission(paramContext, "android.permission.ACCESS_NETWORK_STATE")) {
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    }
    return (paramContext != null) && (paramContext.isConnectedOrConnecting());
  }
  
  public static boolean checkPermission(Context paramContext, String paramString)
  {
    return paramContext.checkCallingOrSelfPermission(paramString) == 0;
  }
  
  public static void closeOrLog(Closeable paramCloseable, String paramString)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException paramCloseable)
    {
      Fabric.getLogger().e("Fabric", paramString, paramCloseable);
    }
  }
  
  public static void closeQuietly(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (RuntimeException paramCloseable)
    {
      throw paramCloseable;
    }
    catch (Exception paramCloseable) {}
  }
  
  static long convertMemInfoToBytes(String paramString1, String paramString2, int paramInt)
  {
    return Long.parseLong(paramString1.split(paramString2)[0].trim()) * paramInt;
  }
  
  public static void copyStream(InputStream paramInputStream, OutputStream paramOutputStream, byte[] paramArrayOfByte)
    throws IOException
  {
    for (;;)
    {
      int i = paramInputStream.read(paramArrayOfByte);
      if (i == -1) {
        break;
      }
      paramOutputStream.write(paramArrayOfByte, 0, i);
    }
  }
  
  public static String createInstanceIdFrom(String... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length == 0)) {}
    do
    {
      return null;
      Object localObject = new ArrayList();
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        String str = paramVarArgs[i];
        if (str != null) {
          ((List)localObject).add(str.replace("-", "").toLowerCase(Locale.US));
        }
        i += 1;
      }
      Collections.sort((List)localObject);
      paramVarArgs = new StringBuilder();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        paramVarArgs.append((String)((Iterator)localObject).next());
      }
      paramVarArgs = paramVarArgs.toString();
    } while (paramVarArgs.length() <= 0);
    return sha1(paramVarArgs);
  }
  
  /* Error */
  public static String extractFieldFromSystemFile(File paramFile, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore 4
    //   5: aload_0
    //   6: invokevirtual 248	java/io/File:exists	()Z
    //   9: ifeq +81 -> 90
    //   12: aconst_null
    //   13: astore_2
    //   14: aconst_null
    //   15: astore 5
    //   17: new 250	java/io/BufferedReader
    //   20: dup
    //   21: new 252	java/io/FileReader
    //   24: dup
    //   25: aload_0
    //   26: invokespecial 255	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   29: sipush 1024
    //   32: invokespecial 258	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   35: astore_3
    //   36: aload_3
    //   37: invokevirtual 261	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   40: astore 5
    //   42: aload 4
    //   44: astore_2
    //   45: aload 5
    //   47: ifnull +36 -> 83
    //   50: ldc_w 263
    //   53: invokestatic 269	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   56: aload 5
    //   58: iconst_2
    //   59: invokevirtual 272	java/util/regex/Pattern:split	(Ljava/lang/CharSequence;I)[Ljava/lang/String;
    //   62: astore_2
    //   63: aload_2
    //   64: arraylength
    //   65: iconst_1
    //   66: if_icmple -30 -> 36
    //   69: aload_2
    //   70: iconst_0
    //   71: aaload
    //   72: aload_1
    //   73: invokevirtual 275	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   76: ifeq -40 -> 36
    //   79: aload_2
    //   80: iconst_1
    //   81: aaload
    //   82: astore_2
    //   83: aload_3
    //   84: ldc_w 277
    //   87: invokestatic 279	io/fabric/sdk/android/services/common/CommonUtils:closeOrLog	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   90: aload_2
    //   91: areturn
    //   92: astore_3
    //   93: aload 5
    //   95: astore_1
    //   96: aload_1
    //   97: astore_2
    //   98: invokestatic 130	io/fabric/sdk/android/Fabric:getLogger	()Lio/fabric/sdk/android/Logger;
    //   101: ldc -124
    //   103: new 213	java/lang/StringBuilder
    //   106: dup
    //   107: invokespecial 214	java/lang/StringBuilder:<init>	()V
    //   110: ldc_w 281
    //   113: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: aload_0
    //   117: invokevirtual 284	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   120: invokevirtual 234	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   123: aload_3
    //   124: invokeinterface 138 4 0
    //   129: aload_1
    //   130: ldc_w 277
    //   133: invokestatic 279	io/fabric/sdk/android/services/common/CommonUtils:closeOrLog	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   136: aconst_null
    //   137: areturn
    //   138: astore_0
    //   139: aload_2
    //   140: ldc_w 277
    //   143: invokestatic 279	io/fabric/sdk/android/services/common/CommonUtils:closeOrLog	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   146: aload_0
    //   147: athrow
    //   148: astore_0
    //   149: aload_3
    //   150: astore_2
    //   151: goto -12 -> 139
    //   154: astore_2
    //   155: aload_3
    //   156: astore_1
    //   157: aload_2
    //   158: astore_3
    //   159: goto -63 -> 96
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	162	0	paramFile	File
    //   0	162	1	paramString	String
    //   1	150	2	localObject1	Object
    //   154	4	2	localException1	Exception
    //   35	49	3	localBufferedReader	java.io.BufferedReader
    //   92	64	3	localException2	Exception
    //   158	1	3	localException3	Exception
    //   3	40	4	localObject2	Object
    //   15	79	5	str	String
    // Exception table:
    //   from	to	target	type
    //   17	36	92	java/lang/Exception
    //   17	36	138	finally
    //   98	129	138	finally
    //   36	42	148	finally
    //   50	79	148	finally
    //   36	42	154	java/lang/Exception
    //   50	79	154	java/lang/Exception
  }
  
  public static void flushOrLog(Flushable paramFlushable, String paramString)
  {
    if (paramFlushable != null) {}
    try
    {
      paramFlushable.flush();
      return;
    }
    catch (IOException paramFlushable)
    {
      Fabric.getLogger().e("Fabric", paramString, paramFlushable);
    }
  }
  
  public static String getAppIconHashOrNull(Context paramContext)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    try
    {
      paramContext = paramContext.getResources().openRawResource(getAppIconResourceId(paramContext));
      localObject1 = paramContext;
      localObject2 = paramContext;
      String str = sha1(paramContext);
      localObject1 = paramContext;
      localObject2 = paramContext;
      boolean bool = isNullOrEmpty(str);
      localObject1 = str;
      if (bool) {
        localObject1 = null;
      }
      closeOrLog(paramContext, "Failed to close icon input stream.");
      return (String)localObject1;
    }
    catch (Exception paramContext)
    {
      localObject2 = localObject1;
      Fabric.getLogger().e("Fabric", "Could not calculate hash for app icon.", paramContext);
      return null;
    }
    finally
    {
      closeOrLog((Closeable)localObject2, "Failed to close icon input stream.");
    }
  }
  
  public static int getAppIconResourceId(Context paramContext)
  {
    return getApplicationContextgetApplicationInfoicon;
  }
  
  public static ActivityManager.RunningAppProcessInfo getAppProcessInfo(String paramString, Context paramContext)
  {
    Object localObject2 = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
    Object localObject1 = null;
    paramContext = (Context)localObject1;
    if (localObject2 != null)
    {
      localObject2 = ((List)localObject2).iterator();
      do
      {
        paramContext = (Context)localObject1;
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        paramContext = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject2).next();
      } while (!processName.equals(paramString));
    }
    return paramContext;
  }
  
  public static float getBatteryLevel(Context paramContext)
  {
    paramContext = paramContext.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
    int i = paramContext.getIntExtra("level", -1);
    int j = paramContext.getIntExtra("scale", -1);
    return i / j;
  }
  
  public static int getBatteryVelocity(Context paramContext, boolean paramBoolean)
  {
    float f = getBatteryLevel(paramContext);
    if (!paramBoolean) {
      return 1;
    }
    if ((paramBoolean) && (f >= 99.0D)) {
      return 3;
    }
    if ((paramBoolean) && (f < 99.0D)) {
      return 2;
    }
    return 0;
  }
  
  public static boolean getBooleanResourceValue(Context paramContext, String paramString, boolean paramBoolean)
  {
    boolean bool = paramBoolean;
    int i;
    if (paramContext != null)
    {
      Resources localResources = paramContext.getResources();
      bool = paramBoolean;
      if (localResources != null)
      {
        i = getResourcesIdentifier(paramContext, paramString, "bool");
        if (i <= 0) {
          break label45;
        }
        bool = localResources.getBoolean(i);
      }
    }
    label45:
    do
    {
      return bool;
      i = getResourcesIdentifier(paramContext, paramString, "string");
      bool = paramBoolean;
    } while (i <= 0);
    return Boolean.parseBoolean(paramContext.getString(i));
  }
  
  public static int getCpuArchitectureInt()
  {
    return Architecture.getValue().ordinal();
  }
  
  public static int getDeviceState(Context paramContext)
  {
    int j = 0;
    if (isEmulator(paramContext)) {
      j = 0x0 | 0x1;
    }
    int i = j;
    if (isRooted(paramContext)) {
      i = j | 0x2;
    }
    j = i;
    if (isDebuggerAttached()) {
      j = i | 0x4;
    }
    return j;
  }
  
  public static boolean getProximitySensorEnabled(Context paramContext)
  {
    if (isEmulator(paramContext)) {}
    while (((SensorManager)paramContext.getSystemService("sensor")).getDefaultSensor(8) == null) {
      return false;
    }
    return true;
  }
  
  public static String getResourcePackageName(Context paramContext)
  {
    int i = getApplicationContextgetApplicationInfoicon;
    if (i > 0) {
      return paramContext.getResources().getResourcePackageName(i);
    }
    return paramContext.getPackageName();
  }
  
  public static int getResourcesIdentifier(Context paramContext, String paramString1, String paramString2)
  {
    return paramContext.getResources().getIdentifier(paramString1, paramString2, getResourcePackageName(paramContext));
  }
  
  public static SharedPreferences getSharedPrefs(Context paramContext)
  {
    return paramContext.getSharedPreferences("com.crashlytics.prefs", 0);
  }
  
  public static String getStringsFileValue(Context paramContext, String paramString)
  {
    int i = getResourcesIdentifier(paramContext, paramString, "string");
    if (i > 0) {
      return paramContext.getString(i);
    }
    return "";
  }
  
  /* Error */
  public static long getTotalRamInBytes()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 44	io/fabric/sdk/android/services/common/CommonUtils:totalRamInBytes	J
    //   6: ldc2_w 41
    //   9: lcmp
    //   10: ifne +70 -> 80
    //   13: lconst_0
    //   14: lstore_2
    //   15: new 245	java/io/File
    //   18: dup
    //   19: ldc_w 449
    //   22: invokespecial 450	java/io/File:<init>	(Ljava/lang/String;)V
    //   25: ldc_w 452
    //   28: invokestatic 454	io/fabric/sdk/android/services/common/CommonUtils:extractFieldFromSystemFile	(Ljava/io/File;Ljava/lang/String;)Ljava/lang/String;
    //   31: astore 4
    //   33: lload_2
    //   34: lstore_0
    //   35: aload 4
    //   37: invokestatic 460	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   40: ifne +36 -> 76
    //   43: aload 4
    //   45: getstatic 195	java/util/Locale:US	Ljava/util/Locale;
    //   48: invokevirtual 463	java/lang/String:toUpperCase	(Ljava/util/Locale;)Ljava/lang/String;
    //   51: astore 4
    //   53: aload 4
    //   55: ldc_w 465
    //   58: invokevirtual 468	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   61: ifeq +28 -> 89
    //   64: aload 4
    //   66: ldc_w 465
    //   69: sipush 1024
    //   72: invokestatic 470	io/fabric/sdk/android/services/common/CommonUtils:convertMemInfoToBytes	(Ljava/lang/String;Ljava/lang/String;I)J
    //   75: lstore_0
    //   76: lload_0
    //   77: putstatic 44	io/fabric/sdk/android/services/common/CommonUtils:totalRamInBytes	J
    //   80: getstatic 44	io/fabric/sdk/android/services/common/CommonUtils:totalRamInBytes	J
    //   83: lstore_0
    //   84: ldc 2
    //   86: monitorexit
    //   87: lload_0
    //   88: lreturn
    //   89: aload 4
    //   91: ldc_w 472
    //   94: invokevirtual 468	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   97: ifeq +18 -> 115
    //   100: aload 4
    //   102: ldc_w 472
    //   105: ldc_w 473
    //   108: invokestatic 470	io/fabric/sdk/android/services/common/CommonUtils:convertMemInfoToBytes	(Ljava/lang/String;Ljava/lang/String;I)J
    //   111: lstore_0
    //   112: goto -36 -> 76
    //   115: aload 4
    //   117: ldc_w 475
    //   120: invokevirtual 468	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   123: ifeq +18 -> 141
    //   126: aload 4
    //   128: ldc_w 475
    //   131: ldc_w 476
    //   134: invokestatic 470	io/fabric/sdk/android/services/common/CommonUtils:convertMemInfoToBytes	(Ljava/lang/String;Ljava/lang/String;I)J
    //   137: lstore_0
    //   138: goto -62 -> 76
    //   141: invokestatic 130	io/fabric/sdk/android/Fabric:getLogger	()Lio/fabric/sdk/android/Logger;
    //   144: ldc -124
    //   146: new 213	java/lang/StringBuilder
    //   149: dup
    //   150: invokespecial 214	java/lang/StringBuilder:<init>	()V
    //   153: ldc_w 478
    //   156: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: aload 4
    //   161: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: invokevirtual 234	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   167: invokeinterface 482 3 0
    //   172: lload_2
    //   173: lstore_0
    //   174: goto -98 -> 76
    //   177: astore 5
    //   179: invokestatic 130	io/fabric/sdk/android/Fabric:getLogger	()Lio/fabric/sdk/android/Logger;
    //   182: ldc -124
    //   184: new 213	java/lang/StringBuilder
    //   187: dup
    //   188: invokespecial 214	java/lang/StringBuilder:<init>	()V
    //   191: ldc_w 478
    //   194: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: aload 4
    //   199: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: invokevirtual 234	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   205: aload 5
    //   207: invokeinterface 138 4 0
    //   212: lload_2
    //   213: lstore_0
    //   214: goto -138 -> 76
    //   217: astore 4
    //   219: ldc 2
    //   221: monitorexit
    //   222: aload 4
    //   224: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   34	180	0	l1	long
    //   14	199	2	l2	long
    //   31	167	4	str	String
    //   217	6	4	localObject	Object
    //   177	29	5	localNumberFormatException	NumberFormatException
    // Exception table:
    //   from	to	target	type
    //   53	76	177	java/lang/NumberFormatException
    //   89	112	177	java/lang/NumberFormatException
    //   115	138	177	java/lang/NumberFormatException
    //   141	172	177	java/lang/NumberFormatException
    //   3	13	217	finally
    //   15	33	217	finally
    //   35	53	217	finally
    //   53	76	217	finally
    //   76	80	217	finally
    //   80	84	217	finally
    //   89	112	217	finally
    //   115	138	217	finally
    //   141	172	217	finally
    //   179	212	217	finally
  }
  
  private static String hash(InputStream paramInputStream, String paramString)
  {
    try
    {
      paramString = MessageDigest.getInstance("SHA-1");
      byte[] arrayOfByte = new byte['Ѐ'];
      for (;;)
      {
        int i = paramInputStream.read(arrayOfByte);
        if (i == -1) {
          break;
        }
        paramString.update(arrayOfByte, 0, i);
      }
      paramInputStream = hexify(paramString.digest());
    }
    catch (Exception paramInputStream)
    {
      Fabric.getLogger().e("Fabric", "Could not calculate hash for app icon.", paramInputStream);
      return "";
    }
    return paramInputStream;
  }
  
  private static String hash(String paramString1, String paramString2)
  {
    return hash(paramString1.getBytes(), paramString2);
  }
  
  private static String hash(byte[] paramArrayOfByte, String paramString)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance(paramString);
      localMessageDigest.update(paramArrayOfByte);
      return hexify(localMessageDigest.digest());
    }
    catch (NoSuchAlgorithmException paramArrayOfByte)
    {
      Fabric.getLogger().e("Fabric", "Could not create hashing algorithm: " + paramString + ", returning empty string.", paramArrayOfByte);
    }
    return "";
  }
  
  public static String hexify(byte[] paramArrayOfByte)
  {
    char[] arrayOfChar = new char[paramArrayOfByte.length * 2];
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      int j = paramArrayOfByte[i] & 0xFF;
      arrayOfChar[(i * 2)] = HEX_VALUES[(j >>> 4)];
      arrayOfChar[(i * 2 + 1)] = HEX_VALUES[(j & 0xF)];
      i += 1;
    }
    return new String(arrayOfChar);
  }
  
  public static boolean isAppDebuggable(Context paramContext)
  {
    return (getApplicationInfoflags & 0x2) != 0;
  }
  
  public static boolean isClsTrace(Context paramContext)
  {
    if (clsTrace == null) {
      clsTrace = Boolean.valueOf(getBooleanResourceValue(paramContext, "com.crashlytics.Trace", false));
    }
    return clsTrace.booleanValue();
  }
  
  public static boolean isDebuggerAttached()
  {
    return (Debug.isDebuggerConnected()) || (Debug.waitingForDebugger());
  }
  
  public static boolean isEmulator(Context paramContext)
  {
    paramContext = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
    return ("sdk".equals(Build.PRODUCT)) || ("google_sdk".equals(Build.PRODUCT)) || (paramContext == null);
  }
  
  public static boolean isNullOrEmpty(String paramString)
  {
    return (paramString == null) || (paramString.length() == 0);
  }
  
  public static boolean isRooted(Context paramContext)
  {
    boolean bool = isEmulator(paramContext);
    paramContext = Build.TAGS;
    if ((!bool) && (paramContext != null) && (paramContext.contains("test-keys"))) {}
    do
    {
      do
      {
        return true;
      } while (new File("/system/app/Superuser.apk").exists());
      paramContext = new File("/system/xbin/su");
    } while ((!bool) && (paramContext.exists()));
    return false;
  }
  
  public static void logControlled(Context paramContext, int paramInt, String paramString1, String paramString2)
  {
    if (isClsTrace(paramContext)) {
      Fabric.getLogger().log(paramInt, "Fabric", paramString2);
    }
  }
  
  public static void logControlled(Context paramContext, String paramString)
  {
    if (isClsTrace(paramContext)) {
      Fabric.getLogger().d("Fabric", paramString);
    }
  }
  
  public static void logControlledError(Context paramContext, String paramString, Throwable paramThrowable)
  {
    if (isClsTrace(paramContext)) {
      Fabric.getLogger().e("Fabric", paramString);
    }
  }
  
  public static String logPriorityToString(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "?";
    case 7: 
      return "A";
    case 3: 
      return "D";
    case 6: 
      return "E";
    case 4: 
      return "I";
    case 2: 
      return "V";
    }
    return "W";
  }
  
  public static String padWithZerosToMaxIntWidth(int paramInt)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException("value must be zero or greater");
    }
    return String.format(Locale.US, "%1$10s", new Object[] { Integer.valueOf(paramInt) }).replace(' ', '0');
  }
  
  public static String resolveBuildId(Context paramContext)
  {
    String str = null;
    int j = getResourcesIdentifier(paramContext, "io.fabric.android.build_id", "string");
    int i = j;
    if (j == 0) {
      i = getResourcesIdentifier(paramContext, "com.crashlytics.android.build_id", "string");
    }
    if (i != 0)
    {
      str = paramContext.getResources().getString(i);
      Fabric.getLogger().d("Fabric", "Build ID is: " + str);
    }
    return str;
  }
  
  public static String sha1(InputStream paramInputStream)
  {
    return hash(paramInputStream, "SHA-1");
  }
  
  public static String sha1(String paramString)
  {
    return hash(paramString, "SHA-1");
  }
  
  public static String streamToString(InputStream paramInputStream)
    throws IOException
  {
    paramInputStream = new Scanner(paramInputStream).useDelimiter("\\A");
    if (paramInputStream.hasNext()) {
      return paramInputStream.next();
    }
    return "";
  }
  
  static enum Architecture
  {
    private static final Map<String, Architecture> matcher;
    
    static
    {
      ARM_UNKNOWN = new Architecture("ARM_UNKNOWN", 2);
      PPC = new Architecture("PPC", 3);
      PPC64 = new Architecture("PPC64", 4);
      ARMV6 = new Architecture("ARMV6", 5);
      ARMV7 = new Architecture("ARMV7", 6);
      UNKNOWN = new Architecture("UNKNOWN", 7);
      ARMV7S = new Architecture("ARMV7S", 8);
      ARM64 = new Architecture("ARM64", 9);
      $VALUES = new Architecture[] { X86_32, X86_64, ARM_UNKNOWN, PPC, PPC64, ARMV6, ARMV7, UNKNOWN, ARMV7S, ARM64 };
      matcher = new HashMap(4);
      matcher.put("armeabi-v7a", ARMV7);
      matcher.put("armeabi", ARMV6);
      matcher.put("x86", X86_32);
    }
    
    private Architecture() {}
    
    static Architecture getValue()
    {
      Object localObject = Build.CPU_ABI;
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        Fabric.getLogger().d("Fabric", "Architecture#getValue()::Build.CPU_ABI returned null or empty");
        localObject = UNKNOWN;
      }
      Architecture localArchitecture;
      do
      {
        return (Architecture)localObject;
        localObject = ((String)localObject).toLowerCase(Locale.US);
        localArchitecture = (Architecture)matcher.get(localObject);
        localObject = localArchitecture;
      } while (localArchitecture != null);
      return UNKNOWN;
    }
  }
}

/* Location:
 * Qualified Name:     io.fabric.sdk.android.services.common.CommonUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */