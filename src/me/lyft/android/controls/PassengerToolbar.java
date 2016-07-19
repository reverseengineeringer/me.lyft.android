package me.lyft.android.controls;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import butterknife.ButterKnife;
import com.lyft.scoop.Scoop;
import com.lyft.scoop.dagger.DaggerInjector;
import com.lyft.widgets.ForegroundRoundedImageView;
import com.squareup.picasso.RequestCreator;
import javax.inject.Inject;
import me.lyft.android.application.IUserProvider;
import me.lyft.android.common.Preconditions;
import me.lyft.android.domain.User;
import me.lyft.android.managers.ImageLoader;
import me.lyft.android.ui.SlideMenuController;
import me.lyft.android.ui.passenger.v2.request.pickup.ScheduledRidesToolbarItem;
import rx.functions.Action1;
import rx.functions.Actions;

public class PassengerToolbar
  extends LinearLayout
{
  View driverModeToggleView;
  ForegroundRoundedImageView homeImageView;
  @Inject
  ImageLoader imageLoader;
  private LayoutInflater inflater;
  ImageView logoImageView;
  private Action1<Integer> onItemClickAction = Actions.empty();
  private final View.OnClickListener onItemClickListener = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      int i = paramAnonymousView.getId();
      onItemClickAction.call(Integer.valueOf(i));
    }
  };
  ScheduledRidesToolbarItem scheduledRidesToolbarItem;
  private Scoop scoop;
  FrameLayout secondaryContainer;
  @Inject
  SlideMenuController slideMenuController;
  @Inject
  IUserProvider userProvider;
  
  public PassengerToolbar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    if (isInEditMode()) {
      return;
    }
    scoop = Scoop.fromView(this);
    inflater = scoop.inflater(paramContext);
    inflater.inflate(2130903359, this, true);
    DaggerInjector.fromView(this).inject(this);
  }
  
  private void init()
  {
    scheduledRidesToolbarItem.setOnClickListener(onItemClickListener);
    homeImageView.setForegroundDrawable(2130837661);
    imageLoader.load(userProvider.getUser().getPhotoUrl()).fit().centerCrop().placeholder(2130838447).into(homeImageView);
  }
  
  private PassengerToolbar show(View paramView, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      paramView.setVisibility(i);
      return this;
    }
  }
  
  private PassengerToolbar showDriverToggle(boolean paramBoolean)
  {
    show(driverModeToggleView, paramBoolean);
    return this;
  }
  
  private PassengerToolbar showLogo(boolean paramBoolean)
  {
    show(logoImageView, paramBoolean);
    return this;
  }
  
  public PassengerToolbar hideDriverModeToggle()
  {
    showLogo(true);
    showDriverToggle(false);
    return this;
  }
  
  public PassengerToolbar hideScheduledRidesButton()
  {
    scheduledRidesToolbarItem.setVisibility(8);
    return this;
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
  
  public void removeToolbarItem(int paramInt)
  {
    View localView = secondaryContainer.findViewById(paramInt);
    if (localView != null) {
      secondaryContainer.removeView(localView);
    }
  }
  
  public void setOnItemClickAction(Action1<Integer> paramAction1)
  {
    Preconditions.checkNotNull(paramAction1);
    onItemClickAction = paramAction1;
  }
  
  public PassengerToolbar setSecondaryItem(int paramInt1, int paramInt2)
  {
    secondaryContainer.removeAllViews();
    hideScheduledRidesButton();
    ForegroundRoundedImageView localForegroundRoundedImageView = (ForegroundRoundedImageView)inflater.inflate(2130903358, secondaryContainer, false);
    localForegroundRoundedImageView.setImageResource(paramInt2);
    localForegroundRoundedImageView.setId(paramInt1);
    localForegroundRoundedImageView.setOnClickListener(onItemClickListener);
    secondaryContainer.addView(localForegroundRoundedImageView);
    return this;
  }
  
  public PassengerToolbar setSecondaryItem(int paramInt, Drawable paramDrawable)
  {
    secondaryContainer.removeAllViews();
    hideScheduledRidesButton();
    ForegroundRoundedImageView localForegroundRoundedImageView = (ForegroundRoundedImageView)inflater.inflate(2130903358, secondaryContainer, false);
    localForegroundRoundedImageView.setImageDrawable(paramDrawable);
    localForegroundRoundedImageView.setId(paramInt);
    localForegroundRoundedImageView.setOnClickListener(onItemClickListener);
    secondaryContainer.addView(localForegroundRoundedImageView);
    return this;
  }
  
  public PassengerToolbar showDriverModeToggle()
  {
    showLogo(false);
    showDriverToggle(true);
    return this;
  }
  
  public PassengerToolbar showScheduledRidesButton()
  {
    secondaryContainer.removeAllViews();
    scheduledRidesToolbarItem.setVisibility(0);
    return this;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.controls.PassengerToolbar
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */