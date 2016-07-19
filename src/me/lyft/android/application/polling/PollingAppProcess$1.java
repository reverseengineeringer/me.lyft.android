package me.lyft.android.application.polling;

import me.lyft.android.domain.User;
import me.lyft.android.infrastructure.foreground.IAppForegroundDetector;
import rx.functions.Action1;

class PollingAppProcess$1
  implements Action1<User>
{
  PollingAppProcess$1(PollingAppProcess paramPollingAppProcess) {}
  
  public void call(User paramUser)
  {
    boolean bool = PollingAppProcess.access$000(this$0).isForegrounded();
    PollingAppProcess.access$100(this$0, paramUser, bool);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.polling.PollingAppProcess.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */