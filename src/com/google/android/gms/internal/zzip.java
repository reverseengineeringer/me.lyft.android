package com.google.android.gms.internal;

import android.support.v4.util.SimpleArrayMap;
import com.google.android.gms.ads.internal.formats.zza;
import com.google.android.gms.ads.internal.formats.zzc;
import com.google.android.gms.ads.internal.formats.zzf;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzir
public class zzip
  implements zzim.zza<zzf>
{
  private final boolean zzcae;
  
  public zzip(boolean paramBoolean)
  {
    zzcae = paramBoolean;
  }
  
  private void zza(zzim paramzzim, JSONObject paramJSONObject, SimpleArrayMap<String, Future<zzc>> paramSimpleArrayMap)
    throws JSONException
  {
    paramSimpleArrayMap.put(paramJSONObject.getString("name"), paramzzim.zza(paramJSONObject, "image_value", zzcae));
  }
  
  private void zza(JSONObject paramJSONObject, SimpleArrayMap<String, String> paramSimpleArrayMap)
    throws JSONException
  {
    paramSimpleArrayMap.put(paramJSONObject.getString("name"), paramJSONObject.getString("string_value"));
  }
  
  private <K, V> SimpleArrayMap<K, V> zzc(SimpleArrayMap<K, Future<V>> paramSimpleArrayMap)
    throws InterruptedException, ExecutionException
  {
    SimpleArrayMap localSimpleArrayMap = new SimpleArrayMap();
    int i = 0;
    while (i < paramSimpleArrayMap.size())
    {
      localSimpleArrayMap.put(paramSimpleArrayMap.keyAt(i), ((Future)paramSimpleArrayMap.valueAt(i)).get());
      i += 1;
    }
    return localSimpleArrayMap;
  }
  
  public zzf zzd(zzim paramzzim, JSONObject paramJSONObject)
    throws JSONException, InterruptedException, ExecutionException
  {
    SimpleArrayMap localSimpleArrayMap1 = new SimpleArrayMap();
    SimpleArrayMap localSimpleArrayMap2 = new SimpleArrayMap();
    zzlc localzzlc = paramzzim.zzg(paramJSONObject);
    JSONArray localJSONArray = paramJSONObject.getJSONArray("custom_assets");
    int i = 0;
    if (i < localJSONArray.length())
    {
      Object localObject = localJSONArray.getJSONObject(i);
      String str = ((JSONObject)localObject).getString("type");
      if ("string".equals(str)) {
        zza((JSONObject)localObject, localSimpleArrayMap2);
      }
      for (;;)
      {
        i += 1;
        break;
        if (!"image".equals(str)) {
          break label108;
        }
        zza(paramzzim, (JSONObject)localObject, localSimpleArrayMap1);
      }
      label108:
      localObject = String.valueOf(str);
      if (((String)localObject).length() != 0) {}
      for (localObject = "Unknown custom asset type: ".concat((String)localObject);; localObject = new String("Unknown custom asset type: "))
      {
        zzkh.zzcy((String)localObject);
        break;
      }
    }
    return new zzf(paramJSONObject.getString("custom_template_id"), zzc(localSimpleArrayMap1), localSimpleArrayMap2, (zza)localzzlc.get());
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzip
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */