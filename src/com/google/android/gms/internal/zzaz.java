package com.google.android.gms.internal;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class zzaz
  extends zzbp
{
  public zzaz(zzax paramzzax, String paramString1, String paramString2, zzae.zza paramzza, int paramInt1, int paramInt2)
  {
    super(paramzzax, paramString1, paramString2, paramzza, paramInt1, paramInt2);
  }
  
  protected void zzcv()
    throws IllegalAccessException, InvocationTargetException
  {
    synchronized (zzaha)
    {
      zzaha.zzcu = Long.valueOf(-1L);
      zzaha.zzcu = ((Long)zzahh.invoke(null, new Object[] { zzaey.getContext() }));
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzaz
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */