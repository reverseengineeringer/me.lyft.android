package me.lyft.android;

import android.view.View;
import butterknife.ButterKnife;
import com.lyft.scoop.ViewBinder;

public class ButterKnifeViewBinder
  implements ViewBinder
{
  public void bind(Object paramObject, View paramView)
  {
    ButterKnife.bind(paramObject, paramView);
  }
  
  public void unbind(Object paramObject)
  {
    ButterKnife.unbind(paramObject);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ButterKnifeViewBinder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */