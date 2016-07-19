package com.appboy.ui.inappmessage;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import com.appboy.Appboy;
import com.appboy.Constants;
import com.appboy.IAppboyNavigator;
import com.appboy.events.IEventSubscriber;
import com.appboy.events.InAppMessageEvent;
import com.appboy.managers.InAppMessageManagerStateListener;
import com.appboy.models.IInAppMessage;
import com.appboy.models.InAppMessageFull;
import com.appboy.models.InAppMessageHtmlFull;
import com.appboy.models.InAppMessageModal;
import com.appboy.models.InAppMessageSlideup;
import com.appboy.support.AppboyLogger;
import com.appboy.ui.AppboyNavigator;
import com.appboy.ui.inappmessage.factories.AppboyFullViewFactory;
import com.appboy.ui.inappmessage.factories.AppboyHtmlFullViewFactory;
import com.appboy.ui.inappmessage.factories.AppboyInAppMessageAnimationFactory;
import com.appboy.ui.inappmessage.factories.AppboyModalViewFactory;
import com.appboy.ui.inappmessage.factories.AppboySlideupViewFactory;
import com.appboy.ui.inappmessage.listeners.AppboyDefaultHtmlInAppMessageActionListener;
import com.appboy.ui.inappmessage.listeners.AppboyDefaultInAppMessageManagerListener;
import com.appboy.ui.inappmessage.listeners.AppboyInAppMessageViewLifecycleListener;
import com.appboy.ui.inappmessage.listeners.AppboyInAppMessageWebViewClientListener;
import com.appboy.ui.inappmessage.listeners.IHtmlInAppMessageActionListener;
import com.appboy.ui.inappmessage.listeners.IInAppMessageManagerListener;
import com.appboy.ui.inappmessage.listeners.IInAppMessageViewLifecycleListener;
import com.appboy.ui.inappmessage.listeners.IInAppMessageWebViewClientListener;
import com.appboy.ui.support.ViewUtils;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicBoolean;

public final class AppboyInAppMessageManager
{
  private static final String TAG = String.format("%s.%s", new Object[] { Constants.APPBOY_LOG_TAG_PREFIX, AppboyInAppMessageManager.class.getName() });
  private static volatile AppboyInAppMessageManager sInstance = null;
  private Activity mActivity;
  private Context mApplicationContext;
  private IInAppMessage mCarryoverInAppMessage;
  private IHtmlInAppMessageActionListener mCustomHtmlInAppMessageActionListener;
  private IInAppMessageAnimationFactory mCustomInAppMessageAnimationFactory;
  private IInAppMessageManagerListener mCustomInAppMessageManagerListener;
  private IInAppMessageViewFactory mCustomInAppMessageViewFactory;
  private final IAppboyNavigator mDefaultAppboyNavigator = new AppboyNavigator();
  private IHtmlInAppMessageActionListener mDefaultHtmlInAppMessageActionListener = new AppboyDefaultHtmlInAppMessageActionListener();
  private IInAppMessageManagerListener mDefaultInAppMessageManagerListener = new AppboyDefaultInAppMessageManagerListener();
  private AtomicBoolean mDisplayingInAppMessage = new AtomicBoolean(false);
  private IInAppMessageAnimationFactory mInAppMessageAnimationFactory = new AppboyInAppMessageAnimationFactory();
  private IEventSubscriber<InAppMessageEvent> mInAppMessageEventSubscriber;
  private IInAppMessageViewFactory mInAppMessageFullViewFactory = new AppboyFullViewFactory();
  private IInAppMessageViewFactory mInAppMessageHtmlFullViewFactory = new AppboyHtmlFullViewFactory(mInAppMessageWebViewClientListener);
  private IInAppMessageViewFactory mInAppMessageModalViewFactory = new AppboyModalViewFactory();
  private IInAppMessageViewFactory mInAppMessageSlideupViewFactory = new AppboySlideupViewFactory();
  private final Stack<IInAppMessage> mInAppMessageStack = new Stack();
  private final IInAppMessageViewLifecycleListener mInAppMessageViewLifecycleListener = new AppboyInAppMessageViewLifecycleListener();
  private IInAppMessageViewWrapper mInAppMessageViewWrapper;
  private final IInAppMessageWebViewClientListener mInAppMessageWebViewClientListener = new AppboyInAppMessageWebViewClientListener();
  
  private IEventSubscriber<InAppMessageEvent> createInAppMessageEventSubscriber()
  {
    new IEventSubscriber()
    {
      public void trigger(InAppMessageEvent paramAnonymousInAppMessageEvent)
      {
        if (getInAppMessageManagerListener().onInAppMessageReceived(paramAnonymousInAppMessageEvent.getInAppMessage())) {
          return;
        }
        addInAppMessage(paramAnonymousInAppMessageEvent.getInAppMessage());
      }
    };
  }
  
  private IInAppMessageAnimationFactory getInAppMessageAnimationFactory()
  {
    if (mCustomInAppMessageAnimationFactory != null) {
      return mCustomInAppMessageAnimationFactory;
    }
    return mInAppMessageAnimationFactory;
  }
  
  private IInAppMessageViewFactory getInAppMessageViewFactory(IInAppMessage paramIInAppMessage)
  {
    if (mCustomInAppMessageViewFactory != null) {
      return mCustomInAppMessageViewFactory;
    }
    if ((paramIInAppMessage instanceof InAppMessageSlideup)) {
      return mInAppMessageSlideupViewFactory;
    }
    if ((paramIInAppMessage instanceof InAppMessageModal)) {
      return mInAppMessageModalViewFactory;
    }
    if ((paramIInAppMessage instanceof InAppMessageFull)) {
      return mInAppMessageFullViewFactory;
    }
    if ((paramIInAppMessage instanceof InAppMessageHtmlFull)) {
      return mInAppMessageHtmlFullViewFactory;
    }
    return null;
  }
  
  public static AppboyInAppMessageManager getInstance()
  {
    if (sInstance == null) {}
    try
    {
      if (sInstance == null) {
        sInstance = new AppboyInAppMessageManager();
      }
      return sInstance;
    }
    finally {}
  }
  
  public void addInAppMessage(IInAppMessage paramIInAppMessage)
  {
    mInAppMessageStack.push(paramIInAppMessage);
    requestDisplayInAppMessage();
  }
  
  boolean displayInAppMessage(IInAppMessage paramIInAppMessage)
  {
    if (!mDisplayingInAppMessage.compareAndSet(false, true))
    {
      AppboyLogger.d(TAG, "A in-app message is currently being displayed.  Adding in-app message back on the stack.");
      mInAppMessageStack.push(paramIInAppMessage);
      return false;
    }
    try
    {
      if (mActivity == null) {
        throw new Exception("No activity is currently registered to receive in-app messages. Doing nothing.");
      }
    }
    catch (Exception paramIInAppMessage)
    {
      AppboyLogger.e(TAG, "Error running displayInAppMessage", paramIInAppMessage);
      mInAppMessageViewWrapper = null;
      mDisplayingInAppMessage.set(false);
      return false;
    }
    Object localObject1 = getInAppMessageViewFactory(paramIInAppMessage);
    if (localObject1 == null) {
      throw new Exception("ViewFactory from getInAppMessageViewFactory was null.");
    }
    localObject1 = ((IInAppMessageViewFactory)localObject1).createInAppMessageView(mActivity, paramIInAppMessage);
    if (localObject1 == null) {
      throw new Exception("The in-app message view returned from the IInAppMessageViewFactory was null. The in-app message will not be displayed and will not be put back on the stack.");
    }
    if (((View)localObject1).getParent() != null) {
      throw new Exception("The in-app message view returned from the IInAppMessageViewFactory already has a parent. This is a sign that the view is being reused. The IInAppMessageViewFactory method createInAppMessageViewmust return a new view without a parent. The in-app message will not be displayed and will not be put back on the stack.");
    }
    Animation localAnimation1 = getInAppMessageAnimationFactory().getOpeningAnimation(paramIInAppMessage);
    Animation localAnimation2 = getInAppMessageAnimationFactory().getClosingAnimation(paramIInAppMessage);
    Object localObject2;
    if ((localObject1 instanceof IInAppMessageImmersiveView))
    {
      AppboyLogger.d(TAG, "Creating view wrapper for immersive in-app message.");
      localObject2 = (IInAppMessageImmersiveView)localObject1;
      mInAppMessageViewWrapper = new InAppMessageViewWrapper((View)localObject1, paramIInAppMessage, mInAppMessageViewLifecycleListener, localAnimation1, localAnimation2, ((IInAppMessageImmersiveView)localObject2).getMessageClickableView(), ((IInAppMessageImmersiveView)localObject2).getMessageButtonViews(), ((IInAppMessageImmersiveView)localObject2).getMessageCloseButtonView());
    }
    for (;;)
    {
      mInAppMessageViewWrapper.open(mActivity);
      return true;
      if ((localObject1 instanceof IInAppMessageView))
      {
        AppboyLogger.d(TAG, "Creating view wrapper for base in-app message.");
        localObject2 = (IInAppMessageView)localObject1;
        mInAppMessageViewWrapper = new InAppMessageViewWrapper((View)localObject1, paramIInAppMessage, mInAppMessageViewLifecycleListener, localAnimation1, localAnimation2, ((IInAppMessageView)localObject2).getMessageClickableView());
      }
      else
      {
        AppboyLogger.d(TAG, "Creating view wrapper for in-app message.");
        mInAppMessageViewWrapper = new InAppMessageViewWrapper((View)localObject1, paramIInAppMessage, mInAppMessageViewLifecycleListener, localAnimation1, localAnimation2, (View)localObject1);
      }
    }
  }
  
  public Activity getActivity()
  {
    return mActivity;
  }
  
  public IAppboyNavigator getAppboyNavigator()
  {
    IAppboyNavigator localIAppboyNavigator = Appboy.getInstance(mActivity).getAppboyNavigator();
    if (localIAppboyNavigator != null) {
      return localIAppboyNavigator;
    }
    return mDefaultAppboyNavigator;
  }
  
  public IHtmlInAppMessageActionListener getHtmlInAppMessageActionListener()
  {
    if (mCustomHtmlInAppMessageActionListener != null) {
      return mCustomHtmlInAppMessageActionListener;
    }
    return mDefaultHtmlInAppMessageActionListener;
  }
  
  public IInAppMessageManagerListener getInAppMessageManagerListener()
  {
    if (mCustomInAppMessageManagerListener != null) {
      return mCustomInAppMessageManagerListener;
    }
    return mDefaultInAppMessageManagerListener;
  }
  
  public void hideCurrentInAppMessage(boolean paramBoolean)
  {
    IInAppMessageViewWrapper localIInAppMessageViewWrapper = mInAppMessageViewWrapper;
    if (localIInAppMessageViewWrapper != null)
    {
      IInAppMessage localIInAppMessage = localIInAppMessageViewWrapper.getInAppMessage();
      if (localIInAppMessage != null) {
        localIInAppMessage.setAnimateOut(paramBoolean);
      }
      localIInAppMessageViewWrapper.close();
    }
  }
  
  public void hideCurrentInAppMessage(boolean paramBoolean1, boolean paramBoolean2)
  {
    IInAppMessageViewWrapper localIInAppMessageViewWrapper = mInAppMessageViewWrapper;
    if ((localIInAppMessageViewWrapper != null) && (paramBoolean2)) {
      mInAppMessageViewLifecycleListener.onDismissed(localIInAppMessageViewWrapper.getInAppMessageView(), localIInAppMessageViewWrapper.getInAppMessage());
    }
    hideCurrentInAppMessage(paramBoolean1);
  }
  
  public void registerInAppMessageManager(Activity paramActivity)
  {
    mActivity = paramActivity;
    if ((mActivity != null) && (mApplicationContext == null)) {
      mApplicationContext = mActivity.getApplicationContext();
    }
    if (mCarryoverInAppMessage != null)
    {
      AppboyLogger.d(TAG, "Displaying carryover in-app message.");
      mCarryoverInAppMessage.setAnimateIn(false);
      displayInAppMessage(mCarryoverInAppMessage);
      mCarryoverInAppMessage = null;
    }
    mInAppMessageEventSubscriber = createInAppMessageEventSubscriber();
    Appboy.getInstance(paramActivity).subscribeToNewInAppMessages(mInAppMessageEventSubscriber);
    InAppMessageManagerStateListener.getInstance().notifyInAppMessageManagerRegistered(mApplicationContext);
  }
  
  public boolean requestDisplayInAppMessage()
  {
    try
    {
      if (mActivity == null)
      {
        AppboyLogger.e(TAG, "No activity is currently registered to receive in-app messages. Doing nothing.");
        return false;
      }
      if (mDisplayingInAppMessage.get())
      {
        AppboyLogger.d(TAG, "A in-app message is currently being displayed. Ignoring request to display in-app message.");
        return false;
      }
    }
    catch (Exception localException)
    {
      AppboyLogger.e(TAG, "Error running requestDisplayInAppMessage", localException);
      return false;
    }
    if (mInAppMessageStack.isEmpty())
    {
      AppboyLogger.d(TAG, "The in-app message stack is empty. No in-app message will be displayed.");
      return false;
    }
    final IInAppMessage localIInAppMessage = (IInAppMessage)mInAppMessageStack.pop();
    InAppMessageOperation localInAppMessageOperation = getInAppMessageManagerListener().beforeInAppMessageDisplayed(localIInAppMessage);
    switch (localInAppMessageOperation)
    {
    }
    for (;;)
    {
      AppboyLogger.e(TAG, "The IInAppMessageManagerListener method beforeInAppMessageDisplayed returned null instead of a InAppMessageOperation. Ignoring the in-app message. Please check the IInAppMessageStackBehaviour implementation.");
      return false;
      AppboyLogger.d(TAG, "The IInAppMessageManagerListener method beforeInAppMessageDisplayed returned DISPLAY_NOW. The in-app message will be displayed.");
      mActivity.runOnUiThread(new Runnable()
      {
        public void run()
        {
          new AppboyAsyncInAppMessageDisplayer().execute(new IInAppMessage[] { localIInAppMessage });
        }
      });
      return true;
      AppboyLogger.d(TAG, "The IInAppMessageManagerListener method beforeInAppMessageDisplayed returned DISPLAY_LATER. The in-app message will be pushed back onto the stack.");
      mInAppMessageStack.push(localIInAppMessage);
      return false;
      AppboyLogger.d(TAG, "The IInAppMessageManagerListener method beforeInAppMessageDisplayed returned DISCARD. The in-app message will not be displayed and will not be put back on the stack.");
      return false;
    }
  }
  
  public void resetAfterInAppMessageClose()
  {
    mInAppMessageViewWrapper = null;
    mDisplayingInAppMessage.set(false);
  }
  
  public void setCustomHtmlInAppMessageActionListener(IHtmlInAppMessageActionListener paramIHtmlInAppMessageActionListener)
  {
    mCustomHtmlInAppMessageActionListener = paramIHtmlInAppMessageActionListener;
  }
  
  public void setCustomInAppMessageAnimationFactory(IInAppMessageAnimationFactory paramIInAppMessageAnimationFactory)
  {
    mCustomInAppMessageAnimationFactory = paramIInAppMessageAnimationFactory;
  }
  
  public void setCustomInAppMessageManagerListener(IInAppMessageManagerListener paramIInAppMessageManagerListener)
  {
    mCustomInAppMessageManagerListener = paramIInAppMessageManagerListener;
  }
  
  public void setCustomInAppMessageViewFactory(IInAppMessageViewFactory paramIInAppMessageViewFactory)
  {
    mCustomInAppMessageViewFactory = paramIInAppMessageViewFactory;
  }
  
  public void unregisterInAppMessageManager(Activity paramActivity)
  {
    if (mInAppMessageViewWrapper != null)
    {
      ViewUtils.removeViewFromParent(mInAppMessageViewWrapper.getInAppMessageView());
      if (mInAppMessageViewWrapper.getIsAnimatingClose())
      {
        mInAppMessageViewLifecycleListener.afterClosed(mInAppMessageViewWrapper.getInAppMessage());
        mCarryoverInAppMessage = null;
        mInAppMessageViewWrapper = null;
      }
    }
    for (;;)
    {
      InAppMessageManagerStateListener.getInstance().notifyInAppMessageManagerUnregistered(mApplicationContext);
      Appboy.getInstance(paramActivity).removeSingleSubscription(mInAppMessageEventSubscriber, InAppMessageEvent.class);
      mActivity = null;
      mDisplayingInAppMessage.set(false);
      return;
      mCarryoverInAppMessage = mInAppMessageViewWrapper.getInAppMessage();
      break;
      mCarryoverInAppMessage = null;
    }
  }
}

/* Location:
 * Qualified Name:     com.appboy.ui.inappmessage.AppboyInAppMessageManager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */