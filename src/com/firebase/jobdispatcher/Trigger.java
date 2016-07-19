package com.firebase.jobdispatcher;

public final class Trigger
{
  public static final JobTrigger.ImmediateTrigger NOW = new JobTrigger.ImmediateTrigger();
  
  public static JobTrigger.ExecutionWindowTrigger executionWindow(int paramInt1, int paramInt2)
  {
    if (paramInt1 < 0) {
      throw new IllegalArgumentException("Window start can't be less than 0");
    }
    if (paramInt2 < paramInt1) {
      throw new IllegalArgumentException("Window end can't be less than window start");
    }
    return new JobTrigger.ExecutionWindowTrigger(paramInt1, paramInt2);
  }
}

/* Location:
 * Qualified Name:     com.firebase.jobdispatcher.Trigger
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */