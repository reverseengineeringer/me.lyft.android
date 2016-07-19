package com.firebase.jobdispatcher;

public final class FirebaseJobDispatcher
{
  private final Driver mDriver;
  private RetryStrategy.Builder mRetryStrategyBuilder;
  private final ValidationEnforcer mValidator;
  
  public FirebaseJobDispatcher(Driver paramDriver)
  {
    mDriver = paramDriver;
    mValidator = new ValidationEnforcer(mDriver.getValidator());
    mRetryStrategyBuilder = new RetryStrategy.Builder(mValidator);
  }
  
  public Job.Builder newJobBuilder()
  {
    return new Job.Builder(mValidator);
  }
  
  public int schedule(Job paramJob)
  {
    if (!mDriver.isAvailable()) {
      return 2;
    }
    return mDriver.schedule(paramJob);
  }
}

/* Location:
 * Qualified Name:     com.firebase.jobdispatcher.FirebaseJobDispatcher
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */