package me.lyft.android.infrastructure.deferred;

import java.util.HashMap;
import me.lyft.android.infrastructure.deferred.deferredcalls.DropOffDeferredCall;
import me.lyft.android.infrastructure.deferred.deferredcalls.RateDeferredCall;

final class DeferredCallService$1
  extends HashMap<String, Class<? extends IDeferredCall>>
{
  DeferredCallService$1()
  {
    put("dropOffPassenger", DropOffDeferredCall.class);
    put("ratePassenger", RateDeferredCall.class);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.deferred.DeferredCallService.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */