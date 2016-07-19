package me.lyft.android.application.geo;

import java.util.List;
import me.lyft.android.domain.eta.EtaEstimate;
import me.lyft.android.domain.geo.EtaRecord;

public abstract interface IEtaAnalyticService
{
  @Deprecated
  public abstract void clear();
  
  @Deprecated
  public abstract EtaRecord getRecord();
  
  public abstract void record(Boolean paramBoolean, Long paramLong);
  
  public abstract void record(List<EtaEstimate> paramList);
}

/* Location:
 * Qualified Name:     me.lyft.android.application.geo.IEtaAnalyticService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */