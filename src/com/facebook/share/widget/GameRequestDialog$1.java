package com.facebook.share.widget;

import android.os.Bundle;
import com.facebook.FacebookCallback;
import com.facebook.internal.AppCall;
import com.facebook.share.internal.ResultProcessor;

class GameRequestDialog$1
  extends ResultProcessor
{
  GameRequestDialog$1(GameRequestDialog paramGameRequestDialog, FacebookCallback paramFacebookCallback1, FacebookCallback paramFacebookCallback2)
  {
    super(paramFacebookCallback1);
  }
  
  public void onSuccess(AppCall paramAppCall, Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      val$callback.onSuccess(new GameRequestDialog.Result(paramBundle, null));
      return;
    }
    onCancel(paramAppCall);
  }
}

/* Location:
 * Qualified Name:     com.facebook.share.widget.GameRequestDialog.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */