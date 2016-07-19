package me.lyft.android.domain.driver;

import com.lyft.android.api.dto.ExpressPayDTO;
import com.lyft.android.api.dto.LineItemDTO;
import me.lyft.android.common.Iterables;
import me.lyft.android.common.Objects;
import me.lyft.android.domain.payment.LineItem;
import me.lyft.android.domain.payment.MoneyMapper;
import rx.functions.Func1;

public class ExpressPayMapper
{
  public static ExpressPay fromExpressPayDTO(ExpressPayDTO paramExpressPayDTO)
  {
    new ExpressPay(Iterables.map(lineItems, new Func1()
    {
      public LineItem call(LineItemDTO paramAnonymousLineItemDTO)
      {
        return ExpressPayMapper.fromLineItemDTO(paramAnonymousLineItemDTO);
      }
    }), payoutInfoText);
  }
  
  public static LineItem fromLineItemDTO(LineItemDTO paramLineItemDTO)
  {
    if (paramLineItemDTO == null) {
      return LineItem.empty();
    }
    return new LineItem(MoneyMapper.fromMoneyDTO(money), (String)Objects.firstNonNull(title, ""));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.driver.ExpressPayMapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */