package me.lyft.android.domain.geo;

class Leg$NullLeg
  extends Leg
{
  private static final Leg INSTANCE = new NullLeg();
  
  public static Leg getInstance()
  {
    return INSTANCE;
  }
  
  public boolean isNull()
  {
    return true;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.geo.Leg.NullLeg
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */