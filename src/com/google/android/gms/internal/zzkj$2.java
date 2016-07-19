package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

final class zzkj$2
  extends zzkj.zza
{
  zzkj$2(Context paramContext, zzkj.zzb paramzzb)
  {
    super(null);
  }
  
  public void zzew()
  {
    SharedPreferences localSharedPreferences = zzkj.zzn(zzaky);
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("auto_collect_location", localSharedPreferences.getBoolean("auto_collect_location", false));
    if (zzcks != null) {
      zzcks.zzg(localBundle);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzkj.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */