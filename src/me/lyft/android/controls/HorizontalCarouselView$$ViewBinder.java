package me.lyft.android.controls;

import android.view.View;
import android.widget.LinearLayout;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class HorizontalCarouselView$$ViewBinder<T extends HorizontalCarouselView>
  implements ButterKnife.ViewBinder<T>
{
  public void bind(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    containerView = ((LinearLayout)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131559201, "field 'containerView'"), 2131559201, "field 'containerView'"));
  }
  
  public void unbind(T paramT)
  {
    containerView = null;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.controls.HorizontalCarouselView..ViewBinder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */