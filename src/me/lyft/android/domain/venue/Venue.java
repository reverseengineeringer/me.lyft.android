package me.lyft.android.domain.venue;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import me.lyft.android.common.INullable;
import me.lyft.android.common.Preconditions;
import me.lyft.android.common.Strings;
import me.lyft.android.domain.location.LatLng;
import me.lyft.android.domain.location.PolyUtils;
import me.lyft.android.domain.location.SphericalUtils;

public class Venue
  implements INullable
{
  private final String introductionMessage;
  private final int locationCount;
  private final List<List<LatLng>> polylines;
  private final String venueId;
  private final String venueName;
  private final VenueType venueType;
  private final List<VenueZone> venueZones;
  
  Venue(String paramString1, VenueType paramVenueType, String paramString2, String paramString3, List<VenueZone> paramList, List<List<LatLng>> paramList1, int paramInt)
  {
    if (!Strings.isNullOrEmpty(paramString1)) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool);
      venueId = paramString1;
      venueType = paramVenueType;
      venueName = paramString2;
      introductionMessage = paramString3;
      venueZones = paramList;
      polylines = paramList1;
      locationCount = paramInt;
      return;
    }
  }
  
  public static Venue empty()
  {
    return NullVenue.getInstance();
  }
  
  public boolean containsLocation(LatLng paramLatLng)
  {
    if (!polylines.isEmpty())
    {
      Iterator localIterator = polylines.iterator();
      while (localIterator.hasNext()) {
        if (PolyUtils.containsLocation(paramLatLng, (List)localIterator.next(), true)) {
          return true;
        }
      }
    }
    return false;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof Venue))
    {
      paramObject = (Venue)paramObject;
      return getVenueId().equals(((Venue)paramObject).getVenueId());
    }
    return false;
  }
  
  public List<List<LatLng>> getBoundaryPolylines()
  {
    return polylines;
  }
  
  public PickupLocation getClosestPickupLocation(LatLng paramLatLng)
  {
    int k = 0;
    int m = 0;
    double d1 = Double.MAX_VALUE;
    int i = 0;
    while (i < venueZones.size())
    {
      List localList = ((VenueZone)venueZones.get(i)).getVenuePickupLocations();
      int j = 0;
      while (j < localList.size())
      {
        double d3 = SphericalUtils.computeDistanceBetween(paramLatLng, (VenuePickupLocation)localList.get(j));
        double d2 = d1;
        if (Double.compare(d3, d1) < 0)
        {
          k = i;
          m = j;
          d2 = d3;
        }
        j += 1;
        d1 = d2;
      }
      i += 1;
    }
    return new PickupLocation(k, m);
  }
  
  public VenuePickupLocation getClosestVenuePickupLocation(LatLng paramLatLng)
  {
    Object localObject2 = null;
    double d2 = Double.MAX_VALUE;
    Iterator localIterator1 = venueZones.iterator();
    if (localIterator1.hasNext())
    {
      Iterator localIterator2 = ((VenueZone)localIterator1.next()).getVenuePickupLocations().iterator();
      double d1 = d2;
      Object localObject1 = localObject2;
      for (;;)
      {
        localObject2 = localObject1;
        d2 = d1;
        if (!localIterator2.hasNext()) {
          break;
        }
        localObject2 = (VenuePickupLocation)localIterator2.next();
        d2 = SphericalUtils.computeDistanceBetween(paramLatLng, (LatLng)localObject2);
        if (Double.compare(d2, d1) < 0)
        {
          d1 = d2;
          localObject1 = localObject2;
        }
      }
    }
    return (VenuePickupLocation)localObject2;
  }
  
  public String getIntroductionMessage()
  {
    return introductionMessage;
  }
  
  public int getLocationCount()
  {
    return locationCount;
  }
  
  public String getVenueId()
  {
    return venueId;
  }
  
  public String getVenueName()
  {
    return venueName;
  }
  
  public List<VenueZone> getVenueZones()
  {
    return venueZones;
  }
  
  public int hashCode()
  {
    return venueId.hashCode();
  }
  
  public boolean isNull()
  {
    return false;
  }
  
  public boolean isProhibited()
  {
    return VenueType.PROHIBITED == venueType;
  }
  
  private static class NullVenue
    extends Venue
  {
    private static Venue INSTANCE = new NullVenue();
    
    private NullVenue()
    {
      super(null, "", "", Collections.emptyList(), Collections.emptyList(), 0);
    }
    
    static Venue getInstance()
    {
      return INSTANCE;
    }
    
    public boolean isNull()
    {
      return true;
    }
  }
  
  public static class PickupLocation
  {
    public final int pickupPosition;
    public final int zonePosition;
    
    public PickupLocation(int paramInt1, int paramInt2)
    {
      zonePosition = paramInt1;
      pickupPosition = paramInt2;
    }
  }
  
  static enum VenueType
  {
    PICKUP,  PROHIBITED;
    
    private VenueType() {}
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.venue.Venue
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */