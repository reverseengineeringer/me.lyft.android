package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

final class zzkj$6
  extends zzkj.zza
{
  zzkj$6(Context paramContext, zzkj.zzb paramzzb)
  {
    super(null);
  }
  
  public void zzew()
  {
    SharedPreferences localSharedPreferences = zzkj.zzn(zzaky);
    Bundle localBundle = new Bundle();
    localBundle.putInt("webview_cache_version", localSharedPreferences.getInt("webview_cache_version", 0));
    if (zzcks != null) {
      zzcks.zzg(localBundle);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzkj.6
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */