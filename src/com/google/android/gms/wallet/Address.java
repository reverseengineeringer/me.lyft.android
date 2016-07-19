package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

@Deprecated
public final class Address
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<Address> CREATOR = new zza();
  String aGa;
  String aGb;
  String abC;
  String abD;
  String abE;
  String abJ;
  boolean abL;
  String abM;
  private final int mVersionCode;
  String name;
  String phoneNumber;
  String zzcgl;
  
  Address()
  {
    mVersionCode = 1;
  }
  
  Address(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, boolean paramBoolean, String paramString10)
  {
    mVersionCode = paramInt;
    name = paramString1;
    abC = paramString2;
    abD = paramString3;
    abE = paramString4;
    zzcgl = paramString5;
    aGa = paramString6;
    aGb = paramString7;
    abJ = paramString8;
    phoneNumber = paramString9;
    abL = paramBoolean;
    abM = paramString10;
  }
  
  public int getVersionCode()
  {
    return mVersionCode;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zza.zza(this, paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wallet.Address
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */