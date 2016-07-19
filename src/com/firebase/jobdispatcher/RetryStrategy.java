package com.firebase.jobdispatcher;

public final class RetryStrategy
{
  public static final RetryStrategy DEFAULT_EXPONENTIAL = new RetryStrategy(1, 30, 3600);
  public static final RetryStrategy DEFAULT_LINEAR = new RetryStrategy(2, 30, 3600);
  private final int mInitialBackoff;
  private final int mMaximumBackoff;
  private final int mPolicy;
  
  RetryStrategy(int paramInt1, int paramInt2, int paramInt3)
  {
    mPolicy = paramInt1;
    mInitialBackoff = paramInt2;
    mMaximumBackoff = paramInt3;
  }
  
  public int getInitialBackoff()
  {
    return mInitialBackoff;
  }
  
  public int getMaximumBackoff()
  {
    return mMaximumBackoff;
  }
  
  public int getPolicy()
  {
    return mPolicy;
  }
  
  static final class Builder
  {
    private final ValidationEnforcer mValidator;
    
    Builder(ValidationEnforcer paramValidationEnforcer)
    {
      mValidator = paramValidationEnforcer;
    }
  }
}

/* Location:
 * Qualified Name:     com.firebase.jobdispatcher.RetryStrategy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */