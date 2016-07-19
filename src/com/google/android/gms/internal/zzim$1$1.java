package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.common.internal.zzab;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class zzim$1$1
  implements zzet
{
  zzim$1$1(zzim.1 param1, zzfx paramzzfx) {}
  
  public void zza(zzll paramzzll, Map<String, String> paramMap)
  {
    zzbgp.zzb("/nativeAdPreProcess", zzbzp.zzbzl.zzcad);
    try
    {
      paramzzll = (String)paramMap.get("success");
      if (!TextUtils.isEmpty(paramzzll))
      {
        zzbzp.zzbzm.zzi(new JSONObject(paramzzll).getJSONArray("ads").getJSONObject(0));
        return;
      }
    }
    catch (JSONException paramzzll)
    {
      zzkh.zzb("Malformed native JSON response.", paramzzll);
      zzbzp.zzbzo.zzan(0);
      zzab.zza(zzbzp.zzbzo.zzqt(), "Unable to set the ad state error!");
      zzbzp.zzbzm.zzi(null);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzim.1.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */