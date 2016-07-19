package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzaa.zza;
import java.util.ArrayList;
import java.util.List;

@zzir
public class zzkq
{
  private final String[] zzclv;
  private final double[] zzclw;
  private final double[] zzclx;
  private final int[] zzcly;
  private int zzclz;
  
  private zzkq(zzb paramzzb)
  {
    int i = zzb.zza(paramzzb).size();
    zzclv = ((String[])zzb.zzb(paramzzb).toArray(new String[i]));
    zzclw = zzm(zzb.zza(paramzzb));
    zzclx = zzm(zzb.zzc(paramzzb));
    zzcly = new int[i];
    zzclz = 0;
  }
  
  private double[] zzm(List<Double> paramList)
  {
    double[] arrayOfDouble = new double[paramList.size()];
    int i = 0;
    while (i < arrayOfDouble.length)
    {
      arrayOfDouble[i] = ((Double)paramList.get(i)).doubleValue();
      i += 1;
    }
    return arrayOfDouble;
  }
  
  public List<zza> getBuckets()
  {
    ArrayList localArrayList = new ArrayList(zzclv.length);
    int i = 0;
    while (i < zzclv.length)
    {
      localArrayList.add(new zza(zzclv[i], zzclx[i], zzclw[i], zzcly[i] / zzclz, zzcly[i]));
      i += 1;
    }
    return localArrayList;
  }
  
  public void zza(double paramDouble)
  {
    zzclz += 1;
    int i = 0;
    for (;;)
    {
      if (i < zzclx.length)
      {
        if ((zzclx[i] <= paramDouble) && (paramDouble < zzclw[i]))
        {
          int[] arrayOfInt = zzcly;
          arrayOfInt[i] += 1;
        }
        if (paramDouble >= zzclx[i]) {}
      }
      else
      {
        return;
      }
      i += 1;
    }
  }
  
  public static class zza
  {
    public final int count;
    public final String name;
    public final double zzcma;
    public final double zzcmb;
    public final double zzcmc;
    
    public zza(String paramString, double paramDouble1, double paramDouble2, double paramDouble3, int paramInt)
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
  
  public static class zzb
  {
    private final List<String> zzcmd = new ArrayList();
    private final List<Double> zzcme = new ArrayList();
    private final List<Double> zzcmf = new ArrayList();
    
    public zzb zza(String paramString, double paramDouble1, double paramDouble2)
    {
      int i = 0;
      for (;;)
      {
        double d1;
        double d2;
        if (i < zzcmd.size())
        {
          d1 = ((Double)zzcmf.get(i)).doubleValue();
          d2 = ((Double)zzcme.get(i)).doubleValue();
          if (paramDouble1 >= d1) {
            break label107;
          }
        }
        label107:
        while ((d1 == paramDouble1) && (paramDouble2 < d2))
        {
          zzcmd.add(i, paramString);
          zzcmf.add(i, Double.valueOf(paramDouble1));
          zzcme.add(i, Double.valueOf(paramDouble2));
          return this;
        }
        i += 1;
      }
    }
    
    public zzkq zztp()
    {
      return new zzkq(this, null);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzkq
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */