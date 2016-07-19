package com.google.android.gms.common.internal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class zzf$zza
  extends zzf
{
  List<zzf> xX;
  
  zzf$zza(List<zzf> paramList)
  {
    xX = paramList;
  }
  
  public zzf zza(zzf paramzzf)
  {
    ArrayList localArrayList = new ArrayList(xX);
    localArrayList.add((zzf)zzab.zzaa(paramzzf));
    return new zza(localArrayList);
  }
  
  public boolean zzd(char paramChar)
  {
    Iterator localIterator = xX.iterator();
    while (localIterator.hasNext()) {
      if (((zzf)localIterator.next()).zzd(paramChar)) {
        return true;
      }
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.internal.zzf.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */