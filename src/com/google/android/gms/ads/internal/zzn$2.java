package com.google.android.gms.ads.internal;

import com.google.android.gms.ads.internal.formats.zze;
import com.google.android.gms.internal.zzkh;
import com.google.android.gms.internal.zzll;
import com.google.android.gms.internal.zzlm.zza;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class zzn$2
  implements zzlm.zza
{
  zzn$2(zze paramzze, String paramString, zzll paramzzll) {}
  
  public void zza(zzll paramzzll, boolean paramBoolean)
  {
    try
    {
      paramzzll = new JSONObject();
      paramzzll.put("headline", zzaml.getHeadline());
      paramzzll.put("body", zzaml.getBody());
      paramzzll.put("call_to_action", zzaml.getCallToAction());
      paramzzll.put("advertiser", zzaml.getAdvertiser());
      paramzzll.put("logo", zzn.zza(zzaml.zzla()));
      localObject1 = new JSONArray();
      Object localObject2 = zzaml.getImages();
      if (localObject2 != null)
      {
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((JSONArray)localObject1).put(zzn.zza(zzn.zzf(((Iterator)localObject2).next())));
        }
      }
      paramzzll.put("images", localObject1);
    }
    catch (JSONException paramzzll)
    {
      zzkh.zzd("Exception occurred when loading assets", paramzzll);
      return;
    }
    paramzzll.put("extras", zzn.zzb(zzaml.getExtras(), zzamj));
    Object localObject1 = new JSONObject();
    ((JSONObject)localObject1).put("assets", paramzzll);
    ((JSONObject)localObject1).put("template_id", "1");
    zzamk.zza("google.afma.nativeExpressAds.loadAssets", (JSONObject)localObject1);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.zzn.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */