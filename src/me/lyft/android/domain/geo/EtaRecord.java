package me.lyft.android.domain.geo;

import java.util.concurrent.TimeUnit;
import me.lyft.android.common.INullable;

public class EtaRecord
  implements INullable
{
  private final Long eta;
  private final Boolean isInternal;
  
  public EtaRecord(Boolean paramBoolean, Long paramLong)
  {
    isInternal = paramBoolean;
    eta = paramLong;
  }
  
  public static EtaRecord empty()
  {
    return NullEtaRecord.instance;
  }
  
  public Long getEta()
  {
    Long localLong = Long.valueOf(TimeUnit.SECONDS.toMinutes(eta.longValue()));
    if (localLong.longValue() > 0L) {}
    for (long l = localLong.longValue();; l = 1L) {
      return Long.valueOf(TimeUnit.MINUTES.toSeconds(Long.valueOf(l).longValue()));
    }
  }
  
  public Boolean isInternal()
  {
    return isInternal;
  }
  
  public boolean isNull()
  {
    return false;
  }
  
  public static class NullEtaRecord
    extends EtaRecord
  {
    private static final EtaRecord instance = new NullEtaRecord();
    
    public NullEtaRecord()
    {
      super(null);
    }
    
    public boolean isNull()
    {
      return true;
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.geo.EtaRecord
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */