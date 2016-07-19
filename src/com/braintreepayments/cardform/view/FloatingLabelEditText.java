package com.braintreepayments.cardform.view;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.os.Build.VERSION;
import android.os.Looper;
import android.text.Editable;
import android.text.TextPaint;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.braintreepayments.cardform.R.color;
import com.braintreepayments.cardform.R.dimen;

public abstract class FloatingLabelEditText
  extends ErrorEditText
  implements TextWatcher, View.OnFocusChangeListener
{
  private static final int ANIMATION_DURATION_MILLIS = 300;
  private ValueAnimator mAlphaAnimator;
  private int mAnimatedHintColor;
  private float mAnimatedHintHeight = -1.0F;
  private ValueAnimator mFocusColorAnimator;
  private int mHintAlpha;
  private ValueAnimator mHintAnimator;
  private TextPaint mHintPaint = new TextPaint();
  private float mHorizontalTextOffset;
  private ValueAnimator mInactiveColorAnimator;
  private View.OnFocusChangeListener mOnFocusChangeListener;
  private OnTextChangedListener mOnTextChangedListener;
  private int mPreviousTextLength;
  protected boolean mRightToLeftLanguage;
  
  public FloatingLabelEditText(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public FloatingLabelEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public FloatingLabelEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void init()
  {
    mRightToLeftLanguage = isRightToLeftLanguage();
    addTextChangedListener(this);
    mPreviousTextLength = getText().length();
    if (Build.VERSION.SDK_INT >= 11) {
      setupAnimations();
    }
  }
  
  @TargetApi(17)
  private boolean isRightToLeftLanguage()
  {
    return (Build.VERSION.SDK_INT >= 17) && (getResources().getConfiguration().getLayoutDirection() == 1);
  }
  
  @TargetApi(11)
  private void setupAnimations()
  {
    Object localObject = getResources();
    mHorizontalTextOffset = ((Resources)localObject).getDimension(R.dimen.bt_floating_edit_text_horizontal_offset);
    float f = getTextSize();
    mHintAnimator = ValueAnimator.ofFloat(new float[] { 1.75F * f, f });
    mHintAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        FloatingLabelEditText.access$002(FloatingLabelEditText.this, ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue());
        invalidate();
      }
    });
    mHintAnimator.setDuration(300L);
    int i = ((Resources)localObject).getColor(R.color.bt_light_gray);
    int j = ((Resources)localObject).getColor(R.color.bt_blue);
    localObject = new ValueAnimator.AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        FloatingLabelEditText.access$102(FloatingLabelEditText.this, ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
        invalidate();
      }
    };
    mFocusColorAnimator = ValueAnimator.ofInt(new int[] { i, j });
    mFocusColorAnimator.setEvaluator(new ArgbEvaluator());
    mFocusColorAnimator.addUpdateListener((ValueAnimator.AnimatorUpdateListener)localObject);
    mFocusColorAnimator.setDuration(300L);
    mInactiveColorAnimator = ValueAnimator.ofInt(new int[] { j, i });
    mInactiveColorAnimator.setEvaluator(new ArgbEvaluator());
    mInactiveColorAnimator.addUpdateListener((ValueAnimator.AnimatorUpdateListener)localObject);
    mInactiveColorAnimator.setDuration(300L);
    mAlphaAnimator = ValueAnimator.ofInt(new int[] { 0, 255 });
    mAlphaAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        FloatingLabelEditText.access$202(FloatingLabelEditText.this, ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
        invalidate();
      }
    });
    setOnFocusChangeListener(this);
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (mOnTextChangedListener != null) {
      mOnTextChangedListener.onTextChanged(paramEditable);
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void focusNext()
  {
    if (getImeActionId() == 2) {}
    View localView;
    do
    {
      return;
      localView = focusSearch(2);
    } while (localView == null);
    localView.requestFocus();
  }
  
  @TargetApi(11)
  protected void handleTextColorOnFocus(boolean paramBoolean)
  {
    if ((Build.VERSION.SDK_INT >= 11) && (Looper.myLooper() != null))
    {
      if (paramBoolean) {
        mFocusColorAnimator.start();
      }
    }
    else {
      return;
    }
    mInactiveColorAnimator.start();
  }
  
  public abstract boolean isValid();
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (getText().length() > 0)
    {
      mHintPaint.setColor(mAnimatedHintColor);
      mHintPaint.setTextSize(getPaint().getTextSize() * 2.0F / 3.0F);
      mHintPaint.setAlpha(mHintAlpha);
      paramCanvas.drawText(getHint().toString(), mHorizontalTextOffset, mAnimatedHintHeight, mHintPaint);
    }
  }
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    handleTextColorOnFocus(paramBoolean);
    setErrorOnFocusChange(paramBoolean);
    if (mOnFocusChangeListener != null) {
      mOnFocusChangeListener.onFocusChange(paramView, paramBoolean);
    }
  }
  
  @TargetApi(14)
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    super.onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
    if ((Build.VERSION.SDK_INT >= 14) && (Looper.myLooper() != null) && (mPreviousTextLength == 0) && (paramCharSequence.length() > 0) && (!mHintAnimator.isStarted()))
    {
      mHintAnimator.start();
      mFocusColorAnimator.start();
      mAlphaAnimator.start();
    }
    mPreviousTextLength = paramCharSequence.length();
  }
  
  protected void setErrorOnFocusChange(boolean paramBoolean)
  {
    if ((!paramBoolean) && (!isValid())) {
      setError();
    }
  }
  
  public void setFocusChangeListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    mOnFocusChangeListener = paramOnFocusChangeListener;
  }
  
  public void setTextChangedListener(OnTextChangedListener paramOnTextChangedListener)
  {
    mOnTextChangedListener = paramOnTextChangedListener;
  }
  
  public void validate()
  {
    if (isValid())
    {
      clearError();
      return;
    }
    setError();
  }
  
  public static abstract interface OnTextChangedListener
  {
    public abstract void onTextChanged(Editable paramEditable);
  }
}

/* Location:
 * Qualified Name:     com.braintreepayments.cardform.view.FloatingLabelEditText
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */