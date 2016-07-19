package me.lyft.android.infrastructure.leanplum;

import com.leanplum.Leanplum;
import com.leanplum.callbacks.StartCallback;
import java.util.Map;
import me.lyft.android.analytics.core.CallAnalytics;
import me.lyft.android.analytics.core.ExperimentAnalytics;

class LeanplumService$3
  extends StartCallback
{
  LeanplumService$3(LeanplumService paramLeanplumService, CallAnalytics paramCallAnalytics) {}
  
  public void onResponse(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      val$leanplumStart.trackSuccess();
      LeanplumService.access$200((Map)Leanplum.objectForKeyPath(new Object[] { "client" }), LeanplumService.access$100(this$0));
      ExperimentAnalytics.updateAssignments(LeanplumService.access$300());
    }
    synchronized (LeanplumService.access$400())
    {
      LeanplumService.access$502(false);
      if (LeanplumService.access$600()) {
        LeanplumService.access$800(true, LeanplumService.access$700(this$0), LeanplumService.access$100(this$0));
      }
      return;
      val$leanplumStart.trackFailure();
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.leanplum.LeanplumService.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */