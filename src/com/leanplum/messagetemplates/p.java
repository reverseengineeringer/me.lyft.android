package com.leanplum.messagetemplates;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.leanplum.ActionContext;

final class p
  implements DialogInterface.OnClickListener
{
  p(o paramo, ActionContext paramActionContext) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    a.runTrackedActionNamed("Accept action");
  }
}

/* Location:
 * Qualified Name:     com.leanplum.messagetemplates.p
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */