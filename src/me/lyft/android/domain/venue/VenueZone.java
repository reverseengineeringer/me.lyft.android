package me.lyft.android.domain.venue;

import java.util.Collections;
import java.util.List;
import me.lyft.android.common.INullable;

public class VenueZone
  implements INullable
{
  private static final VenueZone EMPTY = new VenueZone("", "", "", "", "", Collections.emptyList())
  {
    public boolean isNull()
    {
      return true;
    }
  };
  private final String confirmDetail;
  private final String confirmMessage;
  private final String pickupDetail;
  private final String pickupInfo;
  private final String venueName;
  private final List<VenuePickupLocation> venuePickupLocations;
  
  public VenueZone(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, List<VenuePickupLocation> paramList)
  {
    venueName = paramString1;
    pickupInfo = paramString2;
    pickupDetail = paramString3;
    confirmMessage = paramString4;
    confirmDetail = paramString5;
    venuePickupLocations = paramList;
  }
  
  public static VenueZone empty()
  {
    return EMPTY;
  }
  
  public String getConfirmDetail()
  {
    return confirmDetail;
  }
  
  public String getConfirmMessage()
  {
    return confirmMessage;
  }
  
  public String getPickupDetail()
  {
    return pickupDetail;
  }
  
  public String getPickupInfo()
  {
    return pickupInfo;
  }
  
  public String getVenueName()
  {
    return venueName;
  }
  
  public List<VenuePickupLocation> getVenuePickupLocations()
  {
    return venuePickupLocations;
  }
  
  public boolean isNull()
  {
    return false;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.venue.VenueZone
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */