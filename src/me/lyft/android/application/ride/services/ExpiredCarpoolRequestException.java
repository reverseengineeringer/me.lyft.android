package me.lyft.android.application.ride.services;

public class ExpiredCarpoolRequestException
  extends Throwable
{
  private final String message;
  
  public ExpiredCarpoolRequestException(String paramString)
  {
    message = paramString;
  }
  
  public String getMessage()
  {
    return message;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ride.services.ExpiredCarpoolRequestException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */