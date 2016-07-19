package com.lyft.scoop;

import android.os.Parcelable;
import android.util.SparseArray;
import android.view.View;

public class Screen
{
  public static final String SERVICE_NAME = "screen";
  private transient SparseArray<Parcelable> viewState = new SparseArray();
  
  public static boolean equals(Screen paramScreen1, Screen paramScreen2)
  {
    if ((paramScreen1 == null) || (paramScreen2 == null)) {
      return false;
    }
    return paramScreen1.equals(paramScreen2);
  }
  
  public static <T extends Screen> T fromController(ViewController paramViewController)
  {
    return fromScoop(paramViewController.getScoop());
  }
  
  public static <T extends Screen> T fromScoop(Scoop paramScoop)
  {
    if (paramScoop == null) {
      return null;
    }
    return (Screen)paramScoop.findService("screen");
  }
  
  public static <T extends Screen> T fromView(View paramView)
  {
    return fromScoop(Scoop.fromView(paramView));
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof Screen)) {
      return false;
    }
    return equals(((Screen)paramObject).getClass(), getClass());
  }
  
  public boolean equals(Object paramObject1, Object paramObject2)
  {
    return (paramObject1 == paramObject2) || ((paramObject1 != null) && (paramObject1.equals(paramObject2)));
  }
  
  public Class<? extends ViewController> getController()
  {
    Controller localController = (Controller)getClass().getAnnotation(Controller.class);
    if (localController != null) {
      return localController.value();
    }
    return null;
  }
  
  public Integer getLayout()
  {
    Layout localLayout = (Layout)getClass().getAnnotation(Layout.class);
    if (localLayout != null) {
      return Integer.valueOf(localLayout.value());
    }
    return null;
  }
  
  public void restoreViewState(View paramView)
  {
    paramView.restoreHierarchyState(viewState);
  }
  
  public void saveViewState(View paramView)
  {
    SparseArray localSparseArray = new SparseArray();
    paramView.saveHierarchyState(localSparseArray);
    viewState = localSparseArray;
  }
}

/* Location:
 * Qualified Name:     com.lyft.scoop.Screen
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */