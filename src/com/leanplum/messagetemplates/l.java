package com.leanplum.messagetemplates;

import com.leanplum.ActionContext;
import com.leanplum.LeanplumActivityHelper;
import com.leanplum.callbacks.VariablesChangedCallback;

final class l
  extends VariablesChangedCallback
{
  l(k paramk, ActionContext paramActionContext) {}
  
  public final void variablesChanged()
  {
    new CenterPopup(LeanplumActivityHelper.getCurrentActivity(), new CenterPopupOptions(a)).show();
  }
}

/* Location:
 * Qualified Name:     com.leanplum.messagetemplates.l
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */