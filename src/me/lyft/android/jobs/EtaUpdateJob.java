package me.lyft.android.jobs;

import com.lyft.android.api.dto.RideDTO;
import com.lyft.android.api.dto.UniversalDTO;
import javax.inject.Inject;
import me.lyft.android.application.geo.IEtaRepository;

public class EtaUpdateJob
  implements Job
{
  UniversalDTO currentAppState;
  @Inject
  IEtaRepository etaRepository;
  
  public EtaUpdateJob(UniversalDTO paramUniversalDTO)
  {
    currentAppState = paramUniversalDTO;
  }
  
  public void execute()
    throws Throwable
  {
    if (currentAppState == null) {}
    RideDTO localRideDTO;
    do
    {
      return;
      localRideDTO = currentAppState.ride;
    } while (localRideDTO == null);
    etaRepository.updateEta(eta);
    etaRepository.updateEtd(etd);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.jobs.EtaUpdateJob
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */