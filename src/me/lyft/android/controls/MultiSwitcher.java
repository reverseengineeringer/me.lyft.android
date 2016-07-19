package me.lyft.android.controls;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import butterknife.ButterKnife;
import com.lyft.widgets.ISwitcherItem;
import com.lyft.widgets.SimpleAnimationListener;
import com.lyft.widgets.SwitcherSelection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import me.lyft.android.common.Objects;
import me.lyft.android.common.Unit;
import rx.Observable;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Actions;
import rx.subjects.PublishSubject;

public abstract class MultiSwitcher<E extends ISwitcherItem>
  extends RelativeLayout
{
  private static final float THUMB_SLIDING_DURATION = 200.0F;
  private PublishSubject<Unit> animationFinishedSubject = PublishSubject.create();
  private GestureDetector gestureDetector;
  private boolean isCurrentItemDragged = false;
  private boolean isSelectionAnimationInProgress = false;
  private boolean isUserAction = false;
  private int itemWidth;
  private final List<E> items = new ArrayList(3);
  LinearLayout itemsPlaceHolder;
  private int lastTouchedThumbIndex;
  private LayoutInflater layoutInflater;
  private Action1<E> previewChangeListener = Actions.empty();
  private PublishSubject<E> previewChangedSubject = PublishSubject.create();
  private int previewItemIndex = 0;
  private int selectedItemIndex = 0;
  private Action1<SwitcherSelection<E>> selectionChangeListener = Actions.empty();
  private PublishSubject<SwitcherSelection<E>> selectionChangedSubject = PublishSubject.create();
  private boolean sizeMeasured;
  private ValueAnimator thumbAnimator;
  private Action0 thumbClickListener = Actions.empty();
  private PublishSubject<Unit> thumbClickSubject = PublishSubject.create();
  ViewGroup thumbView;
  private View.OnTouchListener thumbViewTouchListener = new View.OnTouchListener()
  {
    public float lastTouchX;
    
    public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
    {
      switch (paramAnonymousMotionEvent.getActionMasked())
      {
      }
      for (;;)
      {
        return gestureDetector.onTouchEvent(paramAnonymousMotionEvent);
        MultiSwitcher.access$102(MultiSwitcher.this, MultiSwitcher.this.getCurrentItemIndex());
        lastTouchX = paramAnonymousMotionEvent.getX();
        MultiSwitcher.this.clearThumbAnimation();
        continue;
        float f1 = lastTouchX;
        float f2 = paramAnonymousMotionEvent.getX();
        f2 = MultiSwitcher.this.getThumbTranslationX() - (f1 - f2);
        f1 = f2;
        if (f2 <= 0.0F) {
          f1 = 0.0F;
        }
        f2 = f1;
        if (f1 >= MultiSwitcher.this.getMaxTranslationX()) {
          f2 = MultiSwitcher.this.getMaxTranslationX();
        }
        if (f2 >= 0.0F) {
          MultiSwitcher.this.setThumbTranslationX((int)f2);
        }
        MultiSwitcher.access$802(MultiSwitcher.this, true);
        MultiSwitcher.this.checkIfPreviewItemChanged();
        continue;
        MultiSwitcher.access$1002(MultiSwitcher.this, true);
        MultiSwitcher.access$802(MultiSwitcher.this, false);
        animateToItemIndex(MultiSwitcher.this.getCurrentItemIndex());
      }
    }
  };
  private int width;
  
  public MultiSwitcher(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public MultiSwitcher(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public MultiSwitcher(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void animateTo(int paramInt)
  {
    int i = paramInt * itemWidth;
    if (paramInt == items.size() - 1) {
      i = width - itemWidth;
    }
    clearThumbAnimation();
    thumbAnimator = createThumbAnimator(i);
    thumbAnimator.start();
  }
  
  private void checkIfPreviewItemChanged()
  {
    if (isSelectionAnimationInProgress) {}
    for (int i = selectedItemIndex;; i = getCurrentItemIndex())
    {
      setPreviewItemIndex(i);
      return;
    }
  }
  
  private void clearThumbAnimation()
  {
    if (thumbAnimator != null)
    {
      thumbAnimator.removeAllListeners();
      thumbAnimator.cancel();
    }
  }
  
  private ValueAnimator createThumbAnimator(int paramInt)
  {
    int i = getThumbTranslationX();
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(thumbView, "translationX", new float[] { paramInt });
    localObjectAnimator.setDuration((200.0F * Math.abs(i - paramInt) / itemWidth));
    localObjectAnimator.addListener(new SimpleAnimationListener()
    {
      public void onAnimationCancel(Animator paramAnonymousAnimator)
      {
        super.onAnimationCancel(paramAnonymousAnimator);
        MultiSwitcher.access$1202(MultiSwitcher.this, false);
        animationFinishedSubject.onNext(Unit.create());
      }
      
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        super.onAnimationEnd(paramAnonymousAnimator);
        MultiSwitcher.access$1202(MultiSwitcher.this, false);
        animationFinishedSubject.onNext(Unit.create());
        updateThumb();
      }
    });
    return localObjectAnimator;
  }
  
  private int getCurrentItemIndex()
  {
    float f = getThumbTranslationX();
    return (int)((itemWidth / 2 + f) / itemWidth);
  }
  
  private int getMaxTranslationX()
  {
    return width - itemWidth;
  }
  
  private RelativeLayout.LayoutParams getThumViewLayoutParams()
  {
    return (RelativeLayout.LayoutParams)thumbView.getLayoutParams();
  }
  
  private int getThumbTranslationX()
  {
    return (int)thumbView.getTranslationX();
  }
  
  private void initThumb()
  {
    RelativeLayout.LayoutParams localLayoutParams = getThumViewLayoutParams();
    width = itemWidth;
    thumbView.setLayoutParams(localLayoutParams);
    slideTo(selectedItemIndex);
  }
  
  private void initializeSubViews()
  {
    if (items.size() > 0)
    {
      itemWidth = (width / items.size());
      itemsPlaceHolder.post(new Runnable()
      {
        public void run()
        {
          if (!isCurrentItemDragged)
          {
            MultiSwitcher.this.initThumb();
            updateThumb();
          }
          itemsPlaceHolder.removeAllViews();
          final int i = 0;
          Iterator localIterator = items.iterator();
          while (localIterator.hasNext())
          {
            ISwitcherItem localISwitcherItem = (ISwitcherItem)localIterator.next();
            View localView = createSwitcherItem(layoutInflater, localISwitcherItem);
            bindSwitcherItem(localView, localISwitcherItem);
            localView.setOnClickListener(new View.OnClickListener()
            {
              public void onClick(View paramAnonymous2View)
              {
                MultiSwitcher.access$1002(MultiSwitcher.this, true);
                animateToItemIndex(i);
              }
            });
            itemsPlaceHolder.addView(localView, new LinearLayout.LayoutParams(itemWidth, -1));
            i += 1;
          }
        }
      });
    }
  }
  
  private void setPreviewItemIndex(int paramInt)
  {
    if (previewItemIndex != paramInt)
    {
      previewItemIndex = paramInt;
      updateThumb();
      ISwitcherItem localISwitcherItem = getPreviewItem();
      if (localISwitcherItem != null)
      {
        previewChangedSubject.onNext(localISwitcherItem);
        previewChangeListener.call(localISwitcherItem);
      }
    }
  }
  
  private void setSelectedIndex(int paramInt)
  {
    if (selectedItemIndex != paramInt)
    {
      selectedItemIndex = paramInt;
      final ISwitcherItem localISwitcherItem = getSelectedItem();
      if (localISwitcherItem != null)
      {
        final boolean bool = isUserAction;
        isUserAction = false;
        animationFinishedSubject.first().subscribe(new Action1()
        {
          public void call(Unit paramAnonymousUnit)
          {
            paramAnonymousUnit = new SwitcherSelection(localISwitcherItem, bool);
            selectionChangedSubject.onNext(paramAnonymousUnit);
            selectionChangeListener.call(paramAnonymousUnit);
          }
        });
      }
      setPreviewItemIndex(paramInt);
    }
  }
  
  private void setThumbTranslationX(int paramInt)
  {
    thumbView.setTranslationX(paramInt);
  }
  
  private void slideTo(int paramInt)
  {
    int i = paramInt * itemWidth;
    if (paramInt == items.size() - 1) {
      i = width - itemWidth;
    }
    setThumbTranslationX(i);
  }
  
  public boolean animateThumbToItemId(String paramString)
  {
    if (isCurrentItemDragged) {
      return false;
    }
    int i = 0;
    while (i < items.size())
    {
      if (Objects.equals(((ISwitcherItem)items.get(i)).getId(), paramString))
      {
        animateToItemIndex(i);
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  protected void animateToItemIndex(int paramInt)
  {
    isSelectionAnimationInProgress = true;
    setSelectedIndex(paramInt);
    updateThumb();
    animateTo(paramInt);
  }
  
  protected abstract void bindSwitcherItem(View paramView, E paramE);
  
  protected abstract View createMultiSwitcherView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup);
  
  protected abstract View createSwitcherItem(LayoutInflater paramLayoutInflater, E paramE);
  
  protected abstract View createThumb(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup);
  
  public E getPreviewItem()
  {
    if (previewItemIndex < items.size()) {
      return (ISwitcherItem)items.get(previewItemIndex);
    }
    return null;
  }
  
  public E getSelectedItem()
  {
    if ((selectedItemIndex >= 0) && (selectedItemIndex < items.size())) {
      return (ISwitcherItem)items.get(selectedItemIndex);
    }
    return null;
  }
  
  public String getSelectedItemId()
  {
    ISwitcherItem localISwitcherItem = getSelectedItem();
    if (localISwitcherItem != null) {
      return localISwitcherItem.getId();
    }
    return null;
  }
  
  public View getThumbViewAt(int paramInt)
  {
    return itemsPlaceHolder.getChildAt(paramInt);
  }
  
  protected void init()
  {
    if (isInEditMode()) {
      return;
    }
    layoutInflater = LayoutInflater.from(getContext());
    ButterKnife.bind(this, createMultiSwitcherView(layoutInflater, this));
    createThumb(layoutInflater, thumbView);
    thumbView.setOnTouchListener(thumbViewTouchListener);
    gestureDetector = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener()
    {
      public boolean onSingleTapUp(MotionEvent paramAnonymousMotionEvent)
      {
        if (MultiSwitcher.this.getCurrentItemIndex() == lastTouchedThumbIndex)
        {
          thumbClickSubject.onNext(Unit.create());
          thumbClickListener.call();
        }
        return false;
      }
    });
  }
  
  public boolean isVisible()
  {
    return getVisibility() == 0;
  }
  
  public boolean moveThumbToItemId(String paramString)
  {
    if (isCurrentItemDragged) {
      return false;
    }
    int i = 0;
    while (i < items.size())
    {
      if (Objects.equals(((ISwitcherItem)items.get(i)).getId(), paramString))
      {
        moveToIndex(i);
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  protected void moveToIndex(int paramInt)
  {
    slideTo(paramInt);
    updateThumb();
    setSelectedIndex(paramInt);
  }
  
  public Observable<E> observePreviewChanges()
  {
    return previewChangedSubject.asObservable();
  }
  
  public Observable<SwitcherSelection<E>> observeSelectionChanges()
  {
    return selectionChangedSubject.asObservable();
  }
  
  public Observable<Unit> observeThumbClick()
  {
    return thumbClickSubject.asObservable();
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    width = paramInt1;
    sizeMeasured = true;
    initializeSubViews();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public void setItems(List<E> paramList)
  {
    if (!items.equals(paramList))
    {
      items.clear();
      items.addAll(paramList);
      if (sizeMeasured) {
        initializeSubViews();
      }
    }
  }
  
  protected void updateThumb()
  {
    if ((items.size() > 0) && (previewItemIndex < items.size())) {
      updateThumbViewToIndex((ISwitcherItem)items.get(previewItemIndex), thumbView);
    }
  }
  
  protected abstract void updateThumbViewToIndex(E paramE, ViewGroup paramViewGroup);
}

/* Location:
 * Qualified Name:     me.lyft.android.controls.MultiSwitcher
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */