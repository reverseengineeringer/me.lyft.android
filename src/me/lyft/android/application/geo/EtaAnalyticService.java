package me.lyft.android.application.geo;

import java.util.Iterator;
import java.util.List;
import me.lyft.android.analytics.core.ActionAnalytics;
import me.lyft.android.analytics.core.SpanningAnalytics;
import me.lyft.android.analytics.core.events.ActionEvent.Action;
import me.lyft.android.application.ride.IRideRequestSession;
import me.lyft.android.common.Objects;
import me.lyft.android.common.Strings;
import me.lyft.android.domain.eta.EtaEstimate;
import me.lyft.android.domain.geo.EtaRecord;
import me.lyft.android.domain.passenger.ridetypes.RequestRideType;

public class EtaAnalyticService
  implements IEtaAnalyticService
{
  private EtaRecord etaRecord;
  private IRideRequestSession rideRequestSession;
  
  public EtaAnalyticService(IRideRequestSession paramIRideRequestSession)
  {
    rideRequestSession = paramIRideRequestSession;
  }
  
  public void clear()
  {
    etaRecord = null;
  }
  
  public EtaRecord getRecord()
  {
    return (EtaRecord)Objects.firstNonNull(etaRecord, EtaRecord.empty());
  }
  
  public void record(Boolean paramBoolean, Long paramLong)
  {
    if (paramLong == null) {
      return;
    }
    ActionAnalytics localActionAnalytics = new ActionAnalytics(ActionEvent.Action.SET_ETA);
    if (paramBoolean.booleanValue()) {}
    for (String str = "internal";; str = "google")
    {
      localActionAnalytics.setParameter(str).setValue(paramLong.longValue()).trackInitiation().trackSuccess();
      etaRecord = new EtaRecord(paramBoolean, paramLong);
      return;
    }
  }
  
  public void record(List<EtaEstimate> paramList)
  {
    String str = rideRequestSession.getCurrentRideType().getPublicId();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      EtaEstimate localEtaEstimate = (EtaEstimate)paramList.next();
      if (Strings.equalsIgnoreCase(rideTypeId, str)) {
        record(Boolean.valueOf(isInternal), Long.valueOf(eta));
      }
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.geo.EtaAnalyticService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */