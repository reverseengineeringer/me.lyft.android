package com.google.android.gms.ads.internal.formats;

import android.text.TextUtils;
import com.google.android.gms.internal.zzet;
import com.google.android.gms.internal.zzfx;
import com.google.android.gms.internal.zzkh;
import com.google.android.gms.internal.zzll;
import com.google.android.gms.internal.zzlm;
import com.google.android.gms.internal.zzlm.zza;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

class zzi$3$1
  implements zzet
{
  zzi$3$1(zzi.3 param3, zzfx paramzzfx) {}
  
  public void zza(zzll paramzzll, final Map<String, String> paramMap)
  {
    zzi.zzb(zzbgq.zzbgo).zzuk().zza(new zzlm.zza()
    {
      public void zza(zzll paramAnonymouszzll, boolean paramAnonymousBoolean)
      {
        zzi.zza(zzbgq.zzbgo, (String)paramMap.get("id"));
        paramAnonymouszzll = new JSONObject();
        try
        {
          paramAnonymouszzll.put("messageType", "htmlLoaded");
          paramAnonymouszzll.put("id", zzi.zza(zzbgq.zzbgo));
          zzbgp.zzb("sendMessageToNativeJs", paramAnonymouszzll);
          return;
        }
        catch (JSONException paramAnonymouszzll)
        {
          zzkh.zzb("Unable to dispatch sendMessageToNativeJs event", paramAnonymouszzll);
        }
      }
    });
    paramzzll = (String)paramMap.get("overlayHtml");
    paramMap = (String)paramMap.get("baseUrl");
    if (TextUtils.isEmpty(paramMap))
    {
      zzi.zzb(zzbgq.zzbgo).loadData(paramzzll, "text/html", "UTF-8");
      return;
    }
    zzi.zzb(zzbgq.zzbgo).loadDataWithBaseURL(paramMap, paramzzll, "text/html", "UTF-8", null);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.formats.zzi.3.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */