package me.lyft.android.application.ride;

public class RouteInvalidException
  extends RideRequestException
{
  private String message;
  
  public RouteInvalidException(String paramString)
  {
    message = paramString;
  }
  
  public String getMessage()
  {
    return message;
  }
  
  public String getReason()
  {
    return "route_invalid";
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ride.RouteInvalidException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */