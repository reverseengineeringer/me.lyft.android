package com.facebook.share.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.FacebookSdk;
import com.facebook.internal.FileLruCache;
import java.util.concurrent.ConcurrentHashMap;

final class LikeActionController$5
  extends AccessTokenTracker
{
  protected void onCurrentAccessTokenChanged(AccessToken paramAccessToken1, AccessToken paramAccessToken2)
  {
    paramAccessToken1 = FacebookSdk.getApplicationContext();
    if (paramAccessToken2 == null)
    {
      LikeActionController.access$302((LikeActionController.access$300() + 1) % 1000);
      paramAccessToken1.getSharedPreferences("com.facebook.LikeActionController.CONTROLLER_STORE_KEY", 0).edit().putInt("OBJECT_SUFFIX", LikeActionController.access$300()).apply();
      LikeActionController.access$400().clear();
      LikeActionController.access$500().clearCache();
    }
    LikeActionController.access$600(null, "com.facebook.sdk.LikeActionController.DID_RESET");
  }
}

/* Location:
 * Qualified Name:     com.facebook.share.internal.LikeActionController.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */