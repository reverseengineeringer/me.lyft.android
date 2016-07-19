package com.google.android.gms.internal;

@zzir
public final class zzgg
  extends zzgp.zza
{
  private final Object zzail = new Object();
  private zzgi.zza zzboe;
  private zzgf zzbof;
  
  public void onAdClicked()
  {
    synchronized (zzail)
    {
      if (zzbof != null) {
        zzbof.zzea();
      }
      return;
    }
  }
  
  public void onAdClosed()
  {
    synchronized (zzail)
    {
      if (zzbof != null) {
        zzbof.zzeb();
      }
      return;
    }
  }
  
  public void onAdFailedToLoad(int paramInt)
  {
    for (;;)
    {
      synchronized (zzail)
      {
        if (zzboe != null)
        {
          if (paramInt == 3)
          {
            paramInt = 1;
            zzboe.zzy(paramInt);
            zzboe = null;
          }
        }
        else {
          return;
        }
      }
      paramInt = 2;
    }
  }
  
  public void onAdImpression()
  {
    synchronized (zzail)
    {
      if (zzbof != null) {
        zzbof.zzef();
      }
      return;
    }
  }
  
  public void onAdLeftApplication()
  {
    synchronized (zzail)
    {
      if (zzbof != null) {
        zzbof.zzec();
      }
      return;
    }
  }
  
  public void onAdLoaded()
  {
    synchronized (zzail)
    {
      if (zzboe != null)
      {
        zzboe.zzy(0);
        zzboe = null;
        return;
      }
      if (zzbof != null) {
        zzbof.zzee();
      }
      return;
    }
  }
  
  public void onAdOpened()
  {
    synchronized (zzail)
    {
      if (zzbof != null) {
        zzbof.zzed();
      }
      return;
    }
  }
  
  public void zza(zzgf paramzzgf)
  {
    synchronized (zzail)
    {
      zzbof = paramzzgf;
      return;
    }
  }
  
  public void zza(zzgi.zza paramzza)
  {
    synchronized (zzail)
    {
      zzboe = paramzza;
      return;
    }
  }
  
  public void zza(zzgq paramzzgq)
  {
    synchronized (zzail)
    {
      if (zzboe != null)
      {
        zzboe.zza(0, paramzzgq);
        zzboe = null;
        return;
      }
      if (zzbof != null) {
        zzbof.zzee();
      }
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzgg
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */