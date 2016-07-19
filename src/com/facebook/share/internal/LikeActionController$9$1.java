package com.facebook.share.internal;

import com.facebook.GraphRequestBatch;
import com.facebook.GraphRequestBatch.Callback;
import com.facebook.LoggingBehavior;
import com.facebook.internal.Logger;

class LikeActionController$9$1
  implements GraphRequestBatch.Callback
{
  LikeActionController$9$1(LikeActionController.9 param9, LikeActionController.LikeRequestWrapper paramLikeRequestWrapper, LikeActionController.GetEngagementRequestWrapper paramGetEngagementRequestWrapper) {}
  
  public void onBatchCompleted(GraphRequestBatch paramGraphRequestBatch)
  {
    if ((val$likeRequestWrapper.getError() != null) || (val$engagementRequest.getError() != null))
    {
      Logger.log(LoggingBehavior.REQUESTS, LikeActionController.access$100(), "Unable to refresh like state for id: '%s'", new Object[] { LikeActionController.access$2200(this$1.this$0) });
      return;
    }
    LikeActionController.access$1300(this$1.this$0, val$likeRequestWrapper.isObjectLiked(), val$engagementRequest.likeCountStringWithLike, val$engagementRequest.likeCountStringWithoutLike, val$engagementRequest.socialSentenceStringWithLike, val$engagementRequest.socialSentenceStringWithoutLike, val$likeRequestWrapper.getUnlikeToken());
  }
}

/* Location:
 * Qualified Name:     com.facebook.share.internal.LikeActionController.9.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */