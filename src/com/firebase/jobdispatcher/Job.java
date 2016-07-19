package com.firebase.jobdispatcher;

import android.os.Bundle;

public final class Job
  implements JobParameters
{
  private final int[] mConstraints;
  private Bundle mExtras;
  private final int mLifetime;
  private final boolean mRecurring;
  private final boolean mReplaceCurrent;
  private final RetryStrategy mRetryStrategy;
  private final String mService;
  private final String mTag;
  private final JobTrigger mTrigger;
  
  private Job(Builder paramBuilder)
  {
    if (mServiceClass != null)
    {
      localObject = mServiceClass.getName();
      mService = ((String)localObject);
      mExtras = mExtras;
      mTag = mTag;
      mTrigger = mTrigger;
      mRetryStrategy = mRetryStrategy;
      mLifetime = mLifetime;
      mRecurring = mRecurring;
      if (mConstraints == null) {
        break label103;
      }
    }
    label103:
    for (Object localObject = mConstraints;; localObject = new int[0])
    {
      mConstraints = ((int[])localObject);
      mReplaceCurrent = mReplaceCurrent;
      return;
      localObject = null;
      break;
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
  
  public static final class Builder
    implements JobParameters
  {
    private int[] mConstraints;
    private Bundle mExtras;
    private int mLifetime = 1;
    private boolean mRecurring = false;
    private boolean mReplaceCurrent = false;
    private RetryStrategy mRetryStrategy = RetryStrategy.DEFAULT_EXPONENTIAL;
    private Class<? extends JobService> mServiceClass;
    private String mTag;
    private JobTrigger mTrigger = Trigger.NOW;
    private final ValidationEnforcer mValidator;
    
    Builder(ValidationEnforcer paramValidationEnforcer)
    {
      mValidator = paramValidationEnforcer;
    }
    
    public Job build()
    {
      mValidator.ensureValid(this);
      return new Job(this, null);
    }
    
    public int[] getConstraints()
    {
      if (mConstraints == null) {
        return new int[0];
      }
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
      return mServiceClass.getName();
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
    
    public Builder setConstraints(int... paramVarArgs)
    {
      mConstraints = paramVarArgs;
      return this;
    }
    
    public Builder setLifetime(int paramInt)
    {
      mLifetime = paramInt;
      return this;
    }
    
    public Builder setRecurring(boolean paramBoolean)
    {
      mRecurring = paramBoolean;
      return this;
    }
    
    public Builder setReplaceCurrent(boolean paramBoolean)
    {
      mReplaceCurrent = paramBoolean;
      return this;
    }
    
    public Builder setRetryStrategy(RetryStrategy paramRetryStrategy)
    {
      mRetryStrategy = paramRetryStrategy;
      return this;
    }
    
    public Builder setService(Class<? extends JobService> paramClass)
    {
      mServiceClass = paramClass;
      return this;
    }
    
    public Builder setTag(String paramString)
    {
      mTag = paramString;
      return this;
    }
    
    public Builder setTrigger(JobTrigger paramJobTrigger)
    {
      mTrigger = paramJobTrigger;
      return this;
    }
    
    public boolean shouldReplaceCurrent()
    {
      return mReplaceCurrent;
    }
  }
}

/* Location:
 * Qualified Name:     com.firebase.jobdispatcher.Job
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */