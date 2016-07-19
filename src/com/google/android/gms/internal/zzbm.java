package com.google.android.gms.internal;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class zzbm
  extends zzbp
{
  private List<Long> zzahd = null;
  
  public zzbm(zzax paramzzax, String paramString1, String paramString2, zzae.zza paramzza, int paramInt1, int paramInt2)
  {
    super(paramzzax, paramString1, paramString2, paramzza, paramInt1, paramInt2);
  }
  
  protected void zzcv()
    throws IllegalAccessException, InvocationTargetException
  {
    zzaha.zzdq = Long.valueOf(-1L);
    zzaha.zzdr = Long.valueOf(-1L);
    if (zzahd == null) {
      zzahd = ((List)zzahh.invoke(null, new Object[] { zzaey.getContext() }));
    }
    if ((zzahd != null) && (zzahd.size() == 2)) {
      synchronized (zzaha)
      {
        zzaha.zzdq = Long.valueOf(((Long)zzahd.get(0)).longValue());
        zzaha.zzdr = Long.valueOf(((Long)zzahd.get(1)).longValue());
        return;
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzbm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */