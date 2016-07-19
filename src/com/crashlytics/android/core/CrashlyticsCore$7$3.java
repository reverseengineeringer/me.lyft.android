package com.crashlytics.android.core;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class CrashlyticsCore$7$3
  implements DialogInterface.OnClickListener
{
  CrashlyticsCore$7$3(CrashlyticsCore.7 param7) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this$1.this$0.setShouldSendUserReportsWithoutPrompting(true);
    this$1.val$latch.setOptIn(true);
    paramDialogInterface.dismiss();
  }
}

/* Location:
 * Qualified Name:     com.crashlytics.android.core.CrashlyticsCore.7.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */