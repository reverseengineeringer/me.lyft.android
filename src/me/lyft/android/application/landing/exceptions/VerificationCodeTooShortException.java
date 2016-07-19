package me.lyft.android.application.landing.exceptions;

public class VerificationCodeTooShortException
  extends InvalidVerificationCodeException
{
  public VerificationCodeTooShortException()
  {
    super("Verification code is too short", null);
  }
  
  public String getReason()
  {
    return "verification_code_too_short";
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.landing.exceptions.VerificationCodeTooShortException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */