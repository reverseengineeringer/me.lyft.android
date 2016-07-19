package me.lyft.android.application.requestridetypes;

import me.lyft.android.common.Strings;
import me.lyft.android.domain.passenger.ridetypes.RequestRideType;
import rx.functions.Func1;

class RequestRideTypeService$1
  implements Func1<RequestRideType, Boolean>
{
  RequestRideTypeService$1(RequestRideTypeService paramRequestRideTypeService, String paramString) {}
  
  public Boolean call(RequestRideType paramRequestRideType)
  {
    return Boolean.valueOf(Strings.equalsIgnoreCase(paramRequestRideType.getPublicId(), val$rideTypeId));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.requestridetypes.RequestRideTypeService.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */