package com.firebase.jobdispatcher;

final class JobTrigger$ExecutionWindowTrigger
  extends JobTrigger
{
  private final int mWindowEnd;
  private final int mWindowStart;
  
  JobTrigger$ExecutionWindowTrigger(int paramInt1, int paramInt2)
  {
    mWindowStart = paramInt1;
    mWindowEnd = paramInt2;
  }
  
  public int getWindowEnd()
  {
    return mWindowEnd;
  }
  
  public int getWindowStart()
  {
    return mWindowStart;
  }
}

/* Location:
 * Qualified Name:     com.firebase.jobdispatcher.JobTrigger.ExecutionWindowTrigger
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */