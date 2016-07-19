package me.lyft.android.application.invite;

import me.lyft.android.domain.invite.WarmWelcome;
import rx.Observable;
import rx.functions.Func1;

class WarmWelcomeService$1
  implements Func1<String, Observable<WarmWelcome>>
{
  WarmWelcomeService$1(WarmWelcomeService paramWarmWelcomeService) {}
  
  public Observable<WarmWelcome> call(String paramString)
  {
    return WarmWelcomeService.access$000(this$0, paramString);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.invite.WarmWelcomeService.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */