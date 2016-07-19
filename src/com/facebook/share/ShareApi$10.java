package com.facebook.share;

import com.facebook.FacebookGraphResponseException;
import com.facebook.FacebookRequestError;
import com.facebook.GraphRequest.Callback;
import com.facebook.GraphResponse;
import com.facebook.internal.CollectionMapper.OnMapValueCompleteListener;
import org.json.JSONObject;

class ShareApi$10
  implements GraphRequest.Callback
{
  ShareApi$10(ShareApi paramShareApi, CollectionMapper.OnMapValueCompleteListener paramOnMapValueCompleteListener) {}
  
  public void onCompleted(GraphResponse paramGraphResponse)
  {
    Object localObject = paramGraphResponse.getError();
    if (localObject != null)
    {
      String str = ((FacebookRequestError)localObject).getErrorMessage();
      localObject = str;
      if (str == null) {
        localObject = "Error staging Open Graph object.";
      }
      val$onOpenGraphObjectStagedListener.onError(new FacebookGraphResponseException(paramGraphResponse, (String)localObject));
      return;
    }
    localObject = paramGraphResponse.getJSONObject();
    if (localObject == null)
    {
      val$onOpenGraphObjectStagedListener.onError(new FacebookGraphResponseException(paramGraphResponse, "Error staging Open Graph object."));
      return;
    }
    localObject = ((JSONObject)localObject).optString("id");
    if (localObject == null)
    {
      val$onOpenGraphObjectStagedListener.onError(new FacebookGraphResponseException(paramGraphResponse, "Error staging Open Graph object."));
      return;
    }
    val$onOpenGraphObjectStagedListener.onComplete(localObject);
  }
}

/* Location:
 * Qualified Name:     com.facebook.share.ShareApi.10
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */