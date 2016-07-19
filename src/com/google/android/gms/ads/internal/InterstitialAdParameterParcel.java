package com.google.android.gms.ads.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.zzir;

@zzir
public final class InterstitialAdParameterParcel
  extends AbstractSafeParcelable
{
  public static final zzm CREATOR = new zzm();
  public final int versionCode;
  public final boolean zzamc;
  public final boolean zzamd;
  public final String zzame;
  public final boolean zzamf;
  public final float zzamg;
  public final int zzamh;
  
  InterstitialAdParameterParcel(int paramInt1, boolean paramBoolean1, boolean paramBoolean2, String paramString, boolean paramBoolean3, float paramFloat, int paramInt2)
  {
    versionCode = paramInt1;
    zzamc = paramBoolean1;
    zzamd = paramBoolean2;
    zzame = paramString;
    zzamf = paramBoolean3;
    zzamg = paramFloat;
    zzamh = paramInt2;
  }
  
  public InterstitialAdParameterParcel(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, float paramFloat, int paramInt)
  {
    this(3, paramBoolean1, paramBoolean2, null, paramBoolean3, paramFloat, paramInt);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzm.zza(this, paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.InterstitialAdParameterParcel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */