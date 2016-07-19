package me.lyft.android.controls;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;
import butterknife.internal.DebouncingOnClickListener;

public class SearchToolbarView$$ViewBinder<T extends SearchToolbarView>
  implements ButterKnife.ViewBinder<T>
{
  public void bind(ButterKnife.Finder paramFinder, final T paramT, Object paramObject)
  {
    View localView = (View)paramFinder.findRequiredView(paramObject, 2131559595, "field 'clearButton' and method 'onClearClicked'");
    clearButton = ((ImageView)paramFinder.castView(localView, 2131559595, "field 'clearButton'"));
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClearClicked();
      }
    });
    editText = ((EditText)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131559797, "field 'editText'"), 2131559797, "field 'editText'"));
    ((View)paramFinder.findRequiredView(paramObject, 2131559087, "method 'onHomeClicked'")).setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onHomeClicked();
      }
    });
  }
  
  public void unbind(T paramT)
  {
    clearButton = null;
    editText = null;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.controls.SearchToolbarView..ViewBinder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */