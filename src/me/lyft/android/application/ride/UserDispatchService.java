package me.lyft.android.application.ride;

import com.lyft.android.api.dto.UniversalDTO;
import com.lyft.android.api.dto.UpdateUserRequestBuilder;
import com.lyft.android.api.dto.UpdateUserRequestDTO;
import me.lyft.android.application.IUserProvider;
import me.lyft.android.application.driver.IVehicleService;
import me.lyft.android.common.Unit;
import me.lyft.android.domain.User;
import me.lyft.android.domain.driver.Vehicle;
import me.lyft.android.domain.driverdocuments.Insurance;
import me.lyft.android.infrastructure.locationsettings.ILocationSettingsService;
import me.lyft.android.infrastructure.lyft.ILyftApi;
import rx.Observable;
import rx.functions.Func1;

public class UserDispatchService
  implements IUserDispatchService
{
  private final ILocationSettingsService locationSettingsService;
  private final ILyftApi lyftApi;
  private final IUserProvider userProvider;
  private final IVehicleService vehicleService;
  
  public UserDispatchService(IUserProvider paramIUserProvider, ILyftApi paramILyftApi, IVehicleService paramIVehicleService, ILocationSettingsService paramILocationSettingsService)
  {
    lyftApi = paramILyftApi;
    userProvider = paramIUserProvider;
    vehicleService = paramIVehicleService;
    locationSettingsService = paramILocationSettingsService;
  }
  
  private Observable<Unit> checkDriverStatusAndEnterDispatch()
  {
    vehicleService.getInUseOrFirstVehicle().onErrorReturn(new Func1()
    {
      public Vehicle call(Throwable paramAnonymousThrowable)
      {
        return Vehicle.empty();
      }
    }).flatMap(new Func1()
    {
      public Observable<Unit> call(Vehicle paramAnonymousVehicle)
      {
        Insurance localInsurance = paramAnonymousVehicle.getInsurance();
        boolean bool = userProvider.getUser().isApprovedDriver();
        if (localInsurance.isNull()) {
          return UserDispatchService.this.handleMissingInsuranceAndSwitchMode(bool);
        }
        if (!bool) {
          return UserDispatchService.this.handleUnapprovedDriver(paramAnonymousVehicle);
        }
        if (localInsurance.isExpiredOrExpiringSoon()) {
          return Observable.error(new InsuranceExpiringException(paramAnonymousVehicle));
        }
        return UserDispatchService.this.checkLocationSettingsAndEnterDriverMode();
      }
    });
  }
  
  private Observable<Unit> checkLocationSettingsAndEnterDriverMode()
  {
    locationSettingsService.observeLocationSettingsEnabled().flatMap(new Func1()
    {
      public Observable<Unit> call(Unit paramAnonymousUnit)
      {
        return UserDispatchService.this.updateUser(true).map(Unit.func1());
      }
    });
  }
  
  private Observable<Unit> handleMissingInsuranceAndSwitchMode(boolean paramBoolean)
  {
    if (paramBoolean) {
      return checkLocationSettingsAndEnterDriverMode();
    }
    return Observable.error(new DriverNotApprovedException());
  }
  
  private Observable<Unit> handleUnapprovedDriver(Vehicle paramVehicle)
  {
    Insurance localInsurance = paramVehicle.getInsurance();
    if ((localInsurance.isPending()) || (localInsurance.isRejected())) {
      return Observable.error(new InsuranceNotApprovedException(paramVehicle));
    }
    return Observable.error(new DriverNotApprovedException());
  }
  
  private Observable<UniversalDTO> updateUser(boolean paramBoolean)
  {
    UpdateUserRequestBuilder localUpdateUserRequestBuilder = new UpdateUserRequestBuilder();
    if (paramBoolean) {}
    for (Object localObject = "driver";; localObject = "passenger")
    {
      localObject = localUpdateUserRequestBuilder.withMode((String)localObject).build();
      return lyftApi.updateUser(userProvider.getUser().getId(), (UpdateUserRequestDTO)localObject);
    }
  }
  
  public Observable<Unit> switchToDispatchable(boolean paramBoolean)
  {
    return updateUser(paramBoolean).map(Unit.func1());
  }
  
  public Observable<Unit> validateDriverStatusAndSwitchToDispatch()
  {
    User localUser = userProvider.getUser();
    if ((localUser.isApprovedDriver()) && (localUser.hasTermsUrl())) {
      return Observable.error(new DriverTermsNotAcceptedException());
    }
    if (localUser.submittedDriverApplication()) {
      return checkDriverStatusAndEnterDispatch();
    }
    return Observable.error(new DriverNotApprovedException());
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ride.UserDispatchService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */