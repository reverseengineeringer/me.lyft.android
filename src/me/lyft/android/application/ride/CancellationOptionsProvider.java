package me.lyft.android.application.ride;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import me.lyft.android.application.constants.IConstantsProvider;
import me.lyft.android.common.Unit;
import me.lyft.android.domain.ride.CancellationOption;
import me.lyft.android.rx.ReactiveProperty;
import rx.Observable;

public class CancellationOptionsProvider
  implements ICancellationOptionsProvider
{
  public static final String DEFAULT_CANCEL_OPTION_STRING = "Cancel the ride";
  private Map<String, CancellationOption> cancellationIdDisplayMap = new HashMap();
  private IConstantsProvider constantsProvider;
  private ReactiveProperty<List<CancellationOption>> currentCancellationOptionsSubject = ReactiveProperty.create();
  
  public CancellationOptionsProvider(IConstantsProvider paramIConstantsProvider)
  {
    constantsProvider = paramIConstantsProvider;
  }
  
  private void updateOptions(List<String> paramList)
  {
    Object localObject1 = constantsProvider.getCancellationOptions().iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (CancellationOption)((Iterator)localObject1).next();
      cancellationIdDisplayMap.put(((CancellationOption)localObject2).getId(), localObject2);
    }
    localObject1 = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localObject2 = (String)paramList.next();
      if (cancellationIdDisplayMap.get(localObject2) != null) {
        ((List)localObject1).add(cancellationIdDisplayMap.get(localObject2));
      }
    }
    if (((List)localObject1).isEmpty()) {
      ((List)localObject1).add(new CancellationOption("canceled", "Cancel the ride", "canceled"));
    }
    currentCancellationOptionsSubject.onNext(localObject1);
  }
  
  public List<CancellationOption> getCancellationOptions()
  {
    return (List)currentCancellationOptionsSubject.get();
  }
  
  public Observable<Unit> observeCancellationOptionChange()
  {
    return currentCancellationOptionsSubject.asObservable().map(Unit.func1());
  }
  
  public void updateCancellationOptions(List<String> paramList)
  {
    updateOptions(paramList);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ride.CancellationOptionsProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */