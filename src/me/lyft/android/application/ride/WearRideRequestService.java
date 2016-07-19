package me.lyft.android.application.ride;

import com.lyft.android.api.dto.RideRequestDTOBuilder;
import com.lyft.android.api.dto.RideRequestDetailsDTO;
import me.lyft.android.application.IUserProvider;
import me.lyft.android.application.checkout.ICheckoutSession;
import me.lyft.android.application.landing.exceptions.TermsNotAcceptedException;
import me.lyft.android.common.Unit;
import me.lyft.android.domain.User;
import me.lyft.android.domain.location.Location;
import me.lyft.android.domain.location.LocationMapper;
import me.lyft.android.infrastructure.lyft.ILyftApi;
import me.lyft.android.persistence.payment.IChargeAccountsProvider;
import rx.Observable;
import rx.functions.Action1;

public class WearRideRequestService
  implements IWearRideRequestService
{
  private IChargeAccountsProvider chargeAccountsProvider;
  private ICheckoutSession checkoutSession;
  private ILyftApi lyftApi;
  private IUserProvider userProvider;
  
  public WearRideRequestService(IUserProvider paramIUserProvider, IChargeAccountsProvider paramIChargeAccountsProvider, ILyftApi paramILyftApi, ICheckoutSession paramICheckoutSession)
  {
    userProvider = paramIUserProvider;
    chargeAccountsProvider = paramIChargeAccountsProvider;
    lyftApi = paramILyftApi;
    checkoutSession = paramICheckoutSession;
  }
  
  private Observable<Unit> createRideRequest(Location paramLocation)
  {
    paramLocation = new RideRequestDTOBuilder().withRideType("lyft").withOrigin(LocationMapper.toPlaceDTO(paramLocation)).build();
    lyftApi.createRide(paramLocation).doOnNext(new Action1()
    {
      public void call(RideRequestDetailsDTO paramAnonymousRideRequestDetailsDTO)
      {
        checkoutSession.reset();
      }
    }).map(Unit.func1());
  }
  
  public Observable<Unit> requestRide(double paramDouble1, double paramDouble2)
  {
    Location localLocation = new Location(paramDouble1, paramDouble2, "defaultLocation");
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
    if (!chargeAccountsProvider.hasValidChargeAccount()) {
      return Observable.error(new NoValidChargeAccountException());
    }
    return createRideRequest(localLocation);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ride.WearRideRequestService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */