package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public class DeleteDataItemsResponse
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<DeleteDataItemsResponse> CREATOR = new zzag();
  public final int aKC;
  public final int statusCode;
  public final int versionCode;
  
  DeleteDataItemsResponse(int paramInt1, int paramInt2, int paramInt3)
  {
    versionCode = paramInt1;
    statusCode = paramInt2;
    aKC = paramInt3;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzag.zza(this, paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wearable.internal.DeleteDataItemsResponse
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */