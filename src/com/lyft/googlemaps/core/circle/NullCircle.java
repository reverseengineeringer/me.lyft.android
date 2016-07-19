package com.lyft.googlemaps.core.circle;

public class NullCircle
  implements ICircle
{
  private static final ICircle INSTANCE = new NullCircle();
  
  public static ICircle getInstance()
  {
    return INSTANCE;
  }
  
  public void remove() {}
}

/* Location:
 * Qualified Name:     com.lyft.googlemaps.core.circle.NullCircle
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */