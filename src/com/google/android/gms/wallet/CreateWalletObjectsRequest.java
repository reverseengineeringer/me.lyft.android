package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public final class CreateWalletObjectsRequest
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<CreateWalletObjectsRequest> CREATOR = new zzd();
  LoyaltyWalletObject aGg;
  OfferWalletObject aGh;
  GiftCardWalletObject aGi;
  private final int mVersionCode;
  
  CreateWalletObjectsRequest()
  {
    mVersionCode = 3;
  }
  
  CreateWalletObjectsRequest(int paramInt, LoyaltyWalletObject paramLoyaltyWalletObject, OfferWalletObject paramOfferWalletObject, GiftCardWalletObject paramGiftCardWalletObject)
  {
    mVersionCode = paramInt;
    aGg = paramLoyaltyWalletObject;
    aGh = paramOfferWalletObject;
    aGi = paramGiftCardWalletObject;
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
 * Qualified Name:     com.google.android.gms.wallet.CreateWalletObjectsRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */