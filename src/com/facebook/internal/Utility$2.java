package com.facebook.internal;

import com.facebook.FacebookRequestError;
import com.facebook.GraphRequest.Callback;
import com.facebook.GraphResponse;

final class Utility$2
  implements GraphRequest.Callback
{
  Utility$2(Utility.GraphMeRequestWithCacheCallback paramGraphMeRequestWithCacheCallback, String paramString) {}
  
  public void onCompleted(GraphResponse paramGraphResponse)
  {
    if (paramGraphResponse.getError() != null)
    {
      val$callback.onFailure(paramGraphResponse.getError().getException());
      return;
    }
    ProfileInformationCache.putProfileInformation(val$accessToken, paramGraphResponse.getJSONObject());
    val$callback.onSuccess(paramGraphResponse.getJSONObject());
  }
}

/* Location:
 * Qualified Name:     com.facebook.internal.Utility.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */