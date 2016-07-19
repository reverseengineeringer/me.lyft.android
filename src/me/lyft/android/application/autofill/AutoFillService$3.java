package me.lyft.android.application.autofill;

import com.lyft.android.api.dto.UpdateUserLocationRequestDTO;
import me.lyft.android.application.IUserProvider;
import me.lyft.android.common.Unit;
import me.lyft.android.domain.User;
import me.lyft.android.domain.location.Location;
import me.lyft.android.infrastructure.lyft.ILyftApi;
import rx.Observable.OnSubscribe;
import rx.Subscriber;

class AutoFillService$3
  implements Observable.OnSubscribe<Unit>
{
  AutoFillService$3(AutoFillService paramAutoFillService, Location paramLocation) {}
  
  public void call(Subscriber<? super Unit> paramSubscriber)
  {
    try
    {
      UpdateUserLocationRequestDTO localUpdateUserLocationRequestDTO = AutoFillService.access$100(this$0, val$location);
      AutoFillService.access$300(this$0).updateLocationSync(AutoFillService.access$200(this$0).getUser().getId(), localUpdateUserLocationRequestDTO);
      paramSubscriber.onNext(Unit.create());
      paramSubscriber.onCompleted();
      return;
    }
    catch (Throwable localThrowable)
    {
      paramSubscriber.onError(localThrowable);
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.autofill.AutoFillService.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */