package com.google.android.gms.internal;

import com.google.android.gms.common.api.Api.zze;
import java.util.ArrayList;
import java.util.Iterator;

class zzqb$zzc
  extends zzqb.zzf
{
  private final ArrayList<Api.zze> tM;
  
  public zzqb$zzc(ArrayList<Api.zze> paramArrayList)
  {
    super(paramArrayList, null);
    ArrayList localArrayList;
    tM = localArrayList;
  }
  
  public void zzapi()
  {
    zzdtG).sX.tZ = zzqb.zzg(tG);
    Iterator localIterator = tM.iterator();
    while (localIterator.hasNext()) {
      ((Api.zze)localIterator.next()).zza(zzqb.zzh(tG), zzdtG).sX.tZ);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzqb.zzc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */