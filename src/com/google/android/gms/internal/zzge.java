package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel;
import com.google.android.gms.ads.internal.zzu;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzir
public final class zzge
{
  public final List<zzgd> zzbno;
  public final long zzbnp;
  public final List<String> zzbnq;
  public final List<String> zzbnr;
  public final List<String> zzbns;
  public final List<String> zzbnt;
  public final boolean zzbnu;
  public final String zzbnv;
  public final long zzbnw;
  public final String zzbnx;
  public final int zzbny;
  public final int zzbnz;
  public final long zzboa;
  public final boolean zzbob;
  public int zzboc;
  public int zzbod;
  
  public zzge(String paramString)
    throws JSONException
  {
    Object localObject = new JSONObject(paramString);
    if (zzkh.zzaz(2))
    {
      paramString = String.valueOf(((JSONObject)localObject).toString(2));
      if (paramString.length() == 0) {
        break label138;
      }
    }
    ArrayList localArrayList;
    int j;
    label138:
    for (paramString = "Mediation Response JSON: ".concat(paramString);; paramString = new String("Mediation Response JSON: "))
    {
      zzkh.v(paramString);
      paramString = ((JSONObject)localObject).getJSONArray("ad_networks");
      localArrayList = new ArrayList(paramString.length());
      int i = 0;
      int k;
      for (j = -1; i < paramString.length(); j = k)
      {
        zzgd localzzgd = new zzgd(paramString.getJSONObject(i));
        localArrayList.add(localzzgd);
        k = j;
        if (j < 0)
        {
          k = j;
          if (zza(localzzgd)) {
            k = i;
          }
        }
        i += 1;
      }
    }
    zzboc = j;
    zzbod = paramString.length();
    zzbno = Collections.unmodifiableList(localArrayList);
    zzbnv = ((JSONObject)localObject).getString("qdata");
    zzbnz = ((JSONObject)localObject).optInt("fs_model_type", -1);
    zzboa = ((JSONObject)localObject).optLong("timeout_ms", -1L);
    paramString = ((JSONObject)localObject).optJSONObject("settings");
    if (paramString != null)
    {
      zzbnp = paramString.optLong("ad_network_timeout_millis", -1L);
      zzbnq = zzu.zzgf().zza(paramString, "click_urls");
      zzbnr = zzu.zzgf().zza(paramString, "imp_urls");
      zzbns = zzu.zzgf().zza(paramString, "nofill_urls");
      zzbnt = zzu.zzgf().zza(paramString, "remote_ping_urls");
      zzbnu = paramString.optBoolean("render_in_browser", false);
      long l = paramString.optLong("refresh", -1L);
      if (l > 0L)
      {
        l *= 1000L;
        zzbnw = l;
        localObject = RewardItemParcel.zza(paramString.optJSONArray("rewards"));
        if (localObject != null) {
          break label376;
        }
        zzbnx = null;
      }
      for (zzbny = 0;; zzbny = zzcih)
      {
        zzbob = paramString.optBoolean("use_displayed_impression", false);
        return;
        l = -1L;
        break;
        label376:
        zzbnx = type;
      }
    }
    zzbnp = -1L;
    zzbnq = null;
    zzbnr = null;
    zzbns = null;
    zzbnt = null;
    zzbnw = -1L;
    zzbnx = null;
    zzbny = 0;
    zzbob = false;
    zzbnu = false;
  }
  
  public zzge(List<zzgd> paramList, long paramLong1, List<String> paramList1, List<String> paramList2, List<String> paramList3, List<String> paramList4, boolean paramBoolean1, String paramString1, long paramLong2, int paramInt1, int paramInt2, String paramString2, int paramInt3, int paramInt4, long paramLong3, boolean paramBoolean2)
  {
    zzbno = paramList;
    zzbnp = paramLong1;
    zzbnq = paramList1;
    zzbnr = paramList2;
    zzbns = paramList3;
    zzbnt = paramList4;
    zzbnu = paramBoolean1;
    zzbnv = paramString1;
    zzbnw = paramLong2;
    zzboc = paramInt1;
    zzbod = paramInt2;
    zzbnx = paramString2;
    zzbny = paramInt3;
    zzbnz = paramInt4;
    zzboa = paramLong3;
    zzbob = paramBoolean2;
  }
  
  private boolean zza(zzgd paramzzgd)
  {
    paramzzgd = zzbna.iterator();
    while (paramzzgd.hasNext()) {
      if (((String)paramzzgd.next()).equals("com.google.ads.mediation.admob.AdMobAdapter")) {
        return true;
      }
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzge
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */