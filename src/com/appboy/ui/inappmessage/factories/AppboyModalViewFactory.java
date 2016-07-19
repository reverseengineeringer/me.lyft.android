package com.appboy.ui.inappmessage.factories;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import com.appboy.models.IInAppMessage;
import com.appboy.models.InAppMessageModal;
import com.appboy.support.StringUtils;
import com.appboy.ui.R.layout;
import com.appboy.ui.inappmessage.IInAppMessageViewFactory;
import com.appboy.ui.inappmessage.views.AppboyInAppMessageModalView;
import com.appboy.ui.support.FrescoLibraryUtils;

public class AppboyModalViewFactory
  implements IInAppMessageViewFactory
{
  public AppboyInAppMessageModalView createInAppMessageView(Activity paramActivity, IInAppMessage paramIInAppMessage)
  {
    InAppMessageModal localInAppMessageModal = (InAppMessageModal)paramIInAppMessage;
    AppboyInAppMessageModalView localAppboyInAppMessageModalView = (AppboyInAppMessageModalView)paramActivity.getLayoutInflater().inflate(R.layout.com_appboy_inappmessage_modal, null);
    localAppboyInAppMessageModalView.inflateStubViews();
    if (FrescoLibraryUtils.canUseFresco(paramActivity.getApplicationContext())) {
      if (!StringUtils.isNullOrBlank(paramIInAppMessage.getLocalImageUrl())) {
        localAppboyInAppMessageModalView.setMessageSimpleDrawee(paramIInAppMessage.getLocalImageUrl());
      }
    }
    for (;;)
    {
      localAppboyInAppMessageModalView.getModalFrameView().setOnClickListener(null);
      localAppboyInAppMessageModalView.setMessageBackgroundColor(paramIInAppMessage.getBackgroundColor());
      localAppboyInAppMessageModalView.setMessage(paramIInAppMessage.getMessage());
      localAppboyInAppMessageModalView.setMessageTextColor(paramIInAppMessage.getMessageTextColor());
      localAppboyInAppMessageModalView.setMessageHeaderText(localInAppMessageModal.getHeader());
      localAppboyInAppMessageModalView.setMessageHeaderTextColor(localInAppMessageModal.getHeaderTextColor());
      localAppboyInAppMessageModalView.setModalFrameColor(localInAppMessageModal.getModalFrameColor());
      localAppboyInAppMessageModalView.setMessageIcon(paramIInAppMessage.getIcon(), paramIInAppMessage.getIconColor(), paramIInAppMessage.getIconBackgroundColor());
      localAppboyInAppMessageModalView.setMessageButtons(localInAppMessageModal.getMessageButtons());
      localAppboyInAppMessageModalView.setMessageCloseButtonColor(localInAppMessageModal.getCloseButtonColor());
      localAppboyInAppMessageModalView.resetMessageMargins(paramIInAppMessage.getImageDownloadSuccessful());
      return localAppboyInAppMessageModalView;
      localAppboyInAppMessageModalView.setMessageSimpleDrawee(paramIInAppMessage.getRemoteImageUrl());
      continue;
      localAppboyInAppMessageModalView.setMessageImageView(localInAppMessageModal.getBitmap());
    }
  }
}

/* Location:
 * Qualified Name:     com.appboy.ui.inappmessage.factories.AppboyModalViewFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */