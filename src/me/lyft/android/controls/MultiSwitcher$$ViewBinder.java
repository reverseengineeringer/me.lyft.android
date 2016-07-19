package me.lyft.android.controls;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class MultiSwitcher$$ViewBinder<T extends MultiSwitcher>
  implements ButterKnife.ViewBinder<T>
{
  public void bind(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    thumbView = ((ViewGroup)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131559691, "field 'thumbView'"), 2131559691, "field 'thumbView'"));
    itemsPlaceHolder = ((LinearLayout)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131559690, "field 'itemsPlaceHolder'"), 2131559690, "field 'itemsPlaceHolder'"));
  }
  
  public void unbind(T paramT)
  {
    thumbView = null;
    itemsPlaceHolder = null;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.controls.MultiSwitcher..ViewBinder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */