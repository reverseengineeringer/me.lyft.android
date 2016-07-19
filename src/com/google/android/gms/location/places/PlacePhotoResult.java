package com.google.android.gms.location.places;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzaa.zza;

public class PlacePhotoResult
  extends AbstractSafeParcelable
  implements Result
{
  public static final Parcelable.Creator<PlacePhotoResult> CREATOR = new zzi();
  final BitmapTeleporter aeK;
  private final Status cc;
  private final Bitmap mBitmap;
  final int mVersionCode;
  
  PlacePhotoResult(int paramInt, Status paramStatus, BitmapTeleporter paramBitmapTeleporter)
  {
    mVersionCode = paramInt;
    cc = paramStatus;
    aeK = paramBitmapTeleporter;
    if (aeK != null)
    {
      mBitmap = paramBitmapTeleporter.zzaqz();
      return;
    }
    mBitmap = null;
  }
  
  public Status getStatus()
  {
    return cc;
  }
  
  public String toString()
  {
    return zzaa.zzz(this).zzg("status", cc).zzg("bitmap", mBitmap).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzi.zza(this, paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.places.PlacePhotoResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */