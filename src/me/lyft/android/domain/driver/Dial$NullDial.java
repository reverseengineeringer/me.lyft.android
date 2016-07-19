package me.lyft.android.domain.driver;

class Dial$NullDial
  extends Dial
{
  private static final Dial INSTANCE = new NullDial();
  
  private Dial$NullDial()
  {
    super(Dial.Type.COUNT, "", "", Integer.valueOf(0), Integer.valueOf(0), Boolean.valueOf(false));
  }
  
  static Dial getInstance()
  {
    return INSTANCE;
  }
  
  public boolean isNull()
  {
    return true;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.driver.Dial.NullDial
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */