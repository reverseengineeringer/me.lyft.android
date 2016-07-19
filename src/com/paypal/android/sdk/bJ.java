package com.paypal.android.sdk;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.method.LinkMovementMethod;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class bj
{
  private static final Map a;
  private static Pattern b = Pattern.compile("^\\s*(\\d+(\\.\\d+)*)\\s*([a-zA-Z]+)\\s*$");
  private static HashMap c = new HashMap();
  
  static
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("px", Integer.valueOf(0));
    localHashMap.put("dip", Integer.valueOf(1));
    localHashMap.put("dp", Integer.valueOf(1));
    localHashMap.put("sp", Integer.valueOf(2));
    localHashMap.put("pt", Integer.valueOf(3));
    localHashMap.put("in", Integer.valueOf(4));
    localHashMap.put("mm", Integer.valueOf(5));
    a = Collections.unmodifiableMap(localHashMap);
  }
  
  public static float a(String paramString, Context paramContext)
  {
    if (paramString == null) {
      return 0.0F;
    }
    String str = paramString.toLowerCase();
    if (c.containsKey(str)) {
      return ((Float)c.get(str)).floatValue();
    }
    paramString = b.matcher(str);
    if (!paramString.matches()) {
      throw new NumberFormatException();
    }
    float f = Float.parseFloat(paramString.group(1));
    paramString = paramString.group(3).toLowerCase();
    Integer localInteger = (Integer)a.get(paramString);
    paramString = localInteger;
    if (localInteger == null) {
      paramString = Integer.valueOf(1);
    }
    f = TypedValue.applyDimension(paramString.intValue(), f, paramContext.getResources().getDisplayMetrics());
    c.put(str, Float.valueOf(f));
    return f;
  }
  
  public static Bitmap a(String paramString, Context paramContext, int paramInt)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    if (paramContext != null) {}
    for (inTargetDensity = getResourcesgetDisplayMetricsdensityDpi;; inTargetDensity = 160)
    {
      inDensity = 240;
      inScaled = false;
      paramString = Base64.decode(paramString, 0);
      return BitmapFactory.decodeByteArray(paramString, 0, paramString.length, localOptions);
    }
  }
  
  public static View a(LinearLayout paramLinearLayout)
  {
    View localView = new View(paramLinearLayout.getContext());
    paramLinearLayout.addView(localView);
    a(localView, new ColorDrawable(bi.f));
    a(localView, -1, "1dip");
    b(localView, null, "12dip", null, "12dip");
    return localView;
  }
  
  public static ViewGroup.LayoutParams a()
  {
    return new ViewGroup.LayoutParams(-1, -2);
  }
  
  public static ViewGroup a(Context paramContext)
  {
    paramContext = new ScrollView(paramContext);
    paramContext.setBackgroundColor(bi.d);
    return paramContext;
  }
  
  public static ImageView a(Context paramContext, String paramString1, String paramString2)
  {
    ImageView localImageView = new ImageView(paramContext);
    localImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    localImageView.setImageBitmap(b(paramString1, paramContext));
    localImageView.setAdjustViewBounds(true);
    localImageView.setContentDescription(paramString2);
    return localImageView;
  }
  
  public static LinearLayout a(Context paramContext, boolean paramBoolean, int paramInt, LinearLayout paramLinearLayout)
  {
    LinearLayout localLinearLayout = new LinearLayout(paramContext);
    if (paramInt != 0) {
      localLinearLayout.setId(paramInt);
    }
    paramLinearLayout.addView(localLinearLayout);
    localLinearLayout.setGravity(17);
    localLinearLayout.setOrientation(0);
    a(localLinearLayout, true, paramContext);
    a(localLinearLayout, -1, "58dip");
    b(localLinearLayout, null, null, null, "4dip");
    return localLinearLayout;
  }
  
  public static LinearLayout a(ViewGroup paramViewGroup)
  {
    LinearLayout localLinearLayout = new LinearLayout(paramViewGroup.getContext());
    localLinearLayout.setOrientation(1);
    localLinearLayout.setBackgroundColor(bi.d);
    paramViewGroup.addView(localLinearLayout);
    a(localLinearLayout, -1, -2);
    return localLinearLayout;
  }
  
  public static RelativeLayout.LayoutParams a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(3, 2301);
    return localLayoutParams;
  }
  
  public static RelativeLayout.LayoutParams a(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    paramContext = new RelativeLayout.LayoutParams(c(paramString1, paramContext), c(paramString2, paramContext));
    paramContext.addRule(paramInt);
    return paramContext;
  }
  
  public static void a(View paramView, int paramInt, float paramFloat)
  {
    paramView = paramView.getLayoutParams();
    if ((paramView instanceof LinearLayout.LayoutParams))
    {
      paramView = (LinearLayout.LayoutParams)paramView;
      gravity = paramInt;
      weight = paramFloat;
    }
  }
  
  public static void a(View paramView, int paramInt1, int paramInt2)
  {
    paramView = paramView.getLayoutParams();
    width = paramInt1;
    height = paramInt2;
  }
  
  public static void a(View paramView, int paramInt, String paramString)
  {
    a(paramView, -1, c(paramString, paramView.getContext()));
  }
  
  private static void a(View paramView, Drawable paramDrawable)
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      paramView.setBackground(paramDrawable);
      return;
    }
    paramView.setBackgroundDrawable(paramDrawable);
  }
  
  public static void a(View paramView, String paramString, int paramInt)
  {
    a(paramView, c(paramString, paramView.getContext()), -2);
  }
  
  public static void a(View paramView, String paramString1, String paramString2)
  {
    b(paramView, "4dip", paramString1, "4dip", paramString2);
  }
  
  public static void a(View paramView, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Context localContext = paramView.getContext();
    paramView.setPadding(c(paramString1, localContext), c(paramString2, localContext), c(paramString3, localContext), c(paramString4, localContext));
  }
  
  public static void a(View paramView, boolean paramBoolean, Context paramContext)
  {
    a(paramView, -1, -2);
    a(paramView, "10dip", "0dip", "10dip", "0dip");
    if (paramBoolean) {}
    for (Drawable localDrawable = bi.a(paramContext);; localDrawable = bi.b(paramContext))
    {
      a(paramView, localDrawable);
      paramView.setFocusable(true);
      paramView.setMinimumHeight(c("54dip", paramContext));
      if ((paramView instanceof TextView)) {
        a((TextView)paramView);
      }
      if (!(paramView instanceof Button)) {
        paramView.setClickable(true);
      }
      return;
    }
  }
  
  public static void a(Button paramButton)
  {
    a(paramButton, 17);
  }
  
  public static void a(TextView paramTextView)
  {
    paramTextView.setGravity(17);
    paramTextView.setTextColor(-1);
    paramTextView.setTextSize(20.0F);
    paramTextView.setTypeface(bi.j);
  }
  
  public static void a(TextView paramTextView, int paramInt)
  {
    a(paramTextView, "2dip", "2dip", "2dip", "2dip");
    paramTextView.setTypeface(bi.k);
    paramTextView.setTextColor(bi.p);
    if (Build.VERSION.SDK_INT < 16) {
      paramTextView.setBackgroundDrawable(bi.c(paramTextView.getContext()));
    }
    for (;;)
    {
      paramTextView.setAutoLinkMask(15);
      paramTextView.setTextSize(14.0F);
      paramTextView.setTextColor(bi.p);
      paramTextView.setGravity(paramInt);
      return;
      paramTextView.setBackground(bi.c(paramTextView.getContext()));
    }
  }
  
  public static Bitmap b(String paramString, Context paramContext)
  {
    return a(paramString, paramContext, 240);
  }
  
  public static LinearLayout b(ViewGroup paramViewGroup)
  {
    LinearLayout localLinearLayout = new LinearLayout(paramViewGroup.getContext());
    localLinearLayout.setOrientation(1);
    a(localLinearLayout, "10dip", "14dip", "10dip", "14dip");
    paramViewGroup.addView(localLinearLayout, a());
    return localLinearLayout;
  }
  
  public static void b(View paramView, String paramString1, String paramString2)
  {
    Context localContext = paramView.getContext();
    a(paramView, c(paramString1, localContext), c(paramString2, localContext));
  }
  
  public static void b(View paramView, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Context localContext = paramView.getContext();
    paramView = paramView.getLayoutParams();
    if ((paramView instanceof ViewGroup.MarginLayoutParams)) {
      ((ViewGroup.MarginLayoutParams)paramView).setMargins(c(paramString1, localContext), c(paramString2, localContext), c(paramString3, localContext), c(paramString4, localContext));
    }
  }
  
  public static void b(TextView paramTextView)
  {
    paramTextView.setTextColor(bi.i);
    paramTextView.setLinkTextColor(bi.p);
    paramTextView.setTypeface(bi.o);
    paramTextView.setTextSize(13.0F);
    paramTextView.setSingleLine(false);
    paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
  }
  
  public static void b(TextView paramTextView, int paramInt)
  {
    paramTextView.setTextSize(18.0F);
    paramTextView.setTypeface(bi.l);
    paramTextView.setSingleLine(true);
    paramTextView.setGravity(paramInt);
    paramTextView.setTextColor(bi.g);
  }
  
  private static int c(String paramString, Context paramContext)
  {
    if (paramString == null) {
      return 0;
    }
    return (int)a(paramString, paramContext);
  }
  
  public static void c(TextView paramTextView, int paramInt)
  {
    paramTextView.setTextSize(14.0F);
    paramTextView.setTypeface(bi.n);
    paramTextView.setSingleLine(true);
    paramTextView.setGravity(0);
    paramTextView.setTextColor(bi.g);
  }
}

/* Location:
 * Qualified Name:     com.paypal.android.sdk.bj
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */