package me.lyft.android.domain.ridehistory.charge;

public class NullAccountInfoItem
  extends AccountInfoItem
{
  public NullAccountInfoItem()
  {
    super(null, null, null, null);
  }
  
  public boolean isNull()
  {
    return true;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.ridehistory.charge.NullAccountInfoItem
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */