package com.google.android.gms.internal;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class zzbj
  extends zzbp
{
  private static final Object zzafc = new Object();
  private static volatile Long zzahb = null;
  
  public zzbj(zzax paramzzax, String paramString1, String paramString2, zzae.zza paramzza, int paramInt1, int paramInt2)
  {
    super(paramzzax, paramString1, paramString2, paramzza, paramInt1, paramInt2);
  }
  
  protected void zzcv()
    throws IllegalAccessException, InvocationTargetException
  {
    if (zzahb == null) {
      synchronized (zzafc)
      {
        if (zzahb == null) {
          zzahb = (Long)zzahh.invoke(null, new Object[0]);
        }
      }
    }
    synchronized (zzaha)
    {
      zzaha.zzdm = zzahb;
      return;
      localObject2 = finally;
      throw ((Throwable)localObject2);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzbj
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */