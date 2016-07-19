package com.facebook;

import android.os.Bundle;
import com.facebook.internal.Utility.GraphMeRequestWithCacheCallback;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

final class AccessToken$1
  implements Utility.GraphMeRequestWithCacheCallback
{
  AccessToken$1(Bundle paramBundle, AccessToken.AccessTokenCreationCallback paramAccessTokenCreationCallback, String paramString) {}
  
  public void onFailure(FacebookException paramFacebookException)
  {
    val$accessTokenCallback.onError(paramFacebookException);
  }
  
  public void onSuccess(JSONObject paramJSONObject)
  {
    try
    {
      paramJSONObject = paramJSONObject.getString("id");
      val$extras.putString("user_id", paramJSONObject);
      val$accessTokenCallback.onSuccess(AccessToken.access$000(null, val$extras, AccessTokenSource.FACEBOOK_APPLICATION_WEB, new Date(), val$applicationId));
      return;
    }
    catch (JSONException paramJSONObject)
    {
      val$accessTokenCallback.onError(new FacebookException("Unable to generate access token due to missing user id"));
    }
  }
}

/* Location:
 * Qualified Name:     com.facebook.AccessToken.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */