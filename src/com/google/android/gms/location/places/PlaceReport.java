package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzaa.zza;
import com.google.android.gms.common.internal.zzab;

public class PlaceReport
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<PlaceReport> CREATOR = new zzj();
  private final String aeL;
  private final String mTag;
  final int mVersionCode;
  private final String zzcus;
  
  PlaceReport(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    mVersionCode = paramInt;
    aeL = paramString1;
    mTag = paramString2;
    zzcus = paramString3;
  }
  
  public static PlaceReport create(String paramString1, String paramString2)
  {
    return zzk(paramString1, paramString2, "unknown");
  }
  
  public static PlaceReport zzk(String paramString1, String paramString2, String paramString3)
  {
    zzab.zzaa(paramString1);
    zzab.zzhs(paramString2);
    zzab.zzhs(paramString3);
    zzab.zzb(zzkq(paramString3), "Invalid source");
    return new PlaceReport(1, paramString1, paramString2, paramString3);
  }
  
  private static boolean zzkq(String paramString)
  {
    boolean bool = true;
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        bool = false;
      }
      return bool;
      if (paramString.equals("unknown"))
      {
        i = 0;
        continue;
        if (paramString.equals("userReported"))
        {
          i = 1;
          continue;
          if (paramString.equals("inferredGeofencing"))
          {
            i = 2;
            continue;
            if (paramString.equals("inferredRadioSignals"))
            {
              i = 3;
              continue;
              if (paramString.equals("inferredReverseGeocoding"))
              {
                i = 4;
                continue;
                if (paramString.equals("inferredSnappedToRoad")) {
                  i = 5;
                }
              }
            }
          }
        }
      }
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof PlaceReport)) {}
    do
    {
      return false;
      paramObject = (PlaceReport)paramObject;
    } while ((!zzaa.equal(aeL, aeL)) || (!zzaa.equal(mTag, mTag)) || (!zzaa.equal(zzcus, zzcus)));
    return true;
  }
  
  public String getPlaceId()
  {
    return aeL;
  }
  
  public String getSource()
  {
    return zzcus;
  }
  
  public String getTag()
  {
    return mTag;
  }
  
  public int hashCode()
  {
    return zzaa.hashCode(new Object[] { aeL, mTag, zzcus });
  }
  
  public String toString()
  {
    zzaa.zza localzza = zzaa.zzz(this);
    localzza.zzg("placeId", aeL);
    localzza.zzg("tag", mTag);
    if (!"unknown".equals(zzcus)) {
      localzza.zzg("source", zzcus);
    }
    return localzza.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzj.zza(this, paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.places.PlaceReport
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */