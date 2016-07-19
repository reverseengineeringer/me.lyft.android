package me.lyft.android.infrastructure.appboy;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;
import butterknife.internal.DebouncingOnClickListener;

public class CustomAppboyInAppDialog$$ViewBinder<T extends CustomAppboyInAppDialog>
  implements ButterKnife.ViewBinder<T>
{
  public void bind(ButterKnife.Finder paramFinder, final T paramT, Object paramObject)
  {
    titleTextView = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131558889, "field 'titleTextView'"), 2131558889, "field 'titleTextView'"));
    imageView = ((ImageView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131558890, "field 'imageView'"), 2131558890, "field 'imageView'"));
    messageTextView = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131558891, "field 'messageTextView'"), 2131558891, "field 'messageTextView'"));
    buttonLayout = ((LinearLayout)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131558892, "field 'buttonLayout'"), 2131558892, "field 'buttonLayout'"));
    background = ((View)paramFinder.findRequiredView(paramObject, 2131558888, "field 'background'"));
    paramObject = (View)paramFinder.findRequiredView(paramObject, 2131558683, "field 'cancelView' and method 'onCancelClicked'");
    cancelView = ((ImageView)paramFinder.castView((View)paramObject, 2131558683, "field 'cancelView'"));
    ((View)paramObject).setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onCancelClicked();
      }
    });
  }
  
  public void unbind(T paramT)
  {
    titleTextView = null;
    imageView = null;
    messageTextView = null;
    buttonLayout = null;
    background = null;
    cancelView = null;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.appboy.CustomAppboyInAppDialog..ViewBinder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */