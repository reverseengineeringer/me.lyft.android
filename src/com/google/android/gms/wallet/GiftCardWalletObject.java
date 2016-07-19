package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.wallet.wobs.CommonWalletObject;
import com.google.android.gms.wallet.wobs.CommonWalletObject.zza;

public final class GiftCardWalletObject
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<GiftCardWalletObject> CREATOR = new zzg();
  String aGA;
  long aGB;
  String aGC;
  CommonWalletObject aGw = CommonWalletObject.zzcig().zzcih();
  String aGx;
  String aGy;
  long aGz;
  final int mVersionCode;
  String pin;
  
  GiftCardWalletObject()
  {
    mVersionCode = 1;
  }
  
  GiftCardWalletObject(int paramInt, CommonWalletObject paramCommonWalletObject, String paramString1, String paramString2, String paramString3, long paramLong1, String paramString4, long paramLong2, String paramString5)
  {
    mVersionCode = paramInt;
    aGw = paramCommonWalletObject;
    aGx = paramString1;
    pin = paramString2;
    aGz = paramLong1;
    aGA = paramString4;
    aGB = paramLong2;
    aGC = paramString5;
    aGy = paramString3;
  }
  
  public int getVersionCode()
  {
    return mVersionCode;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzg.zza(this, paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wallet.GiftCardWalletObject
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */