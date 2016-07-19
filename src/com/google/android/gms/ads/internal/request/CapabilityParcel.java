package com.google.android.gms.ads.internal.request;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.zzir;

@zzir
public class CapabilityParcel
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<CapabilityParcel> CREATOR = new zzj();
  public final int versionCode;
  public final boolean zzcda;
  public final boolean zzcdb;
  public final boolean zzcdc;
  
  CapabilityParcel(int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    versionCode = paramInt;
    zzcda = paramBoolean1;
    zzcdb = paramBoolean2;
    zzcdc = paramBoolean3;
  }
  
  public CapabilityParcel(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this(2, paramBoolean1, paramBoolean2, paramBoolean3);
  }
  
  public Bundle toBundle()
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("iap_supported", zzcda);
    localBundle.putBoolean("default_iap_supported", zzcdb);
    localBundle.putBoolean("app_streaming_supported", zzcdc);
    return localBundle;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzj.zza(this, paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.request.CapabilityParcel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */