package me.lyft.android.ui;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.lyft.scoop.Screen;
import com.lyft.scoop.dagger.DaggerInjector;
import com.squareup.picasso.RequestCreator;
import javax.inject.Inject;
import me.lyft.android.common.ActivityController;
import me.lyft.android.common.AppFlow;
import me.lyft.android.common.Strings;
import me.lyft.android.managers.ImageLoader;
import me.lyft.android.rx.Binder;
import rx.functions.Action1;

public class FullscreenPhotoView
  extends FrameLayout
{
  @Inject
  ActivityController activityController;
  @Inject
  AppFlow appFlow;
  private Binder binder;
  @Inject
  ImageLoader imageLoader;
  private final Action1<Configuration> onConfigurationChanged = new FullscreenPhotoView.2(this);
  MainScreens.FullscreenPhotoScreen params;
  ImageView photoImageView;
  TextView photoSubtitleTextView;
  TextView photoTitleTextView;
  
  public FullscreenPhotoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    DaggerInjector.fromView(this).inject(this);
    params = ((MainScreens.FullscreenPhotoScreen)Screen.fromView(this));
  }
  
  public void close(View paramView)
  {
    appFlow.goBack();
  }
  
  protected void onAttachedToWindow()
  {
    int j = 8;
    super.onAttachedToWindow();
    binder = Binder.attach(this);
    binder.bind(activityController.observeConfigurationChange(), onConfigurationChanged);
    Object localObject = params.getPhotoUrl();
    imageLoader.load((String)localObject).placeholder(2130838345).into(photoImageView);
    photoTitleTextView.setText(params.getTitle());
    localObject = photoTitleTextView;
    if (Strings.isNullOrEmpty(params.getTitle()))
    {
      i = 8;
      ((TextView)localObject).setVisibility(i);
      photoSubtitleTextView.setText(params.getSubtitle());
      localObject = photoSubtitleTextView;
      if (!Strings.isNullOrEmpty(params.getSubtitle())) {
        break label154;
      }
    }
    label154:
    for (int i = j;; i = 0)
    {
      ((TextView)localObject).setVisibility(i);
      activityController.setRotationOrientation();
      return;
      i = 0;
      break;
    }
  }
  
  protected void onDetachedFromWindow()
  {
    activityController.restoreDefaultOrientation();
    super.onDetachedFromWindow();
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    ButterKnife.bind(this);
    setOnClickListener(new FullscreenPhotoView.1(this));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.FullscreenPhotoView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */