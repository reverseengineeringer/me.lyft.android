package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzaa.zza;

public final class VisibleRegion
  implements SafeParcelable
{
  public static final zzp CREATOR = new zzp();
  public final LatLng farLeft;
  public final LatLng farRight;
  public final LatLngBounds latLngBounds;
  private final int mVersionCode;
  public final LatLng nearLeft;
  public final LatLng nearRight;
  
  VisibleRegion(int paramInt, LatLng paramLatLng1, LatLng paramLatLng2, LatLng paramLatLng3, LatLng paramLatLng4, LatLngBounds paramLatLngBounds)
  {
    mVersionCode = paramInt;
    nearLeft = paramLatLng1;
    nearRight = paramLatLng2;
    farLeft = paramLatLng3;
    farRight = paramLatLng4;
    latLngBounds = paramLatLngBounds;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof VisibleRegion)) {
        return false;
      }
      paramObject = (VisibleRegion)paramObject;
    } while ((nearLeft.equals(nearLeft)) && (nearRight.equals(nearRight)) && (farLeft.equals(farLeft)) && (farRight.equals(farRight)) && (latLngBounds.equals(latLngBounds)));
    return false;
  }
  
  int getVersionCode()
  {
    return mVersionCode;
  }
  
  public int hashCode()
  {
    return zzaa.hashCode(new Object[] { nearLeft, nearRight, farLeft, farRight, latLngBounds });
  }
  
  public String toString()
  {
    return zzaa.zzz(this).zzg("nearLeft", nearLeft).zzg("nearRight", nearRight).zzg("farLeft", farLeft).zzg("farRight", farRight).zzg("latLngBounds", latLngBounds).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzp.zza(this, paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.maps.model.VisibleRegion
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */