package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.List;

public class GetAllCapabilitiesResponse
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<GetAllCapabilitiesResponse> CREATOR = new zzah();
  public final List<CapabilityInfoParcelable> aKD;
  public final int statusCode;
  public final int versionCode;
  
  GetAllCapabilitiesResponse(int paramInt1, int paramInt2, List<CapabilityInfoParcelable> paramList)
  {
    versionCode = paramInt1;
    statusCode = paramInt2;
    aKD = paramList;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzah.zza(this, paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wearable.internal.GetAllCapabilitiesResponse
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */