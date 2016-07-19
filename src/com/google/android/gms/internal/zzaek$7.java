package com.google.android.gms.internal;

import com.google.android.gms.common.api.BooleanResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wallet.IsReadyToPayRequest;
import com.google.android.gms.wallet.IsReadyToPayRequest.zza;
import com.google.android.gms.wallet.Wallet.zza;

class zzaek$7
  extends Wallet.zza<BooleanResult>
{
  zzaek$7(zzaek paramzzaek, GoogleApiClient paramGoogleApiClient)
  {
    super(paramGoogleApiClient);
  }
  
  protected void zza(zzael paramzzael)
  {
    paramzzael.zza(IsReadyToPayRequest.zzchz().zzcia(), this);
  }
  
  protected BooleanResult zzaj(Status paramStatus)
  {
    return new BooleanResult(paramStatus, false);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzaek.7
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */