package me.lyft.android.application.landing.exceptions;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import me.lyft.android.common.Strings;
import me.lyft.android.domain.lyft.LyftError;
import me.lyft.android.domain.lyft.LyftValidationError;
import me.lyft.android.infrastructure.lyft.LyftApiException;

public class TermsNotAcceptedException
  extends LandingServiceException
{
  public static final String CARPOOL_PROVIDER = "carpool";
  public static final String ERROR_CODE = "terms_not_accepted";
  public static final String OLD_ERROR_CODE = "termsNotAccepted";
  static final String TERMS_PROVIDER_KEY = "terms_provider";
  static final String TERMS_URL_KEY = "terms_url";
  private String termsProvider;
  private String termsUrl;
  
  public TermsNotAcceptedException()
  {
    this(null, null);
  }
  
  public TermsNotAcceptedException(String paramString1, String paramString2)
  {
    termsUrl = paramString1;
    termsProvider = paramString2;
  }
  
  private static TermsNotAcceptedException mapException(LyftError paramLyftError)
  {
    return new TermsNotAcceptedException((String)paramLyftError.getMeta().get("terms_url"), (String)paramLyftError.getMeta().get("terms_provider"));
  }
  
  public static Throwable transform(Throwable paramThrowable)
  {
    if (!(paramThrowable instanceof LyftApiException)) {}
    LyftError localLyftError;
    do
    {
      return paramThrowable;
      localLyftError = ((LyftApiException)paramThrowable).getLyftError();
    } while (!Strings.equalsIgnoreCase(localLyftError.getErrorCode(), "terms_not_accepted"));
    return mapException(localLyftError);
  }
  
  public static Throwable transformForOldApi(Throwable paramThrowable)
  {
    Throwable localThrowable = paramThrowable;
    Object localObject = localThrowable;
    if ((paramThrowable instanceof LyftApiException))
    {
      localObject = (LyftApiException)paramThrowable;
      paramThrowable = ((LyftApiException)localObject).getLyftError();
      Iterator localIterator = ((LyftApiException)localObject).getValidationErrors().iterator();
      do
      {
        localObject = localThrowable;
        if (!localIterator.hasNext()) {
          break;
        }
      } while (!Strings.equalsIgnoreCase("termsNotAccepted", ((LyftValidationError)localIterator.next()).getReason()));
      localObject = mapException(paramThrowable);
    }
    return (Throwable)localObject;
  }
  
  public String getMessage()
  {
    return "Terms of service should be accepted to request ride";
  }
  
  public String getReason()
  {
    return "terms_not_accepted";
  }
  
  public String getTermsProvider()
  {
    return termsProvider;
  }
  
  public String getTermsUrl()
  {
    return termsUrl;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.landing.exceptions.TermsNotAcceptedException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */