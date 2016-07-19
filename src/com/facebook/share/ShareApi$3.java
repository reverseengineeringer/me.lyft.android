package com.facebook.share;

import com.facebook.FacebookCallback;
import com.facebook.GraphRequest.Callback;
import com.facebook.GraphResponse;
import com.facebook.internal.Mutable;
import com.facebook.share.internal.ShareInternalUtility;
import java.util.ArrayList;
import org.json.JSONObject;

class ShareApi$3
  implements GraphRequest.Callback
{
  ShareApi$3(ShareApi paramShareApi, ArrayList paramArrayList1, ArrayList paramArrayList2, Mutable paramMutable, FacebookCallback paramFacebookCallback) {}
  
  public void onCompleted(GraphResponse paramGraphResponse)
  {
    Object localObject = paramGraphResponse.getJSONObject();
    if (localObject != null) {
      val$results.add(localObject);
    }
    if (paramGraphResponse.getError() != null) {
      val$errorResponses.add(paramGraphResponse);
    }
    val$requestCount.value = Integer.valueOf(((Integer)val$requestCount.value).intValue() - 1);
    if (((Integer)val$requestCount.value).intValue() == 0)
    {
      if (val$errorResponses.isEmpty()) {
        break label105;
      }
      ShareInternalUtility.invokeCallbackWithResults(val$callback, null, (GraphResponse)val$errorResponses.get(0));
    }
    label105:
    while (val$results.isEmpty()) {
      return;
    }
    localObject = ((JSONObject)val$results.get(0)).optString("id");
    ShareInternalUtility.invokeCallbackWithResults(val$callback, (String)localObject, paramGraphResponse);
  }
}

/* Location:
 * Qualified Name:     com.facebook.share.ShareApi.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */