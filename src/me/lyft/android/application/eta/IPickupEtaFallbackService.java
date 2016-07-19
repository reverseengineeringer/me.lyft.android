package me.lyft.android.application.eta;

import java.util.List;
import me.lyft.android.domain.eta.EtaEstimate;

public abstract interface IPickupEtaFallbackService
{
  public abstract List<EtaEstimate> useGoogleFallback();
}

/* Location:
 * Qualified Name:     me.lyft.android.application.eta.IPickupEtaFallbackService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */