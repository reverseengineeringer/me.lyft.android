package com.leanplum.messagetemplates;

import com.leanplum.ActionContext;
import com.leanplum.LeanplumActivityHelper;
import com.leanplum.callbacks.ActionCallback;

final class v
  extends ActionCallback
{
  public final boolean onResponse(ActionContext paramActionContext)
  {
    LeanplumActivityHelper.queueActionUponActive(new w(this, paramActionContext));
    return true;
  }
}

/* Location:
 * Qualified Name:     com.leanplum.messagetemplates.v
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */