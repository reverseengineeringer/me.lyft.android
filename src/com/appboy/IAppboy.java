package com.appboy;

import android.app.Activity;
import android.content.Intent;
import android.widget.ImageView;
import com.appboy.enums.SocialNetwork;
import com.appboy.events.FeedUpdatedEvent;
import com.appboy.events.IEventSubscriber;
import com.appboy.events.InAppMessageEvent;
import com.appboy.events.SubmitFeedbackFailed;
import com.appboy.events.SubmitFeedbackSucceeded;
import com.appboy.models.outgoing.AppboyProperties;
import java.math.BigDecimal;

public abstract interface IAppboy
{
  public abstract AppboyUser changeUser(String paramString);
  
  public abstract boolean closeSession(Activity paramActivity);
  
  public abstract void fetchAndRenderImage(String paramString, ImageView paramImageView);
  
  public abstract void fetchAndRenderImage(String paramString, ImageView paramImageView, boolean paramBoolean);
  
  public abstract IAppboyNavigator getAppboyNavigator();
  
  public abstract String getAppboyPushMessageRegistrationId();
  
  public abstract AppboyUser getCurrentUser();
  
  public abstract String getInstallTrackingId();
  
  public abstract boolean logCustomEvent(String paramString);
  
  public abstract boolean logCustomEvent(String paramString, AppboyProperties paramAppboyProperties);
  
  public abstract boolean logFeedCardClick(String paramString);
  
  public abstract boolean logFeedCardImpression(String paramString);
  
  public abstract boolean logFeedDisplayed();
  
  public abstract boolean logFeedbackDisplayed();
  
  public abstract boolean logPurchase(String paramString, int paramInt);
  
  public abstract boolean logPurchase(String paramString1, String paramString2, BigDecimal paramBigDecimal);
  
  public abstract boolean logPurchase(String paramString1, String paramString2, BigDecimal paramBigDecimal, int paramInt);
  
  public abstract boolean logPurchase(String paramString1, String paramString2, BigDecimal paramBigDecimal, int paramInt, AppboyProperties paramAppboyProperties);
  
  public abstract boolean logPurchase(String paramString1, String paramString2, BigDecimal paramBigDecimal, AppboyProperties paramAppboyProperties);
  
  public abstract boolean logPushNotificationActionClicked(String paramString1, String paramString2);
  
  public abstract boolean logPushNotificationOpened(Intent paramIntent);
  
  public abstract boolean logPushNotificationOpened(String paramString);
  
  public abstract boolean logShare(SocialNetwork paramSocialNetwork);
  
  public abstract boolean openSession(Activity paramActivity);
  
  public abstract void registerAppboyGcmMessages(String paramString);
  
  public abstract void registerAppboyPushMessages(String paramString);
  
  public abstract <T> void removeSingleSubscription(IEventSubscriber<T> paramIEventSubscriber, Class<T> paramClass);
  
  public abstract void requestFeedRefresh();
  
  public abstract void requestFeedRefreshFromCache();
  
  public abstract void requestImmediateDataFlush();
  
  public abstract void requestInAppMessageRefresh();
  
  public abstract void setAppboyNavigator(IAppboyNavigator paramIAppboyNavigator);
  
  public abstract boolean submitFeedback(String paramString1, String paramString2, boolean paramBoolean);
  
  public abstract void subscribeToFeedUpdates(IEventSubscriber<FeedUpdatedEvent> paramIEventSubscriber);
  
  public abstract void subscribeToFeedbackRequestEvents(IEventSubscriber<SubmitFeedbackSucceeded> paramIEventSubscriber, IEventSubscriber<SubmitFeedbackFailed> paramIEventSubscriber1);
  
  public abstract void subscribeToNewInAppMessages(IEventSubscriber<InAppMessageEvent> paramIEventSubscriber);
  
  public abstract void unregisterAppboyPushMessages();
}

/* Location:
 * Qualified Name:     com.appboy.IAppboy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */