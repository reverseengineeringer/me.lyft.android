package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public final class FullWalletRequest
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<FullWalletRequest> CREATOR = new zzf();
  String aGj;
  String aGk;
  Cart aGu;
  private final int mVersionCode;
  
  FullWalletRequest()
  {
    mVersionCode = 1;
  }
  
  FullWalletRequest(int paramInt, String paramString1, String paramString2, Cart paramCart)
  {
    mVersionCode = paramInt;
    aGj = paramString1;
    aGk = paramString2;
    aGu = paramCart;
  }
  
  public static Builder newBuilder()
  {
    FullWalletRequest localFullWalletRequest = new FullWalletRequest();
    localFullWalletRequest.getClass();
    return new Builder(null);
  }
  
  public int getVersionCode()
  {
    return mVersionCode;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzf.zza(this, paramParcel, paramInt);
  }
  
  public final class Builder
  {
    private Builder() {}
    
    public FullWalletRequest build()
    {
      return FullWalletRequest.this;
    }
    
    public Builder setCart(Cart paramCart)
    {
      aGu = paramCart;
      return this;
    }
    
    public Builder setGoogleTransactionId(String paramString)
    {
      aGj = paramString;
      return this;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wallet.FullWalletRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */