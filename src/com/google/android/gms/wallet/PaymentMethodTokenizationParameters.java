package com.google.android.gms.wallet;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzab;

public final class PaymentMethodTokenizationParameters
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<PaymentMethodTokenizationParameters> CREATOR = new zzq();
  int aHx;
  Bundle aHy = new Bundle();
  private final int mVersionCode;
  
  private PaymentMethodTokenizationParameters()
  {
    mVersionCode = 1;
  }
  
  PaymentMethodTokenizationParameters(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    mVersionCode = paramInt1;
    aHx = paramInt2;
    aHy = paramBundle;
  }
  
  public static Builder newBuilder()
  {
    PaymentMethodTokenizationParameters localPaymentMethodTokenizationParameters = new PaymentMethodTokenizationParameters();
    localPaymentMethodTokenizationParameters.getClass();
    return new Builder(null);
  }
  
  public int getVersionCode()
  {
    return mVersionCode;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzq.zza(this, paramParcel, paramInt);
  }
  
  public final class Builder
  {
    private Builder() {}
    
    public Builder addParameter(String paramString1, String paramString2)
    {
      zzab.zzh(paramString1, "Tokenization parameter name must not be empty");
      zzab.zzh(paramString2, "Tokenization parameter value must not be empty");
      aHy.putString(paramString1, paramString2);
      return this;
    }
    
    public PaymentMethodTokenizationParameters build()
    {
      return PaymentMethodTokenizationParameters.this;
    }
    
    public Builder setPaymentMethodTokenizationType(int paramInt)
    {
      aHx = paramInt;
      return this;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wallet.PaymentMethodTokenizationParameters
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */