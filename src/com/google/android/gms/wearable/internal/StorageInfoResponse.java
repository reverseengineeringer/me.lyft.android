package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.List;

public class StorageInfoResponse
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<StorageInfoResponse> CREATOR = new zzbl();
  public final long aLc;
  public final List<PackageStorageInfo> aLe;
  public final int statusCode;
  public final int versionCode;
  
  StorageInfoResponse(int paramInt1, int paramInt2, long paramLong, List<PackageStorageInfo> paramList)
  {
    versionCode = paramInt1;
    statusCode = paramInt2;
    aLc = paramLong;
    aLe = paramList;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzbl.zza(this, paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wearable.internal.StorageInfoResponse
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */