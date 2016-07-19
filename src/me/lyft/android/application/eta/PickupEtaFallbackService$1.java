package me.lyft.android.application.eta;

import rx.functions.Func1;

class PickupEtaFallbackService$1
  implements Func1<DriverEtaEstimate, String>
{
  PickupEtaFallbackService$1(PickupEtaFallbackService paramPickupEtaFallbackService) {}
  
  public String call(DriverEtaEstimate paramDriverEtaEstimate)
  {
    return paramDriverEtaEstimate.getLocationQuery();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.eta.PickupEtaFallbackService.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */