package me.lyft.android.infrastructure.leanplum;

import com.leanplum.Leanplum;
import com.leanplum.callbacks.VariablesChangedCallback;
import java.util.Map;
import me.lyft.android.analytics.core.CallAnalytics;
import me.lyft.android.analytics.core.ExperimentAnalytics;
import me.lyft.android.application.constants.IConstantsProvider;
import me.lyft.android.application.constants.ILeanplumOverrideService;

final class LeanplumService$5
  extends VariablesChangedCallback
{
  LeanplumService$5(CallAnalytics paramCallAnalytics, IConstantsProvider paramIConstantsProvider, boolean paramBoolean, ILeanplumOverrideService paramILeanplumOverrideService) {}
  
  public void variablesChanged()
  {
    val$leanplumUpdate.trackSuccess();
    LeanplumService.access$200((Map)Leanplum.objectForKeyPath(new Object[] { "client" }), val$constantsProvider);
    if (val$force) {
      ExperimentAnalytics.reset();
    }
    ExperimentAnalytics.updateAssignments(LeanplumService.access$300());
    synchronized (LeanplumService.access$400())
    {
      LeanplumService.access$502(false);
      if (LeanplumService.access$600()) {
        LeanplumService.access$800(true, val$leanplumOverrideService, val$constantsProvider);
      }
      return;
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.leanplum.LeanplumService.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */