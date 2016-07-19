package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zzu;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzir
public final class zzgd
{
  public final String zzbmy;
  public final String zzbmz;
  public final List<String> zzbna;
  public final String zzbnb;
  public final String zzbnc;
  public final List<String> zzbnd;
  public final List<String> zzbne;
  public final List<String> zzbnf;
  public final String zzbng;
  public final List<String> zzbnh;
  public final List<String> zzbni;
  public final String zzbnj;
  public final String zzbnk;
  public final String zzbnl;
  public final List<String> zzbnm;
  public final String zzbnn;
  
  public zzgd(String paramString1, String paramString2, List<String> paramList1, String paramString3, String paramString4, List<String> paramList2, List<String> paramList3, String paramString5, String paramString6, List<String> paramList4, List<String> paramList5, String paramString7, String paramString8, String paramString9, List<String> paramList6, String paramString10, List<String> paramList7)
  {
    zzbmy = paramString1;
    zzbmz = paramString2;
    zzbna = paramList1;
    zzbnb = paramString3;
    zzbnc = paramString4;
    zzbnd = paramList2;
    zzbne = paramList3;
    zzbng = paramString5;
    zzbnh = paramList4;
    zzbni = paramList5;
    zzbnj = paramString7;
    zzbnk = paramString8;
    zzbnl = paramString9;
    zzbnm = paramList6;
    zzbnn = paramString10;
    zzbnf = paramList7;
  }
  
  public zzgd(JSONObject paramJSONObject)
    throws JSONException
  {
    zzbmz = paramJSONObject.getString("id");
    Object localObject1 = paramJSONObject.getJSONArray("adapters");
    Object localObject3 = new ArrayList(((JSONArray)localObject1).length());
    int i = 0;
    while (i < ((JSONArray)localObject1).length())
    {
      ((List)localObject3).add(((JSONArray)localObject1).getString(i));
      i += 1;
    }
    zzbna = Collections.unmodifiableList((List)localObject3);
    zzbnb = paramJSONObject.optString("allocation_id", null);
    zzbnd = zzu.zzgf().zza(paramJSONObject, "clickurl");
    zzbne = zzu.zzgf().zza(paramJSONObject, "imp_urls");
    zzbnf = zzu.zzgf().zza(paramJSONObject, "fill_urls");
    zzbnh = zzu.zzgf().zza(paramJSONObject, "video_start_urls");
    zzbni = zzu.zzgf().zza(paramJSONObject, "video_complete_urls");
    localObject1 = paramJSONObject.optJSONObject("ad");
    if (localObject1 != null)
    {
      localObject1 = ((JSONObject)localObject1).toString();
      zzbmy = ((String)localObject1);
      localObject3 = paramJSONObject.optJSONObject("data");
      if (localObject3 == null) {
        break label301;
      }
      localObject1 = ((JSONObject)localObject3).toString();
      label192:
      zzbng = ((String)localObject1);
      if (localObject3 == null) {
        break label306;
      }
      localObject1 = ((JSONObject)localObject3).optString("class_name");
      label210:
      zzbnc = ((String)localObject1);
      zzbnj = paramJSONObject.optString("html_template", null);
      zzbnk = paramJSONObject.optString("ad_base_url", null);
      localObject1 = paramJSONObject.optJSONObject("assets");
      if (localObject1 == null) {
        break label311;
      }
    }
    label301:
    label306:
    label311:
    for (localObject1 = ((JSONObject)localObject1).toString();; localObject1 = null)
    {
      zzbnl = ((String)localObject1);
      zzbnm = zzu.zzgf().zza(paramJSONObject, "template_ids");
      localObject1 = paramJSONObject.optJSONObject("ad_loader_options");
      paramJSONObject = (JSONObject)localObject2;
      if (localObject1 != null) {
        paramJSONObject = ((JSONObject)localObject1).toString();
      }
      zzbnn = paramJSONObject;
      return;
      localObject1 = null;
      break;
      localObject1 = null;
      break label192;
      localObject1 = null;
      break label210;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzgd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */