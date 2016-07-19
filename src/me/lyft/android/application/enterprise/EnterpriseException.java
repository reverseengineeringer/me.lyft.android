package me.lyft.android.application.enterprise;

import java.util.List;
import me.lyft.android.common.IHasReason;
import me.lyft.android.domain.lyft.LyftValidationError;
import me.lyft.android.infrastructure.lyft.LyftApiException;

public class EnterpriseException
  extends Exception
  implements IHasReason
{
  public static final String CLIENT_DETECTED_INVALID_EMAIL_FORMAT = "Client detected Invalid email format";
  public static final String EMAIL_FIELD = "email";
  public static final String REASON_DUPLICATE_ACCOUNT = "duplicateAccount";
  public static final String REASON_INVALID_EMAIL = "emailInvalid";
  public static final String REASON_INVALID_FORMAT = "invalidFormat";
  public static final String REASON_UNKNOWN = "unknown";
  
  public EnterpriseException(Throwable paramThrowable)
  {
    super(paramThrowable);
  }
  
  public static boolean containsWorkValidationError(LyftApiException paramLyftApiException)
  {
    return firstWorkFailureReason(paramLyftApiException) != null;
  }
  
  private static String firstWorkFailureReason(LyftApiException paramLyftApiException)
  {
    if (paramLyftApiException.getValidationErrors().size() > 0)
    {
      paramLyftApiException = (LyftValidationError)paramLyftApiException.getValidationErrors().get(0);
      if (paramLyftApiException.getField().equalsIgnoreCase("email")) {
        return paramLyftApiException.getReason();
      }
    }
    return null;
  }
  
  public String getReason()
  {
    Object localObject = getCause();
    if ((localObject instanceof LyftApiException))
    {
      String str = firstWorkFailureReason((LyftApiException)localObject);
      localObject = str;
      if (str == null) {
        localObject = "unknown";
      }
      return (String)localObject;
    }
    if (((Throwable)localObject).getMessage().equals("Client detected Invalid email format")) {
      return "Client detected Invalid email format";
    }
    return "unknown";
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.enterprise.EnterpriseException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */