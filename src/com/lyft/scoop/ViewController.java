package com.lyft.scoop;

import android.view.View;

public abstract class ViewController
{
  static final int VIEW_CONTROLLER_TAG = -2147483647;
  private boolean attached;
  private boolean isDetaching = false;
  private Scoop scoop;
  private View view;
  
  static ViewController fromView(View paramView)
  {
    if (paramView != null) {
      return (ViewController)paramView.getTag(-2147483647);
    }
    return null;
  }
  
  final void attach(View paramView)
  {
    view = paramView;
    Scoop.viewBinder.bind(this, paramView);
    paramView.setTag(-2147483647, this);
    onAttach();
    attached = true;
    if (isDetaching) {
      detach(paramView);
    }
  }
  
  protected final boolean attached()
  {
    return attached;
  }
  
  final void detach(View paramView)
  {
    isDetaching = true;
    if (attached)
    {
      onDetach();
      paramView.setTag(-2147483647, null);
      Scoop.viewBinder.unbind(this);
      view = null;
      attached = false;
      isDetaching = false;
    }
  }
  
  protected Scoop getScoop()
  {
    return scoop;
  }
  
  public View getView()
  {
    if (view == null) {
      throw new IllegalStateException("View accessed while ViewController is detached.");
    }
    return view;
  }
  
  protected abstract int layoutId();
  
  public void onAttach() {}
  
  public void onDetach() {}
  
  void setScoop(Scoop paramScoop)
  {
    scoop = paramScoop;
  }
}

/* Location:
 * Qualified Name:     com.lyft.scoop.ViewController
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */