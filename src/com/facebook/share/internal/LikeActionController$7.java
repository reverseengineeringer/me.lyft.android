package com.facebook.share.internal;

import android.os.Bundle;
import com.facebook.GraphRequestBatch;
import com.facebook.GraphRequestBatch.Callback;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.internal.Utility;

class LikeActionController$7
  implements LikeActionController.RequestCompletionCallback
{
  LikeActionController$7(LikeActionController paramLikeActionController, Bundle paramBundle) {}
  
  public void onComplete()
  {
    if (Utility.isNullOrEmpty(LikeActionController.access$1600(this$0)))
    {
      localObject = new Bundle();
      ((Bundle)localObject).putString("com.facebook.platform.status.ERROR_DESCRIPTION", "Invalid Object Id");
      LikeActionController.access$1500(this$0, "com.facebook.sdk.LikeActionController.DID_ERROR", (Bundle)localObject);
      return;
    }
    Object localObject = new GraphRequestBatch();
    final LikeActionController.PublishLikeRequestWrapper localPublishLikeRequestWrapper = new LikeActionController.PublishLikeRequestWrapper(this$0, LikeActionController.access$1600(this$0), LikeActionController.access$1700(this$0));
    localPublishLikeRequestWrapper.addToBatch((GraphRequestBatch)localObject);
    ((GraphRequestBatch)localObject).addCallback(new GraphRequestBatch.Callback()
    {
      public void onBatchCompleted(GraphRequestBatch paramAnonymousGraphRequestBatch)
      {
        LikeActionController.access$1802(this$0, false);
        if (localPublishLikeRequestWrapper.getError() != null)
        {
          LikeActionController.access$1900(this$0, false);
          return;
        }
        LikeActionController.access$1102(this$0, Utility.coerceValueIfNullOrEmpty(localPublishLikeRequestWrapperunlikeToken, null));
        LikeActionController.access$2002(this$0, true);
        LikeActionController.access$1200(this$0).logSdkEvent("fb_like_control_did_like", null, val$analyticsParameters);
        LikeActionController.access$2100(this$0, val$analyticsParameters);
      }
    });
    ((GraphRequestBatch)localObject).executeAsync();
  }
}

/* Location:
 * Qualified Name:     com.facebook.share.internal.LikeActionController.7
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */