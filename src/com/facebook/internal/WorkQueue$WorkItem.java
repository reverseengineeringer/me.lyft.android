package com.facebook.internal;

public abstract interface WorkQueue$WorkItem
{
  public abstract boolean cancel();
  
  public abstract boolean isRunning();
  
  public abstract void moveToFront();
}

/* Location:
 * Qualified Name:     com.facebook.internal.WorkQueue.WorkItem
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */