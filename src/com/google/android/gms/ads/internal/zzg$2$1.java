package com.google.android.gms.ads.internal;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.internal.zzfx;
import com.google.android.gms.internal.zzkh;
import com.google.android.gms.internal.zzle.zzc;
import org.json.JSONObject;

class zzg$2$1
  implements zzle.zzc<zzfx>
{
  zzg$2$1(zzg.2 param2) {}
  
  public void zzb(zzfx paramzzfx)
  {
    paramzzfx.zza("/appSettingsFetched", zzakz.zzakt.zzaks);
    try
    {
      JSONObject localJSONObject = new JSONObject();
      if (!TextUtils.isEmpty(zzakz.zzakv)) {
        localJSONObject.put("app_id", zzakz.zzakv);
      }
      for (;;)
      {
        localJSONObject.put("is_init", zzakz.zzakx);
        localJSONObject.put("pn", zzakz.zzaky.getPackageName());
        paramzzfx.zza("AFMA_fetchAppSettings", localJSONObject);
        return;
        if (!TextUtils.isEmpty(zzakz.zzakw)) {
          localJSONObject.put("ad_unit_id", zzakz.zzakw);
        }
      }
      return;
    }
    catch (Exception localException)
    {
      paramzzfx.zzb("/appSettingsFetched", zzakz.zzakt.zzaks);
      zzkh.zzb("Error requesting application settings", localException);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.zzg.2.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */