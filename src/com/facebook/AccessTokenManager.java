package com.facebook;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

final class AccessTokenManager
{
  static final String ACTION_CURRENT_ACCESS_TOKEN_CHANGED = "com.facebook.sdk.ACTION_CURRENT_ACCESS_TOKEN_CHANGED";
  static final String EXTRA_NEW_ACCESS_TOKEN = "com.facebook.sdk.EXTRA_NEW_ACCESS_TOKEN";
  static final String EXTRA_OLD_ACCESS_TOKEN = "com.facebook.sdk.EXTRA_OLD_ACCESS_TOKEN";
  private static final String ME_PERMISSIONS_GRAPH_PATH = "me/permissions";
  static final String SHARED_PREFERENCES_NAME = "com.facebook.AccessTokenManager.SharedPreferences";
  static final String TAG = "AccessTokenManager";
  private static final String TOKEN_EXTEND_GRAPH_PATH = "oauth/access_token";
  private static final int TOKEN_EXTEND_RETRY_SECONDS = 3600;
  private static final int TOKEN_EXTEND_THRESHOLD_SECONDS = 86400;
  private static volatile AccessTokenManager instance;
  private final AccessTokenCache accessTokenCache;
  private AccessToken currentAccessToken;
  private Date lastAttemptedTokenExtendDate = new Date(0L);
  private final LocalBroadcastManager localBroadcastManager;
  private AtomicBoolean tokenRefreshInProgress = new AtomicBoolean(false);
  
  AccessTokenManager(LocalBroadcastManager paramLocalBroadcastManager, AccessTokenCache paramAccessTokenCache)
  {
    Validate.notNull(paramLocalBroadcastManager, "localBroadcastManager");
    Validate.notNull(paramAccessTokenCache, "accessTokenCache");
    localBroadcastManager = paramLocalBroadcastManager;
    accessTokenCache = paramAccessTokenCache;
  }
  
  private static GraphRequest createExtendAccessTokenRequest(AccessToken paramAccessToken, GraphRequest.Callback paramCallback)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("grant_type", "fb_extend_sso_token");
    return new GraphRequest(paramAccessToken, "oauth/access_token", localBundle, HttpMethod.GET, paramCallback);
  }
  
  private static GraphRequest createGrantedPermissionsRequest(AccessToken paramAccessToken, GraphRequest.Callback paramCallback)
  {
    return new GraphRequest(paramAccessToken, "me/permissions", new Bundle(), HttpMethod.GET, paramCallback);
  }
  
  static AccessTokenManager getInstance()
  {
    if (instance == null) {}
    try
    {
      if (instance == null) {
        instance = new AccessTokenManager(LocalBroadcastManager.getInstance(FacebookSdk.getApplicationContext()), new AccessTokenCache());
      }
      return instance;
    }
    finally {}
  }
  
  private void refreshCurrentAccessTokenImpl(final AccessToken.AccessTokenRefreshCallback paramAccessTokenRefreshCallback)
  {
    final AccessToken localAccessToken = currentAccessToken;
    if (localAccessToken == null) {
      if (paramAccessTokenRefreshCallback != null) {
        paramAccessTokenRefreshCallback.OnTokenRefreshFailed(new FacebookException("No current access token to refresh"));
      }
    }
    do
    {
      return;
      if (tokenRefreshInProgress.compareAndSet(false, true)) {
        break;
      }
    } while (paramAccessTokenRefreshCallback == null);
    paramAccessTokenRefreshCallback.OnTokenRefreshFailed(new FacebookException("Refresh already in progress"));
    return;
    lastAttemptedTokenExtendDate = new Date();
    final HashSet localHashSet1 = new HashSet();
    final HashSet localHashSet2 = new HashSet();
    final AtomicBoolean localAtomicBoolean = new AtomicBoolean(false);
    final RefreshResult localRefreshResult = new RefreshResult(null);
    GraphRequestBatch localGraphRequestBatch = new GraphRequestBatch(new GraphRequest[] { createGrantedPermissionsRequest(localAccessToken, new GraphRequest.Callback()
    {
      public void onCompleted(GraphResponse paramAnonymousGraphResponse)
      {
        paramAnonymousGraphResponse = paramAnonymousGraphResponse.getJSONObject();
        if (paramAnonymousGraphResponse == null) {}
        do
        {
          return;
          paramAnonymousGraphResponse = paramAnonymousGraphResponse.optJSONArray("data");
        } while (paramAnonymousGraphResponse == null);
        localAtomicBoolean.set(true);
        int i = 0;
        label31:
        Object localObject;
        if (i < paramAnonymousGraphResponse.length())
        {
          localObject = paramAnonymousGraphResponse.optJSONObject(i);
          if (localObject != null) {
            break label58;
          }
        }
        for (;;)
        {
          i += 1;
          break label31;
          break;
          label58:
          String str = ((JSONObject)localObject).optString("permission");
          localObject = ((JSONObject)localObject).optString("status");
          if ((!Utility.isNullOrEmpty(str)) && (!Utility.isNullOrEmpty((String)localObject)))
          {
            localObject = ((String)localObject).toLowerCase(Locale.US);
            if (((String)localObject).equals("granted")) {
              localHashSet1.add(str);
            } else if (((String)localObject).equals("declined")) {
              localHashSet2.add(str);
            } else {
              Log.w("AccessTokenManager", "Unexpected status: " + (String)localObject);
            }
          }
        }
      }
    }), createExtendAccessTokenRequest(localAccessToken, new GraphRequest.Callback()
    {
      public void onCompleted(GraphResponse paramAnonymousGraphResponse)
      {
        paramAnonymousGraphResponse = paramAnonymousGraphResponse.getJSONObject();
        if (paramAnonymousGraphResponse == null) {
          return;
        }
        localRefreshResultaccessToken = paramAnonymousGraphResponse.optString("access_token");
        localRefreshResultexpiresAt = paramAnonymousGraphResponse.optInt("expires_at");
      }
    }) });
    localGraphRequestBatch.addCallback(new GraphRequestBatch.Callback()
    {
      public void onBatchCompleted(GraphRequestBatch paramAnonymousGraphRequestBatch)
      {
        for (;;)
        {
          try
          {
            if ((AccessTokenManager.getInstance().getCurrentAccessToken() == null) || (AccessTokenManager.getInstance().getCurrentAccessToken().getUserId() != localAccessToken.getUserId()))
            {
              if (paramAccessTokenRefreshCallback != null) {
                paramAccessTokenRefreshCallback.OnTokenRefreshFailed(new FacebookException("No current access token to refresh"));
              }
              tokenRefreshInProgress.set(false);
              if ((paramAccessTokenRefreshCallback != null) && (0 != 0)) {
                paramAccessTokenRefreshCallback.OnTokenRefreshed(null);
              }
              return;
            }
            if ((!localAtomicBoolean.get()) && (localRefreshResultaccessToken == null) && (localRefreshResultexpiresAt == 0))
            {
              if (paramAccessTokenRefreshCallback != null) {
                paramAccessTokenRefreshCallback.OnTokenRefreshFailed(new FacebookException("Failed to refresh access token"));
              }
              tokenRefreshInProgress.set(false);
              if ((paramAccessTokenRefreshCallback != null) && (0 != 0)) {
                paramAccessTokenRefreshCallback.OnTokenRefreshed(null);
              }
              return;
            }
            if (localRefreshResultaccessToken != null)
            {
              paramAnonymousGraphRequestBatch = localRefreshResultaccessToken;
              String str1 = localAccessToken.getApplicationId();
              String str2 = localAccessToken.getUserId();
              if (!localAtomicBoolean.get()) {
                continue;
              }
              localSet1 = localHashSet1;
              if (!localAtomicBoolean.get()) {
                continue;
              }
              localSet2 = localHashSet2;
              AccessTokenSource localAccessTokenSource = localAccessToken.getSource();
              if (localRefreshResultexpiresAt == 0) {
                continue;
              }
              localDate = new Date(localRefreshResultexpiresAt * 1000L);
              paramAnonymousGraphRequestBatch = new AccessToken(paramAnonymousGraphRequestBatch, str1, str2, localSet1, localSet2, localAccessTokenSource, localDate, new Date());
            }
          }
          finally
          {
            Set localSet1;
            Set localSet2;
            Date localDate;
            paramAnonymousGraphRequestBatch = null;
          }
          try
          {
            AccessTokenManager.getInstance().setCurrentAccessToken(paramAnonymousGraphRequestBatch);
            tokenRefreshInProgress.set(false);
            if ((paramAccessTokenRefreshCallback == null) || (paramAnonymousGraphRequestBatch == null)) {
              continue;
            }
            paramAccessTokenRefreshCallback.OnTokenRefreshed(paramAnonymousGraphRequestBatch);
            return;
          }
          finally {}
          paramAnonymousGraphRequestBatch = localAccessToken.getToken();
          continue;
          localSet1 = localAccessToken.getPermissions();
          continue;
          localSet2 = localAccessToken.getDeclinedPermissions();
          continue;
          localDate = localAccessToken.getExpires();
        }
        tokenRefreshInProgress.set(false);
        if ((paramAccessTokenRefreshCallback != null) && (paramAnonymousGraphRequestBatch != null)) {
          paramAccessTokenRefreshCallback.OnTokenRefreshed(paramAnonymousGraphRequestBatch);
        }
        throw ((Throwable)localObject1);
      }
    });
    localGraphRequestBatch.executeAsync();
  }
  
  private void sendCurrentAccessTokenChangedBroadcast(AccessToken paramAccessToken1, AccessToken paramAccessToken2)
  {
    Intent localIntent = new Intent("com.facebook.sdk.ACTION_CURRENT_ACCESS_TOKEN_CHANGED");
    localIntent.putExtra("com.facebook.sdk.EXTRA_OLD_ACCESS_TOKEN", paramAccessToken1);
    localIntent.putExtra("com.facebook.sdk.EXTRA_NEW_ACCESS_TOKEN", paramAccessToken2);
    localBroadcastManager.sendBroadcast(localIntent);
  }
  
  private void setCurrentAccessToken(AccessToken paramAccessToken, boolean paramBoolean)
  {
    AccessToken localAccessToken = currentAccessToken;
    currentAccessToken = paramAccessToken;
    tokenRefreshInProgress.set(false);
    lastAttemptedTokenExtendDate = new Date(0L);
    if (paramBoolean)
    {
      if (paramAccessToken == null) {
        break label61;
      }
      accessTokenCache.save(paramAccessToken);
    }
    for (;;)
    {
      if (!Utility.areObjectsEqual(localAccessToken, paramAccessToken)) {
        sendCurrentAccessTokenChangedBroadcast(localAccessToken, paramAccessToken);
      }
      return;
      label61:
      accessTokenCache.clear();
      Utility.clearFacebookCookies(FacebookSdk.getApplicationContext());
    }
  }
  
  private boolean shouldExtendAccessToken()
  {
    if (currentAccessToken == null) {}
    Long localLong;
    do
    {
      return false;
      localLong = Long.valueOf(new Date().getTime());
    } while ((!currentAccessToken.getSource().canExtendToken()) || (localLong.longValue() - lastAttemptedTokenExtendDate.getTime() <= 3600000L) || (localLong.longValue() - currentAccessToken.getLastRefresh().getTime() <= 86400000L));
    return true;
  }
  
  void extendAccessTokenIfNeeded()
  {
    if (!shouldExtendAccessToken()) {
      return;
    }
    refreshCurrentAccessToken(null);
  }
  
  AccessToken getCurrentAccessToken()
  {
    return currentAccessToken;
  }
  
  boolean loadCurrentAccessToken()
  {
    boolean bool = false;
    AccessToken localAccessToken = accessTokenCache.load();
    if (localAccessToken != null)
    {
      setCurrentAccessToken(localAccessToken, false);
      bool = true;
    }
    return bool;
  }
  
  void refreshCurrentAccessToken(final AccessToken.AccessTokenRefreshCallback paramAccessTokenRefreshCallback)
  {
    if (Looper.getMainLooper().equals(Looper.myLooper()))
    {
      refreshCurrentAccessTokenImpl(paramAccessTokenRefreshCallback);
      return;
    }
    new Handler(Looper.getMainLooper()).post(new Runnable()
    {
      public void run()
      {
        AccessTokenManager.this.refreshCurrentAccessTokenImpl(paramAccessTokenRefreshCallback);
      }
    });
  }
  
  void setCurrentAccessToken(AccessToken paramAccessToken)
  {
    setCurrentAccessToken(paramAccessToken, true);
  }
  
  private static class RefreshResult
  {
    public String accessToken;
    public int expiresAt;
  }
}

/* Location:
 * Qualified Name:     com.facebook.AccessTokenManager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */