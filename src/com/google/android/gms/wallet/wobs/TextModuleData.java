package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public final class TextModuleData
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<TextModuleData> CREATOR = new zzf();
  String aIN;
  String body;
  private final int mVersionCode;
  
  TextModuleData()
  {
    mVersionCode = 1;
  }
  
  TextModuleData(int paramInt, String paramString1, String paramString2)
  {
    mVersionCode = paramInt;
    aIN = paramString1;
    body = paramString2;
  }
  
  public int getVersionCode()
  {
    return mVersionCode;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzf.zza(this, paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wallet.wobs.TextModuleData
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */