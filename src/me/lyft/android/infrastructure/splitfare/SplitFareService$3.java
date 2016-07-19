package me.lyft.android.infrastructure.splitfare;

import me.lyft.android.providers.UserContact;
import rx.functions.Action1;

class SplitFareService$3
  implements Action1<UserContact>
{
  SplitFareService$3(SplitFareService paramSplitFareService, String paramString) {}
  
  public void call(UserContact paramUserContact)
  {
    paramUserContact.setCategory(val$recentCategory);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.splitfare.SplitFareService.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */