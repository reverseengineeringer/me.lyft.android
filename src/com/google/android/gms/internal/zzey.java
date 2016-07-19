package com.google.android.gms.internal;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;
import org.json.JSONException;
import org.json.JSONObject;

@zzir
public class zzey
  implements zzet
{
  final HashMap<String, zzkz<JSONObject>> zzbiw = new HashMap();
  
  public void zza(zzll paramzzll, Map<String, String> paramMap)
  {
    zzi((String)paramMap.get("request_id"), (String)paramMap.get("fetched_ad"));
  }
  
  public Future<JSONObject> zzax(String paramString)
  {
    zzkz localzzkz = new zzkz();
    zzbiw.put(paramString, localzzkz);
    return localzzkz;
  }
  
  public void zzay(String paramString)
  {
    zzkz localzzkz = (zzkz)zzbiw.get(paramString);
    if (localzzkz == null)
    {
      zzkh.e("Could not find the ad request for the corresponding ad response.");
      return;
    }
    if (!localzzkz.isDone()) {
      localzzkz.cancel(true);
    }
    zzbiw.remove(paramString);
  }
  
  public void zzi(String paramString1, String paramString2)
  {
    zzkh.zzcw("Received ad from the cache.");
    zzkz localzzkz = (zzkz)zzbiw.get(paramString1);
    if (localzzkz == null)
    {
      zzkh.e("Could not find the ad request for the corresponding ad response.");
      return;
    }
    try
    {
      localzzkz.zzi(new JSONObject(paramString2));
      return;
    }
    catch (JSONException paramString2)
    {
      zzkh.zzb("Failed constructing JSON object from value passed from javascript", paramString2);
      localzzkz.zzi(null);
      return;
    }
    finally
    {
      zzbiw.remove(paramString1);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzey
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */