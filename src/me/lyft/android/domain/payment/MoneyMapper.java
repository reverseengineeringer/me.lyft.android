package me.lyft.android.domain.payment;

import com.lyft.android.api.dto.MoneyDTO;
import java.util.Map;
import me.lyft.android.common.Objects;
import me.lyft.android.common.Preconditions;
import me.lyft.android.common.Strings;

public class MoneyMapper
{
  public static Money fromCentsAndCurrency(Integer paramInteger, String paramString)
  {
    if ((!Strings.isNullOrEmpty(paramString)) && (paramInteger != null)) {
      return Money.create(paramInteger.intValue(), paramString);
    }
    return NullMoney.getInstance();
  }
  
  @Deprecated
  public static Money fromMap(Map<String, Object> paramMap)
  {
    if (paramMap == null) {
      return NullMoney.getInstance();
    }
    Double localDouble = (Double)paramMap.get("amount");
    paramMap = (String)paramMap.get("amountCurrency");
    return Money.create(((Number)Objects.firstNonNull(localDouble, Integer.valueOf(0))).intValue(), (String)Objects.firstNonNull(paramMap, ""));
  }
  
  public static Money fromMoneyDTO(MoneyDTO paramMoneyDTO)
  {
    if (paramMoneyDTO == null) {
      return NullMoney.getInstance();
    }
    return Money.create(((Integer)Objects.firstNonNull(amount, Integer.valueOf(0))).intValue(), (String)Objects.firstNonNull(amountCurrency, ""));
  }
  
  public static MoneyDTO fromMoneyDomain(Money paramMoney)
  {
    if ((paramMoney == null) || (paramMoney.isNull())) {
      return new MoneyDTO(Integer.valueOf(0), "NONE");
    }
    Preconditions.checkNotNull(paramMoney.getAmountCurrency(), "Money currency cannot be null");
    return new MoneyDTO(paramMoney.getAmount(), paramMoney.getAmountCurrency());
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.payment.MoneyMapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */