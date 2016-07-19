package com.threatmetrix.TrustDefenderMobile;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class NativeGatherer$NativeGathererHelper
{
  private final String TAG = StringUtils.getLogTag(NativeGathererHelper.class);
  String[] m_apkPaths = { "/system/app", "/system/priv-app" };
  boolean m_available = false;
  private final Lock m_initLock = new ReentrantLock();
  int m_packagesFound = 0;
  
  static
  {
    if (!NativeGatherer.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  NativeGatherer$NativeGathererHelper(NativeGatherer paramNativeGatherer) {}
  
  native int cancel();
  
  native String[] checkURLs(String[] paramArrayOfString);
  
  protected void finalize()
    throws Throwable
  {
    super.finalize();
    finit();
  }
  
  native String[] findAllProcs();
  
  native String[] findInstalledProcs();
  
  native int findPackages(int paramInt1, int paramInt2, String[] paramArrayOfString, int paramInt3);
  
  native String[] findRunningProcs();
  
  native void finit();
  
  native String getBinaryArch();
  
  native String getConfig(String paramString);
  
  native String[] getFontList(String paramString);
  
  native String[] getNetworkInfo();
  
  native String getRandomString(int paramInt);
  
  native String hashFile(String paramString);
  
  native boolean init(int paramInt, String paramString);
  
  /* Error */
  boolean init(android.content.Context paramContext)
  {
    // Byte code:
    //   0: getstatic 30	com/threatmetrix/TrustDefenderMobile/NativeGatherer$NativeGathererHelper:$assertionsDisabled	Z
    //   3: ifne +15 -> 18
    //   6: aload_1
    //   7: ifnonnull +11 -> 18
    //   10: new 98	java/lang/AssertionError
    //   13: dup
    //   14: invokespecial 99	java/lang/AssertionError:<init>	()V
    //   17: athrow
    //   18: aload_0
    //   19: getfield 47	com/threatmetrix/TrustDefenderMobile/NativeGatherer$NativeGathererHelper:m_available	Z
    //   22: ifeq +8 -> 30
    //   25: aload_0
    //   26: getfield 47	com/threatmetrix/TrustDefenderMobile/NativeGatherer$NativeGathererHelper:m_available	Z
    //   29: ireturn
    //   30: aload_0
    //   31: getfield 62	com/threatmetrix/TrustDefenderMobile/NativeGatherer$NativeGathererHelper:m_initLock	Ljava/util/concurrent/locks/Lock;
    //   34: invokeinterface 104 1 0
    //   39: aload_0
    //   40: getfield 47	com/threatmetrix/TrustDefenderMobile/NativeGatherer$NativeGathererHelper:m_available	Z
    //   43: ifeq +19 -> 62
    //   46: aload_0
    //   47: getfield 47	com/threatmetrix/TrustDefenderMobile/NativeGatherer$NativeGathererHelper:m_available	Z
    //   50: istore_2
    //   51: aload_0
    //   52: getfield 62	com/threatmetrix/TrustDefenderMobile/NativeGatherer$NativeGathererHelper:m_initLock	Ljava/util/concurrent/locks/Lock;
    //   55: invokeinterface 107 1 0
    //   60: iload_2
    //   61: ireturn
    //   62: ldc 109
    //   64: invokestatic 115	java/lang/System:loadLibrary	(Ljava/lang/String;)V
    //   67: aload_1
    //   68: invokevirtual 121	android/content/Context:getFilesDir	()Ljava/io/File;
    //   71: invokevirtual 126	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   74: astore_1
    //   75: aload_0
    //   76: aload_0
    //   77: getstatic 132	com/threatmetrix/TrustDefenderMobile/TrustDefenderMobileVersion:numeric	Ljava/lang/Integer;
    //   80: invokevirtual 137	java/lang/Integer:intValue	()I
    //   83: aload_1
    //   84: invokevirtual 139	com/threatmetrix/TrustDefenderMobile/NativeGatherer$NativeGathererHelper:init	(ILjava/lang/String;)Z
    //   87: putfield 47	com/threatmetrix/TrustDefenderMobile/NativeGatherer$NativeGathererHelper:m_available	Z
    //   90: aload_0
    //   91: getfield 45	com/threatmetrix/TrustDefenderMobile/NativeGatherer$NativeGathererHelper:TAG	Ljava/lang/String;
    //   94: new 141	java/lang/StringBuilder
    //   97: dup
    //   98: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   101: ldc -112
    //   103: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: aload_0
    //   107: getfield 49	com/threatmetrix/TrustDefenderMobile/NativeGatherer$NativeGathererHelper:m_packagesFound	I
    //   110: invokevirtual 151	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   113: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   116: invokestatic 160	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   119: pop
    //   120: aload_0
    //   121: getfield 62	com/threatmetrix/TrustDefenderMobile/NativeGatherer$NativeGathererHelper:m_initLock	Ljava/util/concurrent/locks/Lock;
    //   124: invokeinterface 107 1 0
    //   129: aload_0
    //   130: getfield 47	com/threatmetrix/TrustDefenderMobile/NativeGatherer$NativeGathererHelper:m_available	Z
    //   133: ireturn
    //   134: astore_1
    //   135: aload_0
    //   136: iconst_0
    //   137: putfield 47	com/threatmetrix/TrustDefenderMobile/NativeGatherer$NativeGathererHelper:m_available	Z
    //   140: goto -50 -> 90
    //   143: astore_1
    //   144: aload_0
    //   145: getfield 62	com/threatmetrix/TrustDefenderMobile/NativeGatherer$NativeGathererHelper:m_initLock	Ljava/util/concurrent/locks/Lock;
    //   148: invokeinterface 107 1 0
    //   153: aload_1
    //   154: athrow
    //   155: astore_1
    //   156: aload_0
    //   157: getfield 45	com/threatmetrix/TrustDefenderMobile/NativeGatherer$NativeGathererHelper:TAG	Ljava/lang/String;
    //   160: ldc -94
    //   162: aload_1
    //   163: invokestatic 166	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   166: pop
    //   167: goto -77 -> 90
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	170	0	this	NativeGathererHelper
    //   0	170	1	paramContext	android.content.Context
    //   50	11	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   62	90	134	java/lang/UnsatisfiedLinkError
    //   30	51	143	finally
    //   62	90	143	finally
    //   90	120	143	finally
    //   135	140	143	finally
    //   156	167	143	finally
    //   62	90	155	java/lang/Throwable
  }
  
  native String md5(String paramString);
  
  native int setConfig(String paramString1, String paramString2);
  
  native String sha1(String paramString);
  
  native String urlEncode(String paramString);
  
  native int waitUntilCancelled();
  
  native String xor(String paramString1, String paramString2);
}

/* Location:
 * Qualified Name:     com.threatmetrix.TrustDefenderMobile.NativeGatherer.NativeGathererHelper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */