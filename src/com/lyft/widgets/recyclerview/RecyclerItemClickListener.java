package com.lyft.widgets.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.SimpleOnItemTouchListener;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import com.jakewharton.rxrelay.PublishRelay;
import rx.Observable;

public class RecyclerItemClickListener
  extends RecyclerView.SimpleOnItemTouchListener
{
  private static final GestureDetector.OnGestureListener RETURN_TRUE_GESTURE_LISTENER = new GestureDetector.SimpleOnGestureListener()
  {
    public boolean onSingleTapUp(MotionEvent paramAnonymousMotionEvent)
    {
      return true;
    }
  };
  final GestureDetector gestureDetector;
  final PublishRelay<Integer> subject = PublishRelay.create();
  
  public RecyclerItemClickListener(Context paramContext)
  {
    gestureDetector = new GestureDetector(paramContext, RETURN_TRUE_GESTURE_LISTENER);
  }
  
  public Observable<Integer> observeClickEvents()
  {
    return subject.asObservable();
  }
  
  public boolean onInterceptTouchEvent(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent)
  {
    View localView = paramRecyclerView.findChildViewUnder(paramMotionEvent.getX(), paramMotionEvent.getY());
    if ((localView != null) && (gestureDetector.onTouchEvent(paramMotionEvent)))
    {
      int i = paramRecyclerView.getChildAdapterPosition(localView);
      subject.call(Integer.valueOf(i));
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     com.lyft.widgets.recyclerview.RecyclerItemClickListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */