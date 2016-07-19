package com.facebook.share;

import com.facebook.FacebookException;
import com.facebook.FacebookGraphResponseException;
import com.facebook.FacebookRequestError;
import com.facebook.GraphRequest.Callback;
import com.facebook.GraphResponse;
import com.facebook.internal.CollectionMapper.OnMapValueCompleteListener;
import com.facebook.share.model.SharePhoto;
import org.json.JSONException;
import org.json.JSONObject;

class ShareApi$12
  implements GraphRequest.Callback
{
  ShareApi$12(ShareApi paramShareApi, CollectionMapper.OnMapValueCompleteListener paramOnMapValueCompleteListener, SharePhoto paramSharePhoto) {}
  
  public void onCompleted(GraphResponse paramGraphResponse)
  {
    Object localObject = paramGraphResponse.getError();
    if (localObject != null)
    {
      String str = ((FacebookRequestError)localObject).getErrorMessage();
      localObject = str;
      if (str == null) {
        localObject = "Error staging photo.";
      }
      val$onPhotoStagedListener.onError(new FacebookGraphResponseException(paramGraphResponse, (String)localObject));
      return;
    }
    paramGraphResponse = paramGraphResponse.getJSONObject();
    if (paramGraphResponse == null)
    {
      val$onPhotoStagedListener.onError(new FacebookException("Error staging photo."));
      return;
    }
    paramGraphResponse = paramGraphResponse.optString("uri");
    if (paramGraphResponse == null)
    {
      val$onPhotoStagedListener.onError(new FacebookException("Error staging photo."));
      return;
    }
    localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("url", paramGraphResponse);
      ((JSONObject)localObject).put("user_generated", val$photo.getUserGenerated());
      val$onPhotoStagedListener.onComplete(localObject);
      return;
    }
    catch (JSONException paramGraphResponse)
    {
      localObject = paramGraphResponse.getLocalizedMessage();
      paramGraphResponse = (GraphResponse)localObject;
      if (localObject == null) {
        paramGraphResponse = "Error staging photo.";
      }
      val$onPhotoStagedListener.onError(new FacebookException(paramGraphResponse));
    }
  }
}

/* Location:
 * Qualified Name:     com.facebook.share.ShareApi.12
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */