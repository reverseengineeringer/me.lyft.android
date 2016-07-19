package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public class GetFdForAssetResponse
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<GetFdForAssetResponse> CREATOR = new zzas();
  public final ParcelFileDescriptor aKN;
  public final int statusCode;
  public final int versionCode;
  
  GetFdForAssetResponse(int paramInt1, int paramInt2, ParcelFileDescriptor paramParcelFileDescriptor)
  {
    versionCode = paramInt1;
    statusCode = paramInt2;
    aKN = paramParcelFileDescriptor;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzas.zza(this, paramParcel, paramInt | 0x1);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wearable.internal.GetFdForAssetResponse
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */