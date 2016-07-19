package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

final class zzkj$1
  extends zzkj.zza
{
  zzkj$1(Context paramContext, boolean paramBoolean)
  {
    super(null);
  }
  
  public void zzew()
  {
    SharedPreferences.Editor localEditor = zzkj.zzn(zzaky).edit();
    localEditor.putBoolean("use_https", zzckr);
    localEditor.apply();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzkj.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */