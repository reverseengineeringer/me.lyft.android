package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public final class InstrumentInfo
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<InstrumentInfo> CREATOR = new zzh();
  private String aGD;
  private String aGE;
  private final int mVersionCode;
  
  InstrumentInfo(int paramInt, String paramString1, String paramString2)
  {
    mVersionCode = paramInt;
    aGD = paramString1;
    aGE = paramString2;
  }
  
  public String getInstrumentDetails()
  {
    return aGE;
  }
  
  public String getInstrumentType()
  {
    return aGD;
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
 * Qualified Name:     com.google.android.gms.wallet.InstrumentInfo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */