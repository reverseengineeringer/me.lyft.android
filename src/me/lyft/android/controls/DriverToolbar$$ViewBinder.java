package me.lyft.android.controls;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;
import butterknife.internal.DebouncingOnClickListener;
import com.lyft.widgets.ForegroundRoundedImageView;

public class DriverToolbar$$ViewBinder<T extends DriverToolbar>
  implements ButterKnife.ViewBinder<T>
{
  public void bind(ButterKnife.Finder paramFinder, final T paramT, Object paramObject)
  {
    View localView = (View)paramFinder.findRequiredView(paramObject, 2131559087, "field 'homeImageView' and method 'onHomeClick'");
    homeImageView = ((ForegroundRoundedImageView)paramFinder.castView(localView, 2131559087, "field 'homeImageView'"));
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onHomeClick();
      }
    });
    driverModeToggleView = ((View)paramFinder.findRequiredView(paramObject, 2131559088, "field 'driverModeToggleView'"));
    dividerView = ((View)paramFinder.findRequiredView(paramObject, 2131558852, "field 'dividerView'"));
    secondaryContainer = ((FrameLayout)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131559089, "field 'secondaryContainer'"), 2131559089, "field 'secondaryContainer'"));
    paramObject = (View)paramFinder.findRequiredView(paramObject, 2131558450, "field 'overflowToolbarItemButton' and method 'onOverflowClick'");
    overflowToolbarItemButton = ((ImageButton)paramFinder.castView((View)paramObject, 2131558450, "field 'overflowToolbarItemButton'"));
    ((View)paramObject).setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onOverflowClick();
      }
    });
  }
  
  public void unbind(T paramT)
  {
    homeImageView = null;
    driverModeToggleView = null;
    dividerView = null;
    secondaryContainer = null;
    overflowToolbarItemButton = null;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.controls.DriverToolbar..ViewBinder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */