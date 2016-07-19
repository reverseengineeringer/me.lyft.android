package me.lyft.android.controls;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;
import com.lyft.widgets.KeyboardImageButton;

public class NumericKeyboard$$ViewBinder<T extends NumericKeyboard>
  implements ButterKnife.ViewBinder<T>
{
  public void bind(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    delButton = ((KeyboardImageButton)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131559250, "field 'delButton'"), 2131559250, "field 'delButton'"));
  }
  
  public void unbind(T paramT)
  {
    delButton = null;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.controls.NumericKeyboard..ViewBinder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */