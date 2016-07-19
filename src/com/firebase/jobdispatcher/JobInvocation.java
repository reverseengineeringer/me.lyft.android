package com.firebase.jobdispatcher;

import android.os.Bundle;

final class JobInvocation
  implements JobParameters
{
  private final int[] mConstraints;
  private final Bundle mExtras;
  private final int mLifetime;
  private final boolean mRecurring;
  private final boolean mReplaceCurrent;
  private final RetryStrategy mRetryStrategy;
  private final String mService;
  private final String mTag;
  private final JobTrigger mTrigger;
  
  JobInvocation(String paramString1, String paramString2, JobTrigger paramJobTrigger, RetryStrategy paramRetryStrategy, boolean paramBoolean1, int paramInt, int[] paramArrayOfInt, Bundle paramBundle, boolean paramBoolean2)
  {
    mTag = paramString1;
    mService = paramString2;
    mTrigger = paramJobTrigger;
    mRetryStrategy = paramRetryStrategy;
    mRecurring = paramBoolean1;
    mLifetime = paramInt;
    mConstraints = paramArrayOfInt;
    if (paramBundle != null) {}
    for (;;)
    {
      mExtras = paramBundle;
      mReplaceCurrent = paramBoolean2;
      return;
      paramBundle = new Bundle();
    }
  }
  
  public int[] getConstraints()
  {
    return mConstraints;
  }
  
  public Bundle getExtras()
  {
    return mExtras;
  }
  
  public int getLifetime()
  {
    return mLifetime;
  }
  
  public RetryStrategy getRetryStrategy()
  {
    return mRetryStrategy;
  }
  
  public String getService()
  {
    return mService;
  }
  
  public String getTag()
  {
    return mTag;
  }
  
  public JobTrigger getTrigger()
  {
    return mTrigger;
  }
  
  public boolean isRecurring()
  {
    return mRecurring;
  }
  
  public boolean shouldReplaceCurrent()
  {
    return mReplaceCurrent;
  }
}

/* Location:
 * Qualified Name:     com.firebase.jobdispatcher.JobInvocation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */