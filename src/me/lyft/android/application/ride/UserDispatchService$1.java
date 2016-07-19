package me.lyft.android.application.ride;

import me.lyft.android.application.IUserProvider;
import me.lyft.android.common.Unit;
import me.lyft.android.domain.User;
import me.lyft.android.domain.driver.Vehicle;
import me.lyft.android.domain.driverdocuments.Insurance;
import rx.Observable;
import rx.functions.Func1;

class UserDispatchService$1
  implements Func1<Vehicle, Observable<Unit>>
{
  UserDispatchService$1(UserDispatchService paramUserDispatchService) {}
  
  public Observable<Unit> call(Vehicle paramVehicle)
  {
    Insurance localInsurance = paramVehicle.getInsurance();
    boolean bool = UserDispatchService.access$000(this$0).getUser().isApprovedDriver();
    if (localInsurance.isNull()) {
      return UserDispatchService.access$100(this$0, bool);
    }
    if (!bool) {
      return UserDispatchService.access$200(this$0, paramVehicle);
    }
    if (localInsurance.isExpiredOrExpiringSoon()) {
      return Observable.error(new InsuranceExpiringException(paramVehicle));
    }
    return UserDispatchService.access$300(this$0);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ride.UserDispatchService.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */