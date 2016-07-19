package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public final class WalletObjectMessage
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<WalletObjectMessage> CREATOR = new zzi();
  String aIN;
  TimeInterval aIR;
  UriData aIS;
  UriData aIT;
  String body;
  private final int mVersionCode;
  
  WalletObjectMessage()
  {
    mVersionCode = 1;
  }
  
  WalletObjectMessage(int paramInt, String paramString1, String paramString2, TimeInterval paramTimeInterval, UriData paramUriData1, UriData paramUriData2)
  {
    mVersionCode = paramInt;
    aIN = paramString1;
    body = paramString2;
    aIR = paramTimeInterval;
    aIS = paramUriData1;
    aIT = paramUriData2;
  }
  
  public int getVersionCode()
  {
    return mVersionCode;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzi.zza(this, paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wallet.wobs.WalletObjectMessage
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */