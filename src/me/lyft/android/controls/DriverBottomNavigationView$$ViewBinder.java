package me.lyft.android.controls;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;
import com.lyft.widgets.DriverTabView;

public class DriverBottomNavigationView$$ViewBinder<T extends DriverBottomNavigationView>
  implements ButterKnife.ViewBinder<T>
{
  public void bind(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    homeTabView = ((DriverTabView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131558948, "field 'homeTabView'"), 2131558948, "field 'homeTabView'"));
    earningsTabView = ((DriverTabView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131558949, "field 'earningsTabView'"), 2131558949, "field 'earningsTabView'"));
    referralsTabView = ((DriverTabView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131558950, "field 'referralsTabView'"), 2131558950, "field 'referralsTabView'"));
  }
  
  public void unbind(T paramT)
  {
    homeTabView = null;
    earningsTabView = null;
    referralsTabView = null;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.controls.DriverBottomNavigationView..ViewBinder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */