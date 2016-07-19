package me.lyft.android.ui.passenger.v2.pending;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import butterknife.ButterKnife;
import com.lyft.scoop.dagger.DaggerInjector;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import me.lyft.android.ILyftPreferences;
import me.lyft.android.application.passenger.IPassengerRideProvider;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.common.Objects;
import me.lyft.android.common.Strings;
import me.lyft.android.common.Unit;
import me.lyft.android.domain.location.Location;
import me.lyft.android.domain.passenger.ride.PassengerRide;
import me.lyft.android.domain.passenger.ride.PassengerStop;
import me.lyft.android.domain.passenger.ride.RideFeature;
import me.lyft.android.domain.time.Time;
import me.lyft.android.maps.renderers.PinTextRenderer;
import me.lyft.android.rx.Binder;
import me.lyft.android.ui.HeightObservableLayout;
import me.lyft.android.ui.SlideMenuController;
import me.lyft.android.ui.dialogs.Toast;
import me.lyft.android.ui.passenger.MatchingStartTime;
import me.lyft.android.ui.passenger.v2.PassengerMapController;
import me.lyft.android.ui.passenger.v2.PassengerRideRouter;
import rx.functions.Action1;
import rx.subjects.BehaviorSubject;

public class CarpoolMatchingView
  extends RelativeLayout
{
  private static final int PROGRESS_DURATION_MS = 1000;
  private static final String TAG = CarpoolMatchingView.class.getSimpleName();
  private Binder binder;
  @Inject
  DialogFlow dialogFlow;
  MatchingFooterView matchingFooterView;
  private final Action1<Unit> onMapLoaded = new CarpoolMatchingView.6(this);
  @Inject
  PassengerMapController passengerMapController;
  HeightObservableLayout passengerRideBottom;
  @Inject
  IPassengerRideProvider passengerRideProvider;
  @Inject
  PassengerRideRouter passengerRideRouter;
  @Inject
  PinTextRenderer pinTextRenderer;
  @Inject
  ILyftPreferences preferences;
  @Inject
  SlideMenuController slideMenuController;
  
  public CarpoolMatchingView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    DaggerInjector.fromView(this).inject(this);
  }
  
  private long getMatchingStartTime(String paramString)
  {
    MatchingStartTime localMatchingStartTime2 = preferences.getPassengerMatchingStartTime();
    MatchingStartTime localMatchingStartTime1 = localMatchingStartTime2;
    if (!Objects.equals(localMatchingStartTime2.getRideId(), paramString))
    {
      localMatchingStartTime1 = new MatchingStartTime(paramString);
      preferences.setPassengerMatchingStartTime(localMatchingStartTime1);
    }
    return localMatchingStartTime1.getStartTime();
  }
  
  private void setPlaceholderMatchingStrings()
  {
    Object localObject = passengerRideProvider.getPassengerRide().getMatchByTime();
    if (!((Time)localObject).isNull()) {}
    for (localObject = Collections.singletonList(getResources().getString(2131165397, new Object[] { ((Time)localObject).formatTime(), Strings.toUpperCaseEnglish(((Time)localObject).formatDay()) }));; localObject = Collections.singletonList(getResources().getString(2131165395)))
    {
      matchingFooterView.setRotatingMessages((List)localObject);
      matchingFooterView.setIsProgressBarVisible(false);
      return;
    }
  }
  
  private void setupMatchingFooterView()
  {
    PassengerRide localPassengerRide = passengerRideProvider.getPassengerRide();
    matchingFooterView.setPickupLocation(localPassengerRide.getPickup());
    matchingFooterView.setDestinationLocation(localPassengerRide.getDropoff());
    matchingFooterView.setIsRealTimeMatching(localPassengerRide.isRealTimeMatching());
    long l = getMatchingStartTime(localPassengerRide.getId());
    matchingFooterView.setWaitTimeInMillis(1000L, l);
    if (l + 1000L > System.currentTimeMillis())
    {
      showSchedulingRideAnimation();
      if (!localPassengerRide.isFeatureEnabled(RideFeature.PASSENGER_CANCEL)) {
        break label113;
      }
    }
    label113:
    for (int i = 0;; i = 8)
    {
      matchingFooterView.setCancelRideButtonVisibility(i);
      return;
      setPlaceholderMatchingStrings();
      break;
    }
  }
  
  private void showMapMarkers(List<PassengerStop> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      PassengerStop localPassengerStop = (PassengerStop)paramList.next();
      Location localLocation = localPassengerStop.getLocation();
      Time localTime = localPassengerStop.getScheduledTime();
      if (localPassengerStop.isPickup())
      {
        if (localTime.isNull()) {
          passengerMapController.showPickupMarker(localLocation);
        } else {
          passengerMapController.showPickupMarkerWithSchedule(localLocation, getContext().getString(2131166136, new Object[] { localTime.formatDay() }), localTime.formatTime());
        }
      }
      else if (localPassengerStop.isDropOff()) {
        if (localTime.isNull())
        {
          passengerMapController.showDropoffMarker(localLocation);
        }
        else
        {
          int i = getResources().getDimensionPixelSize(2131230744);
          pinTextRenderer.createDestinationPin(localLocation, getResources().getString(2131165663), localTime.formatTime(), i, false);
        }
      }
    }
  }
  
  private void showRideScheduledToast()
  {
    Toast localToast = new Toast(getResources().getString(2131165407), Integer.valueOf(2130838387));
    dialogFlow.show(localToast);
  }
  
  private void showSchedulingRideAnimation()
  {
    List localList = Collections.singletonList(getResources().getString(2131165396));
    matchingFooterView.setRotatingMessages(localList);
    binder.bind(matchingFooterView.observeProgressAnimationEnd(), new CarpoolMatchingView.5(this));
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (isInEditMode()) {
      return;
    }
    binder = Binder.attach(this);
    slideMenuController.enableMenu();
    setupMatchingFooterView();
    binder.bind(passengerMapController.observeMapLoaded(), onMapLoaded);
    binder.bind(passengerMapController.observeAndApplyPaddingChanges(BehaviorSubject.create(Integer.valueOf(getResources().getDimensionPixelSize(2131230823))), passengerRideBottom.observeHeightChange()), new CarpoolMatchingView.4(this));
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    slideMenuController.disableMenu();
    passengerMapController.clearAllMarkers();
    passengerMapController.clearRoutes();
    passengerMapController.reset();
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    if (isInEditMode()) {
      return;
    }
    ButterKnife.bind(this);
    matchingFooterView.setPickupAddressClickListener(new CarpoolMatchingView.1(this));
    matchingFooterView.setDestinationAddressClickListener(new CarpoolMatchingView.2(this));
    matchingFooterView.setCancelRideButtonClickListener(new CarpoolMatchingView.3(this));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.passenger.v2.pending.CarpoolMatchingView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */