package me.lyft.android.application.invite;

import com.lyft.android.api.dto.WarmWelcomeDTO;
import me.lyft.android.domain.invite.WarmWelcome;
import me.lyft.android.domain.invite.WarmWelcomeMapper;
import rx.functions.Func1;

class WarmWelcomeService$3
  implements Func1<WarmWelcomeDTO, WarmWelcome>
{
  WarmWelcomeService$3(WarmWelcomeService paramWarmWelcomeService) {}
  
  public WarmWelcome call(WarmWelcomeDTO paramWarmWelcomeDTO)
  {
    return WarmWelcomeMapper.fromWarmWelcomeDTO(paramWarmWelcomeDTO);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.invite.WarmWelcomeService.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */