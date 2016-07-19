package me.lyft.android.application.landing.exceptions;

import me.lyft.android.common.IHasReason;

public abstract class LandingServiceException
  extends Exception
  implements IHasReason
{
  public LandingServiceException() {}
  
  public LandingServiceException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.landing.exceptions.LandingServiceException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */