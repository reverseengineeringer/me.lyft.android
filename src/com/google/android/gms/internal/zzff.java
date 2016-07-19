package com.google.android.gms.internal;

import android.os.Handler;
import com.google.android.gms.ads.internal.zzu;

@zzir
public class zzff
  extends zzkg
{
  final zzll zzbgj;
  final zzfh zzbjf;
  private final String zzbjg;
  
  zzff(zzll paramzzll, zzfh paramzzfh, String paramString)
  {
    zzbgj = paramzzll;
    zzbjf = paramzzfh;
    zzbjg = paramString;
    zzu.zzgj().zza(this);
  }
  
  public void onStop()
  {
    zzbjf.abort();
  }
  
  public void zzew()
  {
    try
    {
      zzbjf.zzba(zzbjg);
      return;
    }
    finally
    {
      zzkl.zzclg.post(new Runnable()
      {
        public void run()
        {
          zzu.zzgj().zzb(zzff.this);
        }
      });
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzff
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */