package me.lyft.android.application.geo;

import rx.functions.Action1;

class GeoService$2
  implements Action1<Long>
{
  GeoService$2(GeoService paramGeoService) {}
  
  public void call(Long paramLong)
  {
    GeoService.access$000(this$0).record(Boolean.valueOf(true), paramLong);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.geo.GeoService.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */