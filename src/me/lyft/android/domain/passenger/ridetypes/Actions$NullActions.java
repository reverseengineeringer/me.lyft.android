package me.lyft.android.domain.passenger.ridetypes;

class Actions$NullActions
  extends Actions
{
  private static final Actions INSTANCE = new NullActions();
  
  private Actions$NullActions()
  {
    super("", "", "", "", "", "", "", "", "");
  }
  
  static Actions getInstance()
  {
    return INSTANCE;
  }
  
  public boolean isNull()
  {
    return true;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.passenger.ridetypes.Actions.NullActions
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */