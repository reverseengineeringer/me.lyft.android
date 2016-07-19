package me.lyft.android.application.ride;

import me.lyft.android.application.IUserProvider;
import me.lyft.android.application.passenger.IPassengerRideProvider;
import me.lyft.android.domain.User;
import me.lyft.android.domain.driver.UiState;
import me.lyft.android.domain.passenger.ride.PassengerRide;
import me.lyft.android.domain.ride.RideStatus;
import me.lyft.android.persistence.ISimpleRepository;
import rx.Observable;

public class UserUiService
  implements IUserUiService
{
  private final IPassengerRideProvider passengerRideProvider;
  private final ISimpleRepository<UiState> uiStateRepository;
  private final IUserProvider userProvider;
  
  public UserUiService(ISimpleRepository<UiState> paramISimpleRepository, IUserProvider paramIUserProvider, IPassengerRideProvider paramIPassengerRideProvider)
  {
    uiStateRepository = paramISimpleRepository;
    userProvider = paramIUserProvider;
    passengerRideProvider = paramIPassengerRideProvider;
  }
  
  private UiState getUiStateDuringRide(UiState paramUiState)
  {
    if (paramUiState.isNull()) {
      return UiState.empty();
    }
    return new UiState(false);
  }
  
  private boolean hasAppliedRecently(User paramUser, UiState paramUiState)
  {
    return (paramUiState.isNull()) && (paramUser.hasAppliedRecently());
  }
  
  private boolean isApprovedDriverWithNoUiState(User paramUser, UiState paramUiState)
  {
    return (paramUiState.isNull()) && (paramUser.isApprovedDriver());
  }
  
  public UiState getUiState()
  {
    return (UiState)uiStateRepository.get();
  }
  
  public Observable<UiState> observeUiState()
  {
    return uiStateRepository.observe();
  }
  
  public void updateUiState(UiState paramUiState)
  {
    uiStateRepository.update(paramUiState);
  }
  
  public void validateUiState()
  {
    UiState localUiState = (UiState)uiStateRepository.get();
    User localUser = userProvider.getUser();
    if (passengerRideProvider.getPassengerRide().getStatus().isActive()) {
      localUiState = getUiStateDuringRide(localUiState);
    }
    for (;;)
    {
      uiStateRepository.update(localUiState);
      return;
      if ((localUser.isDispatchable()) || (hasAppliedRecently(localUser, localUiState)) || (isApprovedDriverWithNoUiState(localUser, localUiState))) {
        localUiState = new UiState(true);
      } else if (!localUser.submittedDriverApplication()) {
        localUiState = UiState.empty();
      }
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ride.UserUiService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */