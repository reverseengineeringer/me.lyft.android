package me.lyft.android.ui.driver;

import android.content.Context;
import android.content.res.Resources;
import android.text.Html;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.lyft.rx.MessageBus;
import com.lyft.scoop.dagger.DaggerInjector;
import com.squareup.picasso.RequestCreator;
import javax.inject.Inject;
import me.lyft.android.ILyftPreferences;
import me.lyft.android.RideFlags;
import me.lyft.android.application.geo.IGeoService;
import me.lyft.android.application.ride.IDriverRideProvider;
import me.lyft.android.common.AppFlow;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.common.Strings;
import me.lyft.android.domain.driver.ride.DriverRide;
import me.lyft.android.domain.driver.ride.DriverRidePassenger;
import me.lyft.android.domain.driver.ride.DriverStop;
import me.lyft.android.domain.location.Location;
import me.lyft.android.managers.ImageLoader;
import me.lyft.android.navigation.Navigator;
import me.lyft.android.rx.Binder;
import me.lyft.android.ui.UserImageView;
import me.lyft.android.ui.dialogs.DialogContainerView;
import me.lyft.android.ui.tooltips.TooltipContainerView;
import me.lyft.android.utils.GoogleMapsUrlBuilder;
import rx.functions.Action1;

public class NavigationDialogView
  extends DialogContainerView
{
  public static final int NAVIGATION_PREVIEW_ZOOM_LEVEL = 14;
  TextView addressTextView;
  @Inject
  AppFlow appFlow;
  private Binder binder;
  @Inject
  MessageBus bus;
  Button closeButton;
  @Inject
  DialogFlow dialogFlow;
  private DriverStop displayedStop;
  @Inject
  IGeoService geoService;
  @Inject
  ImageLoader imageLoader;
  @Inject
  ILyftPreferences lyftPreferences;
  ImageView mapPinImageView;
  Button navigateButton;
  @Inject
  Navigator navigator;
  private Action1<DriverRide> onRouteChanged = new NavigationDialogView.2(this);
  TextView passengerNameTextView;
  UserImageView passengerPhotoImageView;
  @Inject
  IDriverRideProvider routeProvider;
  ImageView staticMap;
  RelativeLayout staticMapLayout;
  TooltipContainerView tooltipContainer;
  
  public NavigationDialogView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    DaggerInjector.fromView(this).inject(this);
  }
  
  private void displayAddress(Location paramLocation)
  {
    String str = paramLocation.getDisplayName();
    if (Strings.isNullOrEmpty(str))
    {
      addressTextView.setText(2131165292);
      binder.bind(geoService.reverseGeocode(paramLocation), new NavigationDialogView.3(this));
      return;
    }
    addressTextView.setText(str);
  }
  
  private ViewGroup.LayoutParams getAddressTextViewLayoutParams()
  {
    ViewGroup.LayoutParams localLayoutParams = addressTextView.getLayoutParams();
    if ((!routeProvider.getDriverRide().isCourier()) && (getStop().isDropOff()))
    {
      width = -1;
      return localLayoutParams;
    }
    width = -2;
    return localLayoutParams;
  }
  
  private int getMapPinResource()
  {
    if (getStop().isPickup()) {
      return 2130838459;
    }
    return 2130838453;
  }
  
  private DriverRidePassenger getPassenger()
  {
    return routeProvider.getDriverRide().getCurrentPassenger();
  }
  
  private int getPinResource()
  {
    if (getStop().isPickup()) {
      return 2130838457;
    }
    return 2130838456;
  }
  
  private String getStaticMap()
  {
    return new GoogleMapsUrlBuilder().setCenter(getStop().getLocation().toQueryString()).setSize(640, 640).setZoom(14).build();
  }
  
  private DriverStop getStop()
  {
    return routeProvider.getDriverRide().getCurrentStop();
  }
  
  private void loadImages()
  {
    passengerPhotoImageView.loadPhoto(getPassenger().getPhotoUrl());
    passengerPhotoImageView.setUserPartySize(Integer.valueOf(getPassenger().getPartySize()));
    imageLoader.load(getStaticMap()).into(staticMap);
  }
  
  private void setButtonStyles()
  {
    if (getStop().isPickup())
    {
      navigateButton.setTextColor(getResources().getColorStateList(2131493092));
      navigateButton.setBackgroundDrawable(getResources().getDrawable(2130837606));
      return;
    }
    navigateButton.setTextColor(getResources().getColorStateList(2131493093));
    navigateButton.setBackgroundDrawable(getResources().getDrawable(2130837611));
  }
  
  private void showTooltips()
  {
    if (!routeProvider.getDriverRide().showHints()) {
      return;
    }
    tooltipContainer.tryToShowAndMarkShown("pickup_modal_navigate_button", navigateButton, 80);
  }
  
  private void styleDropoff()
  {
    if (getStop().getLocation().isNull())
    {
      staticMapLayout.setVisibility(8);
      navigateButton.setVisibility(8);
      addressTextView.setHint(Html.fromHtml(getResources().getString(2131166138)));
    }
    if (!routeProvider.getDriverRide().isCourier())
    {
      addressTextView.setGravity(16);
      addressTextView.setOnClickListener(getAddressTextClickListener());
      addressTextView.setBackgroundDrawable(getResources().getDrawable(2130837512));
    }
  }
  
  public View.OnClickListener getAddressTextClickListener()
  {
    return new NavigationDialogView.5(this);
  }
  
  public View.OnClickListener getNavigateButtonListener()
  {
    return new NavigationDialogView.4(this);
  }
  
  protected int getTitleTextId()
  {
    if (getStop().isPickup()) {
      return 2131165616;
    }
    return 2131165592;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    ButterKnife.bind(this);
    displayedStop = routeProvider.getDriverRide().getCurrentStop();
    binder = Binder.attach(this);
    binder.bind(routeProvider.observeRide(), onRouteChanged);
    Location localLocation = displayedStop.getLocation();
    if (!localLocation.isNull()) {
      displayAddress(localLocation);
    }
    passengerNameTextView.setText(getResources().getString(getTitleTextId(), new Object[] { routeProvider.getDriverRide().getCurrentPassenger().getFirstName() }));
    styleDialog();
    loadImages();
    navigateButton.setOnClickListener(getNavigateButtonListener());
    closeButton.setOnClickListener(new NavigationDialogView.1(this));
    setShownFlag();
    showTooltips();
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
  }
  
  protected void setShownFlag()
  {
    RideFlags localRideFlags = lyftPreferences.getRideFlags();
    localRideFlags.setPickupMessageShown(true);
    lyftPreferences.setRideFlags(localRideFlags);
  }
  
  protected void styleDialog()
  {
    addressTextView.setCompoundDrawablesWithIntrinsicBounds(getPinResource(), 0, 0, 0);
    mapPinImageView.setImageResource(getMapPinResource());
    addressTextView.setLayoutParams(getAddressTextViewLayoutParams());
    if (getStop().isDropOff()) {
      styleDropoff();
    }
    setButtonStyles();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.driver.NavigationDialogView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */