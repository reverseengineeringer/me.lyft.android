package me.lyft.android.application.cost;

import com.lyft.android.api.dto.AdditionalCostEstimateDTO;
import com.lyft.android.api.dto.CostEstimateDTO;
import com.lyft.android.api.dto.CostEstimateResponseDTO;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import me.lyft.android.common.Strings;
import me.lyft.android.domain.cost.CostEstimate;
import me.lyft.android.domain.payment.MoneyMapper;

public class CostMapper
{
  private static Integer convertMultiplierToPercent(Double paramDouble)
  {
    if (paramDouble == null) {
      return null;
    }
    return Integer.valueOf(Double.valueOf((paramDouble.doubleValue() - 1.0D) * 100.0D).intValue());
  }
  
  private static CostEstimate createCostEstimateFromAdditionalCostEstimateDTO(CostEstimateDTO paramCostEstimateDTO, AdditionalCostEstimateDTO paramAdditionalCostEstimateDTO)
  {
    return CostEstimate.createWithCostToken(convertMultiplierToPercent(primetime_multiplier).intValue(), MoneyMapper.fromCentsAndCurrency(estimated_cost_cents_min, currency), MoneyMapper.fromCentsAndCurrency(estimated_cost_cents_max, currency), seats.intValue(), cost_token, MoneyMapper.fromCentsAndCurrency(comparison_cents, currency));
  }
  
  private static CostEstimate createCostEstimateFromCostEstimateDTO(CostEstimateDTO paramCostEstimateDTO)
  {
    if (!Strings.isNullOrEmpty(error_message)) {
      return CostEstimate.createFromError(error_message);
    }
    return CostEstimate.createWithCostToken(convertMultiplierToPercent(primetime_multiplier).intValue(), MoneyMapper.fromCentsAndCurrency(estimated_cost_cents_min, currency), MoneyMapper.fromCentsAndCurrency(estimated_cost_cents_max, currency), 1, cost_token, MoneyMapper.fromCentsAndCurrency(comparison_cents, currency));
  }
  
  public static Map<String, List<CostEstimate>> fromEstimateResponseDTO(CostEstimateResponseDTO paramCostEstimateResponseDTO)
  {
    int i = 0;
    Object localObject1 = cost_estimates;
    if (localObject1 != null) {
      i = ((List)localObject1).size();
    }
    paramCostEstimateResponseDTO = new HashMap(i);
    if (i > 0)
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        CostEstimateDTO localCostEstimateDTO = (CostEstimateDTO)((Iterator)localObject1).next();
        Object localObject2 = createCostEstimateFromCostEstimateDTO(localCostEstimateDTO);
        ArrayList localArrayList = new ArrayList();
        List localList = additional_estimates;
        if ((localList != null) && (((CostEstimate)localObject2).isRouteValid())) {
          localObject2 = localList.iterator();
        }
        while (((Iterator)localObject2).hasNext())
        {
          localArrayList.add(createCostEstimateFromAdditionalCostEstimateDTO(localCostEstimateDTO, (AdditionalCostEstimateDTO)((Iterator)localObject2).next()));
          continue;
          localArrayList.add(localObject2);
        }
        paramCostEstimateResponseDTO.put(ride_type, localArrayList);
      }
    }
    return paramCostEstimateResponseDTO;
  }
  
  public static CostEstimate fromTokenAndMultiplier(String paramString, Double paramDouble)
  {
    return CostEstimate.createFromPrimeTimeAndCostToken(paramString, convertMultiplierToPercent(paramDouble).intValue());
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.cost.CostMapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */