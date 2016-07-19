package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

@zzir
public abstract class zzjb
{
  public abstract void zza(Context paramContext, zziv paramzziv, VersionInfoParcel paramVersionInfoParcel);
  
  protected void zze(zziv paramzziv)
  {
    paramzziv.zzrj();
    if (paramzziv.zzrh() != null) {
      paramzziv.zzrh().release();
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzjb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */