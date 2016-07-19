package me.lyft.android.domain.invite;

import com.lyft.android.api.dto.DriverReferralDTO;
import me.lyft.android.domain.payment.MoneyMapper;

public class DriverReferralMapper
{
  public static DriverReferral fromDriverReferralDto(DriverReferralDTO paramDriverReferralDTO)
  {
    return new DriverReferral(MoneyMapper.fromMoneyDTO(payout), MoneyMapper.fromMoneyDTO(refereePayout), requiredRidesCount.intValue(), daysUntilExpiration.intValue(), regionLabel);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.invite.DriverReferralMapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */