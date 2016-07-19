package com.appboy.ui.inappmessage.factories;

import android.content.res.Resources;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import com.appboy.enums.inappmessage.SlideFrom;
import com.appboy.models.IInAppMessage;
import com.appboy.models.InAppMessageSlideup;
import com.appboy.ui.inappmessage.IInAppMessageAnimationFactory;
import com.appboy.ui.support.AnimationUtils;

public class AppboyInAppMessageAnimationFactory
  implements IInAppMessageAnimationFactory
{
  private final int mShortAnimationDurationMillis = Resources.getSystem().getInteger(17694720);
  
  public Animation getClosingAnimation(IInAppMessage paramIInAppMessage)
  {
    if ((paramIInAppMessage instanceof InAppMessageSlideup))
    {
      if (((InAppMessageSlideup)paramIInAppMessage).getSlideFrom() == SlideFrom.TOP) {
        return AnimationUtils.createVerticalAnimation(0.0F, -1.0F, mShortAnimationDurationMillis, false);
      }
      return AnimationUtils.createVerticalAnimation(0.0F, 1.0F, mShortAnimationDurationMillis, false);
    }
    return AnimationUtils.setAnimationParams(new AlphaAnimation(1.0F, 0.0F), mShortAnimationDurationMillis, false);
  }
  
  public Animation getOpeningAnimation(IInAppMessage paramIInAppMessage)
  {
    if ((paramIInAppMessage instanceof InAppMessageSlideup))
    {
      if (((InAppMessageSlideup)paramIInAppMessage).getSlideFrom() == SlideFrom.TOP) {
        return AnimationUtils.createVerticalAnimation(-1.0F, 0.0F, mShortAnimationDurationMillis, false);
      }
      return AnimationUtils.createVerticalAnimation(1.0F, 0.0F, mShortAnimationDurationMillis, false);
    }
    return AnimationUtils.setAnimationParams(new AlphaAnimation(0.0F, 1.0F), mShortAnimationDurationMillis, true);
  }
}

/* Location:
 * Qualified Name:     com.appboy.ui.inappmessage.factories.AppboyInAppMessageAnimationFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */