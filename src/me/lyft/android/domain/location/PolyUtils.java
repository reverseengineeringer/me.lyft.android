package me.lyft.android.domain.location;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class PolyUtils
{
  private static final double DEFAULT_TOLERANCE = 0.1D;
  
  public static boolean containsLocation(LatLng paramLatLng, List<LatLng> paramList, boolean paramBoolean)
  {
    int i = paramList.size();
    if (i == 0) {
      return false;
    }
    double d5 = Math.toRadians(paramLatLng.getLat());
    double d6 = Math.toRadians(paramLatLng.getLng());
    paramLatLng = (LatLng)paramList.get(i - 1);
    double d1 = Math.toRadians(paramLatLng.getLat());
    double d2 = Math.toRadians(paramLatLng.getLng());
    i = 0;
    paramLatLng = paramList.iterator();
    while (paramLatLng.hasNext())
    {
      paramList = (LatLng)paramLatLng.next();
      double d7 = MathUtils.wrap(d6 - d2, -3.141592653589793D, 3.141592653589793D);
      if ((d5 == d1) && (d7 == 0.0D)) {
        return true;
      }
      double d4 = Math.toRadians(paramList.getLat());
      double d3 = Math.toRadians(paramList.getLng());
      int j = i;
      if (intersects(d1, d4, MathUtils.wrap(d3 - d2, -3.141592653589793D, 3.141592653589793D), d5, d7, paramBoolean)) {
        j = i + 1;
      }
      d1 = d4;
      d2 = d3;
      i = j;
    }
    return (i & 0x1) != 0;
  }
  
  public static List<LatLng> decode(String paramString)
  {
    int i2 = paramString.length();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    int k = 0;
    int j = 0;
    int n;
    int m;
    if (i < i2)
    {
      n = 1;
      m = 0;
    }
    for (int i1 = i;; i1 = i)
    {
      i = i1 + 1;
      i1 = paramString.charAt(i1) - '?' - 1;
      n += (i1 << m);
      m += 5;
      if (i1 < 31)
      {
        if ((n & 0x1) != 0)
        {
          m = n >> 1 ^ 0xFFFFFFFF;
          label92:
          i1 = k + m;
          m = 1;
          k = 0;
        }
        for (n = i;; n = i)
        {
          i = n + 1;
          n = paramString.charAt(n) - '?' - 1;
          m += (n << k);
          k += 5;
          if (n < 31)
          {
            if ((m & 0x1) != 0) {}
            for (k = m >> 1 ^ 0xFFFFFFFF;; k = m >> 1)
            {
              j += k;
              localArrayList.add(new SimpleLatLng(i1 * 1.0E-5D, j * 1.0E-5D));
              k = i1;
              break;
              m = n >> 1;
              break label92;
            }
            return localArrayList;
          }
        }
      }
    }
  }
  
  public static double distanceToLine(LatLng paramLatLng1, LatLng paramLatLng2, LatLng paramLatLng3)
  {
    if (paramLatLng2.equals(paramLatLng3)) {
      SphericalUtils.computeDistanceBetween(paramLatLng3, paramLatLng1);
    }
    double d1 = Math.toRadians(paramLatLng1.getLat());
    double d2 = Math.toRadians(paramLatLng1.getLng());
    double d3 = Math.toRadians(paramLatLng2.getLat());
    double d4 = Math.toRadians(paramLatLng2.getLng());
    double d6 = Math.toRadians(paramLatLng3.getLat());
    double d5 = Math.toRadians(paramLatLng3.getLng());
    d6 -= d3;
    d5 -= d4;
    d1 = ((d1 - d3) * d6 + (d2 - d4) * d5) / (d6 * d6 + d5 * d5);
    if (d1 <= 0.0D) {
      return SphericalUtils.computeDistanceBetween(paramLatLng1, paramLatLng2);
    }
    if (d1 >= 1.0D) {
      return SphericalUtils.computeDistanceBetween(paramLatLng1, paramLatLng3);
    }
    return SphericalUtils.computeDistanceBetween(new SimpleLatLng(paramLatLng1.getLat() - paramLatLng2.getLat(), paramLatLng1.getLng() - paramLatLng2.getLng()), new SimpleLatLng((paramLatLng3.getLat() - paramLatLng2.getLat()) * d1, (paramLatLng3.getLng() - paramLatLng2.getLng()) * d1));
  }
  
  public static String encode(List<LatLng> paramList)
  {
    long l1 = 0L;
    long l2 = 0L;
    StringBuffer localStringBuffer = new StringBuffer();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      LatLng localLatLng = (LatLng)paramList.next();
      long l4 = Math.round(localLatLng.getLat() * 100000.0D);
      long l3 = Math.round(localLatLng.getLng() * 100000.0D);
      encode(l4 - l1, localStringBuffer);
      encode(l3 - l2, localStringBuffer);
      l1 = l4;
      l2 = l3;
    }
    return localStringBuffer.toString();
  }
  
  private static void encode(long paramLong, StringBuffer paramStringBuffer)
  {
    if (paramLong < 0L) {
      paramLong = paramLong << 1 ^ 0xFFFFFFFFFFFFFFFF;
    }
    while (paramLong >= 32L)
    {
      paramStringBuffer.append(Character.toChars((int)((0x1F & paramLong | 0x20) + 63L)));
      paramLong >>= 5;
      continue;
      paramLong <<= 1;
    }
    paramStringBuffer.append(Character.toChars((int)(paramLong + 63L)));
  }
  
  private static boolean intersects(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, boolean paramBoolean)
  {
    if (((paramDouble5 >= 0.0D) && (paramDouble5 >= paramDouble3)) || ((paramDouble5 < 0.0D) && (paramDouble5 < paramDouble3))) {
      return false;
    }
    if (paramDouble4 <= -1.5707963267948966D) {
      return false;
    }
    if ((paramDouble1 <= -1.5707963267948966D) || (paramDouble2 <= -1.5707963267948966D) || (paramDouble1 >= 1.5707963267948966D) || (paramDouble2 >= 1.5707963267948966D)) {
      return false;
    }
    if (paramDouble3 <= -3.141592653589793D) {
      return false;
    }
    double d = ((paramDouble3 - paramDouble5) * paramDouble1 + paramDouble2 * paramDouble5) / paramDouble3;
    if ((paramDouble1 >= 0.0D) && (paramDouble2 >= 0.0D) && (paramDouble4 < d)) {
      return false;
    }
    if ((paramDouble1 <= 0.0D) && (paramDouble2 <= 0.0D) && (paramDouble4 >= d)) {
      return true;
    }
    if (paramDouble4 >= 1.5707963267948966D) {
      return true;
    }
    if (paramBoolean) {
      return Math.tan(paramDouble4) >= tanLatGC(paramDouble1, paramDouble2, paramDouble3, paramDouble5);
    }
    return MathUtils.mercator(paramDouble4) >= mercatorLatRhumb(paramDouble1, paramDouble2, paramDouble3, paramDouble5);
  }
  
  public static boolean isClosedPolygon(List<LatLng> paramList)
  {
    boolean bool = false;
    if (((LatLng)paramList.get(0)).equals((LatLng)paramList.get(paramList.size() - 1))) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean isLocationOnEdge(LatLng paramLatLng, List<LatLng> paramList, boolean paramBoolean)
  {
    return isLocationOnEdge(paramLatLng, paramList, paramBoolean, 0.1D);
  }
  
  public static boolean isLocationOnEdge(LatLng paramLatLng, List<LatLng> paramList, boolean paramBoolean, double paramDouble)
  {
    return isLocationOnEdgeOrPath(paramLatLng, paramList, true, paramBoolean, paramDouble);
  }
  
  private static boolean isLocationOnEdgeOrPath(LatLng paramLatLng, List<LatLng> paramList, boolean paramBoolean1, boolean paramBoolean2, double paramDouble)
  {
    int i = paramList.size();
    if (i == 0) {
      return false;
    }
    double d9 = paramDouble / 6371009.0D;
    double d6 = MathUtils.haversine(d9);
    double d7 = Math.toRadians(paramLatLng.getLat());
    double d8 = Math.toRadians(paramLatLng.getLng());
    double d2;
    double d1;
    double d3;
    if (paramBoolean1)
    {
      i -= 1;
      paramLatLng = (LatLng)paramList.get(i);
      d2 = Math.toRadians(paramLatLng.getLat());
      d1 = Math.toRadians(paramLatLng.getLng());
      if (paramBoolean2) {
        paramLatLng = paramList.iterator();
      }
    }
    else
    {
      for (;;)
      {
        if (!paramLatLng.hasNext()) {
          break label483;
        }
        paramList = (LatLng)paramLatLng.next();
        d3 = Math.toRadians(paramList.getLat());
        paramDouble = Math.toRadians(paramList.getLng());
        if (isOnSegmentGC(d2, d1, d3, paramDouble, d7, d8, d6))
        {
          return true;
          i = 0;
          break;
        }
        d2 = d3;
        d1 = paramDouble;
      }
    }
    paramDouble = MathUtils.mercator(d2);
    double d10 = MathUtils.mercator(d7);
    paramLatLng = new double[3];
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      LatLng localLatLng = (LatLng)paramList.next();
      double d5 = Math.toRadians(localLatLng.getLat());
      d3 = MathUtils.mercator(d5);
      double d4 = Math.toRadians(localLatLng.getLng());
      if ((Math.max(d2, d5) >= d7 - d9) && (Math.min(d2, d5) <= d7 + d9))
      {
        d2 = MathUtils.wrap(d4 - d1, -3.141592653589793D, 3.141592653589793D);
        d1 = MathUtils.wrap(d8 - d1, -3.141592653589793D, 3.141592653589793D);
        paramLatLng[0] = d1;
        paramLatLng[1] = (6.283185307179586D + d1);
        paramLatLng[2] = (d1 - 6.283185307179586D);
        int j = paramLatLng.length;
        i = 0;
        while (i < j)
        {
          double d11 = paramLatLng[i];
          double d12 = d3 - paramDouble;
          d1 = d2 * d2 + d12 * d12;
          if (d1 <= 0.0D) {}
          for (d1 = 0.0D; MathUtils.havDistance(d7, MathUtils.inverseMercator(paramDouble + d1 * d12), d11 - d1 * d2) < d6; d1 = MathUtils.clamp((d11 * d2 + (d10 - paramDouble) * d12) / d1, 0.0D, 1.0D)) {
            return true;
          }
          i += 1;
        }
      }
      d2 = d5;
      d1 = d4;
      paramDouble = d3;
    }
    label483:
    return false;
  }
  
  public static boolean isLocationOnPath(LatLng paramLatLng, List<LatLng> paramList, boolean paramBoolean)
  {
    return isLocationOnPath(paramLatLng, paramList, paramBoolean, 0.1D);
  }
  
  public static boolean isLocationOnPath(LatLng paramLatLng, List<LatLng> paramList, boolean paramBoolean, double paramDouble)
  {
    return isLocationOnEdgeOrPath(paramLatLng, paramList, false, paramBoolean, paramDouble);
  }
  
  private static boolean isOnSegmentGC(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6, double paramDouble7)
  {
    double d1 = MathUtils.havDistance(paramDouble1, paramDouble5, paramDouble2 - paramDouble6);
    if (d1 <= paramDouble7) {
      return true;
    }
    double d2 = MathUtils.havDistance(paramDouble3, paramDouble5, paramDouble4 - paramDouble6);
    if (d2 <= paramDouble7) {
      return true;
    }
    paramDouble5 = sinDeltaBearing(paramDouble1, paramDouble2, paramDouble3, paramDouble4, paramDouble5, paramDouble6);
    paramDouble5 = MathUtils.havFromSin(MathUtils.sinFromHav(d1) * paramDouble5);
    if (paramDouble5 > paramDouble7) {
      return false;
    }
    paramDouble1 = MathUtils.havDistance(paramDouble1, paramDouble3, paramDouble2 - paramDouble4);
    paramDouble2 = paramDouble1 + (1.0D - 2.0D * paramDouble1) * paramDouble5;
    if ((d1 > paramDouble2) || (d2 > paramDouble2)) {
      return false;
    }
    if (paramDouble1 < 0.74D) {
      return true;
    }
    paramDouble1 = 1.0D - 2.0D * paramDouble5;
    return MathUtils.sinSumFromHav((d1 - paramDouble5) / paramDouble1, (d2 - paramDouble5) / paramDouble1) > 0.0D;
  }
  
  private static double mercatorLatRhumb(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    return (MathUtils.mercator(paramDouble1) * (paramDouble3 - paramDouble4) + MathUtils.mercator(paramDouble2) * paramDouble4) / paramDouble3;
  }
  
  public static List<LatLng> simplify(List<LatLng> paramList, double paramDouble)
  {
    int j = paramList.size();
    if (j < 1) {
      throw new IllegalArgumentException("Polyline must have at least 1 point");
    }
    if (paramDouble <= 0.0D) {
      throw new IllegalArgumentException("Tolerance must be greater than zero");
    }
    boolean bool = isClosedPolygon(paramList);
    Object localObject1 = null;
    if (bool)
    {
      localObject1 = (LatLng)paramList.get(paramList.size() - 1);
      paramList.remove(paramList.size() - 1);
      paramList.add(new SimpleLatLng(((LatLng)localObject1).getLat() + 1.0E-11D, ((LatLng)localObject1).getLng() + 1.0E-11D));
    }
    int i = 0;
    Object localObject2 = new Stack();
    double[] arrayOfDouble = new double[j];
    arrayOfDouble[0] = 1.0D;
    arrayOfDouble[(j - 1)] = 1.0D;
    if (j > 2)
    {
      ((Stack)localObject2).push(new int[] { 0, j - 1 });
      while (((Stack)localObject2).size() > 0)
      {
        int[] arrayOfInt = (int[])((Stack)localObject2).pop();
        double d1 = 0.0D;
        int k = arrayOfInt[0] + 1;
        j = i;
        i = k;
        while (i < arrayOfInt[1])
        {
          double d3 = distanceToLine((LatLng)paramList.get(i), (LatLng)paramList.get(arrayOfInt[0]), (LatLng)paramList.get(arrayOfInt[1]));
          double d2 = d1;
          if (d3 > d1)
          {
            d2 = d3;
            j = i;
          }
          i += 1;
          d1 = d2;
        }
        i = j;
        if (d1 > paramDouble)
        {
          arrayOfDouble[j] = d1;
          ((Stack)localObject2).push(new int[] { arrayOfInt[0], j });
          ((Stack)localObject2).push(new int[] { j, arrayOfInt[1] });
          i = j;
        }
      }
    }
    if (bool)
    {
      paramList.remove(paramList.size() - 1);
      paramList.add(localObject1);
    }
    i = 0;
    localObject1 = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localObject2 = (LatLng)paramList.next();
      if (arrayOfDouble[i] != 0.0D) {
        ((ArrayList)localObject1).add(localObject2);
      }
      i += 1;
    }
    return (List<LatLng>)localObject1;
  }
  
  private static double sinDeltaBearing(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6)
  {
    double d1 = Math.sin(paramDouble1);
    double d2 = Math.cos(paramDouble3);
    double d3 = Math.cos(paramDouble5);
    paramDouble6 -= paramDouble2;
    double d4 = paramDouble4 - paramDouble2;
    paramDouble2 = Math.sin(paramDouble6) * d3;
    paramDouble4 = Math.sin(d4) * d2;
    paramDouble5 = Math.sin(paramDouble5 - paramDouble1) + 2.0D * d1 * d3 * MathUtils.haversine(paramDouble6);
    paramDouble1 = Math.sin(paramDouble3 - paramDouble1) + 2.0D * d1 * d2 * MathUtils.haversine(d4);
    paramDouble3 = (paramDouble2 * paramDouble2 + paramDouble5 * paramDouble5) * (paramDouble4 * paramDouble4 + paramDouble1 * paramDouble1);
    if (paramDouble3 <= 0.0D) {
      return 1.0D;
    }
    return (paramDouble2 * paramDouble1 - paramDouble5 * paramDouble4) / Math.sqrt(paramDouble3);
  }
  
  private static double tanLatGC(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    return (Math.tan(paramDouble1) * Math.sin(paramDouble3 - paramDouble4) + Math.tan(paramDouble2) * Math.sin(paramDouble4)) / Math.sin(paramDouble3);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.location.PolyUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */