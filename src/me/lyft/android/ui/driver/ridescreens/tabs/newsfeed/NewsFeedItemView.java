package me.lyft.android.ui.driver.ridescreens.tabs.newsfeed;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.lyft.scoop.dagger.DaggerInjector;
import com.squareup.picasso.RequestCreator;
import javax.inject.Inject;
import me.lyft.android.analytics.studies.DriverConsoleAnalytics;
import me.lyft.android.application.driver.INewsFeedService;
import me.lyft.android.deeplinks.DeepLinkManager;
import me.lyft.android.domain.newsfeed.NewsFeedButton;
import me.lyft.android.domain.newsfeed.NewsFeedMessage;
import me.lyft.android.domain.newsfeed.NewsFeedProgressBar;
import me.lyft.android.infrastructure.device.IDevice;
import me.lyft.android.managers.ImageLoader;
import me.lyft.android.rx.IRxBinder;
import me.lyft.android.rx.RxUIBinder;
import me.lyft.android.rx.ViewExtensions;
import me.lyft.android.ui.RoundedCornersTransformation;
import me.lyft.android.utils.WebBrowser;

public class NewsFeedItemView
  extends LinearLayout
  implements ViewTreeObserver.OnScrollChangedListener
{
  private IRxBinder binder = new RxUIBinder();
  View bottomView;
  LinearLayout container;
  @Inject
  DeepLinkManager deepLinkManager;
  @Inject
  IDevice device;
  @Inject
  DriverConsoleAnalytics driverConsoleAnalytics;
  @Inject
  ImageLoader imageLoader;
  private boolean isCached = false;
  private NewsFeedMessage message = NewsFeedMessage.empty();
  Button messageButton;
  TextView messageDescriptionTextView;
  ImageView messageIconImageView;
  ImageView messageMainImageView;
  FrameLayout messageProgressBar;
  TextView messageProgressLabel;
  TextView messageTitleTextView;
  @Inject
  INewsFeedService newsFeedService;
  private int position = 0;
  View progressHorizontalBar;
  @Inject
  WebBrowser webBrowser;
  
  public NewsFeedItemView(Context paramContext)
  {
    super(paramContext);
  }
  
  public NewsFeedItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void initialize()
  {
    binder.bindAction(ViewExtensions.onLoadedObservable(this), new NewsFeedItemView.1(this));
  }
  
  private void loadButton()
  {
    NewsFeedButton localNewsFeedButton = message.getButton();
    if (localNewsFeedButton.isNull())
    {
      messageButton.setVisibility(8);
      return;
    }
    messageButton.setText(localNewsFeedButton.getText());
    messageButton.setOnClickListener(new NewsFeedItemView.2(this, localNewsFeedButton));
  }
  
  private void loadImage()
  {
    if (message.getImageUrl().isEmpty())
    {
      messageMainImageView.setVisibility(8);
      return;
    }
    imageLoader.load(message.getImageUrl()).resize(messageMainImageView.getWidth(), messageMainImageView.getHeight()).centerCrop().transform(new RoundedCornersTransformation((int)getResources().getDimension(2131230855), 0)).into(messageMainImageView);
  }
  
  private void loadProgressBar()
  {
    NewsFeedProgressBar localNewsFeedProgressBar = message.getProgress();
    if (localNewsFeedProgressBar.isNull())
    {
      messageProgressBar.setVisibility(8);
      messageProgressLabel.setVisibility(8);
      return;
    }
    messageProgressLabel.setText(localNewsFeedProgressBar.getLabel());
    binder.bindAction(ViewExtensions.onLoadedObservable(messageProgressBar), new NewsFeedItemView.3(this, localNewsFeedProgressBar));
  }
  
  private void loadStyle()
  {
    if (message.isAlert()) {
      updateStyle(2130838119, 2130837603, getResources().getColor(2131493083));
    }
    do
    {
      return;
      if (message.isLocal())
      {
        updateStyle(2130838266, 2130837622, getResources().getColor(2131493014));
        return;
      }
      if (message.isEducation())
      {
        updateStyle(2130838211, 2130837607, getResources().getColor(2131493083));
        return;
      }
    } while (!message.isPromotion());
    updateStyle(2130838322, 2130837607, getResources().getColor(2131493083));
  }
  
  private void trackDisplayed()
  {
    if (message.isNull()) {
      return;
    }
    driverConsoleAnalytics.displayNewsFeedMessage(message.getId(), position);
  }
  
  private void updateProgress(int paramInt)
  {
    float f2 = (float)(messageProgressBar.getWidth() * paramInt / 100.0D);
    float f1;
    if (f2 > messageProgressBar.getWidth()) {
      f1 = messageProgressBar.getWidth();
    }
    for (;;)
    {
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)progressHorizontalBar.getLayoutParams();
      width = ((int)f1);
      progressHorizontalBar.setLayoutParams(localLayoutParams);
      return;
      f1 = f2;
      if (f2 < 0.0F) {
        f1 = 0.0F;
      }
    }
  }
  
  private void updateStyle(int paramInt1, int paramInt2, int paramInt3)
  {
    messageIconImageView.setBackgroundResource(paramInt1);
    messageButton.setBackgroundResource(paramInt2);
    messageButton.setTextColor(paramInt3);
  }
  
  public void hideBottomView()
  {
    bottomView.setVisibility(8);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    binder.attach();
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    binder.detach();
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    ButterKnife.bind(this);
    DaggerInjector.fromView(this).inject(this);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)container.getLayoutParams();
    width = ((int)(device.getScreenWidth().intValue() - getResources().getDimension(2131230873)));
    container.setLayoutParams(localLayoutParams);
    getViewTreeObserver().addOnScrollChangedListener(this);
  }
  
  public void onScrollChanged()
  {
    if ((message.isNull()) || (isCached)) {}
    do
    {
      do
      {
        return;
      } while (!getLocalVisibleRect(new Rect()));
      trackDisplayed();
      getViewTreeObserver().removeOnScrollChangedListener(this);
      isCached = true;
    } while ((message.isNull()) || (message.isAlert()));
    newsFeedService.updateReadMessage(message);
  }
  
  public void setMessage(NewsFeedMessage paramNewsFeedMessage, int paramInt)
  {
    message = paramNewsFeedMessage;
    position = paramInt;
    initialize();
  }
  
  public void trackButtonClicked(int paramInt)
  {
    if (message.isNull()) {
      return;
    }
    String str = message.getId();
    driverConsoleAnalytics.tapNewsFeedMessageButton(str, paramInt);
  }
  
  public void trackButtonFailure()
  {
    if (message.isNull()) {
      return;
    }
    driverConsoleAnalytics.tapNewsFeedMessageButtonFailure();
  }
  
  public void trackButtonSuccess()
  {
    if (message.isNull()) {
      return;
    }
    driverConsoleAnalytics.tapNewsFeedMessageButtonSuccess();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.driver.ridescreens.tabs.newsfeed.NewsFeedItemView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */