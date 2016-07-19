package com.leanplum.callbacks;

import com.leanplum.Var;

public abstract class VariableCallback<T>
  implements Runnable
{
  private Var<T> a;
  
  public abstract void handle(Var<T> paramVar);
  
  public void run()
  {
    handle(a);
  }
  
  public void setVariable(Var<T> paramVar)
  {
    a = paramVar;
  }
}

/* Location:
 * Qualified Name:     com.leanplum.callbacks.VariableCallback
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */