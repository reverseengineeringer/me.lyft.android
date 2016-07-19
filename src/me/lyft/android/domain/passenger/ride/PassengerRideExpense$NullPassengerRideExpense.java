package me.lyft.android.domain.passenger.ride;

public class PassengerRideExpense$NullPassengerRideExpense
  extends PassengerRideExpense
{
  private static final PassengerRideExpense instance = new NullPassengerRideExpense();
  
  public PassengerRideExpense$NullPassengerRideExpense()
  {
    super(false, "", "", false);
  }
  
  public boolean isNull()
  {
    return true;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.passenger.ride.PassengerRideExpense.NullPassengerRideExpense
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */