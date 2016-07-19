package com.google.android.gms.wallet.firstparty;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public class WalletCustomTheme
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<WalletCustomTheme> CREATOR = new zzi();
  int aHT;
  Bundle aHU;
  String aHV;
  final int mVersionCode;
  
  public WalletCustomTheme()
  {
    mVersionCode = 2;
    aHT = 0;
    aHU = new Bundle();
    aHV = "";
  }
  
  WalletCustomTheme(int paramInt1, int paramInt2, Bundle paramBundle, String paramString)
  {
    mVersionCode = paramInt1;
    aHU = paramBundle;
    aHT = paramInt2;
    aHV = paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzi.zza(this, paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wallet.firstparty.WalletCustomTheme
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */