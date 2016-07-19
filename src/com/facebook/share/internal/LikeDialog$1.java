package com.facebook.share.internal;

import android.os.Bundle;
import com.facebook.FacebookCallback;
import com.facebook.internal.AppCall;

class LikeDialog$1
  extends ResultProcessor
{
  LikeDialog$1(LikeDialog paramLikeDialog, FacebookCallback paramFacebookCallback1, FacebookCallback paramFacebookCallback2)
  {
    super(paramFacebookCallback1);
  }
  
  public void onSuccess(AppCall paramAppCall, Bundle paramBundle)
  {
    val$callback.onSuccess(new LikeDialog.Result(paramBundle));
  }
}

/* Location:
 * Qualified Name:     com.facebook.share.internal.LikeDialog.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */