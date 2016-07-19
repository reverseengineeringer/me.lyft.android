package me.lyft.android.domain.venue;

import com.lyft.android.api.dto.VenueDTO;
import com.lyft.android.api.dto.VenuePickupLocationDTO;
import com.lyft.android.api.dto.VenueZoneDTO;
import com.lyft.android.api.dto.VenuesDTO;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import me.lyft.android.common.Enums;
import me.lyft.android.common.Strings;
import me.lyft.android.domain.location.LatLng;
import me.lyft.android.domain.location.SphericalUtils;

public class VenueMapper
{
  public static List<List<LatLng>> fromPolygonStrings(List<String> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      ArrayList localArrayList = new ArrayList(paramList.size());
      Iterator localIterator = paramList.iterator();
      for (;;)
      {
        paramList = localArrayList;
        if (!localIterator.hasNext()) {
          break;
        }
        localArrayList.add(SphericalUtils.decodeOverviewPolyLineToLatLngs((String)localIterator.next()));
      }
    }
    paramList = Collections.emptyList();
    return paramList;
  }
  
  public static Venue.VenueType fromType(String paramString)
  {
    return (Venue.VenueType)Enums.valueOf(Venue.VenueType.class, paramString, null);
  }
  
  public static Venue fromVenueDTO(VenueDTO paramVenueDTO)
  {
    if ((Strings.isNullOrEmpty(venueId)) || (zones == null) || (zones.isEmpty())) {
      return Venue.empty();
    }
    Object localObject1 = zones;
    ArrayList localArrayList = new ArrayList(((List)localObject1).size());
    int i = 0;
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = fromVenueZoneDTO((VenueZoneDTO)((Iterator)localObject1).next());
      i += ((VenueZone)localObject2).getVenuePickupLocations().size();
      localArrayList.add(localObject2);
    }
    localObject1 = fromType(type);
    Object localObject2 = fromPolygonStrings(polygons);
    return new Venue(venueId, (Venue.VenueType)localObject1, name, introduction, localArrayList, (List)localObject2, i);
  }
  
  public static List<VenuePickupLocation> fromVenuePickupLocationDTOs(List<VenuePickupLocationDTO> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      ArrayList localArrayList = new ArrayList(paramList.size());
      Iterator localIterator = paramList.iterator();
      for (;;)
      {
        paramList = localArrayList;
        if (!localIterator.hasNext()) {
          break;
        }
        paramList = (VenuePickupLocationDTO)localIterator.next();
        localArrayList.add(new VenuePickupLocation(lat.doubleValue(), lng.doubleValue(), name, id, copy));
      }
    }
    paramList = Collections.emptyList();
    return paramList;
  }
  
  public static VenueZone fromVenueZoneDTO(VenueZoneDTO paramVenueZoneDTO)
  {
    List localList = fromVenuePickupLocationDTOs(pickupLocations);
    return new VenueZone(name, pickupInfo, pickupDetail, confirmMessage, confirmDetail, localList);
  }
  
  public static NearbyVenues fromVenuesDTO(VenuesDTO paramVenuesDTO)
  {
    if ((radius_miles == null) || (lat == null) || (lng == null)) {
      return NearbyVenues.empty();
    }
    double d = SphericalUtils.milesToKilometers(radius_miles.doubleValue());
    if (venues == null) {}
    ArrayList localArrayList;
    for (int i = 0;; i = venues.size())
    {
      localArrayList = new ArrayList(i);
      int j = 0;
      while (j < i)
      {
        localArrayList.add(fromVenueDTO((VenueDTO)venues.get(j)));
        j += 1;
      }
    }
    return new NearbyVenues(lat.doubleValue(), lng.doubleValue(), d, localArrayList);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.venue.VenueMapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */