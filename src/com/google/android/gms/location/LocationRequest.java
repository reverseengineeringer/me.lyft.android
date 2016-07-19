package com.google.android.gms.location;

import android.os.Parcel;
import android.os.SystemClock;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzaa;

public final class LocationRequest
  extends AbstractSafeParcelable
{
  public static final LocationRequestCreator CREATOR = new LocationRequestCreator();
  boolean PO;
  long acI;
  long add;
  long ade;
  int adf;
  float adg;
  long adh;
  int mPriority;
  private final int mVersionCode;
  
  public LocationRequest()
  {
    mVersionCode = 1;
    mPriority = 102;
    add = 3600000L;
    ade = 600000L;
    PO = false;
    acI = Long.MAX_VALUE;
    adf = Integer.MAX_VALUE;
    adg = 0.0F;
    adh = 0L;
  }
  
  LocationRequest(int paramInt1, int paramInt2, long paramLong1, long paramLong2, boolean paramBoolean, long paramLong3, int paramInt3, float paramFloat, long paramLong4)
  {
    mVersionCode = paramInt1;
    mPriority = paramInt2;
    add = paramLong1;
    ade = paramLong2;
    PO = paramBoolean;
    acI = paramLong3;
    adf = paramInt3;
    adg = paramFloat;
    adh = paramLong4;
  }
  
  public static LocationRequest create()
  {
    return new LocationRequest();
  }
  
  private static void zzas(long paramLong)
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException(38 + "invalid interval: " + paramLong);
    }
  }
  
  private static void zze(float paramFloat)
  {
    if (paramFloat < 0.0F) {
      throw new IllegalArgumentException(37 + "invalid displacement: " + paramFloat);
    }
  }
  
  private static void zzsy(int paramInt)
  {
    switch (paramInt)
    {
    case 101: 
    case 103: 
    default: 
      throw new IllegalArgumentException(28 + "invalid quality: " + paramInt);
    }
  }
  
  public static String zzsz(int paramInt)
  {
    switch (paramInt)
    {
    case 101: 
    case 103: 
    default: 
      return "???";
    case 100: 
      return "PRIORITY_HIGH_ACCURACY";
    case 102: 
      return "PRIORITY_BALANCED_POWER_ACCURACY";
    case 104: 
      return "PRIORITY_LOW_POWER";
    }
    return "PRIORITY_NO_POWER";
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof LocationRequest)) {
        return false;
      }
      paramObject = (LocationRequest)paramObject;
    } while ((mPriority == mPriority) && (add == add) && (ade == ade) && (PO == PO) && (acI == acI) && (adf == adf) && (adg == adg));
    return false;
  }
  
  int getVersionCode()
  {
    return mVersionCode;
  }
  
  public int hashCode()
  {
    return zzaa.hashCode(new Object[] { Integer.valueOf(mPriority), Long.valueOf(add), Long.valueOf(ade), Boolean.valueOf(PO), Long.valueOf(acI), Integer.valueOf(adf), Float.valueOf(adg) });
  }
  
  public LocationRequest setFastestInterval(long paramLong)
  {
    zzas(paramLong);
    PO = true;
    ade = paramLong;
    return this;
  }
  
  public LocationRequest setInterval(long paramLong)
  {
    zzas(paramLong);
    add = paramLong;
    if (!PO) {
      ade = ((add / 6.0D));
    }
    return this;
  }
  
  public LocationRequest setPriority(int paramInt)
  {
    zzsy(paramInt);
    mPriority = paramInt;
    return this;
  }
  
  public LocationRequest setSmallestDisplacement(float paramFloat)
  {
    zze(paramFloat);
    adg = paramFloat;
    return this;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Request[").append(zzsz(mPriority));
    if (mPriority != 105)
    {
      localStringBuilder.append(" requested=");
      localStringBuilder.append(add).append("ms");
    }
    localStringBuilder.append(" fastest=");
    localStringBuilder.append(ade).append("ms");
    if (adh > add)
    {
      localStringBuilder.append(" maxWait=");
      localStringBuilder.append(adh).append("ms");
    }
    if (acI != Long.MAX_VALUE)
    {
      long l1 = acI;
      long l2 = SystemClock.elapsedRealtime();
      localStringBuilder.append(" expireIn=");
      localStringBuilder.append(l1 - l2).append("ms");
    }
    if (adf != Integer.MAX_VALUE) {
      localStringBuilder.append(" num=").append(adf);
    }
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    LocationRequestCreator.zza(this, paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.LocationRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */