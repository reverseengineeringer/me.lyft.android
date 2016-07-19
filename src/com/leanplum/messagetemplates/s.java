package com.leanplum.messagetemplates;

import com.leanplum.ActionContext;
import com.leanplum.LeanplumActivityHelper;
import com.leanplum.callbacks.VariablesChangedCallback;

final class s
  extends VariablesChangedCallback
{
  s(r paramr, ActionContext paramActionContext) {}
  
  public final void variablesChanged()
  {
    LeanplumActivityHelper.queueActionUponActive(new t(this, a));
  }
}

/* Location:
 * Qualified Name:     com.leanplum.messagetemplates.s
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */