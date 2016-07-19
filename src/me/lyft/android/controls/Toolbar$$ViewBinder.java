package me.lyft.android.controls;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class Toolbar$$ViewBinder<T extends Toolbar>
  implements ButterKnife.ViewBinder<T>
{
  public void bind(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    homeView = ((View)paramFinder.findRequiredView(paramObject, 2131559795, "field 'homeView'"));
    homeImageView = ((ImageView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131559087, "field 'homeImageView'"), 2131559087, "field 'homeImageView'"));
    logoImageView = ((ImageView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131559211, "field 'logoImageView'"), 2131559211, "field 'logoImageView'"));
    driverModeToggleView = ((View)paramFinder.findRequiredView(paramObject, 2131559088, "field 'driverModeToggleView'"));
    dividerView = ((View)paramFinder.findRequiredView(paramObject, 2131558852, "field 'dividerView'"));
    titleTextView = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131558558, "field 'titleTextView'"), 2131558558, "field 'titleTextView'"));
    itemsContainerView = ((LinearLayout)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131559796, "field 'itemsContainerView'"), 2131559796, "field 'itemsContainerView'"));
  }
  
  public void unbind(T paramT)
  {
    homeView = null;
    homeImageView = null;
    logoImageView = null;
    driverModeToggleView = null;
    dividerView = null;
    titleTextView = null;
    itemsContainerView = null;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.controls.Toolbar..ViewBinder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */