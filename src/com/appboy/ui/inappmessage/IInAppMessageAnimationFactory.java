package com.appboy.ui.inappmessage;

import android.view.animation.Animation;
import com.appboy.models.IInAppMessage;

public abstract interface IInAppMessageAnimationFactory
{
  public abstract Animation getClosingAnimation(IInAppMessage paramIInAppMessage);
  
  public abstract Animation getOpeningAnimation(IInAppMessage paramIInAppMessage);
}

/* Location:
 * Qualified Name:     com.appboy.ui.inappmessage.IInAppMessageAnimationFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */