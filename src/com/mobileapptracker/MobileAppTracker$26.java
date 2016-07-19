package com.mobileapptracker;

import android.content.Context;

class MobileAppTracker$26
  implements Runnable
{
  MobileAppTracker$26(MobileAppTracker paramMobileAppTracker, String paramString) {}
  
  public void run()
  {
    if ((val$packageName == null) || (val$packageName.equals("")))
    {
      this$0.params.setPackageName(this$0.mContext.getPackageName());
      return;
    }
    this$0.params.setPackageName(val$packageName);
  }
}

/* Location:
 * Qualified Name:     com.mobileapptracker.MobileAppTracker.26
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */