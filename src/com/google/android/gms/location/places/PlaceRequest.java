package com.google.android.gms.location.places;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzaa.zza;
import java.util.concurrent.TimeUnit;

public final class PlaceRequest
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<PlaceRequest> CREATOR = new zzk();
  static final long aeM = TimeUnit.SECONDS.toMillis(20L);
  static final long aeN = TimeUnit.MINUTES.toMillis(5L);
  static final long aeO = TimeUnit.MINUTES.toMillis(40L);
  static final long aeP = TimeUnit.HOURS.toMillis(1L);
  static final long aeQ = aeN;
  private final long acI;
  private final long add;
  private final PlaceFilter aeR;
  private final int mPriority;
  final int mVersionCode;
  
  public PlaceRequest(int paramInt1, PlaceFilter paramPlaceFilter, long paramLong1, int paramInt2, long paramLong2)
  {
    mVersionCode = paramInt1;
    aeR = paramPlaceFilter;
    add = paramLong1;
    mPriority = paramInt2;
    acI = paramLong2;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof PlaceRequest)) {
        return false;
      }
      paramObject = (PlaceRequest)paramObject;
    } while ((zzaa.equal(aeR, aeR)) && (add == add) && (mPriority == mPriority) && (acI == acI));
    return false;
  }
  
  public long getExpirationTime()
  {
    return acI;
  }
  
  public long getInterval()
  {
    return add;
  }
  
  public int getPriority()
  {
    return mPriority;
  }
  
  public int hashCode()
  {
    return zzaa.hashCode(new Object[] { aeR, Long.valueOf(add), Integer.valueOf(mPriority), Long.valueOf(acI) });
  }
  
  @SuppressLint({"DefaultLocale"})
  public String toString()
  {
    return zzaa.zzz(this).zzg("filter", aeR).zzg("interval", Long.valueOf(add)).zzg("priority", Integer.valueOf(mPriority)).zzg("expireAt", Long.valueOf(acI)).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzk.zza(this, paramParcel, paramInt);
  }
  
  public PlaceFilter zzbnx()
  {
    return aeR;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.places.PlaceRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */