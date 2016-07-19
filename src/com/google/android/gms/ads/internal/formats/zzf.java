package com.google.android.gms.ads.internal.formats;

import android.support.v4.util.SimpleArrayMap;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.internal.zzdu;
import com.google.android.gms.internal.zzec.zza;
import com.google.android.gms.internal.zzir;
import java.util.Arrays;
import java.util.List;

@zzir
public class zzf
  extends zzec.zza
  implements zzh.zza
{
  private final Object zzail = new Object();
  private final zza zzbfs;
  private zzh zzbft;
  private final String zzbfw;
  private final SimpleArrayMap<String, zzc> zzbfx;
  private final SimpleArrayMap<String, String> zzbfy;
  
  public zzf(String paramString, SimpleArrayMap<String, zzc> paramSimpleArrayMap, SimpleArrayMap<String, String> paramSimpleArrayMap1, zza paramzza)
  {
    zzbfw = paramString;
    zzbfx = paramSimpleArrayMap;
    zzbfy = paramSimpleArrayMap1;
    zzbfs = paramzza;
  }
  
  public List<String> getAvailableAssetNames()
  {
    int n = 0;
    String[] arrayOfString = new String[zzbfx.size() + zzbfy.size()];
    int j = 0;
    int i = 0;
    int k;
    int m;
    for (;;)
    {
      k = n;
      m = i;
      if (j >= zzbfx.size()) {
        break;
      }
      arrayOfString[i] = ((String)zzbfx.keyAt(j));
      i += 1;
      j += 1;
    }
    while (k < zzbfy.size())
    {
      arrayOfString[m] = ((String)zzbfy.keyAt(k));
      k += 1;
      m += 1;
    }
    return Arrays.asList(arrayOfString);
  }
  
  public String getCustomTemplateId()
  {
    return zzbfw;
  }
  
  public void performClick(String paramString)
  {
    synchronized (zzail)
    {
      if (zzbft == null)
      {
        zzb.e("Attempt to call performClick before ad initialized.");
        return;
      }
      zzbft.zza(paramString, null, null, null);
      return;
    }
  }
  
  public void recordImpression()
  {
    synchronized (zzail)
    {
      if (zzbft == null)
      {
        zzb.e("Attempt to perform recordImpression before ad initialized.");
        return;
      }
      zzbft.recordImpression();
      return;
    }
  }
  
  public String zzau(String paramString)
  {
    return (String)zzbfy.get(paramString);
  }
  
  public zzdu zzav(String paramString)
  {
    return (zzdu)zzbfx.get(paramString);
  }
  
  public void zzb(zzh paramzzh)
  {
    synchronized (zzail)
    {
      zzbft = paramzzh;
      return;
    }
  }
  
  public String zzky()
  {
    return "3";
  }
  
  public zza zzkz()
  {
    return zzbfs;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.formats.zzf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */