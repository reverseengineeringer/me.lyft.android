package me.lyft.android.ui;

import android.view.View;
import android.view.ViewGroup;
import com.jakewharton.rxrelay.BehaviorRelay;
import me.lyft.android.maps.LyftMapView;
import me.lyft.android.rx.Binder;

@Deprecated
public class ProgressController
  implements IProgressController
{
  private Binder binder = new Binder();
  private String progressMessage;
  private ProgressView progressView;
  final BehaviorRelay<Boolean> progressVisibleSubject = BehaviorRelay.create(Boolean.valueOf(false));
  private ViewGroup rootView;
  final BehaviorRelay<Boolean> uiEnabledSubject = BehaviorRelay.create(Boolean.valueOf(true));
  
  private void enableUI(View paramView, boolean paramBoolean)
  {
    if (((paramView instanceof ViewGroup)) && (!(paramView instanceof LyftMapView)))
    {
      ViewGroup localViewGroup = (ViewGroup)paramView;
      int i = 0;
      while (i < localViewGroup.getChildCount())
      {
        enableUI(localViewGroup.getChildAt(i), paramBoolean);
        i += 1;
      }
    }
    paramView.setEnabled(paramBoolean);
  }
  
  public void disableUI()
  {
    enableUI(false);
  }
  
  public void dropView()
  {
    binder.detach();
  }
  
  public void enableUI()
  {
    enableUI(true);
  }
  
  public void enableUI(boolean paramBoolean)
  {
    uiEnabledSubject.call(Boolean.valueOf(paramBoolean));
  }
  
  public void hideProgress()
  {
    progressVisibleSubject.call(Boolean.valueOf(false));
  }
  
  public boolean isActive()
  {
    return ((Boolean)progressVisibleSubject.getValue()).booleanValue();
  }
  
  public boolean isUIEnabled()
  {
    return ((Boolean)uiEnabledSubject.getValue()).booleanValue();
  }
  
  public void showProgress()
  {
    progressMessage = "";
    progressVisibleSubject.call(Boolean.valueOf(true));
  }
  
  public void showProgress(String paramString)
  {
    progressMessage = paramString;
    progressVisibleSubject.call(Boolean.valueOf(true));
  }
  
  public void takeView(ProgressView paramProgressView, ViewGroup paramViewGroup)
  {
    progressView = paramProgressView;
    rootView = paramViewGroup;
    binder.bind(uiEnabledSubject, new ProgressController.1(this, paramViewGroup));
    binder.bind(progressVisibleSubject, new ProgressController.2(this));
    hideProgress();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.ProgressController
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */