package me.lyft.android.application.cost;

import java.io.IOException;
import java.util.List;
import me.lyft.android.common.Unit;
import me.lyft.android.domain.cost.CostEstimate;
import me.lyft.android.domain.location.Location;
import me.lyft.android.domain.time.TimeRange;
import rx.Observable;

public abstract interface ICostService
{
  public abstract CostEstimate getCostEstimate(String paramString);
  
  public abstract List<CostEstimate> getCostEstimates(String paramString);
  
  public abstract int getPrimeTime(String paramString);
  
  public abstract boolean hasPrimeTime(String paramString);
  
  public abstract Observable<Unit> observeCostChange();
  
  public abstract void resetCost();
  
  public abstract void updateCost(Location paramLocation1, Location paramLocation2, TimeRange paramTimeRange)
    throws IOException;
}

/* Location:
 * Qualified Name:     me.lyft.android.application.cost.ICostService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */