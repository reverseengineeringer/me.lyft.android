package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.common.zze;
import java.util.concurrent.Callable;

@zzir
public class zzdb
{
  private final Object zzail = new Object();
  private boolean zzamr = false;
  private SharedPreferences zzaxs = null;
  
  public void initialize(Context paramContext)
  {
    synchronized (zzail)
    {
      if (zzamr) {
        return;
      }
      paramContext = zze.getRemoteContext(paramContext);
      if (paramContext == null) {
        return;
      }
    }
    zzaxs = zzu.zzfx().zzn(paramContext);
    zzamr = true;
  }
  
  public <T> T zzd(final zzcy<T> paramzzcy)
  {
    synchronized (zzail)
    {
      if (!zzamr)
      {
        paramzzcy = paramzzcy.zzjw();
        return paramzzcy;
      }
      (T)zzkx.zzb(new Callable()
      {
        public T call()
        {
          return (T)paramzzcy.zza(zzdb.zza(zzdb.this));
        }
      });
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzdb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */