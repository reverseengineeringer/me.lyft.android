package com.google.android.gms.ads.mediation;

import android.os.Bundle;

public abstract interface MediationAdapter
{
  public abstract void onDestroy();
  
  public abstract void onPause();
  
  public abstract void onResume();
  
  public static class zza
  {
    private int zzcqr;
    
    public zza zzbb(int paramInt)
    {
      zzcqr = paramInt;
      return this;
    }
    
    public Bundle zzvp()
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("capabilities", zzcqr);
      return localBundle;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.mediation.MediationAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */