package com.appboy.ui.inappmessage.factories;

import android.app.Activity;
import android.view.LayoutInflater;
import com.appboy.models.IInAppMessage;
import com.appboy.models.InAppMessageSlideup;
import com.appboy.support.StringUtils;
import com.appboy.ui.R.layout;
import com.appboy.ui.inappmessage.IInAppMessageViewFactory;
import com.appboy.ui.inappmessage.views.AppboyInAppMessageSlideupView;
import com.appboy.ui.support.FrescoLibraryUtils;

public class AppboySlideupViewFactory
  implements IInAppMessageViewFactory
{
  public AppboyInAppMessageSlideupView createInAppMessageView(Activity paramActivity, IInAppMessage paramIInAppMessage)
  {
    InAppMessageSlideup localInAppMessageSlideup = (InAppMessageSlideup)paramIInAppMessage;
    AppboyInAppMessageSlideupView localAppboyInAppMessageSlideupView = (AppboyInAppMessageSlideupView)paramActivity.getLayoutInflater().inflate(R.layout.com_appboy_inappmessage_slideup, null);
    localAppboyInAppMessageSlideupView.inflateStubViews();
    if (FrescoLibraryUtils.canUseFresco(paramActivity.getApplicationContext())) {
      if (!StringUtils.isNullOrBlank(paramIInAppMessage.getLocalImageUrl())) {
        localAppboyInAppMessageSlideupView.setMessageSimpleDrawee(paramIInAppMessage.getLocalImageUrl());
      }
    }
    for (;;)
    {
      localAppboyInAppMessageSlideupView.setMessageBackgroundColor(localInAppMessageSlideup.getBackgroundColor());
      localAppboyInAppMessageSlideupView.setMessage(localInAppMessageSlideup.getMessage());
      localAppboyInAppMessageSlideupView.setMessageTextColor(localInAppMessageSlideup.getMessageTextColor());
      localAppboyInAppMessageSlideupView.setMessageIcon(localInAppMessageSlideup.getIcon(), localInAppMessageSlideup.getIconColor(), localInAppMessageSlideup.getIconBackgroundColor());
      localAppboyInAppMessageSlideupView.setMessageChevron(localInAppMessageSlideup.getChevronColor(), localInAppMessageSlideup.getClickAction());
      localAppboyInAppMessageSlideupView.resetMessageMargins(paramIInAppMessage.getImageDownloadSuccessful());
      return localAppboyInAppMessageSlideupView;
      localAppboyInAppMessageSlideupView.setMessageSimpleDrawee(paramIInAppMessage.getRemoteImageUrl());
      continue;
      localAppboyInAppMessageSlideupView.setMessageImageView(localInAppMessageSlideup.getBitmap());
    }
  }
}

/* Location:
 * Qualified Name:     com.appboy.ui.inappmessage.factories.AppboySlideupViewFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */