package com.facebook.share.internal;

import android.os.Bundle;
import com.facebook.GraphRequestBatch;
import com.facebook.GraphRequestBatch.Callback;
import com.facebook.appevents.AppEventsLogger;

class LikeActionController$8
  implements GraphRequestBatch.Callback
{
  LikeActionController$8(LikeActionController paramLikeActionController, LikeActionController.PublishUnlikeRequestWrapper paramPublishUnlikeRequestWrapper, Bundle paramBundle) {}
  
  public void onBatchCompleted(GraphRequestBatch paramGraphRequestBatch)
  {
    LikeActionController.access$1802(this$0, false);
    if (val$unlikeRequest.getError() != null)
    {
      LikeActionController.access$1900(this$0, true);
      return;
    }
    LikeActionController.access$1102(this$0, null);
    LikeActionController.access$2002(this$0, false);
    LikeActionController.access$1200(this$0).logSdkEvent("fb_like_control_did_unlike", null, val$analyticsParameters);
    LikeActionController.access$2100(this$0, val$analyticsParameters);
  }
}

/* Location:
 * Qualified Name:     com.facebook.share.internal.LikeActionController.8
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */