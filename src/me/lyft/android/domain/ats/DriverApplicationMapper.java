package me.lyft.android.domain.ats;

import com.lyft.android.api.dto.DriverApplicationDTO;
import com.lyft.android.api.dto.PhoneDTO;
import me.lyft.android.common.Objects;
import me.lyft.android.common.Strings;

public class DriverApplicationMapper
{
  public static DriverApplication fromDriverApplicationDto(DriverApplicationDTO paramDriverApplicationDTO)
  {
    return new DriverApplication(self, phone, region, referralCode, webOnboardingCompleteness);
  }
  
  private static String getPhoneNumber(PhoneDTO paramPhoneDTO)
  {
    paramPhoneDTO = (PhoneDTO)Objects.firstNonNull(paramPhoneDTO, new PhoneDTO(null, null, null, null));
    if ((!Strings.isNullOrEmpty(number)) && (!((Boolean)Objects.firstNonNull(verificationNeeded, Boolean.valueOf(true))).booleanValue())) {
      return number;
    }
    return null;
  }
  
  private static String getReferralCode(String paramString)
  {
    if (!Strings.isNullOrEmpty(paramString)) {
      return paramString;
    }
    return null;
  }
  
  public static DriverApplicationDTO toDriverApplicationDto(String paramString1, String paramString2, PhoneDTO paramPhoneDTO, String paramString3)
  {
    return new DriverApplicationDTO(paramString1, getPhoneNumber(paramPhoneDTO), paramString2, getReferralCode(paramString3), null);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.ats.DriverApplicationMapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */