package com.google.android.gms.location.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.location.LocationRequest;
import java.util.Collections;
import java.util.List;

public class LocationRequestInternal
  extends AbstractSafeParcelable
{
  public static final zzm CREATOR = new zzm();
  static final List<ClientIdentity> adT = ;
  LocationRequest PM;
  boolean acu;
  List<ClientIdentity> adU;
  boolean adV;
  boolean adW;
  String mTag;
  private final int mVersionCode;
  
  LocationRequestInternal(int paramInt, LocationRequest paramLocationRequest, boolean paramBoolean1, List<ClientIdentity> paramList, String paramString, boolean paramBoolean2, boolean paramBoolean3)
  {
    mVersionCode = paramInt;
    PM = paramLocationRequest;
    acu = paramBoolean1;
    adU = paramList;
    mTag = paramString;
    adV = paramBoolean2;
    adW = paramBoolean3;
  }
  
  public static LocationRequestInternal zza(String paramString, LocationRequest paramLocationRequest)
  {
    return new LocationRequestInternal(1, paramLocationRequest, true, adT, paramString, false, false);
  }
  
  @Deprecated
  public static LocationRequestInternal zzb(LocationRequest paramLocationRequest)
  {
    return zza(null, paramLocationRequest);
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof LocationRequestInternal)) {}
    do
    {
      return false;
      paramObject = (LocationRequestInternal)paramObject;
    } while ((!zzaa.equal(PM, PM)) || (acu != acu) || (adV != adV) || (!zzaa.equal(adU, adU)) || (adW != adW));
    return true;
  }
  
  int getVersionCode()
  {
    return mVersionCode;
  }
  
  public int hashCode()
  {
    return PM.hashCode();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(PM.toString());
    if (mTag != null) {
      localStringBuilder.append(" tag=").append(mTag);
    }
    localStringBuilder.append(" trigger=").append(acu);
    localStringBuilder.append(" hideAppOps=").append(adV);
    localStringBuilder.append(" clients=").append(adU);
    localStringBuilder.append(" forceCoarseLocation=").append(adW);
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzm.zza(this, paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.internal.LocationRequestInternal
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */