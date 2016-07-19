package com.facebook.share.internal;

import com.facebook.GraphRequestBatch;
import com.facebook.GraphRequestBatch.Callback;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.internal.Utility;

class LikeActionController$7$1
  implements GraphRequestBatch.Callback
{
  LikeActionController$7$1(LikeActionController.7 param7, LikeActionController.PublishLikeRequestWrapper paramPublishLikeRequestWrapper) {}
  
  public void onBatchCompleted(GraphRequestBatch paramGraphRequestBatch)
  {
    LikeActionController.access$1802(this$1.this$0, false);
    if (val$likeRequest.getError() != null)
    {
      LikeActionController.access$1900(this$1.this$0, false);
      return;
    }
    LikeActionController.access$1102(this$1.this$0, Utility.coerceValueIfNullOrEmpty(val$likeRequest.unlikeToken, null));
    LikeActionController.access$2002(this$1.this$0, true);
    LikeActionController.access$1200(this$1.this$0).logSdkEvent("fb_like_control_did_like", null, this$1.val$analyticsParameters);
    LikeActionController.access$2100(this$1.this$0, this$1.val$analyticsParameters);
  }
}

/* Location:
 * Qualified Name:     com.facebook.share.internal.LikeActionController.7.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */