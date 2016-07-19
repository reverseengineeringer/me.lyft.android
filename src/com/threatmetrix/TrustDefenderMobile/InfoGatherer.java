package com.threatmetrix.TrustDefenderMobile;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.SystemClock;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.WindowManager;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

class InfoGatherer
{
  private static final String TAG = StringUtils.getLogTag(InfoGatherer.class);
  
  static List<String> checkURLs(Context paramContext, List<String> paramList)
    throws InterruptedException
  {
    ArrayList localArrayList1 = new ArrayList();
    int j = 0;
    if ((paramList == null) || (paramList.isEmpty())) {
      return localArrayList1;
    }
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    Object localObject4 = paramList.iterator();
    while (((Iterator)localObject4).hasNext())
    {
      Object localObject2 = (String)((Iterator)localObject4).next();
      localObject1 = null;
      try
      {
        localObject2 = new URI((String)localObject2);
        localObject1 = localObject2;
      }
      catch (URISyntaxException localURISyntaxException)
      {
        for (;;)
        {
          Log.d(TAG, "malformed check url", localURISyntaxException);
        }
        localArrayList3.add(localObject1);
        localObject3 = new StringBuilder(((URI)localObject1).getScheme());
        ((StringBuilder)localObject3).append("://");
        if (((URI)localObject1).getHost() == null) {
          break label295;
        }
      }
      if (localObject1 != null) {
        if (((URI)localObject1).getScheme() == null)
        {
          Log.d(TAG, "Failed to get url scheme from: " + localObject1);
        }
        else
        {
          if (!((URI)localObject1).getHost().isEmpty()) {
            ((StringBuilder)localObject3).append(((URI)localObject1).getHost());
          }
          for (;;)
          {
            if ((((URI)localObject1).getPath() != null) && (!((URI)localObject1).getPath().isEmpty())) {
              ((StringBuilder)localObject3).append(((URI)localObject1).getPath());
            }
            if ((((URI)localObject1).getQuery() != null) && (!((URI)localObject1).getQuery().isEmpty())) {
              ((StringBuilder)localObject3).append("?").append(((URI)localObject1).getQuery());
            }
            localArrayList2.add(((StringBuilder)localObject3).toString());
            break;
            label295:
            if ((((URI)localObject1).getAuthority() != null) && (!((URI)localObject1).getAuthority().isEmpty())) {
              ((StringBuilder)localObject3).append(((URI)localObject1).getAuthority());
            }
          }
        }
      }
    }
    Object localObject1 = NativeGatherer.getInstance().checkURLs((String[])localArrayList2.toArray(new String[localArrayList2.size()]));
    Object localObject3 = Build.TAGS;
    localObject4 = paramContext.getPackageManager();
    int i = 0;
    Object localObject5;
    String str;
    boolean bool2;
    boolean bool1;
    if (i < localArrayList3.size())
    {
      localObject5 = (URI)localArrayList3.get(i);
      str = (String)localArrayList2.get(i);
      if (Thread.currentThread().isInterrupted()) {
        throw new InterruptedException();
      }
      bool2 = false;
      if (((URI)localObject5).getScheme().equals("file")) {
        bool1 = new File((URI)localObject5).exists();
      }
    }
    for (;;)
    {
      label453:
      int k;
      if (bool1)
      {
        localArrayList1.add(str);
        k = j;
      }
      for (;;)
      {
        label469:
        i += 1;
        j = k;
        break;
        if (((URI)localObject5).getScheme().equals("tags"))
        {
          bool1 = bool2;
          if (localObject3 == null) {
            break label453;
          }
          if (((URI)localObject5).getHost() == null) {}
          for (paramContext = ((URI)localObject5).getAuthority();; paramContext = ((URI)localObject5).getHost())
          {
            bool1 = bool2;
            if (paramContext == null) {
              break;
            }
            bool1 = bool2;
            if (paramContext.isEmpty()) {
              break;
            }
            bool1 = ((String)localObject3).contains(paramContext);
            break;
          }
        }
        if (((URI)localObject5).getScheme().equals("pkg"))
        {
          bool1 = bool2;
          if (localObject4 == null) {
            break label453;
          }
          if (((URI)localObject5).getHost() == null) {}
          for (paramContext = ((URI)localObject5).getAuthority();; paramContext = ((URI)localObject5).getHost())
          {
            bool1 = bool2;
            if (paramContext == null) {
              break;
            }
            try
            {
              ((PackageManager)localObject4).getPackageInfo(paramContext, 1);
              bool1 = true;
            }
            catch (PackageManager.NameNotFoundException paramContext)
            {
              ArrayList localArrayList4;
              bool1 = bool2;
            }
          }
        }
        bool1 = bool2;
        if (!((URI)localObject5).getScheme().equals("prop")) {
          break label453;
        }
        if (((URI)localObject5).getHost() == null) {}
        for (paramContext = ((URI)localObject5).getAuthority();; paramContext = ((URI)localObject5).getHost())
        {
          k = j;
          if (paramContext == null) {
            break label469;
          }
          localObject5 = ((URI)localObject5).getQuery();
          k = j;
          if (localObject5 == null) {
            break label469;
          }
          if (!paramContext.equals("ro.build.version.codename")) {
            break label713;
          }
          bool1 = bool2;
          if (!((String)localObject5).equalsIgnoreCase(Build.VERSION.CODENAME)) {
            break;
          }
          bool1 = true;
          break;
        }
        label713:
        if (paramContext.equals("ro.build.date.utc"))
        {
          bool1 = bool2;
          if (!((String)localObject5).equals(Long.valueOf(Build.TIME))) {
            break label453;
          }
          bool1 = true;
          break label453;
        }
        if (paramContext.equals("ro.build.type"))
        {
          bool1 = bool2;
          if (!((String)localObject5).equalsIgnoreCase(Build.TYPE)) {
            break label453;
          }
          bool1 = true;
          break label453;
        }
        if (paramContext.equals("ro.build.tags"))
        {
          bool1 = bool2;
          if (!((String)localObject5).equalsIgnoreCase(Build.TAGS)) {
            break label453;
          }
          bool1 = true;
          break label453;
        }
        if (paramContext.equals("ro.build.host"))
        {
          bool1 = bool2;
          if (!((String)localObject5).equalsIgnoreCase(Build.HOST)) {
            break label453;
          }
          bool1 = true;
          break label453;
        }
        if (paramContext.equals("ro.build.user"))
        {
          bool1 = bool2;
          if (!((String)localObject5).equalsIgnoreCase(Build.USER)) {
            break label453;
          }
          bool1 = true;
          break label453;
        }
        if (paramContext.equals("ro.build.id"))
        {
          bool1 = bool2;
          if (!((String)localObject5).equalsIgnoreCase(Build.ID)) {
            break label453;
          }
          bool1 = true;
          break label453;
        }
        localArrayList4 = new ArrayList();
        Collections.addAll(localArrayList4, new String[] { paramContext });
        paramContext = getInfoFromFile("/system/build.prop", localArrayList4, "=");
        if ((paramContext != null) && (((String)localObject5).equalsIgnoreCase(paramContext)))
        {
          bool1 = true;
          break label453;
        }
        paramContext = getInfoFromFile("/default.prop", localArrayList4, "=");
        bool1 = bool2;
        if (paramContext == null) {
          break label453;
        }
        bool1 = bool2;
        if (!((String)localObject5).equalsIgnoreCase(paramContext)) {
          break label453;
        }
        bool1 = true;
        break label453;
        k = j + 1;
      }
      Log.d(TAG, "matched " + j + "/" + paramList.size());
      if ((localObject1 != null) && (localObject1.length > 0))
      {
        j = localObject1.length;
        i = 0;
        while (i < j)
        {
          paramContext = localObject1[i];
          localArrayList1.add("a" + paramContext);
          i += 1;
        }
      }
      Collections.sort(localArrayList1);
      if ((localArrayList1.isEmpty()) || (!Log.isLoggable(TAG, 3))) {
        break;
      }
      Log.d(TAG, "found " + StringUtils.ListToSeparatedString(localArrayList1, ";"));
      return localArrayList1;
    }
  }
  
  static String getAppNameVersion(Context paramContext)
  {
    int j = -1;
    localObject1 = null;
    String str = "-";
    Object localObject2 = getApplicationInfopackageName;
    i = j;
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo((String)localObject2, 128);
      i = j;
      j = versionCode;
      i = j;
      paramContext = versionName;
      i = j;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;)
      {
        StringBuilder localStringBuilder;
        Log.e(TAG, "Invalid package name.", paramContext);
        paramContext = (Context)localObject1;
        continue;
        paramContext = Integer.valueOf(i);
      }
    }
    localStringBuilder = new StringBuilder();
    localObject2 = localStringBuilder.append((String)localObject2).append(":");
    localObject1 = paramContext;
    if (paramContext == null) {
      localObject1 = "-";
    }
    localObject1 = ((StringBuilder)localObject2).append((String)localObject1).append(":");
    if (i == -1)
    {
      paramContext = "-";
      ((StringBuilder)localObject1).append(paramContext);
      paramContext = NativeGatherer.getInstance().getBinaryArch();
      localObject1 = localStringBuilder.append(":");
      if (paramContext != null) {
        break label202;
      }
      paramContext = str;
      ((StringBuilder)localObject1).append(paramContext);
      Log.d(TAG, "Application Info " + localStringBuilder.toString());
      return localStringBuilder.toString();
    }
  }
  
  static long getBootTime()
  {
    long l = (System.currentTimeMillis() - SystemClock.elapsedRealtime()) / 1000L;
    Log.d(TAG, " getBootTime: " + l);
    return l;
  }
  
  static String getCPUInfo()
  {
    Object localObject = new ArrayList();
    Collections.addAll((Collection)localObject, new String[] { "Processor", "BogoMips", "Hardware", "Serial" });
    localObject = getInfoFromFile("/proc/cpuinfo", (List)localObject, ":");
    Log.d(TAG, "getCPUInfo returned: " + (String)localObject);
    return (String)localObject;
  }
  
  static String getDeviceFingerprint(Context paramContext1, Context paramContext2)
    throws InterruptedException
  {
    Log.d(TAG, "getDeviceFingerprint()");
    StringBuilder localStringBuilder = new StringBuilder();
    if (Thread.currentThread().isInterrupted()) {
      return "";
    }
    TelephonyManager localTelephonyManager = (TelephonyManager)paramContext2.getSystemService("phone");
    paramContext2 = "Unknown";
    if (localTelephonyManager.getPhoneType() == 1) {
      paramContext2 = localTelephonyManager.getNetworkOperatorName();
    }
    localStringBuilder.append(paramContext2);
    localStringBuilder.append(localTelephonyManager.getSimCountryIso());
    paramContext2 = new StatWrapper(Environment.getDataDirectory().getPath());
    long l = paramContext2.getBlockSize();
    localStringBuilder.append((float)paramContext2.getBlockCount() * (float)l / 1024.0F / 1024.0F / 1024.0F);
    paramContext1 = new DisplayWrapper(((WindowManager)paramContext1.getSystemService("window")).getDefaultDisplay());
    localStringBuilder.append(paramContext1.getWidth()).append("x").append(paramContext1.getHeight());
    Log.d(TAG, "Calling getCPUInfo");
    localStringBuilder.append(getCPUInfo());
    Log.d(TAG, "Calling getMemInfo");
    localStringBuilder.append(getMemInfo());
    localStringBuilder.append(Build.DEVICE).append(" ").append(Build.MODEL).append(" ").append(Build.PRODUCT).append(" ").append(Build.MANUFACTURER).append(" ").append(Build.VERSION.RELEASE);
    Log.d(TAG, "getDeviceFingerprint returned: hash(" + localStringBuilder.toString() + ")");
    return StringUtils.MD5(localStringBuilder.toString());
  }
  
  static String getDeviceState(long paramLong1, long paramLong2)
    throws InterruptedException
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramLong1).append("-").append(Long.toString(paramLong2));
    Log.d(TAG, "getDeviceState: " + StringUtils.MD5(localStringBuilder.toString()));
    return StringUtils.MD5(localStringBuilder.toString());
  }
  
  static String getFontHashAndCount(StringBuilder paramStringBuilder)
    throws InterruptedException
  {
    StringBuilder localStringBuilder = null;
    if (NativeGatherer.getInstance().isAvailable())
    {
      localObject2 = NativeGatherer.getInstance().getFontList("/system/fonts");
      localObject1 = localStringBuilder;
      if (localObject2 != null)
      {
        localObject1 = localStringBuilder;
        if (!((List)localObject2).isEmpty())
        {
          localObject1 = localStringBuilder;
          if (((List)localObject2).size() == 2)
          {
            localObject1 = (String)((List)localObject2).get(0);
            paramStringBuilder.append((String)((List)localObject2).get(1));
          }
        }
      }
      return (String)localObject1;
    }
    Object localObject1 = getFontList();
    localStringBuilder = new StringBuilder();
    Object localObject2 = ((List)localObject1).iterator();
    while (((Iterator)localObject2).hasNext()) {
      localStringBuilder.append((String)((Iterator)localObject2).next());
    }
    paramStringBuilder.append(((List)localObject1).size());
    return StringUtils.MD5(localStringBuilder.toString());
  }
  
  static List<String> getFontList()
  {
    ArrayList localArrayList = new ArrayList();
    String[] arrayOfString = new File("/system/fonts/").list();
    if (arrayOfString == null) {}
    for (;;)
    {
      return localArrayList;
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = arrayOfString[i];
        if ((localObject != null) && (((String)localObject).endsWith(".ttf")))
        {
          localObject = new StringBuilder((String)localObject);
          localArrayList.add(((StringBuilder)localObject).substring(0, ((StringBuilder)localObject).length() - 4));
        }
        i += 1;
      }
    }
  }
  
  static long getFreeSpace()
  {
    StatWrapper localStatWrapper = new StatWrapper(Environment.getDataDirectory().getPath());
    long l3 = localStatWrapper.getAvailableBlocks();
    long l4 = localStatWrapper.getBlockSize();
    long l2 = 0L;
    long l1 = l2;
    if (l3 != 0L)
    {
      l1 = l2;
      if (l4 != 0L) {
        l1 = (l3 * l4 >> 20 << 20) / 10L * 10L;
      }
    }
    Log.d(TAG, "Free space on the phone " + l1);
    return l1;
  }
  
  /* Error */
  static String getInfoFromFile(String paramString1, List<String> paramList, String paramString2)
  {
    // Byte code:
    //   0: new 66	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   7: astore 5
    //   9: aconst_null
    //   10: astore_3
    //   11: aconst_null
    //   12: astore 4
    //   14: aload_0
    //   15: ifnull +211 -> 226
    //   18: aload_1
    //   19: ifnull +207 -> 226
    //   22: new 163	java/io/File
    //   25: dup
    //   26: aload_0
    //   27: invokespecial 471	java/io/File:<init>	(Ljava/lang/String;)V
    //   30: astore 6
    //   32: aload 6
    //   34: invokevirtual 169	java/io/File:exists	()Z
    //   37: ifeq +189 -> 226
    //   40: aload_3
    //   41: astore_0
    //   42: new 500	java/io/BufferedReader
    //   45: dup
    //   46: new 502	java/io/FileReader
    //   49: dup
    //   50: aload 6
    //   52: invokespecial 505	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   55: invokespecial 508	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   58: astore_3
    //   59: aload_3
    //   60: invokevirtual 511	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   63: astore_0
    //   64: aload_0
    //   65: ifnull +269 -> 334
    //   68: ldc_w 353
    //   71: astore 4
    //   73: aload_2
    //   74: ifnull +158 -> 232
    //   77: aload_2
    //   78: invokevirtual 101	java/lang/String:isEmpty	()Z
    //   81: ifne +151 -> 232
    //   84: aload_0
    //   85: aload_2
    //   86: invokestatic 515	com/threatmetrix/TrustDefenderMobile/StringUtils:splitNonRegex	(Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;
    //   89: astore 6
    //   91: aload 6
    //   93: invokeinterface 40 1 0
    //   98: ifne -39 -> 59
    //   101: aload 6
    //   103: iconst_0
    //   104: invokeinterface 146 2 0
    //   109: checkcast 55	java/lang/String
    //   112: invokevirtual 518	java/lang/String:trim	()Ljava/lang/String;
    //   115: astore 7
    //   117: aload 7
    //   119: invokevirtual 519	java/lang/String:length	()I
    //   122: ifeq -63 -> 59
    //   125: aload 4
    //   127: astore_0
    //   128: aload_1
    //   129: aload 7
    //   131: invokeinterface 521 2 0
    //   136: ifeq +32 -> 168
    //   139: aload 4
    //   141: astore_0
    //   142: aload 6
    //   144: invokeinterface 122 1 0
    //   149: iconst_1
    //   150: if_icmple +18 -> 168
    //   153: aload 6
    //   155: iconst_1
    //   156: invokeinterface 146 2 0
    //   161: checkcast 55	java/lang/String
    //   164: invokevirtual 518	java/lang/String:trim	()Ljava/lang/String;
    //   167: astore_0
    //   168: aload_0
    //   169: invokevirtual 101	java/lang/String:isEmpty	()Z
    //   172: ifne -113 -> 59
    //   175: aload 5
    //   177: invokevirtual 483	java/lang/StringBuilder:length	()I
    //   180: ifle +12 -> 192
    //   183: aload 5
    //   185: ldc_w 523
    //   188: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: pop
    //   192: aload 5
    //   194: aload_0
    //   195: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: pop
    //   199: goto -140 -> 59
    //   202: astore_2
    //   203: aload_3
    //   204: astore_1
    //   205: aload_1
    //   206: astore_0
    //   207: getstatic 19	com/threatmetrix/TrustDefenderMobile/InfoGatherer:TAG	Ljava/lang/String;
    //   210: ldc_w 525
    //   213: aload_2
    //   214: invokestatic 90	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   217: pop
    //   218: aload_1
    //   219: ifnull +7 -> 226
    //   222: aload_1
    //   223: invokevirtual 528	java/io/BufferedReader:close	()V
    //   226: aload 5
    //   228: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   231: areturn
    //   232: new 66	java/lang/StringBuilder
    //   235: dup
    //   236: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   239: astore 6
    //   241: aload_1
    //   242: invokeinterface 44 1 0
    //   247: astore 7
    //   249: aload 7
    //   251: invokeinterface 49 1 0
    //   256: ifeq +58 -> 314
    //   259: aload_0
    //   260: aload 7
    //   262: invokeinterface 53 1 0
    //   267: checkcast 55	java/lang/String
    //   270: invokevirtual 176	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   273: ifeq -24 -> 249
    //   276: aload 6
    //   278: invokevirtual 483	java/lang/StringBuilder:length	()I
    //   281: ifle +12 -> 293
    //   284: aload 6
    //   286: ldc_w 523
    //   289: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   292: pop
    //   293: aload 6
    //   295: aload_0
    //   296: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: pop
    //   300: goto -51 -> 249
    //   303: astore_0
    //   304: aload_3
    //   305: ifnull +7 -> 312
    //   308: aload_3
    //   309: invokevirtual 528	java/io/BufferedReader:close	()V
    //   312: aload_0
    //   313: athrow
    //   314: aload 4
    //   316: astore_0
    //   317: aload 6
    //   319: invokevirtual 483	java/lang/StringBuilder:length	()I
    //   322: ifeq -154 -> 168
    //   325: aload 6
    //   327: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   330: astore_0
    //   331: goto -163 -> 168
    //   334: aload_3
    //   335: ifnull +70 -> 405
    //   338: aload_3
    //   339: invokevirtual 528	java/io/BufferedReader:close	()V
    //   342: goto -116 -> 226
    //   345: astore_0
    //   346: getstatic 19	com/threatmetrix/TrustDefenderMobile/InfoGatherer:TAG	Ljava/lang/String;
    //   349: ldc_w 530
    //   352: aload_0
    //   353: invokestatic 90	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   356: pop
    //   357: goto -131 -> 226
    //   360: astore_0
    //   361: getstatic 19	com/threatmetrix/TrustDefenderMobile/InfoGatherer:TAG	Ljava/lang/String;
    //   364: ldc_w 530
    //   367: aload_0
    //   368: invokestatic 90	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   371: pop
    //   372: goto -146 -> 226
    //   375: astore_1
    //   376: getstatic 19	com/threatmetrix/TrustDefenderMobile/InfoGatherer:TAG	Ljava/lang/String;
    //   379: ldc_w 530
    //   382: aload_1
    //   383: invokestatic 90	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   386: pop
    //   387: goto -75 -> 312
    //   390: astore_1
    //   391: aload_0
    //   392: astore_3
    //   393: aload_1
    //   394: astore_0
    //   395: goto -91 -> 304
    //   398: astore_2
    //   399: aload 4
    //   401: astore_1
    //   402: goto -197 -> 205
    //   405: goto -179 -> 226
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	408	0	paramString1	String
    //   0	408	1	paramList	List<String>
    //   0	408	2	paramString2	String
    //   10	383	3	localObject1	Object
    //   12	388	4	str	String
    //   7	220	5	localStringBuilder	StringBuilder
    //   30	296	6	localObject2	Object
    //   115	146	7	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   59	64	202	java/io/IOException
    //   77	125	202	java/io/IOException
    //   128	139	202	java/io/IOException
    //   142	168	202	java/io/IOException
    //   168	192	202	java/io/IOException
    //   192	199	202	java/io/IOException
    //   232	249	202	java/io/IOException
    //   249	293	202	java/io/IOException
    //   293	300	202	java/io/IOException
    //   317	331	202	java/io/IOException
    //   59	64	303	finally
    //   77	125	303	finally
    //   128	139	303	finally
    //   142	168	303	finally
    //   168	192	303	finally
    //   192	199	303	finally
    //   232	249	303	finally
    //   249	293	303	finally
    //   293	300	303	finally
    //   317	331	303	finally
    //   338	342	345	java/io/IOException
    //   222	226	360	java/io/IOException
    //   308	312	375	java/io/IOException
    //   42	59	390	finally
    //   207	218	390	finally
    //   42	59	398	java/io/IOException
  }
  
  static String getLanguage()
  {
    Object localObject = Locale.getDefault();
    StringBuffer localStringBuffer = new StringBuffer();
    String str = ((Locale)localObject).getLanguage();
    if (str != null)
    {
      localStringBuffer.append(str);
      localObject = ((Locale)localObject).getCountry();
      if (localObject != null)
      {
        localStringBuffer.append("-");
        localStringBuffer.append((String)localObject);
      }
    }
    return localStringBuffer.toString();
  }
  
  static String getLocale()
  {
    Object localObject = Locale.getDefault();
    StringBuffer localStringBuffer = new StringBuffer();
    String str = ((Locale)localObject).getLanguage();
    if (str != null)
    {
      localStringBuffer.append(str);
      localObject = ((Locale)localObject).getCountry();
      if (localObject != null)
      {
        localStringBuffer.append("_");
        localStringBuffer.append((String)localObject);
      }
    }
    return localStringBuffer.toString();
  }
  
  static String getMemInfo()
  {
    Object localObject = new ArrayList();
    Collections.addAll((Collection)localObject, new String[] { "MemTotal" });
    localObject = getInfoFromFile("/proc/meminfo", (List)localObject, ":");
    Log.d(TAG, "getMemInfo returned: " + (String)localObject);
    return (String)localObject;
  }
  
  static String[] getNetworkInfo(Context paramContext)
    throws InterruptedException
  {
    String str;
    if (paramContext.getPackageManager().checkPermission("android.permission.ACCESS_WIFI_STATE", paramContext.getPackageName()) == 0)
    {
      paramContext = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo();
      str = paramContext.getBSSID();
      if (str != null) {
        break label42;
      }
    }
    label42:
    do
    {
      return null;
      localObject = paramContext.getSSID();
    } while ((localObject == null) || (((String)localObject).contains("unknown ssid")));
    paramContext = (Context)localObject;
    if (((String)localObject).charAt(0) == '"') {
      paramContext = ((String)localObject).substring(1);
    }
    Object localObject = paramContext;
    if (paramContext.charAt(paramContext.length() - 1) == '"') {
      localObject = paramContext.substring(0, paramContext.length() - 1);
    }
    return new String[] { str, StringUtils.SHA1((String)localObject) };
  }
  
  static boolean getTimeZoneInfo(TZInfo paramTZInfo)
  {
    if (paramTZInfo == null) {
      throw new IllegalArgumentException("tzInfo cannot be null");
    }
    TimeZone localTimeZone = TimeZone.getDefault();
    if (localTimeZone != null)
    {
      gmtOffset = (localTimeZone.getRawOffset() / 60000);
      dstDiff = (localTimeZone.getDSTSavings() / 60000);
      Log.d(TAG, "getTimeZoneInfo: dstDiff=" + dstDiff + " gmfOffset=" + gmtOffset);
      return true;
    }
    Log.w(TAG, "getTimeZoneInfo: FAILED");
    return false;
  }
  
  static String getURLs(List<URI> paramList)
    throws InterruptedException
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if ((paramList == null) || (paramList.isEmpty())) {
      return null;
    }
    Iterator localIterator = paramList.iterator();
    for (;;)
    {
      URI localURI;
      Object localObject2;
      Map localMap;
      if (localIterator.hasNext())
      {
        localURI = (URI)localIterator.next();
        if (Thread.currentThread().isInterrupted()) {
          throw new InterruptedException();
        }
        if (localURI == null) {
          continue;
        }
        if (!localURI.getScheme().equals("file")) {
          break label411;
        }
        localObject2 = new File(localURI.getPath());
        paramList = localURI.getQuery();
        if ((paramList == null) || (paramList.isEmpty()))
        {
          if (localStringBuilder.length() > 0) {
            localStringBuilder.append(";");
          }
          localObject1 = localStringBuilder.append(localURI.getPath()).append("=");
          if (((File)localObject2).exists()) {}
          for (paramList = "true";; paramList = "false")
          {
            ((StringBuilder)localObject1).append(paramList);
            break;
          }
        }
        if (!((File)localObject2).exists()) {
          continue;
        }
        localMap = StringUtils.splitQuery(paramList);
        boolean bool = localMap.containsKey("grep");
        if ((!bool) && (!localMap.containsKey("keys"))) {
          continue;
        }
        localObject1 = (String)localMap.get("sep");
        paramList = (List<URI>)localObject1;
        if (!bool) {
          if (localObject1 != null)
          {
            paramList = (List<URI>)localObject1;
            if (!((String)localObject1).isEmpty()) {}
          }
          else
          {
            paramList = ":";
          }
        }
        if (!bool) {
          break label327;
        }
      }
      label327:
      for (Object localObject1 = (String)localMap.get("grep"); (localObject1 == null) || (((String)localObject1).isEmpty()); localObject1 = (String)localMap.get("keys"))
      {
        if (localStringBuilder.length() > 0) {
          Log.d(TAG, "found " + localStringBuilder.toString());
        }
        return localStringBuilder.toString();
      }
      localObject1 = StringUtils.splitNonRegex((String)localObject1, ",");
      paramList = getInfoFromFile(((File)localObject2).getAbsolutePath(), (List)localObject1, paramList);
      if ((paramList != null) && (!paramList.isEmpty()))
      {
        if (localStringBuilder.length() > 0) {
          localStringBuilder.append(";");
        }
        localStringBuilder.append(localURI.getPath()).append("=").append(paramList);
        continue;
        label411:
        if (localURI.getScheme().equals("intro")) {
          try
          {
            localObject2 = localURI.getHost();
            localObject1 = localURI.getPath();
            if ((localObject2 == null) || (((String)localObject2).isEmpty()))
            {
              Log.d(TAG, "getURLs: empty className");
            }
            else if ((localObject1 == null) || (((String)localObject1).isEmpty()))
            {
              Log.d(TAG, "getURLs: empty methodName");
            }
            else
            {
              paramList = (List<URI>)localObject1;
              if (((String)localObject1).startsWith("/")) {
                paramList = ((String)localObject1).substring(1);
              }
              localObject1 = WrapperHelper.getClass((String)localObject2);
              if (localObject1 == null)
              {
                Log.d(TAG, "getURLs: failed to find class: " + (String)localObject2);
              }
              else
              {
                localObject2 = WrapperHelper.getMethod((Class)localObject1, paramList, new Class[0]);
                if (localObject2 != null)
                {
                  paramList = WrapperHelper.invoke(localObject1, (Method)localObject2, new Object[0]);
                  if (paramList != null)
                  {
                    paramList = paramList.toString();
                    if (paramList != null)
                    {
                      if (localStringBuilder.length() > 0) {
                        localStringBuilder.append(";");
                      }
                      localStringBuilder.append(localURI.getHost()).append(localURI.getPath()).append("=").append(paramList);
                    }
                  }
                }
                else
                {
                  localObject2 = WrapperHelper.getField((Class)localObject1, paramList);
                  if (localObject2 != null)
                  {
                    paramList = WrapperHelper.getValue(localObject1, (Field)localObject2);
                    if ((paramList != null) && ((paramList instanceof String)))
                    {
                      if (localStringBuilder.length() > 0) {
                        localStringBuilder.append(";");
                      }
                      localStringBuilder.append(localURI.getHost()).append(localURI.getPath()).append("=").append((String)paramList);
                    }
                  }
                  else
                  {
                    Log.d(TAG, "getURLs: failed to find method or field: " + paramList);
                  }
                }
              }
            }
          }
          catch (Exception paramList) {}
        }
      }
    }
  }
  
  static boolean isMockLocation(Context paramContext)
  {
    paramContext = Settings.Secure.getString(paramContext.getContentResolver(), "mock_location");
    return (paramContext != null) && (paramContext.equals("1"));
  }
  
  static class TZInfo
  {
    int dstDiff = 0;
    int gmtOffset = 0;
  }
}

/* Location:
 * Qualified Name:     com.threatmetrix.TrustDefenderMobile.InfoGatherer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */