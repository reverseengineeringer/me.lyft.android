package me.lyft.android.controls;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import butterknife.ButterKnife;
import com.lyft.scoop.Scoop;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import me.lyft.android.TrackableView;
import rx.Observable;
import rx.subjects.PublishSubject;

public class HorizontalCarouselView
  extends HorizontalScrollView
{
  private static final double MIN_SCROLL_PERCENTAGE_THRESHOLD = 0.25D;
  private static final int SWIPE_THRESHOLD_VELOCITY = 300;
  LinearLayout containerView;
  private int currentVisibleViewIndex = 0;
  private GestureDetector flingGestureDetector;
  PublishSubject<Integer> onCarouselScrollToIndexSubject = PublishSubject.create();
  private List<View> views = new ArrayList();
  
  public HorizontalCarouselView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initialize();
  }
  
  private int getNextIndex()
  {
    if (currentVisibleViewIndex == views.size() - 1) {
      return currentVisibleViewIndex;
    }
    return currentVisibleViewIndex + 1;
  }
  
  private int getPreviousIndex()
  {
    if (currentVisibleViewIndex == 0) {
      return currentVisibleViewIndex;
    }
    return currentVisibleViewIndex - 1;
  }
  
  private void initialize()
  {
    Scoop.fromView(this).inflater(getContext()).inflate(2130903249, this, true);
    ButterKnife.bind(this);
    setOnTouchListener(new View.OnTouchListener()
    {
      float lastXPosition = 0.0F;
      
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        if (flingGestureDetector.onTouchEvent(paramAnonymousMotionEvent)) {
          return true;
        }
        switch (paramAnonymousMotionEvent.getAction())
        {
        case 2: 
        default: 
        case 0: 
          for (;;)
          {
            return false;
            lastXPosition = paramAnonymousMotionEvent.getX();
          }
        }
        if (HorizontalCarouselView.this.isSwipeToNext(lastXPosition, paramAnonymousMotionEvent.getX()))
        {
          HorizontalCarouselView.this.scrollToIndex(HorizontalCarouselView.access$200(HorizontalCarouselView.this));
          return true;
        }
        if (HorizontalCarouselView.this.isSwipeToPrevious(lastXPosition, paramAnonymousMotionEvent.getX()))
        {
          HorizontalCarouselView.this.scrollToIndex(HorizontalCarouselView.access$500(HorizontalCarouselView.this));
          return true;
        }
        HorizontalCarouselView.this.scrollToIndex(currentVisibleViewIndex);
        return true;
      }
    });
    flingGestureDetector = new FlingGestureDetector();
  }
  
  private boolean isFlingToNext(float paramFloat)
  {
    return (paramFloat < 0.0F) && (Math.abs(paramFloat) > 300.0F);
  }
  
  private boolean isFlingToPrevious(float paramFloat)
  {
    return (paramFloat > 0.0F) && (Math.abs(paramFloat) > 300.0F);
  }
  
  private boolean isSwipeToNext(float paramFloat1, float paramFloat2)
  {
    return paramFloat1 - paramFloat2 > getWidth() * 0.25D;
  }
  
  private boolean isSwipeToPrevious(float paramFloat1, float paramFloat2)
  {
    return paramFloat2 - paramFloat1 > getWidth() * 0.25D;
  }
  
  private void scrollToIndex(int paramInt)
  {
    if (views.isEmpty()) {
      return;
    }
    View localView = (View)views.get(paramInt);
    if ((localView instanceof TrackableView)) {
      ((TrackableView)localView).trackVisible();
    }
    currentVisibleViewIndex = paramInt;
    smoothScrollTo((int)(localView.getX() - (getWidth() - localView.getWidth()) / 2), 0);
    onCarouselScrollToIndexSubject.onNext(Integer.valueOf(paramInt));
  }
  
  public void addItem(View paramView)
  {
    views.add(paramView);
    containerView.addView(paramView, views.size());
  }
  
  public void addItems(List<View> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      addItem((View)paramList.next());
    }
  }
  
  public void clearItems()
  {
    Iterator localIterator = views.iterator();
    while (localIterator.hasNext())
    {
      View localView = (View)localIterator.next();
      containerView.removeView(localView);
    }
    views.clear();
  }
  
  public Observable<Integer> observeOnCarouselScrollToIndex()
  {
    return onCarouselScrollToIndexSubject.asObservable();
  }
  
  class FlingGestureDetector
    extends GestureDetector
  {
    public FlingGestureDetector()
    {
      super()
      {
        public boolean onFling(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
        {
          if ((paramAnonymousMotionEvent1 == null) || (paramAnonymousMotionEvent2 == null)) {
            return true;
          }
          paramAnonymousFloat2 = paramAnonymousMotionEvent1.getX();
          float f = paramAnonymousMotionEvent2.getX();
          if ((HorizontalCarouselView.FlingGestureDetector.this.isSwipeToNext(paramAnonymousFloat2, f)) || (HorizontalCarouselView.FlingGestureDetector.this.isFlingToNext(paramAnonymousFloat1)))
          {
            HorizontalCarouselView.FlingGestureDetector.this.scrollToIndex(HorizontalCarouselView.access$200(HorizontalCarouselView.FlingGestureDetector.this));
            return true;
          }
          if ((HorizontalCarouselView.FlingGestureDetector.this.isSwipeToPrevious(paramAnonymousFloat2, f)) || (HorizontalCarouselView.FlingGestureDetector.this.isFlingToPrevious(paramAnonymousFloat1)))
          {
            HorizontalCarouselView.FlingGestureDetector.this.scrollToIndex(HorizontalCarouselView.access$500(HorizontalCarouselView.FlingGestureDetector.this));
            return true;
          }
          return false;
        }
      };
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.controls.HorizontalCarouselView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */