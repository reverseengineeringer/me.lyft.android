package com.facebook;

import org.json.JSONObject;

class AccessTokenManager$3
  implements GraphRequest.Callback
{
  AccessTokenManager$3(AccessTokenManager paramAccessTokenManager, AccessTokenManager.RefreshResult paramRefreshResult) {}
  
  public void onCompleted(GraphResponse paramGraphResponse)
  {
    paramGraphResponse = paramGraphResponse.getJSONObject();
    if (paramGraphResponse == null) {
      return;
    }
    val$refreshResult.accessToken = paramGraphResponse.optString("access_token");
    val$refreshResult.expiresAt = paramGraphResponse.optInt("expires_at");
  }
}

/* Location:
 * Qualified Name:     com.facebook.AccessTokenManager.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */