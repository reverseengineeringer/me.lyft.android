package com.google.android.gms.internal;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;

public class zzbb
  extends zzbp
{
  private static final Object zzafc = new Object();
  private static volatile String zzagz = null;
  
  public zzbb(zzax paramzzax, String paramString1, String paramString2, zzae.zza paramzza, int paramInt1, int paramInt2)
  {
    super(paramzzax, paramString1, paramString2, paramzza, paramInt1, paramInt2);
  }
  
  protected void zzcv()
    throws IllegalAccessException, InvocationTargetException
  {
    zzaha.zzdo = "E";
    if (zzagz == null) {
      synchronized (zzafc)
      {
        if (zzagz == null) {
          zzagz = zzaj.zza(((ByteBuffer)zzahh.invoke(null, new Object[] { zzaey.getContext() })).array(), true);
        }
      }
    }
    synchronized (zzaha)
    {
      zzaha.zzdo = zzagz;
      return;
      localObject2 = finally;
      throw ((Throwable)localObject2);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzbb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */