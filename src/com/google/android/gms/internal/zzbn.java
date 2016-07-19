package com.google.android.gms.internal;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class zzbn
  extends zzbp
{
  private static final Object zzafc = new Object();
  private static volatile Long zzahe = null;
  
  public zzbn(zzax paramzzax, String paramString1, String paramString2, zzae.zza paramzza, int paramInt1, int paramInt2)
  {
    super(paramzzax, paramString1, paramString2, paramzza, paramInt1, paramInt2);
  }
  
  protected void zzcv()
    throws IllegalAccessException, InvocationTargetException
  {
    if (zzahe == null) {
      synchronized (zzafc)
      {
        if (zzahe == null) {
          zzahe = (Long)zzahh.invoke(null, new Object[0]);
        }
      }
    }
    synchronized (zzaha)
    {
      zzaha.zzds = zzahe;
      return;
      localObject2 = finally;
      throw ((Throwable)localObject2);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzbn
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */