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
import org.json.JSONObject;

class LikeActionController$GetPageIdRequestWrapper
  extends LikeActionController.AbstractRequestWrapper
{
  boolean objectIsPage;
  String verifiedObjectId;
  
  LikeActionController$GetPageIdRequestWrapper(LikeActionController paramLikeActionController, String paramString, LikeView.ObjectType paramObjectType)
  {
    super(paramLikeActionController, paramString, paramObjectType);
    paramLikeActionController = new Bundle();
    paramLikeActionController.putString("fields", "id");
    paramLikeActionController.putString("ids", paramString);
    setRequest(new GraphRequest(AccessToken.getCurrentAccessToken(), "", paramLikeActionController, HttpMethod.GET));
  }
  
  protected void processError(FacebookRequestError paramFacebookRequestError)
  {
    Logger.log(LoggingBehavior.REQUESTS, LikeActionController.access$100(), "Error getting the FB id for object '%s' with type '%s' : %s", new Object[] { objectId, objectType, paramFacebookRequestError });
  }
  
  protected void processSuccess(GraphResponse paramGraphResponse)
  {
    paramGraphResponse = Utility.tryGetJSONObjectFromResponse(paramGraphResponse.getJSONObject(), objectId);
    if (paramGraphResponse != null)
    {
      verifiedObjectId = paramGraphResponse.optString("id");
      if (Utility.isNullOrEmpty(verifiedObjectId)) {
        break label44;
      }
    }
    label44:
    for (boolean bool = true;; bool = false)
    {
      objectIsPage = bool;
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.facebook.share.internal.LikeActionController.GetPageIdRequestWrapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */