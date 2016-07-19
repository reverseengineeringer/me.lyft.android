package me.lyft.android.application.landing.exceptions;

public class DeactivateExistingAccountException
  extends AdditionalAuthRequiredException
{
  public DeactivateExistingAccountException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
  
  public String getReason()
  {
    return "cannotDeactivateExistingAccount";
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.landing.exceptions.DeactivateExistingAccountException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */