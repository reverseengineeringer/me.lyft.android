package me.lyft.android.domain.driver;

import com.lyft.android.api.dto.LineItemDTO;
import me.lyft.android.domain.payment.LineItem;
import rx.functions.Func1;

final class ExpressPayMapper$1
  implements Func1<LineItemDTO, LineItem>
{
  public LineItem call(LineItemDTO paramLineItemDTO)
  {
    return ExpressPayMapper.fromLineItemDTO(paramLineItemDTO);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.driver.ExpressPayMapper.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */