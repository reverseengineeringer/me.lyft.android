package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

final class zzkj$9
  extends zzkj.zza
{
  zzkj$9(Context paramContext, String paramString)
  {
    super(null);
  }
  
  public void zzew()
  {
    SharedPreferences.Editor localEditor = zzkj.zzn(zzaky).edit();
    localEditor.putString("content_url_hashes", zzckw);
    localEditor.apply();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzkj.9
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */