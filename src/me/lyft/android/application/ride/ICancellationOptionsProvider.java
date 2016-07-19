package me.lyft.android.application.ride;

import java.util.List;
import me.lyft.android.common.Unit;
import me.lyft.android.domain.ride.CancellationOption;
import rx.Observable;

public abstract interface ICancellationOptionsProvider
{
  public abstract List<CancellationOption> getCancellationOptions();
  
  public abstract Observable<Unit> observeCancellationOptionChange();
  
  public abstract void updateCancellationOptions(List<String> paramList);
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ride.ICancellationOptionsProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */