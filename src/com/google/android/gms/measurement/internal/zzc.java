package com.google.android.gms.measurement.internal;

import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.internal.zzun.zza;
import com.google.android.gms.internal.zzun.zzb;
import com.google.android.gms.internal.zzun.zzc;
import com.google.android.gms.internal.zzun.zzd;
import com.google.android.gms.internal.zzun.zze;
import com.google.android.gms.internal.zzup.zza;
import com.google.android.gms.internal.zzup.zzb;
import com.google.android.gms.internal.zzup.zzc;
import com.google.android.gms.internal.zzup.zzf;
import com.google.android.gms.internal.zzup.zzg;
import com.google.android.gms.measurement.AppMeasurement.zza;
import com.google.android.gms.measurement.AppMeasurement.zzd;
import com.google.android.gms.measurement.AppMeasurement.zze;
import java.util.Arrays;
import java.util.BitSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

class zzc
  extends zzaa
{
  zzc(zzx paramzzx)
  {
    super(paramzzx);
  }
  
  private Boolean zza(zzun.zzb paramzzb, zzup.zzb paramzzb1, long paramLong)
  {
    if (aoe != null)
    {
      localObject1 = new zzs(aoe).zzbj(paramLong);
      if (localObject1 == null) {
        return null;
      }
      if (!((Boolean)localObject1).booleanValue()) {
        return Boolean.valueOf(false);
      }
    }
    Object localObject2 = new HashSet();
    Object localObject1 = aoc;
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      localObject3 = localObject1[i];
      if (TextUtils.isEmpty(aoj))
      {
        zzbsz().zzbtt().zzj("null or empty param name in filter. event", name);
        return null;
      }
      ((Set)localObject2).add(aoj);
      i += 1;
    }
    localObject1 = new ArrayMap();
    Object localObject3 = aoK;
    j = localObject3.length;
    i = 0;
    Object localObject4;
    if (i < j)
    {
      localObject4 = localObject3[i];
      if (((Set)localObject2).contains(name))
      {
        if (aoO == null) {
          break label219;
        }
        ((Map)localObject1).put(name, aoO);
      }
      for (;;)
      {
        i += 1;
        break;
        label219:
        if (anT != null)
        {
          ((Map)localObject1).put(name, anT);
        }
        else
        {
          if (zr == null) {
            break label277;
          }
          ((Map)localObject1).put(name, zr);
        }
      }
      label277:
      zzbsz().zzbtt().zze("Unknown value for param. event, param", name, name);
      return null;
    }
    paramzzb = aoc;
    int k = paramzzb.length;
    i = 0;
    while (i < k)
    {
      localObject2 = paramzzb[i];
      int m = Boolean.TRUE.equals(aoi);
      localObject3 = aoj;
      if (TextUtils.isEmpty((CharSequence)localObject3))
      {
        zzbsz().zzbtt().zzj("Event has empty param name. event", name);
        return null;
      }
      localObject4 = ((Map)localObject1).get(localObject3);
      if ((localObject4 instanceof Long))
      {
        if (aoh == null)
        {
          zzbsz().zzbtt().zze("No number filter for long param. event, param", name, localObject3);
          return null;
        }
        localObject2 = new zzs(aoh).zzbj(((Long)localObject4).longValue());
        if (localObject2 == null) {
          return null;
        }
        if (!((Boolean)localObject2).booleanValue()) {}
        for (j = 1; (j ^ m) != 0; j = 0) {
          return Boolean.valueOf(false);
        }
      }
      if ((localObject4 instanceof Double))
      {
        if (aoh == null)
        {
          zzbsz().zzbtt().zze("No number filter for double param. event, param", name, localObject3);
          return null;
        }
        localObject2 = new zzs(aoh).zzj(((Double)localObject4).doubleValue());
        if (localObject2 == null) {
          return null;
        }
        if (!((Boolean)localObject2).booleanValue()) {}
        for (j = 1; (j ^ m) != 0; j = 0) {
          return Boolean.valueOf(false);
        }
      }
      if ((localObject4 instanceof String))
      {
        if (aog == null)
        {
          zzbsz().zzbtt().zze("No string filter for String param. event, param", name, localObject3);
          return null;
        }
        localObject2 = new zzag(aog).zzmj((String)localObject4);
        if (localObject2 == null) {
          return null;
        }
        if (!((Boolean)localObject2).booleanValue()) {}
        for (j = 1; (j ^ m) != 0; j = 0) {
          return Boolean.valueOf(false);
        }
      }
      if (localObject4 == null)
      {
        zzbsz().zzbty().zze("Missing param for filter. event, param", name, localObject3);
        return Boolean.valueOf(false);
      }
      zzbsz().zzbtt().zze("Unknown param type. event, param", name, localObject3);
      return null;
      i += 1;
    }
    return Boolean.valueOf(true);
  }
  
  private Boolean zza(zzun.zze paramzze, zzup.zzg paramzzg)
  {
    paramzze = aor;
    if (paramzze == null)
    {
      zzbsz().zzbtt().zzj("Missing property filter. property", name);
      return null;
    }
    boolean bool = Boolean.TRUE.equals(aoi);
    if (aoO != null)
    {
      if (aoh == null)
      {
        zzbsz().zzbtt().zzj("No number filter for long property. property", name);
        return null;
      }
      return zza(new zzs(aoh).zzbj(aoO.longValue()), bool);
    }
    if (anT != null)
    {
      if (aoh == null)
      {
        zzbsz().zzbtt().zzj("No number filter for double property. property", name);
        return null;
      }
      return zza(new zzs(aoh).zzj(anT.doubleValue()), bool);
    }
    if (zr != null)
    {
      if (aog == null)
      {
        if (aoh == null)
        {
          zzbsz().zzbtt().zzj("No string or number filter defined. property", name);
          return null;
        }
        zzs localzzs = new zzs(aoh);
        if ((aoh.aol == null) || (!aoh.aol.booleanValue()))
        {
          if (zzle(zr)) {
            try
            {
              paramzze = zza(localzzs.zzbj(Long.parseLong(zr)), bool);
              return paramzze;
            }
            catch (NumberFormatException paramzze)
            {
              zzbsz().zzbtt().zze("User property value exceeded Long value range. property, value", name, zr);
              return null;
            }
          }
          zzbsz().zzbtt().zze("Invalid user property value for Long number filter. property, value", name, zr);
          return null;
        }
        if (zzlf(zr)) {
          try
          {
            double d = Double.parseDouble(zr);
            if (!Double.isInfinite(d)) {
              return zza(localzzs.zzj(d), bool);
            }
            zzbsz().zzbtt().zze("User property value exceeded Double value range. property, value", name, zr);
            return null;
          }
          catch (NumberFormatException paramzze)
          {
            zzbsz().zzbtt().zze("User property value exceeded Double value range. property, value", name, zr);
            return null;
          }
        }
        zzbsz().zzbtt().zze("Invalid user property value for Double number filter. property, value", name, zr);
        return null;
      }
      return zza(new zzag(aog).zzmj(zr), bool);
    }
    zzbsz().zzbtt().zzj("User property has no value, property", name);
    return null;
  }
  
  static Boolean zza(Boolean paramBoolean, boolean paramBoolean1)
  {
    if (paramBoolean == null) {
      return null;
    }
    return Boolean.valueOf(paramBoolean.booleanValue() ^ paramBoolean1);
  }
  
  void zza(String paramString, zzun.zza[] paramArrayOfzza)
  {
    zzab.zzaa(paramArrayOfzza);
    int m = paramArrayOfzza.length;
    int i = 0;
    while (i < m)
    {
      Object localObject1 = paramArrayOfzza[i];
      zzun.zzb[] arrayOfzzb = anY;
      int n = arrayOfzzb.length;
      int j = 0;
      Object localObject2;
      while (j < n)
      {
        localObject2 = arrayOfzzb[j];
        String str1 = (String)AppMeasurement.zza.ajb.get(aob);
        if (str1 != null) {
          aob = str1;
        }
        localObject2 = aoc;
        int i1 = localObject2.length;
        k = 0;
        while (k < i1)
        {
          str1 = localObject2[k];
          String str2 = (String)AppMeasurement.zzd.ajc.get(aoj);
          if (str2 != null) {
            aoj = str2;
          }
          k += 1;
        }
        j += 1;
      }
      localObject1 = anX;
      int k = localObject1.length;
      j = 0;
      while (j < k)
      {
        arrayOfzzb = localObject1[j];
        localObject2 = (String)AppMeasurement.zze.ajd.get(aoq);
        if (localObject2 != null) {
          aoq = ((String)localObject2);
        }
        j += 1;
      }
      i += 1;
    }
    zzbsu().zzb(paramString, paramArrayOfzza);
  }
  
  zzup.zza[] zza(String paramString, zzup.zzb[] paramArrayOfzzb, zzup.zzg[] paramArrayOfzzg)
  {
    zzab.zzhs(paramString);
    HashSet localHashSet = new HashSet();
    ArrayMap localArrayMap1 = new ArrayMap();
    ArrayMap localArrayMap2 = new ArrayMap();
    ArrayMap localArrayMap3 = new ArrayMap();
    Object localObject4 = zzbsu().zzls(paramString);
    Object localObject5;
    int j;
    Object localObject6;
    Object localObject3;
    Object localObject2;
    Object localObject1;
    int i;
    if (localObject4 != null)
    {
      localObject5 = ((Map)localObject4).keySet().iterator();
      while (((Iterator)localObject5).hasNext())
      {
        j = ((Integer)((Iterator)localObject5).next()).intValue();
        localObject6 = (zzup.zzf)((Map)localObject4).get(Integer.valueOf(j));
        localObject3 = (BitSet)localArrayMap2.get(Integer.valueOf(j));
        localObject2 = (BitSet)localArrayMap3.get(Integer.valueOf(j));
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          localObject1 = new BitSet();
          localArrayMap2.put(Integer.valueOf(j), localObject1);
          localObject2 = new BitSet();
          localArrayMap3.put(Integer.valueOf(j), localObject2);
        }
        i = 0;
        while (i < apq.length * 64)
        {
          if (zzal.zza(apq, i))
          {
            zzbsz().zzbty().zze("Filter already evaluated. audience ID, filter ID", Integer.valueOf(j), Integer.valueOf(i));
            ((BitSet)localObject2).set(i);
            if (zzal.zza(apr, i)) {
              ((BitSet)localObject1).set(i);
            }
          }
          i += 1;
        }
        localObject3 = new zzup.zza();
        localArrayMap1.put(Integer.valueOf(j), localObject3);
        aoI = Boolean.valueOf(false);
        aoH = ((zzup.zzf)localObject6);
        aoG = new zzup.zzf();
        aoG.apr = zzal.zza((BitSet)localObject1);
        aoG.apq = zzal.zza((BitSet)localObject2);
      }
    }
    Object localObject7;
    long l;
    if (paramArrayOfzzb != null)
    {
      localObject6 = new ArrayMap();
      j = paramArrayOfzzb.length;
      i = 0;
      if (i < j)
      {
        localObject7 = paramArrayOfzzb[i];
        localObject1 = zzbsu().zzaq(paramString, name);
        if (localObject1 == null)
        {
          zzbsz().zzbtt().zzj("Event aggregate wasn't created during raw event logging. event", name);
          localObject1 = new zzi(paramString, name, 1L, 1L, aoL.longValue());
          zzbsu().zza((zzi)localObject1);
          l = ajZ;
          localObject1 = (Map)((Map)localObject6).get(name);
          if (localObject1 != null) {
            break label1969;
          }
          localObject2 = zzbsu().zzat(paramString, name);
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = new ArrayMap();
          }
          ((Map)localObject6).put(name, localObject1);
        }
      }
    }
    label1063:
    label1100:
    label1713:
    label1748:
    label1963:
    label1966:
    label1969:
    for (;;)
    {
      zzbsz().zzbty().zze("event, affected audience count", name, Integer.valueOf(((Map)localObject1).size()));
      Iterator localIterator = ((Map)localObject1).keySet().iterator();
      int k;
      Object localObject8;
      Object localObject9;
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label1100;
        }
        k = ((Integer)localIterator.next()).intValue();
        if (localHashSet.contains(Integer.valueOf(k)))
        {
          zzbsz().zzbty().zzj("Skipping failed audience ID", Integer.valueOf(k));
          continue;
          localObject1 = ((zzi)localObject1).zzbtn();
          break;
        }
        localObject4 = (zzup.zza)localArrayMap1.get(Integer.valueOf(k));
        localObject2 = (BitSet)localArrayMap2.get(Integer.valueOf(k));
        localObject3 = (BitSet)localArrayMap3.get(Integer.valueOf(k));
        if (localObject4 == null)
        {
          localObject2 = new zzup.zza();
          localArrayMap1.put(Integer.valueOf(k), localObject2);
          aoI = Boolean.valueOf(true);
          localObject2 = new BitSet();
          localArrayMap2.put(Integer.valueOf(k), localObject2);
          localObject3 = new BitSet();
          localArrayMap3.put(Integer.valueOf(k), localObject3);
        }
        localObject8 = ((List)((Map)localObject1).get(Integer.valueOf(k))).iterator();
        while (((Iterator)localObject8).hasNext())
        {
          localObject9 = (zzun.zzb)((Iterator)localObject8).next();
          if (zzbsz().zzaz(2))
          {
            zzbsz().zzbty().zzd("Evaluating filter. audience, filter, event", Integer.valueOf(k), aoa, aob);
            zzbsz().zzbty().zzj("Filter definition", zzal.zza((zzun.zzb)localObject9));
          }
          if ((aoa == null) || (aoa.intValue() > 256))
          {
            zzbsz().zzbtt().zzj("Invalid event filter ID. id", String.valueOf(aoa));
          }
          else if (((BitSet)localObject2).get(aoa.intValue()))
          {
            zzbsz().zzbty().zze("Event filter already evaluated true. audience ID, filter ID", Integer.valueOf(k), aoa);
          }
          else
          {
            localObject5 = zza((zzun.zzb)localObject9, (zzup.zzb)localObject7, l);
            zzp.zza localzza = zzbsz().zzbty();
            if (localObject5 == null) {}
            for (localObject4 = "null";; localObject4 = localObject5)
            {
              localzza.zzj("Event filter result", localObject4);
              if (localObject5 != null) {
                break label1063;
              }
              localHashSet.add(Integer.valueOf(k));
              break;
            }
            ((BitSet)localObject3).set(aoa.intValue());
            if (((Boolean)localObject5).booleanValue()) {
              ((BitSet)localObject2).set(aoa.intValue());
            }
          }
        }
      }
      i += 1;
      break;
      if (paramArrayOfzzg != null)
      {
        localObject5 = new ArrayMap();
        j = paramArrayOfzzg.length;
        i = 0;
        if (i < j)
        {
          localObject6 = paramArrayOfzzg[i];
          paramArrayOfzzb = (Map)((Map)localObject5).get(name);
          if (paramArrayOfzzb != null) {
            break label1966;
          }
          localObject1 = zzbsu().zzau(paramString, name);
          paramArrayOfzzb = (zzup.zzb[])localObject1;
          if (localObject1 == null) {
            paramArrayOfzzb = new ArrayMap();
          }
          ((Map)localObject5).put(name, paramArrayOfzzb);
        }
      }
      for (;;)
      {
        zzbsz().zzbty().zze("property, affected audience count", name, Integer.valueOf(paramArrayOfzzb.size()));
        localObject7 = paramArrayOfzzb.keySet().iterator();
        while (((Iterator)localObject7).hasNext())
        {
          k = ((Integer)((Iterator)localObject7).next()).intValue();
          if (localHashSet.contains(Integer.valueOf(k)))
          {
            zzbsz().zzbty().zzj("Skipping failed audience ID", Integer.valueOf(k));
          }
          else
          {
            localObject3 = (zzup.zza)localArrayMap1.get(Integer.valueOf(k));
            localObject1 = (BitSet)localArrayMap2.get(Integer.valueOf(k));
            localObject2 = (BitSet)localArrayMap3.get(Integer.valueOf(k));
            if (localObject3 == null)
            {
              localObject1 = new zzup.zza();
              localArrayMap1.put(Integer.valueOf(k), localObject1);
              aoI = Boolean.valueOf(true);
              localObject1 = new BitSet();
              localArrayMap2.put(Integer.valueOf(k), localObject1);
              localObject2 = new BitSet();
              localArrayMap3.put(Integer.valueOf(k), localObject2);
            }
            localIterator = ((List)paramArrayOfzzb.get(Integer.valueOf(k))).iterator();
            for (;;)
            {
              if (!localIterator.hasNext()) {
                break label1748;
              }
              localObject8 = (zzun.zze)localIterator.next();
              if (zzbsz().zzaz(2))
              {
                zzbsz().zzbty().zzd("Evaluating filter. audience, filter, property", Integer.valueOf(k), aoa, aoq);
                zzbsz().zzbty().zzj("Filter definition", zzal.zza((zzun.zze)localObject8));
              }
              if ((aoa == null) || (aoa.intValue() > 256))
              {
                zzbsz().zzbtt().zzj("Invalid property filter ID. id", String.valueOf(aoa));
                localHashSet.add(Integer.valueOf(k));
                break;
              }
              if (((BitSet)localObject1).get(aoa.intValue()))
              {
                zzbsz().zzbty().zze("Property filter already evaluated true. audience ID, filter ID", Integer.valueOf(k), aoa);
              }
              else
              {
                localObject4 = zza((zzun.zze)localObject8, (zzup.zzg)localObject6);
                localObject9 = zzbsz().zzbty();
                if (localObject4 == null) {}
                for (localObject3 = "null";; localObject3 = localObject4)
                {
                  ((zzp.zza)localObject9).zzj("Property filter result", localObject3);
                  if (localObject4 != null) {
                    break label1713;
                  }
                  localHashSet.add(Integer.valueOf(k));
                  break;
                }
                ((BitSet)localObject2).set(aoa.intValue());
                if (((Boolean)localObject4).booleanValue()) {
                  ((BitSet)localObject1).set(aoa.intValue());
                }
              }
            }
          }
        }
        i += 1;
        break;
        paramArrayOfzzg = new zzup.zza[localArrayMap2.size()];
        localObject1 = localArrayMap2.keySet().iterator();
        i = 0;
        while (((Iterator)localObject1).hasNext())
        {
          j = ((Integer)((Iterator)localObject1).next()).intValue();
          if (!localHashSet.contains(Integer.valueOf(j)))
          {
            paramArrayOfzzb = (zzup.zza)localArrayMap1.get(Integer.valueOf(j));
            if (paramArrayOfzzb != null) {
              break label1963;
            }
            paramArrayOfzzb = new zzup.zza();
          }
        }
        for (;;)
        {
          paramArrayOfzzg[i] = paramArrayOfzzb;
          anW = Integer.valueOf(j);
          aoG = new zzup.zzf();
          aoG.apr = zzal.zza((BitSet)localArrayMap2.get(Integer.valueOf(j)));
          aoG.apq = zzal.zza((BitSet)localArrayMap3.get(Integer.valueOf(j)));
          zzbsu().zza(paramString, j, aoG);
          i += 1;
          break;
          return (zzup.zza[])Arrays.copyOf(paramArrayOfzzg, i);
        }
      }
    }
  }
  
  boolean zzle(String paramString)
  {
    return Pattern.matches("[+-]?[0-9]+", paramString);
  }
  
  boolean zzlf(String paramString)
  {
    return Pattern.matches("[+-]?(([0-9]+\\.?)|([0-9]*\\.[0-9]+))", paramString);
  }
  
  protected void zzwv() {}
}

/* Location:
 * Qualified Name:     com.google.android.gms.measurement.internal.zzc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */