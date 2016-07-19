package com.facebook.share.internal;

import com.facebook.GraphRequestBatch;
import com.facebook.GraphRequestBatch.Callback;
import com.facebook.LoggingBehavior;
import com.facebook.internal.Logger;

class LikeActionController$9
  implements LikeActionController.RequestCompletionCallback
{
  LikeActionController$9(LikeActionController paramLikeActionController) {}
  
  public void onComplete()
  {
    switch (LikeActionController.12.$SwitchMap$com$facebook$share$widget$LikeView$ObjectType[LikeActionController.access$1700(this$0).ordinal()])
    {
    }
    for (final Object localObject = new LikeActionController.GetOGObjectLikesRequestWrapper(this$0, LikeActionController.access$1600(this$0), LikeActionController.access$1700(this$0));; localObject = new LikeActionController.GetPageLikesRequestWrapper(this$0, LikeActionController.access$1600(this$0)))
    {
      final LikeActionController.GetEngagementRequestWrapper localGetEngagementRequestWrapper = new LikeActionController.GetEngagementRequestWrapper(this$0, LikeActionController.access$1600(this$0), LikeActionController.access$1700(this$0));
      GraphRequestBatch localGraphRequestBatch = new GraphRequestBatch();
      ((LikeActionController.LikeRequestWrapper)localObject).addToBatch(localGraphRequestBatch);
      localGetEngagementRequestWrapper.addToBatch(localGraphRequestBatch);
      localGraphRequestBatch.addCallback(new GraphRequestBatch.Callback()
      {
        public void onBatchCompleted(GraphRequestBatch paramAnonymousGraphRequestBatch)
        {
          if ((localObject.getError() != null) || (localGetEngagementRequestWrapper.getError() != null))
          {
            Logger.log(LoggingBehavior.REQUESTS, LikeActionController.access$100(), "Unable to refresh like state for id: '%s'", new Object[] { LikeActionController.access$2200(this$0) });
            return;
          }
          LikeActionController.access$1300(this$0, localObject.isObjectLiked(), localGetEngagementRequestWrapperlikeCountStringWithLike, localGetEngagementRequestWrapperlikeCountStringWithoutLike, localGetEngagementRequestWrappersocialSentenceStringWithLike, localGetEngagementRequestWrappersocialSentenceStringWithoutLike, localObject.getUnlikeToken());
        }
      });
      localGraphRequestBatch.executeAsync();
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.facebook.share.internal.LikeActionController.9
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */