package me.lyft.android.ui.profile;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.lyft.scoop.Scoop;
import com.lyft.scoop.dagger.DaggerInjector;
import javax.inject.Inject;
import me.lyft.android.common.AppFlow;
import me.lyft.android.ui.SlideMenuController;

public class ProfileToolBarView
  extends LinearLayout
{
  public static final int ANIMATION_DURATION = 200;
  public static final float MAX_ALPHA = 0.9F;
  public static final float MIN_ALPHA = 0.0F;
  @Inject
  AppFlow appFlow;
  ImageView profileCloseImageView;
  TextView profileEditImageView;
  ImageView profileMenuImageView;
  View profileToolbarBackgroundView;
  @Inject
  SlideMenuController slideMenuController;
  
  public ProfileToolBarView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    DaggerInjector.fromView(this).inject(this);
    setOrientation(1);
    Scoop.fromView(this).inflater(paramContext).inflate(2130903415, this, true);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    profileCloseImageView.setOnClickListener(new ProfileToolBarView.1(this));
    profileMenuImageView.setOnClickListener(new ProfileToolBarView.2(this));
    profileEditImageView.setOnClickListener(new ProfileToolBarView.3(this));
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    if (isInEditMode()) {
      return;
    }
    ButterKnife.bind(this);
  }
  
  public void setFade(boolean paramBoolean)
  {
    profileToolbarBackgroundView.clearAnimation();
    ViewPropertyAnimator localViewPropertyAnimator = profileToolbarBackgroundView.animate().setDuration(200L);
    if (paramBoolean) {}
    for (float f = 0.9F;; f = 0.0F)
    {
      localViewPropertyAnimator.alpha(f).start();
      return;
    }
  }
  
  public void showProfileToolbar()
  {
    profileCloseImageView.setVisibility(8);
    profileEditImageView.setVisibility(0);
    profileMenuImageView.setVisibility(0);
  }
  
  public void showRideToolbar(boolean paramBoolean)
  {
    int i = 0;
    profileCloseImageView.setVisibility(0);
    TextView localTextView = profileEditImageView;
    if (paramBoolean) {}
    for (;;)
    {
      localTextView.setVisibility(i);
      profileMenuImageView.setVisibility(8);
      return;
      i = 8;
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.profile.ProfileToolBarView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */