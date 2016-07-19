package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@zzir
public class zzcz
{
  private final Collection<zzcy> zzaxp = new ArrayList();
  private final Collection<zzcy<String>> zzaxq = new ArrayList();
  private final Collection<zzcy<String>> zzaxr = new ArrayList();
  
  public void zza(zzcy paramzzcy)
  {
    zzaxp.add(paramzzcy);
  }
  
  public void zzb(zzcy<String> paramzzcy)
  {
    zzaxq.add(paramzzcy);
  }
  
  public void zzc(zzcy<String> paramzzcy)
  {
    zzaxr.add(paramzzcy);
  }
  
  public List<String> zzjx()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = zzaxq.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)((zzcy)localIterator.next()).get();
      if (str != null) {
        localArrayList.add(str);
      }
    }
    return localArrayList;
  }
  
  public List<String> zzjy()
  {
    List localList = zzjx();
    Iterator localIterator = zzaxr.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)((zzcy)localIterator.next()).get();
      if (str != null) {
        localList.add(str);
      }
    }
    return localList;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzcz
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */