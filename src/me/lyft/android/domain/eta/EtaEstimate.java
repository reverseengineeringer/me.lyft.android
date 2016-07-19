package me.lyft.android.domain.eta;

import java.util.concurrent.TimeUnit;
import me.lyft.android.common.INullable;

public class EtaEstimate
  implements INullable
{
  public final long eta;
  public final boolean isInternal;
  public final String rideTypeId;
  
  EtaEstimate(long paramLong, String paramString, boolean paramBoolean)
  {
    eta = paramLong;
    rideTypeId = paramString;
    isInternal = paramBoolean;
  }
  
  public static EtaEstimate create(long paramLong, String paramString, boolean paramBoolean)
  {
    return new EtaEstimate(paramLong, paramString, paramBoolean);
  }
  
  public Long etaInMinutes()
  {
    long l = TimeUnit.SECONDS.toMinutes(eta);
    if (l > 0L) {}
    for (;;)
    {
      return Long.valueOf(l);
      l = 1L;
    }
  }
  
  public boolean isNull()
  {
    return false;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.eta.EtaEstimate
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */