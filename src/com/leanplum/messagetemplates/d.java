package com.leanplum.messagetemplates;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.leanplum.ActionContext;

final class d
  implements DialogInterface.OnClickListener
{
  d(c paramc, ActionContext paramActionContext) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    a.runActionNamed("Dismiss action");
  }
}

/* Location:
 * Qualified Name:     com.leanplum.messagetemplates.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */