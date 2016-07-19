package com.facebook.share;

import android.content.Intent;
import com.facebook.FacebookCallback;
import com.facebook.FacebookRequestError;
import com.facebook.internal.CallbackManagerImpl.Callback;

class DeviceShareDialog$1
  implements CallbackManagerImpl.Callback
{
  DeviceShareDialog$1(DeviceShareDialog paramDeviceShareDialog, FacebookCallback paramFacebookCallback) {}
  
  public boolean onActivityResult(int paramInt, Intent paramIntent)
  {
    paramIntent.getExtras();
    if (paramIntent.hasExtra("error"))
    {
      paramIntent = (FacebookRequestError)paramIntent.getParcelableExtra("error");
      val$callback.onError(paramIntent.getException());
      return true;
    }
    val$callback.onSuccess(new DeviceShareDialog.Result());
    return true;
  }
}

/* Location:
 * Qualified Name:     com.facebook.share.DeviceShareDialog.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */