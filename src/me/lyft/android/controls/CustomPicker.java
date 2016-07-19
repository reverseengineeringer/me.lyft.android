package me.lyft.android.controls;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Scroller;
import android.widget.TextView;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import me.lyft.android.R.styleable;
import me.lyft.android.utils.VersionUtils;

@TargetApi(16)
public class CustomPicker
  extends LinearLayout
{
  private static final int DEFAULT_LAYOUT_RESOURCE_ID = 2130903141;
  private static final long DEFAULT_LONG_PRESS_UPDATE_INTERVAL = 300L;
  private static final char[] DIGIT_CHARACTERS = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 1632, 1633, 1634, 1635, 1636, 1637, 1638, 1639, 1640, 1641, 1776, 1777, 1778, 1779, 1780, 1781, 1782, 1783, 1784, 1785, 2406, 2407, 2408, 2409, 2410, 2411, 2412, 2413, 2414, 2415, 2534, 2535, 2536, 2537, 2538, 2539, 2540, 2541, 2542, 2543, 3302, 3303, 3304, 3305, 3306, 3307, 3308, 3309, 3310, 3311 };
  private static final int SELECTOR_ADJUSTMENT_DURATION_MILLIS = 800;
  private static final int SELECTOR_MAX_FLING_VELOCITY_ADJUSTMENT = 8;
  private static final int SELECTOR_MIDDLE_ITEM_INDEX = 1;
  private static final int SELECTOR_WHEEL_ITEM_COUNT = 3;
  private static final int SIZE_UNSPECIFIED = 200;
  private static final int SNAP_SCROLL_DURATION = 300;
  private static final float TOP_AND_BOTTOM_FADING_EDGE_STRENGTH = 0.9F;
  private static final int UNSCALED_DEFAULT_SELECTION_DIVIDERS_DISTANCE = 52;
  private static final int UNSCALED_DEFAULT_SELECTION_DIVIDER_HEIGHT = 2;
  private AccessibilityNodeProviderImpl mAccessibilityNodeProvider;
  private final Scroller mAdjustScroller;
  private BeginSoftInputOnLongPressCommand mBeginSoftInputOnLongPressCommand;
  private int mBottomSelectionDividerBottom;
  private ChangeCurrentByOneFromLongPressCommand mChangeCurrentByOneFromLongPressCommand;
  private final boolean mComputeMaxWidth;
  private int mCurrentScrollOffset;
  private boolean mDecrementVirtualButtonPressed;
  private String[] mDisplayedValues;
  private final Scroller mFlingScroller;
  private final boolean mHasSelectorWheel;
  private boolean mHideWheelUntilFocused;
  private boolean mIgnoreMoveEvents;
  private boolean mIncrementVirtualButtonPressed;
  private int mInitialScrollOffset = Integer.MIN_VALUE;
  private final TextView mInputText;
  private long mLastDownEventTime;
  private float mLastDownEventY;
  private float mLastDownOrMoveEventY;
  private int mLastHandledDownDpadKeyCode = -1;
  private int mLastHoveredChildVirtualViewId;
  private long mLongPressUpdateInterval = 300L;
  private final int mMaxHeight;
  private int mMaxValue;
  private int mMaxWidth;
  private int mMaximumFlingVelocity;
  private final int mMinHeight;
  private int mMinValue;
  private final int mMinWidth;
  private int mMinimumFlingVelocity;
  private OnScrollListener mOnScrollListener;
  private OnValueChangeListener mOnValueChangeListener;
  private boolean mPerformClickOnTap;
  private final PressedStateHelper mPressedStateHelper;
  private int mPreviousScrollerY;
  private int mScrollState = 0;
  private final Drawable mSelectionDivider;
  private final int mSelectionDividerHeight;
  private final int mSelectionDividersDistance;
  private int mSelectorElementHeight;
  private final SparseArray<String> mSelectorIndexToStringCache = new SparseArray();
  private final int[] mSelectorIndices = new int[3];
  private int mSelectorTextGapHeight;
  private final Paint mSelectorWheelPaint;
  private final int mSolidColor;
  private final int mTextSize;
  private int mTopSelectionDividerTop;
  private int mTouchSlop;
  private int mValue;
  private VelocityTracker mVelocityTracker;
  private final Drawable mVirtualButtonPressedDrawable;
  private boolean mWrapSelectorWheel;
  
  public CustomPicker(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CustomPicker(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, 0);
  }
  
  public CustomPicker(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.CustomPicker, paramInt1, paramInt2);
    paramInt1 = paramAttributeSet.getResourceId(0, 2131230743);
    mHasSelectorWheel = true;
    mHideWheelUntilFocused = false;
    mSolidColor = 0;
    mSelectionDivider = getResources().getDrawable(2130838104);
    mSelectionDividerHeight = ((int)TypedValue.applyDimension(1, 2.0F, getResources().getDisplayMetrics()));
    mSelectionDividersDistance = ((int)TypedValue.applyDimension(1, 52.0F, getResources().getDisplayMetrics()));
    mMinHeight = 200;
    mMaxHeight = 200;
    if (mMinHeight > mMaxHeight) {
      throw new IllegalArgumentException("minHeight > maxHeight");
    }
    mMinWidth = 200;
    mMaxWidth = 200;
    if (mMinWidth > mMaxWidth) {
      throw new IllegalArgumentException("minWidth > maxWidth");
    }
    if (mMaxWidth == 200)
    {
      bool = true;
      mComputeMaxWidth = bool;
      mVirtualButtonPressedDrawable = getResources().getDrawable(2130838104);
      paramAttributeSet.recycle();
      mPressedStateHelper = new PressedStateHelper();
      if (mHasSelectorWheel) {
        break label493;
      }
    }
    label493:
    for (boolean bool = true;; bool = false)
    {
      setWillNotDraw(bool);
      LayoutInflater.from(getContext()).inflate(2130903141, this, true);
      mInputText = ((TextView)findViewById(2131558893));
      mInputText.setTextSize(0, getResources().getDimension(paramInt1));
      paramContext = ViewConfiguration.get(paramContext);
      mTouchSlop = paramContext.getScaledTouchSlop();
      mMinimumFlingVelocity = paramContext.getScaledMinimumFlingVelocity();
      mMaximumFlingVelocity = (paramContext.getScaledMaximumFlingVelocity() / 8);
      mTextSize = ((int)mInputText.getTextSize());
      paramContext = new Paint();
      paramContext.setAntiAlias(true);
      paramContext.setTextAlign(Paint.Align.CENTER);
      paramContext.setTextSize(mTextSize);
      paramContext.setTypeface(mInputText.getTypeface());
      paramContext.setColor(mInputText.getTextColors().getColorForState(ENABLED_STATE_SET, -1));
      mSelectorWheelPaint = paramContext;
      mFlingScroller = new Scroller(getContext(), null, true);
      mAdjustScroller = new Scroller(getContext(), new DecelerateInterpolator(2.5F));
      updateInputTextView();
      if ((VersionUtils.hasJellyBean()) && (getImportantForAccessibility() == 0)) {
        setImportantForAccessibility(1);
      }
      return;
      bool = false;
      break;
    }
  }
  
  public CustomPicker(Context paramContext, String[] paramArrayOfString)
  {
    this(paramContext, (AttributeSet)null);
    mDisplayedValues = paramArrayOfString;
    setMaxValue(paramArrayOfString.length - 1);
  }
  
  private void changeValueByOne(boolean paramBoolean)
  {
    if (mHasSelectorWheel)
    {
      mInputText.setVisibility(4);
      if (!moveToFinalScrollerPosition(mFlingScroller)) {
        moveToFinalScrollerPosition(mAdjustScroller);
      }
      mPreviousScrollerY = 0;
      if (paramBoolean) {
        mFlingScroller.startScroll(0, 0, 0, -mSelectorElementHeight, 300);
      }
      for (;;)
      {
        invalidate();
        return;
        mFlingScroller.startScroll(0, 0, 0, mSelectorElementHeight, 300);
      }
    }
    if (paramBoolean)
    {
      setValueInternal(mValue + 1, true);
      return;
    }
    setValueInternal(mValue - 1, true);
  }
  
  private void decrementSelectorIndices(int[] paramArrayOfInt)
  {
    int i = paramArrayOfInt.length - 1;
    while (i > 0)
    {
      paramArrayOfInt[i] = paramArrayOfInt[(i - 1)];
      i -= 1;
    }
    int j = paramArrayOfInt[1] - 1;
    i = j;
    if (mWrapSelectorWheel)
    {
      i = j;
      if (j < mMinValue) {
        i = mMaxValue;
      }
    }
    paramArrayOfInt[0] = i;
    ensureCachedScrollSelectorValue(i);
  }
  
  private void ensureCachedScrollSelectorValue(int paramInt)
  {
    SparseArray localSparseArray = mSelectorIndexToStringCache;
    if ((String)localSparseArray.get(paramInt) != null) {
      return;
    }
    if ((paramInt < mMinValue) || (paramInt > mMaxValue)) {}
    int i;
    for (String str = "";; str = mDisplayedValues[(paramInt - i)])
    {
      localSparseArray.put(paramInt, str);
      return;
      if (mDisplayedValues == null) {
        break;
      }
      i = mMinValue;
    }
  }
  
  private boolean ensureScrollWheelAdjusted()
  {
    boolean bool = false;
    int j = mInitialScrollOffset - mCurrentScrollOffset;
    if (j != 0)
    {
      mPreviousScrollerY = 0;
      i = j;
      if (Math.abs(j) > mSelectorElementHeight / 2) {
        if (j <= 0) {
          break label72;
        }
      }
    }
    label72:
    for (int i = -mSelectorElementHeight;; i = mSelectorElementHeight)
    {
      i = j + i;
      mAdjustScroller.startScroll(0, 0, 0, i, 800);
      invalidate();
      bool = true;
      return bool;
    }
  }
  
  private void fling(int paramInt)
  {
    mPreviousScrollerY = 0;
    if (paramInt > 0) {
      mFlingScroller.fling(0, 0, 0, paramInt, 0, 0, 0, Integer.MAX_VALUE);
    }
    for (;;)
    {
      invalidate();
      return;
      mFlingScroller.fling(0, Integer.MAX_VALUE, 0, paramInt, 0, 0, 0, Integer.MAX_VALUE);
    }
  }
  
  private static String formatNumberWithLocale(int paramInt)
  {
    return String.format(Locale.getDefault(), "%d", new Object[] { Integer.valueOf(paramInt) });
  }
  
  private int getSelectedPos(String paramString)
  {
    if (mDisplayedValues == null) {}
    try
    {
      i = Integer.parseInt(paramString);
      return i;
    }
    catch (NumberFormatException paramString)
    {
      try
      {
        int i = Integer.parseInt(paramString);
        return i;
      }
      catch (NumberFormatException paramString)
      {
        for (;;) {}
      }
      paramString = paramString;
    }
    i = 0;
    while (i < mDisplayedValues.length)
    {
      paramString = paramString.toLowerCase();
      if (mDisplayedValues[i].toLowerCase().startsWith(paramString)) {
        return mMinValue + i;
      }
      i += 1;
    }
    return mMinValue;
  }
  
  private int getWrappedSelectorIndex(int paramInt)
  {
    int i;
    if (paramInt > mMaxValue) {
      i = mMinValue + (paramInt - mMaxValue) % (mMaxValue - mMinValue) - 1;
    }
    do
    {
      return i;
      i = paramInt;
    } while (paramInt >= mMinValue);
    return mMaxValue - (mMinValue - paramInt) % (mMaxValue - mMinValue) + 1;
  }
  
  private void incrementSelectorIndices(int[] paramArrayOfInt)
  {
    int i = 0;
    while (i < paramArrayOfInt.length - 1)
    {
      paramArrayOfInt[i] = paramArrayOfInt[(i + 1)];
      i += 1;
    }
    int j = paramArrayOfInt[(paramArrayOfInt.length - 2)] + 1;
    i = j;
    if (mWrapSelectorWheel)
    {
      i = j;
      if (j > mMaxValue) {
        i = mMinValue;
      }
    }
    paramArrayOfInt[(paramArrayOfInt.length - 1)] = i;
    ensureCachedScrollSelectorValue(i);
  }
  
  private void initializeFadingEdges()
  {
    setVerticalFadingEdgeEnabled(true);
    setFadingEdgeLength((getBottom() - getTop() - mTextSize) / 2);
  }
  
  private void initializeSelectorWheel()
  {
    initializeSelectorWheelIndices();
    int[] arrayOfInt = mSelectorIndices;
    int i = arrayOfInt.length;
    int j = mTextSize;
    mSelectorTextGapHeight = ((int)((getBottom() - getTop() - i * j) / arrayOfInt.length + 0.5F));
    mSelectorElementHeight = (mTextSize + mSelectorTextGapHeight);
    mInitialScrollOffset = (mInputText.getBaseline() + mInputText.getTop() - mSelectorElementHeight * 1);
    mCurrentScrollOffset = mInitialScrollOffset;
    updateInputTextView();
  }
  
  private int makeMeasureSpec(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 200) {
      return paramInt1;
    }
    int i = View.MeasureSpec.getSize(paramInt1);
    int j = View.MeasureSpec.getMode(paramInt1);
    switch (j)
    {
    case 1073741824: 
    default: 
      throw new IllegalArgumentException("Unknown measure mode: " + j);
    case -2147483648: 
      return View.MeasureSpec.makeMeasureSpec(Math.min(i, paramInt2), 1073741824);
    }
    return View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824);
  }
  
  private boolean moveToFinalScrollerPosition(Scroller paramScroller)
  {
    paramScroller.forceFinished(true);
    int k = paramScroller.getFinalY() - paramScroller.getCurrY();
    int i = mCurrentScrollOffset;
    int j = mSelectorElementHeight;
    j = mInitialScrollOffset - (i + k) % j;
    if (j != 0)
    {
      i = j;
      if (Math.abs(j) > mSelectorElementHeight / 2) {
        if (j <= 0) {
          break label79;
        }
      }
      label79:
      for (i = j - mSelectorElementHeight;; i = j + mSelectorElementHeight)
      {
        scrollBy(0, k + i);
        return true;
      }
    }
    return false;
  }
  
  private void notifyChange(int paramInt)
  {
    if (mOnValueChangeListener != null) {
      mOnValueChangeListener.onValueChange(this, paramInt, mValue);
    }
  }
  
  private void onScrollStateChange(int paramInt)
  {
    if (mScrollState == paramInt) {}
    do
    {
      return;
      mScrollState = paramInt;
    } while (mOnScrollListener == null);
    mOnScrollListener.onScrollStateChange(this, paramInt);
  }
  
  private void onScrollerFinished(Scroller paramScroller)
  {
    if (paramScroller == mFlingScroller)
    {
      if (!ensureScrollWheelAdjusted()) {
        updateInputTextView();
      }
      onScrollStateChange(0);
    }
    while (mScrollState == 1) {
      return;
    }
    updateInputTextView();
  }
  
  private void postBeginSoftInputOnLongPressCommand()
  {
    if (mBeginSoftInputOnLongPressCommand == null) {
      mBeginSoftInputOnLongPressCommand = new BeginSoftInputOnLongPressCommand();
    }
    for (;;)
    {
      postDelayed(mBeginSoftInputOnLongPressCommand, ViewConfiguration.getLongPressTimeout());
      return;
      removeCallbacks(mBeginSoftInputOnLongPressCommand);
    }
  }
  
  private void postChangeCurrentByOneFromLongPress(boolean paramBoolean, long paramLong)
  {
    if (mChangeCurrentByOneFromLongPressCommand == null) {
      mChangeCurrentByOneFromLongPressCommand = new ChangeCurrentByOneFromLongPressCommand();
    }
    for (;;)
    {
      mChangeCurrentByOneFromLongPressCommand.setStep(paramBoolean);
      postDelayed(mChangeCurrentByOneFromLongPressCommand, paramLong);
      return;
      removeCallbacks(mChangeCurrentByOneFromLongPressCommand);
    }
  }
  
  private void removeAllCallbacks()
  {
    if (mChangeCurrentByOneFromLongPressCommand != null) {
      removeCallbacks(mChangeCurrentByOneFromLongPressCommand);
    }
    if (mBeginSoftInputOnLongPressCommand != null) {
      removeCallbacks(mBeginSoftInputOnLongPressCommand);
    }
    mPressedStateHelper.cancel();
  }
  
  private void removeBeginSoftInputCommand()
  {
    if (mBeginSoftInputOnLongPressCommand != null) {
      removeCallbacks(mBeginSoftInputOnLongPressCommand);
    }
  }
  
  private void removeChangeCurrentByOneFromLongPress()
  {
    if (mChangeCurrentByOneFromLongPressCommand != null) {
      removeCallbacks(mChangeCurrentByOneFromLongPressCommand);
    }
  }
  
  private int resolveSizeAndStateRespectingMinSize(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = paramInt2;
    if (paramInt1 != 200) {
      i = resolveSizeAndState(Math.max(paramInt1, paramInt2), paramInt3, 0);
    }
    return i;
  }
  
  private void setValueInternal(int paramInt, boolean paramBoolean)
  {
    if (mValue == paramInt) {
      return;
    }
    if (mWrapSelectorWheel) {}
    for (paramInt = getWrappedSelectorIndex(paramInt);; paramInt = Math.min(Math.max(paramInt, mMinValue), mMaxValue))
    {
      int i = mValue;
      mValue = paramInt;
      updateInputTextView();
      if (paramBoolean) {
        notifyChange(i);
      }
      initializeSelectorWheelIndices();
      invalidate();
      return;
    }
  }
  
  private void tryComputeMaxWidth()
  {
    if (!mComputeMaxWidth) {}
    int i;
    float f1;
    int j;
    int k;
    do
    {
      return;
      i = 0;
      if (mDisplayedValues != null) {
        break;
      }
      f1 = 0.0F;
      i = 0;
      while (i <= 9)
      {
        float f3 = mSelectorWheelPaint.measureText(formatNumberWithLocale(i));
        float f2 = f1;
        if (f3 > f1) {
          f2 = f3;
        }
        i += 1;
        f1 = f2;
      }
      j = 0;
      i = mMaxValue;
      while (i > 0)
      {
        j += 1;
        i /= 10;
      }
      k = (int)(j * f1);
      i = k + (mInputText.getPaddingLeft() + mInputText.getPaddingRight());
    } while (mMaxWidth == i);
    if (i > mMinWidth) {}
    for (mMaxWidth = i;; mMaxWidth = mMinWidth)
    {
      invalidate();
      return;
      int m = mDisplayedValues.length;
      j = 0;
      for (;;)
      {
        k = i;
        if (j >= m) {
          break;
        }
        f1 = mSelectorWheelPaint.measureText(mDisplayedValues[j]);
        k = i;
        if (f1 > i) {
          k = (int)f1;
        }
        j += 1;
        i = k;
      }
    }
  }
  
  private boolean updateInputTextView()
  {
    if (mDisplayedValues == null) {}
    for (String str = ""; (!TextUtils.isEmpty(str)) && (!str.equals(mInputText.getText().toString())); str = mDisplayedValues[(mValue - mMinValue)])
    {
      mInputText.setText(str);
      return true;
    }
    return false;
  }
  
  public void clear()
  {
    updateValues(new String[0], 0);
  }
  
  public void computeScroll()
  {
    Scroller localScroller2 = mFlingScroller;
    Scroller localScroller1 = localScroller2;
    if (localScroller2.isFinished())
    {
      localScroller2 = mAdjustScroller;
      localScroller1 = localScroller2;
      if (localScroller2.isFinished()) {
        return;
      }
    }
    localScroller1.computeScrollOffset();
    int i = localScroller1.getCurrY();
    if (mPreviousScrollerY == 0) {
      mPreviousScrollerY = localScroller1.getStartY();
    }
    scrollBy(0, i - mPreviousScrollerY);
    mPreviousScrollerY = i;
    if (localScroller1.isFinished())
    {
      onScrollerFinished(localScroller1);
      return;
    }
    invalidate();
  }
  
  protected int computeVerticalScrollExtent()
  {
    return getHeight();
  }
  
  protected int computeVerticalScrollOffset()
  {
    return mCurrentScrollOffset;
  }
  
  protected int computeVerticalScrollRange()
  {
    return (mMaxValue - mMinValue + 1) * mSelectorElementHeight;
  }
  
  protected boolean dispatchHoverEvent(MotionEvent paramMotionEvent)
  {
    if (!mHasSelectorWheel) {
      return super.dispatchHoverEvent(paramMotionEvent);
    }
    int i;
    if (((AccessibilityManager)getContext().getSystemService("accessibility")).isEnabled())
    {
      i = (int)paramMotionEvent.getY();
      if (i >= mTopSelectionDividerTop) {
        break label94;
      }
      i = 3;
      int j = paramMotionEvent.getActionMasked();
      paramMotionEvent = (AccessibilityNodeProviderImpl)getAccessibilityNodeProvider();
      switch (j)
      {
      }
    }
    for (;;)
    {
      return false;
      label94:
      if (i > mBottomSelectionDividerBottom)
      {
        i = 1;
        break;
      }
      i = 2;
      break;
      paramMotionEvent.sendAccessibilityEventForVirtualView(i, 128);
      mLastHoveredChildVirtualViewId = i;
      paramMotionEvent.performAction(i, 64, null);
      continue;
      if ((mLastHoveredChildVirtualViewId != i) && (mLastHoveredChildVirtualViewId != -1))
      {
        paramMotionEvent.sendAccessibilityEventForVirtualView(mLastHoveredChildVirtualViewId, 256);
        paramMotionEvent.sendAccessibilityEventForVirtualView(i, 128);
        mLastHoveredChildVirtualViewId = i;
        paramMotionEvent.performAction(i, 64, null);
        continue;
        paramMotionEvent.sendAccessibilityEventForVirtualView(i, 256);
        mLastHoveredChildVirtualViewId = -1;
      }
    }
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    boolean bool = true;
    int i = paramKeyEvent.getKeyCode();
    switch (i)
    {
    }
    label127:
    label166:
    do
    {
      bool = super.dispatchKeyEvent(paramKeyEvent);
      do
      {
        return bool;
        removeAllCallbacks();
        break;
        if (!mHasSelectorWheel) {
          break;
        }
        switch (paramKeyEvent.getAction())
        {
        default: 
          break;
        case 0: 
          if (!mWrapSelectorWheel)
          {
            if (i != 20) {
              break label166;
            }
            if (getValue() >= getMaxValue()) {
              break;
            }
          }
          requestFocus();
          mLastHandledDownDpadKeyCode = i;
          removeAllCallbacks();
        }
      } while (!mFlingScroller.isFinished());
      if (i == 20) {}
      for (bool = true;; bool = false)
      {
        changeValueByOne(bool);
        return true;
        if (getValue() <= getMinValue()) {
          break;
        }
        break label127;
      }
    } while (mLastHandledDownDpadKeyCode != i);
    mLastHandledDownDpadKeyCode = -1;
    return true;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getActionMasked())
    {
    }
    for (;;)
    {
      return super.dispatchTouchEvent(paramMotionEvent);
      removeAllCallbacks();
    }
  }
  
  public boolean dispatchTrackballEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getActionMasked())
    {
    }
    for (;;)
    {
      return super.dispatchTrackballEvent(paramMotionEvent);
      removeAllCallbacks();
    }
  }
  
  public AccessibilityNodeProvider getAccessibilityNodeProvider()
  {
    if (!mHasSelectorWheel) {
      return super.getAccessibilityNodeProvider();
    }
    if (mAccessibilityNodeProvider == null) {
      mAccessibilityNodeProvider = new AccessibilityNodeProviderImpl();
    }
    return mAccessibilityNodeProvider;
  }
  
  protected float getBottomFadingEdgeStrength()
  {
    return 0.9F;
  }
  
  public String[] getDisplayedValues()
  {
    return mDisplayedValues;
  }
  
  public int getMaxValue()
  {
    return mMaxValue;
  }
  
  public int getMinValue()
  {
    return mMinValue;
  }
  
  public int getSolidColor()
  {
    return mSolidColor;
  }
  
  protected float getTopFadingEdgeStrength()
  {
    return 0.9F;
  }
  
  public int getValue()
  {
    return mValue;
  }
  
  public boolean getWrapSelectorWheel()
  {
    return mWrapSelectorWheel;
  }
  
  public void initializeSelectorWheelIndices()
  {
    mSelectorIndexToStringCache.clear();
    int[] arrayOfInt = mSelectorIndices;
    int m = getValue();
    int i = 0;
    while (i < mSelectorIndices.length)
    {
      int k = m + (i - 1);
      int j = k;
      if (mWrapSelectorWheel) {
        j = getWrappedSelectorIndex(k);
      }
      arrayOfInt[i] = j;
      ensureCachedScrollSelectorValue(arrayOfInt[i]);
      i += 1;
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    removeAllCallbacks();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (!mHasSelectorWheel) {
      super.onDraw(paramCanvas);
    }
    boolean bool;
    do
    {
      return;
      if (mHideWheelUntilFocused) {}
      for (bool = hasFocus();; bool = true)
      {
        float f2 = (getRight() - getLeft()) / 2;
        float f1 = mCurrentScrollOffset;
        if ((bool) && (mVirtualButtonPressedDrawable != null) && (mScrollState == 0))
        {
          if (mDecrementVirtualButtonPressed)
          {
            mVirtualButtonPressedDrawable.setState(PRESSED_STATE_SET);
            mVirtualButtonPressedDrawable.setBounds(0, 0, getRight(), mTopSelectionDividerTop);
            mVirtualButtonPressedDrawable.draw(paramCanvas);
          }
          if (mIncrementVirtualButtonPressed)
          {
            mVirtualButtonPressedDrawable.setState(PRESSED_STATE_SET);
            mVirtualButtonPressedDrawable.setBounds(0, mBottomSelectionDividerBottom, getRight(), getBottom());
            mVirtualButtonPressedDrawable.draw(paramCanvas);
          }
        }
        int[] arrayOfInt = mSelectorIndices;
        i = 0;
        while (i < arrayOfInt.length)
        {
          j = arrayOfInt[i];
          String str = (String)mSelectorIndexToStringCache.get(j);
          if (((bool) && (i != 1)) || ((i == 1) && (mInputText.getVisibility() != 0))) {
            paramCanvas.drawText(str, f2, f1, mSelectorWheelPaint);
          }
          f1 += mSelectorElementHeight;
          i += 1;
        }
      }
    } while ((!bool) || (mSelectionDivider == null));
    int i = mTopSelectionDividerTop;
    int j = mSelectionDividerHeight;
    mSelectionDivider.setBounds(0, i, getRight(), i + j);
    mSelectionDivider.draw(paramCanvas);
    i = mBottomSelectionDividerBottom;
    j = mSelectionDividerHeight;
    mSelectionDivider.setBounds(0, i - j, getRight(), i);
    mSelectionDivider.draw(paramCanvas);
  }
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName(CustomPicker.class.getName());
    paramAccessibilityEvent.setScrollable(true);
    paramAccessibilityEvent.setScrollY((mMinValue + mValue) * mSelectorElementHeight);
    paramAccessibilityEvent.setMaxScrollY((mMaxValue - mMinValue) * mSelectorElementHeight);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((!mHasSelectorWheel) || (!isEnabled())) {
      return false;
    }
    switch (paramMotionEvent.getActionMasked())
    {
    default: 
      return false;
    }
    removeAllCallbacks();
    mInputText.setVisibility(4);
    float f = paramMotionEvent.getY();
    mLastDownEventY = f;
    mLastDownOrMoveEventY = f;
    mLastDownEventTime = paramMotionEvent.getEventTime();
    mIgnoreMoveEvents = false;
    mPerformClickOnTap = false;
    if (mLastDownEventY < mTopSelectionDividerTop) {
      if (mScrollState == 0) {
        mPressedStateHelper.buttonPressDelayed(2);
      }
    }
    for (;;)
    {
      getParent().requestDisallowInterceptTouchEvent(true);
      if (mFlingScroller.isFinished()) {
        break;
      }
      mFlingScroller.forceFinished(true);
      mAdjustScroller.forceFinished(true);
      onScrollStateChange(0);
      return true;
      if ((mLastDownEventY > mBottomSelectionDividerBottom) && (mScrollState == 0)) {
        mPressedStateHelper.buttonPressDelayed(1);
      }
    }
    if (!mAdjustScroller.isFinished())
    {
      mFlingScroller.forceFinished(true);
      mAdjustScroller.forceFinished(true);
      return true;
    }
    if (mLastDownEventY < mTopSelectionDividerTop)
    {
      postChangeCurrentByOneFromLongPress(false, ViewConfiguration.getLongPressTimeout());
      return true;
    }
    if (mLastDownEventY > mBottomSelectionDividerBottom)
    {
      postChangeCurrentByOneFromLongPress(true, ViewConfiguration.getLongPressTimeout());
      return true;
    }
    mPerformClickOnTap = true;
    postBeginSoftInputOnLongPressCommand();
    return true;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (!mHasSelectorWheel) {
      super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    }
    do
    {
      return;
      paramInt4 = getMeasuredWidth();
      paramInt3 = getMeasuredHeight();
      paramInt1 = mInputText.getMeasuredWidth();
      paramInt2 = mInputText.getMeasuredHeight();
      paramInt4 = (paramInt4 - paramInt1) / 2;
      paramInt3 = (paramInt3 - paramInt2) / 2;
      mInputText.layout(paramInt4, paramInt3, paramInt4 + paramInt1, paramInt3 + paramInt2);
    } while (!paramBoolean);
    initializeSelectorWheel();
    initializeFadingEdges();
    mTopSelectionDividerTop = ((getHeight() - mSelectionDividersDistance) / 2 - mSelectionDividerHeight);
    mBottomSelectionDividerBottom = (mTopSelectionDividerTop + mSelectionDividerHeight * 2 + mSelectionDividersDistance);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (!mHasSelectorWheel)
    {
      super.onMeasure(paramInt1, paramInt2);
      return;
    }
    super.onMeasure(makeMeasureSpec(paramInt1, mMaxWidth), makeMeasureSpec(paramInt2, mMaxHeight));
    setMeasuredDimension(resolveSizeAndStateRespectingMinSize(mMinWidth, getMeasuredWidth(), paramInt1), resolveSizeAndStateRespectingMinSize(mMinHeight, getMeasuredHeight(), paramInt2));
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((!isEnabled()) || (!mHasSelectorWheel)) {
      return false;
    }
    if (mVelocityTracker == null) {
      mVelocityTracker = VelocityTracker.obtain();
    }
    mVelocityTracker.addMovement(paramMotionEvent);
    switch (paramMotionEvent.getActionMasked())
    {
    }
    for (;;)
    {
      return true;
      if (!mIgnoreMoveEvents)
      {
        float f = paramMotionEvent.getY();
        if (mScrollState != 1) {
          if ((int)Math.abs(f - mLastDownEventY) > mTouchSlop)
          {
            removeAllCallbacks();
            onScrollStateChange(1);
          }
        }
        for (;;)
        {
          mLastDownOrMoveEventY = f;
          break;
          scrollBy(0, (int)(f - mLastDownOrMoveEventY));
          invalidate();
        }
        removeBeginSoftInputCommand();
        removeChangeCurrentByOneFromLongPress();
        mPressedStateHelper.cancel();
        VelocityTracker localVelocityTracker = mVelocityTracker;
        localVelocityTracker.computeCurrentVelocity(1000, mMaximumFlingVelocity);
        i = (int)localVelocityTracker.getYVelocity();
        if (Math.abs(i) <= mMinimumFlingVelocity) {
          break;
        }
        fling(i);
        onScrollStateChange(2);
        mVelocityTracker.recycle();
        mVelocityTracker = null;
      }
    }
    int i = (int)paramMotionEvent.getY();
    int j = (int)Math.abs(i - mLastDownEventY);
    long l1 = paramMotionEvent.getEventTime();
    long l2 = mLastDownEventTime;
    if ((j <= mTouchSlop) && (l1 - l2 < ViewConfiguration.getTapTimeout())) {
      if (mPerformClickOnTap)
      {
        mPerformClickOnTap = false;
        performClick();
      }
    }
    for (;;)
    {
      onScrollStateChange(0);
      break;
      i = i / mSelectorElementHeight - 1;
      if (i > 0)
      {
        changeValueByOne(true);
        mPressedStateHelper.buttonTapped(1);
      }
      else if (i < 0)
      {
        changeValueByOne(false);
        mPressedStateHelper.buttonTapped(2);
        continue;
        ensureScrollWheelAdjusted();
      }
    }
  }
  
  public boolean performClick()
  {
    if (!mHasSelectorWheel) {
      return super.performClick();
    }
    if (!super.performClick()) {}
    return true;
  }
  
  public boolean performLongClick()
  {
    boolean bool = true;
    if (!mHasSelectorWheel) {
      bool = super.performLongClick();
    }
    while (super.performLongClick()) {
      return bool;
    }
    mIgnoreMoveEvents = true;
    return true;
  }
  
  public void scrollBy(int paramInt1, int paramInt2)
  {
    int[] arrayOfInt = mSelectorIndices;
    if ((!mWrapSelectorWheel) && (paramInt2 > 0) && (arrayOfInt[1] <= mMinValue)) {
      mCurrentScrollOffset = mInitialScrollOffset;
    }
    for (;;)
    {
      return;
      if ((!mWrapSelectorWheel) && (paramInt2 < 0) && (arrayOfInt[1] >= mMaxValue))
      {
        mCurrentScrollOffset = mInitialScrollOffset;
        return;
      }
      for (mCurrentScrollOffset += paramInt2; mCurrentScrollOffset - mInitialScrollOffset > mSelectorTextGapHeight; mCurrentScrollOffset = mInitialScrollOffset)
      {
        label75:
        mCurrentScrollOffset -= mSelectorElementHeight;
        decrementSelectorIndices(arrayOfInt);
        setValueInternal(arrayOfInt[1], true);
        if ((mWrapSelectorWheel) || (arrayOfInt[1] > mMinValue)) {
          break label75;
        }
      }
      while (mCurrentScrollOffset - mInitialScrollOffset < -mSelectorTextGapHeight)
      {
        mCurrentScrollOffset += mSelectorElementHeight;
        incrementSelectorIndices(arrayOfInt);
        setValueInternal(arrayOfInt[1], true);
        if ((!mWrapSelectorWheel) && (arrayOfInt[1] >= mMaxValue)) {
          mCurrentScrollOffset = mInitialScrollOffset;
        }
      }
    }
  }
  
  public void setDisplayedValues(String[] paramArrayOfString)
  {
    if (mDisplayedValues == paramArrayOfString) {
      return;
    }
    mDisplayedValues = paramArrayOfString;
    if (mDisplayedValues != null) {
      mInputText.setRawInputType(524289);
    }
    for (;;)
    {
      updateInputTextView();
      initializeSelectorWheelIndices();
      tryComputeMaxWidth();
      return;
      mInputText.setRawInputType(2);
    }
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    super.setEnabled(paramBoolean);
  }
  
  public void setMaxValue(int paramInt)
  {
    if (mMaxValue == paramInt) {
      return;
    }
    if (paramInt < 0) {
      throw new IllegalArgumentException("maxValue must be >= 0");
    }
    mMaxValue = paramInt;
    if (mMaxValue < mValue) {
      mValue = mMaxValue;
    }
    if (mMaxValue - mMinValue > mSelectorIndices.length) {}
    for (boolean bool = true;; bool = false)
    {
      setWrapSelectorWheel(bool);
      initializeSelectorWheelIndices();
      updateInputTextView();
      tryComputeMaxWidth();
      invalidate();
      return;
    }
  }
  
  public void setMinValue(int paramInt)
  {
    if (mMinValue == paramInt) {
      return;
    }
    if (paramInt < 0) {
      throw new IllegalArgumentException("minValue must be >= 0");
    }
    mMinValue = paramInt;
    if (mMinValue > mValue) {
      mValue = mMinValue;
    }
    if (mMaxValue - mMinValue > mSelectorIndices.length) {}
    for (boolean bool = true;; bool = false)
    {
      setWrapSelectorWheel(bool);
      initializeSelectorWheelIndices();
      updateInputTextView();
      tryComputeMaxWidth();
      invalidate();
      return;
    }
  }
  
  public void setOnValueChangedListener(OnValueChangeListener paramOnValueChangeListener)
  {
    mOnValueChangeListener = paramOnValueChangeListener;
  }
  
  public void setValue(int paramInt)
  {
    setValueInternal(paramInt, false);
  }
  
  public void setWrapSelectorWheel(boolean paramBoolean)
  {
    if (mMaxValue - mMinValue >= mSelectorIndices.length) {}
    for (int i = 1;; i = 0)
    {
      if (((!paramBoolean) || (i != 0)) && (paramBoolean != mWrapSelectorWheel)) {
        mWrapSelectorWheel = paramBoolean;
      }
      return;
    }
  }
  
  public void updateValues(String[] paramArrayOfString)
  {
    updateValues(paramArrayOfString, getValue());
  }
  
  public void updateValues(String[] paramArrayOfString, int paramInt)
  {
    int i = paramArrayOfString.length - 1;
    if (i > getMaxValue())
    {
      setMinValue(0);
      setValue(0);
      setDisplayedValues(paramArrayOfString);
      setMaxValue(i);
      setWrapSelectorWheel(false);
      initializeSelectorWheelIndices();
    }
    while (paramInt > i)
    {
      setValue(i);
      return;
      setMinValue(0);
      setValue(0);
      setMaxValue(i);
      setWrapSelectorWheel(false);
      setDisplayedValues(paramArrayOfString);
    }
    setValue(paramInt);
  }
  
  class AccessibilityNodeProviderImpl
    extends AccessibilityNodeProvider
  {
    private static final int UNDEFINED = Integer.MIN_VALUE;
    private static final int VIRTUAL_VIEW_ID_DECREMENT = 3;
    private static final int VIRTUAL_VIEW_ID_INCREMENT = 1;
    private static final int VIRTUAL_VIEW_ID_INPUT = 2;
    private int mAccessibilityFocusedView = Integer.MIN_VALUE;
    private final int[] mTempArray = new int[2];
    private final Rect mTempRect = new Rect();
    
    AccessibilityNodeProviderImpl() {}
    
    private AccessibilityNodeInfo createAccessibilityNodeInfoForNumberPicker(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      AccessibilityNodeInfo localAccessibilityNodeInfo = AccessibilityNodeInfo.obtain();
      localAccessibilityNodeInfo.setClassName(CustomPicker.class.getName());
      localAccessibilityNodeInfo.setPackageName(getContext().getPackageName());
      localAccessibilityNodeInfo.setSource(CustomPicker.this);
      if (hasVirtualDecrementButton()) {
        localAccessibilityNodeInfo.addChild(CustomPicker.this, 3);
      }
      localAccessibilityNodeInfo.addChild(CustomPicker.this, 2);
      if (hasVirtualIncrementButton()) {
        localAccessibilityNodeInfo.addChild(CustomPicker.this, 1);
      }
      localAccessibilityNodeInfo.setParent((View)getParentForAccessibility());
      localAccessibilityNodeInfo.setEnabled(isEnabled());
      localAccessibilityNodeInfo.setScrollable(true);
      Rect localRect = mTempRect;
      localRect.set(paramInt1, paramInt2, paramInt3, paramInt4);
      localAccessibilityNodeInfo.setBoundsInParent(localRect);
      int[] arrayOfInt = mTempArray;
      getLocationOnScreen(arrayOfInt);
      localRect.offset(arrayOfInt[0], arrayOfInt[1]);
      localAccessibilityNodeInfo.setBoundsInScreen(localRect);
      if (mAccessibilityFocusedView != -1) {
        localAccessibilityNodeInfo.addAction(64);
      }
      if (mAccessibilityFocusedView == -1) {
        localAccessibilityNodeInfo.addAction(128);
      }
      if (isEnabled())
      {
        if ((getWrapSelectorWheel()) || (getValue() < getMaxValue())) {
          localAccessibilityNodeInfo.addAction(4096);
        }
        if ((getWrapSelectorWheel()) || (getValue() > getMinValue())) {
          localAccessibilityNodeInfo.addAction(8192);
        }
      }
      return localAccessibilityNodeInfo;
    }
    
    private AccessibilityNodeInfo createAccessibilityNodeInfoForVirtualButton(int paramInt1, String paramString, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
    {
      AccessibilityNodeInfo localAccessibilityNodeInfo = AccessibilityNodeInfo.obtain();
      localAccessibilityNodeInfo.setClassName(Button.class.getName());
      localAccessibilityNodeInfo.setPackageName(getContext().getPackageName());
      localAccessibilityNodeInfo.setSource(CustomPicker.this, paramInt1);
      localAccessibilityNodeInfo.setParent(CustomPicker.this);
      localAccessibilityNodeInfo.setText(paramString);
      localAccessibilityNodeInfo.setClickable(true);
      localAccessibilityNodeInfo.setLongClickable(true);
      localAccessibilityNodeInfo.setEnabled(isEnabled());
      paramString = mTempRect;
      paramString.set(paramInt2, paramInt3, paramInt4, paramInt5);
      localAccessibilityNodeInfo.setBoundsInParent(paramString);
      int[] arrayOfInt = mTempArray;
      getLocationOnScreen(arrayOfInt);
      paramString.offset(arrayOfInt[0], arrayOfInt[1]);
      localAccessibilityNodeInfo.setBoundsInScreen(paramString);
      if (mAccessibilityFocusedView != paramInt1) {
        localAccessibilityNodeInfo.addAction(64);
      }
      if (mAccessibilityFocusedView == paramInt1) {
        localAccessibilityNodeInfo.addAction(128);
      }
      if (isEnabled()) {
        localAccessibilityNodeInfo.addAction(16);
      }
      return localAccessibilityNodeInfo;
    }
    
    private AccessibilityNodeInfo createAccessibiltyNodeInfoForInputText(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      AccessibilityNodeInfo localAccessibilityNodeInfo = mInputText.createAccessibilityNodeInfo();
      localAccessibilityNodeInfo.setSource(CustomPicker.this, 2);
      if (mAccessibilityFocusedView != 2) {
        localAccessibilityNodeInfo.addAction(64);
      }
      if (mAccessibilityFocusedView == 2) {
        localAccessibilityNodeInfo.addAction(128);
      }
      Rect localRect = mTempRect;
      localRect.set(paramInt1, paramInt2, paramInt3, paramInt4);
      localAccessibilityNodeInfo.setBoundsInParent(localRect);
      int[] arrayOfInt = mTempArray;
      getLocationOnScreen(arrayOfInt);
      localRect.offset(arrayOfInt[0], arrayOfInt[1]);
      localAccessibilityNodeInfo.setBoundsInScreen(localRect);
      return localAccessibilityNodeInfo;
    }
    
    private void findAccessibilityNodeInfosByTextInChild(String paramString, int paramInt, List<AccessibilityNodeInfo> paramList)
    {
      switch (paramInt)
      {
      }
      Object localObject;
      do
      {
        do
        {
          do
          {
            return;
            localObject = getVirtualDecrementButtonText();
          } while ((TextUtils.isEmpty((CharSequence)localObject)) || (!((String)localObject).toString().toLowerCase().contains(paramString)));
          paramList.add(createAccessibilityNodeInfo(3));
          return;
          localObject = mInputText.getText();
          if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((CharSequence)localObject).toString().toLowerCase().contains(paramString)))
          {
            paramList.add(createAccessibilityNodeInfo(2));
            return;
          }
          localObject = mInputText.getText();
        } while ((TextUtils.isEmpty((CharSequence)localObject)) || (!((CharSequence)localObject).toString().toLowerCase().contains(paramString)));
        paramList.add(createAccessibilityNodeInfo(2));
        return;
        localObject = getVirtualIncrementButtonText();
      } while ((TextUtils.isEmpty((CharSequence)localObject)) || (!((String)localObject).toString().toLowerCase().contains(paramString)));
      paramList.add(createAccessibilityNodeInfo(1));
    }
    
    private String getVirtualDecrementButtonText()
    {
      int j = mValue - 1;
      int i = j;
      if (mWrapSelectorWheel) {
        i = CustomPicker.this.getWrappedSelectorIndex(j);
      }
      if (i >= mMinValue) {
        return mDisplayedValues[(i - mMinValue)];
      }
      return null;
    }
    
    private String getVirtualIncrementButtonText()
    {
      int j = mValue + 1;
      int i = j;
      if (mWrapSelectorWheel) {
        i = CustomPicker.this.getWrappedSelectorIndex(j);
      }
      if (i <= mMaxValue) {
        return mDisplayedValues[(i - mMinValue)];
      }
      return null;
    }
    
    private boolean hasVirtualDecrementButton()
    {
      return (getWrapSelectorWheel()) || (getValue() > getMinValue());
    }
    
    private boolean hasVirtualIncrementButton()
    {
      return (getWrapSelectorWheel()) || (getValue() < getMaxValue());
    }
    
    private void sendAccessibilityEventForVirtualButton(int paramInt1, int paramInt2, String paramString)
    {
      if (((AccessibilityManager)getContext().getSystemService("accessibility")).isEnabled())
      {
        AccessibilityEvent localAccessibilityEvent = AccessibilityEvent.obtain(paramInt2);
        localAccessibilityEvent.setClassName(Button.class.getName());
        localAccessibilityEvent.setPackageName(getContext().getPackageName());
        localAccessibilityEvent.getText().add(paramString);
        localAccessibilityEvent.setEnabled(isEnabled());
        localAccessibilityEvent.setSource(CustomPicker.this, paramInt1);
        requestSendAccessibilityEvent(CustomPicker.this, localAccessibilityEvent);
      }
    }
    
    private void sendAccessibilityEventForVirtualText(int paramInt)
    {
      if (((AccessibilityManager)getContext().getSystemService("accessibility")).isEnabled())
      {
        AccessibilityEvent localAccessibilityEvent = AccessibilityEvent.obtain(paramInt);
        mInputText.onInitializeAccessibilityEvent(localAccessibilityEvent);
        mInputText.onPopulateAccessibilityEvent(localAccessibilityEvent);
        localAccessibilityEvent.setSource(CustomPicker.this, 2);
        requestSendAccessibilityEvent(CustomPicker.this, localAccessibilityEvent);
      }
    }
    
    public AccessibilityNodeInfo createAccessibilityNodeInfo(int paramInt)
    {
      switch (paramInt)
      {
      case 0: 
      default: 
        return super.createAccessibilityNodeInfo(paramInt);
      case -1: 
        return createAccessibilityNodeInfoForNumberPicker(getScrollX(), getScrollY(), getScrollX() + (getRight() - getLeft()), getScrollY() + (getBottom() - getTop()));
      case 3: 
        str = getVirtualDecrementButtonText();
        paramInt = getScrollX();
        i = getScrollY();
        j = getScrollX();
        k = getRight();
        m = getLeft();
        n = mTopSelectionDividerTop;
        return createAccessibilityNodeInfoForVirtualButton(3, str, paramInt, i, k - m + j, mSelectionDividerHeight + n);
      case 2: 
        return createAccessibiltyNodeInfoForInputText(getScrollX(), mTopSelectionDividerTop + mSelectionDividerHeight, getScrollX() + (getRight() - getLeft()), mBottomSelectionDividerBottom - mSelectionDividerHeight);
      }
      String str = getVirtualIncrementButtonText();
      paramInt = getScrollX();
      int i = mBottomSelectionDividerBottom;
      int j = mSelectionDividerHeight;
      int k = getScrollX();
      int m = getRight();
      int n = getLeft();
      int i1 = getScrollY();
      return createAccessibilityNodeInfoForVirtualButton(1, str, paramInt, i - j, m - n + k, getBottom() - getTop() + i1);
    }
    
    public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String paramString, int paramInt)
    {
      if (TextUtils.isEmpty(paramString)) {
        return Collections.emptyList();
      }
      String str = paramString.toLowerCase();
      ArrayList localArrayList = new ArrayList();
      switch (paramInt)
      {
      case 0: 
      default: 
        return super.findAccessibilityNodeInfosByText(paramString, paramInt);
      case -1: 
        findAccessibilityNodeInfosByTextInChild(str, 3, localArrayList);
        findAccessibilityNodeInfosByTextInChild(str, 2, localArrayList);
        findAccessibilityNodeInfosByTextInChild(str, 1, localArrayList);
        return localArrayList;
      }
      findAccessibilityNodeInfosByTextInChild(str, paramInt, localArrayList);
      return localArrayList;
    }
    
    public boolean performAction(int paramInt1, int paramInt2, Bundle paramBundle)
    {
      boolean bool3 = false;
      boolean bool2 = false;
      boolean bool1;
      switch (paramInt1)
      {
      case 0: 
      default: 
        bool1 = super.performAction(paramInt1, paramInt2, paramBundle);
      }
      label183:
      label238:
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          do
                          {
                            do
                            {
                              do
                              {
                                do
                                {
                                  do
                                  {
                                    do
                                    {
                                      do
                                      {
                                        do
                                        {
                                          do
                                          {
                                            do
                                            {
                                              return bool1;
                                              switch (paramInt2)
                                              {
                                              default: 
                                                break;
                                              case 64: 
                                                bool1 = bool2;
                                              }
                                            } while (mAccessibilityFocusedView == paramInt1);
                                            mAccessibilityFocusedView = paramInt1;
                                            return true;
                                            bool1 = bool2;
                                          } while (mAccessibilityFocusedView != paramInt1);
                                          mAccessibilityFocusedView = Integer.MIN_VALUE;
                                          return true;
                                          bool1 = bool2;
                                        } while (!isEnabled());
                                        if (getWrapSelectorWheel()) {
                                          break label183;
                                        }
                                        bool1 = bool2;
                                      } while (getValue() >= getMaxValue());
                                      CustomPicker.this.changeValueByOne(true);
                                      return true;
                                      bool1 = bool2;
                                    } while (!isEnabled());
                                    if (getWrapSelectorWheel()) {
                                      break label238;
                                    }
                                    bool1 = bool2;
                                  } while (getValue() <= getMinValue());
                                  CustomPicker.this.changeValueByOne(false);
                                  return true;
                                  switch (paramInt2)
                                  {
                                  default: 
                                    return mInputText.performAccessibilityAction(paramInt2, paramBundle);
                                  case 1: 
                                    bool1 = bool2;
                                  }
                                } while (!isEnabled());
                                bool1 = bool2;
                              } while (mInputText.isFocused());
                              return mInputText.requestFocus();
                              bool1 = bool2;
                            } while (!isEnabled());
                            bool1 = bool2;
                          } while (!mInputText.isFocused());
                          mInputText.clearFocus();
                          return true;
                          bool1 = bool2;
                        } while (!isEnabled());
                        performClick();
                        return true;
                        bool1 = bool2;
                      } while (!isEnabled());
                      performLongClick();
                      return true;
                      bool1 = bool2;
                    } while (mAccessibilityFocusedView == paramInt1);
                    mAccessibilityFocusedView = paramInt1;
                    sendAccessibilityEventForVirtualView(paramInt1, 32768);
                    mInputText.invalidate();
                    return true;
                    bool1 = bool2;
                  } while (mAccessibilityFocusedView != paramInt1);
                  mAccessibilityFocusedView = Integer.MIN_VALUE;
                  sendAccessibilityEventForVirtualView(paramInt1, 65536);
                  mInputText.invalidate();
                  return true;
                  switch (paramInt2)
                  {
                  default: 
                    return false;
                  case 16: 
                    bool1 = bool2;
                  }
                } while (!isEnabled());
                CustomPicker.this.changeValueByOne(true);
                sendAccessibilityEventForVirtualView(paramInt1, 1);
                return true;
                bool1 = bool2;
              } while (mAccessibilityFocusedView == paramInt1);
              mAccessibilityFocusedView = paramInt1;
              sendAccessibilityEventForVirtualView(paramInt1, 32768);
              invalidate(0, mBottomSelectionDividerBottom, getRight(), getBottom());
              return true;
              bool1 = bool2;
            } while (mAccessibilityFocusedView != paramInt1);
            mAccessibilityFocusedView = Integer.MIN_VALUE;
            sendAccessibilityEventForVirtualView(paramInt1, 65536);
            invalidate(0, mBottomSelectionDividerBottom, getRight(), getBottom());
            return true;
            switch (paramInt2)
            {
            default: 
              return false;
            case 16: 
              bool1 = bool2;
            }
          } while (!isEnabled());
          bool1 = bool3;
          if (paramInt1 == 1) {
            bool1 = true;
          }
          CustomPicker.this.changeValueByOne(bool1);
          sendAccessibilityEventForVirtualView(paramInt1, 1);
          return true;
          bool1 = bool2;
        } while (mAccessibilityFocusedView == paramInt1);
        mAccessibilityFocusedView = paramInt1;
        sendAccessibilityEventForVirtualView(paramInt1, 32768);
        invalidate(0, 0, getRight(), mTopSelectionDividerTop);
        return true;
        bool1 = bool2;
      } while (mAccessibilityFocusedView != paramInt1);
      mAccessibilityFocusedView = Integer.MIN_VALUE;
      sendAccessibilityEventForVirtualView(paramInt1, 65536);
      invalidate(0, 0, getRight(), mTopSelectionDividerTop);
      return true;
    }
    
    public void sendAccessibilityEventForVirtualView(int paramInt1, int paramInt2)
    {
      switch (paramInt1)
      {
      }
      do
      {
        do
        {
          return;
        } while (!hasVirtualDecrementButton());
        sendAccessibilityEventForVirtualButton(paramInt1, paramInt2, getVirtualDecrementButtonText());
        return;
        sendAccessibilityEventForVirtualText(paramInt2);
        return;
      } while (!hasVirtualIncrementButton());
      sendAccessibilityEventForVirtualButton(paramInt1, paramInt2, getVirtualIncrementButtonText());
    }
  }
  
  class BeginSoftInputOnLongPressCommand
    implements Runnable
  {
    BeginSoftInputOnLongPressCommand() {}
    
    public void run()
    {
      performLongClick();
    }
  }
  
  class ChangeCurrentByOneFromLongPressCommand
    implements Runnable
  {
    private boolean mIncrement;
    
    ChangeCurrentByOneFromLongPressCommand() {}
    
    private void setStep(boolean paramBoolean)
    {
      mIncrement = paramBoolean;
    }
    
    public void run()
    {
      CustomPicker.this.changeValueByOne(mIncrement);
      postDelayed(this, mLongPressUpdateInterval);
    }
  }
  
  class InputTextFilter
    extends NumberKeyListener
  {
    InputTextFilter() {}
    
    public CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
    {
      CharSequence localCharSequence1;
      if (mDisplayedValues == null)
      {
        CharSequence localCharSequence2 = super.filter(paramCharSequence, paramInt1, paramInt2, paramSpanned, paramInt3, paramInt4);
        localCharSequence1 = localCharSequence2;
        if (localCharSequence2 == null) {
          localCharSequence1 = paramCharSequence.subSequence(paramInt1, paramInt2);
        }
        paramCharSequence = String.valueOf(paramSpanned.subSequence(0, paramInt3)) + localCharSequence1 + paramSpanned.subSequence(paramInt4, paramSpanned.length());
        if ("".equals(paramCharSequence)) {
          return paramCharSequence;
        }
        if ((CustomPicker.this.getSelectedPos(paramCharSequence) > mMaxValue) || (paramCharSequence.length() > String.valueOf(mMaxValue).length())) {
          return "";
        }
        return localCharSequence1;
      }
      paramCharSequence = String.valueOf(paramCharSequence.subSequence(paramInt1, paramInt2));
      if (TextUtils.isEmpty(paramCharSequence)) {
        return "";
      }
      paramCharSequence = String.valueOf(String.valueOf(paramSpanned.subSequence(0, paramInt3)) + paramCharSequence + paramSpanned.subSequence(paramInt4, paramSpanned.length())).toLowerCase();
      paramSpanned = mDisplayedValues;
      paramInt2 = paramSpanned.length;
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        localCharSequence1 = paramSpanned[paramInt1];
        if (localCharSequence1.toLowerCase().startsWith(paramCharSequence)) {
          return localCharSequence1.subSequence(paramInt3, localCharSequence1.length());
        }
        paramInt1 += 1;
      }
      return "";
    }
    
    protected char[] getAcceptedChars()
    {
      return CustomPicker.DIGIT_CHARACTERS;
    }
    
    public int getInputType()
    {
      return 1;
    }
  }
  
  public static abstract interface OnScrollListener
  {
    public static final int SCROLL_STATE_FLING = 2;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_TOUCH_SCROLL = 1;
    
    public abstract void onScrollStateChange(CustomPicker paramCustomPicker, int paramInt);
    
    @Retention(RetentionPolicy.SOURCE)
    public static @interface ScrollState {}
  }
  
  public static abstract interface OnValueChangeListener
  {
    public abstract void onValueChange(CustomPicker paramCustomPicker, int paramInt1, int paramInt2);
  }
  
  class PressedStateHelper
    implements Runnable
  {
    public static final int BUTTON_DECREMENT = 2;
    public static final int BUTTON_INCREMENT = 1;
    private final int MODE_PRESS = 1;
    private final int MODE_TAPPED = 2;
    private int mManagedButton;
    private int mMode;
    
    PressedStateHelper() {}
    
    public void buttonPressDelayed(int paramInt)
    {
      cancel();
      mMode = 1;
      mManagedButton = paramInt;
      postDelayed(this, ViewConfiguration.getTapTimeout());
    }
    
    public void buttonTapped(int paramInt)
    {
      cancel();
      mMode = 2;
      mManagedButton = paramInt;
      post(this);
    }
    
    public void cancel()
    {
      mMode = 0;
      mManagedButton = 0;
      removeCallbacks(this);
      if (mIncrementVirtualButtonPressed)
      {
        CustomPicker.access$502(CustomPicker.this, false);
        invalidate(0, mBottomSelectionDividerBottom, getRight(), getBottom());
      }
      CustomPicker.access$702(CustomPicker.this, false);
      if (mDecrementVirtualButtonPressed) {
        invalidate(0, 0, getRight(), mTopSelectionDividerTop);
      }
    }
    
    public void run()
    {
      switch (mMode)
      {
      default: 
        return;
      case 1: 
        switch (mManagedButton)
        {
        default: 
          return;
        case 1: 
          CustomPicker.access$502(CustomPicker.this, true);
          invalidate(0, mBottomSelectionDividerBottom, getRight(), getBottom());
          return;
        }
        CustomPicker.access$702(CustomPicker.this, true);
        invalidate(0, 0, getRight(), mTopSelectionDividerTop);
        return;
      }
      switch (mManagedButton)
      {
      default: 
        return;
      case 1: 
        if (!mIncrementVirtualButtonPressed) {
          postDelayed(this, ViewConfiguration.getPressedStateDuration());
        }
        CustomPicker.access$580(CustomPicker.this, 1);
        invalidate(0, mBottomSelectionDividerBottom, getRight(), getBottom());
        return;
      }
      if (!mDecrementVirtualButtonPressed) {
        postDelayed(this, ViewConfiguration.getPressedStateDuration());
      }
      CustomPicker.access$780(CustomPicker.this, 1);
      invalidate(0, 0, getRight(), mTopSelectionDividerTop);
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.controls.CustomPicker
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */