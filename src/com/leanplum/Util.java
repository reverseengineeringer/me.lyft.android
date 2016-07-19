package com.leanplum;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.util.Log;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;
import org.json.JSONTokener;

final class Util
{
  private static final Executor a = ;
  private static boolean b = false;
  private static boolean c = false;
  
  private static Util.DeviceIdInfo a(Context paramContext)
  {
    try
    {
      paramContext = Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient").getMethod("getAdvertisingIdInfo", new Class[] { Context.class }).invoke(null, new Object[] { paramContext });
      paramContext = new Util.DeviceIdInfo((String)paramContext.getClass().getMethod("getId", new Class[0]).invoke(paramContext, new Object[0]), ((Boolean)paramContext.getClass().getMethod("isLimitAdTrackingEnabled", new Class[0]).invoke(paramContext, new Object[0])).booleanValue());
      return paramContext;
    }
    catch (Exception paramContext)
    {
      if (paramContext.getClass().getName().equals("GooglePlayServicesNotAvailableException"))
      {
        Log.e("Leanplum", "Error getting advertising ID. Google Play services are not available.");
        return null;
      }
      throw paramContext;
    }
  }
  
  public static Util.DeviceIdInfo a(LeanplumDeviceIdMode paramLeanplumDeviceIdMode)
  {
    Context localContext = Leanplum.a();
    if (paramLeanplumDeviceIdMode.equals(LeanplumDeviceIdMode.ADVERTISING_ID)) {
      try
      {
        Util.DeviceIdInfo localDeviceIdInfo = a(localContext);
        if (localDeviceIdInfo != null) {
          return localDeviceIdInfo;
        }
      }
      catch (Exception localException)
      {
        Log.e("Leanplum", "Error getting advertising ID", localException);
      }
    }
    if ((e()) || (paramLeanplumDeviceIdMode.equals(LeanplumDeviceIdMode.ANDROID_ID))) {
      return new Util.DeviceIdInfo(Settings.Secure.getString(localContext.getContentResolver(), "android_id"));
    }
    if (localContext.checkCallingOrSelfPermission("android.permission.ACCESS_WIFI_STATE") == 0) {}
    for (;;)
    {
      try
      {
        paramLeanplumDeviceIdMode = ((WifiManager)localContext.getSystemService("wifi")).getConnectionInfo();
        if (paramLeanplumDeviceIdMode == null) {
          break label219;
        }
        if (paramLeanplumDeviceIdMode.getMacAddress() != null) {
          break label141;
        }
      }
      catch (Exception paramLeanplumDeviceIdMode)
      {
        paramLeanplumDeviceIdMode.printStackTrace();
      }
      if (paramLeanplumDeviceIdMode != null)
      {
        paramLeanplumDeviceIdMode = new Util.DeviceIdInfo(paramLeanplumDeviceIdMode);
        return paramLeanplumDeviceIdMode;
      }
      return new Util.DeviceIdInfo(Settings.Secure.getString(localContext.getContentResolver(), "android_id"));
      label141:
      paramLeanplumDeviceIdMode = paramLeanplumDeviceIdMode.getMacAddress();
      Object localObject = MessageDigest.getInstance("MD5");
      ((MessageDigest)localObject).update(paramLeanplumDeviceIdMode.getBytes());
      paramLeanplumDeviceIdMode = ((MessageDigest)localObject).digest();
      localObject = new StringBuffer();
      int i = 0;
      for (;;)
      {
        if (i >= paramLeanplumDeviceIdMode.length)
        {
          paramLeanplumDeviceIdMode = ((StringBuffer)localObject).toString();
          break;
        }
        ((StringBuffer)localObject).append(String.format("%02x", new Object[] { Byte.valueOf(paramLeanplumDeviceIdMode[i]) }));
        i += 1;
      }
      label219:
      paramLeanplumDeviceIdMode = null;
    }
  }
  
  public static <T> T a(Map<?, ?> paramMap, Object... paramVarArgs)
  {
    Object localObject;
    if (paramMap == null)
    {
      localObject = null;
      return (T)localObject;
    }
    int j = paramVarArgs.length;
    int i = 0;
    for (;;)
    {
      localObject = paramMap;
      if (i >= j) {
        break;
      }
      localObject = paramVarArgs[i];
      if (!((Map)paramMap).containsKey(localObject)) {
        return null;
      }
      paramMap = ((Map)paramMap).get(localObject);
      i += 1;
    }
  }
  
  public static String a()
  {
    Object localObject = Leanplum.a();
    try
    {
      localObject = getPackageManagergetPackageInfogetPackageName0versionName;
      return (String)localObject;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException) {}
    return "";
  }
  
  private static String a(String paramString)
  {
    String str;
    if ((paramString == null) || (paramString.length() == 0)) {
      str = "";
    }
    char c1;
    do
    {
      return str;
      c1 = paramString.charAt(0);
      str = paramString;
    } while (Character.isUpperCase(c1));
    return Character.toUpperCase(c1) + paramString.substring(1);
  }
  
  private static String a(List<NameValuePair> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 1;
    paramList = paramList.iterator();
    NameValuePair localNameValuePair;
    for (;;)
    {
      if (!paramList.hasNext()) {
        return localStringBuilder.toString();
      }
      localNameValuePair = (NameValuePair)paramList.next();
      if (localNameValuePair.getValue() != null) {
        break;
      }
      Log.w("Leanplum", "Request param " + localNameValuePair.getName() + " is null");
    }
    if (i != 0) {
      i = 0;
    }
    for (;;)
    {
      localStringBuilder.append(localNameValuePair.getName());
      localStringBuilder.append("=");
      localStringBuilder.append(URLEncoder.encode(localNameValuePair.getValue(), "UTF-8"));
      break;
      localStringBuilder.append("&");
    }
  }
  
  private static HttpURLConnection a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt)
  {
    if (paramString2.startsWith("http"))
    {
      paramString1 = (HttpURLConnection)new URL(paramString2).openConnection();
      if (paramBoolean)
      {
        paramString2 = (SSLSocketFactory)SSLSocketFactory.getDefault();
        ((HttpsURLConnection)paramString1).setSSLSocketFactory(paramString2);
      }
      paramString1.setReadTimeout(paramInt * 1000);
      paramString1.setConnectTimeout(paramInt * 1000);
      paramString1.setRequestMethod(paramString3);
      if (!paramString3.equals("GET")) {
        break label153;
      }
    }
    label153:
    for (paramBoolean = false;; paramBoolean = true)
    {
      paramString1.setDoOutput(paramBoolean);
      paramString1.setDoInput(true);
      paramString1.setUseCaches(false);
      paramString1.setInstanceFollowRedirects(true);
      return paramString1;
      if (paramBoolean) {}
      for (String str = "https://";; str = "http://")
      {
        paramString2 = str + paramString1 + "/" + paramString2;
        break;
      }
    }
  }
  
  public static HttpURLConnection a(String paramString1, String paramString2, Map<String, String> paramMap, String paramString3, boolean paramBoolean, int paramInt)
  {
    String str1 = paramString2;
    Iterator localIterator;
    if (paramString3.equals("GET"))
    {
      localIterator = paramMap.keySet().iterator();
      str1 = "";
    }
    String str2;
    String str3;
    for (;;)
    {
      if (!localIterator.hasNext())
      {
        str1 = paramString2 + str1;
        paramString1 = a(paramString1, str1, paramString3, paramBoolean, paramInt);
        if (!paramString3.equals("GET")) {
          a(paramMap, paramString1);
        }
        if ((g.m) && (g.k)) {
          Log.d("Leanplum", "Sending request at path " + str1 + " with parameters " + paramMap);
        }
        return paramString1;
      }
      str2 = (String)localIterator.next();
      str3 = (String)paramMap.get(str2);
      if (str3 != null) {
        break;
      }
      Log.w("Leanplum", "Request param " + str2 + " is null");
    }
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(str1));
    if (str1.length() == 0) {}
    for (char c1 = '?';; c1 = '&')
    {
      str1 = localStringBuilder.append(c1).toString() + str2 + "=" + URLEncoder.encode(str3, "utf-8");
      break;
    }
  }
  
  /* Error */
  @android.annotation.SuppressLint({"DefaultLocale"})
  public static HttpURLConnection a(String paramString1, List<File> paramList, List<InputStream> paramList1, String paramString2, String paramString3, Map<String, String> paramMap, String paramString4, boolean paramBoolean, int paramInt)
  {
    // Byte code:
    //   0: aload_3
    //   1: aload 4
    //   3: aload 6
    //   5: iload 7
    //   7: bipush 60
    //   9: invokestatic 382	com/leanplum/Util:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZI)Ljava/net/HttpURLConnection;
    //   12: astore 4
    //   14: aload 4
    //   16: ldc_w 417
    //   19: ldc_w 419
    //   22: invokevirtual 423	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   25: aload 4
    //   27: ldc_w 425
    //   30: ldc_w 427
    //   33: invokevirtual 423	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   36: new 429	java/io/DataOutputStream
    //   39: dup
    //   40: aload 4
    //   42: invokevirtual 433	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   45: invokespecial 436	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   48: astore 6
    //   50: aload 5
    //   52: invokeinterface 377 1 0
    //   57: invokeinterface 380 1 0
    //   62: astore_3
    //   63: aload_3
    //   64: invokeinterface 280 1 0
    //   69: ifne +38 -> 107
    //   72: iconst_0
    //   73: istore 8
    //   75: iload 8
    //   77: aload_1
    //   78: invokeinterface 439 1 0
    //   83: if_icmplt +94 -> 177
    //   86: aload 6
    //   88: ldc_w 441
    //   91: invokevirtual 444	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   94: aload 6
    //   96: invokevirtual 447	java/io/DataOutputStream:flush	()V
    //   99: aload 6
    //   101: invokevirtual 450	java/io/DataOutputStream:close	()V
    //   104: aload 4
    //   106: areturn
    //   107: aload_3
    //   108: invokeinterface 284 1 0
    //   113: checkcast 59	java/lang/String
    //   116: astore 10
    //   118: aload 6
    //   120: new 251	java/lang/StringBuilder
    //   123: dup
    //   124: ldc_w 452
    //   127: invokespecial 259	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   130: aload 10
    //   132: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: ldc_w 454
    //   138: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: ldc_w 456
    //   144: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: aload 5
    //   149: aload 10
    //   151: invokeinterface 209 2 0
    //   156: checkcast 59	java/lang/String
    //   159: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: ldc_w 456
    //   165: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: invokevirtual 267	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   171: invokevirtual 444	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   174: goto -111 -> 63
    //   177: aload_1
    //   178: iload 8
    //   180: invokeinterface 459 2 0
    //   185: checkcast 461	java/io/File
    //   188: astore_3
    //   189: ldc_w 463
    //   192: iconst_3
    //   193: anewarray 4	java/lang/Object
    //   196: dup
    //   197: iconst_0
    //   198: aload_0
    //   199: aastore
    //   200: dup
    //   201: iconst_1
    //   202: iload 8
    //   204: invokestatic 468	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   207: aastore
    //   208: dup
    //   209: iconst_2
    //   210: aload_3
    //   211: invokevirtual 469	java/io/File:getName	()Ljava/lang/String;
    //   214: aastore
    //   215: invokestatic 195	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   218: astore 5
    //   220: aload 6
    //   222: new 251	java/lang/StringBuilder
    //   225: dup
    //   226: ldc_w 471
    //   229: invokespecial 259	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   232: aload 5
    //   234: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: ldc_w 473
    //   240: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: ldc_w 475
    //   246: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: invokevirtual 267	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   252: invokevirtual 444	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   255: iload 8
    //   257: aload_2
    //   258: invokeinterface 439 1 0
    //   263: if_icmpge +57 -> 320
    //   266: aload_2
    //   267: iload 8
    //   269: invokeinterface 459 2 0
    //   274: checkcast 477	java/io/InputStream
    //   277: astore_3
    //   278: sipush 4096
    //   281: newarray <illegal type>
    //   283: astore 5
    //   285: aload_3
    //   286: aload 5
    //   288: invokevirtual 481	java/io/InputStream:read	([B)I
    //   291: istore 9
    //   293: iload 9
    //   295: iconst_m1
    //   296: if_icmpne +36 -> 332
    //   299: aload_3
    //   300: invokevirtual 482	java/io/InputStream:close	()V
    //   303: aload 6
    //   305: ldc_w 456
    //   308: invokevirtual 444	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   311: iload 8
    //   313: iconst_1
    //   314: iadd
    //   315: istore 8
    //   317: goto -242 -> 75
    //   320: new 484	java/io/FileInputStream
    //   323: dup
    //   324: aload_3
    //   325: invokespecial 487	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   328: astore_3
    //   329: goto -51 -> 278
    //   332: aload 6
    //   334: aload 5
    //   336: iconst_0
    //   337: iload 9
    //   339: invokevirtual 491	java/io/DataOutputStream:write	([BII)V
    //   342: goto -57 -> 285
    //   345: astore_0
    //   346: ldc 83
    //   348: new 251	java/lang/StringBuilder
    //   351: dup
    //   352: ldc_w 493
    //   355: invokespecial 259	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   358: aload_1
    //   359: iload 8
    //   361: invokeinterface 459 2 0
    //   366: invokevirtual 400	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   369: invokevirtual 267	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   372: invokestatic 91	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   375: pop
    //   376: aload_3
    //   377: invokevirtual 482	java/io/InputStream:close	()V
    //   380: aconst_null
    //   381: areturn
    //   382: astore_0
    //   383: aload_3
    //   384: invokevirtual 482	java/io/InputStream:close	()V
    //   387: aload_0
    //   388: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	389	0	paramString1	String
    //   0	389	1	paramList	List<File>
    //   0	389	2	paramList1	List<InputStream>
    //   0	389	3	paramString2	String
    //   0	389	4	paramString3	String
    //   0	389	5	paramMap	Map<String, String>
    //   0	389	6	paramString4	String
    //   0	389	7	paramBoolean	boolean
    //   0	389	8	paramInt	int
    //   291	47	9	i	int
    //   116	34	10	str	String
    // Exception table:
    //   from	to	target	type
    //   285	293	345	java/lang/NullPointerException
    //   332	342	345	java/lang/NullPointerException
    //   285	293	382	finally
    //   332	342	382	finally
    //   346	376	382	finally
  }
  
  public static JSONObject a(HttpURLConnection paramHttpURLConnection)
  {
    StringBuilder localStringBuilder;
    if (paramHttpURLConnection.getResponseCode() < 400)
    {
      paramHttpURLConnection = paramHttpURLConnection.getInputStream();
      paramHttpURLConnection = new BufferedReader(new InputStreamReader(paramHttpURLConnection));
      localStringBuilder = new StringBuilder();
    }
    for (;;)
    {
      String str = paramHttpURLConnection.readLine();
      if (str == null)
      {
        paramHttpURLConnection = localStringBuilder.toString();
        if ((g.m) && (g.k)) {
          Log.d("Leanplum", "Received response " + paramHttpURLConnection);
        }
        return new JSONObject(new JSONTokener(paramHttpURLConnection));
        paramHttpURLConnection = paramHttpURLConnection.getErrorStream();
        break;
      }
      localStringBuilder.append(str).append("\n");
    }
  }
  
  public static <T> void a(AsyncTask<T, ?, ?> paramAsyncTask, T... paramVarArgs)
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      paramAsyncTask.executeOnExecutor(a, paramVarArgs);
      return;
    }
    paramAsyncTask.execute(paramVarArgs);
  }
  
  public static void a(URLConnection paramURLConnection, OutputStream paramOutputStream)
  {
    paramURLConnection = paramURLConnection.getInputStream();
    byte[] arrayOfByte = new byte['က'];
    for (;;)
    {
      int i = paramURLConnection.read(arrayOfByte);
      if (i == -1)
      {
        paramOutputStream.close();
        return;
      }
      paramOutputStream.write(arrayOfByte, 0, i);
    }
  }
  
  public static void a(Map<String, String> paramMap)
  {
    Object localObject2 = Leanplum.a();
    SharedPreferences localSharedPreferences = ((Context)localObject2).getSharedPreferences("__leanplum__", 0);
    if (localSharedPreferences.getBoolean("installTimeInitialized", false)) {
      return;
    }
    Object localObject1 = ((Context)localObject2).getPackageManager();
    localObject2 = ((Context)localObject2).getPackageName();
    if (Build.VERSION.SDK_INT >= 9) {}
    try
    {
      PackageInfo localPackageInfo = ((PackageManager)localObject1).getPackageInfo((String)localObject2, 0);
      paramMap.put("installDate", firstInstallTime / 1000.0D);
      try
      {
        localObject1 = new File(getApplicationInfo0sourceDir);
        if (((File)localObject1).exists()) {
          paramMap.put("updateDate", ((File)localObject1).lastModified() / 1000.0D);
        }
        paramMap = localSharedPreferences.edit();
        paramMap.putBoolean("installTimeInitialized", true);
        try
        {
          paramMap.apply();
          return;
        }
        catch (NoSuchMethodError localNoSuchMethodError)
        {
          paramMap.commit();
          return;
        }
      }
      catch (PackageManager.NameNotFoundException paramMap)
      {
        for (;;) {}
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;) {}
    }
  }
  
  private static void a(Map<String, String> paramMap, HttpURLConnection paramHttpURLConnection)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramMap.keySet().iterator();
    for (;;)
    {
      if (!localIterator.hasNext())
      {
        paramMap = paramHttpURLConnection.getOutputStream();
        paramHttpURLConnection = new BufferedWriter(new OutputStreamWriter(paramMap, "UTF-8"));
        paramHttpURLConnection.write(a(localArrayList));
        paramHttpURLConnection.close();
        paramMap.close();
        return;
      }
      String str = (String)localIterator.next();
      localArrayList.add(new BasicNameValuePair(str, (String)paramMap.get(str)));
    }
  }
  
  public static String b()
  {
    if (e()) {
      return "Android Emulator";
    }
    String str1 = Build.MANUFACTURER;
    String str2 = Build.MODEL;
    if (str2.startsWith(str1)) {
      return a(str2);
    }
    return a(str1) + " " + str2;
  }
  
  public static String c()
  {
    return "Android OS";
  }
  
  public static String d()
  {
    return Build.VERSION.RELEASE;
  }
  
  public static boolean e()
  {
    String str = Build.MODEL.toLowerCase(Locale.getDefault());
    return (str.contains("google_sdk")) || (str.contains("emulator")) || (str.contains("sdk"));
  }
  
  public static String f()
  {
    if (e()) {
      return "Android Emulator";
    }
    return b();
  }
  
  public static String g()
  {
    Object localObject2 = Locale.getDefault().getLanguage();
    Object localObject1 = localObject2;
    if (((String)localObject2).equals("")) {
      localObject1 = "xx";
    }
    String str = Locale.getDefault().getCountry();
    localObject2 = str;
    if (str.equals("")) {
      localObject2 = "XX";
    }
    return localObject1 + "_" + (String)localObject2;
  }
  
  public static boolean h()
  {
    try
    {
      Object localObject = (ConnectivityManager)Leanplum.a().getSystemService("connectivity");
      if (localObject == null) {
        return false;
      }
      localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
      boolean bool;
      if (localObject != null) {
        bool = ((NetworkInfo)localObject).isConnectedOrConnecting();
      }
      return bool;
    }
    catch (Exception localException)
    {
      Log.e("Leanplum", "Error getting connectivity info", localException);
    }
    return false;
  }
  
  static boolean i()
  {
    if (b) {
      return c;
    }
    PackageManager localPackageManager = Leanplum.a().getPackageManager();
    try
    {
      PackageInfo localPackageInfo = localPackageManager.getPackageInfo("com.google.android.gms", 64);
      if (versionCode < 4242000)
      {
        Log.i("Leanplum", "Google Play services version is too old: " + versionCode);
        b = true;
        c = false;
        return false;
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException1)
    {
      b = true;
      c = false;
      return false;
    }
    try
    {
      ApplicationInfo localApplicationInfo = localNameNotFoundException1.getApplicationInfo("com.google.android.gms", 0);
      b = true;
      c = enabled;
      return enabled;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException2)
    {
      b = true;
      c = false;
    }
    return false;
  }
  
  public static boolean j()
  {
    return (LeanplumActivityHelper.b == null) || (LeanplumActivityHelper.a);
  }
}

/* Location:
 * Qualified Name:     com.leanplum.Util
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */