package com.google.android.gms.location;

import android.os.SystemClock;
import com.google.android.gms.location.internal.ParcelableGeofence;

public final class Geofence$Builder
{
  private int acH = 0;
  private long acI = Long.MIN_VALUE;
  private short acJ = -1;
  private double acK;
  private double acL;
  private float acM;
  private int acN = 0;
  private int acO = -1;
  private String zzbvu = null;
  
  public Geofence build()
  {
    if (zzbvu == null) {
      throw new IllegalArgumentException("Request ID not set.");
    }
    if (acH == 0) {
      throw new IllegalArgumentException("Transitions types not set.");
    }
    if (((acH & 0x4) != 0) && (acO < 0)) {
      throw new IllegalArgumentException("Non-negative loitering delay needs to be set when transition types include GEOFENCE_TRANSITION_DWELLING.");
    }
    if (acI == Long.MIN_VALUE) {
      throw new IllegalArgumentException("Expiration not set.");
    }
    if (acJ == -1) {
      throw new IllegalArgumentException("Geofence region not set.");
    }
    if (acN < 0) {
      throw new IllegalArgumentException("Notification responsiveness should be nonnegative.");
    }
    return new ParcelableGeofence(zzbvu, acH, (short)1, acK, acL, acM, acI, acN, acO);
  }
  
  public Builder setCircularRegion(double paramDouble1, double paramDouble2, float paramFloat)
  {
    acJ = 1;
    acK = paramDouble1;
    acL = paramDouble2;
    acM = paramFloat;
    return this;
  }
  
  public Builder setExpirationDuration(long paramLong)
  {
    if (paramLong < 0L)
    {
      acI = -1L;
      return this;
    }
    acI = (SystemClock.elapsedRealtime() + paramLong);
    return this;
  }
  
  public Builder setRequestId(String paramString)
  {
    zzbvu = paramString;
    return this;
  }
  
  public Builder setTransitionTypes(int paramInt)
  {
    acH = paramInt;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.Geofence.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */