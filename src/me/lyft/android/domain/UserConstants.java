package me.lyft.android.domain;

import java.util.concurrent.TimeUnit;

public class UserConstants
{
  public static final long DEFAULT_POLLING_RATE = TimeUnit.SECONDS.toMillis(5L);
  public static final String DRIVER = "driver";
  public static final String EMAIL_FIELD = "email";
  public static final String INVALID_AREA_CODE_REASON = "invalidAreaCode";
  public static final String INVALID_COUNTRY_REASON = "invalidCountry";
  public static final String PASSENGER = "passenger";
  public static final String PHONE_NUMBER_FIELD = "number";
  public static final String VERIFICATION_CODE_FIELD = "verificationCode";
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.UserConstants
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */