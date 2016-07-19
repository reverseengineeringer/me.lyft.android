package com.google.android.gms.location.internal;

import android.annotation.SuppressLint;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.location.Geofence;
import java.util.Locale;

public class ParcelableGeofence
  extends AbstractSafeParcelable
  implements Geofence
{
  public static final zzo CREATOR = new zzo();
  private final int acH;
  private final short acJ;
  private final double acK;
  private final double acL;
  private final float acM;
  private final int acN;
  private final int acO;
  private final long aec;
  private final int mVersionCode;
  private final String zzbvu;
  
  public ParcelableGeofence(int paramInt1, String paramString, int paramInt2, short paramShort, double paramDouble1, double paramDouble2, float paramFloat, long paramLong, int paramInt3, int paramInt4)
  {
    zzkp(paramString);
    zzf(paramFloat);
    zza(paramDouble1, paramDouble2);
    paramInt2 = zztl(paramInt2);
    mVersionCode = paramInt1;
    acJ = paramShort;
    zzbvu = paramString;
    acK = paramDouble1;
    acL = paramDouble2;
    acM = paramFloat;
    aec = paramLong;
    acH = paramInt2;
    acN = paramInt3;
    acO = paramInt4;
  }
  
  public ParcelableGeofence(String paramString, int paramInt1, short paramShort, double paramDouble1, double paramDouble2, float paramFloat, long paramLong, int paramInt2, int paramInt3)
  {
    this(1, paramString, paramInt1, paramShort, paramDouble1, paramDouble2, paramFloat, paramLong, paramInt2, paramInt3);
  }
  
  private static void zza(double paramDouble1, double paramDouble2)
  {
    if ((paramDouble1 > 90.0D) || (paramDouble1 < -90.0D)) {
      throw new IllegalArgumentException(42 + "invalid latitude: " + paramDouble1);
    }
    if ((paramDouble2 > 180.0D) || (paramDouble2 < -180.0D)) {
      throw new IllegalArgumentException(43 + "invalid longitude: " + paramDouble2);
    }
  }
  
  private static void zzf(float paramFloat)
  {
    if (paramFloat <= 0.0F) {
      throw new IllegalArgumentException(31 + "invalid radius: " + paramFloat);
    }
  }
  
  private static void zzkp(String paramString)
  {
    if ((paramString == null) || (paramString.length() > 100))
    {
      paramString = String.valueOf(paramString);
      if (paramString.length() != 0) {}
      for (paramString = "requestId is null or too long: ".concat(paramString);; paramString = new String("requestId is null or too long: ")) {
        throw new IllegalArgumentException(paramString);
      }
    }
  }
  
  private static int zztl(int paramInt)
  {
    int i = paramInt & 0x7;
    if (i == 0) {
      throw new IllegalArgumentException(46 + "No supported transition specified: " + paramInt);
    }
    return i;
  }
  
  @SuppressLint({"DefaultLocale"})
  private static String zztm(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    }
    return "CIRCLE";
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (paramObject == null) {
        return false;
      }
      if (!(paramObject instanceof ParcelableGeofence)) {
        return false;
      }
      paramObject = (ParcelableGeofence)paramObject;
      if (acM != acM) {
        return false;
      }
      if (acK != acK) {
        return false;
      }
      if (acL != acL) {
        return false;
      }
    } while (acJ == acJ);
    return false;
  }
  
  public long getExpirationTime()
  {
    return aec;
  }
  
  public double getLatitude()
  {
    return acK;
  }
  
  public double getLongitude()
  {
    return acL;
  }
  
  public String getRequestId()
  {
    return zzbvu;
  }
  
  public int getVersionCode()
  {
    return mVersionCode;
  }
  
  public int hashCode()
  {
    long l = Double.doubleToLongBits(acK);
    int i = (int)(l ^ l >>> 32);
    l = Double.doubleToLongBits(acL);
    return ((((i + 31) * 31 + (int)(l ^ l >>> 32)) * 31 + Float.floatToIntBits(acM)) * 31 + acJ) * 31 + acH;
  }
  
  public String toString()
  {
    return String.format(Locale.US, "Geofence[%s id:%s transitions:%d %.6f, %.6f %.0fm, resp=%ds, dwell=%dms, @%d]", new Object[] { zztm(acJ), zzbvu, Integer.valueOf(acH), Double.valueOf(acK), Double.valueOf(acL), Float.valueOf(acM), Integer.valueOf(acN / 1000), Integer.valueOf(acO), Long.valueOf(aec) });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzo localzzo = CREATOR;
    zzo.zza(this, paramParcel, paramInt);
  }
  
  public short zzbnq()
  {
    return acJ;
  }
  
  public float zzbnr()
  {
    return acM;
  }
  
  public int zzbns()
  {
    return acH;
  }
  
  public int zzbnt()
  {
    return acN;
  }
  
  public int zzbnu()
  {
    return acO;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.internal.ParcelableGeofence
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */