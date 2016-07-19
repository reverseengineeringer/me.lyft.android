package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.wearable.ConnectionConfiguration;

@Deprecated
public class GetConfigResponse
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<GetConfigResponse> CREATOR = new zzao();
  public final ConnectionConfiguration aKJ;
  public final int statusCode;
  public final int versionCode;
  
  GetConfigResponse(int paramInt1, int paramInt2, ConnectionConfiguration paramConnectionConfiguration)
  {
    versionCode = paramInt1;
    statusCode = paramInt2;
    aKJ = paramConnectionConfiguration;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzao.zza(this, paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wearable.internal.GetConfigResponse
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */