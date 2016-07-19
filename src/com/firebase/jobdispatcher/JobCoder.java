package com.firebase.jobdispatcher;

import android.os.Bundle;

final class JobCoder
{
  private final boolean includeExtras;
  private final String prefix;
  
  public JobCoder()
  {
    this("", true);
  }
  
  public JobCoder(String paramString, boolean paramBoolean)
  {
    includeExtras = paramBoolean;
    prefix = paramString;
  }
  
  private RetryStrategy decodeRetryStrategy(Bundle paramBundle)
  {
    int i = paramBundle.getInt(prefix + "retry_policy");
    if ((i != 1) && (i != 2)) {
      return RetryStrategy.DEFAULT_EXPONENTIAL;
    }
    return new RetryStrategy(i, paramBundle.getInt(prefix + "initial_backoff_seconds"), paramBundle.getInt(prefix + "maximum_backoff_seconds"));
  }
  
  private JobTrigger decodeTrigger(Bundle paramBundle)
  {
    switch (paramBundle.getInt(prefix + "trigger_type"))
    {
    default: 
      return null;
    case 2: 
      return Trigger.NOW;
    }
    return Trigger.executionWindow(paramBundle.getInt(prefix + "window_start"), paramBundle.getInt(prefix + "window_end"));
  }
  
  private void encodeRetryStrategy(RetryStrategy paramRetryStrategy, Bundle paramBundle)
  {
    RetryStrategy localRetryStrategy = paramRetryStrategy;
    if (paramRetryStrategy == null) {
      localRetryStrategy = RetryStrategy.DEFAULT_EXPONENTIAL;
    }
    paramBundle.putInt(prefix + "retry_policy", localRetryStrategy.getPolicy());
    paramBundle.putInt(prefix + "initial_backoff_seconds", localRetryStrategy.getInitialBackoff());
    paramBundle.putInt(prefix + "maximum_backoff_seconds", localRetryStrategy.getMaximumBackoff());
  }
  
  private void encodeTrigger(JobTrigger paramJobTrigger, Bundle paramBundle)
  {
    if (paramJobTrigger == Trigger.NOW) {
      paramBundle.putInt(prefix + "trigger_type", 2);
    }
    while (!(paramJobTrigger instanceof JobTrigger.ExecutionWindowTrigger)) {
      return;
    }
    paramJobTrigger = (JobTrigger.ExecutionWindowTrigger)paramJobTrigger;
    paramBundle.putInt(prefix + "trigger_type", 1);
    paramBundle.putInt(prefix + "window_start", paramJobTrigger.getWindowStart());
    paramBundle.putInt(prefix + "window_end", paramJobTrigger.getWindowEnd());
  }
  
  public JobInvocation decode(Bundle paramBundle)
  {
    Bundle localBundle = null;
    if (paramBundle == null) {
      throw new IllegalArgumentException("Unexpected null Bundle provided");
    }
    boolean bool1 = paramBundle.getBoolean(prefix + "recurring");
    boolean bool2 = paramBundle.getBoolean(prefix + "replace_current");
    int i = paramBundle.getInt(prefix + "persistent");
    int[] arrayOfInt = Constraint.uncompact(paramBundle.getInt(prefix + "constraints"));
    JobTrigger localJobTrigger = decodeTrigger(paramBundle);
    RetryStrategy localRetryStrategy = decodeRetryStrategy(paramBundle);
    String str1 = paramBundle.getString(prefix + "tag");
    String str2 = paramBundle.getString(prefix + "service");
    if ((str1 == null) || (str2 == null) || (localJobTrigger == null) || (localRetryStrategy == null)) {
      return null;
    }
    if (includeExtras) {
      localBundle = paramBundle.getBundle(prefix + "extras");
    }
    return new JobInvocation(str1, str2, localJobTrigger, localRetryStrategy, bool1, i, arrayOfInt, localBundle, bool2);
  }
  
  public Bundle encode(JobParameters paramJobParameters, Bundle paramBundle)
  {
    if (paramBundle == null) {
      throw new IllegalArgumentException("Unexpected null Bundle provided");
    }
    paramBundle.putInt(prefix + "persistent", paramJobParameters.getLifetime());
    paramBundle.putBoolean(prefix + "recurring", paramJobParameters.isRecurring());
    paramBundle.putString(prefix + "tag", paramJobParameters.getTag());
    paramBundle.putString(prefix + "service", paramJobParameters.getService());
    paramBundle.putInt(prefix + "constraints", Constraint.compact(paramJobParameters.getConstraints()));
    if (includeExtras) {
      paramBundle.putBundle(prefix + "extras", paramJobParameters.getExtras());
    }
    encodeTrigger(paramJobParameters.getTrigger(), paramBundle);
    encodeRetryStrategy(paramJobParameters.getRetryStrategy(), paramBundle);
    return paramBundle;
  }
}

/* Location:
 * Qualified Name:     com.firebase.jobdispatcher.JobCoder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */