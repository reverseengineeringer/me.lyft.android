package com.google.android.gms.wallet.fragment;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;

public final class WalletFragmentInitParams
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<WalletFragmentInitParams> CREATOR = new zza();
  private MaskedWalletRequest aIc;
  private MaskedWallet aId;
  private int aIq;
  private String cf;
  final int mVersionCode;
  
  private WalletFragmentInitParams()
  {
    mVersionCode = 1;
    aIq = -1;
  }
  
  WalletFragmentInitParams(int paramInt1, String paramString, MaskedWalletRequest paramMaskedWalletRequest, int paramInt2, MaskedWallet paramMaskedWallet)
  {
    mVersionCode = paramInt1;
    cf = paramString;
    aIc = paramMaskedWalletRequest;
    aIq = paramInt2;
    aId = paramMaskedWallet;
  }
  
  public String getAccountName()
  {
    return cf;
  }
  
  public MaskedWallet getMaskedWallet()
  {
    return aId;
  }
  
  public MaskedWalletRequest getMaskedWalletRequest()
  {
    return aIc;
  }
  
  public int getMaskedWalletRequestCode()
  {
    return aIq;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zza.zza(this, paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wallet.fragment.WalletFragmentInitParams
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */