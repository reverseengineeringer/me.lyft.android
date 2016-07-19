package com.google.android.gms.internal;

import java.io.IOException;

public abstract interface zzuo
{
  public static final class zza
    extends zzapc
  {
    private static volatile zza[] aow;
    public Boolean aox;
    public Boolean aoy;
    public String name;
    
    public zza()
    {
      zzbwk();
    }
    
    public static zza[] zzbwj()
    {
      if (aow == null) {}
      synchronized (zzapa.bij)
      {
        if (aow == null) {
          aow = new zza[0];
        }
        return aow;
      }
    }
    
    public boolean equals(Object paramObject)
    {
      if (paramObject == this) {}
      do
      {
        do
        {
          return true;
          if (!(paramObject instanceof zza)) {
            return false;
          }
          paramObject = (zza)paramObject;
          if (name == null)
          {
            if (name != null) {
              return false;
            }
          }
          else if (!name.equals(name)) {
            return false;
          }
          if (aox == null)
          {
            if (aox != null) {
              return false;
            }
          }
          else if (!aox.equals(aox)) {
            return false;
          }
          if (aoy != null) {
            break;
          }
        } while (aoy == null);
        return false;
      } while (aoy.equals(aoy));
      return false;
    }
    
    public int hashCode()
    {
      int k = 0;
      int m = getClass().getName().hashCode();
      int i;
      int j;
      if (name == null)
      {
        i = 0;
        if (aox != null) {
          break label72;
        }
        j = 0;
        label32:
        if (aoy != null) {
          break label83;
        }
      }
      for (;;)
      {
        return (j + (i + (m + 527) * 31) * 31) * 31 + k;
        i = name.hashCode();
        break;
        label72:
        j = aox.hashCode();
        break label32;
        label83:
        k = aoy.hashCode();
      }
    }
    
    public void zza(zzaov paramzzaov)
      throws IOException
    {
      if (name != null) {
        paramzzaov.zzr(1, name);
      }
      if (aox != null) {
        paramzzaov.zzj(2, aox.booleanValue());
      }
      if (aoy != null) {
        paramzzaov.zzj(3, aoy.booleanValue());
      }
      super.zza(paramzzaov);
    }
    
    public zza zzbj(zzaou paramzzaou)
      throws IOException
    {
      for (;;)
      {
        int i = paramzzaou.J();
        switch (i)
        {
        default: 
          if (zzapf.zzb(paramzzaou, i)) {}
          break;
        case 0: 
          return this;
        case 10: 
          name = paramzzaou.readString();
          break;
        case 16: 
          aox = Boolean.valueOf(paramzzaou.P());
          break;
        case 24: 
          aoy = Boolean.valueOf(paramzzaou.P());
        }
      }
    }
    
    public zza zzbwk()
    {
      name = null;
      aox = null;
      aoy = null;
      bik = -1;
      return this;
    }
    
    protected int zzy()
    {
      int j = super.zzy();
      int i = j;
      if (name != null) {
        i = j + zzaov.zzs(1, name);
      }
      j = i;
      if (aox != null) {
        j = i + zzaov.zzk(2, aox.booleanValue());
      }
      i = j;
      if (aoy != null) {
        i = j + zzaov.zzk(3, aoy.booleanValue());
      }
      return i;
    }
  }
  
  public static final class zzb
    extends zzapc
  {
    public String ajz;
    public Integer aoA;
    public zzuo.zzc[] aoB;
    public zzuo.zza[] aoC;
    public zzun.zza[] aoD;
    public Long aoz;
    
    public zzb()
    {
      zzbwl();
    }
    
    public boolean equals(Object paramObject)
    {
      if (paramObject == this) {}
      do
      {
        return true;
        if (!(paramObject instanceof zzb)) {
          return false;
        }
        paramObject = (zzb)paramObject;
        if (aoz == null)
        {
          if (aoz != null) {
            return false;
          }
        }
        else if (!aoz.equals(aoz)) {
          return false;
        }
        if (ajz == null)
        {
          if (ajz != null) {
            return false;
          }
        }
        else if (!ajz.equals(ajz)) {
          return false;
        }
        if (aoA == null)
        {
          if (aoA != null) {
            return false;
          }
        }
        else if (!aoA.equals(aoA)) {
          return false;
        }
        if (!zzapa.equals(aoB, aoB)) {
          return false;
        }
        if (!zzapa.equals(aoC, aoC)) {
          return false;
        }
      } while (zzapa.equals(aoD, aoD));
      return false;
    }
    
    public int hashCode()
    {
      int k = 0;
      int m = getClass().getName().hashCode();
      int i;
      int j;
      if (aoz == null)
      {
        i = 0;
        if (ajz != null) {
          break label105;
        }
        j = 0;
        label32:
        if (aoA != null) {
          break label116;
        }
      }
      for (;;)
      {
        return ((((j + (i + (m + 527) * 31) * 31) * 31 + k) * 31 + zzapa.hashCode(aoB)) * 31 + zzapa.hashCode(aoC)) * 31 + zzapa.hashCode(aoD);
        i = aoz.hashCode();
        break;
        label105:
        j = ajz.hashCode();
        break label32;
        label116:
        k = aoA.hashCode();
      }
    }
    
    public void zza(zzaov paramzzaov)
      throws IOException
    {
      int j = 0;
      if (aoz != null) {
        paramzzaov.zzb(1, aoz.longValue());
      }
      if (ajz != null) {
        paramzzaov.zzr(2, ajz);
      }
      if (aoA != null) {
        paramzzaov.zzae(3, aoA.intValue());
      }
      int i;
      Object localObject;
      if ((aoB != null) && (aoB.length > 0))
      {
        i = 0;
        while (i < aoB.length)
        {
          localObject = aoB[i];
          if (localObject != null) {
            paramzzaov.zza(4, (zzapc)localObject);
          }
          i += 1;
        }
      }
      if ((aoC != null) && (aoC.length > 0))
      {
        i = 0;
        while (i < aoC.length)
        {
          localObject = aoC[i];
          if (localObject != null) {
            paramzzaov.zza(5, (zzapc)localObject);
          }
          i += 1;
        }
      }
      if ((aoD != null) && (aoD.length > 0))
      {
        i = j;
        while (i < aoD.length)
        {
          localObject = aoD[i];
          if (localObject != null) {
            paramzzaov.zza(6, (zzapc)localObject);
          }
          i += 1;
        }
      }
      super.zza(paramzzaov);
    }
    
    public zzb zzbk(zzaou paramzzaou)
      throws IOException
    {
      for (;;)
      {
        int i = paramzzaou.J();
        int j;
        Object localObject;
        switch (i)
        {
        default: 
          if (zzapf.zzb(paramzzaou, i)) {}
          break;
        case 0: 
          return this;
        case 8: 
          aoz = Long.valueOf(paramzzaou.M());
          break;
        case 18: 
          ajz = paramzzaou.readString();
          break;
        case 24: 
          aoA = Integer.valueOf(paramzzaou.N());
          break;
        case 34: 
          j = zzapf.zzc(paramzzaou, 34);
          if (aoB == null) {}
          for (i = 0;; i = aoB.length)
          {
            localObject = new zzuo.zzc[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(aoB, 0, localObject, 0, i);
              j = i;
            }
            while (j < localObject.length - 1)
            {
              localObject[j] = new zzuo.zzc();
              paramzzaou.zza(localObject[j]);
              paramzzaou.J();
              j += 1;
            }
          }
          localObject[j] = new zzuo.zzc();
          paramzzaou.zza(localObject[j]);
          aoB = ((zzuo.zzc[])localObject);
          break;
        case 42: 
          j = zzapf.zzc(paramzzaou, 42);
          if (aoC == null) {}
          for (i = 0;; i = aoC.length)
          {
            localObject = new zzuo.zza[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(aoC, 0, localObject, 0, i);
              j = i;
            }
            while (j < localObject.length - 1)
            {
              localObject[j] = new zzuo.zza();
              paramzzaou.zza(localObject[j]);
              paramzzaou.J();
              j += 1;
            }
          }
          localObject[j] = new zzuo.zza();
          paramzzaou.zza(localObject[j]);
          aoC = ((zzuo.zza[])localObject);
          break;
        case 50: 
          j = zzapf.zzc(paramzzaou, 50);
          if (aoD == null) {}
          for (i = 0;; i = aoD.length)
          {
            localObject = new zzun.zza[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(aoD, 0, localObject, 0, i);
              j = i;
            }
            while (j < localObject.length - 1)
            {
              localObject[j] = new zzun.zza();
              paramzzaou.zza(localObject[j]);
              paramzzaou.J();
              j += 1;
            }
          }
          localObject[j] = new zzun.zza();
          paramzzaou.zza(localObject[j]);
          aoD = ((zzun.zza[])localObject);
        }
      }
    }
    
    public zzb zzbwl()
    {
      aoz = null;
      ajz = null;
      aoA = null;
      aoB = zzuo.zzc.zzbwm();
      aoC = zzuo.zza.zzbwj();
      aoD = zzun.zza.zzbvz();
      bik = -1;
      return this;
    }
    
    protected int zzy()
    {
      int m = 0;
      int j = super.zzy();
      int i = j;
      if (aoz != null) {
        i = j + zzaov.zze(1, aoz.longValue());
      }
      j = i;
      if (ajz != null) {
        j = i + zzaov.zzs(2, ajz);
      }
      i = j;
      if (aoA != null) {
        i = j + zzaov.zzag(3, aoA.intValue());
      }
      j = i;
      Object localObject;
      if (aoB != null)
      {
        j = i;
        if (aoB.length > 0)
        {
          j = 0;
          while (j < aoB.length)
          {
            localObject = aoB[j];
            k = i;
            if (localObject != null) {
              k = i + zzaov.zzc(4, (zzapc)localObject);
            }
            j += 1;
            i = k;
          }
          j = i;
        }
      }
      i = j;
      if (aoC != null)
      {
        i = j;
        if (aoC.length > 0)
        {
          i = j;
          j = 0;
          while (j < aoC.length)
          {
            localObject = aoC[j];
            k = i;
            if (localObject != null) {
              k = i + zzaov.zzc(5, (zzapc)localObject);
            }
            j += 1;
            i = k;
          }
        }
      }
      int k = i;
      if (aoD != null)
      {
        k = i;
        if (aoD.length > 0)
        {
          j = m;
          for (;;)
          {
            k = i;
            if (j >= aoD.length) {
              break;
            }
            localObject = aoD[j];
            k = i;
            if (localObject != null) {
              k = i + zzaov.zzc(6, (zzapc)localObject);
            }
            j += 1;
            i = k;
          }
        }
      }
      return k;
    }
  }
  
  public static final class zzc
    extends zzapc
  {
    private static volatile zzc[] aoE;
    public String value;
    public String zzcb;
    
    public zzc()
    {
      zzbwn();
    }
    
    public static zzc[] zzbwm()
    {
      if (aoE == null) {}
      synchronized (zzapa.bij)
      {
        if (aoE == null) {
          aoE = new zzc[0];
        }
        return aoE;
      }
    }
    
    public boolean equals(Object paramObject)
    {
      if (paramObject == this) {}
      do
      {
        do
        {
          return true;
          if (!(paramObject instanceof zzc)) {
            return false;
          }
          paramObject = (zzc)paramObject;
          if (zzcb == null)
          {
            if (zzcb != null) {
              return false;
            }
          }
          else if (!zzcb.equals(zzcb)) {
            return false;
          }
          if (value != null) {
            break;
          }
        } while (value == null);
        return false;
      } while (value.equals(value));
      return false;
    }
    
    public int hashCode()
    {
      int j = 0;
      int k = getClass().getName().hashCode();
      int i;
      if (zzcb == null)
      {
        i = 0;
        if (value != null) {
          break label56;
        }
      }
      for (;;)
      {
        return (i + (k + 527) * 31) * 31 + j;
        i = zzcb.hashCode();
        break;
        label56:
        j = value.hashCode();
      }
    }
    
    public void zza(zzaov paramzzaov)
      throws IOException
    {
      if (zzcb != null) {
        paramzzaov.zzr(1, zzcb);
      }
      if (value != null) {
        paramzzaov.zzr(2, value);
      }
      super.zza(paramzzaov);
    }
    
    public zzc zzbl(zzaou paramzzaou)
      throws IOException
    {
      for (;;)
      {
        int i = paramzzaou.J();
        switch (i)
        {
        default: 
          if (zzapf.zzb(paramzzaou, i)) {}
          break;
        case 0: 
          return this;
        case 10: 
          zzcb = paramzzaou.readString();
          break;
        case 18: 
          value = paramzzaou.readString();
        }
      }
    }
    
    public zzc zzbwn()
    {
      zzcb = null;
      value = null;
      bik = -1;
      return this;
    }
    
    protected int zzy()
    {
      int j = super.zzy();
      int i = j;
      if (zzcb != null) {
        i = j + zzaov.zzs(1, zzcb);
      }
      j = i;
      if (value != null) {
        j = i + zzaov.zzs(2, value);
      }
      return j;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzuo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */