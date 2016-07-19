package com.leanplum.callbacks;

public abstract class VariablesChangedCallback
  implements Runnable
{
  public void run()
  {
    variablesChanged();
  }
  
  public abstract void variablesChanged();
}

/* Location:
 * Qualified Name:     com.leanplum.callbacks.VariablesChangedCallback
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */