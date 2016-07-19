package com.facebook.share.internal;

import com.facebook.internal.DialogFeature;

public enum OpenGraphMessageDialogFeature
  implements DialogFeature
{
  OG_MESSAGE_DIALOG(20140204);
  
  private int minVersion;
  
  private OpenGraphMessageDialogFeature(int paramInt)
  {
    minVersion = paramInt;
  }
  
  public String getAction()
  {
    return "com.facebook.platform.action.request.OGMESSAGEPUBLISH_DIALOG";
  }
  
  public int getMinVersion()
  {
    return minVersion;
  }
}

/* Location:
 * Qualified Name:     com.facebook.share.internal.OpenGraphMessageDialogFeature
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */