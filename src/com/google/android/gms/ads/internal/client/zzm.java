package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.internal.reward.client.zzf;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.internal.zzei;
import com.google.android.gms.internal.zzhl;
import com.google.android.gms.internal.zzhy;
import com.google.android.gms.internal.zzir;

@zzir
public class zzm
{
  private static final Object zzamp = new Object();
  private static zzm zzavk;
  private final zza zzavl = new zza();
  private final zzl zzavm = new zzl(new zze(), new zzd(), new zzai(), new zzei(), new zzf(), new zzhy(), new zzhl());
  
  static
  {
    zza(new zzm());
  }
  
  protected static void zza(zzm paramzzm)
  {
    synchronized (zzamp)
    {
      zzavk = paramzzm;
      return;
    }
  }
  
  private static zzm zziv()
  {
    synchronized (zzamp)
    {
      zzm localzzm = zzavk;
      return localzzm;
    }
  }
  
  public static zza zziw()
  {
    return zzivzzavl;
  }
  
  public static zzl zzix()
  {
    return zzivzzavm;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.client.zzm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */