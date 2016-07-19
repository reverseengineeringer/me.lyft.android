package com.lyft.scoop;

import android.content.Context;
import android.util.AttributeSet;
import android.view.DragEvent;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.lyft.scoop.transitions.InstantTransition;
import java.util.ArrayDeque;

public abstract class UiContainer
  extends FrameLayout
  implements HandleBack, TransitionListener
{
  private View active;
  private boolean isTransitioning;
  private ArrayDeque<RouteChange> screenSwapQueue = new ArrayDeque();
  
  public UiContainer(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public UiContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public UiContainer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    if (isInEditMode()) {}
  }
  
  private boolean childCanGoBack()
  {
    if ((active instanceof HandleBack)) {
      return handleBack(active);
    }
    ViewController localViewController = ViewController.fromView(active);
    if ((localViewController != null) && ((localViewController instanceof HandleBack))) {
      return handleBack(localViewController);
    }
    return false;
  }
  
  static ScreenTransition getEnterTransition(ScreenSwap paramScreenSwap)
  {
    if (next == null) {
      return new InstantTransition();
    }
    paramScreenSwap = (EnterTransition)next.getClass().getAnnotation(EnterTransition.class);
    if (paramScreenSwap != null) {
      try
      {
        ScreenTransition localScreenTransition = (ScreenTransition)paramScreenSwap.value().newInstance();
        return localScreenTransition;
      }
      catch (Throwable localThrowable)
      {
        throw new RuntimeException("Failed to instantiate enter transition: " + paramScreenSwap.value().getSimpleName(), localThrowable);
      }
    }
    return new InstantTransition();
  }
  
  static ScreenTransition getExitTransition(ScreenSwap paramScreenSwap)
  {
    if (previous == null) {
      return new InstantTransition();
    }
    paramScreenSwap = (ExitTransition)previous.getClass().getAnnotation(ExitTransition.class);
    if (paramScreenSwap != null) {
      try
      {
        ScreenTransition localScreenTransition = (ScreenTransition)paramScreenSwap.value().newInstance();
        return localScreenTransition;
      }
      catch (Throwable localThrowable)
      {
        throw new RuntimeException("Failed to instantiate exit transition: " + paramScreenSwap.value().getSimpleName(), localThrowable);
      }
    }
    return new InstantTransition();
  }
  
  private ScreenTransition getTransition(ScreenSwap paramScreenSwap)
  {
    if (direction == TransitionDirection.ENTER) {
      return getEnterTransition(paramScreenSwap);
    }
    return getExitTransition(paramScreenSwap);
  }
  
  private TransitionListener getTransitionListener()
  {
    ViewController localViewController = ViewController.fromView(active);
    Object localObject = new NoOpTransitionListener();
    if ((localViewController instanceof TransitionListener)) {
      localObject = (TransitionListener)localViewController;
    }
    return (TransitionListener)localObject;
  }
  
  private boolean handleBack(Object paramObject)
  {
    return ((HandleBack)paramObject).onBack();
  }
  
  private View inflateControllerView(Screen paramScreen, Scoop paramScoop)
  {
    return getViewControllerInflater().inflateViewController(paramScoop, paramScreen.getController(), this);
  }
  
  private View inflateLayout(Screen paramScreen, Scoop paramScoop)
  {
    return getLayoutInflater().inflateView(paramScoop, paramScreen, this);
  }
  
  private void swap(RouteChange paramRouteChange)
  {
    Scoop localScoop = getActiveScoop(paramRouteChange);
    paramRouteChange = paramRouteChange.toScreenSwap();
    Screen localScreen1 = previous;
    Screen localScreen2 = next;
    View localView = active;
    if ((active != null) && (localScreen1 != null)) {
      localScreen1.saveViewState(active);
    }
    if (localScreen2 == null) {
      active = null;
    }
    for (;;)
    {
      isTransitioning = true;
      getTransition(paramRouteChange).transition(this, localView, active, this);
      return;
      if (localScreen2.getController() != null)
      {
        active = inflateControllerView(localScreen2, localScoop);
        localScreen2.restoreViewState(active);
      }
      else
      {
        active = inflateLayout(localScreen2, localScoop);
        localScreen2.restoreViewState(active);
      }
    }
  }
  
  public boolean dispatchDragEvent(DragEvent paramDragEvent)
  {
    if (isTransitioning) {
      return true;
    }
    return super.dispatchDragEvent(paramDragEvent);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if (isTransitioning) {
      return true;
    }
    return super.dispatchKeyEvent(paramKeyEvent);
  }
  
  public boolean dispatchKeyEventPreIme(KeyEvent paramKeyEvent)
  {
    if (isTransitioning) {
      return true;
    }
    return super.dispatchKeyEventPreIme(paramKeyEvent);
  }
  
  public boolean dispatchKeyShortcutEvent(KeyEvent paramKeyEvent)
  {
    if (isTransitioning) {
      return true;
    }
    return super.dispatchKeyShortcutEvent(paramKeyEvent);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (isTransitioning) {
      return true;
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public boolean dispatchTrackballEvent(MotionEvent paramMotionEvent)
  {
    if (isTransitioning) {
      return true;
    }
    return super.dispatchTrackballEvent(paramMotionEvent);
  }
  
  Scoop getActiveScoop(RouteChange paramRouteChange)
  {
    Scoop localScoop1 = Scoop.fromView(this);
    Scoop localScoop2 = Scoop.fromView(active);
    return getScreenScooper().create(localScoop1, localScoop2, fromPath, toPath);
  }
  
  protected LayoutInflater getLayoutInflater()
  {
    return new LayoutInflater();
  }
  
  protected ScreenScooper getScreenScooper()
  {
    return new ScreenScooper(new ScreenScoopFactory());
  }
  
  protected ViewControllerInflater getViewControllerInflater()
  {
    return new ViewControllerInflater();
  }
  
  public void goTo(RouteChange paramRouteChange)
  {
    if (screenSwapQueue.isEmpty())
    {
      screenSwapQueue.add(paramRouteChange);
      swap(paramRouteChange);
      return;
    }
    screenSwapQueue.add(paramRouteChange);
  }
  
  public boolean onBack()
  {
    return childCanGoBack();
  }
  
  public void onTransitionCompleted()
  {
    getTransitionListener().onTransitionCompleted();
    isTransitioning = false;
    if (!screenSwapQueue.isEmpty())
    {
      screenSwapQueue.pop();
      if (!screenSwapQueue.isEmpty()) {
        swap((RouteChange)screenSwapQueue.peek());
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.lyft.scoop.UiContainer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */