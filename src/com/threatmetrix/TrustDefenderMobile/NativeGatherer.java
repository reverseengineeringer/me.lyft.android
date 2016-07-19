package com.threatmetrix.TrustDefenderMobile;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class NativeGatherer
{
  private static final String TAG;
  private static volatile NativeGatherer s_gatherer;
  private static final Lock s_lock;
  private String[] m_appList = null;
  private NativeGathererHelper m_gathererHelper = new NativeGathererHelper();
  private long m_lastAPKScanTime = 0L;
  
  static
  {
    if (!NativeGatherer.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      TAG = StringUtils.getLogTag(NativeGatherer.class);
      s_lock = new ReentrantLock();
      return;
    }
  }
  
  private String[] findAPKPaths(Context paramContext)
  {
    if ((m_appList != null) && (TimeUnit.SECONDS.convert(System.nanoTime() - m_lastAPKScanTime, TimeUnit.NANOSECONDS) < 60L)) {
      return m_appList;
    }
    Log.d(TAG, "Starting path find for apk");
    m_lastAPKScanTime = System.nanoTime();
    Object localObject = paramContext.getPackageManager().getInstalledApplications(0);
    paramContext = new ArrayList(((List)localObject).size());
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      ApplicationInfo localApplicationInfo = (ApplicationInfo)((Iterator)localObject).next();
      if ((!sourceDir.startsWith("/system/app")) && (!sourceDir.startsWith("/system/priv-app"))) {
        paramContext.add(sourceDir);
      }
    }
    paramContext.add("/system/app");
    paramContext.add("/system/priv-app");
    Log.d(TAG, "findAPKPaths found : " + paramContext.size());
    m_appList = ((String[])paramContext.toArray(new String[paramContext.size()]));
    return m_appList;
  }
  
  public static NativeGatherer getInstance()
  {
    if (s_gatherer == null) {}
    try
    {
      s_lock.lock();
      if (s_gatherer == null) {
        s_gatherer = new NativeGatherer();
      }
      return s_gatherer;
    }
    finally
    {
      s_lock.unlock();
    }
  }
  
  public int cancel()
  {
    try
    {
      if (m_gathererHelper.m_available)
      {
        int i = m_gathererHelper.cancel();
        return i;
      }
    }
    catch (Throwable localThrowable)
    {
      Log.e(TAG, "Native code:", localThrowable);
    }
    return -1;
  }
  
  public String[] checkURLs(String[] paramArrayOfString)
    throws InterruptedException
  {
    try
    {
      String str2 = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      if (m_gathererHelper.m_available) {}
      for (String str1 = " available ";; str1 = "not available ")
      {
        Log.d(str2, str1 + " Found " + m_gathererHelper.m_packagesFound);
        if ((!m_gathererHelper.m_available) || (paramArrayOfString == null)) {
          break;
        }
        paramArrayOfString = m_gathererHelper.checkURLs(paramArrayOfString);
        if (!Thread.interrupted()) {
          return paramArrayOfString;
        }
        Log.d(TAG, "Thread interrupt detected, throwing");
        throw new InterruptedException();
      }
    }
    catch (Throwable paramArrayOfString)
    {
      Log.e(TAG, "Native code:", paramArrayOfString);
    }
    finally
    {
      if (Thread.interrupted())
      {
        Log.d(TAG, "Thread interrupt detected, throwing");
        throw new InterruptedException();
      }
    }
    paramArrayOfString = null;
    return paramArrayOfString;
  }
  
  public String[] findAllProcs()
    throws InterruptedException
  {
    try
    {
      if (m_gathererHelper.m_available)
      {
        String[] arrayOfString1 = m_gathererHelper.findAllProcs();
        if (!Thread.interrupted()) {
          return ???;
        }
        Log.d(TAG, "Thread interrupt detected, throwing");
        throw new InterruptedException();
      }
    }
    catch (Throwable localThrowable)
    {
      Log.e(TAG, "Native code:", localThrowable);
    }
    finally
    {
      if (Thread.interrupted())
      {
        Log.d(TAG, "Thread interrupt detected, throwing");
        throw new InterruptedException();
      }
    }
    String[] arrayOfString2 = null;
    return arrayOfString2;
  }
  
  public String[] findInstalledProcs()
    throws InterruptedException
  {
    try
    {
      if (m_gathererHelper.m_available)
      {
        String[] arrayOfString1 = m_gathererHelper.findInstalledProcs();
        if (!Thread.interrupted()) {
          return ???;
        }
        Log.d(TAG, "Thread interrupt detected, throwing");
        throw new InterruptedException();
      }
    }
    catch (Throwable localThrowable)
    {
      Log.e(TAG, "Native code:", localThrowable);
    }
    finally
    {
      if (Thread.interrupted())
      {
        Log.d(TAG, "Thread interrupt detected, throwing");
        throw new InterruptedException();
      }
    }
    String[] arrayOfString2 = null;
    return arrayOfString2;
  }
  
  public int findPackages(Context paramContext, int paramInt1, int paramInt2, int paramInt3)
    throws InterruptedException
  {
    assert (paramContext != null);
    int j = 0;
    int i = 0;
    try
    {
      if (m_gathererHelper.m_available)
      {
        m_gathererHelper.m_apkPaths = findAPKPaths(paramContext);
        i = m_gathererHelper.findPackages(paramInt2, paramInt3, m_gathererHelper.m_apkPaths, paramInt1);
      }
    }
    catch (Throwable paramContext)
    {
      Log.e(TAG, "Native code:", paramContext);
      i = j;
    }
    finally
    {
      if (Thread.interrupted())
      {
        Log.d(TAG, "Thread interrupt detected, throwing");
        throw new InterruptedException();
      }
    }
    return i;
  }
  
  public String[] findRunningProcs()
    throws InterruptedException
  {
    try
    {
      if (m_gathererHelper.m_available)
      {
        String[] arrayOfString1 = m_gathererHelper.findRunningProcs();
        if (!Thread.interrupted()) {
          return ???;
        }
        Log.d(TAG, "Thread interrupt detected, throwing");
        throw new InterruptedException();
      }
    }
    catch (Throwable localThrowable)
    {
      Log.e(TAG, "Native code:", localThrowable);
    }
    finally
    {
      if (Thread.interrupted())
      {
        Log.d(TAG, "Thread interrupt detected, throwing");
        throw new InterruptedException();
      }
    }
    String[] arrayOfString2 = null;
    return arrayOfString2;
  }
  
  public String getBinaryArch()
  {
    try
    {
      if (m_gathererHelper.m_available)
      {
        String str = m_gathererHelper.getBinaryArch();
        return str;
      }
    }
    catch (Throwable localThrowable)
    {
      Log.e(TAG, "Native code:", localThrowable);
    }
    return null;
  }
  
  public String getConfig(String paramString)
    throws InterruptedException
  {
    try
    {
      if ((m_gathererHelper.m_available) && (paramString != null))
      {
        paramString = m_gathererHelper.getConfig(paramString);
        if (!Thread.interrupted()) {
          return paramString;
        }
        Log.d(TAG, "Thread interrupt detected, throwing");
        throw new InterruptedException();
      }
    }
    catch (Throwable paramString)
    {
      Log.e(TAG, "Native code:", paramString);
    }
    finally
    {
      if (Thread.interrupted())
      {
        Log.d(TAG, "Thread interrupt detected, throwing");
        throw new InterruptedException();
      }
    }
    paramString = null;
    return paramString;
  }
  
  public List<String> getFontList(String paramString)
    throws InterruptedException
  {
    try
    {
      if ((m_gathererHelper.m_available) && (paramString != null))
      {
        paramString = m_gathererHelper.getFontList(paramString);
        if (paramString != null)
        {
          paramString = Arrays.asList(paramString);
          if (!Thread.interrupted()) {
            return paramString;
          }
          Log.d(TAG, "Thread interrupt detected, throwing");
          throw new InterruptedException();
        }
        paramString = new ArrayList();
        if (!Thread.interrupted()) {
          return paramString;
        }
        Log.d(TAG, "Thread interrupt detected, throwing");
        throw new InterruptedException();
      }
    }
    catch (Throwable paramString)
    {
      Log.e(TAG, "Native code:", paramString);
    }
    finally
    {
      if (Thread.interrupted())
      {
        Log.d(TAG, "Thread interrupt detected, throwing");
        throw new InterruptedException();
      }
    }
    paramString = null;
    return paramString;
  }
  
  public String[] getNetworkInfo()
  {
    try
    {
      if (m_gathererHelper.m_available)
      {
        String[] arrayOfString = m_gathererHelper.getNetworkInfo();
        return arrayOfString;
      }
    }
    catch (Throwable localThrowable)
    {
      Log.e(TAG, "Native code:", localThrowable);
    }
    return null;
  }
  
  public String getRandomString(int paramInt)
    throws InterruptedException
  {
    try
    {
      if ((m_gathererHelper.m_available) && (paramInt > 0))
      {
        String str1 = m_gathererHelper.getRandomString(paramInt);
        if (!Thread.interrupted()) {
          return ???;
        }
        Log.d(TAG, "Thread interrupt detected, throwing");
        throw new InterruptedException();
      }
    }
    catch (Throwable localThrowable)
    {
      Log.e(TAG, "Native code:", localThrowable);
    }
    finally
    {
      if (Thread.interrupted())
      {
        Log.d(TAG, "Thread interrupt detected, throwing");
        throw new InterruptedException();
      }
    }
    String str2 = null;
    return str2;
  }
  
  public String hashFile(String paramString)
    throws InterruptedException
  {
    try
    {
      if ((m_gathererHelper.m_available) && (paramString != null))
      {
        paramString = m_gathererHelper.hashFile(paramString);
        if (!Thread.interrupted()) {
          return paramString;
        }
        Log.d(TAG, "Thread interrupt detected, throwing");
        throw new InterruptedException();
      }
    }
    catch (Throwable paramString)
    {
      Log.e(TAG, "Native code:", paramString);
    }
    finally
    {
      if (Thread.interrupted())
      {
        Log.d(TAG, "Thread interrupt detected, throwing");
        throw new InterruptedException();
      }
    }
    paramString = null;
    return paramString;
  }
  
  public boolean init(Context paramContext)
  {
    return m_gathererHelper.init(paramContext);
  }
  
  public boolean isAvailable()
  {
    return m_gathererHelper.m_available;
  }
  
  public String md5(String paramString)
    throws InterruptedException
  {
    try
    {
      if ((m_gathererHelper.m_available) && (paramString != null))
      {
        paramString = m_gathererHelper.md5(paramString);
        if (!Thread.interrupted()) {
          return paramString;
        }
        Log.d(TAG, "Thread interrupt detected, throwing");
        throw new InterruptedException();
      }
    }
    catch (Throwable paramString)
    {
      Log.e(TAG, "Native code:", paramString);
    }
    finally
    {
      if (Thread.interrupted())
      {
        Log.d(TAG, "Thread interrupt detected, throwing");
        throw new InterruptedException();
      }
    }
    paramString = null;
    return paramString;
  }
  
  public int setConfig(String paramString1, String paramString2)
    throws InterruptedException
  {
    try
    {
      if ((m_gathererHelper.m_available) && (paramString1 != null) && (paramString2 != null))
      {
        i = m_gathererHelper.setConfig(paramString1, paramString2);
        if (!Thread.interrupted()) {
          return i;
        }
        Log.d(TAG, "Thread interrupt detected, throwing");
        throw new InterruptedException();
      }
    }
    catch (Throwable paramString1)
    {
      Log.e(TAG, "Native code:", paramString1);
    }
    finally
    {
      if (Thread.interrupted())
      {
        Log.d(TAG, "Thread interrupt detected, throwing");
        throw new InterruptedException();
      }
    }
    int i = -1;
    return i;
  }
  
  public String sha1(String paramString)
    throws InterruptedException
  {
    try
    {
      if ((m_gathererHelper.m_available) && (paramString != null))
      {
        paramString = m_gathererHelper.sha1(paramString);
        if (!Thread.interrupted()) {
          return paramString;
        }
        Log.d(TAG, "Thread interrupt detected, throwing");
        throw new InterruptedException();
      }
    }
    catch (Throwable paramString)
    {
      Log.e(TAG, "Native code:", paramString);
    }
    finally
    {
      if (Thread.interrupted())
      {
        Log.d(TAG, "Thread interrupt detected, throwing");
        throw new InterruptedException();
      }
    }
    paramString = null;
    return paramString;
  }
  
  public String urlEncode(String paramString)
    throws InterruptedException
  {
    try
    {
      if ((m_gathererHelper.m_available) && (paramString != null))
      {
        paramString = m_gathererHelper.urlEncode(paramString);
        if (!Thread.interrupted()) {
          return paramString;
        }
        Log.d(TAG, "Thread interrupt detected, throwing");
        throw new InterruptedException();
      }
    }
    catch (Throwable paramString)
    {
      Log.e(TAG, "Native code:", paramString);
    }
    finally
    {
      if (Thread.interrupted())
      {
        Log.d(TAG, "Thread interrupt detected, throwing");
        throw new InterruptedException();
      }
    }
    paramString = null;
    return paramString;
  }
  
  public int waitUntilCancelled()
  {
    try
    {
      if (m_gathererHelper.m_available)
      {
        int i = m_gathererHelper.waitUntilCancelled();
        return i;
      }
    }
    catch (Throwable localThrowable)
    {
      Log.e(TAG, "Native code:", localThrowable);
    }
    return -1;
  }
  
  public String xor(String paramString1, String paramString2)
    throws InterruptedException
  {
    try
    {
      if ((m_gathererHelper.m_available) && (paramString2 != null) && (paramString1 != null) && (paramString2.length() > 0) && (!paramString1.isEmpty()))
      {
        paramString1 = m_gathererHelper.xor(paramString1, paramString2);
        if (!Thread.interrupted()) {
          return paramString1;
        }
        Log.d(TAG, "Thread interrupt detected, throwing");
        throw new InterruptedException();
      }
    }
    catch (Throwable paramString1)
    {
      Log.e(TAG, "Native code:", paramString1);
    }
    finally
    {
      if (Thread.interrupted())
      {
        Log.d(TAG, "Thread interrupt detected, throwing");
        throw new InterruptedException();
      }
    }
    paramString1 = null;
    return paramString1;
  }
  
  private class NativeGathererHelper
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
    
    NativeGathererHelper() {}
    
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
    boolean init(Context paramContext)
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
      //   0	170	1	paramContext	Context
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
}

/* Location:
 * Qualified Name:     com.threatmetrix.TrustDefenderMobile.NativeGatherer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */