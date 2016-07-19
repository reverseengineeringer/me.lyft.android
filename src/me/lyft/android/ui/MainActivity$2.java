package me.lyft.android.ui;

import com.lyft.scoop.RouteChange;
import com.lyft.scoop.Screen;
import java.util.List;
import me.lyft.android.logging.L;
import me.lyft.android.utils.Keyboard;
import rx.functions.Action1;

class MainActivity$2
  implements Action1<RouteChange>
{
  MainActivity$2(MainActivity paramMainActivity) {}
  
  public void call(RouteChange paramRouteChange)
  {
    List localList1 = fromPath;
    List localList2 = toPath;
    if (!localList1.isEmpty()) {
      L.d("Dialog changed from: %s", new Object[] { ((Screen)localList1.get(localList1.size() - 1)).getClass().getName() });
    }
    if (!localList2.isEmpty()) {
      L.d("Dialog changed to: %s", new Object[] { ((Screen)localList2.get(localList2.size() - 1)).getClass().getName() });
    }
    Keyboard.hideKeyboard(MainActivity.access$100(this$0));
    MainActivity.access$100(this$0).goTo(paramRouteChange);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.MainActivity.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */