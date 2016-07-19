package me.lyft.android.application.invite;

import com.lyft.android.api.dto.ReferralInfoDTO;
import me.lyft.android.domain.invite.ReferralInfo;
import me.lyft.android.domain.invite.ReferralInfoMapper;
import me.lyft.android.infrastructure.lyft.ILyftApi;
import rx.Observable;
import rx.functions.Func1;

public class ReferralService
  implements IReferralService
{
  private ILyftApi lyftApi;
  
  public ReferralService(ILyftApi paramILyftApi)
  {
    lyftApi = paramILyftApi;
  }
  
  public Observable<ReferralInfo> getReferral()
  {
    lyftApi.getReferral().map(new Func1()
    {
      public ReferralInfo call(ReferralInfoDTO paramAnonymousReferralInfoDTO)
      {
        return ReferralInfoMapper.fromReferralDto(paramAnonymousReferralInfoDTO);
      }
    });
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.invite.ReferralService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */