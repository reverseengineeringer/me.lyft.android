package com.google.android.gms.wallet;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.internal.zzael;

final class Wallet$1
  extends Api.zza<zzael, Wallet.WalletOptions>
{
  public zzael zza(Context paramContext, Looper paramLooper, zzg paramzzg, Wallet.WalletOptions paramWalletOptions, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    if (paramWalletOptions != null) {}
    for (;;)
    {
      return new zzael(paramContext, paramLooper, paramzzg, paramConnectionCallbacks, paramOnConnectionFailedListener, environment, theme, Wallet.WalletOptions.zza(paramWalletOptions));
      paramWalletOptions = new Wallet.WalletOptions(null);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wallet.Wallet.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */