package me.lyft.android.application.ride;

import com.lyft.android.api.dto.RideRequestDTOBuilder;
import com.lyft.android.api.dto.RideRequestDetailsDTO;
import com.lyft.android.api.dto.ScheduledRideDTO;
import com.lyft.android.api.dto.ScheduledRideRequestDTO;
import com.lyft.android.api.dto.ScheduledRideRequestDTOBuilder;
import java.util.Iterator;
import java.util.List;
import me.lyft.android.analytics.core.ActionAnalytics;
import me.lyft.android.analytics.core.ExperimentAnalytics;
import me.lyft.android.analytics.core.definitions.Experiment;
import me.lyft.android.analytics.studies.RideAnalytics;
import me.lyft.android.application.IUserProvider;
import me.lyft.android.application.checkout.ICheckoutSession;
import me.lyft.android.application.constants.Constants;
import me.lyft.android.application.constants.IConstantsProvider;
import me.lyft.android.application.cost.CostMapper;
import me.lyft.android.application.cost.ICostService;
import me.lyft.android.application.features.Features;
import me.lyft.android.application.features.IFeaturesProvider;
import me.lyft.android.application.landing.exceptions.TermsNotAcceptedException;
import me.lyft.android.application.passenger.IPassengerRideProvider;
import me.lyft.android.application.payment.IPaymentDefaultsService;
import me.lyft.android.application.payment.IPaymentService;
import me.lyft.android.application.payment.PaymentException;
import me.lyft.android.application.requestridetypes.IRequestRideTypeService;
import me.lyft.android.common.Strings;
import me.lyft.android.common.Unit;
import me.lyft.android.domain.User;
import me.lyft.android.domain.cost.CostEstimate;
import me.lyft.android.domain.location.Location;
import me.lyft.android.domain.location.LocationMapper;
import me.lyft.android.domain.lyft.LyftError;
import me.lyft.android.domain.lyft.LyftValidationError;
import me.lyft.android.domain.passenger.ride.PassengerRideMapper;
import me.lyft.android.domain.passenger.ridetypes.RequestRideType;
import me.lyft.android.domain.passenger.ridetypes.RequestRideType.Feature;
import me.lyft.android.domain.payment.ChargeAccount;
import me.lyft.android.domain.ride.ScheduledInterval;
import me.lyft.android.domain.ride.ScheduledIntervalMapper;
import me.lyft.android.domain.ride.ScheduledRide;
import me.lyft.android.domain.ride.ScheduledRideMapper;
import me.lyft.android.domain.time.Time;
import me.lyft.android.infrastructure.location.ILocationService;
import me.lyft.android.infrastructure.lyft.ILyftApi;
import me.lyft.android.infrastructure.lyft.LyftApiException;
import me.lyft.android.infrastructure.paypal.IPayPalService;
import me.lyft.android.persistence.payment.IChargeAccountsProvider;
import rx.Notification;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

public class RideRequestService
  implements IRideRequestService
{
  static final String DESTINATION_REQUIRED_ERROR_CODE = "destination_required";
  static final String DESTINATION_REQUIRED_ERROR_REASON = "destinationRequired";
  static final String INACTIVE_CARPOOL_ROUTE_ERROR_CODE = "inactive_chauffeur_route";
  static final String INACTIVE_CARPOOL_ROUTE_ERROR_REASON = "inactiveChauffeurRoute";
  private static final float PICKUP_DISTANCE_FROM_CURRENT_LOCATION_THRESHOLD_METERS = 150.0F;
  static final String PRIMETIME_CONFIRMATION_REQUIRED = "primetime_confirmation_required";
  private final IChargeAccountsProvider chargeAccountsProvider;
  private final ICheckoutSession checkoutSession;
  private final IConstantsProvider constantsProvider;
  private final ICostService costService;
  private final IPaymentDefaultsService defaultPaymentSettingsService;
  private final IFeaturesProvider featuresProvider;
  private final ILocationService locationService;
  private final ILyftApi lyftApi;
  private final IPassengerRideProvider passengerRideProvider;
  private final IPayPalService payPalService;
  private final IPaymentService paymentService;
  private final IRequestRideTypeService requestRideTypeService;
  private final IRideRequestSession rideRequestSession;
  private final IUserProvider userProvider;
  
  public RideRequestService(IUserProvider paramIUserProvider, IChargeAccountsProvider paramIChargeAccountsProvider, ILocationService paramILocationService, IRideRequestSession paramIRideRequestSession, ILyftApi paramILyftApi, ICheckoutSession paramICheckoutSession, IConstantsProvider paramIConstantsProvider, IFeaturesProvider paramIFeaturesProvider, IPaymentService paramIPaymentService, IPaymentDefaultsService paramIPaymentDefaultsService, IPayPalService paramIPayPalService, ICostService paramICostService, IPassengerRideProvider paramIPassengerRideProvider, IRequestRideTypeService paramIRequestRideTypeService)
  {
    userProvider = paramIUserProvider;
    chargeAccountsProvider = paramIChargeAccountsProvider;
    locationService = paramILocationService;
    rideRequestSession = paramIRideRequestSession;
    lyftApi = paramILyftApi;
    checkoutSession = paramICheckoutSession;
    constantsProvider = paramIConstantsProvider;
    featuresProvider = paramIFeaturesProvider;
    paymentService = paramIPaymentService;
    defaultPaymentSettingsService = paramIPaymentDefaultsService;
    payPalService = paramIPayPalService;
    costService = paramICostService;
    passengerRideProvider = paramIPassengerRideProvider;
    requestRideTypeService = paramIRequestRideTypeService;
  }
  
  private void clearPartySizeForInvalidRequest(Throwable paramThrowable)
  {
    if (((paramThrowable instanceof LyftApiException)) && (400 == ((LyftApiException)paramThrowable).getStatusCode())) {
      rideRequestSession.clearPartySize();
    }
  }
  
  private Observable<Unit> createLyftApiRequest(Location paramLocation1, Location paramLocation2)
  {
    CostEstimate localCostEstimate = rideRequestSession.getCostEstimate();
    Integer localInteger = resolvePartySize();
    paramLocation1 = new RideRequestDTOBuilder().withRideType(rideRequestSession.getCurrentRideType().getPublicId()).withOrigin(LocationMapper.toPlaceDTO(paramLocation1)).withDestination(LocationMapper.toPlaceDTO(paramLocation2)).withCostToken(localCostEstimate.getCostToken()).withPartySize(localInteger).withPaymentAccountId(checkoutSession.getSelectedPaymentMethodId()).withChargeToken(obtainChargeToken()).withIsBusinessRide(Boolean.valueOf(checkoutSession.isBusinessProfile())).withCarpoolDropoffTimeMs(Long.valueOf(rideRequestSession.getScheduledInterval().getDropoffTime().getTimestamp())).build();
    lyftApi.createRide(paramLocation1).onErrorResumeNext(new Func1()
    {
      public Observable<? extends RideRequestDetailsDTO> call(Throwable paramAnonymousThrowable)
      {
        RideRequestService.this.clearPartySizeForInvalidRequest(paramAnonymousThrowable);
        paramAnonymousThrowable = RideRequestService.this.handleCostTokenChange(paramAnonymousThrowable);
        paramAnonymousThrowable = RideRequestService.this.handleInactiveCarpoolRoute(paramAnonymousThrowable);
        return Observable.error(TermsNotAcceptedException.transform(RideRequestService.this.handleDestinationRequired(paramAnonymousThrowable)));
      }
    }).doOnNext(new Action1()
    {
      public void call(RideRequestDetailsDTO paramAnonymousRideRequestDetailsDTO)
      {
        paramAnonymousRideRequestDetailsDTO = PassengerRideMapper.fromRideRequestDetailsDTO(paramAnonymousRideRequestDetailsDTO);
        passengerRideProvider.updatePassengerRide(paramAnonymousRideRequestDetailsDTO);
      }
    }).map(Unit.func1());
  }
  
  private Observable<Unit> createPaymentTokenRequest()
  {
    ChargeAccount localChargeAccount = chargeAccountsProvider.getDefaultOrFirstValidChargeAccount();
    Observable localObservable2 = Unit.just();
    Observable localObservable1 = localObservable2;
    if (localChargeAccount != null)
    {
      localObservable1 = localObservable2;
      if (localChargeAccount.isWallet()) {
        localObservable1 = paymentService.saveAndroidPayCard().onErrorResumeNext(new Func1()
        {
          public Observable<Unit> call(Throwable paramAnonymousThrowable)
          {
            if ((paramAnonymousThrowable instanceof PaymentException)) {
              return Observable.error(new NoValidChargeAccountException());
            }
            return Observable.error(paramAnonymousThrowable);
          }
        });
      }
    }
    return localObservable1;
  }
  
  private Observable<Unit> createRide()
  {
    createPaymentTokenRequest().flatMap(new Func1()
    {
      public Observable<Unit> call(Unit paramAnonymousUnit)
      {
        return val$requestRideObservable;
      }
    }).doOnNext(new Action1()
    {
      public void call(Unit paramAnonymousUnit)
      {
        rideRequestSession.clearConfirmations();
        checkoutSession.reset();
      }
    });
  }
  
  private Observable<ScheduledRide> createScheduledRide()
  {
    ScheduledRideRequestDTO localScheduledRideRequestDTO = new ScheduledRideRequestDTOBuilder().withPaymentAccountId(checkoutSession.getSelectedPaymentMethodId()).withIsBusinessRide(Boolean.valueOf(checkoutSession.isBusinessProfile())).withChargeToken(obtainChargeToken()).withCostToken(rideRequestSession.getCostEstimate().getCostToken()).withScheduledPickupRange(ScheduledIntervalMapper.toTimeRangeDTO(rideRequestSession.getScheduledInterval().getPickupTimeRange())).withRideType(rideRequestSession.getCurrentRideType().getPublicId()).withOrigin(LocationMapper.toPlaceDTO(rideRequestSession.getPickupLocation())).withDestination(LocationMapper.toPlaceDTO(rideRequestSession.getDropoffLocation())).build();
    createPaymentTokenRequest().flatMap(new Func1()
    {
      public Observable<ScheduledRideDTO> call(Unit paramAnonymousUnit)
      {
        return val$scheduleRideObservable;
      }
    }).map(new Func1()
    {
      public ScheduledRide call(ScheduledRideDTO paramAnonymousScheduledRideDTO)
      {
        return ScheduledRideMapper.fromScheduledRideDTO(paramAnonymousScheduledRideDTO, requestRideTypeService.getRideTypes());
      }
    });
  }
  
  private String getCostErrorMessage()
  {
    return rideRequestSession.getCostEstimate().getErrorMessage();
  }
  
  private Throwable handleCostTokenChange(Throwable paramThrowable)
  {
    Throwable localThrowable = paramThrowable;
    Object localObject = localThrowable;
    if ((paramThrowable instanceof LyftApiException))
    {
      paramThrowable = ((LyftApiException)paramThrowable).getLyftError();
      String str = paramThrowable.getCostToken();
      localObject = localThrowable;
      if (!Strings.isNullOrEmpty(str))
      {
        paramThrowable = CostMapper.fromTokenAndMultiplier(str, paramThrowable.getPrimeTimeMultiplier());
        rideRequestSession.setCostEstimate(paramThrowable);
        localObject = new PrimeTimeNotConfirmedException();
      }
    }
    return (Throwable)localObject;
  }
  
  private Throwable handleDestinationRequired(Throwable paramThrowable)
  {
    Throwable localThrowable = paramThrowable;
    Object localObject = localThrowable;
    if ((paramThrowable instanceof LyftApiException))
    {
      paramThrowable = ((LyftApiException)paramThrowable).getLyftError();
      localObject = localThrowable;
      if (Strings.equalsIgnoreCase(paramThrowable.getErrorCode(), "destination_required")) {
        localObject = new DestinationRequiredException(paramThrowable.getErrorCode(), paramThrowable.getErrorDescription());
      }
    }
    return (Throwable)localObject;
  }
  
  private Throwable handleDestinationRequiredForOldApi(Throwable paramThrowable)
  {
    Object localObject1 = paramThrowable;
    Object localObject2 = localObject1;
    if ((paramThrowable instanceof LyftApiException))
    {
      Iterator localIterator = ((LyftApiException)paramThrowable).getValidationErrors().iterator();
      paramThrowable = (Throwable)localObject1;
      for (;;)
      {
        localObject2 = paramThrowable;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject1 = (LyftValidationError)localIterator.next();
        localObject2 = ((LyftValidationError)localObject1).getReason();
        if (Strings.equalsIgnoreCase("destinationRequired", (String)localObject2)) {
          paramThrowable = new DestinationRequiredException((String)localObject2, ((LyftValidationError)localObject1).getMessage());
        }
      }
    }
    return (Throwable)localObject2;
  }
  
  private Throwable handleInactiveCarpoolRoute(Throwable paramThrowable)
  {
    Throwable localThrowable = paramThrowable;
    Object localObject = localThrowable;
    if ((paramThrowable instanceof LyftApiException))
    {
      paramThrowable = ((LyftApiException)paramThrowable).getLyftError();
      localObject = localThrowable;
      if (Strings.equalsIgnoreCase(paramThrowable.getErrorCode(), "inactive_chauffeur_route")) {
        localObject = new InactiveCarpoolRouteException(paramThrowable.getErrorCode(), paramThrowable.getErrorDescription());
      }
    }
    return (Throwable)localObject;
  }
  
  private Throwable handleInactiveCarpoolRouteForOldApi(Throwable paramThrowable)
  {
    Object localObject1 = paramThrowable;
    Object localObject2 = localObject1;
    if ((paramThrowable instanceof LyftApiException))
    {
      Iterator localIterator = ((LyftApiException)paramThrowable).getValidationErrors().iterator();
      paramThrowable = (Throwable)localObject1;
      for (;;)
      {
        localObject2 = paramThrowable;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject1 = (LyftValidationError)localIterator.next();
        localObject2 = ((LyftValidationError)localObject1).getReason();
        if (Strings.equalsIgnoreCase("inactiveChauffeurRoute", (String)localObject2)) {
          paramThrowable = new InactiveCarpoolRouteException((String)localObject2, ((LyftValidationError)localObject1).getMessage());
        }
      }
    }
    return (Throwable)localObject2;
  }
  
  private boolean isInaccurateDefaultPickupLocation()
  {
    boolean bool = false;
    Location localLocation = rideRequestSession.getPickupLocation();
    Double localDouble = (Double)constantsProvider.get(Constants.DEFAULT_LOCATION_ACCURACY_THRESHOLD_METERS);
    if ((Strings.equalsIgnoreCase(localLocation.getSource(), "defaultLocation")) && (localLocation.getAccuracy().doubleValue() > localDouble.doubleValue()) && (!rideRequestSession.isPickupConfirmed())) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        ExperimentAnalytics.trackExposure(Experiment.CONFIRM_INACCURATE_PICKUP);
        bool = featuresProvider.isEnabled(Features.CONFIRM_ACCURACY_ENABLED);
      }
      return bool;
    }
  }
  
  private boolean isPickupTooFarFromCurrentLocationAndNotConfirmed()
  {
    if (!rideRequestSession.getScheduledInterval().isNull()) {}
    Location localLocation;
    do
    {
      return false;
      localLocation = rideRequestSession.getPickupLocation();
    } while ((locationService.getLastCachedLocation().distanceTo(localLocation) <= 150.0D) || (rideRequestSession.isPickupConfirmed()));
    return true;
  }
  
  private boolean isPrimeTimeNotConfirmedAndNotFixedFare()
  {
    if (rideRequestSession.getCurrentRideType().hasFeature(RequestRideType.Feature.FIXED_FARE)) {}
    boolean bool1;
    boolean bool2;
    do
    {
      return false;
      bool1 = rideRequestSession.getCostEstimate().isPrimeTime();
      bool2 = rideRequestSession.isDynamicPricingConfirmed();
    } while ((!bool1) || (bool2));
    return true;
  }
  
  private Boolean isRouteInvalid()
  {
    if (!rideRequestSession.getCostEstimate().isRouteValid()) {}
    for (boolean bool = true;; bool = false) {
      return Boolean.valueOf(bool);
    }
  }
  
  private String obtainChargeToken()
  {
    ChargeAccount localChargeAccount = defaultPaymentSettingsService.getCurrentDefaultChargeAccount();
    if ((localChargeAccount == null) || (!localChargeAccount.isPayPal())) {}
    for (int i = 1; i != 0; i = 0) {
      return "";
    }
    return payPalService.obtainChargeToken();
  }
  
  private <T> Observable<T> preRideRequestChecks(Observable<T> paramObservable)
  {
    User localUser = userProvider.getUser();
    if (!localUser.hasValidPhoneNumber()) {
      return Observable.error(new NoValidPhoneException());
    }
    if (chargeAccountsProvider.hasNoChargeAccounts()) {
      return Observable.error(new NoChargeAccountException());
    }
    if (localUser.hasDebt()) {
      return Observable.error(new HasDebtException());
    }
    if (localUser.hasTermsUrl()) {
      return Observable.error(new TermsNotAcceptedException());
    }
    if (checkoutSession.isBusinessProfile())
    {
      if (chargeAccountsProvider.hasValidBusinessChargeAccount()) {}
    }
    else {
      while (!chargeAccountsProvider.hasValidChargeAccount()) {
        return Observable.error(new NoValidChargeAccountException());
      }
    }
    if (isInaccurateDefaultPickupLocation()) {
      return Observable.error(new ConfirmInaccuratePickupLocationException());
    }
    if (isPickupTooFarFromCurrentLocationAndNotConfirmed()) {
      return Observable.error(new PickupNotConfirmedException());
    }
    if (isRouteInvalid().booleanValue()) {
      return Observable.error(new RouteInvalidException(getCostErrorMessage()));
    }
    if (requiresSeatingAndPartySizeNotSet()) {
      return Observable.error(new PartySizeNotSetException());
    }
    if (isPrimeTimeNotConfirmedAndNotFixedFare()) {
      return Observable.error(new PrimeTimeNotConfirmedException());
    }
    if (rideRequestSession.getPickupLocation().isNull()) {
      return Observable.error(new PickupLocationMissingException());
    }
    if ((rideRequestSession.isForceDestination()) && (rideRequestSession.getDropoffLocation().isNull())) {
      return Observable.error(new DestinationRequiredEscalationException());
    }
    return paramObservable;
  }
  
  private boolean requiresSeatingAndPartySizeNotSet()
  {
    return (rideRequestSession.getCurrentRideType().hasFeature(RequestRideType.Feature.SEATS_REQUIRED)) && (!rideRequestSession.isPartySizeSet());
  }
  
  private Integer resolvePartySize()
  {
    if (rideRequestSession.getCurrentRideType().hasFeature(RequestRideType.Feature.SEATS_REQUIRED)) {
      return Integer.valueOf(rideRequestSession.getPartySize());
    }
    return null;
  }
  
  public Observable<Unit> requestRide(boolean paramBoolean)
  {
    final ActionAnalytics localActionAnalytics = RideAnalytics.trackRequestRideAction();
    rideRequestSession.setRideRequestInProgress(true);
    if (paramBoolean)
    {
      CostEstimate localCostEstimate = costService.getCostEstimate(rideRequestSession.getCurrentRideType().getPublicId());
      rideRequestSession.setCostEstimate(localCostEstimate);
    }
    preRideRequestChecks(createRide()).doOnEach(new Action1()
    {
      public void call(Notification<? super Unit> paramAnonymousNotification)
      {
        rideRequestSession.setRideRequestInProgress(false);
        if (paramAnonymousNotification.isOnNext()) {
          localActionAnalytics.trackSuccess();
        }
        while (!paramAnonymousNotification.isOnError()) {
          return;
        }
        localActionAnalytics.trackFailure(paramAnonymousNotification.getThrowable());
      }
    });
  }
  
  public Observable<ScheduledRide> scheduleRide()
  {
    Observable localObservable = createScheduledRide();
    CostEstimate localCostEstimate = costService.getCostEstimate(rideRequestSession.getCurrentRideType().getPublicId());
    rideRequestSession.setCostEstimate(localCostEstimate);
    preRideRequestChecks(localObservable).doOnNext(new Action1()
    {
      public void call(ScheduledRide paramAnonymousScheduledRide)
      {
        rideRequestSession.clearConfirmations();
        checkoutSession.reset();
      }
    });
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ride.RideRequestService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */