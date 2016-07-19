package com.appboy.ui.widget;

import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.appboy.ui.support.ViewUtils;

class BaseCardView$2
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  BaseCardView$2(BaseCardView paramBaseCardView, ImageView paramImageView, float paramFloat) {}
  
  public void onGlobalLayout()
  {
    int i = val$imageView.getWidth();
    val$imageView.setLayoutParams(new RelativeLayout.LayoutParams(i, (int)(i / val$aspectRatio)));
    ViewUtils.removeOnGlobalLayoutListenerSafe(val$imageView.getViewTreeObserver(), this);
  }
}

/* Location:
 * Qualified Name:     com.appboy.ui.widget.BaseCardView.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */