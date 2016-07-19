package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public final class LoyaltyPointsBalance
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<LoyaltyPointsBalance> CREATOR = new zzd();
  String aGA;
  int aII;
  String aIJ;
  double aIK;
  long aIL;
  int aIM;
  private final int mVersionCode;
  
  LoyaltyPointsBalance()
  {
    mVersionCode = 1;
    aIM = -1;
    aII = -1;
    aIK = -1.0D;
  }
  
  LoyaltyPointsBalance(int paramInt1, int paramInt2, String paramString1, double paramDouble, String paramString2, long paramLong, int paramInt3)
  {
    mVersionCode = paramInt1;
    aII = paramInt2;
    aIJ = paramString1;
    aIK = paramDouble;
    aGA = paramString2;
    aIL = paramLong;
    aIM = paramInt3;
  }
  
  public int getVersionCode()
  {
    return mVersionCode;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzd.zza(this, paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wallet.wobs.LoyaltyPointsBalance
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */