package me.lyft.android.infrastructure.appboy;

import me.lyft.android.domain.User;
import rx.functions.Action1;

class AppboyService$1
  implements Action1<User>
{
  AppboyService$1(AppboyService paramAppboyService) {}
  
  public void call(User paramUser)
  {
    AppboyService.access$000(this$0, paramUser);
    AppboyService.access$100(this$0);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.appboy.AppboyService.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */