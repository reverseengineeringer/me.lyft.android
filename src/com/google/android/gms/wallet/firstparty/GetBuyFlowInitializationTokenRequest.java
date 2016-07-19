package com.google.android.gms.wallet.firstparty;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

@Deprecated
public final class GetBuyFlowInitializationTokenRequest
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<GetBuyFlowInitializationTokenRequest> CREATOR = new zzb();
  byte[] aHK;
  byte[] aHL;
  private final int mVersionCode;
  
  GetBuyFlowInitializationTokenRequest()
  {
    this(1, null, null);
  }
  
  GetBuyFlowInitializationTokenRequest(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    mVersionCode = paramInt;
    aHK = paramArrayOfByte1;
    aHL = paramArrayOfByte2;
  }
  
  public int getVersionCode()
  {
    return mVersionCode;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzb.zza(this, paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wallet.firstparty.GetBuyFlowInitializationTokenRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */