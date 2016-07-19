package me.lyft.android.application.driver.expresspay;

import com.lyft.android.api.dto.ExpressPayDTO;
import me.lyft.android.domain.driver.ExpressPayAccountMapper;
import me.lyft.android.domain.driver.ExpressPayMapper;
import rx.functions.Action1;

class ExpressPayService$1
  implements Action1<ExpressPayDTO>
{
  ExpressPayService$1(ExpressPayService paramExpressPayService) {}
  
  public void call(ExpressPayDTO paramExpressPayDTO)
  {
    ExpressPayService.access$000(this$0).setExpressPay(ExpressPayMapper.fromExpressPayDTO(paramExpressPayDTO));
    ExpressPayService.access$000(this$0).setExpressAccount(ExpressPayAccountMapper.fromDTO(expressAccount));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.driver.expresspay.ExpressPayService.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */