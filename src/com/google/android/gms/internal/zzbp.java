package com.google.android.gms.internal;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.Callable;

public abstract class zzbp
  implements Callable
{
  protected final String TAG = getClass().getSimpleName();
  protected final String className;
  protected final zzax zzaey;
  protected final zzae.zza zzaha;
  protected final String zzahf;
  protected Method zzahh;
  protected final int zzahl;
  protected final int zzahm;
  
  public zzbp(zzax paramzzax, String paramString1, String paramString2, zzae.zza paramzza, int paramInt1, int paramInt2)
  {
    zzaey = paramzzax;
    className = paramString1;
    zzahf = paramString2;
    zzaha = paramzza;
    zzahl = paramInt1;
    zzahm = paramInt2;
  }
  
  protected abstract void zzcv()
    throws IllegalAccessException, InvocationTargetException;
  
  public Void zzcy()
    throws Exception
  {
    try
    {
      long l = System.nanoTime();
      zzahh = zzaey.zzc(className, zzahf);
      if (zzahh == null) {
        return null;
      }
      zzcv();
      zzam localzzam = zzaey.zzcl();
      if ((localzzam != null) && (zzahl != Integer.MIN_VALUE))
      {
        localzzam.zza(zzahm, zzahl, (System.nanoTime() - l) / 1000L);
        return null;
      }
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      return null;
    }
    catch (InvocationTargetException localInvocationTargetException) {}
    return null;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzbp
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */