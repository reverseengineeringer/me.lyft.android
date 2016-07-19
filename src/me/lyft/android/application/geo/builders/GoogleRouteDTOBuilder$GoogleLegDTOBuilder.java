package me.lyft.android.application.geo.builders;

import java.util.ArrayList;
import java.util.List;
import me.lyft.android.infrastructure.googlegeo.model.GoogleRouteDTO.Leg;
import me.lyft.android.infrastructure.googlegeo.model.GoogleRouteDTO.Leg.Step;

public class GoogleRouteDTOBuilder$GoogleLegDTOBuilder
{
  private List<GoogleRouteDTO.Leg.Step> steps = new ArrayList();
  
  private GoogleRouteDTO.Leg build()
  {
    return new GoogleRouteDTO.Leg(steps);
  }
  
  public GoogleLegDTOBuilder withStep(GoogleRouteDTOBuilder.GoogleStepDTOBuilder paramGoogleStepDTOBuilder)
  {
    steps.add(paramGoogleStepDTOBuilder.build());
    return this;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.geo.builders.GoogleRouteDTOBuilder.GoogleLegDTOBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */