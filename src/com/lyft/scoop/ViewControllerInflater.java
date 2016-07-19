package com.lyft.scoop;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewGroup;

public class ViewControllerInflater
{
  private static void bindViewControllerToView(final View paramView, ViewController paramViewController)
  {
    paramView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener()
    {
      public void onViewAttachedToWindow(View paramAnonymousView)
      {
        val$viewController.attach(paramView);
      }
      
      public void onViewDetachedFromWindow(View paramAnonymousView)
      {
        val$viewController.detach(paramView);
      }
    });
  }
  
  protected ViewController createViewController(Scoop paramScoop, Class<? extends ViewController> paramClass)
  {
    try
    {
      paramScoop = (ViewController)paramClass.newInstance();
      return paramScoop;
    }
    catch (Throwable paramScoop)
    {
      throw new RuntimeException("View controller " + paramClass.getSimpleName() + " don't have default constructor");
    }
  }
  
  public View inflateViewController(Scoop paramScoop, Class<? extends ViewController> paramClass, ViewGroup paramViewGroup)
  {
    paramClass = createViewController(paramScoop, paramClass);
    paramClass.setScoop(paramScoop);
    paramScoop = paramScoop.inflate(paramClass.layoutId(), paramViewGroup, false);
    bindViewControllerToView(paramScoop, paramClass);
    return paramScoop;
  }
}

/* Location:
 * Qualified Name:     com.lyft.scoop.ViewControllerInflater
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */