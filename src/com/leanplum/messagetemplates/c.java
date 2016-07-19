package com.leanplum.messagetemplates;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import com.leanplum.ActionContext;
import com.leanplum.LeanplumActivityHelper;
import com.leanplum.callbacks.VariablesChangedCallback;

final class c
  extends VariablesChangedCallback
{
  c(b paramb, ActionContext paramActionContext) {}
  
  public final void variablesChanged()
  {
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(LeanplumActivityHelper.getCurrentActivity());
    localBuilder.setTitle(a.stringNamed("Title")).setMessage(a.stringNamed("Message")).setCancelable(false).setPositiveButton(a.stringNamed("Dismiss text"), new d(this, a));
    localBuilder.create().show();
  }
}

/* Location:
 * Qualified Name:     com.leanplum.messagetemplates.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */