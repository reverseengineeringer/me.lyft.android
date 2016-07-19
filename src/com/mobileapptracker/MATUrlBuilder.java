package com.mobileapptracker;

import android.util.Log;
import java.util.Date;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class MATUrlBuilder
{
  private static MATParameters params;
  
  public static JSONObject buildBody(JSONArray paramJSONArray1, String paramString1, String paramString2, JSONArray paramJSONArray2)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      if (paramJSONArray1 != null) {}
      try
      {
        localJSONObject.put("data", paramJSONArray1);
        if (paramString1 != null) {
          localJSONObject.put("store_iap_data", paramString1);
        }
        if (paramString2 != null) {
          localJSONObject.put("store_iap_signature", paramString2);
        }
        if (paramJSONArray2 != null) {
          localJSONObject.put("user_emails", paramJSONArray2);
        }
      }
      catch (JSONException paramJSONArray1)
      {
        for (;;)
        {
          Log.d("MobileAppTracker", "Could not build JSON body of request");
          paramJSONArray1.printStackTrace();
        }
      }
      return localJSONObject;
    }
    finally {}
  }
  
  /* Error */
  public static String buildDataUnencrypted(MATEvent paramMATEvent)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 50	com/mobileapptracker/MATParameters:getInstance	()Lcom/mobileapptracker/MATParameters;
    //   6: putstatic 52	com/mobileapptracker/MATUrlBuilder:params	Lcom/mobileapptracker/MATParameters;
    //   9: new 54	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   16: astore_1
    //   17: aload_1
    //   18: new 54	java/lang/StringBuilder
    //   21: dup
    //   22: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   25: ldc 57
    //   27: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: getstatic 52	com/mobileapptracker/MATUrlBuilder:params	Lcom/mobileapptracker/MATParameters;
    //   33: invokevirtual 65	com/mobileapptracker/MATParameters:getConnectionType	()Ljava/lang/String;
    //   36: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: pop
    //   46: aload_1
    //   47: ldc 70
    //   49: getstatic 52	com/mobileapptracker/MATUrlBuilder:params	Lcom/mobileapptracker/MATParameters;
    //   52: invokevirtual 73	com/mobileapptracker/MATParameters:getAltitude	()Ljava/lang/String;
    //   55: invokestatic 77	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   58: aload_1
    //   59: ldc 79
    //   61: getstatic 52	com/mobileapptracker/MATUrlBuilder:params	Lcom/mobileapptracker/MATParameters;
    //   64: invokevirtual 82	com/mobileapptracker/MATParameters:getAndroidId	()Ljava/lang/String;
    //   67: invokestatic 77	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   70: aload_1
    //   71: ldc 84
    //   73: getstatic 52	com/mobileapptracker/MATUrlBuilder:params	Lcom/mobileapptracker/MATParameters;
    //   76: invokevirtual 87	com/mobileapptracker/MATParameters:getAndroidIdMd5	()Ljava/lang/String;
    //   79: invokestatic 77	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   82: aload_1
    //   83: ldc 89
    //   85: getstatic 52	com/mobileapptracker/MATUrlBuilder:params	Lcom/mobileapptracker/MATParameters;
    //   88: invokevirtual 92	com/mobileapptracker/MATParameters:getAndroidIdSha1	()Ljava/lang/String;
    //   91: invokestatic 77	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   94: aload_1
    //   95: ldc 94
    //   97: getstatic 52	com/mobileapptracker/MATUrlBuilder:params	Lcom/mobileapptracker/MATParameters;
    //   100: invokevirtual 97	com/mobileapptracker/MATParameters:getAndroidIdSha256	()Ljava/lang/String;
    //   103: invokestatic 77	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   106: aload_1
    //   107: ldc 99
    //   109: getstatic 52	com/mobileapptracker/MATUrlBuilder:params	Lcom/mobileapptracker/MATParameters;
    //   112: invokevirtual 102	com/mobileapptracker/MATParameters:getAppAdTrackingEnabled	()Ljava/lang/String;
    //   115: invokestatic 77	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   118: aload_1
    //   119: ldc 104
    //   121: getstatic 52	com/mobileapptracker/MATUrlBuilder:params	Lcom/mobileapptracker/MATParameters;
    //   124: invokevirtual 107	com/mobileapptracker/MATParameters:getAppName	()Ljava/lang/String;
    //   127: invokestatic 77	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   130: aload_1
    //   131: ldc 109
    //   133: getstatic 52	com/mobileapptracker/MATUrlBuilder:params	Lcom/mobileapptracker/MATParameters;
    //   136: invokevirtual 112	com/mobileapptracker/MATParameters:getAppVersion	()Ljava/lang/String;
    //   139: invokestatic 77	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   142: aload_1
    //   143: ldc 114
    //   145: getstatic 52	com/mobileapptracker/MATUrlBuilder:params	Lcom/mobileapptracker/MATParameters;
    //   148: invokevirtual 117	com/mobileapptracker/MATParameters:getAppVersionName	()Ljava/lang/String;
    //   151: invokestatic 77	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   154: aload_1
    //   155: ldc 119
    //   157: getstatic 52	com/mobileapptracker/MATUrlBuilder:params	Lcom/mobileapptracker/MATParameters;
    //   160: invokevirtual 122	com/mobileapptracker/MATParameters:getCountryCode	()Ljava/lang/String;
    //   163: invokestatic 77	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   166: aload_1
    //   167: ldc 124
    //   169: getstatic 52	com/mobileapptracker/MATUrlBuilder:params	Lcom/mobileapptracker/MATParameters;
    //   172: invokevirtual 127	com/mobileapptracker/MATParameters:getDeviceBrand	()Ljava/lang/String;
    //   175: invokestatic 77	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   178: aload_1
    //   179: ldc -127
    //   181: getstatic 52	com/mobileapptracker/MATUrlBuilder:params	Lcom/mobileapptracker/MATParameters;
    //   184: invokevirtual 132	com/mobileapptracker/MATParameters:getDeviceCarrier	()Ljava/lang/String;
    //   187: invokestatic 77	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   190: aload_1
    //   191: ldc -122
    //   193: getstatic 52	com/mobileapptracker/MATUrlBuilder:params	Lcom/mobileapptracker/MATParameters;
    //   196: invokevirtual 137	com/mobileapptracker/MATParameters:getDeviceCpuType	()Ljava/lang/String;
    //   199: invokestatic 77	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   202: aload_1
    //   203: ldc -117
    //   205: getstatic 52	com/mobileapptracker/MATUrlBuilder:params	Lcom/mobileapptracker/MATParameters;
    //   208: invokevirtual 142	com/mobileapptracker/MATParameters:getDeviceCpuSubtype	()Ljava/lang/String;
    //   211: invokestatic 77	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   214: aload_1
    //   215: ldc -112
    //   217: getstatic 52	com/mobileapptracker/MATUrlBuilder:params	Lcom/mobileapptracker/MATParameters;
    //   220: invokevirtual 147	com/mobileapptracker/MATParameters:getDeviceModel	()Ljava/lang/String;
    //   223: invokestatic 77	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   226: aload_1
    //   227: ldc -107
    //   229: getstatic 52	com/mobileapptracker/MATUrlBuilder:params	Lcom/mobileapptracker/MATParameters;
    //   232: invokevirtual 152	com/mobileapptracker/MATParameters:getDeviceId	()Ljava/lang/String;
    //   235: invokestatic 77	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   238: aload_1
    //   239: ldc -102
    //   241: getstatic 52	com/mobileapptracker/MATUrlBuilder:params	Lcom/mobileapptracker/MATParameters;
    //   244: invokevirtual 157	com/mobileapptracker/MATParameters:getGoogleAdvertisingId	()Ljava/lang/String;
    //   247: invokestatic 77	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   250: aload_1
    //   251: ldc -97
    //   253: getstatic 52	com/mobileapptracker/MATUrlBuilder:params	Lcom/mobileapptracker/MATParameters;
    //   256: invokevirtual 162	com/mobileapptracker/MATParameters:getGoogleAdTrackingLimited	()Ljava/lang/String;
    //   259: invokestatic 77	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   262: aload_1
    //   263: ldc -92
    //   265: getstatic 52	com/mobileapptracker/MATUrlBuilder:params	Lcom/mobileapptracker/MATParameters;
    //   268: invokevirtual 167	com/mobileapptracker/MATParameters:getInstallDate	()Ljava/lang/String;
    //   271: invokestatic 77	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   274: aload_1
    //   275: ldc -87
    //   277: getstatic 52	com/mobileapptracker/MATUrlBuilder:params	Lcom/mobileapptracker/MATParameters;
    //   280: invokevirtual 172	com/mobileapptracker/MATParameters:getInstaller	()Ljava/lang/String;
    //   283: invokestatic 77	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   286: aload_1
    //   287: ldc -82
    //   289: getstatic 52	com/mobileapptracker/MATUrlBuilder:params	Lcom/mobileapptracker/MATParameters;
    //   292: invokevirtual 177	com/mobileapptracker/MATParameters:getInstallReferrer	()Ljava/lang/String;
    //   295: invokestatic 77	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   298: aload_1
    //   299: ldc -77
    //   301: getstatic 52	com/mobileapptracker/MATUrlBuilder:params	Lcom/mobileapptracker/MATParameters;
    //   304: invokevirtual 182	com/mobileapptracker/MATParameters:getLanguage	()Ljava/lang/String;
    //   307: invokestatic 77	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   310: aload_1
    //   311: ldc -72
    //   313: getstatic 52	com/mobileapptracker/MATUrlBuilder:params	Lcom/mobileapptracker/MATParameters;
    //   316: invokevirtual 187	com/mobileapptracker/MATParameters:getLastOpenLogId	()Ljava/lang/String;
    //   319: invokestatic 77	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   322: aload_1
    //   323: ldc -67
    //   325: getstatic 52	com/mobileapptracker/MATUrlBuilder:params	Lcom/mobileapptracker/MATParameters;
    //   328: invokevirtual 192	com/mobileapptracker/MATParameters:getLatitude	()Ljava/lang/String;
    //   331: invokestatic 77	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   334: aload_1
    //   335: ldc -62
    //   337: getstatic 52	com/mobileapptracker/MATUrlBuilder:params	Lcom/mobileapptracker/MATParameters;
    //   340: invokevirtual 197	com/mobileapptracker/MATParameters:getLongitude	()Ljava/lang/String;
    //   343: invokestatic 77	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   346: aload_1
    //   347: ldc -57
    //   349: getstatic 52	com/mobileapptracker/MATUrlBuilder:params	Lcom/mobileapptracker/MATParameters;
    //   352: invokevirtual 202	com/mobileapptracker/MATParameters:getMacAddress	()Ljava/lang/String;
    //   355: invokestatic 77	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   358: aload_1
    //   359: ldc -52
    //   361: getstatic 52	com/mobileapptracker/MATUrlBuilder:params	Lcom/mobileapptracker/MATParameters;
    //   364: invokevirtual 207	com/mobileapptracker/MATParameters:getMatId	()Ljava/lang/String;
    //   367: invokestatic 77	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   370: aload_1
    //   371: ldc -47
    //   373: getstatic 52	com/mobileapptracker/MATUrlBuilder:params	Lcom/mobileapptracker/MATParameters;
    //   376: invokevirtual 212	com/mobileapptracker/MATParameters:getMCC	()Ljava/lang/String;
    //   379: invokestatic 77	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   382: aload_1
    //   383: ldc -42
    //   385: getstatic 52	com/mobileapptracker/MATUrlBuilder:params	Lcom/mobileapptracker/MATParameters;
    //   388: invokevirtual 217	com/mobileapptracker/MATParameters:getMNC	()Ljava/lang/String;
    //   391: invokestatic 77	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   394: aload_1
    //   395: ldc -37
    //   397: getstatic 52	com/mobileapptracker/MATUrlBuilder:params	Lcom/mobileapptracker/MATParameters;
    //   400: invokevirtual 222	com/mobileapptracker/MATParameters:getOpenLogId	()Ljava/lang/String;
    //   403: invokestatic 77	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   406: aload_1
    //   407: ldc -32
    //   409: getstatic 52	com/mobileapptracker/MATUrlBuilder:params	Lcom/mobileapptracker/MATParameters;
    //   412: invokevirtual 227	com/mobileapptracker/MATParameters:getOsVersion	()Ljava/lang/String;
    //   415: invokestatic 77	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   418: aload_1
    //   419: ldc -27
    //   421: getstatic 52	com/mobileapptracker/MATUrlBuilder:params	Lcom/mobileapptracker/MATParameters;
    //   424: invokevirtual 232	com/mobileapptracker/MATParameters:getPluginName	()Ljava/lang/String;
    //   427: invokestatic 77	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   430: aload_1
    //   431: ldc -22
    //   433: getstatic 52	com/mobileapptracker/MATUrlBuilder:params	Lcom/mobileapptracker/MATParameters;
    //   436: invokevirtual 237	com/mobileapptracker/MATParameters:getPurchaseStatus	()Ljava/lang/String;
    //   439: invokestatic 77	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   442: aload_1
    //   443: ldc -17
    //   445: getstatic 52	com/mobileapptracker/MATUrlBuilder:params	Lcom/mobileapptracker/MATParameters;
    //   448: invokevirtual 242	com/mobileapptracker/MATParameters:getReferrerDelay	()Ljava/lang/String;
    //   451: invokestatic 77	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   454: aload_1
    //   455: ldc -12
    //   457: getstatic 52	com/mobileapptracker/MATUrlBuilder:params	Lcom/mobileapptracker/MATParameters;
    //   460: invokevirtual 247	com/mobileapptracker/MATParameters:getScreenDensity	()Ljava/lang/String;
    //   463: invokestatic 77	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   466: aload_1
    //   467: ldc -7
    //   469: new 54	java/lang/StringBuilder
    //   472: dup
    //   473: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   476: getstatic 52	com/mobileapptracker/MATUrlBuilder:params	Lcom/mobileapptracker/MATParameters;
    //   479: invokevirtual 252	com/mobileapptracker/MATParameters:getScreenWidth	()Ljava/lang/String;
    //   482: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   485: ldc -2
    //   487: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   490: getstatic 52	com/mobileapptracker/MATUrlBuilder:params	Lcom/mobileapptracker/MATParameters;
    //   493: invokevirtual 257	com/mobileapptracker/MATParameters:getScreenHeight	()Ljava/lang/String;
    //   496: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   499: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   502: invokestatic 77	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   505: aload_1
    //   506: ldc_w 259
    //   509: getstatic 52	com/mobileapptracker/MATUrlBuilder:params	Lcom/mobileapptracker/MATParameters;
    //   512: invokevirtual 262	com/mobileapptracker/MATParameters:getSdkVersion	()Ljava/lang/String;
    //   515: invokestatic 77	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   518: aload_1
    //   519: ldc_w 264
    //   522: getstatic 52	com/mobileapptracker/MATUrlBuilder:params	Lcom/mobileapptracker/MATParameters;
    //   525: invokevirtual 267	com/mobileapptracker/MATParameters:getTRUSTeId	()Ljava/lang/String;
    //   528: invokestatic 77	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   531: aload_1
    //   532: ldc_w 269
    //   535: getstatic 52	com/mobileapptracker/MATUrlBuilder:params	Lcom/mobileapptracker/MATParameters;
    //   538: invokevirtual 272	com/mobileapptracker/MATParameters:getUserAgent	()Ljava/lang/String;
    //   541: invokestatic 77	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   544: aload_1
    //   545: ldc_w 274
    //   548: aload_0
    //   549: invokevirtual 279	com/mobileapptracker/MATEvent:getAttribute1	()Ljava/lang/String;
    //   552: invokestatic 77	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   555: aload_1
    //   556: ldc_w 281
    //   559: aload_0
    //   560: invokevirtual 284	com/mobileapptracker/MATEvent:getAttribute2	()Ljava/lang/String;
    //   563: invokestatic 77	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   566: aload_1
    //   567: ldc_w 286
    //   570: aload_0
    //   571: invokevirtual 289	com/mobileapptracker/MATEvent:getAttribute3	()Ljava/lang/String;
    //   574: invokestatic 77	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   577: aload_1
    //   578: ldc_w 291
    //   581: aload_0
    //   582: invokevirtual 294	com/mobileapptracker/MATEvent:getAttribute4	()Ljava/lang/String;
    //   585: invokestatic 77	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   588: aload_1
    //   589: ldc_w 296
    //   592: aload_0
    //   593: invokevirtual 299	com/mobileapptracker/MATEvent:getAttribute5	()Ljava/lang/String;
    //   596: invokestatic 77	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   599: aload_1
    //   600: ldc_w 301
    //   603: aload_0
    //   604: invokevirtual 304	com/mobileapptracker/MATEvent:getContentId	()Ljava/lang/String;
    //   607: invokestatic 77	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   610: aload_1
    //   611: ldc_w 306
    //   614: aload_0
    //   615: invokevirtual 309	com/mobileapptracker/MATEvent:getContentType	()Ljava/lang/String;
    //   618: invokestatic 77	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   621: aload_0
    //   622: invokevirtual 312	com/mobileapptracker/MATEvent:getCurrencyCode	()Ljava/lang/String;
    //   625: ifnull +420 -> 1045
    //   628: aload_1
    //   629: ldc_w 314
    //   632: aload_0
    //   633: invokevirtual 312	com/mobileapptracker/MATEvent:getCurrencyCode	()Ljava/lang/String;
    //   636: invokestatic 77	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   639: aload_0
    //   640: invokevirtual 318	com/mobileapptracker/MATEvent:getDate1	()Ljava/util/Date;
    //   643: ifnull +24 -> 667
    //   646: aload_1
    //   647: ldc_w 320
    //   650: aload_0
    //   651: invokevirtual 318	com/mobileapptracker/MATEvent:getDate1	()Ljava/util/Date;
    //   654: invokevirtual 326	java/util/Date:getTime	()J
    //   657: ldc2_w 327
    //   660: ldiv
    //   661: invokestatic 333	java/lang/Long:toString	(J)Ljava/lang/String;
    //   664: invokestatic 77	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   667: aload_0
    //   668: invokevirtual 336	com/mobileapptracker/MATEvent:getDate2	()Ljava/util/Date;
    //   671: ifnull +24 -> 695
    //   674: aload_1
    //   675: ldc_w 338
    //   678: aload_0
    //   679: invokevirtual 336	com/mobileapptracker/MATEvent:getDate2	()Ljava/util/Date;
    //   682: invokevirtual 326	java/util/Date:getTime	()J
    //   685: ldc2_w 327
    //   688: ldiv
    //   689: invokestatic 333	java/lang/Long:toString	(J)Ljava/lang/String;
    //   692: invokestatic 77	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   695: aload_0
    //   696: invokevirtual 342	com/mobileapptracker/MATEvent:getLevel	()I
    //   699: ifeq +17 -> 716
    //   702: aload_1
    //   703: ldc_w 344
    //   706: aload_0
    //   707: invokevirtual 342	com/mobileapptracker/MATEvent:getLevel	()I
    //   710: invokestatic 349	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   713: invokestatic 77	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   716: aload_0
    //   717: invokevirtual 352	com/mobileapptracker/MATEvent:getQuantity	()I
    //   720: ifeq +17 -> 737
    //   723: aload_1
    //   724: ldc_w 354
    //   727: aload_0
    //   728: invokevirtual 352	com/mobileapptracker/MATEvent:getQuantity	()I
    //   731: invokestatic 349	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   734: invokestatic 77	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   737: aload_0
    //   738: invokevirtual 358	com/mobileapptracker/MATEvent:getRating	()D
    //   741: dconst_0
    //   742: dcmpl
    //   743: ifeq +17 -> 760
    //   746: aload_1
    //   747: ldc_w 360
    //   750: aload_0
    //   751: invokevirtual 358	com/mobileapptracker/MATEvent:getRating	()D
    //   754: invokestatic 365	java/lang/Double:toString	(D)Ljava/lang/String;
    //   757: invokestatic 77	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   760: aload_1
    //   761: ldc_w 367
    //   764: aload_0
    //   765: invokevirtual 370	com/mobileapptracker/MATEvent:getSearchString	()Ljava/lang/String;
    //   768: invokestatic 77	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   771: aload_1
    //   772: ldc_w 372
    //   775: aload_0
    //   776: invokevirtual 375	com/mobileapptracker/MATEvent:getRefId	()Ljava/lang/String;
    //   779: invokestatic 77	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   782: aload_1
    //   783: ldc_w 377
    //   786: aload_0
    //   787: invokevirtual 380	com/mobileapptracker/MATEvent:getRevenue	()D
    //   790: invokestatic 365	java/lang/Double:toString	(D)Ljava/lang/String;
    //   793: invokestatic 77	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   796: aload_0
    //   797: invokevirtual 383	com/mobileapptracker/MATEvent:getDeviceForm	()Ljava/lang/String;
    //   800: ifnull +14 -> 814
    //   803: aload_1
    //   804: ldc_w 385
    //   807: aload_0
    //   808: invokevirtual 383	com/mobileapptracker/MATEvent:getDeviceForm	()Ljava/lang/String;
    //   811: invokestatic 77	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   814: aload_1
    //   815: ldc_w 387
    //   818: getstatic 52	com/mobileapptracker/MATUrlBuilder:params	Lcom/mobileapptracker/MATParameters;
    //   821: invokevirtual 390	com/mobileapptracker/MATParameters:getAge	()Ljava/lang/String;
    //   824: invokestatic 77	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   827: aload_1
    //   828: ldc_w 392
    //   831: getstatic 52	com/mobileapptracker/MATUrlBuilder:params	Lcom/mobileapptracker/MATParameters;
    //   834: invokevirtual 395	com/mobileapptracker/MATParameters:getExistingUser	()Ljava/lang/String;
    //   837: invokestatic 77	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   840: aload_1
    //   841: ldc_w 397
    //   844: getstatic 52	com/mobileapptracker/MATUrlBuilder:params	Lcom/mobileapptracker/MATParameters;
    //   847: invokevirtual 400	com/mobileapptracker/MATParameters:getFacebookUserId	()Ljava/lang/String;
    //   850: invokestatic 77	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   853: aload_1
    //   854: ldc_w 402
    //   857: getstatic 52	com/mobileapptracker/MATUrlBuilder:params	Lcom/mobileapptracker/MATParameters;
    //   860: invokevirtual 405	com/mobileapptracker/MATParameters:getGender	()Ljava/lang/String;
    //   863: invokestatic 77	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   866: aload_1
    //   867: ldc_w 407
    //   870: getstatic 52	com/mobileapptracker/MATUrlBuilder:params	Lcom/mobileapptracker/MATParameters;
    //   873: invokevirtual 410	com/mobileapptracker/MATParameters:getGoogleUserId	()Ljava/lang/String;
    //   876: invokestatic 77	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   879: aload_1
    //   880: ldc_w 412
    //   883: getstatic 52	com/mobileapptracker/MATUrlBuilder:params	Lcom/mobileapptracker/MATParameters;
    //   886: invokevirtual 415	com/mobileapptracker/MATParameters:getIsPayingUser	()Ljava/lang/String;
    //   889: invokestatic 77	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   892: aload_1
    //   893: ldc_w 417
    //   896: getstatic 52	com/mobileapptracker/MATUrlBuilder:params	Lcom/mobileapptracker/MATParameters;
    //   899: invokevirtual 420	com/mobileapptracker/MATParameters:getTwitterUserId	()Ljava/lang/String;
    //   902: invokestatic 77	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   905: aload_1
    //   906: ldc_w 422
    //   909: getstatic 52	com/mobileapptracker/MATUrlBuilder:params	Lcom/mobileapptracker/MATParameters;
    //   912: invokevirtual 425	com/mobileapptracker/MATParameters:getUserEmailMd5	()Ljava/lang/String;
    //   915: invokestatic 77	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   918: aload_1
    //   919: ldc_w 427
    //   922: getstatic 52	com/mobileapptracker/MATUrlBuilder:params	Lcom/mobileapptracker/MATParameters;
    //   925: invokevirtual 430	com/mobileapptracker/MATParameters:getUserEmailSha1	()Ljava/lang/String;
    //   928: invokestatic 77	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   931: aload_1
    //   932: ldc_w 432
    //   935: getstatic 52	com/mobileapptracker/MATUrlBuilder:params	Lcom/mobileapptracker/MATParameters;
    //   938: invokevirtual 435	com/mobileapptracker/MATParameters:getUserEmailSha256	()Ljava/lang/String;
    //   941: invokestatic 77	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   944: aload_1
    //   945: ldc_w 437
    //   948: getstatic 52	com/mobileapptracker/MATUrlBuilder:params	Lcom/mobileapptracker/MATParameters;
    //   951: invokevirtual 440	com/mobileapptracker/MATParameters:getUserId	()Ljava/lang/String;
    //   954: invokestatic 77	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   957: aload_1
    //   958: ldc_w 442
    //   961: getstatic 52	com/mobileapptracker/MATUrlBuilder:params	Lcom/mobileapptracker/MATParameters;
    //   964: invokevirtual 445	com/mobileapptracker/MATParameters:getUserNameMd5	()Ljava/lang/String;
    //   967: invokestatic 77	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   970: aload_1
    //   971: ldc_w 447
    //   974: getstatic 52	com/mobileapptracker/MATUrlBuilder:params	Lcom/mobileapptracker/MATParameters;
    //   977: invokevirtual 450	com/mobileapptracker/MATParameters:getUserNameSha1	()Ljava/lang/String;
    //   980: invokestatic 77	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   983: aload_1
    //   984: ldc_w 452
    //   987: getstatic 52	com/mobileapptracker/MATUrlBuilder:params	Lcom/mobileapptracker/MATParameters;
    //   990: invokevirtual 455	com/mobileapptracker/MATParameters:getUserNameSha256	()Ljava/lang/String;
    //   993: invokestatic 77	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   996: aload_1
    //   997: ldc_w 457
    //   1000: getstatic 52	com/mobileapptracker/MATUrlBuilder:params	Lcom/mobileapptracker/MATParameters;
    //   1003: invokevirtual 460	com/mobileapptracker/MATParameters:getPhoneNumberMd5	()Ljava/lang/String;
    //   1006: invokestatic 77	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   1009: aload_1
    //   1010: ldc_w 462
    //   1013: getstatic 52	com/mobileapptracker/MATUrlBuilder:params	Lcom/mobileapptracker/MATParameters;
    //   1016: invokevirtual 465	com/mobileapptracker/MATParameters:getPhoneNumberSha1	()Ljava/lang/String;
    //   1019: invokestatic 77	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   1022: aload_1
    //   1023: ldc_w 467
    //   1026: getstatic 52	com/mobileapptracker/MATUrlBuilder:params	Lcom/mobileapptracker/MATParameters;
    //   1029: invokevirtual 470	com/mobileapptracker/MATParameters:getPhoneNumberSha256	()Ljava/lang/String;
    //   1032: invokestatic 77	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   1035: aload_1
    //   1036: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1039: astore_0
    //   1040: ldc 2
    //   1042: monitorexit
    //   1043: aload_0
    //   1044: areturn
    //   1045: aload_1
    //   1046: ldc_w 314
    //   1049: getstatic 52	com/mobileapptracker/MATUrlBuilder:params	Lcom/mobileapptracker/MATParameters;
    //   1052: invokevirtual 471	com/mobileapptracker/MATParameters:getCurrencyCode	()Ljava/lang/String;
    //   1055: invokestatic 77	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   1058: goto -419 -> 639
    //   1061: astore_0
    //   1062: ldc 2
    //   1064: monitorexit
    //   1065: aload_0
    //   1066: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1067	0	paramMATEvent	MATEvent
    //   16	1030	1	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   3	639	1061	finally
    //   639	667	1061	finally
    //   667	695	1061	finally
    //   695	716	1061	finally
    //   716	737	1061	finally
    //   737	760	1061	finally
    //   760	814	1061	finally
    //   814	1040	1061	finally
    //   1045	1058	1061	finally
  }
  
  public static String buildLink(MATEvent paramMATEvent, MATPreloadData paramMATPreloadData, boolean paramBoolean)
  {
    params = MATParameters.getInstance();
    StringBuilder localStringBuilder = new StringBuilder("https://").append(params.getAdvertiserId()).append(".");
    if (paramBoolean) {
      localStringBuilder.append("debug.engine.mobileapptracking.com");
    }
    for (;;)
    {
      localStringBuilder.append("/serve?ver=").append(params.getSdkVersion());
      localStringBuilder.append("&transaction_id=").append(UUID.randomUUID().toString());
      safeAppend(localStringBuilder, "sdk", "android");
      safeAppend(localStringBuilder, "action", params.getAction());
      safeAppend(localStringBuilder, "advertiser_id", params.getAdvertiserId());
      safeAppend(localStringBuilder, "package_name", params.getPackageName());
      safeAppend(localStringBuilder, "referral_source", params.getReferralSource());
      safeAppend(localStringBuilder, "referral_url", params.getReferralUrl());
      safeAppend(localStringBuilder, "site_id", params.getSiteId());
      safeAppend(localStringBuilder, "tracking_id", params.getTrackingId());
      if (paramMATEvent.getEventId() != 0) {
        safeAppend(localStringBuilder, "site_event_id", Integer.toString(paramMATEvent.getEventId()));
      }
      if (!params.getAction().equals("session")) {
        safeAppend(localStringBuilder, "site_event_name", paramMATEvent.getEventName());
      }
      if (paramMATPreloadData != null)
      {
        localStringBuilder.append("&attr_set=1");
        safeAppend(localStringBuilder, "publisher_id", publisherId);
        safeAppend(localStringBuilder, "offer_id", offerId);
        safeAppend(localStringBuilder, "agency_id", agencyId);
        safeAppend(localStringBuilder, "publisher_ref_id", publisherReferenceId);
        safeAppend(localStringBuilder, "publisher_sub_publisher", publisherSubPublisher);
        safeAppend(localStringBuilder, "publisher_sub_site", publisherSubSite);
        safeAppend(localStringBuilder, "publisher_sub_campaign", publisherSubCampaign);
        safeAppend(localStringBuilder, "publisher_sub_adgroup", publisherSubAdgroup);
        safeAppend(localStringBuilder, "publisher_sub_ad", publisherSubAd);
        safeAppend(localStringBuilder, "publisher_sub_keyword", publisherSubKeyword);
        safeAppend(localStringBuilder, "advertiser_sub_publisher", advertiserSubPublisher);
        safeAppend(localStringBuilder, "advertiser_sub_site", advertiserSubSite);
        safeAppend(localStringBuilder, "advertiser_sub_campaign", advertiserSubCampaign);
        safeAppend(localStringBuilder, "advertiser_sub_adgroup", advertiserSubAdgroup);
        safeAppend(localStringBuilder, "advertiser_sub_ad", advertiserSubAd);
        safeAppend(localStringBuilder, "advertiser_sub_keyword", advertiserSubKeyword);
        safeAppend(localStringBuilder, "publisher_sub1", publisherSub1);
        safeAppend(localStringBuilder, "publisher_sub2", publisherSub2);
        safeAppend(localStringBuilder, "publisher_sub3", publisherSub3);
        safeAppend(localStringBuilder, "publisher_sub4", publisherSub4);
        safeAppend(localStringBuilder, "publisher_sub5", publisherSub5);
      }
      paramMATEvent = params.getAllowDuplicates();
      if ((paramMATEvent != null) && (Integer.parseInt(paramMATEvent) == 1)) {
        localStringBuilder.append("&skip_dup=1");
      }
      if (paramBoolean) {
        localStringBuilder.append("&debug=1");
      }
      return localStringBuilder.toString();
      localStringBuilder.append("engine.mobileapptracking.com");
    }
  }
  
  /* Error */
  private static void safeAppend(StringBuilder paramStringBuilder, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_2
    //   4: ifnull +56 -> 60
    //   7: aload_2
    //   8: ldc_w 677
    //   11: invokevirtual 545	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   14: istore_3
    //   15: iload_3
    //   16: ifne +44 -> 60
    //   19: aload_0
    //   20: new 54	java/lang/StringBuilder
    //   23: dup
    //   24: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   27: ldc_w 679
    //   30: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: aload_1
    //   34: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: ldc_w 681
    //   40: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: aload_2
    //   44: ldc_w 683
    //   47: invokestatic 689	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   50: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   56: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: pop
    //   60: ldc 2
    //   62: monitorexit
    //   63: return
    //   64: astore_0
    //   65: ldc 30
    //   67: new 54	java/lang/StringBuilder
    //   70: dup
    //   71: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   74: ldc_w 691
    //   77: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: aload_2
    //   81: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: ldc_w 693
    //   87: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: aload_1
    //   91: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   97: invokestatic 696	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   100: pop
    //   101: aload_0
    //   102: invokevirtual 697	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   105: goto -45 -> 60
    //   108: astore_0
    //   109: ldc 2
    //   111: monitorexit
    //   112: aload_0
    //   113: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	114	0	paramStringBuilder	StringBuilder
    //   0	114	1	paramString1	String
    //   0	114	2	paramString2	String
    //   14	2	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   19	60	64	java/io/UnsupportedEncodingException
    //   7	15	108	finally
    //   19	60	108	finally
    //   65	105	108	finally
  }
  
  public static String updateAndEncryptData(String paramString, MATEncryption paramMATEncryption)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder(paramString);
      params = MATParameters.getInstance();
      if (params != null)
      {
        String str = params.getGoogleAdvertisingId();
        if ((str != null) && (!paramString.contains("&google_aid=")))
        {
          safeAppend(localStringBuilder, "google_aid", str);
          safeAppend(localStringBuilder, "google_ad_tracking_disabled", params.getGoogleAdTrackingLimited());
        }
        str = params.getAndroidId();
        if ((str != null) && (!paramString.contains("&android_id="))) {
          safeAppend(localStringBuilder, "android_id", str);
        }
        str = params.getInstallReferrer();
        if ((str != null) && (!paramString.contains("&install_referrer="))) {
          safeAppend(localStringBuilder, "install_referrer", str);
        }
        str = params.getUserAgent();
        if ((str != null) && (!paramString.contains("&conversion_user_agent="))) {
          safeAppend(localStringBuilder, "conversion_user_agent", str);
        }
        str = params.getFacebookUserId();
        if ((str != null) && (!paramString.contains("&facebook_user_id="))) {
          safeAppend(localStringBuilder, "facebook_user_id", str);
        }
      }
      if (!paramString.contains("&system_date=")) {
        safeAppend(localStringBuilder, "system_date", Long.toString(new Date().getTime() / 1000L));
      }
      paramString = localStringBuilder.toString();
      try
      {
        paramMATEncryption = MATUtils.bytesToHex(paramMATEncryption.encrypt(paramString));
        paramString = paramMATEncryption;
      }
      catch (Exception paramMATEncryption)
      {
        for (;;)
        {
          paramMATEncryption.printStackTrace();
        }
      }
      return paramString;
    }
    finally {}
  }
}

/* Location:
 * Qualified Name:     com.mobileapptracker.MATUrlBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */