package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.ArrayList;

public final class MaskedWalletRequest
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<MaskedWalletRequest> CREATOR = new zzm();
  String aGd;
  String aGk;
  Cart aGu;
  boolean aHg;
  boolean aHh;
  boolean aHi;
  String aHj;
  String aHk;
  boolean aHl;
  boolean aHm;
  CountrySpecification[] aHn;
  boolean aHo;
  boolean aHp;
  ArrayList<com.google.android.gms.identity.intents.model.CountrySpecification> aHq;
  PaymentMethodTokenizationParameters aHr;
  ArrayList<Integer> aHs;
  private final int mVersionCode;
  
  MaskedWalletRequest()
  {
    mVersionCode = 3;
    aHo = true;
    aHp = true;
  }
  
  MaskedWalletRequest(int paramInt, String paramString1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString2, String paramString3, String paramString4, Cart paramCart, boolean paramBoolean4, boolean paramBoolean5, CountrySpecification[] paramArrayOfCountrySpecification, boolean paramBoolean6, boolean paramBoolean7, ArrayList<com.google.android.gms.identity.intents.model.CountrySpecification> paramArrayList, PaymentMethodTokenizationParameters paramPaymentMethodTokenizationParameters, ArrayList<Integer> paramArrayList1)
  {
    mVersionCode = paramInt;
    aGk = paramString1;
    aHg = paramBoolean1;
    aHh = paramBoolean2;
    aHi = paramBoolean3;
    aHj = paramString2;
    aGd = paramString3;
    aHk = paramString4;
    aGu = paramCart;
    aHl = paramBoolean4;
    aHm = paramBoolean5;
    aHn = paramArrayOfCountrySpecification;
    aHo = paramBoolean6;
    aHp = paramBoolean7;
    aHq = paramArrayList;
    aHr = paramPaymentMethodTokenizationParameters;
    aHs = paramArrayList1;
  }
  
  public static Builder newBuilder()
  {
    MaskedWalletRequest localMaskedWalletRequest = new MaskedWalletRequest();
    localMaskedWalletRequest.getClass();
    return new Builder(null);
  }
  
  public int getVersionCode()
  {
    return mVersionCode;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzm.zza(this, paramParcel, paramInt);
  }
  
  public final class Builder
  {
    private Builder() {}
    
    public MaskedWalletRequest build()
    {
      return MaskedWalletRequest.this;
    }
    
    public Builder setAllowPrepaidCard(boolean paramBoolean)
    {
      aHo = paramBoolean;
      return this;
    }
    
    public Builder setCurrencyCode(String paramString)
    {
      aGd = paramString;
      return this;
    }
    
    public Builder setEstimatedTotalPrice(String paramString)
    {
      aHj = paramString;
      return this;
    }
    
    public Builder setMerchantName(String paramString)
    {
      aHk = paramString;
      return this;
    }
    
    public Builder setPaymentMethodTokenizationParameters(PaymentMethodTokenizationParameters paramPaymentMethodTokenizationParameters)
    {
      aHr = paramPaymentMethodTokenizationParameters;
      return this;
    }
    
    public Builder setPhoneNumberRequired(boolean paramBoolean)
    {
      aHg = paramBoolean;
      return this;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wallet.MaskedWalletRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */