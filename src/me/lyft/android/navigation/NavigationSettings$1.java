package me.lyft.android.navigation;

import me.lyft.android.ILyftPreferences;
import me.lyft.android.common.Unit;
import me.lyft.android.rx.AsyncCall;

class NavigationSettings$1
  extends AsyncCall<Unit>
{
  NavigationSettings$1(NavigationSettings paramNavigationSettings, int paramInt) {}
  
  public void onFail(Throwable paramThrowable)
  {
    NavigationSettings.access$000(this$0).setSelectedNavigation(val$previouslySelectedNavigation);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.navigation.NavigationSettings.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */