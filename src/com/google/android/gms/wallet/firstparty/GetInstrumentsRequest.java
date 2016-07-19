package com.google.android.gms.wallet.firstparty;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public final class GetInstrumentsRequest
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<GetInstrumentsRequest> CREATOR = new zzf();
  int[] aHP;
  private final int mVersionCode;
  
  GetInstrumentsRequest()
  {
    this(1, null);
  }
  
  GetInstrumentsRequest(int paramInt, int[] paramArrayOfInt)
  {
    mVersionCode = paramInt;
    aHP = paramArrayOfInt;
  }
  
  public int getVersionCode()
  {
    return mVersionCode;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzf.zza(this, paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wallet.firstparty.GetInstrumentsRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */