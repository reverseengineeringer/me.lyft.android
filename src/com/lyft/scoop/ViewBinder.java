package com.lyft.scoop;

import android.view.View;

public abstract interface ViewBinder
{
  public abstract void bind(Object paramObject, View paramView);
  
  public abstract void unbind(Object paramObject);
}

/* Location:
 * Qualified Name:     com.lyft.scoop.ViewBinder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */