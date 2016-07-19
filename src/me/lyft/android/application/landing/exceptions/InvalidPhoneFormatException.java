package me.lyft.android.application.landing.exceptions;

public class InvalidPhoneFormatException
  extends InvalidPhoneExeception
{
  public InvalidPhoneFormatException()
  {
    super("Invalid phone format", null);
  }
  
  public String getReason()
  {
    return "client_invalid_phone_format";
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.landing.exceptions.InvalidPhoneFormatException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */