package com.google.android.gms.internal;

public class zzfw$zzc
  extends zzlf<zzfx>
{
  private final Object zzail = new Object();
  private final zzfw.zzd zzbmm;
  private boolean zzbmn;
  
  public zzfw$zzc(zzfw.zzd paramzzd)
  {
    zzbmm = paramzzd;
  }
  
  public void release()
  {
    synchronized (zzail)
    {
      if (zzbmn) {
        return;
      }
      zzbmn = true;
      zza(new zzle.zzc()new zzle.zzb
      {
        public void zzb(zzfx paramAnonymouszzfx)
        {
          zzkh.v("Ending javascript session.");
          ((zzfy)paramAnonymouszzfx).zzmh();
        }
      }, new zzle.zzb());
      zza(new zzle.zzc()new zzle.zza
      {
        public void zzb(zzfx paramAnonymouszzfx)
        {
          zzkh.v("Releasing engine reference.");
          zzfw.zzc.zza(zzfw.zzc.this).zzme();
        }
      }, new zzle.zza()
      {
        public void run()
        {
          zzfw.zzc.zza(zzfw.zzc.this).zzme();
        }
      });
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzfw.zzc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */