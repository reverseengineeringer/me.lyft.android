package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.internal.zzun.zzd;

class zzs
{
  final boolean alk;
  final int all;
  long alm;
  double aln;
  long alo;
  double alp;
  long alq;
  double alr;
  final boolean als;
  
  public zzs(zzun.zzd paramzzd)
  {
    zzab.zzaa(paramzzd);
    boolean bool1;
    if ((aok == null) || (aok.intValue() == 0)) {
      bool1 = false;
    }
    for (;;)
    {
      if (bool1)
      {
        all = aok.intValue();
        if ((aol != null) && (aol.booleanValue()))
        {
          label62:
          alk = bool2;
          if (aok.intValue() != 4) {
            break label185;
          }
          if (!alk) {
            break label160;
          }
          alp = Double.parseDouble(aon);
          alr = Double.parseDouble(aoo);
        }
      }
      for (;;)
      {
        als = bool1;
        return;
        if (aok.intValue() != 4)
        {
          if (aom != null) {
            break label233;
          }
          bool1 = false;
          break;
        }
        if ((aon != null) && (aoo != null)) {
          break label233;
        }
        bool1 = false;
        break;
        bool2 = false;
        break label62;
        label160:
        alo = Long.parseLong(aon);
        alq = Long.parseLong(aoo);
        continue;
        label185:
        if (alk)
        {
          aln = Double.parseDouble(aom);
        }
        else
        {
          alm = Long.parseLong(aom);
          continue;
          all = 0;
          alk = false;
        }
      }
      label233:
      bool1 = true;
    }
  }
  
  public Boolean zzbj(long paramLong)
  {
    boolean bool2 = true;
    boolean bool3 = true;
    boolean bool4 = true;
    boolean bool1 = true;
    if (!als) {
      return null;
    }
    if (alk) {
      return null;
    }
    switch (all)
    {
    default: 
      return null;
    case 1: 
      if (paramLong < alm) {}
      for (;;)
      {
        return Boolean.valueOf(bool1);
        bool1 = false;
      }
    case 2: 
      if (paramLong > alm) {}
      for (bool1 = bool2;; bool1 = false) {
        return Boolean.valueOf(bool1);
      }
    case 3: 
      if (paramLong == alm) {}
      for (bool1 = bool3;; bool1 = false) {
        return Boolean.valueOf(bool1);
      }
    }
    if ((paramLong >= alo) && (paramLong <= alq)) {}
    for (bool1 = bool4;; bool1 = false) {
      return Boolean.valueOf(bool1);
    }
  }
  
  public Boolean zzj(double paramDouble)
  {
    boolean bool3 = true;
    boolean bool4 = true;
    boolean bool1 = true;
    boolean bool2 = false;
    if (!als) {
      return null;
    }
    if (!alk) {
      return null;
    }
    switch (all)
    {
    default: 
      return null;
    case 1: 
      if (paramDouble < aln) {}
      for (;;)
      {
        return Boolean.valueOf(bool1);
        bool1 = false;
      }
    case 2: 
      if (paramDouble > aln) {}
      for (bool1 = bool3;; bool1 = false) {
        return Boolean.valueOf(bool1);
      }
    case 3: 
      if (paramDouble != aln)
      {
        bool1 = bool2;
        if (Math.abs(paramDouble - aln) >= 2.0D * Math.max(Math.ulp(paramDouble), Math.ulp(aln))) {}
      }
      else
      {
        bool1 = true;
      }
      return Boolean.valueOf(bool1);
    }
    if ((paramDouble >= alp) && (paramDouble <= alr)) {}
    for (bool1 = bool4;; bool1 = false) {
      return Boolean.valueOf(bool1);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.measurement.internal.zzs
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */