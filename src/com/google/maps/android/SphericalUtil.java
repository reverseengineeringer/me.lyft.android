package com.google.maps.android;

import com.google.android.gms.maps.model.LatLng;

public class SphericalUtil
{
  static double computeAngleBetween(LatLng paramLatLng1, LatLng paramLatLng2)
  {
    return distanceRadians(Math.toRadians(latitude), Math.toRadians(longitude), Math.toRadians(latitude), Math.toRadians(longitude));
  }
  
  public static double computeDistanceBetween(LatLng paramLatLng1, LatLng paramLatLng2)
  {
    return computeAngleBetween(paramLatLng1, paramLatLng2) * 6371009.0D;
  }
  
  private static double distanceRadians(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    return MathUtil.arcHav(MathUtil.havDistance(paramDouble1, paramDouble3, paramDouble2 - paramDouble4));
  }
}

/* Location:
 * Qualified Name:     com.google.maps.android.SphericalUtil
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */