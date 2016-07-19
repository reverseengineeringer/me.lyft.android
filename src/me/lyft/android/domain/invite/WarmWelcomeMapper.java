package me.lyft.android.domain.invite;

import com.lyft.android.api.dto.WarmWelcomeDTO;

public class WarmWelcomeMapper
{
  public static WarmWelcome fromWarmWelcomeDTO(WarmWelcomeDTO paramWarmWelcomeDTO)
  {
    return new WarmWelcome(attribution_text, credit_text, photo, promo_text);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.invite.WarmWelcomeMapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */