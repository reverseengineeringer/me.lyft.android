package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class PointOfInterest
  implements SafeParcelable
{
  public static final zzg CREATOR = new zzg();
  public final LatLng aiL;
  public final String aiM;
  private final int mVersionCode;
  public final String name;
  
  PointOfInterest(int paramInt, LatLng paramLatLng, String paramString1, String paramString2)
  {
    mVersionCode = paramInt;
    aiL = paramLatLng;
    aiM = paramString1;
    name = paramString2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  int getVersionCode()
  {
    return mVersionCode;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzg.zza(this, paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.maps.model.PointOfInterest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */