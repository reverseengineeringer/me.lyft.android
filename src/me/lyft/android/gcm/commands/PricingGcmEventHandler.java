package me.lyft.android.gcm.commands;

import android.content.Context;
import com.lyft.android.api.dto.PricingDTO;
import java.util.Map;
import me.lyft.android.application.payment.IPricingService;
import me.lyft.android.domain.payment.PricingMapper;
import me.lyft.android.gcm.GcmEventHandler;
import me.lyft.android.gcm.IGcmSerializer;
import me.lyft.android.logging.L;

public class PricingGcmEventHandler
  implements GcmEventHandler
{
  static final String PRICING_PARAM = "pricing";
  private final IGcmSerializer jsonGcmSerializer;
  private final IPricingService pricingService;
  
  public PricingGcmEventHandler(IGcmSerializer paramIGcmSerializer, IPricingService paramIPricingService)
  {
    jsonGcmSerializer = paramIGcmSerializer;
    pricingService = paramIPricingService;
  }
  
  public void execute(Context paramContext, Map<String, String> paramMap)
  {
    try
    {
      paramContext = PricingMapper.fromPricingDto((PricingDTO)jsonGcmSerializer.deserialize(paramMap, "pricing", PricingDTO.class, null));
      pricingService.updatePricing(paramContext);
      return;
    }
    catch (Exception paramContext)
    {
      L.e(paramContext, "pricingUpdateEvent", new Object[0]);
    }
  }
  
  public String getEventName()
  {
    return "pricingUpdate";
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.gcm.commands.PricingGcmEventHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */