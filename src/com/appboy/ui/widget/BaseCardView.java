package com.appboy.ui.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.ViewSwitcher.ViewFactory;
import com.appboy.Appboy;
import com.appboy.Constants;
import com.appboy.models.cards.Card;
import com.appboy.support.AppboyLogger;
import com.appboy.support.PackageUtils;
import com.appboy.ui.R.drawable;
import com.appboy.ui.R.id;
import com.appboy.ui.actions.IAction;
import com.appboy.ui.support.FrescoLibraryUtils;
import com.appboy.ui.support.ViewUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.Observable;
import java.util.Observer;

public abstract class BaseCardView<T extends Card>
  extends RelativeLayout
  implements Observer
{
  private static final String COM_APPBOY_NEWSFEED_UNREAD_VISUAL_INDICATOR_ON = "com_appboy_newsfeed_unread_visual_indicator_on";
  private static final float SQUARE_ASPECT_RATIO = 1.0F;
  private static final String TAG = String.format("%s.%s", new Object[] { Constants.APPBOY_LOG_TAG_PREFIX, BaseCardView.class.getName() });
  private static Boolean unreadCardVisualIndicatorOn;
  private final boolean mCanUseFresco;
  protected T mCard;
  protected final Context mContext;
  protected ImageSwitcher mImageSwitcher;
  
  public BaseCardView(Context paramContext)
  {
    super(paramContext);
    mCanUseFresco = FrescoLibraryUtils.canUseFresco(paramContext);
    mContext = paramContext;
    ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(getLayoutResource(), this);
    mImageSwitcher = ((ImageSwitcher)findViewById(R.id.com_appboy_newsfeed_item_read_indicator_image_switcher));
    if (mImageSwitcher != null) {
      mImageSwitcher.setFactory(new ViewSwitcher.ViewFactory()
      {
        public View makeView()
        {
          return new ImageView(mContext.getApplicationContext());
        }
      });
    }
    int i;
    if (unreadCardVisualIndicatorOn == null)
    {
      i = mContext.getResources().getIdentifier("com_appboy_newsfeed_unread_visual_indicator_on", "bool", PackageUtils.getResourcePackageName(paramContext));
      if (i == 0) {
        break label141;
      }
    }
    label141:
    for (unreadCardVisualIndicatorOn = Boolean.valueOf(paramContext.getResources().getBoolean(i));; unreadCardVisualIndicatorOn = Boolean.valueOf(true))
    {
      if ((!unreadCardVisualIndicatorOn.booleanValue()) && (mImageSwitcher != null)) {
        mImageSwitcher.setVisibility(8);
      }
      return;
    }
  }
  
  protected static void handleCardClick(Context paramContext, Card paramCard, IAction paramIAction, String paramString)
  {
    paramCard.setIsRead(true);
    if (paramIAction != null)
    {
      if (!paramCard.logClick()) {
        break label45;
      }
      AppboyLogger.d(paramString, String.format("Logged click for card %s", new Object[] { paramCard.getId() }));
    }
    for (;;)
    {
      paramIAction.execute(paramContext);
      return;
      label45:
      AppboyLogger.d(paramString, String.format("Logging click failed for card %s", new Object[] { paramCard.getId() }));
    }
  }
  
  @TargetApi(16)
  private void setBackgroundNew(Drawable paramDrawable)
  {
    setBackground(paramDrawable);
  }
  
  private void setCardViewedIndicator()
  {
    if (getCard() != null)
    {
      if (mImageSwitcher != null)
      {
        if (getCard().isRead()) {}
        for (int i = R.drawable.icon_read;; i = R.drawable.icon_unread)
        {
          mImageSwitcher.setImageResource(i);
          mImageSwitcher.setTag(String.valueOf(i));
          return;
        }
      }
      AppboyLogger.d(TAG, "The imageSwitcher for the read/unread feature is null. Did you include it in your xml?");
      return;
    }
    AppboyLogger.d(TAG, "The card is null.");
  }
  
  boolean canUseFresco()
  {
    return mCanUseFresco;
  }
  
  public Card getCard()
  {
    return mCard;
  }
  
  protected abstract int getLayoutResource();
  
  View getProperViewFromInflatedStub(int paramInt)
  {
    ((ViewStub)findViewById(paramInt)).inflate();
    if (mCanUseFresco) {
      return findViewById(R.id.com_appboy_stubbed_feed_drawee_view);
    }
    return findViewById(R.id.com_appboy_stubbed_feed_image_view);
  }
  
  protected abstract void onSetCard(T paramT);
  
  void safeSetBackground(Drawable paramDrawable)
  {
    if (Build.VERSION.SDK_INT < 16)
    {
      setBackgroundDrawable(paramDrawable);
      return;
    }
    setBackgroundNew(paramDrawable);
  }
  
  public void setCard(T paramT)
  {
    mCard = paramT;
    onSetCard(paramT);
    paramT.addObserver(this);
    setCardViewedIndicator();
  }
  
  void setImageViewToUrl(ImageView paramImageView, String paramString)
  {
    setImageViewToUrl(paramImageView, paramString, 1.0F, false);
  }
  
  void setImageViewToUrl(ImageView paramImageView, String paramString, float paramFloat)
  {
    setImageViewToUrl(paramImageView, paramString, paramFloat, true);
  }
  
  void setImageViewToUrl(final ImageView paramImageView, String paramString, final float paramFloat, boolean paramBoolean)
  {
    if (paramString == null) {
      AppboyLogger.w(TAG, "The image url to render is null. Not setting the card image.");
    }
    do
    {
      return;
      if (paramFloat == 0.0F)
      {
        AppboyLogger.w(TAG, "The image aspect ratio is 0. Not setting the card image.");
        return;
      }
    } while (paramString.equals(paramImageView.getTag()));
    if (paramFloat != 1.0F)
    {
      ViewTreeObserver localViewTreeObserver = paramImageView.getViewTreeObserver();
      if (localViewTreeObserver.isAlive()) {
        localViewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
        {
          public void onGlobalLayout()
          {
            int i = paramImageView.getWidth();
            paramImageView.setLayoutParams(new RelativeLayout.LayoutParams(i, (int)(i / paramFloat)));
            ViewUtils.removeOnGlobalLayoutListenerSafe(paramImageView.getViewTreeObserver(), this);
          }
        });
      }
    }
    paramImageView.setImageResource(17170445);
    Appboy.getInstance(getContext()).fetchAndRenderImage(paramString, paramImageView, paramBoolean);
    paramImageView.setTag(paramString);
  }
  
  void setOptionalTextView(TextView paramTextView, String paramString)
  {
    if ((paramString != null) && (!paramString.trim().equals("")))
    {
      paramTextView.setText(paramString);
      paramTextView.setVisibility(0);
      return;
    }
    paramTextView.setText("");
    paramTextView.setVisibility(8);
  }
  
  void setSimpleDraweeToUrl(SimpleDraweeView paramSimpleDraweeView, String paramString, float paramFloat, boolean paramBoolean)
  {
    if (paramString == null)
    {
      AppboyLogger.w(TAG, "The image url to render is null. Not setting the card image.");
      return;
    }
    FrescoLibraryUtils.setDraweeControllerHelper(paramSimpleDraweeView, paramString, paramFloat, paramBoolean);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    setCardViewedIndicator();
  }
}

/* Location:
 * Qualified Name:     com.appboy.ui.widget.BaseCardView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */