package com.facebook.share.internal;

import android.content.Intent;
import com.facebook.FacebookException;
import com.facebook.internal.Utility;

final class LikeActionController$1
  implements LikeActionController.CreationCallback
{
  LikeActionController$1(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void onComplete(LikeActionController paramLikeActionController, FacebookException paramFacebookException)
  {
    if (paramFacebookException == null)
    {
      LikeActionController.access$000(paramLikeActionController, val$requestCode, val$resultCode, val$data);
      return;
    }
    Utility.logd(LikeActionController.access$100(), paramFacebookException);
  }
}

/* Location:
 * Qualified Name:     com.facebook.share.internal.LikeActionController.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */