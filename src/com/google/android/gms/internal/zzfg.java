package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zzu;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@zzir
public class zzfg
  implements Iterable<zzff>
{
  private final List<zzff> zzbji = new LinkedList();
  
  private zzff zzg(zzll paramzzll)
  {
    Iterator localIterator = zzu.zzgj().iterator();
    while (localIterator.hasNext())
    {
      zzff localzzff = (zzff)localIterator.next();
      if (zzbgj == paramzzll) {
        return localzzff;
      }
    }
    return null;
  }
  
  public Iterator<zzff> iterator()
  {
    return zzbji.iterator();
  }
  
  public void zza(zzff paramzzff)
  {
    zzbji.add(paramzzff);
  }
  
  public void zzb(zzff paramzzff)
  {
    zzbji.remove(paramzzff);
  }
  
  public boolean zze(zzll paramzzll)
  {
    paramzzll = zzg(paramzzll);
    if (paramzzll != null)
    {
      zzbjf.abort();
      return true;
    }
    return false;
  }
  
  public boolean zzf(zzll paramzzll)
  {
    return zzg(paramzzll) != null;
  }
  
  public int zzlm()
  {
    return zzbji.size();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzfg
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */