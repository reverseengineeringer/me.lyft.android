package me.lyft.android.ui.passenger.v2.request.venue;

import android.content.res.Resources;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.lyft.scoop.HandleBack;
import com.lyft.scoop.Screen;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import me.lyft.android.application.ride.IRideRequestSession;
import me.lyft.android.common.AppFlow;
import me.lyft.android.common.RxViewController;
import me.lyft.android.domain.venue.Venue;
import me.lyft.android.domain.venue.VenuePickupLocation;
import me.lyft.android.domain.venue.VenueZone;
import me.lyft.android.maps.renderers.VenueMergingMarkerRenderer;
import me.lyft.android.rx.RxUIBinder;
import me.lyft.android.ui.passenger.PassengerScreens.IntroduceVenueScreen;
import me.lyft.android.ui.ride.RideMap;
import me.lyft.android.utils.VersionUtils;

public class IntroduceVenueController
  extends RxViewController
  implements HandleBack
{
  private final AppFlow appFlow;
  TextView content;
  FrameLayout mapPlaceholder;
  private final VenueMergingMarkerRenderer markerRenderer;
  TextView message;
  View overlay;
  private final RideMap rideMap;
  private final IRideRequestSession rideRequestSession;
  
  @Inject
  public IntroduceVenueController(AppFlow paramAppFlow, RideMap paramRideMap, IRideRequestSession paramIRideRequestSession, VenueMergingMarkerRenderer paramVenueMergingMarkerRenderer)
  {
    appFlow = paramAppFlow;
    rideMap = paramRideMap;
    rideRequestSession = paramIRideRequestSession;
    markerRenderer = paramVenueMergingMarkerRenderer;
  }
  
  protected int layoutId()
  {
    return 2130903253;
  }
  
  public void onAttach()
  {
    super.onAttach();
    rideMap.attach(mapPlaceholder);
    Venue localVenue = fromControllervenue;
    message.setText(getView().getResources().getString(2131166414, new Object[] { localVenue.getVenueName() }));
    content.setText(localVenue.getIntroductionMessage());
    overlay.setOnClickListener(new IntroduceVenueController.1(this));
    if (VersionUtils.isIceCreamSandwich()) {
      overlay.setBackgroundResource(2131492872);
    }
    ArrayList localArrayList = new ArrayList(localVenue.getLocationCount());
    Iterator localIterator1 = localVenue.getVenueZones().iterator();
    while (localIterator1.hasNext())
    {
      Iterator localIterator2 = ((VenueZone)localIterator1.next()).getVenuePickupLocations().iterator();
      while (localIterator2.hasNext()) {
        localArrayList.add((VenuePickupLocation)localIterator2.next());
      }
    }
    localArrayList.add(rideRequestSession.getPickupLocation());
    binder.bindAction(rideMap.observeMapLoaded(), new IntroduceVenueController.2(this, localArrayList, localVenue));
  }
  
  public boolean onBack()
  {
    appFlow.goBack();
    return true;
  }
  
  public void onDetach()
  {
    super.onDetach();
    rideMap.clearPickupMarker();
    markerRenderer.clear();
    rideMap.detach();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.passenger.v2.request.venue.IntroduceVenueController
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */