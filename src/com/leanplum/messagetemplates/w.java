package com.leanplum.messagetemplates;

import com.leanplum.ActionContext;
import com.leanplum.LeanplumActivityHelper;
import com.leanplum.callbacks.VariablesChangedCallback;

final class w
  extends VariablesChangedCallback
{
  w(v paramv, ActionContext paramActionContext) {}
  
  public final void variablesChanged()
  {
    new WebInterstitial(LeanplumActivityHelper.getCurrentActivity(), new WebInterstitialOptions(a)).show();
  }
}

/* Location:
 * Qualified Name:     com.leanplum.messagetemplates.w
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */