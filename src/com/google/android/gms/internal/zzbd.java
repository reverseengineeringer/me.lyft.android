package com.google.android.gms.internal;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class zzbd
  extends zzbp
{
  private static final Object zzafc = new Object();
  private static volatile String zzcq = null;
  
  public zzbd(zzax paramzzax, String paramString1, String paramString2, zzae.zza paramzza, int paramInt1, int paramInt2)
  {
    super(paramzzax, paramString1, paramString2, paramzza, paramInt1, paramInt2);
  }
  
  protected void zzcv()
    throws IllegalAccessException, InvocationTargetException
  {
    zzaha.zzdt = "E";
    if (zzcq == null) {
      synchronized (zzafc)
      {
        if (zzcq == null) {
          zzcq = (String)zzahh.invoke(null, new Object[] { zzaey.getContext() });
        }
      }
    }
    synchronized (zzaha)
    {
      zzaha.zzdt = zzcq;
      return;
      localObject2 = finally;
      throw ((Throwable)localObject2);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzbd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */