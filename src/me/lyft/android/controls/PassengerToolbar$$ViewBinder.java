package me.lyft.android.controls;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;
import butterknife.internal.DebouncingOnClickListener;
import com.lyft.widgets.ForegroundRoundedImageView;
import me.lyft.android.ui.passenger.v2.request.pickup.ScheduledRidesToolbarItem;

public class PassengerToolbar$$ViewBinder<T extends PassengerToolbar>
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
    logoImageView = ((ImageView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131559211, "field 'logoImageView'"), 2131559211, "field 'logoImageView'"));
    driverModeToggleView = ((View)paramFinder.findRequiredView(paramObject, 2131559088, "field 'driverModeToggleView'"));
    secondaryContainer = ((FrameLayout)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131559540, "field 'secondaryContainer'"), 2131559540, "field 'secondaryContainer'"));
    scheduledRidesToolbarItem = ((ScheduledRidesToolbarItem)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131558455, "field 'scheduledRidesToolbarItem'"), 2131558455, "field 'scheduledRidesToolbarItem'"));
  }
  
  public void unbind(T paramT)
  {
    homeImageView = null;
    logoImageView = null;
    driverModeToggleView = null;
    secondaryContainer = null;
    scheduledRidesToolbarItem = null;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.controls.PassengerToolbar..ViewBinder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */