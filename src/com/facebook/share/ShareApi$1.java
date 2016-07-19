package com.facebook.share;

import com.facebook.FacebookCallback;
import com.facebook.GraphRequest.Callback;
import com.facebook.GraphResponse;
import com.facebook.share.internal.ShareInternalUtility;
import org.json.JSONObject;

class ShareApi$1
  implements GraphRequest.Callback
{
  ShareApi$1(ShareApi paramShareApi, FacebookCallback paramFacebookCallback) {}
  
  public void onCompleted(GraphResponse paramGraphResponse)
  {
    Object localObject = paramGraphResponse.getJSONObject();
    if (localObject == null) {}
    for (localObject = null;; localObject = ((JSONObject)localObject).optString("id"))
    {
      ShareInternalUtility.invokeCallbackWithResults(val$callback, (String)localObject, paramGraphResponse);
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.facebook.share.ShareApi.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */