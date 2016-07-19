package com.facebook;

import android.net.Uri;
import com.facebook.internal.Utility.GraphMeRequestWithCacheCallback;
import org.json.JSONObject;

final class Profile$1
  implements Utility.GraphMeRequestWithCacheCallback
{
  public void onFailure(FacebookException paramFacebookException) {}
  
  public void onSuccess(JSONObject paramJSONObject)
  {
    String str1 = paramJSONObject.optString("id");
    if (str1 == null) {
      return;
    }
    String str6 = paramJSONObject.optString("link");
    String str2 = paramJSONObject.optString("first_name");
    String str3 = paramJSONObject.optString("middle_name");
    String str4 = paramJSONObject.optString("last_name");
    String str5 = paramJSONObject.optString("name");
    if (str6 != null) {}
    for (paramJSONObject = Uri.parse(str6);; paramJSONObject = null)
    {
      Profile.setCurrentProfile(new Profile(str1, str2, str3, str4, str5, paramJSONObject));
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.facebook.Profile.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */