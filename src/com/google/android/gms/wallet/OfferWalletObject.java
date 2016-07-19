package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.wallet.wobs.CommonWalletObject;
import com.google.android.gms.wallet.wobs.CommonWalletObject.zza;

public final class OfferWalletObject
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<OfferWalletObject> CREATOR = new zzo();
  CommonWalletObject aGw;
  String aHw;
  String id;
  private final int mVersionCode;
  
  OfferWalletObject()
  {
    mVersionCode = 3;
  }
  
  OfferWalletObject(int paramInt, String paramString1, String paramString2, CommonWalletObject paramCommonWalletObject)
  {
    mVersionCode = paramInt;
    aHw = paramString2;
    if (paramInt < 3)
    {
      aGw = CommonWalletObject.zzcig().zzqh(paramString1).zzcih();
      return;
    }
    aGw = paramCommonWalletObject;
  }
  
  public int getVersionCode()
  {
    return mVersionCode;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzo.zza(this, paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wallet.OfferWalletObject
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */