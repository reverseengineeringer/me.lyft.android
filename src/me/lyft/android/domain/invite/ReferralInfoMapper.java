package me.lyft.android.domain.invite;

import com.lyft.android.api.dto.ReferralInfoDTO;

public class ReferralInfoMapper
{
  public static ReferralInfo fromReferralDto(ReferralInfoDTO paramReferralInfoDTO)
  {
    return new ReferralInfo(DriverReferralMapper.fromDriverReferralDto(driver));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.invite.ReferralInfoMapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */