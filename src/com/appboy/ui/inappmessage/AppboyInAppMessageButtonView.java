package com.appboy.ui.inappmessage;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.Button;
import com.appboy.Constants;
import com.appboy.ui.R.styleable;

public class AppboyInAppMessageButtonView
  extends Button
{
  private static final String TAG = String.format("%s.%s", new Object[] { Constants.APPBOY_LOG_TAG_PREFIX, AppboyInAppMessageButtonView.class.getName() });
  
  public AppboyInAppMessageButtonView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    try
    {
      paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.com_appboy_ui_inappmessage_AppboyInAppMessageButtonView);
      int i = 0;
      for (;;)
      {
        if (i < paramAttributeSet.getIndexCount())
        {
          String str;
          if (paramAttributeSet.getIndex(i) == R.styleable.com_appboy_ui_inappmessage_AppboyInAppMessageButtonView_appboyInAppMessageCustomFontFile) {
            str = paramAttributeSet.getString(i);
          }
          try
          {
            setTypeface(Typeface.createFromAsset(paramContext.getAssets(), str));
            i += 1;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              Log.w(TAG, "Error loading custom typeface from: " + str, localException);
            }
          }
        }
      }
      paramAttributeSet.recycle();
    }
    catch (Exception paramContext)
    {
      Log.w(TAG, "Error while checking for custom typeface.", paramContext);
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.appboy.ui.inappmessage.AppboyInAppMessageButtonView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */