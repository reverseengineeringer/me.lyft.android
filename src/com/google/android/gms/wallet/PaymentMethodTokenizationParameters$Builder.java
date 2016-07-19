package com.google.android.gms.wallet;

import android.os.Bundle;
import com.google.android.gms.common.internal.zzab;

public final class PaymentMethodTokenizationParameters$Builder
{
  private PaymentMethodTokenizationParameters$Builder(PaymentMethodTokenizationParameters paramPaymentMethodTokenizationParameters) {}
  
  public Builder addParameter(String paramString1, String paramString2)
  {
    zzab.zzh(paramString1, "Tokenization parameter name must not be empty");
    zzab.zzh(paramString2, "Tokenization parameter value must not be empty");
    aHz.aHy.putString(paramString1, paramString2);
    return this;
  }
  
  public PaymentMethodTokenizationParameters build()
  {
    return aHz;
  }
  
  public Builder setPaymentMethodTokenizationType(int paramInt)
  {
    aHz.aHx = paramInt;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wallet.PaymentMethodTokenizationParameters.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */