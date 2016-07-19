package com.threatmetrix.TrustDefenderMobile;

import java.util.Map;

class HttpConfigRunner
  extends HttpRunner
{
  private static final String TAG = StringUtils.getLogTag(HttpConfigRunner.class);
  public TDConfiguration m_config = null;
  private CancelState m_state = null;
  
  public HttpConfigRunner(TDHttpClient paramTDHttpClient, String paramString, HttpParameterMap paramHttpParameterMap, Map<String, String> paramMap, TrustDefenderMobile paramTrustDefenderMobile, CancelState paramCancelState)
  {
    super(paramTDHttpClient, HttpRunner.HttpRunnerType.GET, paramString, paramHttpParameterMap, paramMap, paramTrustDefenderMobile, null, paramCancelState);
    m_state = paramCancelState;
  }
  
  public THMStatusCode getStatusCode()
  {
    if (m_connection.getStatus() == THMStatusCode.THM_OK)
    {
      if ((m_config != null) && (m_config.isUsable())) {
        return THMStatusCode.THM_OK;
      }
      return THMStatusCode.THM_ConfigurationError;
    }
    return super.getStatusCode();
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: aconst_null
    //   2: putfield 34	com/threatmetrix/TrustDefenderMobile/HttpConfigRunner:m_config	Lcom/threatmetrix/TrustDefenderMobile/TDConfiguration;
    //   5: getstatic 20	com/threatmetrix/TrustDefenderMobile/HttpConfigRunner:TAG	Ljava/lang/String;
    //   8: new 73	java/lang/StringBuilder
    //   11: dup
    //   12: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   15: ldc 77
    //   17: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: aload_0
    //   21: getfield 84	com/threatmetrix/TrustDefenderMobile/HttpConfigRunner:m_url	Ljava/lang/String;
    //   24: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: ldc 86
    //   29: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: aload_0
    //   33: getfield 90	com/threatmetrix/TrustDefenderMobile/HttpConfigRunner:m_params	Lcom/threatmetrix/TrustDefenderMobile/HttpParameterMap;
    //   36: invokevirtual 96	com/threatmetrix/TrustDefenderMobile/HttpParameterMap:getUrlEncodedParamString	()Ljava/lang/String;
    //   39: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: invokestatic 105	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   48: pop
    //   49: aload_0
    //   50: invokespecial 107	com/threatmetrix/TrustDefenderMobile/HttpRunner:run	()V
    //   53: aload_0
    //   54: invokevirtual 111	com/threatmetrix/TrustDefenderMobile/HttpConfigRunner:getHttpStatusCode	()I
    //   57: sipush 200
    //   60: if_icmpne +41 -> 101
    //   63: aload_0
    //   64: new 57	com/threatmetrix/TrustDefenderMobile/TDConfiguration
    //   67: dup
    //   68: invokespecial 112	com/threatmetrix/TrustDefenderMobile/TDConfiguration:<init>	()V
    //   71: putfield 34	com/threatmetrix/TrustDefenderMobile/HttpConfigRunner:m_config	Lcom/threatmetrix/TrustDefenderMobile/TDConfiguration;
    //   74: aload_0
    //   75: getfield 44	com/threatmetrix/TrustDefenderMobile/HttpConfigRunner:m_connection	Lcom/threatmetrix/TrustDefenderMobile/TDURLConnection;
    //   78: invokeinterface 116 1 0
    //   83: astore_1
    //   84: aload_0
    //   85: getfield 34	com/threatmetrix/TrustDefenderMobile/HttpConfigRunner:m_config	Lcom/threatmetrix/TrustDefenderMobile/TDConfiguration;
    //   88: aload_1
    //   89: invokevirtual 120	com/threatmetrix/TrustDefenderMobile/TDConfiguration:parseConfigFromStream	(Ljava/io/InputStream;)V
    //   92: aload_0
    //   93: getfield 44	com/threatmetrix/TrustDefenderMobile/HttpConfigRunner:m_connection	Lcom/threatmetrix/TrustDefenderMobile/TDURLConnection;
    //   96: invokeinterface 123 1 0
    //   101: return
    //   102: astore_1
    //   103: aload_0
    //   104: getfield 36	com/threatmetrix/TrustDefenderMobile/HttpConfigRunner:m_state	Lcom/threatmetrix/TrustDefenderMobile/CancelState;
    //   107: ifnull +50 -> 157
    //   110: aload_0
    //   111: getfield 36	com/threatmetrix/TrustDefenderMobile/HttpConfigRunner:m_state	Lcom/threatmetrix/TrustDefenderMobile/CancelState;
    //   114: invokeinterface 128 1 0
    //   119: ifeq +38 -> 157
    //   122: getstatic 20	com/threatmetrix/TrustDefenderMobile/HttpConfigRunner:TAG	Ljava/lang/String;
    //   125: new 73	java/lang/StringBuilder
    //   128: dup
    //   129: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   132: ldc 77
    //   134: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: aload_0
    //   138: getfield 84	com/threatmetrix/TrustDefenderMobile/HttpConfigRunner:m_url	Ljava/lang/String;
    //   141: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: ldc -126
    //   146: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   152: invokestatic 105	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   155: pop
    //   156: return
    //   157: getstatic 20	com/threatmetrix/TrustDefenderMobile/HttpConfigRunner:TAG	Ljava/lang/String;
    //   160: new 73	java/lang/StringBuilder
    //   163: dup
    //   164: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   167: ldc 77
    //   169: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: aload_0
    //   173: getfield 84	com/threatmetrix/TrustDefenderMobile/HttpConfigRunner:m_url	Ljava/lang/String;
    //   176: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: ldc -124
    //   181: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   187: aload_1
    //   188: invokestatic 136	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   191: pop
    //   192: return
    //   193: astore_1
    //   194: aload_0
    //   195: getfield 36	com/threatmetrix/TrustDefenderMobile/HttpConfigRunner:m_state	Lcom/threatmetrix/TrustDefenderMobile/CancelState;
    //   198: ifnull +34 -> 232
    //   201: aload_0
    //   202: getfield 36	com/threatmetrix/TrustDefenderMobile/HttpConfigRunner:m_state	Lcom/threatmetrix/TrustDefenderMobile/CancelState;
    //   205: invokeinterface 128 1 0
    //   210: ifeq +22 -> 232
    //   213: getstatic 20	com/threatmetrix/TrustDefenderMobile/HttpConfigRunner:TAG	Ljava/lang/String;
    //   216: ldc -118
    //   218: invokestatic 105	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   221: pop
    //   222: aload_0
    //   223: getfield 44	com/threatmetrix/TrustDefenderMobile/HttpConfigRunner:m_connection	Lcom/threatmetrix/TrustDefenderMobile/TDURLConnection;
    //   226: invokeinterface 123 1 0
    //   231: return
    //   232: getstatic 20	com/threatmetrix/TrustDefenderMobile/HttpConfigRunner:TAG	Ljava/lang/String;
    //   235: ldc -116
    //   237: aload_1
    //   238: invokestatic 136	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   241: pop
    //   242: goto -20 -> 222
    //   245: astore_1
    //   246: aload_0
    //   247: getfield 44	com/threatmetrix/TrustDefenderMobile/HttpConfigRunner:m_connection	Lcom/threatmetrix/TrustDefenderMobile/TDURLConnection;
    //   250: invokeinterface 123 1 0
    //   255: aload_1
    //   256: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	257	0	this	HttpConfigRunner
    //   83	6	1	localInputStream	java.io.InputStream
    //   102	86	1	localInterruptedException	InterruptedException
    //   193	45	1	localIOException	java.io.IOException
    //   245	11	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   5	49	102	java/lang/InterruptedException
    //   74	92	193	java/io/IOException
    //   74	92	245	finally
    //   194	222	245	finally
    //   232	242	245	finally
  }
}

/* Location:
 * Qualified Name:     com.threatmetrix.TrustDefenderMobile.HttpConfigRunner
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */