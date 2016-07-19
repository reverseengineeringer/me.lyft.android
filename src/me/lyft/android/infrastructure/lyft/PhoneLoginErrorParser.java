package me.lyft.android.infrastructure.lyft;

import java.util.List;
import me.lyft.android.application.landing.exceptions.CreditCardAuthRequiredException;
import me.lyft.android.application.landing.exceptions.DeactivateExistingAccountException;
import me.lyft.android.application.landing.exceptions.DriverLicenseAuthRequiredException;
import me.lyft.android.application.landing.exceptions.DuplicatePhoneException;
import me.lyft.android.application.landing.exceptions.InvalidPhoneExeception;
import me.lyft.android.application.landing.exceptions.InvalidVerificationCodeException;
import me.lyft.android.application.landing.exceptions.SuspendedPhoneException;
import me.lyft.android.domain.lyft.LyftValidationError;

public class PhoneLoginErrorParser
{
  public static final String FIELD_CC_LAST_FOUR = "ccLast4";
  public static final String FIELD_DRIVERS_LICENSE_NUMBER = "driversLicenseNumber";
  public static final String FIELD_FORCE_NEW_ACCOUNT = "forceNewAccount";
  public static final String REASON_ADDITIONAL_AUTH_REQUIRED = "additionalAuthRequired";
  public static final String REASON_CANNOT_DEACTIVATE_ACCOUNT = "cannotDeactivateExistingAccount";
  public static final String REASON_DUPLICATE_PHONE = "duplicatePhoneNumber";
  public static final String REASON_INVALID_PHONE = "invalidPhone";
  public static final String REASON_INVALID_PHONE_FORMAT = "invalidFormat";
  public static final String REASON_SUSPENDED = "suspended";
  
  public static Throwable parse(Throwable paramThrowable)
  {
    Throwable localThrowable = paramThrowable;
    if ((paramThrowable instanceof LyftApiException)) {
      localThrowable = parseApiException(paramThrowable);
    }
    return localThrowable;
  }
  
  private static Throwable parseApiException(Throwable paramThrowable)
  {
    LyftApiException localLyftApiException = (LyftApiException)paramThrowable;
    if (localLyftApiException.getStatusCode() == 422) {
      paramThrowable = parseValidationErrors(localLyftApiException);
    }
    return paramThrowable;
  }
  
  private static Throwable parseValidationErrorReasonAndField(LyftApiException paramLyftApiException)
  {
    Object localObject = (LyftValidationError)paramLyftApiException.getValidationErrors().get(0);
    String str1 = ((LyftValidationError)localObject).getField();
    String str2 = ((LyftValidationError)localObject).getReason();
    String str3 = ((LyftValidationError)localObject).getMessage();
    if (str1.equalsIgnoreCase("verificationCode")) {
      localObject = new InvalidVerificationCodeException(str3, paramLyftApiException);
    }
    do
    {
      do
      {
        return (Throwable)localObject;
        if ((str2.equalsIgnoreCase("invalidPhone")) || (str2.equalsIgnoreCase("invalidFormat"))) {
          return new InvalidPhoneExeception(str3, paramLyftApiException);
        }
        if (str2.equalsIgnoreCase("duplicatePhoneNumber")) {
          return new DuplicatePhoneException(str3, paramLyftApiException);
        }
        if (str2.equalsIgnoreCase("suspended")) {
          return new SuspendedPhoneException(str3, paramLyftApiException);
        }
        if ((str2.equalsIgnoreCase("additionalAuthRequired")) && (str1.equalsIgnoreCase("driversLicenseNumber"))) {
          return new DriverLicenseAuthRequiredException(str3, paramLyftApiException);
        }
        if ((str2.equalsIgnoreCase("additionalAuthRequired")) && (str1.equalsIgnoreCase("ccLast4"))) {
          return new CreditCardAuthRequiredException(str3, paramLyftApiException);
        }
        localObject = paramLyftApiException;
      } while (!str2.equalsIgnoreCase("cannotDeactivateExistingAccount"));
      localObject = paramLyftApiException;
    } while (!str1.equalsIgnoreCase("forceNewAccount"));
    return new DeactivateExistingAccountException(str3, paramLyftApiException);
  }
  
  private static Throwable parseValidationErrors(LyftApiException paramLyftApiException)
  {
    Object localObject = paramLyftApiException;
    if (paramLyftApiException.getValidationErrors().size() > 0) {
      localObject = parseValidationErrorReasonAndField(paramLyftApiException);
    }
    return (Throwable)localObject;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.lyft.PhoneLoginErrorParser
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */