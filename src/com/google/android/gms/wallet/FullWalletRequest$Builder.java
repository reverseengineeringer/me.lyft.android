package com.google.android.gms.wallet;

public final class FullWalletRequest$Builder
{
  private FullWalletRequest$Builder(FullWalletRequest paramFullWalletRequest) {}
  
  public FullWalletRequest build()
  {
    return aGv;
  }
  
  public Builder setCart(Cart paramCart)
  {
    aGv.aGu = paramCart;
    return this;
  }
  
  public Builder setGoogleTransactionId(String paramString)
  {
    aGv.aGj = paramString;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wallet.FullWalletRequest.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */