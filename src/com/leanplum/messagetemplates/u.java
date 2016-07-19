package com.leanplum.messagetemplates;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import com.leanplum.ActionContext;
import com.leanplum.LeanplumActivityHelper;
import com.leanplum.callbacks.ActionCallback;

final class u
  extends ActionCallback
{
  public final boolean onResponse(ActionContext paramActionContext)
  {
    paramActionContext = paramActionContext.stringNamed("URL");
    Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse(paramActionContext));
    try
    {
      LeanplumActivityHelper.getCurrentActivity().startActivity(localIntent);
      return true;
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      Log.e("Leanplum", "Unable to handle URL " + paramActionContext);
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     com.leanplum.messagetemplates.u
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */