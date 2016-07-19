package com.google.android.gms.ads.internal;

import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.SearchAdRequestParcel;
import com.google.android.gms.internal.zzcy;
import com.google.android.gms.internal.zzdc;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

class zzt$zzb
{
  private final String zzann;
  private final Map<String, String> zzano;
  private String zzanp;
  private String zzanq;
  
  public zzt$zzb(String paramString)
  {
    zzann = paramString;
    zzano = new TreeMap();
  }
  
  public String getQuery()
  {
    return zzanp;
  }
  
  public String zzfi()
  {
    return zzanq;
  }
  
  public String zzfj()
  {
    return zzann;
  }
  
  public Map<String, String> zzfk()
  {
    return zzano;
  }
  
  public void zzh(AdRequestParcel paramAdRequestParcel)
  {
    zzanp = zzatr.zzaxj;
    if (zzatu != null) {}
    for (paramAdRequestParcel = zzatu.getBundle(AdMobAdapter.class.getName());; paramAdRequestParcel = null)
    {
      if (paramAdRequestParcel == null) {}
      for (;;)
      {
        return;
        String str1 = (String)zzdc.zzbda.get();
        Iterator localIterator = paramAdRequestParcel.keySet().iterator();
        while (localIterator.hasNext())
        {
          String str2 = (String)localIterator.next();
          if (str1.equals(str2)) {
            zzanq = paramAdRequestParcel.getString(str2);
          } else if (str2.startsWith("csa_")) {
            zzano.put(str2.substring("csa_".length()), paramAdRequestParcel.getString(str2));
          }
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.zzt.zzb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */