package com.google.android.gms.location;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzaa;

public final class LocationAvailability
  extends AbstractSafeParcelable
{
  public static final LocationAvailabilityCreator CREATOR = new LocationAvailabilityCreator();
  int acZ;
  int ada;
  long adb;
  int adc;
  private final int mVersionCode;
  
  LocationAvailability(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong)
  {
    mVersionCode = paramInt1;
    adc = paramInt2;
    acZ = paramInt3;
    ada = paramInt4;
    adb = paramLong;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof LocationAvailability)) {}
    do
    {
      return false;
      paramObject = (LocationAvailability)paramObject;
    } while ((adc != adc) || (acZ != acZ) || (ada != ada) || (adb != adb));
    return true;
  }
  
  int getVersionCode()
  {
    return mVersionCode;
  }
  
  public int hashCode()
  {
    return zzaa.hashCode(new Object[] { Integer.valueOf(adc), Integer.valueOf(acZ), Integer.valueOf(ada), Long.valueOf(adb) });
  }
  
  public boolean isLocationAvailable()
  {
    return adc < 1000;
  }
  
  public String toString()
  {
    boolean bool = isLocationAvailable();
    return 48 + "LocationAvailability[isLocationAvailable: " + bool + "]";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    LocationAvailabilityCreator.zza(this, paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.LocationAvailability
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */