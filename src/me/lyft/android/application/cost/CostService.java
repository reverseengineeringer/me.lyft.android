package me.lyft.android.application.cost;

import com.jakewharton.rxrelay.BehaviorRelay;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import me.lyft.android.common.Iterables;
import me.lyft.android.common.Objects;
import me.lyft.android.common.Strings;
import me.lyft.android.common.Unit;
import me.lyft.android.domain.cost.CostEstimate;
import me.lyft.android.domain.location.Location;
import me.lyft.android.domain.time.TimeRange;
import me.lyft.android.infrastructure.lyft.ILyftApi;
import rx.Observable;

public class CostService
  implements ICostService
{
  private ILyftApi lyftApi;
  final BehaviorRelay<Map<String, List<CostEstimate>>> subject = BehaviorRelay.create(Collections.emptyMap());
  
  public CostService(ILyftApi paramILyftApi)
  {
    lyftApi = paramILyftApi;
  }
  
  private CostEstimate getFirstCostEstimateForRideType(String paramString)
  {
    return (CostEstimate)Iterables.firstOrDefault(getCostEstimates(paramString), CostEstimate.empty());
  }
  
  public CostEstimate getCostEstimate(String paramString)
  {
    return getFirstCostEstimateForRideType(paramString);
  }
  
  public List<CostEstimate> getCostEstimates(String paramString)
  {
    return (List)Objects.firstNonNull((List)((Map)subject.getValue()).get(paramString), Collections.emptyList());
  }
  
  public int getPrimeTime(String paramString)
  {
    return ((Integer)Objects.firstNonNull(Integer.valueOf(getFirstCostEstimateForRideType(paramString).getPrimeTime()), Integer.valueOf(0))).intValue();
  }
  
  public boolean hasPrimeTime(String paramString)
  {
    return getPrimeTime(paramString) > 0;
  }
  
  public Observable<Unit> observeCostChange()
  {
    return subject.asObservable().map(Unit.func1());
  }
  
  public void resetCost()
  {
    subject.call(Collections.emptyMap());
  }
  
  public void updateCost(Location paramLocation1, Location paramLocation2, TimeRange paramTimeRange)
    throws IOException
  {
    Object localObject5 = null;
    Object localObject2 = null;
    Object localObject3 = null;
    Object localObject6 = null;
    Object localObject1 = localObject5;
    Object localObject4 = localObject6;
    if (!paramLocation2.isNull())
    {
      Double localDouble1 = Double.valueOf(paramLocation2.getLat());
      Double localDouble2 = Double.valueOf(paramLocation2.getLng());
      localObject1 = localObject5;
      localObject2 = localDouble1;
      localObject3 = localDouble2;
      localObject4 = localObject6;
      if (!Strings.isNullOrEmpty(paramLocation2.getRoutableAddress()))
      {
        localObject1 = localObject5;
        localObject2 = localDouble1;
        localObject3 = localDouble2;
        localObject4 = localObject6;
        if (!Strings.isNullOrEmpty(paramLocation1.getRoutableAddress()))
        {
          localObject1 = paramLocation1.getRoutableAddress();
          localObject4 = paramLocation2.getRoutableAddress();
          localObject3 = localDouble2;
          localObject2 = localDouble1;
        }
      }
    }
    paramLocation1 = CostMapper.fromEstimateResponseDTO(lyftApi.getCosts(paramLocation1.getLat(), paramLocation1.getLng(), (String)localObject1, (Double)localObject2, (Double)localObject3, (String)localObject4, paramTimeRange));
    subject.call(paramLocation1);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.cost.CostService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */