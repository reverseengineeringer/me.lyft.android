package com.facebook;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.support.v4.content.ContextCompat;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.internal.FragmentWrapper;

public abstract class FacebookButtonBase
  extends Button
{
  private String analyticsButtonCreatedEventName;
  private String analyticsButtonTappedEventName;
  private View.OnClickListener externalOnClickListener;
  private View.OnClickListener internalOnClickListener;
  private boolean overrideCompoundPadding;
  private int overrideCompoundPaddingLeft;
  private int overrideCompoundPaddingRight;
  private FragmentWrapper parentFragment;
  
  protected FacebookButtonBase(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    super(paramContext, paramAttributeSet, 0);
    int i = paramInt2;
    if (paramInt2 == 0) {
      i = getDefaultStyleResource();
    }
    paramInt2 = i;
    if (i == 0) {
      paramInt2 = R.style.com_facebook_button;
    }
    configureButton(paramContext, paramAttributeSet, paramInt1, paramInt2);
    analyticsButtonCreatedEventName = paramString1;
    analyticsButtonTappedEventName = paramString2;
    setClickable(true);
    setFocusable(true);
  }
  
  private void logButtonCreated(Context paramContext)
  {
    AppEventsLogger.newLogger(paramContext).logSdkEvent(analyticsButtonCreatedEventName, null, null);
  }
  
  private void logButtonTapped(Context paramContext)
  {
    AppEventsLogger.newLogger(paramContext).logSdkEvent(analyticsButtonTappedEventName, null, null);
  }
  
  private void parseBackgroundAttributes(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    if (isInEditMode()) {
      return;
    }
    paramAttributeSet = paramContext.getTheme().obtainStyledAttributes(paramAttributeSet, new int[] { 16842964 }, paramInt1, paramInt2);
    for (;;)
    {
      try
      {
        if (paramAttributeSet.hasValue(0))
        {
          paramInt1 = paramAttributeSet.getResourceId(0, 0);
          if (paramInt1 != 0)
          {
            setBackgroundResource(paramInt1);
            return;
          }
          setBackgroundColor(paramAttributeSet.getColor(0, 0));
          continue;
        }
        setBackgroundColor(ContextCompat.getColor(paramContext, R.color.com_facebook_blue));
      }
      finally
      {
        paramAttributeSet.recycle();
      }
    }
  }
  
  @SuppressLint({"ResourceType"})
  private void parseCompoundDrawableAttributes(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    paramContext = paramContext.getTheme().obtainStyledAttributes(paramAttributeSet, new int[] { 16843119, 16843117, 16843120, 16843118, 16843121 }, paramInt1, paramInt2);
    try
    {
      setCompoundDrawablesWithIntrinsicBounds(paramContext.getResourceId(0, 0), paramContext.getResourceId(1, 0), paramContext.getResourceId(2, 0), paramContext.getResourceId(3, 0));
      setCompoundDrawablePadding(paramContext.getDimensionPixelSize(4, 0));
      return;
    }
    finally
    {
      paramContext.recycle();
    }
  }
  
  private void parseContentAttributes(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    paramContext = paramContext.getTheme().obtainStyledAttributes(paramAttributeSet, new int[] { 16842966, 16842967, 16842968, 16842969 }, paramInt1, paramInt2);
    try
    {
      setPadding(paramContext.getDimensionPixelSize(0, 0), paramContext.getDimensionPixelSize(1, 0), paramContext.getDimensionPixelSize(2, 0), paramContext.getDimensionPixelSize(3, 0));
      return;
    }
    finally
    {
      paramContext.recycle();
    }
  }
  
  /* Error */
  private void parseTextAttributes(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 84	android/content/Context:getTheme	()Landroid/content/res/Resources$Theme;
    //   4: aload_2
    //   5: iconst_1
    //   6: newarray <illegal type>
    //   8: dup
    //   9: iconst_0
    //   10: ldc -101
    //   12: iastore
    //   13: iload_3
    //   14: iload 4
    //   16: invokevirtual 91	android/content/res/Resources$Theme:obtainStyledAttributes	(Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;
    //   19: astore 5
    //   21: aload_0
    //   22: aload 5
    //   24: iconst_0
    //   25: invokevirtual 159	android/content/res/TypedArray:getColorStateList	(I)Landroid/content/res/ColorStateList;
    //   28: invokevirtual 163	com/facebook/FacebookButtonBase:setTextColor	(Landroid/content/res/ColorStateList;)V
    //   31: aload 5
    //   33: invokevirtual 109	android/content/res/TypedArray:recycle	()V
    //   36: aload_1
    //   37: invokevirtual 84	android/content/Context:getTheme	()Landroid/content/res/Resources$Theme;
    //   40: aload_2
    //   41: iconst_1
    //   42: newarray <illegal type>
    //   44: dup
    //   45: iconst_0
    //   46: ldc -92
    //   48: iastore
    //   49: iload_3
    //   50: iload 4
    //   52: invokevirtual 91	android/content/res/Resources$Theme:obtainStyledAttributes	(Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;
    //   55: astore 5
    //   57: aload_0
    //   58: aload 5
    //   60: iconst_0
    //   61: bipush 17
    //   63: invokevirtual 167	android/content/res/TypedArray:getInt	(II)I
    //   66: invokevirtual 170	com/facebook/FacebookButtonBase:setGravity	(I)V
    //   69: aload 5
    //   71: invokevirtual 109	android/content/res/TypedArray:recycle	()V
    //   74: aload_1
    //   75: invokevirtual 84	android/content/Context:getTheme	()Landroid/content/res/Resources$Theme;
    //   78: aload_2
    //   79: iconst_3
    //   80: newarray <illegal type>
    //   82: dup
    //   83: iconst_0
    //   84: ldc -85
    //   86: iastore
    //   87: dup
    //   88: iconst_1
    //   89: ldc -84
    //   91: iastore
    //   92: dup
    //   93: iconst_2
    //   94: ldc -83
    //   96: iastore
    //   97: iload_3
    //   98: iload 4
    //   100: invokevirtual 91	android/content/res/Resources$Theme:obtainStyledAttributes	(Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;
    //   103: astore_1
    //   104: aload_0
    //   105: iconst_0
    //   106: aload_1
    //   107: iconst_0
    //   108: iconst_0
    //   109: invokevirtual 141	android/content/res/TypedArray:getDimensionPixelSize	(II)I
    //   112: i2f
    //   113: invokevirtual 177	com/facebook/FacebookButtonBase:setTextSize	(IF)V
    //   116: aload_0
    //   117: aload_1
    //   118: iconst_1
    //   119: iconst_1
    //   120: invokevirtual 167	android/content/res/TypedArray:getInt	(II)I
    //   123: invokestatic 183	android/graphics/Typeface:defaultFromStyle	(I)Landroid/graphics/Typeface;
    //   126: invokevirtual 187	com/facebook/FacebookButtonBase:setTypeface	(Landroid/graphics/Typeface;)V
    //   129: aload_0
    //   130: aload_1
    //   131: iconst_2
    //   132: invokevirtual 191	android/content/res/TypedArray:getString	(I)Ljava/lang/String;
    //   135: invokevirtual 195	com/facebook/FacebookButtonBase:setText	(Ljava/lang/CharSequence;)V
    //   138: aload_1
    //   139: invokevirtual 109	android/content/res/TypedArray:recycle	()V
    //   142: return
    //   143: astore_1
    //   144: aload 5
    //   146: invokevirtual 109	android/content/res/TypedArray:recycle	()V
    //   149: aload_1
    //   150: athrow
    //   151: astore_1
    //   152: aload 5
    //   154: invokevirtual 109	android/content/res/TypedArray:recycle	()V
    //   157: aload_1
    //   158: athrow
    //   159: astore_2
    //   160: aload_1
    //   161: invokevirtual 109	android/content/res/TypedArray:recycle	()V
    //   164: aload_2
    //   165: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	166	0	this	FacebookButtonBase
    //   0	166	1	paramContext	Context
    //   0	166	2	paramAttributeSet	AttributeSet
    //   0	166	3	paramInt1	int
    //   0	166	4	paramInt2	int
    //   19	134	5	localTypedArray	TypedArray
    // Exception table:
    //   from	to	target	type
    //   21	31	143	finally
    //   57	69	151	finally
    //   104	138	159	finally
  }
  
  private void setupOnClickListener()
  {
    super.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        FacebookButtonBase.this.logButtonTapped(getContext());
        if (internalOnClickListener != null) {
          internalOnClickListener.onClick(paramAnonymousView);
        }
        while (externalOnClickListener == null) {
          return;
        }
        externalOnClickListener.onClick(paramAnonymousView);
      }
    });
  }
  
  protected void callExternalOnClickListener(View paramView)
  {
    if (externalOnClickListener != null) {
      externalOnClickListener.onClick(paramView);
    }
  }
  
  protected void configureButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    parseBackgroundAttributes(paramContext, paramAttributeSet, paramInt1, paramInt2);
    parseCompoundDrawableAttributes(paramContext, paramAttributeSet, paramInt1, paramInt2);
    parseContentAttributes(paramContext, paramAttributeSet, paramInt1, paramInt2);
    parseTextAttributes(paramContext, paramAttributeSet, paramInt1, paramInt2);
    setupOnClickListener();
  }
  
  protected Activity getActivity()
  {
    for (Context localContext = getContext(); (!(localContext instanceof Activity)) && ((localContext instanceof ContextWrapper)); localContext = ((ContextWrapper)localContext).getBaseContext()) {}
    if ((localContext instanceof Activity)) {
      return (Activity)localContext;
    }
    throw new FacebookException("Unable to get Activity.");
  }
  
  public int getCompoundPaddingLeft()
  {
    if (overrideCompoundPadding) {
      return overrideCompoundPaddingLeft;
    }
    return super.getCompoundPaddingLeft();
  }
  
  public int getCompoundPaddingRight()
  {
    if (overrideCompoundPadding) {
      return overrideCompoundPaddingRight;
    }
    return super.getCompoundPaddingRight();
  }
  
  protected abstract int getDefaultRequestCode();
  
  protected int getDefaultStyleResource()
  {
    return 0;
  }
  
  public android.support.v4.app.Fragment getFragment()
  {
    if (parentFragment != null) {
      return parentFragment.getSupportFragment();
    }
    return null;
  }
  
  public android.app.Fragment getNativeFragment()
  {
    if (parentFragment != null) {
      return parentFragment.getNativeFragment();
    }
    return null;
  }
  
  public int getRequestCode()
  {
    return getDefaultRequestCode();
  }
  
  protected int measureTextWidth(String paramString)
  {
    return (int)Math.ceil(getPaint().measureText(paramString));
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (!isInEditMode()) {
      logButtonCreated(getContext());
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if ((getGravity() & 0x1) != 0) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        i = getCompoundPaddingLeft();
        int j = getCompoundPaddingRight();
        int k = getCompoundDrawablePadding();
        k = Math.min((getWidth() - (i + k) - j - measureTextWidth(getText().toString())) / 2, (i - getPaddingLeft()) / 2);
        overrideCompoundPaddingLeft = (i - k);
        overrideCompoundPaddingRight = (j + k);
        overrideCompoundPadding = true;
      }
      super.onDraw(paramCanvas);
      overrideCompoundPadding = false;
      return;
    }
  }
  
  public void setFragment(android.app.Fragment paramFragment)
  {
    parentFragment = new FragmentWrapper(paramFragment);
  }
  
  public void setFragment(android.support.v4.app.Fragment paramFragment)
  {
    parentFragment = new FragmentWrapper(paramFragment);
  }
  
  protected void setInternalOnClickListener(View.OnClickListener paramOnClickListener)
  {
    internalOnClickListener = paramOnClickListener;
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    externalOnClickListener = paramOnClickListener;
  }
}

/* Location:
 * Qualified Name:     com.facebook.FacebookButtonBase
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */