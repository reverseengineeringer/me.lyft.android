package me.lyft.android.infrastructure.api;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class UrlBuilder
{
  private StringBuilder queryParams;
  private String url;
  
  public UrlBuilder(String paramString)
  {
    url = paramString;
  }
  
  private UrlBuilder addPathParam(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (paramString1 == null) {
      throw new IllegalArgumentException("Path replacement name must not be null.");
    }
    if (paramString2 == null) {
      throw new IllegalArgumentException("Path replacement \"" + paramString1 + "\" value must not be null.");
    }
    if (paramBoolean) {}
    try
    {
      String str = URLEncoder.encode(paramString2, "UTF-8").replace("+", "%20");
      url = url.replace("{" + paramString1 + "}", str);
      return this;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      throw new RuntimeException("Unable to convert path parameter \"" + paramString1 + "\" value to UTF-8:" + paramString2, localUnsupportedEncodingException);
    }
    url = url.replace("{" + paramString1 + "}", paramString2);
    return this;
  }
  
  public UrlBuilder addEncodedPathParam(String paramString1, String paramString2)
  {
    return addPathParam(paramString1, paramString2, false);
  }
  
  public UrlBuilder addEncodedQueryParam(String paramString1, String paramString2)
  {
    return addQueryParam(paramString1, paramString2, false);
  }
  
  public UrlBuilder addPathParam(String paramString1, String paramString2)
  {
    return addPathParam(paramString1, paramString2, true);
  }
  
  public UrlBuilder addQueryParam(String paramString1, String paramString2)
  {
    return addQueryParam(paramString1, paramString2, true);
  }
  
  /* Error */
  public UrlBuilder addQueryParam(String paramString1, String paramString2, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +13 -> 14
    //   4: new 22	java/lang/IllegalArgumentException
    //   7: dup
    //   8: ldc 82
    //   10: invokespecial 26	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   13: athrow
    //   14: aload_2
    //   15: ifnonnull +35 -> 50
    //   18: new 22	java/lang/IllegalArgumentException
    //   21: dup
    //   22: new 28	java/lang/StringBuilder
    //   25: dup
    //   26: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   29: ldc 84
    //   31: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: aload_1
    //   35: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: ldc 37
    //   40: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   46: invokespecial 26	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   49: athrow
    //   50: aload_2
    //   51: astore 5
    //   53: iload_3
    //   54: ifeq +14 -> 68
    //   57: aload_2
    //   58: astore 6
    //   60: aload_2
    //   61: ldc 43
    //   63: invokestatic 49	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   66: astore 5
    //   68: aload 5
    //   70: astore 6
    //   72: aload_0
    //   73: getfield 86	me/lyft/android/infrastructure/api/UrlBuilder:queryParams	Ljava/lang/StringBuilder;
    //   76: astore 7
    //   78: aload 7
    //   80: astore_2
    //   81: aload 7
    //   83: ifnonnull +24 -> 107
    //   86: aload 5
    //   88: astore 6
    //   90: new 28	java/lang/StringBuilder
    //   93: dup
    //   94: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   97: astore_2
    //   98: aload 5
    //   100: astore 6
    //   102: aload_0
    //   103: aload_2
    //   104: putfield 86	me/lyft/android/infrastructure/api/UrlBuilder:queryParams	Ljava/lang/StringBuilder;
    //   107: aload 5
    //   109: astore 6
    //   111: aload_2
    //   112: invokevirtual 90	java/lang/StringBuilder:length	()I
    //   115: ifle +40 -> 155
    //   118: bipush 38
    //   120: istore 4
    //   122: aload 5
    //   124: astore 6
    //   126: aload_2
    //   127: iload 4
    //   129: invokevirtual 93	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   132: pop
    //   133: aload 5
    //   135: astore 6
    //   137: aload_2
    //   138: aload_1
    //   139: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: bipush 61
    //   144: invokevirtual 93	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   147: aload 5
    //   149: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: pop
    //   153: aload_0
    //   154: areturn
    //   155: bipush 63
    //   157: istore 4
    //   159: goto -37 -> 122
    //   162: astore_2
    //   163: new 65	java/lang/RuntimeException
    //   166: dup
    //   167: new 28	java/lang/StringBuilder
    //   170: dup
    //   171: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   174: ldc 95
    //   176: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: aload_1
    //   180: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: ldc 97
    //   185: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: aload 6
    //   190: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   196: aload_2
    //   197: invokespecial 72	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   200: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	201	0	this	UrlBuilder
    //   0	201	1	paramString1	String
    //   0	201	2	paramString2	String
    //   0	201	3	paramBoolean	boolean
    //   120	38	4	c	char
    //   51	97	5	str1	String
    //   58	131	6	str2	String
    //   76	6	7	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   60	68	162	java/io/UnsupportedEncodingException
    //   72	78	162	java/io/UnsupportedEncodingException
    //   90	98	162	java/io/UnsupportedEncodingException
    //   102	107	162	java/io/UnsupportedEncodingException
    //   111	118	162	java/io/UnsupportedEncodingException
    //   126	133	162	java/io/UnsupportedEncodingException
    //   137	153	162	java/io/UnsupportedEncodingException
  }
  
  public String build()
  {
    if (queryParams != null) {
      url += queryParams.toString();
    }
    return url;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.api.UrlBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */