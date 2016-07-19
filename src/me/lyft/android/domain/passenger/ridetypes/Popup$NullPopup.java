package me.lyft.android.domain.passenger.ridetypes;

class Popup$NullPopup
  extends Popup
{
  private static final Popup INSTANCE = new NullPopup();
  
  private Popup$NullPopup()
  {
    super("", "", "", "", "", false);
  }
  
  static Popup getInstance()
  {
    return INSTANCE;
  }
  
  public boolean isNull()
  {
    return true;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.passenger.ridetypes.Popup.NullPopup
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */