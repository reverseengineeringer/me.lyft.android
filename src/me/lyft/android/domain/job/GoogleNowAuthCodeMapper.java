package me.lyft.android.domain.job;

import com.lyft.android.api.dto.GoogleNowAuthCodeDTO;

public class GoogleNowAuthCodeMapper
{
  public static GoogleNowAuthCodeDTO fromGoogleNowAuthCode(GoogleNowAuthCode paramGoogleNowAuthCode)
  {
    return new GoogleNowAuthCodeDTO(paramGoogleNowAuthCode.getExpirationTimestamp(), paramGoogleNowAuthCode.getAuthCode());
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.job.GoogleNowAuthCodeMapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */