package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public class GetCloudSyncOptInStatusResponse
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<GetCloudSyncOptInStatusResponse> CREATOR = new zzam();
  public final boolean aKH;
  public final boolean aKI;
  public final int statusCode;
  public final int versionCode;
  
  GetCloudSyncOptInStatusResponse(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    versionCode = paramInt1;
    statusCode = paramInt2;
    aKH = paramBoolean1;
    aKI = paramBoolean2;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzam.zza(this, paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wearable.internal.GetCloudSyncOptInStatusResponse
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */