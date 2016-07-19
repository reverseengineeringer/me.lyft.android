package com.squareup.picasso;

public enum MemoryPolicy
{
  NO_CACHE(1),  NO_STORE(2);
  
  final int index;
  
  private MemoryPolicy(int paramInt)
  {
    index = paramInt;
  }
  
  static boolean shouldReadFromMemoryCache(int paramInt)
  {
    return (NO_CACHEindex & paramInt) == 0;
  }
  
  static boolean shouldWriteToMemoryCache(int paramInt)
  {
    return (NO_STOREindex & paramInt) == 0;
  }
}

/* Location:
 * Qualified Name:     com.squareup.picasso.MemoryPolicy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */