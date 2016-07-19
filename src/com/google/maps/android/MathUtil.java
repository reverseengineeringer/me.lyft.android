package com.google.maps.android;

class MathUtil
{
  static double arcHav(double paramDouble)
  {
    return 2.0D * Math.asin(Math.sqrt(paramDouble));
  }
  
  static double hav(double paramDouble)
  {
    paramDouble = Math.sin(0.5D * paramDouble);
    return paramDouble * paramDouble;
  }
  
  static double havDistance(double paramDouble1, double paramDouble2, double paramDouble3)
  {
    return hav(paramDouble1 - paramDouble2) + hav(paramDouble3) * Math.cos(paramDouble1) * Math.cos(paramDouble2);
  }
}

/* Location:
 * Qualified Name:     com.google.maps.android.MathUtil
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */