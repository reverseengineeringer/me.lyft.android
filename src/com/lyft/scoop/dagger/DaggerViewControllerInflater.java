package com.lyft.scoop.dagger;

import com.lyft.scoop.Scoop;
import com.lyft.scoop.ViewController;
import com.lyft.scoop.ViewControllerInflater;

public class DaggerViewControllerInflater
  extends ViewControllerInflater
{
  protected ViewController createViewController(Scoop paramScoop, Class<? extends ViewController> paramClass)
  {
    return (ViewController)DaggerInjector.fromScoop(paramScoop).get(paramClass);
  }
}

/* Location:
 * Qualified Name:     com.lyft.scoop.dagger.DaggerViewControllerInflater
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */