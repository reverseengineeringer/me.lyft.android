package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.cardview.R.color;
import android.support.v7.cardview.R.style;
import android.support.v7.cardview.R.styleable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;

public class CardView
  extends FrameLayout
{
  private static final int[] COLOR_BACKGROUND_ATTR = { 16842801 };
  private static final CardViewImpl IMPL;
  private final CardViewDelegate mCardViewDelegate = new CardViewDelegate()
  {
    private Drawable mCardBackground;
    
    public Drawable getCardBackground()
    {
      return mCardBackground;
    }
    
    public View getCardView()
    {
      return CardView.this;
    }
    
    public boolean getPreventCornerOverlap()
    {
      return CardView.this.getPreventCornerOverlap();
    }
    
    public boolean getUseCompatPadding()
    {
      return CardView.this.getUseCompatPadding();
    }
    
    public void setCardBackground(Drawable paramAnonymousDrawable)
    {
      mCardBackground = paramAnonymousDrawable;
      setBackgroundDrawable(paramAnonymousDrawable);
    }
    
    public void setMinWidthHeightInternal(int paramAnonymousInt1, int paramAnonymousInt2)
    {
      if (paramAnonymousInt1 > mUserSetMinWidth) {
        CardView.this.setMinimumWidth(paramAnonymousInt1);
      }
      if (paramAnonymousInt2 > mUserSetMinHeight) {
        CardView.this.setMinimumHeight(paramAnonymousInt2);
      }
    }
    
    public void setShadowPadding(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4)
    {
      mShadowBounds.set(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousInt4);
      CardView.this.setPadding(mContentPadding.left + paramAnonymousInt1, mContentPadding.top + paramAnonymousInt2, mContentPadding.right + paramAnonymousInt3, mContentPadding.bottom + paramAnonymousInt4);
    }
  };
  private boolean mCompatPadding;
  private final Rect mContentPadding = new Rect();
  private boolean mPreventCornerOverlap;
  private final Rect mShadowBounds = new Rect();
  private int mUserSetMinHeight;
  private int mUserSetMinWidth;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 21) {
      IMPL = new CardViewApi21();
    }
    for (;;)
    {
      IMPL.initStatic();
      return;
      if (Build.VERSION.SDK_INT >= 17) {
        IMPL = new CardViewJellybeanMr1();
      } else {
        IMPL = new CardViewEclairMr1();
      }
    }
  }
  
  public CardView(Context paramContext)
  {
    super(paramContext);
    initialize(paramContext, null, 0);
  }
  
  public CardView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initialize(paramContext, paramAttributeSet, 0);
  }
  
  public CardView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initialize(paramContext, paramAttributeSet, paramInt);
  }
  
  private void initialize(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.CardView, paramInt, R.style.CardView);
    if (paramAttributeSet.hasValue(R.styleable.CardView_cardBackgroundColor))
    {
      paramInt = paramAttributeSet.getColor(R.styleable.CardView_cardBackgroundColor, 0);
      float f4 = paramAttributeSet.getDimension(R.styleable.CardView_cardCornerRadius, 0.0F);
      float f2 = paramAttributeSet.getDimension(R.styleable.CardView_cardElevation, 0.0F);
      float f3 = paramAttributeSet.getDimension(R.styleable.CardView_cardMaxElevation, 0.0F);
      mCompatPadding = paramAttributeSet.getBoolean(R.styleable.CardView_cardUseCompatPadding, false);
      mPreventCornerOverlap = paramAttributeSet.getBoolean(R.styleable.CardView_cardPreventCornerOverlap, true);
      int i = paramAttributeSet.getDimensionPixelSize(R.styleable.CardView_contentPadding, 0);
      mContentPadding.left = paramAttributeSet.getDimensionPixelSize(R.styleable.CardView_contentPaddingLeft, i);
      mContentPadding.top = paramAttributeSet.getDimensionPixelSize(R.styleable.CardView_contentPaddingTop, i);
      mContentPadding.right = paramAttributeSet.getDimensionPixelSize(R.styleable.CardView_contentPaddingRight, i);
      mContentPadding.bottom = paramAttributeSet.getDimensionPixelSize(R.styleable.CardView_contentPaddingBottom, i);
      float f1 = f3;
      if (f2 > f3) {
        f1 = f2;
      }
      mUserSetMinWidth = paramAttributeSet.getDimensionPixelSize(R.styleable.CardView_android_minWidth, 0);
      mUserSetMinHeight = paramAttributeSet.getDimensionPixelSize(R.styleable.CardView_android_minHeight, 0);
      paramAttributeSet.recycle();
      IMPL.initialize(mCardViewDelegate, paramContext, paramInt, f4, f2, f1);
      return;
    }
    Object localObject = getContext().obtainStyledAttributes(COLOR_BACKGROUND_ATTR);
    paramInt = ((TypedArray)localObject).getColor(0, 0);
    ((TypedArray)localObject).recycle();
    localObject = new float[3];
    Color.colorToHSV(paramInt, (float[])localObject);
    if (localObject[2] > 0.5F) {}
    for (paramInt = getResources().getColor(R.color.cardview_light_background);; paramInt = getResources().getColor(R.color.cardview_dark_background)) {
      break;
    }
  }
  
  public float getCardElevation()
  {
    return IMPL.getElevation(mCardViewDelegate);
  }
  
  public int getContentPaddingBottom()
  {
    return mContentPadding.bottom;
  }
  
  public int getContentPaddingLeft()
  {
    return mContentPadding.left;
  }
  
  public int getContentPaddingRight()
  {
    return mContentPadding.right;
  }
  
  public int getContentPaddingTop()
  {
    return mContentPadding.top;
  }
  
  public float getMaxCardElevation()
  {
    return IMPL.getMaxElevation(mCardViewDelegate);
  }
  
  public boolean getPreventCornerOverlap()
  {
    return mPreventCornerOverlap;
  }
  
  public float getRadius()
  {
    return IMPL.getRadius(mCardViewDelegate);
  }
  
  public boolean getUseCompatPadding()
  {
    return mCompatPadding;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (!(IMPL instanceof CardViewApi21))
    {
      int i = View.MeasureSpec.getMode(paramInt1);
      switch (i)
      {
      default: 
        i = View.MeasureSpec.getMode(paramInt2);
        switch (i)
        {
        }
        break;
      }
      for (;;)
      {
        super.onMeasure(paramInt1, paramInt2);
        return;
        paramInt1 = View.MeasureSpec.makeMeasureSpec(Math.max((int)Math.ceil(IMPL.getMinWidth(mCardViewDelegate)), View.MeasureSpec.getSize(paramInt1)), i);
        break;
        paramInt2 = View.MeasureSpec.makeMeasureSpec(Math.max((int)Math.ceil(IMPL.getMinHeight(mCardViewDelegate)), View.MeasureSpec.getSize(paramInt2)), i);
      }
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void setCardBackgroundColor(int paramInt)
  {
    IMPL.setBackgroundColor(mCardViewDelegate, paramInt);
  }
  
  public void setCardElevation(float paramFloat)
  {
    IMPL.setElevation(mCardViewDelegate, paramFloat);
  }
  
  public void setMaxCardElevation(float paramFloat)
  {
    IMPL.setMaxElevation(mCardViewDelegate, paramFloat);
  }
  
  public void setMinimumHeight(int paramInt)
  {
    mUserSetMinHeight = paramInt;
    super.setMinimumHeight(paramInt);
  }
  
  public void setMinimumWidth(int paramInt)
  {
    mUserSetMinWidth = paramInt;
    super.setMinimumWidth(paramInt);
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void setPaddingRelative(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void setPreventCornerOverlap(boolean paramBoolean)
  {
    if (paramBoolean != mPreventCornerOverlap)
    {
      mPreventCornerOverlap = paramBoolean;
      IMPL.onPreventCornerOverlapChanged(mCardViewDelegate);
    }
  }
  
  public void setRadius(float paramFloat)
  {
    IMPL.setRadius(mCardViewDelegate, paramFloat);
  }
  
  public void setUseCompatPadding(boolean paramBoolean)
  {
    if (mCompatPadding != paramBoolean)
    {
      mCompatPadding = paramBoolean;
      IMPL.onCompatPaddingChanged(mCardViewDelegate);
    }
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.CardView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */