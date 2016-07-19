package me.lyft.android.common;

import com.jakewharton.rxrelay.BehaviorRelay;
import com.lyft.scoop.RouteChange;
import com.lyft.scoop.Router;
import com.lyft.scoop.Screen;
import java.util.Collections;
import rx.Observable;

public class AppFlow
  extends Router
{
  private final BehaviorRelay<RouteChange> routeChangeSubject = BehaviorRelay.create();
  
  public AppFlow(boolean paramBoolean)
  {
    super(paramBoolean);
  }
  
  public void clear()
  {
    replaceAllWith(Collections.emptyList());
  }
  
  public Observable<RouteChange> observeRouteChange()
  {
    return routeChangeSubject.asObservable();
  }
  
  protected void onRouteChanged(RouteChange paramRouteChange)
  {
    routeChangeSubject.call(paramRouteChange);
  }
  
  public Screen peek()
  {
    return super.peek();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.common.AppFlow
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */