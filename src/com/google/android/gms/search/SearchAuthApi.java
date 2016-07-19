package com.google.android.gms.search;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

public abstract interface SearchAuthApi
{
  public abstract PendingResult<Status> clearToken(GoogleApiClient paramGoogleApiClient, String paramString);
  
  public abstract PendingResult<GoogleNowAuthResult> getGoogleNowAuth(GoogleApiClient paramGoogleApiClient, String paramString);
  
  public static abstract interface GoogleNowAuthResult
    extends Result
  {
    public abstract GoogleNowAuthState getGoogleNowAuthState();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.search.SearchAuthApi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */