package com.google.android.gms.wallet.firstparty;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public final class GetClientTokenResponse
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<GetClientTokenResponse> CREATOR = new zze();
  byte[] aHO;
  private final int mVersionCode;
  
  GetClientTokenResponse()
  {
    this(1, new byte[0]);
  }
  
  GetClientTokenResponse(int paramInt, byte[] paramArrayOfByte)
  {
    mVersionCode = paramInt;
    aHO = paramArrayOfByte;
  }
  
  public int getVersionCode()
  {
    return mVersionCode;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zze.zza(this, paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wallet.firstparty.GetClientTokenResponse
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */