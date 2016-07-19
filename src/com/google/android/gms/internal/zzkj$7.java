package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

final class zzkj$7
  extends zzkj.zza
{
  zzkj$7(Context paramContext, boolean paramBoolean)
  {
    super(null);
  }
  
  public void zzew()
  {
    SharedPreferences.Editor localEditor = zzkj.zzn(zzaky).edit();
    localEditor.putBoolean("content_url_opted_out", zzckv);
    localEditor.apply();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzkj.7
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */