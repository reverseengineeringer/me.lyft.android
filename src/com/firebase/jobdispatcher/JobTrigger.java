package com.firebase.jobdispatcher;

class JobTrigger
{
  static final class ExecutionWindowTrigger
    extends JobTrigger
  {
    private final int mWindowEnd;
    private final int mWindowStart;
    
    ExecutionWindowTrigger(int paramInt1, int paramInt2)
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
  
  static final class ImmediateTrigger
    extends JobTrigger
  {}
}

/* Location:
 * Qualified Name:     com.firebase.jobdispatcher.JobTrigger
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */