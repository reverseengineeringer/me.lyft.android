package com.facebook.login;

import android.os.Bundle;
import com.facebook.FacebookException;
import com.facebook.internal.Utility.GraphMeRequestWithCacheCallback;
import org.json.JSONException;
import org.json.JSONObject;

class GetTokenLoginMethodHandler$2
  implements Utility.GraphMeRequestWithCacheCallback
{
  GetTokenLoginMethodHandler$2(GetTokenLoginMethodHandler paramGetTokenLoginMethodHandler, Bundle paramBundle, LoginClient.Request paramRequest) {}
  
  public void onFailure(FacebookException paramFacebookException)
  {
    this$0.loginClient.complete(LoginClient.Result.createErrorResult(this$0.loginClient.getPendingRequest(), "Caught exception", paramFacebookException.getMessage()));
  }
  
  public void onSuccess(JSONObject paramJSONObject)
  {
    try
    {
      paramJSONObject = paramJSONObject.getString("id");
      val$result.putString("com.facebook.platform.extra.USER_ID", paramJSONObject);
      this$0.onComplete(val$request, val$result);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      this$0.loginClient.complete(LoginClient.Result.createErrorResult(this$0.loginClient.getPendingRequest(), "Caught exception", paramJSONObject.getMessage()));
    }
  }
}

/* Location:
 * Qualified Name:     com.facebook.login.GetTokenLoginMethodHandler.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */