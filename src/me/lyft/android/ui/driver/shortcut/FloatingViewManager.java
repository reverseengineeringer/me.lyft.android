package me.lyft.android.ui.driver.shortcut;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Vibrator;
import android.support.v4.view.GestureDetectorCompat;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import java.util.ArrayList;
import java.util.Iterator;

public class FloatingViewManager
  implements View.OnTouchListener, ActionViewListener, ScreenChangedListener
{
  public static final int DISPLAY_MODE_HIDE_ALWAYS = 2;
  public static final int DISPLAY_MODE_HIDE_FULLSCREEN = 3;
  public static final int DISPLAY_MODE_SHOW_ALWAYS = 1;
  public static final int MOVE_DIRECTION_DEFAULT = 0;
  public static final int MOVE_DIRECTION_LEFT = 1;
  public static final int MOVE_DIRECTION_NONE = 3;
  public static final int MOVE_DIRECTION_RIGHT = 2;
  public static final float SHAPE_CIRCLE = 1.0F;
  private static final long VIBRATE_INTERSECTS_MILLIS = 15L;
  private final TrashView actionView;
  private final Rect actionViewRect;
  private final Context context;
  private int displayMode;
  private float extraCenterY = 0.0F;
  private final ArrayList<FloatingView> floatingViewList;
  private final FloatingViewListener floatingViewListener;
  private final Rect floatingViewRect;
  private final FullscreenObserverView fullscreenObserverView;
  private boolean isMoveAccept;
  private final ModeToggleView modeToggleView;
  private final Rect modeToggleViewRect;
  private final GestureDetectorCompat singleTouchGestureDetector;
  private GestureDetector.SimpleOnGestureListener singleTouchGestureListener = new FloatingViewManager.1(this);
  private FloatingView targetFloatingView;
  private final Vibrator vibrator;
  private final WindowManager windowManager;
  
  public FloatingViewManager(Context paramContext, FloatingViewListener paramFloatingViewListener)
  {
    context = paramContext;
    windowManager = ((WindowManager)paramContext.getSystemService("window"));
    floatingViewListener = paramFloatingViewListener;
    floatingViewRect = new Rect();
    actionViewRect = new Rect();
    modeToggleViewRect = new Rect();
    vibrator = ((Vibrator)paramContext.getSystemService("vibrator"));
    isMoveAccept = false;
    displayMode = 3;
    floatingViewList = new ArrayList();
    fullscreenObserverView = new FullscreenObserverView(paramContext, this);
    actionView = new TrashView(paramContext);
    modeToggleView = new ModeToggleView(paramContext);
    actionView.setToggleBackgroundColor(2131492905);
    modeToggleView.setToggleBackgroundColor(2131493067);
    singleTouchGestureDetector = new GestureDetectorCompat(actionView.getContext(), singleTouchGestureListener);
  }
  
  private void actionEventFinish(int paramInt1, int paramInt2, MotionEvent paramMotionEvent, ActionView paramActionView)
  {
    if (paramInt1 == paramInt2)
    {
      paramActionView.onTouchFloatingView(paramMotionEvent, floatingViewRect.left, floatingViewRect.top);
      return;
    }
    WindowManager.LayoutParams localLayoutParams = targetFloatingView.getWindowLayoutParams();
    paramActionView.onTouchFloatingView(paramMotionEvent, x, y);
  }
  
  private void actionUpAction(int paramInt1, int paramInt2, ActionView paramActionView)
  {
    if (paramInt1 == paramInt2)
    {
      targetFloatingView.setFinishing();
      paramActionView.setScaleActionIcon(false);
      floatingViewListener.onTrashActionUp();
    }
    isMoveAccept = false;
  }
  
  private void actionUpModeToggle(int paramInt1, int paramInt2, ActionView paramActionView)
  {
    if (paramInt1 == paramInt2)
    {
      targetFloatingView.setFinishing();
      paramActionView.setScaleActionIcon(false);
      floatingViewListener.onModeToggleActionUp();
    }
    isMoveAccept = false;
  }
  
  private boolean getWindowDrawingRectPadding(ActionView paramActionView, Rect paramRect, int paramInt)
  {
    if (!paramActionView.isEnabled()) {
      return false;
    }
    paramActionView.getWindowDrawingRect(paramRect, paramInt);
    targetFloatingView.getWindowDrawingRect(floatingViewRect);
    return Rect.intersects(paramRect, floatingViewRect);
  }
  
  private boolean isCloseToActionView(ActionView paramActionView, Rect paramRect)
  {
    return getWindowDrawingRectPadding(paramActionView, paramRect, (int)targetFloatingView.getResources().getDimension(2131230873));
  }
  
  private boolean isIntersectWithActionView(ActionView paramActionView, Rect paramRect)
  {
    return getWindowDrawingRectPadding(paramActionView, paramRect, 0);
  }
  
  private void removeViewToWindow(FloatingView paramFloatingView)
  {
    int i = floatingViewList.indexOf(paramFloatingView);
    if (i != -1)
    {
      windowManager.removeViewImmediate(paramFloatingView);
      floatingViewList.remove(i);
    }
    if ((floatingViewList.isEmpty()) && (floatingViewListener != null)) {
      floatingViewListener.onFinishFloatingView();
    }
  }
  
  private void scaleIfNecessary(boolean paramBoolean1, boolean paramBoolean2, ActionView paramActionView)
  {
    if ((paramBoolean1) && (!paramBoolean2))
    {
      vibrator.vibrate(15L);
      paramActionView.setScaleActionIcon(true);
    }
    while ((paramBoolean1) || (!paramBoolean2)) {
      return;
    }
    targetFloatingView.setNormal();
    paramActionView.setScaleActionIcon(false);
  }
  
  private void tryShowFloatingTextView(ActionView paramActionView, Rect paramRect)
  {
    if (isCloseToActionView(paramActionView, paramRect))
    {
      paramActionView.showFloatingTextView();
      return;
    }
    paramActionView.hideFloatingTextView();
  }
  
  @Deprecated
  public void addViewToWindow(View paramView, float paramFloat, int paramInt)
  {
    Options localOptions = new Options();
    shape = paramFloat;
    overMargin = paramInt;
    addViewToWindow(paramView, localOptions);
  }
  
  public void addViewToWindow(View paramView, Options paramOptions)
  {
    boolean bool = floatingViewList.isEmpty();
    FloatingView localFloatingView = new FloatingView(context);
    localFloatingView.setInitCoords(floatingViewX, floatingViewY);
    localFloatingView.setOnTouchListener(this);
    localFloatingView.setShape(shape);
    localFloatingView.setOverMargin(overMargin);
    localFloatingView.setMoveDirection(moveDirection);
    localFloatingView.getViewTreeObserver().addOnPreDrawListener(new FloatingViewManager.2(this, localFloatingView));
    localFloatingView.addView(paramView);
    if (displayMode == 2) {
      localFloatingView.setVisibility(8);
    }
    floatingViewList.add(localFloatingView);
    actionView.setActionViewListener(this);
    modeToggleView.setActionViewListener(this);
    if (!bool)
    {
      windowManager.removeViewImmediate(actionView);
      windowManager.removeViewImmediate(modeToggleView);
    }
    windowManager.addView(actionView, actionView.getWindowLayoutParams());
    windowManager.addView(modeToggleView, modeToggleView.getWindowLayoutParams());
    windowManager.addView(localFloatingView, localFloatingView.getWindowLayoutParams());
    if (bool)
    {
      windowManager.addView(fullscreenObserverView, fullscreenObserverView.getWindowLayoutParams());
      targetFloatingView = localFloatingView;
    }
  }
  
  public boolean isActionViewEnabled()
  {
    return actionView.isEnabled();
  }
  
  public boolean isModeToggleViewEnabled()
  {
    return modeToggleView.isEnabled();
  }
  
  public void onActionAnimationEnd(int paramInt)
  {
    if (targetFloatingView.getState() == 2) {
      removeViewToWindow(targetFloatingView);
    }
    int i = floatingViewList.size();
    paramInt = 0;
    while (paramInt < i)
    {
      ((FloatingView)floatingViewList.get(paramInt)).setDraggable(true);
      paramInt += 1;
    }
  }
  
  public void onActionAnimationStarted(int paramInt)
  {
    if ((paramInt == 2) || (paramInt == 3))
    {
      int i = floatingViewList.size();
      paramInt = 0;
      while (paramInt < i)
      {
        ((FloatingView)floatingViewList.get(paramInt)).setDraggable(false);
        paramInt += 1;
      }
    }
  }
  
  public void onScreenChanged(boolean paramBoolean)
  {
    if (displayMode != 3) {}
    int i;
    do
    {
      return;
      isMoveAccept = false;
      i = targetFloatingView.getState();
      if (i == 0)
      {
        int k = floatingViewList.size();
        i = 0;
        if (i < k)
        {
          FloatingView localFloatingView = (FloatingView)floatingViewList.get(i);
          if (paramBoolean) {}
          for (int j = 8;; j = 0)
          {
            localFloatingView.setVisibility(j);
            i += 1;
            break;
          }
        }
        actionView.dismiss();
        modeToggleView.dismiss();
        return;
      }
    } while (i != 1);
    targetFloatingView.setFinishing();
    actionView.dismiss();
    modeToggleView.dismiss();
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if ((i != 0) && (!isMoveAccept)) {
      return false;
    }
    if (singleTouchGestureDetector.onTouchEvent(paramMotionEvent)) {
      return true;
    }
    int j = targetFloatingView.getState();
    targetFloatingView = ((FloatingView)paramView);
    if (i == 0) {
      isMoveAccept = true;
    }
    for (;;)
    {
      actionEventFinish(j, 1, paramMotionEvent, actionView);
      actionEventFinish(j, 3, paramMotionEvent, modeToggleView);
      tryShowFloatingTextView(actionView, actionViewRect);
      tryShowFloatingTextView(modeToggleView, modeToggleViewRect);
      return false;
      if (i == 2)
      {
        boolean bool3 = isIntersectWithActionView(actionView, actionViewRect);
        boolean bool4 = isIntersectWithActionView(modeToggleView, modeToggleViewRect);
        boolean bool1;
        if (j == 1)
        {
          bool1 = true;
          label149:
          if (j != 3) {
            break label251;
          }
        }
        label251:
        for (boolean bool2 = true;; bool2 = false)
        {
          if (bool3) {
            targetFloatingView.setIntersectingTrash((int)actionView.getActionIconCenterX(), (int)actionView.getActionIconCenterY(), extraCenterY);
          }
          if (bool4) {
            targetFloatingView.setIntersectingModeToggle((int)modeToggleView.getActionIconCenterX(), (int)modeToggleView.getActionIconCenterY());
          }
          scaleIfNecessary(bool3, bool1, actionView);
          scaleIfNecessary(bool4, bool2, modeToggleView);
          break;
          bool1 = false;
          break label149;
        }
      }
      if ((i == 1) || (i == 3))
      {
        actionUpAction(j, 1, actionView);
        actionUpModeToggle(j, 3, modeToggleView);
      }
    }
  }
  
  public void removeAllViewToWindow()
  {
    windowManager.removeViewImmediate(fullscreenObserverView);
    windowManager.removeViewImmediate(actionView);
    windowManager.removeViewImmediate(modeToggleView);
    int j = floatingViewList.size();
    int i = 0;
    while (i < j)
    {
      FloatingView localFloatingView = (FloatingView)floatingViewList.get(i);
      windowManager.removeViewImmediate(localFloatingView);
      i += 1;
    }
    floatingViewList.clear();
  }
  
  public void setActionModeToggleIconImage(Drawable paramDrawable)
  {
    modeToggleView.setActionActionIconImage(paramDrawable);
  }
  
  public void setActionViewEnabled(boolean paramBoolean)
  {
    actionView.setActionEnabled(paramBoolean);
  }
  
  public void setActionViewIconImage(Drawable paramDrawable)
  {
    actionView.setActionActionIconImage(paramDrawable);
  }
  
  public void setDisplayMode(int paramInt)
  {
    displayMode = paramInt;
    Iterator localIterator;
    if ((displayMode == 1) || (displayMode == 3)) {
      localIterator = floatingViewList.iterator();
    }
    while (localIterator.hasNext())
    {
      ((FloatingView)localIterator.next()).setVisibility(0);
      continue;
      if (displayMode == 2)
      {
        localIterator = floatingViewList.iterator();
        while (localIterator.hasNext()) {
          ((FloatingView)localIterator.next()).setVisibility(8);
        }
        actionView.dismiss();
        modeToggleView.dismiss();
      }
    }
  }
  
  public void setExtraCenterY(float paramFloat)
  {
    extraCenterY = paramFloat;
  }
  
  public void setFixedActionIconImage(int paramInt)
  {
    actionView.setFixedActionIconImage(paramInt);
  }
  
  public void setFixedActionIconImage(Drawable paramDrawable)
  {
    actionView.setFixedActionIconImage(paramDrawable);
  }
  
  public void setModeToggleViewEnabled(boolean paramBoolean)
  {
    modeToggleView.setActionEnabled(paramBoolean);
  }
  
  public void setModeToggleViewIcon(int paramInt)
  {
    modeToggleView.setActionActionIconImage(paramInt);
  }
  
  public void setTrashViewIcon(int paramInt)
  {
    actionView.setActionActionIconImage(paramInt);
  }
  
  public void updateModeToggleView(int paramInt, String paramString)
  {
    modeToggleView.setFixedActionIconImage(paramInt);
    modeToggleView.setFloatingViewText(paramString);
  }
  
  public void updateModeToggleView(Drawable paramDrawable)
  {
    modeToggleView.setFixedActionIconImage(paramDrawable);
  }
  
  public static class Options
  {
    public int floatingViewX = Integer.MIN_VALUE;
    public int floatingViewY = Integer.MIN_VALUE;
    public int moveDirection = 0;
    public int overMargin = 0;
    public float shape = 1.0F;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.driver.shortcut.FloatingViewManager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */