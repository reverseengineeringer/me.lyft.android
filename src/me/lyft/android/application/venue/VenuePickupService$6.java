package me.lyft.android.application.venue;

import com.lyft.android.api.dto.VenuesDTO;
import java.util.List;
import me.lyft.android.domain.venue.NearbyVenues;
import me.lyft.android.domain.venue.Venue;
import me.lyft.android.domain.venue.VenueMapper;
import rx.functions.Func1;

class VenuePickupService$6
  implements Func1<VenuesDTO, List<Venue>>
{
  VenuePickupService$6(VenuePickupService paramVenuePickupService) {}
  
  public List<Venue> call(VenuesDTO paramVenuesDTO)
  {
    paramVenuesDTO = VenueMapper.fromVenuesDTO(paramVenuesDTO);
    VenuePickupService.access$202(this$0, paramVenuesDTO);
    return paramVenuesDTO.getVenues();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.venue.VenuePickupService.6
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */