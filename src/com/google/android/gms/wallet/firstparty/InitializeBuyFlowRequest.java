package com.google.android.gms.wallet.firstparty;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public class InitializeBuyFlowRequest
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<InitializeBuyFlowRequest> CREATOR = new zzh();
  byte[][] aHS;
  private final int mVersionCode;
  
  InitializeBuyFlowRequest(int paramInt, byte[][] paramArrayOfByte)
  {
    mVersionCode = paramInt;
    aHS = paramArrayOfByte;
  }
  
  public int getVersionCode()
  {
    return mVersionCode;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzh.zza(this, paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wallet.firstparty.InitializeBuyFlowRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */