package com.facebook.share.widget;

import android.os.Bundle;
import com.facebook.FacebookCallback;
import com.facebook.internal.AppCall;
import com.facebook.share.internal.ResultProcessor;

class JoinAppGroupDialog$1
  extends ResultProcessor
{
  JoinAppGroupDialog$1(JoinAppGroupDialog paramJoinAppGroupDialog, FacebookCallback paramFacebookCallback1, FacebookCallback paramFacebookCallback2)
  {
    super(paramFacebookCallback1);
  }
  
  public void onSuccess(AppCall paramAppCall, Bundle paramBundle)
  {
    val$callback.onSuccess(new JoinAppGroupDialog.Result(paramBundle, null));
  }
}

/* Location:
 * Qualified Name:     com.facebook.share.widget.JoinAppGroupDialog.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */