package com.threatmetrix.TrustDefenderMobile;

import android.os.StatFs;
import java.lang.reflect.Method;

class StatWrapper
  extends WrapperHelper
{
  private static final String TAG = StringUtils.getLogTag(StatWrapper.class);
  private static final Method s_getAvailableBlocks = getMethod(StatFs.class, "getAvailableBlocks", new Class[0]);
  private static final Method s_getAvailableBlocksLong = getMethod(StatFs.class, "getAvailableBlocksLong", new Class[0]);
  private static final Method s_getBlockCount = getMethod(StatFs.class, "getBlockCount", new Class[0]);
  private static final Method s_getBlockCountLong = getMethod(StatFs.class, "getBlockCountLong", new Class[0]);
  private static final Method s_getBlockSize = getMethod(StatFs.class, "getBlockSize", new Class[0]);
  private static final Method s_getBlockSizeLong = getMethod(StatFs.class, "getBlockSizeLong", new Class[0]);
  private final StatFs m_stat;
  
  public StatWrapper(String paramString)
  {
    m_stat = new StatFs(paramString);
  }
  
  public long getAvailableBlocks()
  {
    Object localObject;
    if (s_getAvailableBlocksLong != null)
    {
      localObject = (Long)invoke(m_stat, s_getAvailableBlocksLong, new Object[0]);
      if (localObject != null) {
        return ((Long)localObject).longValue();
      }
    }
    if (s_getAvailableBlocks != null)
    {
      localObject = (Integer)invoke(m_stat, s_getAvailableBlocks, new Object[0]);
      if (localObject != null) {
        return ((Integer)localObject).intValue();
      }
    }
    return 0L;
  }
  
  public long getBlockCount()
  {
    Object localObject;
    if (s_getBlockCountLong != null)
    {
      localObject = (Long)invoke(m_stat, s_getBlockCountLong, new Object[0]);
      if (localObject != null) {
        return ((Long)localObject).longValue();
      }
    }
    if (s_getBlockCount != null)
    {
      localObject = (Integer)invoke(m_stat, s_getBlockCount, new Object[0]);
      if (localObject != null) {
        return ((Integer)localObject).intValue();
      }
    }
    return 0L;
  }
  
  public long getBlockSize()
  {
    Object localObject;
    if (s_getBlockSizeLong != null)
    {
      localObject = (Long)invoke(m_stat, s_getBlockSizeLong, new Object[0]);
      if (localObject != null) {
        return ((Long)localObject).longValue();
      }
    }
    if (s_getBlockSize != null)
    {
      localObject = (Integer)invoke(m_stat, s_getBlockSize, new Object[0]);
      if (localObject != null) {
        return ((Integer)localObject).intValue();
      }
    }
    return 0L;
  }
}

/* Location:
 * Qualified Name:     com.threatmetrix.TrustDefenderMobile.StatWrapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */