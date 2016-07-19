package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.identity.intents.model.UserAddress;

public final class FullWallet
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<FullWallet> CREATOR = new zze();
  String aGj;
  String aGk;
  ProxyCard aGl;
  String aGm;
  Address aGn;
  Address aGo;
  String[] aGp;
  UserAddress aGq;
  UserAddress aGr;
  InstrumentInfo[] aGs;
  PaymentMethodToken aGt;
  private final int mVersionCode;
  
  private FullWallet()
  {
    mVersionCode = 1;
  }
  
  FullWallet(int paramInt, String paramString1, String paramString2, ProxyCard paramProxyCard, String paramString3, Address paramAddress1, Address paramAddress2, String[] paramArrayOfString, UserAddress paramUserAddress1, UserAddress paramUserAddress2, InstrumentInfo[] paramArrayOfInstrumentInfo, PaymentMethodToken paramPaymentMethodToken)
  {
    mVersionCode = paramInt;
    aGj = paramString1;
    aGk = paramString2;
    aGl = paramProxyCard;
    aGm = paramString3;
    aGn = paramAddress1;
    aGo = paramAddress2;
    aGp = paramArrayOfString;
    aGq = paramUserAddress1;
    aGr = paramUserAddress2;
    aGs = paramArrayOfInstrumentInfo;
    aGt = paramPaymentMethodToken;
  }
  
  public String[] getPaymentDescriptions()
  {
    return aGp;
  }
  
  public PaymentMethodToken getPaymentMethodToken()
  {
    return aGt;
  }
  
  public int getVersionCode()
  {
    return mVersionCode;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zze.zza(this, paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wallet.FullWallet
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */