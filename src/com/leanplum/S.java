package com.leanplum;

import com.leanplum.callbacks.ActionCallback;
import com.leanplum.callbacks.VariablesChangedCallback;
import java.util.concurrent.atomic.AtomicBoolean;

final class s
  implements Runnable
{
  s(ActionCallback paramActionCallback, ActionContext paramActionContext, VariablesChangedCallback paramVariablesChangedCallback, AtomicBoolean paramAtomicBoolean) {}
  
  public final void run()
  {
    if ((a.onResponse(b)) && (c != null) && (!d.getAndSet(true))) {
      c.variablesChanged();
    }
  }
}

/* Location:
 * Qualified Name:     com.leanplum.s
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */