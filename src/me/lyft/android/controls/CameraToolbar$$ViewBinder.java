package me.lyft.android.controls;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class CameraToolbar$$ViewBinder<T extends CameraToolbar>
  extends Toolbar..ViewBinder<T>
{
  public void bind(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    super.bind(paramFinder, paramT, paramObject);
    toolbarContainer = ((View)paramFinder.findRequiredView(paramObject, 2131558947, "field 'toolbarContainer'"));
  }
  
  public void unbind(T paramT)
  {
    super.unbind(paramT);
    toolbarContainer = null;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.controls.CameraToolbar..ViewBinder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */