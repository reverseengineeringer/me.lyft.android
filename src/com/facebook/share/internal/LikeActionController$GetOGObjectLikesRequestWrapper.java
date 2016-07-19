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
import org.json.JSONObject;

class LikeActionController$GetOGObjectLikesRequestWrapper
  extends LikeActionController.AbstractRequestWrapper
  implements LikeActionController.LikeRequestWrapper
{
  private final String objectId;
  private boolean objectIsLiked = LikeActionController.access$2500(this$0);
  private final LikeView.ObjectType objectType;
  private String unlikeToken;
  
  LikeActionController$GetOGObjectLikesRequestWrapper(LikeActionController paramLikeActionController, String paramString, LikeView.ObjectType paramObjectType)
  {
    super(paramLikeActionController, paramString, paramObjectType);
    objectId = paramString;
    objectType = paramObjectType;
    paramLikeActionController = new Bundle();
    paramLikeActionController.putString("fields", "id,application");
    paramLikeActionController.putString("object", objectId);
    setRequest(new GraphRequest(AccessToken.getCurrentAccessToken(), "me/og.likes", paramLikeActionController, HttpMethod.GET));
  }
  
  public String getUnlikeToken()
  {
    return unlikeToken;
  }
  
  public boolean isObjectLiked()
  {
    return objectIsLiked;
  }
  
  protected void processError(FacebookRequestError paramFacebookRequestError)
  {
    Logger.log(LoggingBehavior.REQUESTS, LikeActionController.access$100(), "Error fetching like status for object '%s' with type '%s' : %s", new Object[] { objectId, objectType, paramFacebookRequestError });
    LikeActionController.access$2400(this$0, "get_og_object_like", paramFacebookRequestError);
  }
  
  protected void processSuccess(GraphResponse paramGraphResponse)
  {
    paramGraphResponse = Utility.tryGetJSONArrayFromResponse(paramGraphResponse.getJSONObject(), "data");
    if (paramGraphResponse != null)
    {
      int i = 0;
      while (i < paramGraphResponse.length())
      {
        JSONObject localJSONObject1 = paramGraphResponse.optJSONObject(i);
        if (localJSONObject1 != null)
        {
          objectIsLiked = true;
          JSONObject localJSONObject2 = localJSONObject1.optJSONObject("application");
          AccessToken localAccessToken = AccessToken.getCurrentAccessToken();
          if ((localJSONObject2 != null) && (localAccessToken != null) && (Utility.areObjectsEqual(localAccessToken.getApplicationId(), localJSONObject2.optString("id")))) {
            unlikeToken = localJSONObject1.optString("id");
          }
        }
        i += 1;
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.facebook.share.internal.LikeActionController.GetOGObjectLikesRequestWrapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */