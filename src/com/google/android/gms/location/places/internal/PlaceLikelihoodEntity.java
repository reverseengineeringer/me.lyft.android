package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzaa.zza;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.PlaceLikelihood;

public class PlaceLikelihoodEntity
  extends AbstractSafeParcelable
  implements PlaceLikelihood
{
  public static final Parcelable.Creator<PlaceLikelihoodEntity> CREATOR = new zzm();
  final PlaceEntity afS;
  final float afT;
  final int mVersionCode;
  
  PlaceLikelihoodEntity(int paramInt, PlaceEntity paramPlaceEntity, float paramFloat)
  {
    mVersionCode = paramInt;
    afS = paramPlaceEntity;
    afT = paramFloat;
  }
  
  public static PlaceLikelihoodEntity zza(PlaceEntity paramPlaceEntity, float paramFloat)
  {
    return new PlaceLikelihoodEntity(0, (PlaceEntity)zzab.zzaa(paramPlaceEntity), paramFloat);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof PlaceLikelihoodEntity)) {
        return false;
      }
      paramObject = (PlaceLikelihoodEntity)paramObject;
    } while ((afS.equals(afS)) && (afT == afT));
    return false;
  }
  
  public Place getPlace()
  {
    return afS;
  }
  
  public int hashCode()
  {
    return zzaa.hashCode(new Object[] { afS, Float.valueOf(afT) });
  }
  
  public String toString()
  {
    return zzaa.zzz(this).zzg("place", afS).zzg("likelihood", Float.valueOf(afT)).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzm.zza(this, paramParcel, paramInt);
  }
  
  public PlaceLikelihood zzbox()
  {
    return this;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.places.internal.PlaceLikelihoodEntity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */