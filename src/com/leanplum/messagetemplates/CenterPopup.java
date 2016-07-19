package com.leanplum.messagetemplates;

import android.app.Activity;
import android.content.Context;
import com.leanplum.Leanplum;

public class CenterPopup
  extends BaseMessageDialog
{
  public CenterPopup(Activity paramActivity, CenterPopupOptions paramCenterPopupOptions)
  {
    super(paramActivity, false, paramCenterPopupOptions, null);
    options = paramCenterPopupOptions;
  }
  
  public static void register(Context paramContext)
  {
    Leanplum.defineAction("Center Popup", Leanplum.ACTION_KIND_MESSAGE | Leanplum.ACTION_KIND_ACTION, CenterPopupOptions.toArgs(paramContext), new j());
  }
}

/* Location:
 * Qualified Name:     com.leanplum.messagetemplates.CenterPopup
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */