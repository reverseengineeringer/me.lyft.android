package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.internal.zzun.zzf;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class zzag
{
  final boolean als;
  final int anL;
  final boolean anM;
  final String anN;
  final List<String> anO;
  final String anP;
  
  public zzag(zzun.zzf paramzzf)
  {
    zzab.zzaa(paramzzf);
    boolean bool1;
    if ((aos == null) || (aos.intValue() == 0)) {
      bool1 = false;
    }
    for (;;)
    {
      if (bool1)
      {
        anL = aos.intValue();
        boolean bool2 = bool3;
        if (aou != null)
        {
          bool2 = bool3;
          if (aou.booleanValue()) {
            bool2 = true;
          }
        }
        anM = bool2;
        if ((anM) || (anL == 1) || (anL == 6))
        {
          anN = aot;
          label108:
          if (aov != null) {
            break label205;
          }
          paramzzf = null;
          label117:
          anO = paramzzf;
          if (anL != 1) {
            break label221;
          }
          anP = anN;
        }
      }
      for (;;)
      {
        als = bool1;
        return;
        if (aos.intValue() == 6)
        {
          if ((aov != null) && (aov.length != 0)) {
            break label257;
          }
          bool1 = false;
          break;
        }
        if (aot != null) {
          break label257;
        }
        bool1 = false;
        break;
        anN = aot.toUpperCase(Locale.ENGLISH);
        break label108;
        label205:
        paramzzf = zza(aov, anM);
        break label117;
        label221:
        anP = null;
        continue;
        anL = 0;
        anM = false;
        anN = null;
        anO = null;
        anP = null;
      }
      label257:
      bool1 = true;
    }
  }
  
  private List<String> zza(String[] paramArrayOfString, boolean paramBoolean)
  {
    Object localObject;
    if (paramBoolean)
    {
      localObject = Arrays.asList(paramArrayOfString);
      return (List<String>)localObject;
    }
    ArrayList localArrayList = new ArrayList();
    int j = paramArrayOfString.length;
    int i = 0;
    for (;;)
    {
      localObject = localArrayList;
      if (i >= j) {
        break;
      }
      localArrayList.add(paramArrayOfString[i].toUpperCase(Locale.ENGLISH));
      i += 1;
    }
  }
  
  public Boolean zzmj(String paramString)
  {
    if (!als) {}
    while (paramString == null) {
      return null;
    }
    String str = paramString;
    if (!anM)
    {
      if (anL != 1) {
        break label106;
      }
      str = paramString;
    }
    switch (anL)
    {
    default: 
      return null;
    case 1: 
      if (anM) {}
      for (int i = 0;; i = 66)
      {
        return Boolean.valueOf(Pattern.compile(anP, i).matcher(str).matches());
        str = paramString.toUpperCase(Locale.ENGLISH);
        break;
      }
    case 2: 
      return Boolean.valueOf(str.startsWith(anN));
    case 3: 
      return Boolean.valueOf(str.endsWith(anN));
    case 4: 
      return Boolean.valueOf(str.contains(anN));
    case 5: 
      label106:
      return Boolean.valueOf(str.equals(anN));
    }
    return Boolean.valueOf(anO.contains(str));
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.measurement.internal.zzag
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */