package com.google.android.gms.internal;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class zzbg
  extends zzbp
{
  private long startTime;
  
  public zzbg(zzax paramzzax, String paramString1, String paramString2, zzae.zza paramzza, long paramLong, int paramInt1, int paramInt2)
  {
    super(paramzzax, paramString1, paramString2, paramzza, paramInt1, paramInt2);
    startTime = paramLong;
  }
  
  protected void zzcv()
    throws IllegalAccessException, InvocationTargetException
  {
    long l = ((Long)zzahh.invoke(null, new Object[0])).longValue();
    synchronized (zzaha)
    {
      zzaha.zzek = Long.valueOf(l);
      if (startTime != 0L)
      {
        zzaha.zzdi = Long.valueOf(l - startTime);
        zzaha.zzdn = Long.valueOf(startTime);
      }
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzbg
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */