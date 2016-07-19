package com.facebook.share.widget;

import android.content.Intent;
import com.facebook.internal.CallbackManagerImpl.Callback;
import com.facebook.share.internal.ResultProcessor;
import com.facebook.share.internal.ShareInternalUtility;

class AppInviteDialog$2
  implements CallbackManagerImpl.Callback
{
  AppInviteDialog$2(AppInviteDialog paramAppInviteDialog, ResultProcessor paramResultProcessor) {}
  
  public boolean onActivityResult(int paramInt, Intent paramIntent)
  {
    return ShareInternalUtility.handleActivityResult(this$0.getRequestCode(), paramInt, paramIntent, val$resultProcessor);
  }
}

/* Location:
 * Qualified Name:     com.facebook.share.widget.AppInviteDialog.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */