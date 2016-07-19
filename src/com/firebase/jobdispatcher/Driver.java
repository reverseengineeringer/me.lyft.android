package com.firebase.jobdispatcher;

public abstract interface Driver
{
  public abstract JobValidator getValidator();
  
  public abstract boolean isAvailable();
  
  public abstract int schedule(Job paramJob);
}

/* Location:
 * Qualified Name:     com.firebase.jobdispatcher.Driver
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */