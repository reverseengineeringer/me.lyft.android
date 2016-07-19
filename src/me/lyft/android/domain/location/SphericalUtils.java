package me.lyft.android.domain.location;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SphericalUtils
{
  static final double EARTH_RADIUS = 6371009.0D;
  private static final double KILOMETERS_PER_MILE = 1.609344D;
  private static final double LAT_LNG_EPSILON = 1.0E-5D;
  
  private static double computeAngleBetween(LatLng paramLatLng1, LatLng paramLatLng2)
  {
    return distanceRadians(Math.toRadians(paramLatLng1.getLat()), Math.toRadians(paramLatLng1.getLng()), Math.toRadians(paramLatLng2.getLat()), Math.toRadians(paramLatLng2.getLng()));
  }
  
  public static double computeDistanceBetween(LatLng paramLatLng1, LatLng paramLatLng2)
  {
    return computeAngleBetween(paramLatLng1, paramLatLng2) * 6371009.0D;
  }
  
  public static double computeLength(List<LatLng> paramList)
  {
    if (paramList.size() < 2) {
      return 0.0D;
    }
    double d3 = 0.0D;
    LatLng localLatLng = (LatLng)paramList.get(0);
    double d1 = Math.toRadians(localLatLng.getLat());
    double d2 = Math.toRadians(localLatLng.getLng());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localLatLng = (LatLng)paramList.next();
      double d5 = Math.toRadians(localLatLng.getLat());
      double d4 = Math.toRadians(localLatLng.getLng());
      d3 += distanceRadians(d1, d2, d5, d4);
      d1 = d5;
      d2 = d4;
    }
    return 6371009.0D * d3;
  }
  
  public static LatLng computeOffset(LatLng paramLatLng, double paramDouble1, double paramDouble2)
  {
    double d2 = paramDouble1 / 6371009.0D;
    paramDouble2 = Math.toRadians(paramDouble2);
    double d4 = Math.toRadians(paramLatLng.getLat());
    paramDouble1 = Math.toRadians(paramLatLng.getLng());
    double d1 = Math.cos(d2);
    d2 = Math.sin(d2);
    double d3 = Math.sin(d4);
    double d5 = Math.cos(d4);
    d4 = d1 * d3 + d2 * d5 * Math.cos(paramDouble2);
    paramDouble2 = Math.atan2(d2 * d5 * Math.sin(paramDouble2), d1 - d3 * d4);
    return new SimpleLatLng(Math.toDegrees(Math.asin(d4)), Math.toDegrees(paramDouble1 + paramDouble2));
  }
  
  public static List<LatLng> decodeOverviewPolyLineToLatLngs(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    int i2 = paramString.length();
    int k = 0;
    int j = 0;
    int m;
    int n;
    if (i < i2)
    {
      m = 0;
      n = 0;
    }
    for (int i1 = i;; i1 = i)
    {
      i = i1 + 1;
      i1 = paramString.charAt(i1) - '?';
      n |= (i1 & 0x1F) << m;
      m += 5;
      if (i1 < 32)
      {
        if ((n & 0x1) != 0)
        {
          m = n >> 1 ^ 0xFFFFFFFF;
          label93:
          i1 = k + m;
          k = 0;
          m = 0;
        }
        for (n = i;; n = i)
        {
          i = n + 1;
          n = paramString.charAt(n) - '?';
          m |= (n & 0x1F) << k;
          k += 5;
          if (n < 32)
          {
            if ((m & 0x1) != 0) {}
            for (k = m >> 1 ^ 0xFFFFFFFF;; k = m >> 1)
            {
              j += k;
              localArrayList.add(new SimpleLatLng(i1 / 100000.0D, j / 100000.0D));
              k = i1;
              break;
              m = n >> 1;
              break label93;
            }
            return localArrayList;
          }
        }
      }
    }
  }
  
  private static double distanceRadians(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    return inverseHaversine(haversineDistance(paramDouble1, paramDouble3, paramDouble2 - paramDouble4));
  }
  
  private static double haversine(double paramDouble)
  {
    paramDouble = Math.sin(0.5D * paramDouble);
    return paramDouble * paramDouble;
  }
  
  private static double haversineDistance(double paramDouble1, double paramDouble2, double paramDouble3)
  {
    return haversine(paramDouble1 - paramDouble2) + haversine(paramDouble3) * Math.cos(paramDouble1) * Math.cos(paramDouble2);
  }
  
  public static LatLng interpolate(LatLng paramLatLng1, LatLng paramLatLng2, double paramDouble)
  {
    double d1 = Math.toRadians(paramLatLng1.getLat());
    double d4 = Math.toRadians(paramLatLng1.getLng());
    double d2 = Math.toRadians(paramLatLng2.getLat());
    double d5 = Math.toRadians(paramLatLng2.getLng());
    double d6 = Math.cos(d1);
    double d7 = Math.cos(d2);
    double d8 = computeAngleBetween(paramLatLng1, paramLatLng2);
    double d9 = Math.sin(d8);
    if (d9 < 1.0E-6D) {
      return paramLatLng1;
    }
    double d3 = Math.sin((1.0D - paramDouble) * d8) / d9;
    d8 = Math.sin(paramDouble * d8) / d9;
    paramDouble = d3 * d6 * Math.cos(d4) + d8 * d7 * Math.cos(d5);
    d4 = d3 * d6 * Math.sin(d4) + d8 * d7 * Math.sin(d5);
    d1 = Math.atan2(Math.sin(d1) * d3 + Math.sin(d2) * d8, Math.sqrt(paramDouble * paramDouble + d4 * d4));
    paramDouble = Math.atan2(d4, paramDouble);
    return new SimpleLatLng(Math.toDegrees(d1), Math.toDegrees(paramDouble));
  }
  
  private static double inverseHaversine(double paramDouble)
  {
    return 2.0D * Math.asin(Math.sqrt(paramDouble));
  }
  
  public static boolean latLngApproximateEquals(Location paramLocation1, Location paramLocation2)
  {
    int i;
    if (Math.abs(paramLocation1.getLat() - paramLocation2.getLat()) <= 1.0E-5D)
    {
      i = 1;
      if (Math.abs(paramLocation1.getLng() - paramLocation2.getLng()) > 1.0E-5D) {
        break label57;
      }
    }
    label57:
    for (int j = 1;; j = 0)
    {
      if ((i == 0) || (j == 0)) {
        break label62;
      }
      return true;
      i = 0;
      break;
    }
    label62:
    return false;
  }
  
  public static double milesToKilometers(double paramDouble)
  {
    return 1.609344D * paramDouble;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.location.SphericalUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */