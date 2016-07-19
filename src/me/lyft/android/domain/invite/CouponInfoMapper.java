package me.lyft.android.domain.invite;

import com.lyft.android.api.dto.CouponTemplateBodyDTO;
import com.lyft.android.api.dto.CouponTemplateDTO;
import com.lyft.android.api.dto.CouponTemplateValueDTO;
import me.lyft.android.common.Strings;
import me.lyft.android.domain.payment.Money;
import me.lyft.android.domain.payment.MoneyMapper;
import me.lyft.android.domain.payment.NullMoney;

public class CouponInfoMapper
{
  private static Money extractMoneyFromTemplate(CouponTemplateBodyDTO paramCouponTemplateBodyDTO)
  {
    if ((paramCouponTemplateBodyDTO == null) || (value == null)) {
      return NullMoney.getInstance();
    }
    return MoneyMapper.fromCentsAndCurrency(value.amount, value.currency);
  }
  
  private static CouponPayoutType extractPayoutTypeFromTemplate(CouponTemplateBodyDTO paramCouponTemplateBodyDTO)
  {
    if ((paramCouponTemplateBodyDTO == null) || (value == null)) {
      return CouponPayoutType.UNKNOWN;
    }
    if (Strings.equalsIgnoreCase(value.type, "money")) {
      return CouponPayoutType.CASH;
    }
    if (Strings.equalsIgnoreCase(value.type, "credit")) {
      return CouponPayoutType.CREDIT;
    }
    return CouponPayoutType.UNKNOWN;
  }
  
  public static CouponInfo fromCouponTemplateDTO(CouponTemplateDTO paramCouponTemplateDTO)
  {
    if (paramCouponTemplateDTO == null) {
      return CouponInfo.empty();
    }
    return new CouponInfo(code, extractMoneyFromTemplate(passenger_kickback_template), extractPayoutTypeFromTemplate(passenger_kickback_template));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.invite.CouponInfoMapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */