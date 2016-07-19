package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.search.GoogleNowAuthState;
import com.google.android.gms.search.SearchAuth;
import com.google.android.gms.search.SearchAuthApi.GoogleNowAuthResult;

class zzvv$zzc
  extends zzpr.zza<SearchAuthApi.GoogleNowAuthResult, zzvu>
{
  private final String aua;
  private final boolean aub = Log.isLoggable("SearchAuth", 3);
  private final String aud;
  
  protected zzvv$zzc(GoogleApiClient paramGoogleApiClient, String paramString)
  {
    super(SearchAuth.API, paramGoogleApiClient);
    aud = paramString;
    aua = paramGoogleApiClient.getContext().getPackageName();
  }
  
  protected void zza(zzvu paramzzvu)
    throws RemoteException
  {
    if (aub) {
      Log.d("SearchAuth", "GetGoogleNowAuthImpl started");
    }
    zzvv.zza local1 = new zzvv.zza()
    {
      public void zza(Status paramAnonymousStatus, GoogleNowAuthState paramAnonymousGoogleNowAuthState)
      {
        if (zzvv.zzc.zza(zzvv.zzc.this)) {
          Log.d("SearchAuth", "GetGoogleNowAuthImpl success");
        }
        zzc(new zzvv.zzd(paramAnonymousStatus, paramAnonymousGoogleNowAuthState));
      }
    };
    ((zzvt)paramzzvu.zzarw()).zza(local1, aua, aud);
  }
  
  protected SearchAuthApi.GoogleNowAuthResult zzdz(Status paramStatus)
  {
    if (aub)
    {
      str = String.valueOf(paramStatus.getStatusMessage());
      if (str.length() == 0) {
        break label46;
      }
    }
    label46:
    for (String str = "GetGoogleNowAuthImpl received failure: ".concat(str);; str = new String("GetGoogleNowAuthImpl received failure: "))
    {
      Log.d("SearchAuth", str);
      return new zzvv.zzd(paramStatus, null);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzvv.zzc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */