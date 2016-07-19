package com.google.android.gms.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.search.GoogleNowAuthState;
import com.google.android.gms.search.SearchAuthApi.GoogleNowAuthResult;

class zzvv$zzd
  implements SearchAuthApi.GoogleNowAuthResult
{
  private final GoogleNowAuthState auf;
  private final Status cc;
  
  zzvv$zzd(Status paramStatus, GoogleNowAuthState paramGoogleNowAuthState)
  {
    cc = paramStatus;
    auf = paramGoogleNowAuthState;
  }
  
  public GoogleNowAuthState getGoogleNowAuthState()
  {
    return auf;
  }
  
  public Status getStatus()
  {
    return cc;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzvv.zzd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */