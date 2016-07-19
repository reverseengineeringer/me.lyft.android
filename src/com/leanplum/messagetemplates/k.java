package com.leanplum.messagetemplates;

import com.leanplum.ActionContext;
import com.leanplum.LeanplumActivityHelper;
import com.leanplum.callbacks.VariablesChangedCallback;

final class k
  extends VariablesChangedCallback
{
  k(j paramj, ActionContext paramActionContext) {}
  
  public final void variablesChanged()
  {
    LeanplumActivityHelper.queueActionUponActive(new l(this, a));
  }
}

/* Location:
 * Qualified Name:     com.leanplum.messagetemplates.k
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */