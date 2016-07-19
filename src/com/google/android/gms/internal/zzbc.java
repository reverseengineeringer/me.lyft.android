package com.google.android.gms.internal;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class zzbc
  extends zzbp
{
  private static final Object zzafc = new Object();
  private static volatile Long zzcr = null;
  
  public zzbc(zzax paramzzax, String paramString1, String paramString2, zzae.zza paramzza, int paramInt1, int paramInt2)
  {
    super(paramzzax, paramString1, paramString2, paramzza, paramInt1, paramInt2);
  }
  
  protected void zzcv()
    throws IllegalAccessException, InvocationTargetException
  {
    zzaha.zzdu = Long.valueOf(-1L);
    if (zzcr == null) {
      synchronized (zzafc)
      {
        if (zzcr == null) {
          zzcr = (Long)zzahh.invoke(null, new Object[] { zzaey.getContext() });
        }
      }
    }
    synchronized (zzaha)
    {
      zzaha.zzdu = zzcr;
      return;
      localObject2 = finally;
      throw ((Throwable)localObject2);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzbc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */