package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public final class LocationSettingsStates
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<LocationSettingsStates> CREATOR = new zzi();
  private final boolean ado;
  private final boolean adp;
  private final boolean adq;
  private final boolean adr;
  private final boolean ads;
  private final boolean adt;
  private final int mVersionCode;
  
  LocationSettingsStates(int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6)
  {
    mVersionCode = paramInt;
    ado = paramBoolean1;
    adp = paramBoolean2;
    adq = paramBoolean3;
    adr = paramBoolean4;
    ads = paramBoolean5;
    adt = paramBoolean6;
  }
  
  public int getVersionCode()
  {
    return mVersionCode;
  }
  
  public boolean isBlePresent()
  {
    return adt;
  }
  
  public boolean isBleUsable()
  {
    return adq;
  }
  
  public boolean isGpsPresent()
  {
    return adr;
  }
  
  public boolean isGpsUsable()
  {
    return ado;
  }
  
  public boolean isNetworkLocationPresent()
  {
    return ads;
  }
  
  public boolean isNetworkLocationUsable()
  {
    return adp;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzi.zza(this, paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.LocationSettingsStates
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */