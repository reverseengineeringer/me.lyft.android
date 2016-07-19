package me.lyft.android.domain.eta;

import com.lyft.android.api.dto.EtaEstimateDTO;
import com.lyft.android.api.dto.EtaEstimateResponseDTO;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EtaEstimateMapper
{
  public static List<EtaEstimate> fromEtaResponse(EtaEstimateResponseDTO paramEtaEstimateResponseDTO)
  {
    int i = 0;
    if (eta_estimates != null) {
      i = eta_estimates.size();
    }
    ArrayList localArrayList = new ArrayList();
    if (i > 0)
    {
      paramEtaEstimateResponseDTO = eta_estimates.iterator();
      while (paramEtaEstimateResponseDTO.hasNext())
      {
        EtaEstimateDTO localEtaEstimateDTO = (EtaEstimateDTO)paramEtaEstimateResponseDTO.next();
        if (eta_seconds != null) {
          localArrayList.add(EtaEstimate.create(eta_seconds.intValue(), ride_type, true));
        }
      }
    }
    return localArrayList;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.eta.EtaEstimateMapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */