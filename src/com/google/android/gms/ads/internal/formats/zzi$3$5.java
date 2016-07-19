package com.google.android.gms.ads.internal.formats;

import com.google.android.gms.internal.zzet;
import com.google.android.gms.internal.zzfx;
import com.google.android.gms.internal.zzkh;
import com.google.android.gms.internal.zzll;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

class zzi$3$5
  implements zzet
{
  zzi$3$5(zzi.3 param3, zzfx paramzzfx) {}
  
  public void zza(zzll paramzzll, Map<String, String> paramMap)
  {
    paramzzll = new JSONObject();
    try
    {
      Iterator localIterator = paramMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        paramzzll.put(str, paramMap.get(str));
      }
      paramzzll.put("id", zzi.zza(zzbgq.zzbgo));
    }
    catch (JSONException paramzzll)
    {
      zzkh.zzb("Unable to dispatch sendMessageToNativeJs event", paramzzll);
      return;
    }
    zzbgp.zzb("sendMessageToNativeJs", paramzzll);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.formats.zzi.3.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */