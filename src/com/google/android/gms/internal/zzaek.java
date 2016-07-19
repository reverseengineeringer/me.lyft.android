package com.google.android.gms.internal;

import android.annotation.SuppressLint;
import com.google.android.gms.common.api.BooleanResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wallet.FullWalletRequest;
import com.google.android.gms.wallet.IsReadyToPayRequest;
import com.google.android.gms.wallet.IsReadyToPayRequest.zza;
import com.google.android.gms.wallet.MaskedWalletRequest;
import com.google.android.gms.wallet.Payments;
import com.google.android.gms.wallet.Wallet.zza;
import com.google.android.gms.wallet.Wallet.zzb;

@SuppressLint({"MissingRemoteException"})
public class zzaek
  implements Payments
{
  public void changeMaskedWallet(GoogleApiClient paramGoogleApiClient, final String paramString1, final String paramString2, final int paramInt)
  {
    paramGoogleApiClient.zzc(new Wallet.zzb(paramGoogleApiClient)
    {
      protected void zza(zzael paramAnonymouszzael)
      {
        paramAnonymouszzael.zzf(paramString1, paramString2, paramInt);
        zzc(Status.sg);
      }
    });
  }
  
  public PendingResult<BooleanResult> isReadyToPay(GoogleApiClient paramGoogleApiClient)
  {
    paramGoogleApiClient.zzc(new Wallet.zza(paramGoogleApiClient)
    {
      protected void zza(zzael paramAnonymouszzael)
      {
        paramAnonymouszzael.zza(IsReadyToPayRequest.zzchz().zzcia(), this);
      }
      
      protected BooleanResult zzaj(Status paramAnonymousStatus)
      {
        return new BooleanResult(paramAnonymousStatus, false);
      }
    });
  }
  
  public void loadFullWallet(GoogleApiClient paramGoogleApiClient, final FullWalletRequest paramFullWalletRequest, final int paramInt)
  {
    paramGoogleApiClient.zzc(new Wallet.zzb(paramGoogleApiClient)
    {
      protected void zza(zzael paramAnonymouszzael)
      {
        paramAnonymouszzael.zza(paramFullWalletRequest, paramInt);
        zzc(Status.sg);
      }
    });
  }
  
  public void loadMaskedWallet(GoogleApiClient paramGoogleApiClient, final MaskedWalletRequest paramMaskedWalletRequest, final int paramInt)
  {
    paramGoogleApiClient.zzc(new Wallet.zzb(paramGoogleApiClient)
    {
      protected void zza(zzael paramAnonymouszzael)
      {
        paramAnonymouszzael.zza(paramMaskedWalletRequest, paramInt);
        zzc(Status.sg);
      }
    });
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzaek
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */