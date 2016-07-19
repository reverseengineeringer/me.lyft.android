package me.lyft.android.infrastructure.appboy;

import android.app.Activity;
import com.appboy.Appboy;
import com.appboy.AppboyUser;
import com.appboy.models.IInAppMessage;
import com.appboy.models.MessageButton;
import com.appboy.ui.inappmessage.AppboyInAppMessageManager;
import com.appboy.ui.inappmessage.InAppMessageCloser;
import com.appboy.ui.inappmessage.InAppMessageOperation;
import com.appboy.ui.inappmessage.listeners.IInAppMessageManagerListener;
import com.squareup.picasso.RequestCreator;
import me.lyft.android.application.IUserProvider;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.common.Strings;
import me.lyft.android.domain.User;
import me.lyft.android.infrastructure.activity.ActivityService;
import me.lyft.android.infrastructure.gcm.IGcmIdService;
import me.lyft.android.infrastructure.notifications.InAppNotificationService;
import me.lyft.android.managers.ImageLoader;
import me.lyft.android.ui.AppboyScreens.AppBoyInappDialog;
import rx.Observable;
import rx.Subscription;
import rx.functions.Action1;
import rx.subscriptions.Subscriptions;

public class AppboyService
  extends ActivityService
  implements IInAppMessageManagerListener, IAppboyService
{
  boolean appboyRefreshData;
  IInAppMessage cachedMessage;
  DialogFlow dialogFlow;
  IGcmIdService gcmIdService;
  ImageLoader imageLoader;
  InAppNotificationService inAppNotificationService;
  boolean inappNoteDisplayEnabled = false;
  private Action1<? super User> onUserUpdate = new Action1()
  {
    public void call(User paramAnonymousUser)
    {
      AppboyService.this.updateUserId(paramAnonymousUser);
      AppboyService.this.updateGcmId();
    }
  };
  IUserProvider userProvider;
  private Subscription userSubscription = Subscriptions.empty();
  
  public AppboyService(IUserProvider paramIUserProvider, IGcmIdService paramIGcmIdService, DialogFlow paramDialogFlow, ImageLoader paramImageLoader, InAppNotificationService paramInAppNotificationService)
  {
    userProvider = paramIUserProvider;
    gcmIdService = paramIGcmIdService;
    dialogFlow = paramDialogFlow;
    imageLoader = paramImageLoader;
    inAppNotificationService = paramInAppNotificationService;
  }
  
  private boolean cacheImageForInAppMessage(IInAppMessage paramIInAppMessage)
  {
    String str = paramIInAppMessage.getImageUrl();
    if (!Strings.isNullOrBlank(str))
    {
      imageLoader.load(str).fetch();
      cachedMessage = paramIInAppMessage;
    }
    if (inappNoteDisplayEnabled)
    {
      displayCachedMessage();
      return true;
    }
    return false;
  }
  
  private void displayCachedMessage()
  {
    AppboyScreens.AppBoyInappDialog localAppBoyInappDialog = new AppboyScreens.AppBoyInappDialog(cachedMessage);
    dialogFlow.show(localAppBoyInappDialog);
    cachedMessage = null;
  }
  
  private void startAppboySession(Activity paramActivity)
  {
    if (Appboy.getInstance(paramActivity).openSession(paramActivity)) {
      appboyRefreshData = true;
    }
    updateUserId(userProvider.getUser());
    updateGcmId();
  }
  
  private void updateGcmId()
  {
    String str = gcmIdService.getToken();
    if ((str != null) && (!str.equals(Appboy.getInstance(getCurrentActivity()).getAppboyPushMessageRegistrationId()))) {
      Appboy.getInstance(getCurrentActivity()).registerAppboyPushMessages(str);
    }
  }
  
  private void updateUserId(User paramUser)
  {
    paramUser = paramUser.getId();
    String str = Appboy.getInstance(getCurrentActivity()).getCurrentUser().getUserId();
    if ((!Strings.isNullOrEmpty(paramUser)) && (!paramUser.equals(str))) {
      Appboy.getInstance(getCurrentActivity()).changeUser(paramUser);
    }
  }
  
  public InAppMessageOperation beforeInAppMessageDisplayed(IInAppMessage paramIInAppMessage)
  {
    if ((!inappNoteDisplayEnabled) && (!inAppNotificationService.didShowNotificationForSession())) {
      return InAppMessageOperation.DISPLAY_LATER;
    }
    if (cachedMessage != null)
    {
      displayCachedMessage();
      return InAppMessageOperation.DISCARD;
    }
    cachedMessage = paramIInAppMessage;
    if (cacheImageForInAppMessage(cachedMessage)) {
      return InAppMessageOperation.DISCARD;
    }
    return InAppMessageOperation.DISPLAY_LATER;
  }
  
  public void disableInappNoteDisplay()
  {
    inappNoteDisplayEnabled = false;
  }
  
  public void enableInappNoteDisplay()
  {
    inappNoteDisplayEnabled = true;
    AppboyInAppMessageManager.getInstance().requestDisplayInAppMessage();
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    userSubscription.unsubscribe();
    super.onActivityPaused(paramActivity);
    AppboyInAppMessageManager.getInstance().unregisterInAppMessageManager(paramActivity);
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    super.onActivityResumed(paramActivity);
    userSubscription = userProvider.observeUserUpdates().subscribe(onUserUpdate);
    AppboyInAppMessageManager.getInstance().registerInAppMessageManager(paramActivity);
    AppboyInAppMessageManager.getInstance().setCustomInAppMessageManagerListener(this);
    if (appboyRefreshData) {
      Appboy.getInstance(paramActivity).requestInAppMessageRefresh();
    }
  }
  
  public void onActivityStarted(Activity paramActivity)
  {
    super.onActivityStarted(paramActivity);
    startAppboySession(paramActivity);
  }
  
  public void onActivityStopped(Activity paramActivity)
  {
    Appboy.getInstance(paramActivity).closeSession(paramActivity);
    super.onActivityStopped(paramActivity);
  }
  
  public boolean onInAppMessageButtonClicked(MessageButton paramMessageButton, InAppMessageCloser paramInAppMessageCloser)
  {
    return false;
  }
  
  public boolean onInAppMessageClicked(IInAppMessage paramIInAppMessage, InAppMessageCloser paramInAppMessageCloser)
  {
    return false;
  }
  
  public void onInAppMessageDismissed(IInAppMessage paramIInAppMessage) {}
  
  public boolean onInAppMessageReceived(IInAppMessage paramIInAppMessage)
  {
    return false;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.appboy.AppboyService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */