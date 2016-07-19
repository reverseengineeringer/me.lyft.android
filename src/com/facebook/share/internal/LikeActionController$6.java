package com.facebook.share.internal;

import android.os.Bundle;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.internal.AppCall;
import com.facebook.internal.Logger;
import com.facebook.internal.NativeProtocol;
import java.util.UUID;

class LikeActionController$6
  extends ResultProcessor
{
  LikeActionController$6(LikeActionController paramLikeActionController, FacebookCallback paramFacebookCallback, Bundle paramBundle)
  {
    super(paramFacebookCallback);
  }
  
  public void onCancel(AppCall paramAppCall)
  {
    onError(paramAppCall, new FacebookOperationCanceledException());
  }
  
  public void onError(AppCall paramAppCall, FacebookException paramFacebookException)
  {
    Logger.log(LoggingBehavior.REQUESTS, LikeActionController.access$100(), "Like Dialog failed with error : %s", new Object[] { paramFacebookException });
    if (val$analyticsParameters == null) {}
    for (Bundle localBundle = new Bundle();; localBundle = val$analyticsParameters)
    {
      localBundle.putString("call_id", paramAppCall.getCallId().toString());
      LikeActionController.access$1400(this$0, "present_dialog", localBundle);
      LikeActionController.access$1500(this$0, "com.facebook.sdk.LikeActionController.DID_ERROR", NativeProtocol.createBundleForException(paramFacebookException));
      return;
    }
  }
  
  public void onSuccess(AppCall paramAppCall, Bundle paramBundle)
  {
    if ((paramBundle == null) || (!paramBundle.containsKey("object_is_liked"))) {
      return;
    }
    boolean bool = paramBundle.getBoolean("object_is_liked");
    String str1 = LikeActionController.access$700(this$0);
    String str2 = LikeActionController.access$800(this$0);
    if (paramBundle.containsKey("like_count_string"))
    {
      str1 = paramBundle.getString("like_count_string");
      str2 = str1;
    }
    String str3 = LikeActionController.access$900(this$0);
    String str4 = LikeActionController.access$1000(this$0);
    if (paramBundle.containsKey("social_sentence"))
    {
      str3 = paramBundle.getString("social_sentence");
      str4 = str3;
    }
    if (paramBundle.containsKey("object_is_liked"))
    {
      paramBundle = paramBundle.getString("unlike_token");
      if (val$analyticsParameters != null) {
        break label189;
      }
    }
    label189:
    for (Bundle localBundle = new Bundle();; localBundle = val$analyticsParameters)
    {
      localBundle.putString("call_id", paramAppCall.getCallId().toString());
      LikeActionController.access$1200(this$0).logSdkEvent("fb_like_control_dialog_did_succeed", null, localBundle);
      LikeActionController.access$1300(this$0, bool, str1, str2, str3, str4, paramBundle);
      return;
      paramBundle = LikeActionController.access$1100(this$0);
      break;
    }
  }
}

/* Location:
 * Qualified Name:     com.facebook.share.internal.LikeActionController.6
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */