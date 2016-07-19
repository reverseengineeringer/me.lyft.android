package com.leanplum.callbacks;

public abstract class StartCallback
  implements Runnable
{
  private boolean a;
  
  public abstract void onResponse(boolean paramBoolean);
  
  public void run()
  {
    onResponse(a);
  }
  
  public void setSuccess(boolean paramBoolean)
  {
    a = paramBoolean;
  }
}

/* Location:
 * Qualified Name:     com.leanplum.callbacks.StartCallback
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */