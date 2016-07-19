package com.facebook;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.facebook.internal.Validate;
import org.json.JSONException;
import org.json.JSONObject;

final class ProfileCache
{
  static final String CACHED_PROFILE_KEY = "com.facebook.ProfileManager.CachedProfile";
  static final String SHARED_PREFERENCES_NAME = "com.facebook.AccessTokenManager.SharedPreferences";
  private final SharedPreferences sharedPreferences = FacebookSdk.getApplicationContext().getSharedPreferences("com.facebook.AccessTokenManager.SharedPreferences", 0);
  
  void clear()
  {
    sharedPreferences.edit().remove("com.facebook.ProfileManager.CachedProfile").apply();
  }
  
  Profile load()
  {
    Object localObject = sharedPreferences.getString("com.facebook.ProfileManager.CachedProfile", null);
    if (localObject != null) {
      try
      {
        localObject = new Profile(new JSONObject((String)localObject));
        return (Profile)localObject;
      }
      catch (JSONException localJSONException) {}
    }
    return null;
  }
  
  void save(Profile paramProfile)
  {
    Validate.notNull(paramProfile, "profile");
    paramProfile = paramProfile.toJSONObject();
    if (paramProfile != null) {
      sharedPreferences.edit().putString("com.facebook.ProfileManager.CachedProfile", paramProfile.toString()).apply();
    }
  }
}

/* Location:
 * Qualified Name:     com.facebook.ProfileCache
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */