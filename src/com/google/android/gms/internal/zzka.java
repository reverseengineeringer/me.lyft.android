package com.google.android.gms.internal;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzu;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzir
public class zzka
{
  private final long zzcjg;
  private final List<String> zzcjh = new ArrayList();
  private final Map<String, zzb> zzcji = new HashMap();
  private String zzcjj;
  private String zzcjk;
  private boolean zzcjl = false;
  
  public zzka(String paramString, long paramLong)
  {
    zzcjk = paramString;
    zzcjg = paramLong;
    zzcm(paramString);
  }
  
  private void zzcm(String paramString)
  {
    int i = 0;
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return;
      try
      {
        paramString = new JSONObject(paramString);
        if (paramString.optInt("status", -1) != 1)
        {
          zzcjl = false;
          zzkh.zzcy("App settings could not be fetched successfully.");
          return;
        }
      }
      catch (JSONException paramString)
      {
        zzkh.zzd("Exception occurred while processing app setting json", paramString);
        zzu.zzft().zzb(paramString, true);
        return;
      }
      zzcjl = true;
      zzcjj = paramString.optString("app_id");
      paramString = paramString.optJSONArray("ad_unit_id_settings");
      if (paramString != null) {
        while (i < paramString.length())
        {
          zzi(paramString.getJSONObject(i));
          i += 1;
        }
      }
    }
  }
  
  private void zzi(JSONObject paramJSONObject)
    throws JSONException
  {
    Object localObject1 = paramJSONObject.optString("format");
    String str1 = paramJSONObject.optString("ad_unit_id");
    if ((TextUtils.isEmpty((CharSequence)localObject1)) || (TextUtils.isEmpty(str1))) {}
    int i;
    label92:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              if ("interstitial".equalsIgnoreCase((String)localObject1))
              {
                zzcjh.add(str1);
                return;
              }
            } while (!"rewarded".equalsIgnoreCase((String)localObject1));
            paramJSONObject = paramJSONObject.optJSONObject("mediation_config");
          } while (paramJSONObject == null);
          localObject1 = paramJSONObject.optJSONArray("ad_networks");
        } while (localObject1 == null);
        i = 0;
        if (i >= ((JSONArray)localObject1).length()) {
          break;
        }
        localObject2 = ((JSONArray)localObject1).getJSONObject(i);
        localObject3 = ((JSONObject)localObject2).optJSONArray("adapters");
      } while (localObject3 == null);
      paramJSONObject = new ArrayList();
      int j = 0;
      while (j < ((JSONArray)localObject3).length())
      {
        paramJSONObject.add(((JSONArray)localObject3).getString(j));
        j += 1;
      }
      localObject2 = ((JSONObject)localObject2).optJSONObject("data");
    } while (localObject2 == null);
    Object localObject3 = new Bundle();
    Iterator localIterator = ((JSONObject)localObject2).keys();
    while (localIterator.hasNext())
    {
      String str2 = (String)localIterator.next();
      ((Bundle)localObject3).putString(str2, ((JSONObject)localObject2).getString(str2));
    }
    Object localObject2 = new zza(paramJSONObject, (Bundle)localObject3);
    if (zzcji.containsKey(str1)) {}
    for (paramJSONObject = (zzb)zzcji.get(str1);; paramJSONObject = new zzb())
    {
      paramJSONObject.zza((zza)localObject2);
      zzcji.put(str1, paramJSONObject);
      i += 1;
      break label92;
      break;
    }
  }
  
  public long zzsf()
  {
    return zzcjg;
  }
  
  public boolean zzsg()
  {
    return zzcjl;
  }
  
  public String zzsh()
  {
    return zzcjk;
  }
  
  public String zzsi()
  {
    return zzcjj;
  }
  
  class zza
  {
    private final List<String> zzcjm;
    private final Bundle zzcjn;
    
    public zza(Bundle paramBundle)
    {
      zzcjm = paramBundle;
      Bundle localBundle;
      zzcjn = localBundle;
    }
  }
  
  class zzb
  {
    final List<zzka.zza> zzcjp = new ArrayList();
    
    zzb() {}
    
    public void zza(zzka.zza paramzza)
    {
      zzcjp.add(paramzza);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzka
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */