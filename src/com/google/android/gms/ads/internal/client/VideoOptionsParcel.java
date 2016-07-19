package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.zzir;

@zzir
public class VideoOptionsParcel
  extends AbstractSafeParcelable
{
  public static final zzaq CREATOR = new zzaq();
  public final int versionCode;
  public final boolean zzaxk;
  
  public VideoOptionsParcel(int paramInt, boolean paramBoolean)
  {
    versionCode = paramInt;
    zzaxk = paramBoolean;
  }
  
  public VideoOptionsParcel(VideoOptions paramVideoOptions)
  {
    this(1, paramVideoOptions.getStartMuted());
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzaq.zza(this, paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.client.VideoOptionsParcel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */