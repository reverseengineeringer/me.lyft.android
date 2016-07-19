package com.leanplum.messagetemplates;

import android.content.Context;
import com.leanplum.ActionArgs;
import com.leanplum.ActionContext;

public class WebInterstitialOptions
{
  private String a;
  private String b;
  private boolean c;
  
  protected WebInterstitialOptions(ActionContext paramActionContext)
  {
    a = paramActionContext.stringNamed("URL");
    c = paramActionContext.booleanNamed("Has dismiss button");
    b = paramActionContext.stringNamed("Close URL");
  }
  
  public static ActionArgs toArgs(Context paramContext)
  {
    return new ActionArgs().with("URL", "http://www.example.com").with("Close URL", "http://leanplum:close").with("Has dismiss button", Boolean.valueOf(true));
  }
  
  public String getCloseUrl()
  {
    return b;
  }
  
  public String getUrl()
  {
    return a;
  }
  
  public boolean hasDismissButton()
  {
    return c;
  }
}

/* Location:
 * Qualified Name:     com.leanplum.messagetemplates.WebInterstitialOptions
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */