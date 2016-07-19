package com.leanplum.messagetemplates;

import android.content.Context;
import com.leanplum.ActionArgs;
import com.leanplum.ActionContext;

public class CenterPopupOptions
  extends BaseMessageOptions
{
  private int a;
  private int b;
  
  public CenterPopupOptions(ActionContext paramActionContext)
  {
    super(paramActionContext);
    a = paramActionContext.numberNamed("Layout.Width").intValue();
    b = paramActionContext.numberNamed("Layout.Height").intValue();
  }
  
  public static ActionArgs toArgs(Context paramContext)
  {
    return BaseMessageOptions.toArgs(paramContext).with("Layout.Width", Integer.valueOf(300)).with("Layout.Height", Integer.valueOf(250));
  }
  
  public int getHeight()
  {
    return b;
  }
  
  public int getWidth()
  {
    return a;
  }
}

/* Location:
 * Qualified Name:     com.leanplum.messagetemplates.CenterPopupOptions
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */