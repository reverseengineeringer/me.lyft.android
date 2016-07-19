package com.threatmetrix.TrustDefenderMobile;

import android.util.Log;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

class ProfileState
  implements CancelState
{
  private static final String TAG = StringUtils.getLogTag(ProfileState.class);
  boolean m_cancelled = false;
  CountDownLatch m_initLatch = null;
  boolean m_inited = false;
  private final ReentrantReadWriteLock m_lock = new ReentrantReadWriteLock();
  boolean m_profiling = false;
  boolean m_scanCancelled = false;
  CountDownLatch m_scanLatch = null;
  boolean m_scanning = false;
  
  boolean endCancelling()
  {
    m_lock.writeLock().lock();
    try
    {
      if (m_cancelled)
      {
        m_cancelled = false;
        m_scanCancelled = false;
        return true;
      }
      return false;
    }
    finally
    {
      m_lock.writeLock().unlock();
    }
  }
  
  void endInitialising()
  {
    m_lock.readLock().lock();
    try
    {
      CountDownLatch localCountDownLatch = m_initLatch;
      m_lock.readLock().unlock();
      if (localCountDownLatch != null) {
        localCountDownLatch.countDown();
      }
      return;
    }
    finally
    {
      m_lock.readLock().unlock();
    }
  }
  
  void endProfiling()
  {
    m_lock.writeLock().lock();
    try
    {
      m_profiling = false;
      return;
    }
    finally
    {
      m_lock.writeLock().unlock();
    }
  }
  
  void endScanning()
  {
    CountDownLatch localCountDownLatch = null;
    m_lock.readLock().lock();
    try
    {
      if (m_scanning)
      {
        m_scanning = false;
        m_scanCancelled = false;
        localCountDownLatch = m_scanLatch;
      }
      m_lock.readLock().unlock();
      if (localCountDownLatch != null) {
        localCountDownLatch.countDown();
      }
      return;
    }
    finally
    {
      m_lock.readLock().unlock();
    }
  }
  
  public boolean isCancelled()
  {
    m_lock.readLock().lock();
    try
    {
      boolean bool = m_cancelled;
      return bool;
    }
    finally
    {
      m_lock.readLock().unlock();
    }
  }
  
  /* Error */
  boolean isInitFinished()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 38	com/threatmetrix/TrustDefenderMobile/ProfileState:m_lock	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   4: invokevirtual 71	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   7: invokevirtual 74	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:lock	()V
    //   10: aload_0
    //   11: getfield 40	com/threatmetrix/TrustDefenderMobile/ProfileState:m_inited	Z
    //   14: ifeq +31 -> 45
    //   17: aload_0
    //   18: getfield 50	com/threatmetrix/TrustDefenderMobile/ProfileState:m_initLatch	Ljava/util/concurrent/CountDownLatch;
    //   21: invokevirtual 88	java/util/concurrent/CountDownLatch:getCount	()J
    //   24: lstore_1
    //   25: lload_1
    //   26: lconst_0
    //   27: lcmp
    //   28: ifne +17 -> 45
    //   31: iconst_1
    //   32: istore_3
    //   33: aload_0
    //   34: getfield 38	com/threatmetrix/TrustDefenderMobile/ProfileState:m_lock	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   37: invokevirtual 71	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   40: invokevirtual 75	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   43: iload_3
    //   44: ireturn
    //   45: iconst_0
    //   46: istore_3
    //   47: goto -14 -> 33
    //   50: astore 4
    //   52: aload_0
    //   53: getfield 38	com/threatmetrix/TrustDefenderMobile/ProfileState:m_lock	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   56: invokevirtual 71	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   59: invokevirtual 75	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   62: aload 4
    //   64: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	65	0	this	ProfileState
    //   24	2	1	l	long
    //   32	15	3	bool	boolean
    //   50	13	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   10	25	50	finally
  }
  
  boolean isInitInProgress()
  {
    CountDownLatch localCountDownLatch = null;
    m_lock.readLock().lock();
    try
    {
      if (m_inited) {
        localCountDownLatch = m_initLatch;
      }
      m_lock.readLock().unlock();
      if ((localCountDownLatch != null) && (localCountDownLatch.getCount() > 0L)) {
        return true;
      }
    }
    finally
    {
      m_lock.readLock().unlock();
    }
    return false;
  }
  
  boolean isInited()
  {
    m_lock.readLock().lock();
    try
    {
      boolean bool = m_inited;
      return bool;
    }
    finally
    {
      m_lock.readLock().unlock();
    }
  }
  
  boolean isProfiling()
  {
    m_lock.readLock().lock();
    try
    {
      boolean bool = m_profiling;
      return bool;
    }
    finally
    {
      m_lock.readLock().unlock();
    }
  }
  
  boolean isScanInProgress()
  {
    CountDownLatch localCountDownLatch = null;
    m_lock.readLock().lock();
    try
    {
      if (m_scanning) {
        localCountDownLatch = m_scanLatch;
      }
      m_lock.readLock().unlock();
      if ((localCountDownLatch != null) && (localCountDownLatch.getCount() > 0L)) {
        return true;
      }
    }
    finally
    {
      m_lock.readLock().unlock();
    }
    return false;
  }
  
  void reset()
  {
    m_lock.writeLock().lock();
    try
    {
      m_inited = false;
      m_profiling = false;
      m_scanning = false;
      m_scanCancelled = false;
      m_cancelled = false;
      return;
    }
    finally
    {
      m_lock.writeLock().unlock();
    }
  }
  
  boolean startCancelling()
  {
    m_lock.writeLock().lock();
    try
    {
      if (!m_cancelled)
      {
        m_cancelled = true;
        return true;
      }
      return false;
    }
    finally
    {
      m_lock.writeLock().unlock();
    }
  }
  
  boolean startCancellingScan()
  {
    Log.d(TAG, "Attempting to cancel doPackageScan");
    m_lock.writeLock().lock();
    try
    {
      if (!m_scanCancelled)
      {
        m_scanCancelled = true;
        return true;
      }
      return false;
    }
    finally
    {
      m_lock.writeLock().unlock();
    }
  }
  
  boolean startInitialising()
  {
    m_lock.writeLock().lock();
    try
    {
      if (!m_inited)
      {
        m_inited = true;
        m_initLatch = new CountDownLatch(1);
        return true;
      }
      return false;
    }
    finally
    {
      m_lock.writeLock().unlock();
    }
  }
  
  boolean startProfiling()
  {
    m_lock.writeLock().lock();
    try
    {
      if (!m_profiling)
      {
        m_profiling = true;
        m_cancelled = false;
        return true;
      }
      return false;
    }
    finally
    {
      m_lock.writeLock().unlock();
    }
  }
  
  boolean startScanning(boolean paramBoolean)
  {
    m_lock.writeLock().lock();
    for (;;)
    {
      try
      {
        if (!m_scanning)
        {
          if ((paramBoolean) && (!m_profiling))
          {
            if (m_scanCancelled)
            {
              Log.d(TAG, "startScanning: aborted, marked as cancelled");
              m_scanCancelled = false;
              return false;
            }
            m_scanning = true;
            m_scanLatch = new CountDownLatch(1);
            return true;
          }
        }
        else {
          return false;
        }
      }
      finally
      {
        m_lock.writeLock().unlock();
      }
      if (paramBoolean) {}
    }
  }
  
  /* Error */
  boolean waitForInit(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 38	com/threatmetrix/TrustDefenderMobile/ProfileState:m_lock	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   4: invokevirtual 71	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   7: invokevirtual 74	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:lock	()V
    //   10: aload_0
    //   11: getfield 40	com/threatmetrix/TrustDefenderMobile/ProfileState:m_inited	Z
    //   14: ifeq +10 -> 24
    //   17: aload_0
    //   18: getfield 50	com/threatmetrix/TrustDefenderMobile/ProfileState:m_initLatch	Ljava/util/concurrent/CountDownLatch;
    //   21: ifnonnull +26 -> 47
    //   24: getstatic 29	com/threatmetrix/TrustDefenderMobile/ProfileState:TAG	Ljava/lang/String;
    //   27: ldc 118
    //   29: invokestatic 103	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   32: pop
    //   33: iconst_1
    //   34: istore_3
    //   35: aload_0
    //   36: getfield 38	com/threatmetrix/TrustDefenderMobile/ProfileState:m_lock	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   39: invokevirtual 71	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   42: invokevirtual 75	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   45: iload_3
    //   46: ireturn
    //   47: aload_0
    //   48: getfield 50	com/threatmetrix/TrustDefenderMobile/ProfileState:m_initLatch	Ljava/util/concurrent/CountDownLatch;
    //   51: astore 6
    //   53: aload_0
    //   54: getfield 38	com/threatmetrix/TrustDefenderMobile/ProfileState:m_lock	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   57: invokevirtual 71	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   60: invokevirtual 75	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   63: getstatic 29	com/threatmetrix/TrustDefenderMobile/ProfileState:TAG	Ljava/lang/String;
    //   66: ldc 120
    //   68: invokestatic 103	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   71: pop
    //   72: iconst_0
    //   73: istore_3
    //   74: iload_1
    //   75: i2l
    //   76: lstore 4
    //   78: aload 6
    //   80: lload 4
    //   82: getstatic 126	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   85: invokevirtual 130	java/util/concurrent/CountDownLatch:await	(JLjava/util/concurrent/TimeUnit;)Z
    //   88: istore_2
    //   89: iload_2
    //   90: istore_3
    //   91: iload_2
    //   92: ifne -47 -> 45
    //   95: iload_2
    //   96: istore_3
    //   97: getstatic 29	com/threatmetrix/TrustDefenderMobile/ProfileState:TAG	Ljava/lang/String;
    //   100: ldc -124
    //   102: invokestatic 135	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   105: pop
    //   106: iload_2
    //   107: ireturn
    //   108: astore 6
    //   110: getstatic 29	com/threatmetrix/TrustDefenderMobile/ProfileState:TAG	Ljava/lang/String;
    //   113: ldc -119
    //   115: aload 6
    //   117: invokestatic 140	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   120: pop
    //   121: iload_3
    //   122: ireturn
    //   123: astore 6
    //   125: aload_0
    //   126: getfield 38	com/threatmetrix/TrustDefenderMobile/ProfileState:m_lock	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   129: invokevirtual 71	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   132: invokevirtual 75	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   135: aload 6
    //   137: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	138	0	this	ProfileState
    //   0	138	1	paramInt	int
    //   88	19	2	bool1	boolean
    //   34	88	3	bool2	boolean
    //   76	5	4	l	long
    //   51	28	6	localCountDownLatch	CountDownLatch
    //   108	8	6	localInterruptedException	InterruptedException
    //   123	13	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   78	89	108	java/lang/InterruptedException
    //   97	106	108	java/lang/InterruptedException
    //   10	24	123	finally
    //   24	33	123	finally
    //   47	53	123	finally
  }
  
  boolean waitForScan()
  {
    m_lock.readLock().lock();
    try
    {
      if ((!m_scanning) || (m_scanLatch == null))
      {
        Log.d(TAG, "waitForScan: No scan in progress, nothing to wait for");
        m_lock.readLock().unlock();
        return true;
      }
      CountDownLatch localCountDownLatch = m_scanLatch;
      m_lock.readLock().unlock();
      Log.d(TAG, "waitForScan: Waiting for scan to complete");
      return false;
    }
    finally
    {
      try
      {
        localCountDownLatch.await();
        return true;
      }
      catch (InterruptedException localInterruptedException)
      {
        if (isCancelled()) {
          break label108;
        }
        Log.e(TAG, "waitForScan: Waiting for scan to complete interrupted", localInterruptedException);
        return false;
        Log.d(TAG, "waitForScan: interrupted by cancel");
      }
      localObject = finally;
      m_lock.readLock().unlock();
    }
  }
}

/* Location:
 * Qualified Name:     com.threatmetrix.TrustDefenderMobile.ProfileState
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */