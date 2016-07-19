package me.lyft.android.domain.payment;

import com.lyft.android.api.dto.PricingDTO;
import me.lyft.android.common.Objects;
import me.lyft.android.domain.passenger.ridetypes.Pricing;

public class PricingMapper
{
  public static Pricing fromPricingDto(PricingDTO paramPricingDTO)
  {
    if (paramPricingDTO == null) {
      return Pricing.empty();
    }
    return new Pricing((Integer)Objects.firstNonNull(dynamicPricing, Integer.valueOf(0)), (String)Objects.firstNonNull(minimum, ""), (String)Objects.firstNonNull(pickup, ""), (String)Objects.firstNonNull(perMile, ""), (String)Objects.firstNonNull(perMinute, ""));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.payment.PricingMapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */