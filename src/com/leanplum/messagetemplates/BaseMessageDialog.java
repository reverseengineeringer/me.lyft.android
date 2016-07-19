package com.leanplum.messagetemplates;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.RelativeLayout;

public class BaseMessageDialog
  extends Dialog
{
  private RelativeLayout a;
  private boolean b;
  private boolean c;
  protected BaseMessageOptions options;
  protected WebInterstitialOptions webOptions;
  
  protected BaseMessageDialog(Activity paramActivity, boolean paramBoolean, BaseMessageOptions paramBaseMessageOptions, WebInterstitialOptions paramWebInterstitialOptions) {}
  
  private static Shape a(int paramInt)
  {
    return new RoundRectShape(new float[] { paramInt, paramInt, paramInt, paramInt, paramInt, paramInt, paramInt, paramInt }, null, null);
  }
  
  public void cancel()
  {
    if (c) {
      return;
    }
    c = true;
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setInterpolator(new AccelerateInterpolator());
    localAlphaAnimation.setDuration(350L);
    localAlphaAnimation.setAnimationListener(new e(this));
    a.startAnimation(localAlphaAnimation);
  }
}

/* Location:
 * Qualified Name:     com.leanplum.messagetemplates.BaseMessageDialog
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */