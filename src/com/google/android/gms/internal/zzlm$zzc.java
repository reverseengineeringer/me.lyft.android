package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.overlay.zzg;

class zzlm$zzc
  implements zzg
{
  private zzg zzcoq;
  private zzll zzcpc;
  
  public zzlm$zzc(zzll paramzzll, zzg paramzzg)
  {
    zzcpc = paramzzll;
    zzcoq = paramzzg;
  }
  
  public void onPause() {}
  
  public void onResume() {}
  
  public void zzdy()
  {
    zzcoq.zzdy();
    zzcpc.zzud();
  }
  
  public void zzdz()
  {
    zzcoq.zzdz();
    zzcpc.zzoc();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzlm.zzc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */