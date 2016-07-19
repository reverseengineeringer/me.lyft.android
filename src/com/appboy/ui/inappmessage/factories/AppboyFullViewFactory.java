package com.appboy.ui.inappmessage.factories;

import android.app.Activity;
import android.view.LayoutInflater;
import com.appboy.models.IInAppMessage;
import com.appboy.models.InAppMessageFull;
import com.appboy.support.StringUtils;
import com.appboy.ui.R.layout;
import com.appboy.ui.inappmessage.IInAppMessageViewFactory;
import com.appboy.ui.inappmessage.views.AppboyInAppMessageFullView;
import com.appboy.ui.support.FrescoLibraryUtils;

public class AppboyFullViewFactory
  implements IInAppMessageViewFactory
{
  public AppboyInAppMessageFullView createInAppMessageView(Activity paramActivity, IInAppMessage paramIInAppMessage)
  {
    InAppMessageFull localInAppMessageFull = (InAppMessageFull)paramIInAppMessage;
    AppboyInAppMessageFullView localAppboyInAppMessageFullView = (AppboyInAppMessageFullView)paramActivity.getLayoutInflater().inflate(R.layout.com_appboy_inappmessage_full, null);
    localAppboyInAppMessageFullView.inflateStubViews();
    if (FrescoLibraryUtils.canUseFresco(paramActivity.getApplicationContext())) {
      if (!StringUtils.isNullOrBlank(paramIInAppMessage.getLocalImageUrl())) {
        localAppboyInAppMessageFullView.setMessageSimpleDrawee(paramIInAppMessage.getLocalImageUrl());
      }
    }
    for (;;)
    {
      localAppboyInAppMessageFullView.setMessageBackgroundColor(localInAppMessageFull.getBackgroundColor());
      localAppboyInAppMessageFullView.setMessage(localInAppMessageFull.getMessage());
      localAppboyInAppMessageFullView.setMessageTextColor(localInAppMessageFull.getMessageTextColor());
      localAppboyInAppMessageFullView.setMessageHeaderText(localInAppMessageFull.getHeader());
      localAppboyInAppMessageFullView.setMessageHeaderTextColor(localInAppMessageFull.getHeaderTextColor());
      localAppboyInAppMessageFullView.setMessageButtons(localInAppMessageFull.getMessageButtons());
      localAppboyInAppMessageFullView.setMessageCloseButtonColor(localInAppMessageFull.getCloseButtonColor());
      localAppboyInAppMessageFullView.resetMessageMargins(paramIInAppMessage.getImageDownloadSuccessful());
      return localAppboyInAppMessageFullView;
      localAppboyInAppMessageFullView.setMessageSimpleDrawee(paramIInAppMessage.getRemoteImageUrl());
      continue;
      localAppboyInAppMessageFullView.setMessageImageView(paramIInAppMessage.getBitmap());
    }
  }
}

/* Location:
 * Qualified Name:     com.appboy.ui.inappmessage.factories.AppboyFullViewFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */