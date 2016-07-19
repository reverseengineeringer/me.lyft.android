package com.google.android.gms.wallet;

public final class MaskedWalletRequest$Builder
{
  private MaskedWalletRequest$Builder(MaskedWalletRequest paramMaskedWalletRequest) {}
  
  public MaskedWalletRequest build()
  {
    return aHt;
  }
  
  public Builder setAllowPrepaidCard(boolean paramBoolean)
  {
    aHt.aHo = paramBoolean;
    return this;
  }
  
  public Builder setCurrencyCode(String paramString)
  {
    aHt.aGd = paramString;
    return this;
  }
  
  public Builder setEstimatedTotalPrice(String paramString)
  {
    aHt.aHj = paramString;
    return this;
  }
  
  public Builder setMerchantName(String paramString)
  {
    aHt.aHk = paramString;
    return this;
  }
  
  public Builder setPaymentMethodTokenizationParameters(PaymentMethodTokenizationParameters paramPaymentMethodTokenizationParameters)
  {
    aHt.aHr = paramPaymentMethodTokenizationParameters;
    return this;
  }
  
  public Builder setPhoneNumberRequired(boolean paramBoolean)
  {
    aHt.aHg = paramBoolean;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wallet.MaskedWalletRequest.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */