package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.common.internal.zzab;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class zzim$1
  extends zzil.zza
{
  zzim$1(zzim paramzzim, zzim.zzb paramzzb, zzkz paramzzkz, String paramString) {}
  
  public void zze(final zzfx paramzzfx)
  {
    Object localObject = new zzet()
    {
      public void zza(zzll paramAnonymouszzll, Map<String, String> paramAnonymousMap)
      {
        paramzzfx.zzb("/nativeAdPreProcess", zzbzl.zzcad);
        try
        {
          paramAnonymouszzll = (String)paramAnonymousMap.get("success");
          if (!TextUtils.isEmpty(paramAnonymouszzll))
          {
            zzbzm.zzi(new JSONObject(paramAnonymouszzll).getJSONArray("ads").getJSONObject(0));
            return;
          }
        }
        catch (JSONException paramAnonymouszzll)
        {
          zzkh.zzb("Malformed native JSON response.", paramAnonymouszzll);
          zzbzo.zzan(0);
          zzab.zza(zzbzo.zzqt(), "Unable to set the ad state error!");
          zzbzm.zzi(null);
        }
      }
    };
    zzbzl.zzcad = ((zzet)localObject);
    paramzzfx.zza("/nativeAdPreProcess", (zzet)localObject);
    try
    {
      localObject = new JSONObject(zzazzbzo).zzciu.body);
      ((JSONObject)localObject).put("ads_id", zzbzn);
      paramzzfx.zza("google.afma.nativeAds.preProcessJsonGmsg", (JSONObject)localObject);
      return;
    }
    catch (JSONException paramzzfx)
    {
      zzkh.zzd("Exception occurred while invoking javascript", paramzzfx);
      zzbzm.zzi(null);
    }
  }
  
  public void zzqr()
  {
    zzbzm.zzi(null);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzim.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */