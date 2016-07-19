package me.lyft.android.domain.location;

class MathUtils
{
  static final double EARTH_RADIUS = 6371009.0D;
  
  static double arcHav(double paramDouble)
  {
    return 2.0D * Math.asin(Math.sqrt(paramDouble));
  }
  
  static double clamp(double paramDouble1, double paramDouble2, double paramDouble3)
  {
    if (paramDouble1 < paramDouble2) {
      return paramDouble2;
    }
    if (paramDouble1 > paramDouble3) {
      return paramDouble3;
    }
    return paramDouble1;
  }
  
  static double havDistance(double paramDouble1, double paramDouble2, double paramDouble3)
  {
    return haversine(paramDouble1 - paramDouble2) + haversine(paramDouble3) * Math.cos(paramDouble1) * Math.cos(paramDouble2);
  }
  
  static double havFromSin(double paramDouble)
  {
    paramDouble *= paramDouble;
    return paramDouble / (Math.sqrt(1.0D - paramDouble) + 1.0D) * 0.5D;
  }
  
  static double haversine(double paramDouble)
  {
    paramDouble = Math.sin(0.5D * paramDouble);
    return paramDouble * paramDouble;
  }
  
  static double inverseMercator(double paramDouble)
  {
    return 2.0D * Math.atan(Math.exp(paramDouble)) - 1.5707963267948966D;
  }
  
  static double mercator(double paramDouble)
  {
    return Math.log(Math.tan(0.5D * paramDouble + 0.7853981633974483D));
  }
  
  static double mod(double paramDouble1, double paramDouble2)
  {
    return (paramDouble1 % paramDouble2 + paramDouble2) % paramDouble2;
  }
  
  static double sinFromHav(double paramDouble)
  {
    return 2.0D * Math.sqrt((1.0D - paramDouble) * paramDouble);
  }
  
  static double sinSumFromHav(double paramDouble1, double paramDouble2)
  {
    double d1 = Math.sqrt((1.0D - paramDouble1) * paramDouble1);
    double d2 = Math.sqrt((1.0D - paramDouble2) * paramDouble2);
    return (d1 + d2 - (d1 * paramDouble2 + d2 * paramDouble1) * 2.0D) * 2.0D;
  }
  
  static double wrap(double paramDouble1, double paramDouble2, double paramDouble3)
  {
    if ((paramDouble1 >= paramDouble2) && (paramDouble1 < paramDouble3)) {
      return paramDouble1;
    }
    return mod(paramDouble1 - paramDouble2, paramDouble3 - paramDouble2) + paramDouble2;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.location.MathUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */