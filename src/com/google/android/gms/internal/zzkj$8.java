package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

final class zzkj$8
  extends zzkj.zza
{
  zzkj$8(Context paramContext, zzkj.zzb paramzzb)
  {
    super(null);
  }
  
  public void zzew()
  {
    SharedPreferences localSharedPreferences = zzkj.zzn(zzaky);
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("content_url_opted_out", localSharedPreferences.getBoolean("content_url_opted_out", true));
    if (zzcks != null) {
      zzcks.zzg(localBundle);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzkj.8
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */