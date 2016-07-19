package me.lyft.android.services;

import me.lyft.android.domain.User;
import rx.functions.Action1;

class AppService$2
  implements Action1<User>
{
  AppService$2(AppService paramAppService) {}
  
  public void call(User paramUser)
  {
    if (paramUser.isDispatchable())
    {
      AppService.access$000(this$0);
      return;
    }
    AppService.access$100(this$0);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.services.AppService.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */