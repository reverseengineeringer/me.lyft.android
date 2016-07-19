package me.lyft.android.application.autofill;

import me.lyft.android.analytics.core.ActionAnalytics;
import me.lyft.android.analytics.core.ExperimentAnalytics;
import me.lyft.android.analytics.core.SpanningAnalytics;
import me.lyft.android.analytics.core.definitions.Experiment;
import me.lyft.android.analytics.core.events.ActionEvent.Action;

public class AutoFillAnalytics
{
  private ActionAnalytics dropoffPrefillActionAnalytics = new ActionAnalytics(ActionEvent.Action.DROPOFF_PREFILL_LOCATION);
  private ActionAnalytics pickupPrefillActionAnalytics = new ActionAnalytics(ActionEvent.Action.PICKUP_PREFILL_LOCATION);
  
  public void initializeOnBootstrap()
  {
    ExperimentAnalytics.trackExposure(Experiment.INITIATE_AUTO_FILL_ULU_ON_BOOTSTRAP);
  }
  
  public void trackAutoFillDropoffSuccess()
  {
    dropoffPrefillActionAnalytics.trackInitiation().trackSuccess();
  }
  
  public void trackAutoFillPickupSuccess()
  {
    pickupPrefillActionAnalytics.trackInitiation().trackSuccess();
  }
  
  public void trackAutoFillRideStepExposure()
  {
    ExperimentAnalytics.trackExposure(Experiment.AUTO_FILL_RIDE_STEP);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.autofill.AutoFillAnalytics
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */