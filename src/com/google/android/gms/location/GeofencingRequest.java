package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.location.internal.ParcelableGeofence;
import java.util.List;

public class GeofencingRequest
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<GeofencingRequest> CREATOR = new zzb();
  private final List<ParcelableGeofence> acS;
  private final int acT;
  private final int mVersionCode;
  
  GeofencingRequest(int paramInt1, List<ParcelableGeofence> paramList, int paramInt2)
  {
    mVersionCode = paramInt1;
    acS = paramList;
    acT = paramInt2;
  }
  
  public int getInitialTrigger()
  {
    return acT;
  }
  
  public int getVersionCode()
  {
    return mVersionCode;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzb.zza(this, paramParcel, paramInt);
  }
  
  public List<ParcelableGeofence> zzbnf()
  {
    return acS;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.GeofencingRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */