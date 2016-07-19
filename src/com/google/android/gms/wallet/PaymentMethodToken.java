package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public final class PaymentMethodToken
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<PaymentMethodToken> CREATOR = new zzp();
  int aHx;
  String apC;
  private final int mVersionCode;
  
  private PaymentMethodToken()
  {
    mVersionCode = 1;
  }
  
  PaymentMethodToken(int paramInt1, int paramInt2, String paramString)
  {
    mVersionCode = paramInt1;
    aHx = paramInt2;
    apC = paramString;
  }
  
  public String getToken()
  {
    return apC;
  }
  
  public int getVersionCode()
  {
    return mVersionCode;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzp.zza(this, paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wallet.PaymentMethodToken
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */