package com.google.android.gms.internal;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class zzar
  extends zzaq
{
  private static final String TAG = zzar.class.getSimpleName();
  
  protected zzar(Context paramContext, String paramString, boolean paramBoolean)
  {
    super(paramContext, paramString, paramBoolean);
  }
  
  public static zzar zza(String paramString, Context paramContext, boolean paramBoolean)
  {
    zza(paramContext, paramBoolean);
    return new zzar(paramContext, paramString, paramBoolean);
  }
  
  protected List<Callable<Void>> zzb(zzax paramzzax, zzae.zza paramzza)
  {
    if ((paramzzax.zzce() == null) || (!zzafn)) {
      return super.zzb(paramzzax, paramzza);
    }
    int i = paramzzax.zzau();
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(super.zzb(paramzzax, paramzza));
    localArrayList.add(new zzbh(paramzzax, zzav.zzbm(), zzav.zzbn(), paramzza, i, 24));
    return localArrayList;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzar
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */