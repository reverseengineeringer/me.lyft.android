package com.crashlytics.android.core;

import org.json.JSONException;
import org.json.JSONObject;

final class MetaDataStore$1
  extends JSONObject
{
  MetaDataStore$1(UserMetaData paramUserMetaData)
    throws JSONException
  {
    put("userId", val$userData.id);
    put("userName", val$userData.name);
    put("userEmail", val$userData.email);
  }
}

/* Location:
 * Qualified Name:     com.crashlytics.android.core.MetaDataStore.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */