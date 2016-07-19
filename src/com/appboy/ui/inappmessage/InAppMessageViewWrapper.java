package com.appboy.ui.inappmessage;

import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.appboy.Constants;
import com.appboy.enums.inappmessage.DismissType;
import com.appboy.enums.inappmessage.SlideFrom;
import com.appboy.models.IInAppMessage;
import com.appboy.models.IInAppMessageHtml;
import com.appboy.models.IInAppMessageImmersive;
import com.appboy.models.InAppMessageSlideup;
import com.appboy.models.MessageButton;
import com.appboy.support.AppboyLogger;
import com.appboy.ui.inappmessage.listeners.IInAppMessageViewLifecycleListener;
import com.appboy.ui.inappmessage.listeners.SimpleSwipeDismissTouchListener;
import com.appboy.ui.inappmessage.listeners.SwipeDismissTouchListener.DismissCallbacks;
import com.appboy.ui.inappmessage.listeners.TouchAwareSwipeDismissTouchListener;
import com.appboy.ui.inappmessage.listeners.TouchAwareSwipeDismissTouchListener.ITouchListener;
import com.appboy.ui.support.AnimationUtils;
import com.appboy.ui.support.ViewUtils;
import java.util.Iterator;
import java.util.List;

public class InAppMessageViewWrapper
  implements IInAppMessageViewWrapper
{
  private static final String TAG = String.format("%s.%s", new Object[] { Constants.APPBOY_LOG_TAG_PREFIX, InAppMessageViewWrapper.class.getName() });
  private List<View> mButtons;
  private View mClickableInAppMessageView;
  private View mCloseButton;
  private final Animation mClosingAnimation;
  private Runnable mDismissRunnable;
  private final IInAppMessage mInAppMessage;
  private final View mInAppMessageView;
  private final IInAppMessageViewLifecycleListener mInAppMessageViewLifecycleListener;
  private boolean mIsAnimatingClose;
  private final Animation mOpeningAnimation;
  
  public InAppMessageViewWrapper(View paramView1, IInAppMessage paramIInAppMessage, IInAppMessageViewLifecycleListener paramIInAppMessageViewLifecycleListener, Animation paramAnimation1, Animation paramAnimation2, View paramView2)
  {
    mInAppMessageView = paramView1;
    mInAppMessage = paramIInAppMessage;
    mInAppMessageViewLifecycleListener = paramIInAppMessageViewLifecycleListener;
    mIsAnimatingClose = false;
    if (paramView2 != null)
    {
      mClickableInAppMessageView = paramView2;
      if ((Build.VERSION.SDK_INT < 12) || (!(mInAppMessage instanceof InAppMessageSlideup))) {
        break label118;
      }
      paramView1 = new TouchAwareSwipeDismissTouchListener(paramView1, null, createDismissCallbacks());
      paramView1.setTouchListener(createTouchAwareListener());
      mClickableInAppMessageView.setOnTouchListener(paramView1);
    }
    for (;;)
    {
      mOpeningAnimation = paramAnimation1;
      mClosingAnimation = paramAnimation2;
      mClickableInAppMessageView.setOnClickListener(createClickListener());
      return;
      mClickableInAppMessageView = mInAppMessageView;
      break;
      label118:
      if ((mInAppMessage instanceof InAppMessageSlideup)) {
        mClickableInAppMessageView.setOnTouchListener(getSimpleSwipeListener());
      }
    }
  }
  
  public InAppMessageViewWrapper(View paramView1, IInAppMessage paramIInAppMessage, IInAppMessageViewLifecycleListener paramIInAppMessageViewLifecycleListener, Animation paramAnimation1, Animation paramAnimation2, View paramView2, List<View> paramList, View paramView3)
  {
    this(paramView1, paramIInAppMessage, paramIInAppMessageViewLifecycleListener, paramAnimation1, paramAnimation2, paramView2);
    if (paramView3 != null)
    {
      mCloseButton = paramView3;
      mCloseButton.setOnClickListener(createCloseInAppMessageClickListener());
    }
    if (paramList != null)
    {
      mButtons = paramList;
      paramView1 = mButtons.iterator();
      while (paramView1.hasNext()) {
        ((View)paramView1.next()).setOnClickListener(createButtonClickListener());
      }
    }
  }
  
  private void addDismissRunnable()
  {
    if (mDismissRunnable == null)
    {
      mDismissRunnable = new Runnable()
      {
        public void run()
        {
          mInAppMessageViewLifecycleListener.onDismissed(mInAppMessageView, mInAppMessage);
          close();
        }
      };
      mInAppMessageView.postDelayed(mDismissRunnable, mInAppMessage.getDurationInMilliseconds());
    }
  }
  
  private Animation.AnimationListener createAnimationListener(boolean paramBoolean)
  {
    if (paramBoolean) {
      new Animation.AnimationListener()
      {
        public void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          if (mInAppMessage.getDismissType() == DismissType.AUTO_DISMISS) {
            InAppMessageViewWrapper.this.addDismissRunnable();
          }
          AppboyLogger.d(InAppMessageViewWrapper.TAG, "In-app message animated into view.");
          mInAppMessageViewLifecycleListener.afterOpened(mInAppMessageView, mInAppMessage);
        }
        
        public void onAnimationRepeat(Animation paramAnonymousAnimation) {}
        
        public void onAnimationStart(Animation paramAnonymousAnimation) {}
      };
    }
    new Animation.AnimationListener()
    {
      public void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        mInAppMessageView.clearAnimation();
        mInAppMessageView.setVisibility(8);
        ViewUtils.removeViewFromParent(mInAppMessageView);
        mInAppMessageViewLifecycleListener.afterClosed(mInAppMessage);
      }
      
      public void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public void onAnimationStart(Animation paramAnonymousAnimation) {}
    };
  }
  
  private View.OnClickListener createButtonClickListener()
  {
    new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        IInAppMessageImmersive localIInAppMessageImmersive = (IInAppMessageImmersive)mInAppMessage;
        int i = 0;
        for (;;)
        {
          if (i < mButtons.size())
          {
            if (paramAnonymousView.getId() == ((View)mButtons.get(i)).getId())
            {
              paramAnonymousView = (MessageButton)localIInAppMessageImmersive.getMessageButtons().get(i);
              mInAppMessageViewLifecycleListener.onButtonClicked(new InAppMessageCloser(InAppMessageViewWrapper.this), paramAnonymousView, localIInAppMessageImmersive);
            }
          }
          else {
            return;
          }
          i += 1;
        }
      }
    };
  }
  
  private View.OnClickListener createClickListener()
  {
    new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if ((mInAppMessage instanceof IInAppMessageImmersive))
        {
          paramAnonymousView = (IInAppMessageImmersive)mInAppMessage;
          if ((paramAnonymousView.getMessageButtons() == null) || (paramAnonymousView.getMessageButtons().size() == 0)) {
            mInAppMessageViewLifecycleListener.onClicked(new InAppMessageCloser(InAppMessageViewWrapper.this), mInAppMessageView, mInAppMessage);
          }
          return;
        }
        mInAppMessageViewLifecycleListener.onClicked(new InAppMessageCloser(InAppMessageViewWrapper.this), mInAppMessageView, mInAppMessage);
      }
    };
  }
  
  private View.OnClickListener createCloseInAppMessageClickListener()
  {
    new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        mInAppMessageViewLifecycleListener.onDismissed(mInAppMessageView, mInAppMessage);
        close();
      }
    };
  }
  
  private SwipeDismissTouchListener.DismissCallbacks createDismissCallbacks()
  {
    new SwipeDismissTouchListener.DismissCallbacks()
    {
      public boolean canDismiss(Object paramAnonymousObject)
      {
        return true;
      }
      
      public void onDismiss(View paramAnonymousView, Object paramAnonymousObject)
      {
        mInAppMessageViewLifecycleListener.onDismissed(mInAppMessageView, mInAppMessage);
        mInAppMessage.setAnimateOut(false);
        close();
      }
    };
  }
  
  private TouchAwareSwipeDismissTouchListener.ITouchListener createTouchAwareListener()
  {
    new TouchAwareSwipeDismissTouchListener.ITouchListener()
    {
      public void onTouchEnded()
      {
        if (mInAppMessage.getDismissType() == DismissType.AUTO_DISMISS) {
          InAppMessageViewWrapper.this.addDismissRunnable();
        }
      }
      
      public void onTouchStartedOrContinued()
      {
        mInAppMessageView.removeCallbacks(mDismissRunnable);
      }
    };
  }
  
  private FrameLayout.LayoutParams getLayoutParams(FrameLayout paramFrameLayout, int paramInt)
  {
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -2);
    if ((mInAppMessage instanceof InAppMessageSlideup)) {
      if (((InAppMessageSlideup)mInAppMessage).getSlideFrom() != SlideFrom.TOP) {
        break label99;
      }
    }
    label99:
    for (int i = 48;; i = 80)
    {
      gravity = i;
      if ((paramInt > 0) && (paramInt == paramFrameLayout.getHeight()))
      {
        paramInt = ViewUtils.getTopVisibleCoordinate(paramFrameLayout);
        AppboyLogger.d(TAG, String.format("Detected status bar height of %d.", new Object[] { Integer.valueOf(paramInt) }));
        localLayoutParams.setMargins(0, paramInt, 0, 0);
      }
      return localLayoutParams;
    }
  }
  
  private SimpleSwipeDismissTouchListener getSimpleSwipeListener()
  {
    new SimpleSwipeDismissTouchListener(mInAppMessageView.getContext())
    {
      private final long sSwipeAnimationDurationMillis = 400L;
      
      private void animateAndClose(Animation paramAnonymousAnimation)
      {
        mInAppMessageViewLifecycleListener.onDismissed(mInAppMessageView, mInAppMessage);
        mInAppMessageView.clearAnimation();
        mInAppMessageView.setAnimation(paramAnonymousAnimation);
        paramAnonymousAnimation.startNow();
        mInAppMessageView.invalidate();
        mInAppMessage.setAnimateOut(false);
        close();
      }
      
      public void onSwipeLeft()
      {
        animateAndClose(AnimationUtils.createHorizontalAnimation(0.0F, -1.0F, 400L, false));
      }
      
      public void onSwipeRight()
      {
        animateAndClose(AnimationUtils.createHorizontalAnimation(0.0F, 1.0F, 400L, false));
      }
    };
  }
  
  private void open(FrameLayout paramFrameLayout, int paramInt)
  {
    mInAppMessageViewLifecycleListener.beforeOpened(mInAppMessageView, mInAppMessage);
    AppboyLogger.d(TAG, "Adding In-app message view to root FrameLayout.");
    if (((mInAppMessage instanceof IInAppMessageImmersive)) || ((mInAppMessage instanceof IInAppMessageHtml)))
    {
      mInAppMessageView.setFocusableInTouchMode(true);
      mInAppMessageView.requestFocus();
    }
    paramFrameLayout.addView(mInAppMessageView, getLayoutParams(paramFrameLayout, paramInt));
    if (mInAppMessage.getAnimateIn())
    {
      AppboyLogger.d(TAG, "In-app message view will animate into the visible area.");
      setAndStartAnimation(true);
      return;
    }
    AppboyLogger.d(TAG, "In-app message view will be placed instantly into the visible area.");
    if (mInAppMessage.getDismissType() == DismissType.AUTO_DISMISS) {
      addDismissRunnable();
    }
    mInAppMessageViewLifecycleListener.afterOpened(mInAppMessageView, mInAppMessage);
  }
  
  private void setAndStartAnimation(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (Animation localAnimation = mOpeningAnimation;; localAnimation = mClosingAnimation)
    {
      localAnimation.setAnimationListener(createAnimationListener(paramBoolean));
      mInAppMessageView.clearAnimation();
      mInAppMessageView.setAnimation(localAnimation);
      localAnimation.startNow();
      mInAppMessageView.invalidate();
      return;
    }
  }
  
  public void close()
  {
    mInAppMessageView.removeCallbacks(mDismissRunnable);
    mInAppMessageViewLifecycleListener.beforeClosed(mInAppMessageView, mInAppMessage);
    if (mInAppMessage.getAnimateOut())
    {
      mIsAnimatingClose = true;
      setAndStartAnimation(false);
      return;
    }
    ViewUtils.removeViewFromParent(mInAppMessageView);
    mInAppMessageViewLifecycleListener.afterClosed(mInAppMessage);
  }
  
  public IInAppMessage getInAppMessage()
  {
    return mInAppMessage;
  }
  
  public View getInAppMessageView()
  {
    return mInAppMessageView;
  }
  
  public boolean getIsAnimatingClose()
  {
    return mIsAnimatingClose;
  }
  
  public void open(Activity paramActivity)
  {
    final FrameLayout localFrameLayout = (FrameLayout)paramActivity.getWindow().getDecorView().findViewById(16908290);
    int i = localFrameLayout.getHeight();
    final int j = ViewUtils.getDisplayHeight(paramActivity);
    if (i == 0)
    {
      paramActivity = localFrameLayout.getViewTreeObserver();
      if (paramActivity.isAlive()) {
        paramActivity.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
        {
          public void onGlobalLayout()
          {
            AppboyLogger.d(InAppMessageViewWrapper.TAG, String.format("Detected root view height of %d, display height of %d in onGlobalLayout", new Object[] { Integer.valueOf(localFrameLayout.getHeight()), Integer.valueOf(j) }));
            localFrameLayout.removeView(mInAppMessageView);
            InAppMessageViewWrapper.this.open(localFrameLayout, j);
            ViewUtils.removeOnGlobalLayoutListenerSafe(localFrameLayout.getViewTreeObserver(), this);
          }
        });
      }
      return;
    }
    AppboyLogger.d(TAG, String.format("Detected root view height of %d, display height of %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) }));
    open(localFrameLayout, j);
  }
}

/* Location:
 * Qualified Name:     com.appboy.ui.inappmessage.InAppMessageViewWrapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */