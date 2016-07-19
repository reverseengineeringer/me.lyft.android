package com.google.android.gms.internal;

import java.util.AbstractMap.SimpleEntry;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONObject;

@zzir
public class zzfz
  implements zzfy
{
  private final zzfx zzbmw;
  private final HashSet<AbstractMap.SimpleEntry<String, zzet>> zzbmx;
  
  public zzfz(zzfx paramzzfx)
  {
    zzbmw = paramzzfx;
    zzbmx = new HashSet();
  }
  
  public void zza(String paramString, zzet paramzzet)
  {
    zzbmw.zza(paramString, paramzzet);
    zzbmx.add(new AbstractMap.SimpleEntry(paramString, paramzzet));
  }
  
  public void zza(String paramString, JSONObject paramJSONObject)
  {
    zzbmw.zza(paramString, paramJSONObject);
  }
  
  public void zzb(String paramString, zzet paramzzet)
  {
    zzbmw.zzb(paramString, paramzzet);
    zzbmx.remove(new AbstractMap.SimpleEntry(paramString, paramzzet));
  }
  
  public void zzb(String paramString, JSONObject paramJSONObject)
  {
    zzbmw.zzb(paramString, paramJSONObject);
  }
  
  public void zzj(String paramString1, String paramString2)
  {
    zzbmw.zzj(paramString1, paramString2);
  }
  
  public void zzmh()
  {
    Iterator localIterator = zzbmx.iterator();
    if (localIterator.hasNext())
    {
      AbstractMap.SimpleEntry localSimpleEntry = (AbstractMap.SimpleEntry)localIterator.next();
      String str = String.valueOf(((zzet)localSimpleEntry.getValue()).toString());
      if (str.length() != 0) {}
      for (str = "Unregistering eventhandler: ".concat(str);; str = new String("Unregistering eventhandler: "))
      {
        zzkh.v(str);
        zzbmw.zzb((String)localSimpleEntry.getKey(), (zzet)localSimpleEntry.getValue());
        break;
      }
    }
    zzbmx.clear();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzfz
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */