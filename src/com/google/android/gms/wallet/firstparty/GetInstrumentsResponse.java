package com.google.android.gms.wallet.firstparty;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public final class GetInstrumentsResponse
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<GetInstrumentsResponse> CREATOR = new zzg();
  String[] aHQ;
  byte[][] aHR;
  private final int mVersionCode;
  
  GetInstrumentsResponse()
  {
    this(1, new String[0], new byte[0][]);
  }
  
  GetInstrumentsResponse(int paramInt, String[] paramArrayOfString, byte[][] paramArrayOfByte)
  {
    mVersionCode = paramInt;
    aHQ = paramArrayOfString;
    aHR = paramArrayOfByte;
  }
  
  public int getVersionCode()
  {
    return mVersionCode;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzg.zza(this, paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wallet.firstparty.GetInstrumentsResponse
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */