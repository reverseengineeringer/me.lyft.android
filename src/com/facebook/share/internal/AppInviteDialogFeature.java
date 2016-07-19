package com.facebook.share.internal;

import com.facebook.internal.DialogFeature;

public enum AppInviteDialogFeature
  implements DialogFeature
{
  APP_INVITES_DIALOG(20140701);
  
  private int minVersion;
  
  private AppInviteDialogFeature(int paramInt)
  {
    minVersion = paramInt;
  }
  
  public String getAction()
  {
    return "com.facebook.platform.action.request.APPINVITES_DIALOG";
  }
  
  public int getMinVersion()
  {
    return minVersion;
  }
}

/* Location:
 * Qualified Name:     com.facebook.share.internal.AppInviteDialogFeature
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */