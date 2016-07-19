package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public final class TimeInterval
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<TimeInterval> CREATOR = new zzg();
  long aIO;
  long aIP;
  private final int mVersionCode;
  
  TimeInterval()
  {
    mVersionCode = 1;
  }
  
  TimeInterval(int paramInt, long paramLong1, long paramLong2)
  {
    mVersionCode = paramInt;
    aIO = paramLong1;
    aIP = paramLong2;
  }
  
  public int getVersionCode()
  {
    return mVersionCode;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzg.zza(this, paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wallet.wobs.TimeInterval
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */