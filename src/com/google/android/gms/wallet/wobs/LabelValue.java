package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public final class LabelValue
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<LabelValue> CREATOR = new zzb();
  String label;
  private final int mVersionCode;
  String value;
  
  LabelValue()
  {
    mVersionCode = 1;
  }
  
  LabelValue(int paramInt, String paramString1, String paramString2)
  {
    mVersionCode = paramInt;
    label = paramString1;
    value = paramString2;
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
 * Qualified Name:     com.google.android.gms.wallet.wobs.LabelValue
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */