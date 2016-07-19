package me.lyft.android.application.eta;

import java.io.IOException;
import java.util.List;
import me.lyft.android.domain.eta.EtaEstimate;
import me.lyft.android.domain.location.Location;
import rx.Observable;

public abstract interface IPickupEtaService
{
  public abstract Long getEta(String paramString);
  
  public abstract Observable<List<EtaEstimate>> observeEta();
  
  public abstract void updateEtas(Location paramLocation)
    throws IOException;
}

/* Location:
 * Qualified Name:     me.lyft.android.application.eta.IPickupEtaService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */