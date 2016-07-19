package com.google.android.gms.ads.internal.formats;

import com.google.android.gms.internal.zzfx;
import com.google.android.gms.internal.zzkh;
import com.google.android.gms.internal.zzll;
import com.google.android.gms.internal.zzlm.zza;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

class zzi$3$1$1
  implements zzlm.zza
{
  zzi$3$1$1(zzi.3.1 param1, Map paramMap) {}
  
  public void zza(zzll paramzzll, boolean paramBoolean)
  {
    zzi.zza(zzbgs.zzbgq.zzbgo, (String)zzbgr.get("id"));
    paramzzll = new JSONObject();
    try
    {
      paramzzll.put("messageType", "htmlLoaded");
      paramzzll.put("id", zzi.zza(zzbgs.zzbgq.zzbgo));
      zzbgs.zzbgp.zzb("sendMessageToNativeJs", paramzzll);
      return;
    }
    catch (JSONException paramzzll)
    {
      zzkh.zzb("Unable to dispatch sendMessageToNativeJs event", paramzzll);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.formats.zzi.3.1.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */