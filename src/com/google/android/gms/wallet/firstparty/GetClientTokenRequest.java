package com.google.android.gms.wallet.firstparty;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public final class GetClientTokenRequest
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<GetClientTokenRequest> CREATOR = new zzd();
  WalletCustomTheme aHN;
  private final int mVersionCode;
  
  GetClientTokenRequest()
  {
    this(1, null);
  }
  
  GetClientTokenRequest(int paramInt, WalletCustomTheme paramWalletCustomTheme)
  {
    mVersionCode = paramInt;
    aHN = paramWalletCustomTheme;
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
 * Qualified Name:     com.google.android.gms.wallet.firstparty.GetClientTokenRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */