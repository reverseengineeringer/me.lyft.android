package com.leanplum.messagetemplates;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.leanplum.ActionContext;

final class q
  implements DialogInterface.OnClickListener
{
  q(o paramo, ActionContext paramActionContext) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    a.runActionNamed("Cancel action");
  }
}

/* Location:
 * Qualified Name:     com.leanplum.messagetemplates.q
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */