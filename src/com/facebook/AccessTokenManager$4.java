package com.facebook;

import java.util.Date;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

class AccessTokenManager$4
  implements GraphRequestBatch.Callback
{
  AccessTokenManager$4(AccessTokenManager paramAccessTokenManager, AccessToken paramAccessToken, AccessToken.AccessTokenRefreshCallback paramAccessTokenRefreshCallback, AtomicBoolean paramAtomicBoolean, AccessTokenManager.RefreshResult paramRefreshResult, Set paramSet1, Set paramSet2) {}
  
  public void onBatchCompleted(GraphRequestBatch paramGraphRequestBatch)
  {
    for (;;)
    {
      try
      {
        if ((AccessTokenManager.getInstance().getCurrentAccessToken() == null) || (AccessTokenManager.getInstance().getCurrentAccessToken().getUserId() != val$accessToken.getUserId()))
        {
          if (val$callback != null) {
            val$callback.OnTokenRefreshFailed(new FacebookException("No current access token to refresh"));
          }
          AccessTokenManager.access$200(this$0).set(false);
          if ((val$callback != null) && (0 != 0)) {
            val$callback.OnTokenRefreshed(null);
          }
          return;
        }
        if ((!val$permissionsCallSucceeded.get()) && (val$refreshResult.accessToken == null) && (val$refreshResult.expiresAt == 0))
        {
          if (val$callback != null) {
            val$callback.OnTokenRefreshFailed(new FacebookException("Failed to refresh access token"));
          }
          AccessTokenManager.access$200(this$0).set(false);
          if ((val$callback != null) && (0 != 0)) {
            val$callback.OnTokenRefreshed(null);
          }
          return;
        }
        if (val$refreshResult.accessToken != null)
        {
          paramGraphRequestBatch = val$refreshResult.accessToken;
          String str1 = val$accessToken.getApplicationId();
          String str2 = val$accessToken.getUserId();
          if (!val$permissionsCallSucceeded.get()) {
            continue;
          }
          localSet1 = val$permissions;
          if (!val$permissionsCallSucceeded.get()) {
            continue;
          }
          localSet2 = val$declinedPermissions;
          AccessTokenSource localAccessTokenSource = val$accessToken.getSource();
          if (val$refreshResult.expiresAt == 0) {
            continue;
          }
          localDate = new Date(val$refreshResult.expiresAt * 1000L);
          paramGraphRequestBatch = new AccessToken(paramGraphRequestBatch, str1, str2, localSet1, localSet2, localAccessTokenSource, localDate, new Date());
        }
      }
      finally
      {
        Set localSet1;
        Set localSet2;
        Date localDate;
        paramGraphRequestBatch = null;
      }
      try
      {
        AccessTokenManager.getInstance().setCurrentAccessToken(paramGraphRequestBatch);
        AccessTokenManager.access$200(this$0).set(false);
        if ((val$callback == null) || (paramGraphRequestBatch == null)) {
          continue;
        }
        val$callback.OnTokenRefreshed(paramGraphRequestBatch);
        return;
      }
      finally {}
      paramGraphRequestBatch = val$accessToken.getToken();
      continue;
      localSet1 = val$accessToken.getPermissions();
      continue;
      localSet2 = val$accessToken.getDeclinedPermissions();
      continue;
      localDate = val$accessToken.getExpires();
    }
    AccessTokenManager.access$200(this$0).set(false);
    if ((val$callback != null) && (paramGraphRequestBatch != null)) {
      val$callback.OnTokenRefreshed(paramGraphRequestBatch);
    }
    throw ((Throwable)localObject1);
  }
}

/* Location:
 * Qualified Name:     com.facebook.AccessTokenManager.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */