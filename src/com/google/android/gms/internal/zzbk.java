package com.google.android.gms.internal;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class zzbk
  extends zzbp
{
  private long zzahc = -1L;
  
  public zzbk(zzax paramzzax, String paramString1, String paramString2, zzae.zza paramzza, int paramInt1, int paramInt2)
  {
    super(paramzzax, paramString1, paramString2, paramzza, paramInt1, paramInt2);
  }
  
  protected void zzcv()
    throws IllegalAccessException, InvocationTargetException
  {
    zzaha.zzdd = Long.valueOf(-1L);
    if (zzahc == -1L) {
      zzahc = ((Integer)zzahh.invoke(null, new Object[] { zzaey.getContext() })).intValue();
    }
    synchronized (zzaha)
    {
      zzaha.zzdd = Long.valueOf(zzahc);
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzbk
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */