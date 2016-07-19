package com.facebook.share.internal;

import android.os.Bundle;
import com.facebook.AccessToken;
import com.facebook.FacebookRequestError;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.LoggingBehavior;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import com.facebook.share.widget.LikeView.ObjectType;
import org.json.JSONArray;

class LikeActionController$GetPageLikesRequestWrapper
  extends LikeActionController.AbstractRequestWrapper
  implements LikeActionController.LikeRequestWrapper
{
  private boolean objectIsLiked = LikeActionController.access$2500(this$0);
  private String pageId;
  
  LikeActionController$GetPageLikesRequestWrapper(LikeActionController paramLikeActionController, String paramString)
  {
    super(paramLikeActionController, paramString, LikeView.ObjectType.PAGE);
    pageId = paramString;
    paramLikeActionController = new Bundle();
    paramLikeActionController.putString("fields", "id");
    setRequest(new GraphRequest(AccessToken.getCurrentAccessToken(), "me/likes/" + paramString, paramLikeActionController, HttpMethod.GET));
  }
  
  public String getUnlikeToken()
  {
    return null;
  }
  
  public boolean isObjectLiked()
  {
    return objectIsLiked;
  }
  
  protected void processError(FacebookRequestError paramFacebookRequestError)
  {
    Logger.log(LoggingBehavior.REQUESTS, LikeActionController.access$100(), "Error fetching like status for page id '%s': %s", new Object[] { pageId, paramFacebookRequestError });
    LikeActionController.access$2400(this$0, "get_page_like", paramFacebookRequestError);
  }
  
  protected void processSuccess(GraphResponse paramGraphResponse)
  {
    paramGraphResponse = Utility.tryGetJSONArrayFromResponse(paramGraphResponse.getJSONObject(), "data");
    if ((paramGraphResponse != null) && (paramGraphResponse.length() > 0)) {
      objectIsLiked = true;
    }
  }
}

/* Location:
 * Qualified Name:     com.facebook.share.internal.LikeActionController.GetPageLikesRequestWrapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */