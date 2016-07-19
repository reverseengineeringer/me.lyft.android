package me.lyft.android.domain.passenger.ride;

import java.util.Set;

public class PassengerRideRating
{
  private final int driverRating;
  private final String feedback;
  private final Set<String> improvementAreas;
  
  public PassengerRideRating(int paramInt, String paramString, Set<String> paramSet)
  {
    driverRating = paramInt;
    feedback = paramString;
    improvementAreas = paramSet;
  }
  
  public int getDriverRating()
  {
    return driverRating;
  }
  
  public String getFeedback()
  {
    return feedback;
  }
  
  public Set<String> getImprovementAreas()
  {
    return improvementAreas;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.passenger.ride.PassengerRideRating
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */