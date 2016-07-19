package com.facebook.share.widget;

import com.facebook.FacebookException;
import com.facebook.share.internal.LikeActionController;
import com.facebook.share.internal.LikeActionController.CreationCallback;

class LikeView$LikeActionControllerCreationCallback
  implements LikeActionController.CreationCallback
{
  private boolean isCancelled;
  
  private LikeView$LikeActionControllerCreationCallback(LikeView paramLikeView) {}
  
  public void cancel()
  {
    isCancelled = true;
  }
  
  public void onComplete(LikeActionController paramLikeActionController, FacebookException paramFacebookException)
  {
    if (isCancelled) {
      return;
    }
    FacebookException localFacebookException = paramFacebookException;
    if (paramLikeActionController != null)
    {
      if (!paramLikeActionController.shouldEnableView()) {
        paramFacebookException = new FacebookException("Cannot use LikeView. The device may not be supported.");
      }
      LikeView.access$1100(this$0, paramLikeActionController);
      LikeView.access$700(this$0);
      localFacebookException = paramFacebookException;
    }
    if ((localFacebookException != null) && (LikeView.access$800(this$0) != null)) {
      LikeView.access$800(this$0).onError(localFacebookException);
    }
    LikeView.access$1202(this$0, null);
  }
}

/* Location:
 * Qualified Name:     com.facebook.share.widget.LikeView.LikeActionControllerCreationCallback
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */