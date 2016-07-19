package com.appboy.ui.inappmessage.views;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.PorterDuff.Mode;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.appboy.Constants;
import com.appboy.models.MessageButton;
import com.appboy.support.AppboyLogger;
import com.appboy.ui.R.color;
import com.appboy.ui.inappmessage.AppboyInAppMessageManager;
import com.appboy.ui.support.ViewUtils;
import java.util.List;

public class InAppMessageViewUtils
{
  private static final String TAG = String.format("%s.%s", new Object[] { Constants.APPBOY_LOG_TAG_PREFIX, InAppMessageViewUtils.class.getName() });
  
  public static void closeInAppMessageOnKeycodeBack()
  {
    AppboyLogger.d(TAG, "Back button intercepted by in-app message view, closing in-app message.");
    AppboyInAppMessageManager.getInstance().hideCurrentInAppMessage(true, true);
  }
  
  public static boolean isValidIcon(String paramString)
  {
    return paramString != null;
  }
  
  public static boolean isValidInAppMessageColor(int paramInt)
  {
    return paramInt != 0;
  }
  
  protected static void resetButtonSizesIfNecessary(List<View> paramList, List<MessageButton> paramList1)
  {
    if ((paramList1 != null) && (paramList1.size() == 1))
    {
      paramList1 = new LinearLayout.LayoutParams(0, -2, 1.0F);
      ((View)paramList.get(0)).setLayoutParams(paramList1);
    }
  }
  
  protected static void resetMessageMarginsIfNecessary(TextView paramTextView1, TextView paramTextView2)
  {
    if ((paramTextView2 == null) && (paramTextView1 != null))
    {
      paramTextView2 = new LinearLayout.LayoutParams(-2, -2);
      paramTextView2.setMargins(0, 0, 0, 0);
      paramTextView1.setLayoutParams(paramTextView2);
    }
  }
  
  public static void setButtons(List<View> paramList, View paramView, int paramInt, List<MessageButton> paramList1)
  {
    if ((paramList1 == null) || (paramList1.size() == 0))
    {
      ViewUtils.removeViewFromParent(paramView);
      return;
    }
    int i = 0;
    label21:
    if (i < paramList.size())
    {
      if (paramList1.size() > i) {
        break label68;
      }
      ((View)paramList.get(i)).setVisibility(8);
    }
    for (;;)
    {
      i += 1;
      break label21;
      break;
      label68:
      if ((paramList.get(i) instanceof Button))
      {
        paramView = (Button)paramList.get(i);
        MessageButton localMessageButton = (MessageButton)paramList1.get(i);
        paramView.setText(localMessageButton.getText());
        setTextViewColor(paramView, localMessageButton.getTextColor());
        setDrawableColor(paramView.getBackground(), localMessageButton.getBackgroundColor(), paramInt);
      }
    }
  }
  
  public static void setDrawableColor(Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    if ((paramDrawable instanceof GradientDrawable))
    {
      setDrawableColor((GradientDrawable)paramDrawable, paramInt1, paramInt2);
      return;
    }
    if (isValidInAppMessageColor(paramInt1))
    {
      paramDrawable.setColorFilter(paramInt1, PorterDuff.Mode.MULTIPLY);
      return;
    }
    paramDrawable.setColorFilter(paramInt2, PorterDuff.Mode.MULTIPLY);
  }
  
  public static void setDrawableColor(GradientDrawable paramGradientDrawable, int paramInt1, int paramInt2)
  {
    if (isValidInAppMessageColor(paramInt1))
    {
      paramGradientDrawable.setColor(paramInt1);
      return;
    }
    paramGradientDrawable.setColor(paramInt2);
  }
  
  public static void setIcon(Context paramContext, String paramString, int paramInt1, int paramInt2, TextView paramTextView)
  {
    if (isValidIcon(paramString)) {}
    try
    {
      paramTextView.setTypeface(Typeface.createFromAsset(paramContext.getAssets(), "fontawesome-webfont.ttf"));
      paramTextView.setText(paramString);
      setTextViewColor(paramTextView, paramInt1);
      if (paramTextView.getBackground() != null)
      {
        setDrawableColor(paramTextView.getBackground(), paramInt2, paramContext.getResources().getColor(R.color.com_appboy_inappmessage_icon_background));
        return;
      }
    }
    catch (Exception paramContext)
    {
      AppboyLogger.e(TAG, "Caught exception setting icon typeface. Not rendering icon.", paramContext);
      return;
    }
    setViewBackgroundColor(paramTextView, paramInt2);
  }
  
  public static void setImage(Bitmap paramBitmap, ImageView paramImageView)
  {
    if (paramBitmap != null) {
      paramImageView.setImageBitmap(paramBitmap);
    }
  }
  
  public static void setModalFrameColor(View paramView, Integer paramInteger)
  {
    if (paramInteger != null) {
      paramView.setBackgroundColor(paramInteger.intValue());
    }
  }
  
  public static void setTextViewColor(TextView paramTextView, int paramInt)
  {
    if (isValidInAppMessageColor(paramInt)) {
      paramTextView.setTextColor(paramInt);
    }
  }
  
  public static void setViewBackgroundColor(View paramView, int paramInt)
  {
    if (isValidInAppMessageColor(paramInt)) {
      paramView.setBackgroundColor(paramInt);
    }
  }
  
  public static void setViewBackgroundColorFilter(View paramView, int paramInt1, int paramInt2)
  {
    if (isValidInAppMessageColor(paramInt1))
    {
      paramView.getBackground().setColorFilter(paramInt1, PorterDuff.Mode.MULTIPLY);
      return;
    }
    paramView.getBackground().setColorFilter(paramInt2, PorterDuff.Mode.MULTIPLY);
  }
}

/* Location:
 * Qualified Name:     com.appboy.ui.inappmessage.views.InAppMessageViewUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */