package me.lyft.android.application.passenger;

import com.lyft.android.api.dto.PickupGeofenceDTO;
import com.lyft.android.api.dto.RideUpdateRequestDTOBuilder;
import com.lyft.android.api.dto.ShareRouteDTO;
import com.lyft.android.api.dto.ShareRouteRequestDTO;
import com.lyft.android.api.dto.UniversalDTO;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import me.lyft.android.analytics.core.ActionAnalytics;
import me.lyft.android.analytics.studies.RideAnalytics;
import me.lyft.android.analytics.utils.AnalyticsUtils;
import me.lyft.android.application.checkout.ICheckoutSession;
import me.lyft.android.application.ride.IExpenseNoteSession;
import me.lyft.android.application.ride.IRatingSession;
import me.lyft.android.application.ride.IRideRequestSession;
import me.lyft.android.common.DeviceClock;
import me.lyft.android.common.Strings;
import me.lyft.android.common.Unit;
import me.lyft.android.domain.location.Location;
import me.lyft.android.domain.location.LocationMapper;
import me.lyft.android.domain.passenger.ride.PassengerRide;
import me.lyft.android.domain.passenger.ride.PassengerRideExpense;
import me.lyft.android.domain.passenger.ride.PassengerRidePayment;
import me.lyft.android.domain.passenger.ride.PassengerRideRating;
import me.lyft.android.domain.passenger.ride.PickupGeofence;
import me.lyft.android.domain.passenger.ride.PickupGeofenceMapper;
import me.lyft.android.domain.payment.PaymentMapper;
import me.lyft.android.domain.ride.CancellationOption;
import me.lyft.android.infrastructure.location.ILocationService;
import me.lyft.android.infrastructure.lyft.ILyftApi;
import me.lyft.android.rx.AsyncCall;
import rx.Notification;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

public class PassengerRideService
  implements IPassengerRideService
{
  private final ICheckoutSession checkoutSession;
  private final IExpenseNoteSession expenseNoteSession;
  private final ILocationService locationService;
  private final ILyftApi lyftApi;
  private final IPassengerRideProvider passengerRideProvider;
  private final IRatingSession ratingSession;
  private final IRideRequestSession rideRequestSession;
  
  public PassengerRideService(ILyftApi paramILyftApi, IPassengerRideProvider paramIPassengerRideProvider, ICheckoutSession paramICheckoutSession, ILocationService paramILocationService, IRideRequestSession paramIRideRequestSession, IRatingSession paramIRatingSession, IExpenseNoteSession paramIExpenseNoteSession)
  {
    lyftApi = paramILyftApi;
    passengerRideProvider = paramIPassengerRideProvider;
    checkoutSession = paramICheckoutSession;
    locationService = paramILocationService;
    rideRequestSession = paramIRideRequestSession;
    ratingSession = paramIRatingSession;
    expenseNoteSession = paramIExpenseNoteSession;
  }
  
  private String getDriverImprovementAreas(PassengerRideRating paramPassengerRideRating)
  {
    if (paramPassengerRideRating.getDriverRating() == 5) {
      return null;
    }
    return Strings.emptyToNull(marshalImprovementAreas(paramPassengerRideRating.getImprovementAreas()));
  }
  
  static String marshalImprovementAreas(Set<String> paramSet)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramSet = paramSet.iterator();
    while (paramSet.hasNext())
    {
      String str = (String)paramSet.next();
      if (localStringBuilder.length() > 0) {
        localStringBuilder.append(',');
      }
      localStringBuilder.append(str);
    }
    return localStringBuilder.toString();
  }
  
  public Observable<Unit> cancelRide(final CancellationOption paramCancellationOption, int paramInt)
  {
    final PassengerRide localPassengerRide = passengerRideProvider.getPassengerRide();
    final String str;
    if (!Strings.isNullOrEmpty(paramCancellationOption.getStatus())) {
      str = paramCancellationOption.getStatus();
    }
    for (;;)
    {
      final ActionAnalytics localActionAnalytics = RideAnalytics.trackCancelRide(str);
      locationService.getLastLocation().flatMap(new Func1()
      {
        public Observable<UniversalDTO> call(Location paramAnonymousLocation)
        {
          return lyftApi.updateRide(localPassengerRide.getId(), new RideUpdateRequestDTOBuilder().withStatus(str).withActionTimestampMs(Long.valueOf(DeviceClock.getCurrentTimeMs())).withLocation(LocationMapper.toLocationDTO(paramAnonymousLocation)).withCanceledReason(Strings.emptyToNull(paramCancellationOption.getId())).build());
        }
      }).map(Unit.func1()).doOnEach(new Action1()
      {
        public void call(Notification<? super Unit> paramAnonymousNotification)
        {
          AnalyticsUtils.trackResult(localActionAnalytics, paramAnonymousNotification);
        }
      });
      if (paramInt != 0) {
        str = "canceledWithPenalty";
      } else {
        str = "canceled";
      }
    }
  }
  
  public Observable<Unit> changePickup(Location paramLocation)
  {
    paramLocation = LocationMapper.toDeprecatedPlaceDTO(paramLocation);
    return lyftApi.updateRide(passengerRideProvider.getPassengerRide().getId(), new RideUpdateRequestDTOBuilder().withStartLocation(paramLocation).build()).map(Unit.func1());
  }
  
  public void fetchPickupGeofence()
  {
    if (passengerRideProvider.hasPickupGeofence()) {
      return;
    }
    final String str = passengerRideProvider.getPassengerRide().getId();
    lyftApi.getPickupGeofence(str).subscribe(new AsyncCall()
    {
      public void onFail(Throwable paramAnonymousThrowable)
      {
        passengerRideProvider.updatePickupGeofence(PickupGeofence.empty());
      }
      
      public void onSuccess(PickupGeofenceDTO paramAnonymousPickupGeofenceDTO)
      {
        passengerRideProvider.updatePickupGeofence(PickupGeofenceMapper.from(paramAnonymousPickupGeofenceDTO, str));
      }
    });
  }
  
  public Observable<Unit> rateAndPayDriver(PassengerRideRating paramPassengerRideRating, final PassengerRideExpense paramPassengerRideExpense, PassengerRidePayment paramPassengerRidePayment)
  {
    List localList = PaymentMapper.fromPaymentDomain(paramPassengerRidePayment);
    Boolean localBoolean;
    label25:
    String str;
    if (paramPassengerRideExpense.isNull())
    {
      paramPassengerRidePayment = null;
      if (!paramPassengerRideExpense.isNull()) {
        break label174;
      }
      localBoolean = null;
      if (!paramPassengerRideExpense.isNull()) {
        break label186;
      }
      str = null;
      label35:
      if (!paramPassengerRideExpense.isNull()) {
        break label195;
      }
    }
    label174:
    label186:
    label195:
    for (paramPassengerRideExpense = null;; paramPassengerRideExpense = paramPassengerRideExpense.getExpenseCode())
    {
      paramPassengerRideRating = new RideUpdateRequestDTOBuilder().withDriverRating(Integer.valueOf(paramPassengerRideRating.getDriverRating())).withDriverFeedback(Strings.emptyToNull(paramPassengerRideRating.getFeedback())).withDriverImprovementAreas(getDriverImprovementAreas(paramPassengerRideRating)).withConcurEnabled(paramPassengerRidePayment).withExpenseNote(str).withExpenseCode(paramPassengerRideExpense).withPayment(localList).withIsBusinessRide(localBoolean).build();
      paramPassengerRideExpense = RideAnalytics.trackRateAndPayDriver();
      lyftApi.updateRide(passengerRideProvider.getPassengerRide().getId(), paramPassengerRideRating).doOnNext(new Action1()
      {
        public void call(UniversalDTO paramAnonymousUniversalDTO)
        {
          rideRequestSession.clearRideRequest();
          ratingSession.reset();
          expenseNoteSession.reset();
          checkoutSession.resetChargeAccountAndCoupon();
          paramPassengerRideExpense.trackSuccess();
        }
      }).doOnError(new Action1()
      {
        public void call(Throwable paramAnonymousThrowable)
        {
          paramPassengerRideExpense.trackFailure(paramAnonymousThrowable);
        }
      }).map(Unit.func1());
      paramPassengerRidePayment = Boolean.valueOf(paramPassengerRideExpense.isConcurEnabled());
      break;
      localBoolean = Boolean.valueOf(paramPassengerRideExpense.isBusinessProfileEnabled());
      break label25;
      str = paramPassengerRideExpense.getExpenseNote();
      break label35;
    }
  }
  
  public Observable<Unit> setDropoff(Location paramLocation)
  {
    return lyftApi.updateRide(passengerRideProvider.getPassengerRide().getId(), new RideUpdateRequestDTOBuilder().withEndLocation(LocationMapper.toDeprecatedPlaceDTO(paramLocation)).build()).map(Unit.func1());
  }
  
  public Observable<String> shareRoute()
  {
    ShareRouteRequestDTO localShareRouteRequestDTO = new ShareRouteRequestDTO(passengerRideProvider.getPassengerRide().getId());
    lyftApi.getShareRouteUrl(localShareRouteRequestDTO).map(new Func1()
    {
      public String call(ShareRouteDTO paramAnonymousShareRouteDTO)
      {
        return shareUrl;
      }
    });
  }
  
  public void updatePassengerRide(PassengerRide paramPassengerRide)
  {
    passengerRideProvider.updatePassengerRide(paramPassengerRide);
    if ((paramPassengerRide.isPickupEditEnabled()) && (!passengerRideProvider.hasPickupGeofence())) {
      fetchPickupGeofence();
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.passenger.PassengerRideService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */