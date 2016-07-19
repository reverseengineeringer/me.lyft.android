package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

final class zzkj$11
  extends zzkj.zza
{
  zzkj$11(Context paramContext, boolean paramBoolean)
  {
    super(null);
  }
  
  public void zzew()
  {
    SharedPreferences.Editor localEditor = zzkj.zzn(zzaky).edit();
    localEditor.putBoolean("auto_collect_location", zzckx);
    localEditor.apply();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzkj.11
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */