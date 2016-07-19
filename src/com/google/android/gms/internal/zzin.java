package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.ads.internal.formats.zza;
import com.google.android.gms.ads.internal.formats.zzc;
import com.google.android.gms.ads.internal.formats.zzd;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import org.json.JSONException;
import org.json.JSONObject;

@zzir
public class zzin
  implements zzim.zza<zzd>
{
  private final boolean zzcae;
  private final boolean zzcaf;
  
  public zzin(boolean paramBoolean1, boolean paramBoolean2)
  {
    zzcae = paramBoolean1;
    zzcaf = paramBoolean2;
  }
  
  public zzd zzb(zzim paramzzim, JSONObject paramJSONObject)
    throws JSONException, InterruptedException, ExecutionException
  {
    Object localObject = paramzzim.zza(paramJSONObject, "images", true, zzcae, zzcaf);
    zzlc localzzlc = paramzzim.zza(paramJSONObject, "app_icon", true, zzcae);
    paramzzim = paramzzim.zzg(paramJSONObject);
    ArrayList localArrayList = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList.add((zzc)((zzlc)((Iterator)localObject).next()).get());
    }
    return new zzd(paramJSONObject.getString("headline"), localArrayList, paramJSONObject.getString("body"), (zzdu)localzzlc.get(), paramJSONObject.getString("call_to_action"), paramJSONObject.optDouble("rating", -1.0D), paramJSONObject.optString("store"), paramJSONObject.optString("price"), (zza)paramzzim.get(), new Bundle());
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzin
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */