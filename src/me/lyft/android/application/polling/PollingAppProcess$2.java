package me.lyft.android.application.polling;

import me.lyft.android.application.IUserProvider;
import me.lyft.android.domain.User;
import rx.functions.Action1;

class PollingAppProcess$2
  implements Action1<Boolean>
{
  PollingAppProcess$2(PollingAppProcess paramPollingAppProcess) {}
  
  public void call(Boolean paramBoolean)
  {
    User localUser = PollingAppProcess.access$200(this$0).getUser();
    PollingAppProcess.access$100(this$0, localUser, paramBoolean.booleanValue());
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.polling.PollingAppProcess.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */