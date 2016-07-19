package com.appboy.ui.inappmessage.listeners;

import android.app.Activity;
import android.net.Uri;
import android.view.View;
import com.appboy.Constants;
import com.appboy.IAppboyNavigator;
import com.appboy.enums.inappmessage.ClickAction;
import com.appboy.models.IInAppMessage;
import com.appboy.models.IInAppMessageHtml;
import com.appboy.models.IInAppMessageImmersive;
import com.appboy.models.MessageButton;
import com.appboy.support.AppboyFileUtils;
import com.appboy.support.AppboyLogger;
import com.appboy.support.BundleUtils;
import com.appboy.support.WebContentUtils;
import com.appboy.ui.actions.ActionFactory;
import com.appboy.ui.actions.IAction;
import com.appboy.ui.inappmessage.AppboyInAppMessageManager;
import com.appboy.ui.inappmessage.InAppMessageCloser;

public class AppboyInAppMessageViewLifecycleListener
  implements IInAppMessageViewLifecycleListener
{
  private static final String TAG = String.format("%s.%s", new Object[] { Constants.APPBOY_LOG_TAG_PREFIX, AppboyInAppMessageViewLifecycleListener.class.getName() });
  
  private AppboyInAppMessageManager getInAppMessageManager()
  {
    return AppboyInAppMessageManager.getInstance();
  }
  
  private void performClickAction(ClickAction paramClickAction, IInAppMessage paramIInAppMessage, InAppMessageCloser paramInAppMessageCloser, Uri paramUri)
  {
    if (getInAppMessageManager().getActivity() == null)
    {
      AppboyLogger.w(TAG, "Can't perform click action because the cached activity is null.");
      return;
    }
    switch (paramClickAction)
    {
    default: 
      paramInAppMessageCloser.close(false);
      return;
    case ???: 
      paramIInAppMessage.setAnimateOut(false);
      paramInAppMessageCloser.close(false);
      getInAppMessageManager().getAppboyNavigator().gotoNewsFeed(getInAppMessageManager().getActivity(), BundleUtils.mapToBundle(paramIInAppMessage.getExtras()));
      return;
    case ???: 
      paramIInAppMessage.setAnimateOut(false);
      paramInAppMessageCloser.close(false);
      ActionFactory.createUriAction(getInAppMessageManager().getActivity(), paramUri.toString()).execute(getInAppMessageManager().getActivity());
      return;
    }
    paramInAppMessageCloser.close(true);
  }
  
  private void performInAppMessageButtonClicked(MessageButton paramMessageButton, IInAppMessage paramIInAppMessage, InAppMessageCloser paramInAppMessageCloser)
  {
    performClickAction(paramMessageButton.getClickAction(), paramIInAppMessage, paramInAppMessageCloser, paramMessageButton.getUri());
  }
  
  private void performInAppMessageClicked(IInAppMessage paramIInAppMessage, InAppMessageCloser paramInAppMessageCloser)
  {
    performClickAction(paramIInAppMessage.getClickAction(), paramIInAppMessage, paramInAppMessageCloser, paramIInAppMessage.getUri());
  }
  
  private void startClearHtmlInAppMessageAssetsThread()
  {
    new Thread(new Runnable()
    {
      public void run()
      {
        Activity localActivity = AppboyInAppMessageManager.getInstance().getActivity();
        if (localActivity != null) {
          AppboyFileUtils.deleteFileOrDirectory(WebContentUtils.getHtmlInAppMessageAssetCacheDirectory(localActivity));
        }
      }
    }).start();
  }
  
  public void afterClosed(IInAppMessage paramIInAppMessage)
  {
    AppboyLogger.d(TAG, "InAppMessageViewWrapper.IInAppMessageViewLifecycleListener.afterClosed called.");
    getInAppMessageManager().resetAfterInAppMessageClose();
    if ((paramIInAppMessage instanceof IInAppMessageHtml)) {
      startClearHtmlInAppMessageAssetsThread();
    }
  }
  
  public void afterOpened(View paramView, IInAppMessage paramIInAppMessage)
  {
    AppboyLogger.d(TAG, "InAppMessageViewWrapper.IInAppMessageViewLifecycleListener.afterOpened called.");
  }
  
  public void beforeClosed(View paramView, IInAppMessage paramIInAppMessage)
  {
    AppboyLogger.d(TAG, "InAppMessageViewWrapper.IInAppMessageViewLifecycleListener.beforeClosed called.");
  }
  
  public void beforeOpened(View paramView, IInAppMessage paramIInAppMessage)
  {
    AppboyLogger.d(TAG, "InAppMessageViewWrapper.IInAppMessageViewLifecycleListener.beforeOpened called.");
    paramIInAppMessage.logImpression();
  }
  
  public void onButtonClicked(InAppMessageCloser paramInAppMessageCloser, MessageButton paramMessageButton, IInAppMessageImmersive paramIInAppMessageImmersive)
  {
    AppboyLogger.d(TAG, "InAppMessageViewWrapper.IInAppMessageViewLifecycleListener.onButtonClicked called.");
    paramIInAppMessageImmersive.logButtonClick(paramMessageButton);
    if (!getInAppMessageManager().getInAppMessageManagerListener().onInAppMessageButtonClicked(paramMessageButton, paramInAppMessageCloser)) {
      performInAppMessageButtonClicked(paramMessageButton, paramIInAppMessageImmersive, paramInAppMessageCloser);
    }
  }
  
  public void onClicked(InAppMessageCloser paramInAppMessageCloser, View paramView, IInAppMessage paramIInAppMessage)
  {
    AppboyLogger.d(TAG, "InAppMessageViewWrapper.IInAppMessageViewLifecycleListener.onClicked called.");
    paramIInAppMessage.logClick();
    if (!getInAppMessageManager().getInAppMessageManagerListener().onInAppMessageClicked(paramIInAppMessage, paramInAppMessageCloser)) {
      performInAppMessageClicked(paramIInAppMessage, paramInAppMessageCloser);
    }
  }
  
  public void onDismissed(View paramView, IInAppMessage paramIInAppMessage)
  {
    AppboyLogger.d(TAG, "InAppMessageViewWrapper.IInAppMessageViewLifecycleListener.onDismissed called.");
    getInAppMessageManager().getInAppMessageManagerListener().onInAppMessageDismissed(paramIInAppMessage);
  }
}

/* Location:
 * Qualified Name:     com.appboy.ui.inappmessage.listeners.AppboyInAppMessageViewLifecycleListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */