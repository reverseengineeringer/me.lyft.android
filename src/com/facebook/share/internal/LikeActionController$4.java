package com.facebook.share.internal;

import com.facebook.FacebookException;

final class LikeActionController$4
  implements Runnable
{
  LikeActionController$4(LikeActionController.CreationCallback paramCreationCallback, LikeActionController paramLikeActionController, FacebookException paramFacebookException) {}
  
  public void run()
  {
    val$callback.onComplete(val$controller, val$error);
  }
}

/* Location:
 * Qualified Name:     com.facebook.share.internal.LikeActionController.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */