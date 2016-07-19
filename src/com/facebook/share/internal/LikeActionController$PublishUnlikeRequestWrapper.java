package com.facebook.share.internal;

import com.facebook.AccessToken;
import com.facebook.FacebookRequestError;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.LoggingBehavior;
import com.facebook.internal.Logger;

class LikeActionController$PublishUnlikeRequestWrapper
  extends LikeActionController.AbstractRequestWrapper
{
  private String unlikeToken;
  
  LikeActionController$PublishUnlikeRequestWrapper(LikeActionController paramLikeActionController, String paramString)
  {
    super(paramLikeActionController, null, null);
    unlikeToken = paramString;
    setRequest(new GraphRequest(AccessToken.getCurrentAccessToken(), paramString, null, HttpMethod.DELETE));
  }
  
  protected void processError(FacebookRequestError paramFacebookRequestError)
  {
    Logger.log(LoggingBehavior.REQUESTS, LikeActionController.access$100(), "Error unliking object with unlike token '%s' : %s", new Object[] { unlikeToken, paramFacebookRequestError });
    LikeActionController.access$2400(this$0, "publish_unlike", paramFacebookRequestError);
  }
  
  protected void processSuccess(GraphResponse paramGraphResponse) {}
}

/* Location:
 * Qualified Name:     com.facebook.share.internal.LikeActionController.PublishUnlikeRequestWrapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */