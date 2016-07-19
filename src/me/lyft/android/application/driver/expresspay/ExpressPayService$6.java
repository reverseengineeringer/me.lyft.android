package me.lyft.android.application.driver.expresspay;

import com.lyft.android.api.dto.CreateExpressPayAccountDTO;
import com.lyft.android.api.dto.ExpressPayAccountDTO;
import me.lyft.android.application.IUserProvider;
import me.lyft.android.domain.User;
import me.lyft.android.infrastructure.lyft.ILyftApi;
import rx.Observable;
import rx.functions.Func1;

class ExpressPayService$6
  implements Func1<String, Observable<ExpressPayAccountDTO>>
{
  ExpressPayService$6(ExpressPayService paramExpressPayService) {}
  
  public Observable<ExpressPayAccountDTO> call(String paramString)
  {
    return ExpressPayService.access$300(this$0).createOrUpdateDebitCard(ExpressPayService.access$200(this$0).getUser().getId(), new CreateExpressPayAccountDTO("card", paramString));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.driver.expresspay.ExpressPayService.6
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */