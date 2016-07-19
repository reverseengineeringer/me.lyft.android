package me.lyft.android.common;

import android.content.res.Resources;
import android.view.View;
import com.lyft.scoop.ViewController;
import me.lyft.android.rx.RxUIBinder;

public abstract class RxViewController
  extends ViewController
{
  protected final RxUIBinder binder = new RxUIBinder();
  private Resources resources;
  
  public final Resources getResources()
  {
    return resources;
  }
  
  public void onAttach()
  {
    super.onAttach();
    binder.attach();
    resources = getView().getResources();
  }
  
  public void onDetach()
  {
    binder.detach();
    super.onDetach();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.common.RxViewController
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */