package com.google.android.gms.wallet;

import com.google.android.gms.common.api.Api.ApiOptions.HasOptions;
import java.util.Locale;

public final class Wallet$WalletOptions
  implements Api.ApiOptions.HasOptions
{
  private final boolean aHG;
  public final int environment;
  public final int theme;
  
  private Wallet$WalletOptions()
  {
    this(new Builder());
  }
  
  private Wallet$WalletOptions(Builder paramBuilder)
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

/* Location:
 * Qualified Name:     com.google.android.gms.wallet.Wallet.WalletOptions
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */