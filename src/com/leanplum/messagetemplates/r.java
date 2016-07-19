package com.leanplum.messagetemplates;

import com.leanplum.ActionContext;
import com.leanplum.Leanplum;
import com.leanplum.callbacks.ActionCallback;

final class r
  extends ActionCallback
{
  public final boolean onResponse(ActionContext paramActionContext)
  {
    Leanplum.addOnceVariablesChangedAndNoDownloadsPendingHandler(new s(this, paramActionContext));
    return true;
  }
}

/* Location:
 * Qualified Name:     com.leanplum.messagetemplates.r
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */