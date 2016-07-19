package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public class PutDataResponse
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<PutDataResponse> CREATOR = new zzbf();
  public final DataItemParcelable aKM;
  public final int statusCode;
  public final int versionCode;
  
  PutDataResponse(int paramInt1, int paramInt2, DataItemParcelable paramDataItemParcelable)
  {
    versionCode = paramInt1;
    statusCode = paramInt2;
    aKM = paramDataItemParcelable;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzbf.zza(this, paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wearable.internal.PutDataResponse
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */