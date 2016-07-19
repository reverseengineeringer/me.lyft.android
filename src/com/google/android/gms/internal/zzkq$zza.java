package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzaa.zza;

public class zzkq$zza
{
  public final int count;
  public final String name;
  public final double zzcma;
  public final double zzcmb;
  public final double zzcmc;
  
  public zzkq$zza(String paramString, double paramDouble1, double paramDouble2, double paramDouble3, int paramInt)
  {
    name = paramString;
    zzcmb = paramDouble1;
    zzcma = paramDouble2;
    zzcmc = paramDouble3;
    count = paramInt;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof zza)) {}
    do
    {
      return false;
      paramObject = (zza)paramObject;
    } while ((!zzaa.equal(name, name)) || (zzcma != zzcma) || (zzcmb != zzcmb) || (count != count) || (Double.compare(zzcmc, zzcmc) != 0));
    return true;
  }
  
  public int hashCode()
  {
    return zzaa.hashCode(new Object[] { name, Double.valueOf(zzcma), Double.valueOf(zzcmb), Double.valueOf(zzcmc), Integer.valueOf(count) });
  }
  
  public String toString()
  {
    return zzaa.zzz(this).zzg("name", name).zzg("minBound", Double.valueOf(zzcmb)).zzg("maxBound", Double.valueOf(zzcma)).zzg("percent", Double.valueOf(zzcmc)).zzg("count", Integer.valueOf(count)).toString();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzkq.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */