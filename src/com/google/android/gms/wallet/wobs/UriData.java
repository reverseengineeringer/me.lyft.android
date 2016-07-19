package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public final class UriData
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<UriData> CREATOR = new zzh();
  String aIQ;
  String description;
  private final int mVersionCode;
  
  UriData()
  {
    mVersionCode = 1;
  }
  
  UriData(int paramInt, String paramString1, String paramString2)
  {
    mVersionCode = paramInt;
    aIQ = paramString1;
    description = paramString2;
  }
  
  public int getVersionCode()
  {
    return mVersionCode;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzh.zza(this, paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wallet.wobs.UriData
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */