package com.google.android.gms.wallet;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.HasOptions;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzf;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.internal.zzaek;
import com.google.android.gms.internal.zzael;
import com.google.android.gms.internal.zzaen;
import com.google.android.gms.internal.zzaeo;
import com.google.android.gms.internal.zzpr.zza;
import com.google.android.gms.wallet.firstparty.zza;
import com.google.android.gms.wallet.wobs.zzj;
import java.util.Locale;

public final class Wallet
{
  public static final Api<WalletOptions> API = new Api("Wallet.API", bO, bN);
  public static final Payments Payments = new zzaek();
  public static final zzj aHE = new zzaeo();
  public static final zza aHF = new zzaen();
  private static final Api.zzf<zzael> bN = new Api.zzf();
  private static final Api.zza<zzael, WalletOptions> bO = new Api.zza()
  {
    public zzael zza(Context paramAnonymousContext, Looper paramAnonymousLooper, zzg paramAnonymouszzg, Wallet.WalletOptions paramAnonymousWalletOptions, GoogleApiClient.ConnectionCallbacks paramAnonymousConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramAnonymousOnConnectionFailedListener)
    {
      if (paramAnonymousWalletOptions != null) {}
      for (;;)
      {
        return new zzael(paramAnonymousContext, paramAnonymousLooper, paramAnonymouszzg, paramAnonymousConnectionCallbacks, paramAnonymousOnConnectionFailedListener, environment, theme, Wallet.WalletOptions.zza(paramAnonymousWalletOptions));
        paramAnonymousWalletOptions = new Wallet.WalletOptions(null);
      }
    }
  };
  
  public static final class WalletOptions
    implements Api.ApiOptions.HasOptions
  {
    private final boolean aHG;
    public final int environment;
    public final int theme;
    
    private WalletOptions()
    {
      this(new Builder());
    }
    
    private WalletOptions(Builder paramBuilder)
    {
      environment = Builder.zza(paramBuilder);
      theme = Builder.zzb(paramBuilder);
      aHG = Builder.zzc(paramBuilder);
    }
    
    public static final class Builder
    {
      private int aHH = 3;
      private boolean aHI = true;
      private int mTheme = 0;
      
      public Wallet.WalletOptions build()
      {
        return new Wallet.WalletOptions(this, null);
      }
      
      public Builder setEnvironment(int paramInt)
      {
        if ((paramInt == 0) || (paramInt == 2) || (paramInt == 1) || (paramInt == 3))
        {
          aHH = paramInt;
          return this;
        }
        throw new IllegalArgumentException(String.format(Locale.US, "Invalid environment value %d", new Object[] { Integer.valueOf(paramInt) }));
      }
      
      public Builder setTheme(int paramInt)
      {
        if ((paramInt == 0) || (paramInt == 1))
        {
          mTheme = paramInt;
          return this;
        }
        throw new IllegalArgumentException(String.format(Locale.US, "Invalid theme value %d", new Object[] { Integer.valueOf(paramInt) }));
      }
    }
  }
  
  public static abstract class zza<R extends Result>
    extends zzpr.zza<R, zzael>
  {
    public zza(GoogleApiClient paramGoogleApiClient)
    {
      super(paramGoogleApiClient);
    }
  }
  
  public static abstract class zzb
    extends Wallet.zza<Status>
  {
    public zzb(GoogleApiClient paramGoogleApiClient)
    {
      super();
    }
    
    protected Status zzb(Status paramStatus)
    {
      return paramStatus;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wallet.Wallet
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */