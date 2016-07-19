package me.lyft.android.controls;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import butterknife.ButterKnife;
import com.lyft.scoop.Scoop;
import com.lyft.scoop.dagger.DaggerInjector;
import com.lyft.widgets.ForegroundRoundedImageView;
import com.squareup.picasso.RequestCreator;
import javax.inject.Inject;
import me.lyft.android.application.profile.IProfileService;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.common.Preconditions;
import me.lyft.android.domain.driver.DriverOverflowMenuDisplayManager;
import me.lyft.android.domain.profile.Profile;
import me.lyft.android.managers.ImageLoader;
import me.lyft.android.ui.SlideMenuController;
import me.lyft.android.ui.driver.DriverDialogs.DriverOverflowMenuScreen;
import rx.functions.Action1;
import rx.functions.Actions;

public class DriverToolbar
  extends LinearLayout
{
  @Inject
  DialogFlow dialogFlow;
  View dividerView;
  View driverModeToggleView;
  @Inject
  DriverOverflowMenuDisplayManager driverOverflowMenuDisplayManager;
  ForegroundRoundedImageView homeImageView;
  @Inject
  ImageLoader imageLoader;
  private Action1<Integer> onItemClickAction = Actions.empty();
  private final View.OnClickListener onItemClickListener = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      int i = paramAnonymousView.getId();
      onItemClickAction.call(Integer.valueOf(i));
    }
  };
  ImageButton overflowToolbarItemButton;
  @Inject
  IProfileService profileService;
  private final Scoop scoop = Scoop.fromView(this);
  FrameLayout secondaryContainer;
  @Inject
  SlideMenuController slideMenuController;
  
  public DriverToolbar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    DaggerInjector.fromView(this).inject(this);
    scoop.inflater(paramContext).inflate(2130903199, this, true);
  }
  
  private void init()
  {
    homeImageView.setForegroundDrawable(2130837661);
    imageLoader.load(profileService.getMyProfile().getPhotoUrl()).fit().centerCrop().placeholder(2130838447).into(homeImageView);
    if (driverOverflowMenuDisplayManager.enableShowOverflowMenu()) {
      showOverflowMenu();
    }
  }
  
  public DriverToolbar addItem(int paramInt1, int paramInt2)
  {
    ForegroundRoundedImageView localForegroundRoundedImageView = (ForegroundRoundedImageView)scoop.inflater(getContext()).inflate(2130903358, secondaryContainer, false);
    localForegroundRoundedImageView.setVisibility(8);
    localForegroundRoundedImageView.setImageResource(paramInt2);
    localForegroundRoundedImageView.setId(paramInt1);
    localForegroundRoundedImageView.setOnClickListener(onItemClickListener);
    secondaryContainer.addView(localForegroundRoundedImageView);
    return this;
  }
  
  public DriverToolbar addItem(int paramInt, Drawable paramDrawable)
  {
    ForegroundRoundedImageView localForegroundRoundedImageView = (ForegroundRoundedImageView)scoop.inflater(getContext()).inflate(2130903358, secondaryContainer, false);
    localForegroundRoundedImageView.setVisibility(8);
    localForegroundRoundedImageView.setImageDrawable(paramDrawable);
    localForegroundRoundedImageView.setId(paramInt);
    localForegroundRoundedImageView.setOnClickListener(onItemClickListener);
    secondaryContainer.addView(localForegroundRoundedImageView);
    return this;
  }
  
  public DriverToolbar hideDivider()
  {
    dividerView.setVisibility(8);
    return this;
  }
  
  public void hideOverflowMenu()
  {
    overflowToolbarItemButton.setVisibility(4);
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    if (isInEditMode()) {
      return;
    }
    ButterKnife.bind(this);
    init();
  }
  
  void onHomeClick()
  {
    slideMenuController.toggle();
  }
  
  void onOverflowClick()
  {
    dialogFlow.show(new DriverDialogs.DriverOverflowMenuScreen());
  }
  
  public void setOnItemClickAction(Action1<Integer> paramAction1)
  {
    Preconditions.checkNotNull(paramAction1);
    onItemClickAction = paramAction1;
  }
  
  public DriverToolbar showDivider()
  {
    dividerView.setVisibility(0);
    return this;
  }
  
  public void showOverflowMenu()
  {
    overflowToolbarItemButton.setVisibility(0);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.controls.DriverToolbar
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */