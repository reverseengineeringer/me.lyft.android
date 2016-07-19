package com.google.android.gms.internal;

import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.DataMap;
import java.util.ArrayList;
import java.util.List;

public final class zzaep
{
  private static int zza(String paramString, zzaeq.zza.zza[] paramArrayOfzza)
  {
    int m = paramArrayOfzza.length;
    int j = 0;
    int i = 14;
    if (j < m)
    {
      zzaeq.zza.zza localzza = paramArrayOfzza[j];
      int k;
      if (i == 14) {
        if ((type == 9) || (type == 2) || (type == 6)) {
          k = type;
        }
      }
      do
      {
        do
        {
          j += 1;
          i = k;
          break;
          k = i;
        } while (type == 14);
        i = type;
        throw new IllegalArgumentException(String.valueOf(paramString).length() + 48 + "Unexpected TypedValue type: " + i + " for key " + paramString);
        k = i;
      } while (type == i);
      j = type;
      throw new IllegalArgumentException(String.valueOf(paramString).length() + 126 + "The ArrayList elements should all be the same type, but ArrayList with key " + paramString + " contains items of type " + i + " and " + j);
    }
    return i;
  }
  
  public static DataMap zza(zza paramzza)
  {
    DataMap localDataMap = new DataMap();
    zzaeq.zza[] arrayOfzza = aLB.aLD;
    int j = arrayOfzza.length;
    int i = 0;
    while (i < j)
    {
      zzaeq.zza localzza = arrayOfzza[i];
      zza(aLC, localDataMap, name, aLF);
      i += 1;
    }
    return localDataMap;
  }
  
  private static ArrayList zza(List<Asset> paramList, zzaeq.zza.zza.zza paramzza, int paramInt)
  {
    ArrayList localArrayList = new ArrayList(aLR.length);
    paramzza = aLR;
    int k = paramzza.length;
    int i = 0;
    if (i < k)
    {
      zzaeq.zza[] arrayOfzza = paramzza[i];
      if (type == 14) {
        localArrayList.add(null);
      }
      for (;;)
      {
        i += 1;
        break;
        if (paramInt == 9)
        {
          DataMap localDataMap = new DataMap();
          arrayOfzza = aLH.aLQ;
          int m = arrayOfzza.length;
          int j = 0;
          while (j < m)
          {
            zzaeq.zza localzza = arrayOfzza[j];
            zza(paramList, localDataMap, name, aLF);
            j += 1;
          }
          localArrayList.add(localDataMap);
        }
        else if (paramInt == 2)
        {
          localArrayList.add(aLH.aLJ);
        }
        else
        {
          if (paramInt != 6) {
            break label191;
          }
          localArrayList.add(Integer.valueOf(aLH.aLN));
        }
      }
      label191:
      throw new IllegalArgumentException(39 + "Unexpected typeOfArrayList: " + paramInt);
    }
    return localArrayList;
  }
  
  private static void zza(List<Asset> paramList, DataMap paramDataMap, String paramString, zzaeq.zza.zza paramzza)
  {
    int i = type;
    if (i == 14)
    {
      paramDataMap.putString(paramString, null);
      return;
    }
    Object localObject1 = aLH;
    if (i == 1)
    {
      paramDataMap.putByteArray(paramString, aLI);
      return;
    }
    if (i == 11)
    {
      paramDataMap.putStringArray(paramString, aLS);
      return;
    }
    if (i == 12)
    {
      paramDataMap.putLongArray(paramString, aLT);
      return;
    }
    if (i == 15)
    {
      paramDataMap.putFloatArray(paramString, aLU);
      return;
    }
    if (i == 2)
    {
      paramDataMap.putString(paramString, aLJ);
      return;
    }
    if (i == 3)
    {
      paramDataMap.putDouble(paramString, aLK);
      return;
    }
    if (i == 4)
    {
      paramDataMap.putFloat(paramString, aLL);
      return;
    }
    if (i == 5)
    {
      paramDataMap.putLong(paramString, aLM);
      return;
    }
    if (i == 6)
    {
      paramDataMap.putInt(paramString, aLN);
      return;
    }
    if (i == 7)
    {
      paramDataMap.putByte(paramString, (byte)aLO);
      return;
    }
    if (i == 8)
    {
      paramDataMap.putBoolean(paramString, aLP);
      return;
    }
    if (i == 13)
    {
      if (paramList == null)
      {
        paramList = String.valueOf(paramString);
        if (paramList.length() != 0) {}
        for (paramList = "populateBundle: unexpected type for: ".concat(paramList);; paramList = new String("populateBundle: unexpected type for: ")) {
          throw new RuntimeException(paramList);
        }
      }
      paramDataMap.putAsset(paramString, (Asset)paramList.get((int)aLV));
      return;
    }
    if (i == 9)
    {
      paramzza = new DataMap();
      localObject1 = aLQ;
      int j = localObject1.length;
      i = 0;
      while (i < j)
      {
        Object localObject2 = localObject1[i];
        zza(paramList, paramzza, name, aLF);
        i += 1;
      }
      paramDataMap.putDataMap(paramString, paramzza);
      return;
    }
    if (i == 10)
    {
      i = zza(paramString, aLR);
      paramList = zza(paramList, (zzaeq.zza.zza.zza)localObject1, i);
      if (i == 14)
      {
        paramDataMap.putStringArrayList(paramString, paramList);
        return;
      }
      if (i == 9)
      {
        paramDataMap.putDataMapArrayList(paramString, paramList);
        return;
      }
      if (i == 2)
      {
        paramDataMap.putStringArrayList(paramString, paramList);
        return;
      }
      if (i == 6)
      {
        paramDataMap.putIntegerArrayList(paramString, paramList);
        return;
      }
      throw new IllegalStateException(39 + "Unexpected typeOfArrayList: " + i);
    }
    throw new RuntimeException(43 + "populateBundle: unexpected type " + i);
  }
  
  public static class zza
  {
    public final zzaeq aLB;
    public final List<Asset> aLC;
    
    public zza(zzaeq paramzzaeq, List<Asset> paramList)
    {
      aLB = paramzzaeq;
      aLC = paramList;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzaep
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */