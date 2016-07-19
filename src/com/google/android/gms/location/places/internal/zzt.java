package com.google.android.gms.location.places.internal;

import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzafb;
import com.google.android.gms.internal.zzapb;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class zzt
  extends com.google.android.gms.common.data.zzc
{
  private final String TAG = "SafeDataBufferRef";
  
  public zzt(DataHolder paramDataHolder, int paramInt)
  {
    super(paramDataHolder, paramInt);
  }
  
  protected <E extends SafeParcelable> E zza(String paramString, Parcelable.Creator<E> paramCreator)
  {
    paramString = zzc(paramString, null);
    if (paramString == null) {
      return null;
    }
    return com.google.android.gms.common.internal.safeparcel.zzc.zza(paramString, paramCreator);
  }
  
  protected <E extends SafeParcelable> List<E> zza(String paramString, Parcelable.Creator<E> paramCreator, List<E> paramList)
  {
    paramString = zzc(paramString, null);
    if (paramString == null) {}
    do
    {
      for (;;)
      {
        return paramList;
        try
        {
          Object localObject = zzafb.zzas(paramString);
          if (aMK != null)
          {
            paramString = new ArrayList(aMK.length);
            localObject = aMK;
            int j = localObject.length;
            int i = 0;
            while (i < j)
            {
              paramString.add(com.google.android.gms.common.internal.safeparcel.zzc.zza(localObject[i], paramCreator));
              i += 1;
            }
            return paramString;
          }
        }
        catch (zzapb paramString) {}
      }
    } while (!Log.isLoggable("SafeDataBufferRef", 6));
    Log.e("SafeDataBufferRef", "Cannot parse byte[]", paramString);
    return paramList;
  }
  
  protected List<Integer> zza(String paramString, List<Integer> paramList)
  {
    paramString = zzc(paramString, null);
    if (paramString == null) {}
    do
    {
      for (;;)
      {
        return paramList;
        try
        {
          paramString = zzafb.zzas(paramString);
          if (aMJ != null)
          {
            ArrayList localArrayList = new ArrayList(aMJ.length);
            int i = 0;
            while (i < aMJ.length)
            {
              localArrayList.add(Integer.valueOf(aMJ[i]));
              i += 1;
            }
            return localArrayList;
          }
        }
        catch (zzapb paramString) {}
      }
    } while (!Log.isLoggable("SafeDataBufferRef", 6));
    Log.e("SafeDataBufferRef", "Cannot parse byte[]", paramString);
    return paramList;
  }
  
  protected String zzao(String paramString1, String paramString2)
  {
    String str = paramString2;
    if (zzhf(paramString1))
    {
      str = paramString2;
      if (!zzhh(paramString1)) {
        str = getString(paramString1);
      }
    }
    return str;
  }
  
  protected float zzb(String paramString, float paramFloat)
  {
    float f = paramFloat;
    if (zzhf(paramString))
    {
      f = paramFloat;
      if (!zzhh(paramString)) {
        f = getFloat(paramString);
      }
    }
    return f;
  }
  
  protected List<String> zzb(String paramString, List<String> paramList)
  {
    paramString = zzc(paramString, null);
    if (paramString == null) {}
    do
    {
      for (;;)
      {
        return paramList;
        try
        {
          paramString = zzafb.zzas(paramString);
          if (aMI != null)
          {
            paramString = Arrays.asList(aMI);
            return paramString;
          }
        }
        catch (zzapb paramString) {}
      }
    } while (!Log.isLoggable("SafeDataBufferRef", 6));
    Log.e("SafeDataBufferRef", "Cannot parse byte[]", paramString);
    return paramList;
  }
  
  protected byte[] zzc(String paramString, byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = paramArrayOfByte;
    if (zzhf(paramString))
    {
      arrayOfByte = paramArrayOfByte;
      if (!zzhh(paramString)) {
        arrayOfByte = getByteArray(paramString);
      }
    }
    return arrayOfByte;
  }
  
  protected boolean zzn(String paramString, boolean paramBoolean)
  {
    boolean bool = paramBoolean;
    if (zzhf(paramString))
    {
      bool = paramBoolean;
      if (!zzhh(paramString)) {
        bool = getBoolean(paramString);
      }
    }
    return bool;
  }
  
  protected int zzx(String paramString, int paramInt)
  {
    int i = paramInt;
    if (zzhf(paramString))
    {
      i = paramInt;
      if (!zzhh(paramString)) {
        i = getInteger(paramString);
      }
    }
    return i;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.places.internal.zzt
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */