package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public class ChannelReceiveFileResponse
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<ChannelReceiveFileResponse> CREATOR = new zzr();
  public final int statusCode;
  public final int versionCode;
  
  ChannelReceiveFileResponse(int paramInt1, int paramInt2)
  {
    versionCode = paramInt1;
    statusCode = paramInt2;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzr.zza(this, paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wearable.internal.ChannelReceiveFileResponse
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */