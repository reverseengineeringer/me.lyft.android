package com.facebook.share.widget;

import android.os.Bundle;
import com.facebook.FacebookCallback;
import com.facebook.internal.AppCall;
import com.facebook.share.internal.ResultProcessor;
import com.facebook.share.internal.ShareInternalUtility;

class AppInviteDialog$1
  extends ResultProcessor
{
  AppInviteDialog$1(AppInviteDialog paramAppInviteDialog, FacebookCallback paramFacebookCallback1, FacebookCallback paramFacebookCallback2)
  {
    super(paramFacebookCallback1);
  }
  
  public void onSuccess(AppCall paramAppCall, Bundle paramBundle)
  {
    if ("cancel".equalsIgnoreCase(ShareInternalUtility.getNativeDialogCompletionGesture(paramBundle)))
    {
      val$callback.onCancel();
      return;
    }
    val$callback.onSuccess(new AppInviteDialog.Result(paramBundle));
  }
}

/* Location:
 * Qualified Name:     com.facebook.share.widget.AppInviteDialog.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */