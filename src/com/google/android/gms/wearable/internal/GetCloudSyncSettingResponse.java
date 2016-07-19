package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public class GetCloudSyncSettingResponse
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<GetCloudSyncSettingResponse> CREATOR = new zzan();
  public final boolean enabled;
  public final int statusCode;
  public final int versionCode;
  
  GetCloudSyncSettingResponse(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    versionCode = paramInt1;
    statusCode = paramInt2;
    enabled = paramBoolean;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzan.zza(this, paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wearable.internal.GetCloudSyncSettingResponse
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */