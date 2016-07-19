package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

final class zzkj$10
  extends zzkj.zza
{
  zzkj$10(Context paramContext, zzkj.zzb paramzzb)
  {
    super(null);
  }
  
  public void zzew()
  {
    SharedPreferences localSharedPreferences = zzkj.zzn(zzaky);
    Bundle localBundle = new Bundle();
    localBundle.putString("content_url_hashes", localSharedPreferences.getString("content_url_hashes", ""));
    if (zzcks != null) {
      zzcks.zzg(localBundle);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzkj.10
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */