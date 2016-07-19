package com.threatmetrix.TrustDefenderMobile;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.util.Log;

class ApplicationInfoGatherer
{
  private static final String TAG = StringUtils.getLogTag(ApplicationInfoGatherer.class);
  
  static String checkThisPackage(Context paramContext)
    throws InterruptedException
  {
    paramContext = paramContext.getApplicationInfo();
    if (paramContext != null)
    {
      paramContext = sourceDir;
      Log.d(TAG, "sourceDir: " + paramContext);
      return getHashForPackage(paramContext);
    }
    return null;
  }
  
  /* Error */
  private static String getHashForPackage(String paramString)
    throws InterruptedException
  {
    // Byte code:
    //   0: invokestatic 71	com/threatmetrix/TrustDefenderMobile/NativeGatherer:getInstance	()Lcom/threatmetrix/TrustDefenderMobile/NativeGatherer;
    //   3: invokevirtual 75	com/threatmetrix/TrustDefenderMobile/NativeGatherer:isAvailable	()Z
    //   6: ifeq +11 -> 17
    //   9: invokestatic 71	com/threatmetrix/TrustDefenderMobile/NativeGatherer:getInstance	()Lcom/threatmetrix/TrustDefenderMobile/NativeGatherer;
    //   12: aload_0
    //   13: invokevirtual 78	com/threatmetrix/TrustDefenderMobile/NativeGatherer:hashFile	(Ljava/lang/String;)Ljava/lang/String;
    //   16: areturn
    //   17: getstatic 16	com/threatmetrix/TrustDefenderMobile/ApplicationInfoGatherer:TAG	Ljava/lang/String;
    //   20: ldc 80
    //   22: invokestatic 54	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   25: pop
    //   26: ldc 82
    //   28: invokestatic 87	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   31: astore_2
    //   32: new 89	java/io/FileInputStream
    //   35: dup
    //   36: aload_0
    //   37: invokespecial 92	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   40: astore_3
    //   41: aconst_null
    //   42: astore_0
    //   43: sipush 8192
    //   46: newarray <illegal type>
    //   48: astore 4
    //   50: aload_3
    //   51: aload 4
    //   53: invokevirtual 98	java/io/InputStream:read	([B)I
    //   56: istore_1
    //   57: iload_1
    //   58: ifle +83 -> 141
    //   61: aload_2
    //   62: aload 4
    //   64: iconst_0
    //   65: iload_1
    //   66: invokevirtual 102	java/security/MessageDigest:update	([BII)V
    //   69: goto -19 -> 50
    //   72: astore_2
    //   73: getstatic 16	com/threatmetrix/TrustDefenderMobile/ApplicationInfoGatherer:TAG	Ljava/lang/String;
    //   76: ldc 104
    //   78: aload_2
    //   79: invokestatic 108	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   82: pop
    //   83: aload_3
    //   84: invokevirtual 111	java/io/InputStream:close	()V
    //   87: getstatic 16	com/threatmetrix/TrustDefenderMobile/ApplicationInfoGatherer:TAG	Ljava/lang/String;
    //   90: new 37	java/lang/StringBuilder
    //   93: dup
    //   94: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   97: ldc 113
    //   99: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: aload_0
    //   103: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   109: invokestatic 54	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   112: pop
    //   113: aload_0
    //   114: areturn
    //   115: astore_0
    //   116: getstatic 16	com/threatmetrix/TrustDefenderMobile/ApplicationInfoGatherer:TAG	Ljava/lang/String;
    //   119: ldc 115
    //   121: aload_0
    //   122: invokestatic 108	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   125: pop
    //   126: aconst_null
    //   127: areturn
    //   128: astore_0
    //   129: getstatic 16	com/threatmetrix/TrustDefenderMobile/ApplicationInfoGatherer:TAG	Ljava/lang/String;
    //   132: ldc 117
    //   134: aload_0
    //   135: invokestatic 108	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   138: pop
    //   139: aconst_null
    //   140: areturn
    //   141: ldc 119
    //   143: iconst_1
    //   144: anewarray 4	java/lang/Object
    //   147: dup
    //   148: iconst_0
    //   149: new 121	java/math/BigInteger
    //   152: dup
    //   153: iconst_1
    //   154: aload_2
    //   155: invokevirtual 125	java/security/MessageDigest:digest	()[B
    //   158: invokespecial 128	java/math/BigInteger:<init>	(I[B)V
    //   161: bipush 16
    //   163: invokevirtual 131	java/math/BigInteger:toString	(I)Ljava/lang/String;
    //   166: aastore
    //   167: invokestatic 137	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   170: bipush 32
    //   172: bipush 48
    //   174: invokevirtual 141	java/lang/String:replace	(CC)Ljava/lang/String;
    //   177: astore_2
    //   178: aload_2
    //   179: astore_0
    //   180: aload_3
    //   181: invokevirtual 111	java/io/InputStream:close	()V
    //   184: goto -97 -> 87
    //   187: astore_2
    //   188: getstatic 16	com/threatmetrix/TrustDefenderMobile/ApplicationInfoGatherer:TAG	Ljava/lang/String;
    //   191: ldc -113
    //   193: aload_2
    //   194: invokestatic 108	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   197: pop
    //   198: goto -111 -> 87
    //   201: astore_2
    //   202: getstatic 16	com/threatmetrix/TrustDefenderMobile/ApplicationInfoGatherer:TAG	Ljava/lang/String;
    //   205: ldc -113
    //   207: aload_2
    //   208: invokestatic 108	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   211: pop
    //   212: goto -125 -> 87
    //   215: astore_0
    //   216: aload_3
    //   217: invokevirtual 111	java/io/InputStream:close	()V
    //   220: aload_0
    //   221: athrow
    //   222: astore_2
    //   223: getstatic 16	com/threatmetrix/TrustDefenderMobile/ApplicationInfoGatherer:TAG	Ljava/lang/String;
    //   226: ldc -113
    //   228: aload_2
    //   229: invokestatic 108	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   232: pop
    //   233: goto -13 -> 220
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	236	0	paramString	String
    //   56	10	1	i	int
    //   31	31	2	localMessageDigest	java.security.MessageDigest
    //   72	83	2	localIOException1	java.io.IOException
    //   177	2	2	str	String
    //   187	7	2	localIOException2	java.io.IOException
    //   201	7	2	localIOException3	java.io.IOException
    //   222	7	2	localIOException4	java.io.IOException
    //   40	177	3	localFileInputStream	java.io.FileInputStream
    //   48	15	4	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   50	57	72	java/io/IOException
    //   61	69	72	java/io/IOException
    //   141	178	72	java/io/IOException
    //   26	32	115	java/security/NoSuchAlgorithmException
    //   32	41	128	java/io/FileNotFoundException
    //   180	184	187	java/io/IOException
    //   83	87	201	java/io/IOException
    //   50	57	215	finally
    //   61	69	215	finally
    //   73	83	215	finally
    //   141	178	215	finally
    //   216	220	222	java/io/IOException
  }
}

/* Location:
 * Qualified Name:     com.threatmetrix.TrustDefenderMobile.ApplicationInfoGatherer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */