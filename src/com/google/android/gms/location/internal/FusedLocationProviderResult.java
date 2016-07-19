package com.google.android.gms.location.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public final class FusedLocationProviderResult
  extends AbstractSafeParcelable
  implements Result
{
  public static final Parcelable.Creator<FusedLocationProviderResult> CREATOR = new zze();
  public static final FusedLocationProviderResult adH = new FusedLocationProviderResult(Status.sg);
  private final Status cc;
  private final int mVersionCode;
  
  FusedLocationProviderResult(int paramInt, Status paramStatus)
  {
    mVersionCode = paramInt;
    cc = paramStatus;
  }
  
  public FusedLocationProviderResult(Status paramStatus)
  {
    this(1, paramStatus);
  }
  
  public Status getStatus()
  {
    return cc;
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
 * Qualified Name:     com.google.android.gms.location.internal.FusedLocationProviderResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */