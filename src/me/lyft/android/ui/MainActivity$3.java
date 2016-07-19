package me.lyft.android.ui;

import com.lyft.scoop.RouteChange;
import com.lyft.scoop.Screen;
import me.lyft.android.common.ScreenUtils;
import me.lyft.android.logging.L;
import me.lyft.android.utils.Keyboard;
import rx.functions.Action1;

class MainActivity$3
  implements Action1<RouteChange>
{
  MainActivity$3(MainActivity paramMainActivity) {}
  
  public void call(RouteChange paramRouteChange)
  {
    Screen localScreen = ScreenUtils.nextScreenFromRouteChange(paramRouteChange);
    if (localScreen != null) {
      L.d("Screen: %s", new Object[] { localScreen.getClass().getName() });
    }
    if (localScreen != null)
    {
      Keyboard.hideKeyboard(MainActivity.access$200(this$0));
      MainActivity.access$200(this$0).goTo(paramRouteChange);
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.MainActivity.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */