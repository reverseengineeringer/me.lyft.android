package com.google.android.gms.ads.internal.formats;

import android.os.Parcel;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.zzir;

@zzir
public class NativeAdOptionsParcel
  extends AbstractSafeParcelable
{
  public static final zzj CREATOR = new zzj();
  public final int versionCode;
  public final boolean zzbgt;
  public final int zzbgu;
  public final boolean zzbgv;
  public final int zzbgw;
  
  public NativeAdOptionsParcel(int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2, int paramInt3)
  {
    versionCode = paramInt1;
    zzbgt = paramBoolean1;
    zzbgu = paramInt2;
    zzbgv = paramBoolean2;
    zzbgw = paramInt3;
  }
  
  public NativeAdOptionsParcel(NativeAdOptions paramNativeAdOptions)
  {
    this(2, paramNativeAdOptions.shouldReturnUrlsForImageAssets(), paramNativeAdOptions.getImageOrientation(), paramNativeAdOptions.shouldRequestMultipleImages(), paramNativeAdOptions.getAdChoicesPlacement());
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzj.zza(this, paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */