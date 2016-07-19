package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

@Deprecated
public final class ProxyCard
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<ProxyCard> CREATOR = new zzr();
  String aHA;
  String aHB;
  int aHC;
  int aHD;
  private final int mVersionCode;
  
  ProxyCard(int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3)
  {
    mVersionCode = paramInt1;
    aHA = paramString1;
    aHB = paramString2;
    aHC = paramInt2;
    aHD = paramInt3;
  }
  
  public int getVersionCode()
  {
    return mVersionCode;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzr.zza(this, paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wallet.ProxyCard
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */