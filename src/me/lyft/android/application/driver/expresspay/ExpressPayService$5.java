package me.lyft.android.application.driver.expresspay;

import com.lyft.android.api.dto.ExpressPayAccountDTO;
import me.lyft.android.analytics.core.ActionAnalytics;
import me.lyft.android.domain.driver.ExpressPayAccountMapper;
import rx.functions.Action1;

class ExpressPayService$5
  implements Action1<ExpressPayAccountDTO>
{
  ExpressPayService$5(ExpressPayService paramExpressPayService, ActionAnalytics paramActionAnalytics) {}
  
  public void call(ExpressPayAccountDTO paramExpressPayAccountDTO)
  {
    val$analytics.trackSuccess();
    ExpressPayService.access$000(this$0).setExpressAccount(ExpressPayAccountMapper.fromDTO(paramExpressPayAccountDTO));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.driver.expresspay.ExpressPayService.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */