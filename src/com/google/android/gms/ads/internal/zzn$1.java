package com.google.android.gms.ads.internal;

import com.google.android.gms.ads.internal.formats.zzd;
import com.google.android.gms.internal.zzkh;
import com.google.android.gms.internal.zzll;
import com.google.android.gms.internal.zzlm.zza;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class zzn$1
  implements zzlm.zza
{
  zzn$1(zzd paramzzd, String paramString, zzll paramzzll) {}
  
  public void zza(zzll paramzzll, boolean paramBoolean)
  {
    try
    {
      paramzzll = new JSONObject();
      paramzzll.put("headline", zzami.getHeadline());
      paramzzll.put("body", zzami.getBody());
      paramzzll.put("call_to_action", zzami.getCallToAction());
      paramzzll.put("price", zzami.getPrice());
      paramzzll.put("star_rating", String.valueOf(zzami.getStarRating()));
      paramzzll.put("store", zzami.getStore());
      paramzzll.put("icon", zzn.zza(zzami.zzkw()));
      localObject1 = new JSONArray();
      Object localObject2 = zzami.getImages();
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
    paramzzll.put("extras", zzn.zzb(zzami.getExtras(), zzamj));
    Object localObject1 = new JSONObject();
    ((JSONObject)localObject1).put("assets", paramzzll);
    ((JSONObject)localObject1).put("template_id", "2");
    zzamk.zza("google.afma.nativeExpressAds.loadAssets", (JSONObject)localObject1);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.zzn.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */