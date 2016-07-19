package com.google.android.gms.internal;

import android.os.Handler;
import java.util.concurrent.Executor;

public class zze
  implements zzn
{
  private final Executor zzr;
  
  public zze(final Handler paramHandler)
  {
    zzr = new Executor()
    {
      public void execute(Runnable paramAnonymousRunnable)
      {
        paramHandler.post(paramAnonymousRunnable);
      }
    };
  }
  
  public void zza(zzk<?> paramzzk, zzm<?> paramzzm)
  {
    zza(paramzzk, paramzzm, null);
  }
  
  public void zza(zzk<?> paramzzk, zzm<?> paramzzm, Runnable paramRunnable)
  {
    paramzzk.zzu();
    paramzzk.zzc("post-response");
    zzr.execute(new zza(paramzzk, paramzzm, paramRunnable));
  }
  
  public void zza(zzk<?> paramzzk, zzr paramzzr)
  {
    paramzzk.zzc("post-error");
    paramzzr = zzm.zzd(paramzzr);
    zzr.execute(new zza(paramzzk, paramzzr, null));
  }
  
  private class zza
    implements Runnable
  {
    private final zzk zzu;
    private final zzm zzv;
    private final Runnable zzw;
    
    public zza(zzk paramzzk, zzm paramzzm, Runnable paramRunnable)
    {
      zzu = paramzzk;
      zzv = paramzzm;
      zzw = paramRunnable;
    }
    
    public void run()
    {
      if (zzu.isCanceled()) {
        zzu.zzd("canceled-at-delivery");
      }
      label97:
      label107:
      for (;;)
      {
        return;
        if (zzv.isSuccess())
        {
          zzu.zza(zzv.result);
          if (!zzv.zzbh) {
            break label97;
          }
          zzu.zzc("intermediate-response");
        }
        for (;;)
        {
          if (zzw == null) {
            break label107;
          }
          zzw.run();
          return;
          zzu.zzc(zzv.zzbg);
          break;
          zzu.zzd("done");
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zze
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */