package me.lyft.android.domain.driver;

import com.lyft.android.api.dto.DialDTO;
import me.lyft.android.common.Objects;
import me.lyft.android.common.Strings;
import me.lyft.android.domain.payment.MoneyMapper;

public class DialMapper
{
  public static Dial fromDto(DialDTO paramDialDTO)
  {
    Object localObject = type;
    if (Strings.isNullOrEmpty((String)localObject)) {}
    for (localObject = Dial.Type.COUNT; ((Dial.Type)localObject).equals(Dial.Type.REFERRAL); localObject = Dial.Type.valueOf(((String)localObject).toUpperCase())) {
      return new ReferralDial((Dial.Type)localObject, (String)Objects.firstNonNull(title, ""), (String)Objects.firstNonNull(subtitle, ""), (Integer)Objects.firstNonNull(value, Integer.valueOf(0)), (Integer)Objects.firstNonNull(maxValue, Integer.valueOf(0)), (Boolean)Objects.firstNonNull(goalMet, Boolean.valueOf(false)), MoneyMapper.fromMoneyDTO(payout));
    }
    return new Dial((Dial.Type)localObject, (String)Objects.firstNonNull(title, ""), (String)Objects.firstNonNull(subtitle, ""), (Integer)Objects.firstNonNull(value, Integer.valueOf(0)), (Integer)Objects.firstNonNull(maxValue, Integer.valueOf(0)), (Boolean)Objects.firstNonNull(goalMet, Boolean.valueOf(false)));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.driver.DialMapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */