package com.lyft.widgets;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import me.lyft.android.common.Unit;
import rx.Observable;
import rx.Subscription;
import rx.functions.Action1;
import rx.subjects.BehaviorSubject;
import rx.subjects.PublishSubject;
import rx.subscriptions.Subscriptions;

public class Toggle
  extends FrameLayout
{
  private boolean checked;
  private PublishSubject<Boolean> checkedSubject = PublishSubject.create();
  private View fill;
  private View handle;
  private Subscription measureSubscription = Subscriptions.empty();
  View.OnTouchListener onHandleTouchListener = new View.OnTouchListener()
  {
    private final int TAP_DRAG_THRESHOLD = 10;
    private float touchDownX;
    
    public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
    {
      boolean bool2 = false;
      boolean bool1 = false;
      if (paramAnonymousMotionEvent.getAction() == 0)
      {
        getParent().requestDisallowInterceptTouchEvent(true);
        touchDownX = paramAnonymousMotionEvent.getX();
      }
      for (;;)
      {
        bool1 = true;
        do
        {
          return bool1;
          if (paramAnonymousMotionEvent.getAction() == 2)
          {
            float f2 = paramAnonymousView.getTranslationX() + paramAnonymousMotionEvent.getX() - touchDownX;
            float f1;
            if (f2 < 0.0F) {
              f1 = 0.0F;
            }
            for (;;)
            {
              Toggle.this.setHandlePosition((int)f1);
              break;
              f1 = f2;
              if (f2 > track.getWidth() - handle.getWidth()) {
                f1 = track.getWidth() - handle.getWidth();
              }
            }
          }
        } while (paramAnonymousMotionEvent.getAction() != 1);
        if (Math.abs(paramAnonymousMotionEvent.getX() - touchDownX) < 10.0F)
        {
          paramAnonymousView = Toggle.this;
          bool1 = bool2;
          if (!checked) {
            bool1 = true;
          }
          paramAnonymousView.setChecked(bool1, true);
        }
        else
        {
          Toggle.this.snapHandleToNearestState();
        }
      }
    }
  };
  View.OnTouchListener onTrackTouchListenser = new View.OnTouchListener()
  {
    public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
    {
      boolean bool = false;
      if (paramAnonymousMotionEvent.getAction() == 0)
      {
        float f = track.getWidth() - handle.getWidth();
        Toggle.this.setHandlePosition((int)f);
      }
      for (;;)
      {
        return true;
        if (paramAnonymousMotionEvent.getAction() != 1) {
          break;
        }
        if (new Rect(paramAnonymousView.getLeft(), paramAnonymousView.getTop(), paramAnonymousView.getRight(), paramAnonymousView.getBottom()).contains(paramAnonymousView.getLeft() + (int)paramAnonymousMotionEvent.getX(), paramAnonymousView.getTop() + (int)paramAnonymousMotionEvent.getY()))
        {
          paramAnonymousView = Toggle.this;
          if (!checked) {
            bool = true;
          }
          paramAnonymousView.setChecked(bool, true);
        }
      }
      setChecked(checked, false);
      return false;
    }
  };
  private Action1<Unit> onViewLengthMeasured = new Action1()
  {
    public void call(Unit paramAnonymousUnit)
    {
      setChecked(isChecked(), true);
    }
  };
  private View track;
  private BehaviorSubject<Unit> viewLengthMeasuredSubject = BehaviorSubject.create();
  
  public Toggle(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    LayoutInflater.from(paramContext).inflate(R.layout.toggle, this, true);
    track = findViewById(R.id.toggle_track);
    fill = findViewById(R.id.toggle_fill);
    handle = findViewById(R.id.toggle_handle);
    measureSubscription = viewLengthMeasuredSubject.first().subscribe(onViewLengthMeasured);
    handle.setOnTouchListener(onHandleTouchListener);
    track.setOnTouchListener(onTrackTouchListenser);
    setChecked(false, false);
  }
  
  private void setHandlePosition(int paramInt)
  {
    handle.setTranslationX(paramInt);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)fill.getLayoutParams();
    width = (handle.getWidth() / 2 + paramInt);
    fill.setLayoutParams(localLayoutParams);
  }
  
  private void snapHandleToNearestState()
  {
    boolean bool = false;
    if (handle.getTranslationX() + handle.getWidth() / 2 > track.getWidth() / 2) {
      bool = true;
    }
    setChecked(bool, true);
  }
  
  public boolean isChecked()
  {
    return checked;
  }
  
  public Observable<Boolean> observeChange()
  {
    return checkedSubject.asObservable();
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    measureSubscription.unsubscribe();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    viewLengthMeasuredSubject.onNext(Unit.create());
  }
  
  public void setChecked(boolean paramBoolean)
  {
    setChecked(paramBoolean, true);
  }
  
  public void setChecked(boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 0;
    if (paramBoolean1) {
      i = track.getWidth() - handle.getWidth();
    }
    setHandlePosition(i);
    if (checked != paramBoolean1) {}
    for (i = 1;; i = 0)
    {
      checked = paramBoolean1;
      if ((paramBoolean2) && (i != 0)) {
        checkedSubject.onNext(Boolean.valueOf(checked));
      }
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.lyft.widgets.Toggle
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */