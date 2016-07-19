package com.google.android.gms.ads.internal;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.internal.zzfw;
import com.google.android.gms.internal.zzfw.zzc;
import com.google.android.gms.internal.zzfx;
import com.google.android.gms.internal.zzkh;
import com.google.android.gms.internal.zzle.zzb;
import com.google.android.gms.internal.zzle.zzc;
import org.json.JSONObject;

class zzg$2
  implements Runnable
{
  zzg$2(zzg paramzzg, zzfw paramzzfw, String paramString1, String paramString2, boolean paramBoolean, Context paramContext) {}
  
  public void run()
  {
    zzaku.zzmc().zza(new zzle.zzc()new zzle.zzb
    {
      public void zzb(zzfx paramAnonymouszzfx)
      {
        paramAnonymouszzfx.zza("/appSettingsFetched", zzakt.zzaks);
        try
        {
          JSONObject localJSONObject = new JSONObject();
          if (!TextUtils.isEmpty(zzakv)) {
            localJSONObject.put("app_id", zzakv);
          }
          for (;;)
          {
            localJSONObject.put("is_init", zzakx);
            localJSONObject.put("pn", zzaky.getPackageName());
            paramAnonymouszzfx.zza("AFMA_fetchAppSettings", localJSONObject);
            return;
            if (!TextUtils.isEmpty(zzakw)) {
              localJSONObject.put("ad_unit_id", zzakw);
            }
          }
          return;
        }
        catch (Exception localException)
        {
          paramAnonymouszzfx.zzb("/appSettingsFetched", zzakt.zzaks);
          zzkh.zzb("Error requesting application settings", localException);
        }
      }
    }, new zzle.zzb());
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.zzg.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */