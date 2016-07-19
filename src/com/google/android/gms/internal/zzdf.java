package com.google.android.gms.internal;

import android.text.TextUtils;

@zzir
public class zzdf
{
  public zzde zza(zzdd paramzzdd)
  {
    if (paramzzdd == null) {
      throw new IllegalArgumentException("CSI configuration can't be null. ");
    }
    if (!paramzzdd.zzjz())
    {
      zzkh.v("CsiReporterFactory: CSI is not enabled. No CSI reporter created.");
      return null;
    }
    if (paramzzdd.getContext() == null) {
      throw new IllegalArgumentException("Context can't be null. Please set up context in CsiConfiguration.");
    }
    if (TextUtils.isEmpty(paramzzdd.zzhl())) {
      throw new IllegalArgumentException("AfmaVersion can't be null or empty. Please set up afmaVersion in CsiConfiguration.");
    }
    return new zzde(paramzzdd.getContext(), paramzzdd.zzhl(), paramzzdd.zzka(), paramzzdd.zzkb());
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzdf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */