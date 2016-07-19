package me.lyft.android.application.geo;

import java.util.concurrent.TimeUnit;

class CachedEta
{
  public static final Long CACHE_TTL = Long.valueOf(TimeUnit.SECONDS.toMillis(30L));
  private Long eta;
  private String rideId;
  private Long timestamp;
  
  public CachedEta(Long paramLong1, Long paramLong2, String paramString)
  {
    timestamp = paramLong1;
    eta = paramLong2;
    rideId = paramString;
  }
  
  public Long getEta()
  {
    return eta;
  }
  
  public String getRideId()
  {
    return rideId;
  }
  
  public Long getTimestamp()
  {
    return timestamp;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.geo.CachedEta
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */