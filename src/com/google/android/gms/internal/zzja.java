package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.common.util.zze;
import java.util.WeakHashMap;

@zzir
public final class zzja
{
  private WeakHashMap<Context, zza> zzche = new WeakHashMap();
  
  public zziz zzy(Context paramContext)
  {
    Object localObject = (zza)zzche.get(paramContext);
    if ((localObject != null) && (!((zza)localObject).hasExpired()) && (((Boolean)zzdc.zzbaq.get()).booleanValue())) {}
    for (localObject = new zziz.zza(paramContext, zzchg).zzro();; localObject = new zziz.zza(paramContext).zzro())
    {
      zzche.put(paramContext, new zza((zziz)localObject));
      return (zziz)localObject;
    }
  }
  
  private class zza
  {
    public final long zzchf = zzu.zzfu().currentTimeMillis();
    public final zziz zzchg;
    
    public zza(zziz paramzziz)
    {
      zzchg = paramzziz;
    }
    
    public boolean hasExpired()
    {
      long l = zzchf;
      return ((Long)zzdc.zzbar.get()).longValue() + l < zzu.zzfu().currentTimeMillis();
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzja
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */