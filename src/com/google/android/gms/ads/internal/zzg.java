package com.google.android.gms.ads.internal;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.util.zze;
import com.google.android.gms.internal.zzcy;
import com.google.android.gms.internal.zzdc;
import com.google.android.gms.internal.zzet;
import com.google.android.gms.internal.zzfw;
import com.google.android.gms.internal.zzfw.zzc;
import com.google.android.gms.internal.zzfx;
import com.google.android.gms.internal.zzir;
import com.google.android.gms.internal.zzka;
import com.google.android.gms.internal.zzkb;
import com.google.android.gms.internal.zzkh;
import com.google.android.gms.internal.zzkl;
import com.google.android.gms.internal.zzle.zzb;
import com.google.android.gms.internal.zzle.zzc;
import com.google.android.gms.internal.zzll;
import java.util.Map;
import org.json.JSONObject;

@zzir
public class zzg
{
  private Context mContext;
  private final Object zzail = new Object();
  public final zzet zzaks = new zzet()
  {
    public void zza(zzll paramAnonymouszzll, Map<String, String> paramAnonymousMap)
    {
      paramAnonymouszzll.zzb("/appSettingsFetched", this);
      paramAnonymouszzll = zzg.zza(zzg.this);
      if (paramAnonymousMap != null) {}
      try
      {
        if ("true".equalsIgnoreCase((String)paramAnonymousMap.get("isSuccessful")))
        {
          paramAnonymousMap = (String)paramAnonymousMap.get("appSettingsJson");
          zzu.zzft().zze(zzg.zzb(zzg.this), paramAnonymousMap);
        }
        return;
      }
      finally {}
    }
  };
  
  private static boolean zza(zzka paramzzka)
  {
    if (paramzzka == null) {
      return true;
    }
    long l = paramzzka.zzsf();
    int i;
    if (zzu.zzfu().currentTimeMillis() - l > ((Long)zzdc.zzbct.get()).longValue())
    {
      i = 1;
      if ((i == 0) && (paramzzka.zzsg())) {
        break label61;
      }
    }
    label61:
    for (boolean bool = true;; bool = false)
    {
      return bool;
      i = 0;
      break;
    }
  }
  
  public void zza(final Context paramContext, final VersionInfoParcel paramVersionInfoParcel, final boolean paramBoolean, zzka paramzzka, final String paramString1, final String paramString2)
  {
    if (!zza(paramzzka)) {
      return;
    }
    if (paramContext == null)
    {
      zzkh.zzcy("Context not provided to fetch application settings");
      return;
    }
    if ((TextUtils.isEmpty(paramString1)) && (TextUtils.isEmpty(paramString2)))
    {
      zzkh.zzcy("App settings could not be fetched. Required parameters missing");
      return;
    }
    mContext = paramContext;
    paramVersionInfoParcel = zzu.zzfq().zzc(paramContext, paramVersionInfoParcel);
    zzkl.zzclg.post(new Runnable()
    {
      public void run()
      {
        paramVersionInfoParcel.zzmc().zza(new zzle.zzc()new zzle.zzb
        {
          public void zzb(zzfx paramAnonymous2zzfx)
          {
            paramAnonymous2zzfx.zza("/appSettingsFetched", zzaks);
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
                paramAnonymous2zzfx.zza("AFMA_fetchAppSettings", localJSONObject);
                return;
                if (!TextUtils.isEmpty(zzakw)) {
                  localJSONObject.put("ad_unit_id", zzakw);
                }
              }
              return;
            }
            catch (Exception localException)
            {
              paramAnonymous2zzfx.zzb("/appSettingsFetched", zzaks);
              zzkh.zzb("Error requesting application settings", localException);
            }
          }
        }, new zzle.zzb());
      }
    });
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.zzg
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */