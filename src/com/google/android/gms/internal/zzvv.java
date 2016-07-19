package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.search.GoogleNowAuthState;
import com.google.android.gms.search.SearchAuth;
import com.google.android.gms.search.SearchAuthApi;
import com.google.android.gms.search.SearchAuthApi.GoogleNowAuthResult;

public class zzvv
  implements SearchAuthApi
{
  public PendingResult<Status> clearToken(GoogleApiClient paramGoogleApiClient, String paramString)
  {
    return paramGoogleApiClient.zzc(new zzb(paramGoogleApiClient, paramString));
  }
  
  public PendingResult<SearchAuthApi.GoogleNowAuthResult> getGoogleNowAuth(GoogleApiClient paramGoogleApiClient, String paramString)
  {
    return paramGoogleApiClient.zzc(new zzc(paramGoogleApiClient, paramString));
  }
  
  static abstract class zza
    extends zzvs.zza
  {
    public void zza(Status paramStatus, GoogleNowAuthState paramGoogleNowAuthState)
    {
      throw new UnsupportedOperationException();
    }
    
    public void zzdy(Status paramStatus)
    {
      throw new UnsupportedOperationException();
    }
  }
  
  static class zzb
    extends zzpr.zza<Status, zzvu>
  {
    private final String atX;
    private final String aua;
    private final boolean aub = Log.isLoggable("SearchAuth", 3);
    
    protected zzb(GoogleApiClient paramGoogleApiClient, String paramString)
    {
      super(paramGoogleApiClient);
      atX = paramString;
      aua = paramGoogleApiClient.getContext().getPackageName();
    }
    
    protected void zza(zzvu paramzzvu)
      throws RemoteException
    {
      if (aub) {
        Log.d("SearchAuth", "ClearTokenImpl started");
      }
      zzvv.zza local1 = new zzvv.zza()
      {
        public void zzdy(Status paramAnonymousStatus)
        {
          if (zzvv.zzb.zza(zzvv.zzb.this)) {
            Log.d("SearchAuth", "ClearTokenImpl success");
          }
          zzc(paramAnonymousStatus);
        }
      };
      ((zzvt)paramzzvu.zzarw()).zzb(local1, aua, atX);
    }
    
    protected Status zzb(Status paramStatus)
    {
      if (aub)
      {
        str = String.valueOf(paramStatus.getStatusMessage());
        if (str.length() == 0) {
          break label38;
        }
      }
      label38:
      for (String str = "ClearTokenImpl received failure: ".concat(str);; str = new String("ClearTokenImpl received failure: "))
      {
        Log.d("SearchAuth", str);
        return paramStatus;
      }
    }
  }
  
  static class zzc
    extends zzpr.zza<SearchAuthApi.GoogleNowAuthResult, zzvu>
  {
    private final String aua;
    private final boolean aub = Log.isLoggable("SearchAuth", 3);
    private final String aud;
    
    protected zzc(GoogleApiClient paramGoogleApiClient, String paramString)
    {
      super(paramGoogleApiClient);
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
  
  static class zzd
    implements SearchAuthApi.GoogleNowAuthResult
  {
    private final GoogleNowAuthState auf;
    private final Status cc;
    
    zzd(Status paramStatus, GoogleNowAuthState paramGoogleNowAuthState)
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
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzvv
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */