package com.google.android.gms.internal;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class zzbe
  extends zzbp
{
  public zzbe(zzax paramzzax, String paramString1, String paramString2, zzae.zza paramzza, int paramInt1, int paramInt2)
  {
    super(paramzzax, paramString1, paramString2, paramzza, paramInt1, paramInt2);
  }
  
  protected void zzcv()
    throws IllegalAccessException, InvocationTargetException
  {
    zzaha.zzcw = Long.valueOf(-1L);
    zzaha.zzcx = Long.valueOf(-1L);
    int[] arrayOfInt = (int[])zzahh.invoke(null, new Object[] { zzaey.getContext() });
    synchronized (zzaha)
    {
      zzaha.zzcw = Long.valueOf(arrayOfInt[0]);
      zzaha.zzcx = Long.valueOf(arrayOfInt[1]);
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzbe
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */