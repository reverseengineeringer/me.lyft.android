package me.lyft.android.application.geo;

import rx.functions.Action1;

class GeoService$4
  implements Action1<Long>
{
  GeoService$4(GeoService paramGeoService, String paramString) {}
  
  public void call(Long paramLong)
  {
    GeoService.access$102(this$0, new CachedEta(Long.valueOf(System.currentTimeMillis()), paramLong, val$currentRideId));
    GeoService.access$000(this$0).record(Boolean.valueOf(false), paramLong);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.geo.GeoService.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */