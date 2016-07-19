package com.google.android.gms.wallet.firstparty;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public final class GetBuyFlowInitializationTokenResponse
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<GetBuyFlowInitializationTokenResponse> CREATOR = new zzc();
  byte[] aHM;
  private final int mVersionCode;
  
  GetBuyFlowInitializationTokenResponse()
  {
    this(1, new byte[0]);
  }
  
  GetBuyFlowInitializationTokenResponse(int paramInt, byte[] paramArrayOfByte)
  {
    mVersionCode = paramInt;
    aHM = paramArrayOfByte;
  }
  
  public int getVersionCode()
  {
    return mVersionCode;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzc.zza(this, paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wallet.firstparty.GetBuyFlowInitializationTokenResponse
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */