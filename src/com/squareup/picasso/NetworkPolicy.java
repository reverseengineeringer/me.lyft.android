package com.squareup.picasso;

public enum NetworkPolicy
{
  NO_CACHE(1),  NO_STORE(2),  OFFLINE(4);
  
  final int index;
  
  private NetworkPolicy(int paramInt)
  {
    index = paramInt;
  }
  
  public static boolean isOfflineOnly(int paramInt)
  {
    return (OFFLINEindex & paramInt) != 0;
  }
  
  public static boolean shouldReadFromDiskCache(int paramInt)
  {
    return (NO_CACHEindex & paramInt) == 0;
  }
  
  public static boolean shouldWriteToDiskCache(int paramInt)
  {
    return (NO_STOREindex & paramInt) == 0;
  }
}

/* Location:
 * Qualified Name:     com.squareup.picasso.NetworkPolicy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */