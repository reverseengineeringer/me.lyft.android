package com.google.android.gms.identity.intents.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public final class UserAddress
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<UserAddress> CREATOR = new zzb();
  String abC;
  String abD;
  String abE;
  String abF;
  String abG;
  String abH;
  String abI;
  String abJ;
  String abK;
  boolean abL;
  String abM;
  String abN;
  private final int mVersionCode;
  String name;
  String phoneNumber;
  String zzcgl;
  
  UserAddress()
  {
    mVersionCode = 1;
  }
  
  UserAddress(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, boolean paramBoolean, String paramString13, String paramString14)
  {
    mVersionCode = paramInt;
    name = paramString1;
    abC = paramString2;
    abD = paramString3;
    abE = paramString4;
    abF = paramString5;
    abG = paramString6;
    abH = paramString7;
    abI = paramString8;
    zzcgl = paramString9;
    abJ = paramString10;
    abK = paramString11;
    phoneNumber = paramString12;
    abL = paramBoolean;
    abM = paramString13;
    abN = paramString14;
  }
  
  public int getVersionCode()
  {
    return mVersionCode;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzb.zza(this, paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.identity.intents.model.UserAddress
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */