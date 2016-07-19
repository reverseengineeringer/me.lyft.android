package com.firebase.jobdispatcher;

import android.os.Bundle;

public abstract interface JobParameters
{
  public abstract int[] getConstraints();
  
  public abstract Bundle getExtras();
  
  public abstract int getLifetime();
  
  public abstract RetryStrategy getRetryStrategy();
  
  public abstract String getService();
  
  public abstract String getTag();
  
  public abstract JobTrigger getTrigger();
  
  public abstract boolean isRecurring();
  
  public abstract boolean shouldReplaceCurrent();
}

/* Location:
 * Qualified Name:     com.firebase.jobdispatcher.JobParameters
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */