package com.google.android.gms.wallet.fragment;

import android.os.Bundle;
import com.google.android.gms.internal.zzaef.zza;

class SupportWalletFragment$zza
  extends zzaef.zza
{
  private SupportWalletFragment.OnStateChangedListener aIf;
  private final SupportWalletFragment aIg;
  
  SupportWalletFragment$zza(SupportWalletFragment paramSupportWalletFragment)
  {
    aIg = paramSupportWalletFragment;
  }
  
  public void zza(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    if (aIf != null) {
      aIf.onStateChanged(aIg, paramInt1, paramInt2, paramBundle);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wallet.fragment.SupportWalletFragment.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */