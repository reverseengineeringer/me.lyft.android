package com.facebook.share.internal;

import com.facebook.internal.DialogFeature;

public enum OpenGraphActionDialogFeature
  implements DialogFeature
{
  OG_ACTION_DIALOG(20130618);
  
  private int minVersion;
  
  private OpenGraphActionDialogFeature(int paramInt)
  {
    minVersion = paramInt;
  }
  
  public String getAction()
  {
    return "com.facebook.platform.action.request.OGACTIONPUBLISH_DIALOG";
  }
  
  public int getMinVersion()
  {
    return minVersion;
  }
}

/* Location:
 * Qualified Name:     com.facebook.share.internal.OpenGraphActionDialogFeature
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */