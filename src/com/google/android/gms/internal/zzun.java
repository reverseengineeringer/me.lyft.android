package com.google.android.gms.internal;

import java.io.IOException;

public abstract interface zzun
{
  public static final class zza
    extends zzapc
  {
    private static volatile zza[] anV;
    public Integer anW;
    public zzun.zze[] anX;
    public zzun.zzb[] anY;
    
    public zza()
    {
      zzbwa();
    }
    
    public static zza[] zzbvz()
    {
      if (anV == null) {}
      synchronized (zzapa.bij)
      {
        if (anV == null) {
          anV = new zza[0];
        }
        return anV;
      }
    }
    
    public boolean equals(Object paramObject)
    {
      if (paramObject == this) {}
      do
      {
        return true;
        if (!(paramObject instanceof zza)) {
          return false;
        }
        paramObject = (zza)paramObject;
        if (anW == null)
        {
          if (anW != null) {
            return false;
          }
        }
        else if (!anW.equals(anW)) {
          return false;
        }
        if (!zzapa.equals(anX, anX)) {
          return false;
        }
      } while (zzapa.equals(anY, anY));
      return false;
    }
    
    public int hashCode()
    {
      int j = getClass().getName().hashCode();
      if (anW == null) {}
      for (int i = 0;; i = anW.hashCode()) {
        return ((i + (j + 527) * 31) * 31 + zzapa.hashCode(anX)) * 31 + zzapa.hashCode(anY);
      }
    }
    
    public void zza(zzaov paramzzaov)
      throws IOException
    {
      int j = 0;
      if (anW != null) {
        paramzzaov.zzae(1, anW.intValue());
      }
      int i;
      Object localObject;
      if ((anX != null) && (anX.length > 0))
      {
        i = 0;
        while (i < anX.length)
        {
          localObject = anX[i];
          if (localObject != null) {
            paramzzaov.zza(2, (zzapc)localObject);
          }
          i += 1;
        }
      }
      if ((anY != null) && (anY.length > 0))
      {
        i = j;
        while (i < anY.length)
        {
          localObject = anY[i];
          if (localObject != null) {
            paramzzaov.zza(3, (zzapc)localObject);
          }
          i += 1;
        }
      }
      super.zza(paramzzaov);
    }
    
    public zza zzbd(zzaou paramzzaou)
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
          anW = Integer.valueOf(paramzzaou.N());
          break;
        case 18: 
          j = zzapf.zzc(paramzzaou, 18);
          if (anX == null) {}
          for (i = 0;; i = anX.length)
          {
            localObject = new zzun.zze[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(anX, 0, localObject, 0, i);
              j = i;
            }
            while (j < localObject.length - 1)
            {
              localObject[j] = new zzun.zze();
              paramzzaou.zza(localObject[j]);
              paramzzaou.J();
              j += 1;
            }
          }
          localObject[j] = new zzun.zze();
          paramzzaou.zza(localObject[j]);
          anX = ((zzun.zze[])localObject);
          break;
        case 26: 
          j = zzapf.zzc(paramzzaou, 26);
          if (anY == null) {}
          for (i = 0;; i = anY.length)
          {
            localObject = new zzun.zzb[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(anY, 0, localObject, 0, i);
              j = i;
            }
            while (j < localObject.length - 1)
            {
              localObject[j] = new zzun.zzb();
              paramzzaou.zza(localObject[j]);
              paramzzaou.J();
              j += 1;
            }
          }
          localObject[j] = new zzun.zzb();
          paramzzaou.zza(localObject[j]);
          anY = ((zzun.zzb[])localObject);
        }
      }
    }
    
    public zza zzbwa()
    {
      anW = null;
      anX = zzun.zze.zzbwg();
      anY = zzun.zzb.zzbwb();
      bik = -1;
      return this;
    }
    
    protected int zzy()
    {
      int m = 0;
      int i = super.zzy();
      int j = i;
      if (anW != null) {
        j = i + zzaov.zzag(1, anW.intValue());
      }
      i = j;
      Object localObject;
      if (anX != null)
      {
        i = j;
        if (anX.length > 0)
        {
          i = j;
          j = 0;
          while (j < anX.length)
          {
            localObject = anX[j];
            k = i;
            if (localObject != null) {
              k = i + zzaov.zzc(2, (zzapc)localObject);
            }
            j += 1;
            i = k;
          }
        }
      }
      int k = i;
      if (anY != null)
      {
        k = i;
        if (anY.length > 0)
        {
          j = m;
          for (;;)
          {
            k = i;
            if (j >= anY.length) {
              break;
            }
            localObject = anY[j];
            k = i;
            if (localObject != null) {
              k = i + zzaov.zzc(3, (zzapc)localObject);
            }
            j += 1;
            i = k;
          }
        }
      }
      return k;
    }
  }
  
  public static final class zzb
    extends zzapc
  {
    private static volatile zzb[] anZ;
    public Integer aoa;
    public String aob;
    public zzun.zzc[] aoc;
    public Boolean aod;
    public zzun.zzd aoe;
    
    public zzb()
    {
      zzbwc();
    }
    
    public static zzb[] zzbwb()
    {
      if (anZ == null) {}
      synchronized (zzapa.bij)
      {
        if (anZ == null) {
          anZ = new zzb[0];
        }
        return anZ;
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
          if (!(paramObject instanceof zzb)) {
            return false;
          }
          paramObject = (zzb)paramObject;
          if (aoa == null)
          {
            if (aoa != null) {
              return false;
            }
          }
          else if (!aoa.equals(aoa)) {
            return false;
          }
          if (aob == null)
          {
            if (aob != null) {
              return false;
            }
          }
          else if (!aob.equals(aob)) {
            return false;
          }
          if (!zzapa.equals(aoc, aoc)) {
            return false;
          }
          if (aod == null)
          {
            if (aod != null) {
              return false;
            }
          }
          else if (!aod.equals(aod)) {
            return false;
          }
          if (aoe != null) {
            break;
          }
        } while (aoe == null);
        return false;
      } while (aoe.equals(aoe));
      return false;
    }
    
    public int hashCode()
    {
      int m = 0;
      int n = getClass().getName().hashCode();
      int i;
      int j;
      label33:
      int i1;
      int k;
      if (aoa == null)
      {
        i = 0;
        if (aob != null) {
          break label103;
        }
        j = 0;
        i1 = zzapa.hashCode(aoc);
        if (aod != null) {
          break label114;
        }
        k = 0;
        label51:
        if (aoe != null) {
          break label125;
        }
      }
      for (;;)
      {
        return (k + ((j + (i + (n + 527) * 31) * 31) * 31 + i1) * 31) * 31 + m;
        i = aoa.hashCode();
        break;
        label103:
        j = aob.hashCode();
        break label33;
        label114:
        k = aod.hashCode();
        break label51;
        label125:
        m = aoe.hashCode();
      }
    }
    
    public void zza(zzaov paramzzaov)
      throws IOException
    {
      if (aoa != null) {
        paramzzaov.zzae(1, aoa.intValue());
      }
      if (aob != null) {
        paramzzaov.zzr(2, aob);
      }
      if ((aoc != null) && (aoc.length > 0))
      {
        int i = 0;
        while (i < aoc.length)
        {
          zzun.zzc localzzc = aoc[i];
          if (localzzc != null) {
            paramzzaov.zza(3, localzzc);
          }
          i += 1;
        }
      }
      if (aod != null) {
        paramzzaov.zzj(4, aod.booleanValue());
      }
      if (aoe != null) {
        paramzzaov.zza(5, aoe);
      }
      super.zza(paramzzaov);
    }
    
    public zzb zzbe(zzaou paramzzaou)
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
        case 8: 
          aoa = Integer.valueOf(paramzzaou.N());
          break;
        case 18: 
          aob = paramzzaou.readString();
          break;
        case 26: 
          int j = zzapf.zzc(paramzzaou, 26);
          if (aoc == null) {}
          zzun.zzc[] arrayOfzzc;
          for (i = 0;; i = aoc.length)
          {
            arrayOfzzc = new zzun.zzc[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(aoc, 0, arrayOfzzc, 0, i);
              j = i;
            }
            while (j < arrayOfzzc.length - 1)
            {
              arrayOfzzc[j] = new zzun.zzc();
              paramzzaou.zza(arrayOfzzc[j]);
              paramzzaou.J();
              j += 1;
            }
          }
          arrayOfzzc[j] = new zzun.zzc();
          paramzzaou.zza(arrayOfzzc[j]);
          aoc = arrayOfzzc;
          break;
        case 32: 
          aod = Boolean.valueOf(paramzzaou.P());
          break;
        case 42: 
          if (aoe == null) {
            aoe = new zzun.zzd();
          }
          paramzzaou.zza(aoe);
        }
      }
    }
    
    public zzb zzbwc()
    {
      aoa = null;
      aob = null;
      aoc = zzun.zzc.zzbwd();
      aod = null;
      aoe = null;
      bik = -1;
      return this;
    }
    
    protected int zzy()
    {
      int i = super.zzy();
      int j = i;
      if (aoa != null) {
        j = i + zzaov.zzag(1, aoa.intValue());
      }
      i = j;
      if (aob != null) {
        i = j + zzaov.zzs(2, aob);
      }
      j = i;
      if (aoc != null)
      {
        j = i;
        if (aoc.length > 0)
        {
          j = 0;
          while (j < aoc.length)
          {
            zzun.zzc localzzc = aoc[j];
            int k = i;
            if (localzzc != null) {
              k = i + zzaov.zzc(3, localzzc);
            }
            j += 1;
            i = k;
          }
          j = i;
        }
      }
      i = j;
      if (aod != null) {
        i = j + zzaov.zzk(4, aod.booleanValue());
      }
      j = i;
      if (aoe != null) {
        j = i + zzaov.zzc(5, aoe);
      }
      return j;
    }
  }
  
  public static final class zzc
    extends zzapc
  {
    private static volatile zzc[] aof;
    public zzun.zzf aog;
    public zzun.zzd aoh;
    public Boolean aoi;
    public String aoj;
    
    public zzc()
    {
      zzbwe();
    }
    
    public static zzc[] zzbwd()
    {
      if (aof == null) {}
      synchronized (zzapa.bij)
      {
        if (aof == null) {
          aof = new zzc[0];
        }
        return aof;
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
          if (aog == null)
          {
            if (aog != null) {
              return false;
            }
          }
          else if (!aog.equals(aog)) {
            return false;
          }
          if (aoh == null)
          {
            if (aoh != null) {
              return false;
            }
          }
          else if (!aoh.equals(aoh)) {
            return false;
          }
          if (aoi == null)
          {
            if (aoi != null) {
              return false;
            }
          }
          else if (!aoi.equals(aoi)) {
            return false;
          }
          if (aoj != null) {
            break;
          }
        } while (aoj == null);
        return false;
      } while (aoj.equals(aoj));
      return false;
    }
    
    public int hashCode()
    {
      int m = 0;
      int n = getClass().getName().hashCode();
      int i;
      int j;
      label33:
      int k;
      if (aog == null)
      {
        i = 0;
        if (aoh != null) {
          break label88;
        }
        j = 0;
        if (aoi != null) {
          break label99;
        }
        k = 0;
        label42:
        if (aoj != null) {
          break label110;
        }
      }
      for (;;)
      {
        return (k + (j + (i + (n + 527) * 31) * 31) * 31) * 31 + m;
        i = aog.hashCode();
        break;
        label88:
        j = aoh.hashCode();
        break label33;
        label99:
        k = aoi.hashCode();
        break label42;
        label110:
        m = aoj.hashCode();
      }
    }
    
    public void zza(zzaov paramzzaov)
      throws IOException
    {
      if (aog != null) {
        paramzzaov.zza(1, aog);
      }
      if (aoh != null) {
        paramzzaov.zza(2, aoh);
      }
      if (aoi != null) {
        paramzzaov.zzj(3, aoi.booleanValue());
      }
      if (aoj != null) {
        paramzzaov.zzr(4, aoj);
      }
      super.zza(paramzzaov);
    }
    
    public zzc zzbf(zzaou paramzzaou)
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
          if (aog == null) {
            aog = new zzun.zzf();
          }
          paramzzaou.zza(aog);
          break;
        case 18: 
          if (aoh == null) {
            aoh = new zzun.zzd();
          }
          paramzzaou.zza(aoh);
          break;
        case 24: 
          aoi = Boolean.valueOf(paramzzaou.P());
          break;
        case 34: 
          aoj = paramzzaou.readString();
        }
      }
    }
    
    public zzc zzbwe()
    {
      aog = null;
      aoh = null;
      aoi = null;
      aoj = null;
      bik = -1;
      return this;
    }
    
    protected int zzy()
    {
      int j = super.zzy();
      int i = j;
      if (aog != null) {
        i = j + zzaov.zzc(1, aog);
      }
      j = i;
      if (aoh != null) {
        j = i + zzaov.zzc(2, aoh);
      }
      i = j;
      if (aoi != null) {
        i = j + zzaov.zzk(3, aoi.booleanValue());
      }
      j = i;
      if (aoj != null) {
        j = i + zzaov.zzs(4, aoj);
      }
      return j;
    }
  }
  
  public static final class zzd
    extends zzapc
  {
    public Integer aok;
    public Boolean aol;
    public String aom;
    public String aon;
    public String aoo;
    
    public zzd()
    {
      zzbwf();
    }
    
    public boolean equals(Object paramObject)
    {
      if (paramObject == this) {}
      do
      {
        do
        {
          return true;
          if (!(paramObject instanceof zzd)) {
            return false;
          }
          paramObject = (zzd)paramObject;
          if (aok == null)
          {
            if (aok != null) {
              return false;
            }
          }
          else if (!aok.equals(aok)) {
            return false;
          }
          if (aol == null)
          {
            if (aol != null) {
              return false;
            }
          }
          else if (!aol.equals(aol)) {
            return false;
          }
          if (aom == null)
          {
            if (aom != null) {
              return false;
            }
          }
          else if (!aom.equals(aom)) {
            return false;
          }
          if (aon == null)
          {
            if (aon != null) {
              return false;
            }
          }
          else if (!aon.equals(aon)) {
            return false;
          }
          if (aoo != null) {
            break;
          }
        } while (aoo == null);
        return false;
      } while (aoo.equals(aoo));
      return false;
    }
    
    public int hashCode()
    {
      int n = 0;
      int i1 = getClass().getName().hashCode();
      int i;
      int j;
      label33:
      int k;
      label42:
      int m;
      if (aok == null)
      {
        i = 0;
        if (aol != null) {
          break label104;
        }
        j = 0;
        if (aom != null) {
          break label115;
        }
        k = 0;
        if (aon != null) {
          break label126;
        }
        m = 0;
        label52:
        if (aoo != null) {
          break label138;
        }
      }
      for (;;)
      {
        return (m + (k + (j + (i + (i1 + 527) * 31) * 31) * 31) * 31) * 31 + n;
        i = aok.intValue();
        break;
        label104:
        j = aol.hashCode();
        break label33;
        label115:
        k = aom.hashCode();
        break label42;
        label126:
        m = aon.hashCode();
        break label52;
        label138:
        n = aoo.hashCode();
      }
    }
    
    public void zza(zzaov paramzzaov)
      throws IOException
    {
      if (aok != null) {
        paramzzaov.zzae(1, aok.intValue());
      }
      if (aol != null) {
        paramzzaov.zzj(2, aol.booleanValue());
      }
      if (aom != null) {
        paramzzaov.zzr(3, aom);
      }
      if (aon != null) {
        paramzzaov.zzr(4, aon);
      }
      if (aoo != null) {
        paramzzaov.zzr(5, aoo);
      }
      super.zza(paramzzaov);
    }
    
    public zzd zzbg(zzaou paramzzaou)
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
        case 8: 
          i = paramzzaou.N();
          switch (i)
          {
          default: 
            break;
          case 0: 
          case 1: 
          case 2: 
          case 3: 
          case 4: 
            aok = Integer.valueOf(i);
          }
          break;
        case 16: 
          aol = Boolean.valueOf(paramzzaou.P());
          break;
        case 26: 
          aom = paramzzaou.readString();
          break;
        case 34: 
          aon = paramzzaou.readString();
          break;
        case 42: 
          aoo = paramzzaou.readString();
        }
      }
    }
    
    public zzd zzbwf()
    {
      aol = null;
      aom = null;
      aon = null;
      aoo = null;
      bik = -1;
      return this;
    }
    
    protected int zzy()
    {
      int j = super.zzy();
      int i = j;
      if (aok != null) {
        i = j + zzaov.zzag(1, aok.intValue());
      }
      j = i;
      if (aol != null) {
        j = i + zzaov.zzk(2, aol.booleanValue());
      }
      i = j;
      if (aom != null) {
        i = j + zzaov.zzs(3, aom);
      }
      j = i;
      if (aon != null) {
        j = i + zzaov.zzs(4, aon);
      }
      i = j;
      if (aoo != null) {
        i = j + zzaov.zzs(5, aoo);
      }
      return i;
    }
  }
  
  public static final class zze
    extends zzapc
  {
    private static volatile zze[] aop;
    public Integer aoa;
    public String aoq;
    public zzun.zzc aor;
    
    public zze()
    {
      zzbwh();
    }
    
    public static zze[] zzbwg()
    {
      if (aop == null) {}
      synchronized (zzapa.bij)
      {
        if (aop == null) {
          aop = new zze[0];
        }
        return aop;
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
          if (!(paramObject instanceof zze)) {
            return false;
          }
          paramObject = (zze)paramObject;
          if (aoa == null)
          {
            if (aoa != null) {
              return false;
            }
          }
          else if (!aoa.equals(aoa)) {
            return false;
          }
          if (aoq == null)
          {
            if (aoq != null) {
              return false;
            }
          }
          else if (!aoq.equals(aoq)) {
            return false;
          }
          if (aor != null) {
            break;
          }
        } while (aor == null);
        return false;
      } while (aor.equals(aor));
      return false;
    }
    
    public int hashCode()
    {
      int k = 0;
      int m = getClass().getName().hashCode();
      int i;
      int j;
      if (aoa == null)
      {
        i = 0;
        if (aoq != null) {
          break label72;
        }
        j = 0;
        label32:
        if (aor != null) {
          break label83;
        }
      }
      for (;;)
      {
        return (j + (i + (m + 527) * 31) * 31) * 31 + k;
        i = aoa.hashCode();
        break;
        label72:
        j = aoq.hashCode();
        break label32;
        label83:
        k = aor.hashCode();
      }
    }
    
    public void zza(zzaov paramzzaov)
      throws IOException
    {
      if (aoa != null) {
        paramzzaov.zzae(1, aoa.intValue());
      }
      if (aoq != null) {
        paramzzaov.zzr(2, aoq);
      }
      if (aor != null) {
        paramzzaov.zza(3, aor);
      }
      super.zza(paramzzaov);
    }
    
    public zze zzbh(zzaou paramzzaou)
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
        case 8: 
          aoa = Integer.valueOf(paramzzaou.N());
          break;
        case 18: 
          aoq = paramzzaou.readString();
          break;
        case 26: 
          if (aor == null) {
            aor = new zzun.zzc();
          }
          paramzzaou.zza(aor);
        }
      }
    }
    
    public zze zzbwh()
    {
      aoa = null;
      aoq = null;
      aor = null;
      bik = -1;
      return this;
    }
    
    protected int zzy()
    {
      int j = super.zzy();
      int i = j;
      if (aoa != null) {
        i = j + zzaov.zzag(1, aoa.intValue());
      }
      j = i;
      if (aoq != null) {
        j = i + zzaov.zzs(2, aoq);
      }
      i = j;
      if (aor != null) {
        i = j + zzaov.zzc(3, aor);
      }
      return i;
    }
  }
  
  public static final class zzf
    extends zzapc
  {
    public Integer aos;
    public String aot;
    public Boolean aou;
    public String[] aov;
    
    public zzf()
    {
      zzbwi();
    }
    
    public boolean equals(Object paramObject)
    {
      if (paramObject == this) {}
      do
      {
        return true;
        if (!(paramObject instanceof zzf)) {
          return false;
        }
        paramObject = (zzf)paramObject;
        if (aos == null)
        {
          if (aos != null) {
            return false;
          }
        }
        else if (!aos.equals(aos)) {
          return false;
        }
        if (aot == null)
        {
          if (aot != null) {
            return false;
          }
        }
        else if (!aot.equals(aot)) {
          return false;
        }
        if (aou == null)
        {
          if (aou != null) {
            return false;
          }
        }
        else if (!aou.equals(aou)) {
          return false;
        }
      } while (zzapa.equals(aov, aov));
      return false;
    }
    
    public int hashCode()
    {
      int k = 0;
      int m = getClass().getName().hashCode();
      int i;
      int j;
      if (aos == null)
      {
        i = 0;
        if (aot != null) {
          break label83;
        }
        j = 0;
        label32:
        if (aou != null) {
          break label94;
        }
      }
      for (;;)
      {
        return ((j + (i + (m + 527) * 31) * 31) * 31 + k) * 31 + zzapa.hashCode(aov);
        i = aos.intValue();
        break;
        label83:
        j = aot.hashCode();
        break label32;
        label94:
        k = aou.hashCode();
      }
    }
    
    public void zza(zzaov paramzzaov)
      throws IOException
    {
      if (aos != null) {
        paramzzaov.zzae(1, aos.intValue());
      }
      if (aot != null) {
        paramzzaov.zzr(2, aot);
      }
      if (aou != null) {
        paramzzaov.zzj(3, aou.booleanValue());
      }
      if ((aov != null) && (aov.length > 0))
      {
        int i = 0;
        while (i < aov.length)
        {
          String str = aov[i];
          if (str != null) {
            paramzzaov.zzr(4, str);
          }
          i += 1;
        }
      }
      super.zza(paramzzaov);
    }
    
    public zzf zzbi(zzaou paramzzaou)
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
        case 8: 
          i = paramzzaou.N();
          switch (i)
          {
          default: 
            break;
          case 0: 
          case 1: 
          case 2: 
          case 3: 
          case 4: 
          case 5: 
          case 6: 
            aos = Integer.valueOf(i);
          }
          break;
        case 18: 
          aot = paramzzaou.readString();
          break;
        case 24: 
          aou = Boolean.valueOf(paramzzaou.P());
          break;
        case 34: 
          int j = zzapf.zzc(paramzzaou, 34);
          if (aov == null) {}
          String[] arrayOfString;
          for (i = 0;; i = aov.length)
          {
            arrayOfString = new String[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(aov, 0, arrayOfString, 0, i);
              j = i;
            }
            while (j < arrayOfString.length - 1)
            {
              arrayOfString[j] = paramzzaou.readString();
              paramzzaou.J();
              j += 1;
            }
          }
          arrayOfString[j] = paramzzaou.readString();
          aov = arrayOfString;
        }
      }
    }
    
    public zzf zzbwi()
    {
      aot = null;
      aou = null;
      aov = zzapf.bir;
      bik = -1;
      return this;
    }
    
    protected int zzy()
    {
      int n = 0;
      int j = super.zzy();
      int i = j;
      if (aos != null) {
        i = j + zzaov.zzag(1, aos.intValue());
      }
      j = i;
      if (aot != null) {
        j = i + zzaov.zzs(2, aot);
      }
      i = j;
      if (aou != null) {
        i = j + zzaov.zzk(3, aou.booleanValue());
      }
      j = i;
      if (aov != null)
      {
        j = i;
        if (aov.length > 0)
        {
          int k = 0;
          int m = 0;
          j = n;
          while (j < aov.length)
          {
            String str = aov[j];
            int i1 = k;
            n = m;
            if (str != null)
            {
              n = m + 1;
              i1 = k + zzaov.zztg(str);
            }
            j += 1;
            k = i1;
            m = n;
          }
          j = i + k + m * 1;
        }
      }
      return j;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzun
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */