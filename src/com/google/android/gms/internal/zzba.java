package com.google.android.gms.internal;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class zzba
  extends zzbp
{
  private static final Object zzafc = new Object();
  private static volatile String zzagy = null;
  
  public zzba(zzax paramzzax, String paramString1, String paramString2, zzae.zza paramzza, int paramInt1, int paramInt2)
  {
    super(paramzzax, paramString1, paramString2, paramzza, paramInt1, paramInt2);
  }
  
  protected void zzcv()
    throws IllegalAccessException, InvocationTargetException
  {
    zzaha.zzdp = "E";
    if (zzagy == null) {
      synchronized (zzafc)
      {
        if (zzagy == null) {
          zzagy = (String)zzahh.invoke(null, new Object[] { zzaey.getContext() });
        }
      }
    }
    synchronized (zzaha)
    {
      zzaha.zzdp = zzaj.zza(zzagy.getBytes(), true);
      return;
      localObject2 = finally;
      throw ((Throwable)localObject2);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzba
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */