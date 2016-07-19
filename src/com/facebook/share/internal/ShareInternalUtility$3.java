package com.facebook.share.internal;

import android.content.Intent;
import com.facebook.FacebookCallback;
import com.facebook.internal.CallbackManagerImpl.Callback;

final class ShareInternalUtility$3
  implements CallbackManagerImpl.Callback
{
  ShareInternalUtility$3(int paramInt, FacebookCallback paramFacebookCallback) {}
  
  public boolean onActivityResult(int paramInt, Intent paramIntent)
  {
    return ShareInternalUtility.handleActivityResult(val$requestCode, paramInt, paramIntent, ShareInternalUtility.getShareResultProcessor(val$callback));
  }
}

/* Location:
 * Qualified Name:     com.facebook.share.internal.ShareInternalUtility.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */