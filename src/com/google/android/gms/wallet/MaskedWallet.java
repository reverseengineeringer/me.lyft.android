package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.identity.intents.model.UserAddress;

public final class MaskedWallet
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<MaskedWallet> CREATOR = new zzl();
  String aGj;
  String aGk;
  String aGm;
  Address aGn;
  Address aGo;
  String[] aGp;
  UserAddress aGq;
  UserAddress aGr;
  InstrumentInfo[] aGs;
  LoyaltyWalletObject[] aHd;
  OfferWalletObject[] aHe;
  private final int mVersionCode;
  
  private MaskedWallet()
  {
    mVersionCode = 2;
  }
  
  MaskedWallet(int paramInt, String paramString1, String paramString2, String[] paramArrayOfString, String paramString3, Address paramAddress1, Address paramAddress2, LoyaltyWalletObject[] paramArrayOfLoyaltyWalletObject, OfferWalletObject[] paramArrayOfOfferWalletObject, UserAddress paramUserAddress1, UserAddress paramUserAddress2, InstrumentInfo[] paramArrayOfInstrumentInfo)
  {
    mVersionCode = paramInt;
    aGj = paramString1;
    aGk = paramString2;
    aGp = paramArrayOfString;
    aGm = paramString3;
    aGn = paramAddress1;
    aGo = paramAddress2;
    aHd = paramArrayOfLoyaltyWalletObject;
    aHe = paramArrayOfOfferWalletObject;
    aGq = paramUserAddress1;
    aGr = paramUserAddress2;
    aGs = paramArrayOfInstrumentInfo;
  }
  
  public String getGoogleTransactionId()
  {
    return aGj;
  }
  
  public String getMerchantTransactionId()
  {
    return aGk;
  }
  
  public int getVersionCode()
  {
    return mVersionCode;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzl.zza(this, paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wallet.MaskedWallet
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */