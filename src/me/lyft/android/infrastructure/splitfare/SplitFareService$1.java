package me.lyft.android.infrastructure.splitfare;

import me.lyft.android.analytics.studies.SplitFareAnalytics;
import me.lyft.android.common.Unit;
import rx.functions.Action1;

class SplitFareService$1
  implements Action1<Unit>
{
  SplitFareService$1(SplitFareService paramSplitFareService) {}
  
  public void call(Unit paramUnit)
  {
    SplitFareService.access$000(this$0).trackSplitResponseSuccess();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.splitfare.SplitFareService.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */