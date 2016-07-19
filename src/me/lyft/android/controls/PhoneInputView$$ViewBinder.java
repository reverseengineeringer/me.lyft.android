package me.lyft.android.controls;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class PhoneInputView$$ViewBinder<T extends PhoneInputView>
  implements ButterKnife.ViewBinder<T>
{
  public void bind(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    phoneEditText = ((KeyboardlessEditText)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131559578, "field 'phoneEditText'"), 2131559578, "field 'phoneEditText'"));
    flagLayout = ((View)paramFinder.findRequiredView(paramObject, 2131559576, "field 'flagLayout'"));
    flagButton = ((ImageView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131558884, "field 'flagButton'"), 2131558884, "field 'flagButton'"));
    callingCodeTextView = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131559577, "field 'callingCodeTextView'"), 2131559577, "field 'callingCodeTextView'"));
  }
  
  public void unbind(T paramT)
  {
    phoneEditText = null;
    flagLayout = null;
    flagButton = null;
    callingCodeTextView = null;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.controls.PhoneInputView..ViewBinder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */