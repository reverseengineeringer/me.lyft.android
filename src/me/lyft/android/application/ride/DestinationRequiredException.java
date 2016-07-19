package me.lyft.android.application.ride;

import me.lyft.android.common.IHasReason;

public class DestinationRequiredException
  extends Exception
  implements IHasReason
{
  private final String message;
  private final String reason;
  
  public DestinationRequiredException(String paramString1, String paramString2)
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
 * Qualified Name:     me.lyft.android.application.ride.DestinationRequiredException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */