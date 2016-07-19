package me.lyft.android.application.ride;

public class InactiveCarpoolRouteException
  extends RideRequestException
{
  private final String message;
  private final String reason;
  
  public InactiveCarpoolRouteException(String paramString1, String paramString2)
  {
    reason = paramString1;
    message = paramString2;
  }
  
  public String getMessage()
  {
    return message;
  }
  
  public String getReason()
  {
    return reason;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ride.InactiveCarpoolRouteException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */