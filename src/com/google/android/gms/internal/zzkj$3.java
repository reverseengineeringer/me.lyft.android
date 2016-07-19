package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

final class zzkj$3
  extends zzkj.zza
{
  zzkj$3(Context paramContext, String paramString, long paramLong)
  {
    super(null);
  }
  
  public void zzew()
  {
    SharedPreferences.Editor localEditor = zzkj.zzn(zzaky).edit();
    localEditor.putString("app_settings_json", zzckt);
    localEditor.putLong("app_settings_last_update_ms", zzcku);
    localEditor.apply();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzkj.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */