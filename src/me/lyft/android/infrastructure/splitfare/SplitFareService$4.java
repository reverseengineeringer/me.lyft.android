package me.lyft.android.infrastructure.splitfare;

import java.util.List;
import me.lyft.android.analytics.studies.SplitFareAnalytics;
import me.lyft.android.common.Unit;
import me.lyft.android.providers.ISplitFareProvider;
import rx.functions.Action1;

class SplitFareService$4
  implements Action1<Unit>
{
  SplitFareService$4(SplitFareService paramSplitFareService, List paramList) {}
  
  public void call(Unit paramUnit)
  {
    SplitFareService.access$000(this$0).trackSendSplitRequestSuccess();
    SplitFareService.access$100(this$0).incrementSplitFareCount(val$contacts);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.splitfare.SplitFareService.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */