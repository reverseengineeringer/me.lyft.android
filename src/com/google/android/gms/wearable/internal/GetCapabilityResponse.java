package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public class GetCapabilityResponse
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<GetCapabilityResponse> CREATOR = new zzai();
  public final CapabilityInfoParcelable aKE;
  public final int statusCode;
  public final int versionCode;
  
  GetCapabilityResponse(int paramInt1, int paramInt2, CapabilityInfoParcelable paramCapabilityInfoParcelable)
  {
    versionCode = paramInt1;
    statusCode = paramInt2;
    aKE = paramCapabilityInfoParcelable;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzai.zza(this, paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wearable.internal.GetCapabilityResponse
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */