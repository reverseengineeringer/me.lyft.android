package me.lyft.android.application.invite;

import com.lyft.android.api.dto.ReferralInfoDTO;
import me.lyft.android.domain.invite.ReferralInfo;
import me.lyft.android.domain.invite.ReferralInfoMapper;
import rx.functions.Func1;

class ReferralService$1
  implements Func1<ReferralInfoDTO, ReferralInfo>
{
  ReferralService$1(ReferralService paramReferralService) {}
  
  public ReferralInfo call(ReferralInfoDTO paramReferralInfoDTO)
  {
    return ReferralInfoMapper.fromReferralDto(paramReferralInfoDTO);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.invite.ReferralService.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */