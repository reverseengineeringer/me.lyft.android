package com.firebase.jobdispatcher;

import android.os.Bundle;

final class GooglePlayJobWriter
{
  private JobCoder jobCoder = new JobCoder("com.firebase.jobdispatcher.", false);
  
  private int convertConstraintsToLegacyNetConstant(int paramInt)
  {
    int i = 2;
    if ((paramInt & 0x2) == 2) {
      i = 0;
    }
    if ((paramInt & 0x1) == 1) {
      i = 1;
    }
    return i;
  }
  
  private int convertRetryPolicyToLegacyVersion(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    }
    return 1;
  }
  
  private static boolean isSupported(JobTrigger paramJobTrigger)
  {
    return ((paramJobTrigger instanceof JobTrigger.ExecutionWindowTrigger)) || (paramJobTrigger == Trigger.NOW);
  }
  
  private void writeConstraintsToBundle(JobParameters paramJobParameters, Bundle paramBundle)
  {
    int i = Constraint.compact(paramJobParameters.getConstraints());
    if ((i & 0x4) == 4) {}
    for (boolean bool = true;; bool = false)
    {
      paramBundle.putBoolean("requiresCharging", bool);
      paramBundle.putInt("requiredNetwork", convertConstraintsToLegacyNetConstant(i));
      return;
    }
  }
  
  private static void writeExecutionWindowTriggerToBundle(JobParameters paramJobParameters, Bundle paramBundle, JobTrigger.ExecutionWindowTrigger paramExecutionWindowTrigger)
  {
    paramBundle.putInt("trigger_type", 1);
    if (paramJobParameters.isRecurring())
    {
      paramBundle.putLong("period", paramExecutionWindowTrigger.getWindowEnd());
      paramBundle.putLong("period_flex", paramExecutionWindowTrigger.getWindowEnd() - paramExecutionWindowTrigger.getWindowStart());
      return;
    }
    paramBundle.putLong("window_start", paramExecutionWindowTrigger.getWindowStart());
    paramBundle.putLong("window_end", paramExecutionWindowTrigger.getWindowEnd());
  }
  
  private static void writeImmediateTriggerToBundle(Bundle paramBundle)
  {
    paramBundle.putInt("trigger_type", 2);
    paramBundle.putLong("window_start", 0L);
    paramBundle.putLong("window_end", 30L);
  }
  
  private void writeRetryStrategyToBundle(JobParameters paramJobParameters, Bundle paramBundle)
  {
    paramJobParameters = paramJobParameters.getRetryStrategy();
    Bundle localBundle = new Bundle();
    localBundle.putInt("retry_policy", convertRetryPolicyToLegacyVersion(paramJobParameters.getPolicy()));
    localBundle.putInt("initial_backoff_seconds", paramJobParameters.getInitialBackoff());
    localBundle.putInt("maximum_backoff_seconds", paramJobParameters.getMaximumBackoff());
    paramBundle.putBundle("retryStrategy", localBundle);
  }
  
  private void writeTriggerToBundle(JobParameters paramJobParameters, Bundle paramBundle)
  {
    JobTrigger localJobTrigger = paramJobParameters.getTrigger();
    if (!isSupported(localJobTrigger)) {
      throw new IllegalArgumentException("Unknown trigger: " + localJobTrigger.getClass());
    }
    if (localJobTrigger == Trigger.NOW)
    {
      writeImmediateTriggerToBundle(paramBundle);
      return;
    }
    writeExecutionWindowTriggerToBundle(paramJobParameters, paramBundle, (JobTrigger.ExecutionWindowTrigger)localJobTrigger);
  }
  
  public Bundle writeToBundle(JobParameters paramJobParameters, Bundle paramBundle)
  {
    paramBundle.putString("tag", paramJobParameters.getTag());
    paramBundle.putBoolean("update_current", paramJobParameters.shouldReplaceCurrent());
    if (paramJobParameters.getLifetime() == 2) {}
    for (boolean bool = true;; bool = false)
    {
      paramBundle.putBoolean("persisted", bool);
      paramBundle.putString("service", GooglePlayReceiver.class.getName());
      writeTriggerToBundle(paramJobParameters, paramBundle);
      writeConstraintsToBundle(paramJobParameters, paramBundle);
      writeRetryStrategyToBundle(paramJobParameters, paramBundle);
      Bundle localBundle2 = paramJobParameters.getExtras();
      Bundle localBundle1 = localBundle2;
      if (localBundle2 == null) {
        localBundle1 = new Bundle();
      }
      paramBundle.putBundle("extras", jobCoder.encode(paramJobParameters, localBundle1));
      return paramBundle;
    }
  }
}

/* Location:
 * Qualified Name:     com.firebase.jobdispatcher.GooglePlayJobWriter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */