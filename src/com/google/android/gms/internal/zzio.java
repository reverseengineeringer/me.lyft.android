package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.ads.internal.formats.zza;
import com.google.android.gms.ads.internal.formats.zzc;
import com.google.android.gms.ads.internal.formats.zze;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import org.json.JSONException;
import org.json.JSONObject;

@zzir
public class zzio
  implements zzim.zza<zze>
{
  private final boolean zzcae;
  private final boolean zzcaf;
  
  public zzio(boolean paramBoolean1, boolean paramBoolean2)
  {
    zzcae = paramBoolean1;
    zzcaf = paramBoolean2;
  }
  
  public zze zzc(zzim paramzzim, JSONObject paramJSONObject)
    throws JSONException, InterruptedException, ExecutionException
  {
    Object localObject = paramzzim.zza(paramJSONObject, "images", true, zzcae, zzcaf);
    zzlc localzzlc = paramzzim.zza(paramJSONObject, "secondary_image", false, zzcae);
    paramzzim = paramzzim.zzg(paramJSONObject);
    ArrayList localArrayList = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList.add((zzc)((zzlc)((Iterator)localObject).next()).get());
    }
    return new zze(paramJSONObject.getString("headline"), localArrayList, paramJSONObject.getString("body"), (zzdu)localzzlc.get(), paramJSONObject.getString("call_to_action"), paramJSONObject.getString("advertiser"), (zza)paramzzim.get(), new Bundle());
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzio
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */