package me.lyft.android.locationproviders.android;

import android.location.Location;

class LocationUtil
{
  private static boolean hasSameProvider(Location paramLocation1, Location paramLocation2)
  {
    paramLocation1 = paramLocation1.getProvider();
    paramLocation2 = paramLocation2.getProvider();
    if (paramLocation1 == null) {
      return paramLocation2 == null;
    }
    return paramLocation1.equalsIgnoreCase(paramLocation2);
  }
  
  static boolean isBetterLocation(Location paramLocation1, Location paramLocation2, long paramLong, float paramFloat)
  {
    if (paramLocation1 == null) {
      return false;
    }
    if (paramLocation2 == null) {
      return true;
    }
    long l = paramLocation1.getTime() - paramLocation2.getTime();
    int j;
    int k;
    if (l > paramLong)
    {
      j = 1;
      if (l >= -paramLong) {
        break label67;
      }
      k = 1;
      label44:
      if (l <= 0L) {
        break label73;
      }
    }
    label67:
    label73:
    for (int i = 1;; i = 0)
    {
      if (j == 0) {
        break label79;
      }
      return true;
      j = 0;
      break;
      k = 0;
      break label44;
    }
    label79:
    if (k != 0) {
      return false;
    }
    float f = paramLocation1.getAccuracy() - paramLocation2.getAccuracy();
    if (f == 0.0F)
    {
      j = 1;
      if (f >= 0.0F) {
        break label141;
      }
      k = 1;
      label117:
      if (f >= paramFloat) {
        break label147;
      }
    }
    label141:
    label147:
    for (int m = 1;; m = 0)
    {
      if (k == 0) {
        break label153;
      }
      return true;
      j = 0;
      break;
      k = 0;
      break label117;
    }
    label153:
    if ((i != 0) && (j != 0)) {
      return true;
    }
    return (i != 0) && (m != 0) && (hasSameProvider(paramLocation1, paramLocation2));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.locationproviders.android.LocationUtil
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */