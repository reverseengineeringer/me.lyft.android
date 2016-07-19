package com.leanplum.messagetemplates;

import com.leanplum.ActionContext;
import com.leanplum.LeanplumActivityHelper;
import com.leanplum.callbacks.VariablesChangedCallback;

final class t
  extends VariablesChangedCallback
{
  t(s params, ActionContext paramActionContext) {}
  
  public final void variablesChanged()
  {
    new Interstitial(LeanplumActivityHelper.getCurrentActivity(), new InterstitialOptions(a)).show();
  }
}

/* Location:
 * Qualified Name:     com.leanplum.messagetemplates.t
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */