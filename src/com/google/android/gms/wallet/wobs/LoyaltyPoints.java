package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public final class LoyaltyPoints
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<LoyaltyPoints> CREATOR = new zze();
  TimeInterval aGT;
  LoyaltyPointsBalance aIH;
  String label;
  private final int mVersionCode;
  String type;
  
  LoyaltyPoints()
  {
    mVersionCode = 1;
  }
  
  LoyaltyPoints(int paramInt, String paramString1, LoyaltyPointsBalance paramLoyaltyPointsBalance, String paramString2, TimeInterval paramTimeInterval)
  {
    mVersionCode = paramInt;
    label = paramString1;
    aIH = paramLoyaltyPointsBalance;
    type = paramString2;
    aGT = paramTimeInterval;
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
 * Qualified Name:     com.google.android.gms.wallet.wobs.LoyaltyPoints
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */