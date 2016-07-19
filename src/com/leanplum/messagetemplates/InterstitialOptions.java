package com.leanplum.messagetemplates;

import android.content.Context;
import com.leanplum.ActionArgs;
import com.leanplum.ActionContext;

public class InterstitialOptions
  extends BaseMessageOptions
{
  public InterstitialOptions(ActionContext paramActionContext)
  {
    super(paramActionContext);
  }
  
  public static ActionArgs toArgs(Context paramContext)
  {
    return BaseMessageOptions.toArgs(paramContext).with("Message.Text", "Interstitial message goes here.");
  }
}

/* Location:
 * Qualified Name:     com.leanplum.messagetemplates.InterstitialOptions
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */