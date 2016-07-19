package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.search.SearchAuth;

class zzvv$zzb
  extends zzpr.zza<Status, zzvu>
{
  private final String atX;
  private final String aua;
  private final boolean aub = Log.isLoggable("SearchAuth", 3);
  
  protected zzvv$zzb(GoogleApiClient paramGoogleApiClient, String paramString)
  {
    super(SearchAuth.API, paramGoogleApiClient);
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

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzvv.zzb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */