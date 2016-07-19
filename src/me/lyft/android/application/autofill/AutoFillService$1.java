package me.lyft.android.application.autofill;

import me.lyft.android.common.Unit;
import me.lyft.android.domain.location.Location;
import rx.Observable;
import rx.functions.Func1;

class AutoFillService$1
  implements Func1<Location, Observable<Unit>>
{
  AutoFillService$1(AutoFillService paramAutoFillService) {}
  
  public Observable<Unit> call(Location paramLocation)
  {
    return AutoFillService.access$000(this$0, paramLocation);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.autofill.AutoFillService.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */