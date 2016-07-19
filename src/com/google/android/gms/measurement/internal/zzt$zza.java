package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.google.android.gms.common.internal.zzab;

public final class zzt$zza
{
  private final boolean alK;
  private boolean alL;
  private boolean rD;
  private final String zzaxn;
  
  public zzt$zza(zzt paramzzt, String paramString, boolean paramBoolean)
  {
    zzab.zzhs(paramString);
    zzaxn = paramString;
    alK = paramBoolean;
  }
  
  private void zzbui()
  {
    if (alL) {
      return;
    }
    alL = true;
    rD = zzt.zza(alM).getBoolean(zzaxn, alK);
  }
  
  public boolean get()
  {
    zzbui();
    return rD;
  }
  
  public void set(boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = zzt.zza(alM).edit();
    localEditor.putBoolean(zzaxn, paramBoolean);
    localEditor.apply();
    rD = paramBoolean;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.measurement.internal.zzt.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */