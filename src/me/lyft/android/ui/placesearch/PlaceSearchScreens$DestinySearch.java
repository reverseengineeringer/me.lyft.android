package me.lyft.android.ui.placesearch;

import com.lyft.scoop.Layout;
import me.lyft.android.domain.location.Location;

@Layout(2130903388)
public class PlaceSearchScreens$DestinySearch
  extends PlaceSearchScreens
{
  private final Location driverDestination;
  private boolean fromDispatchableScreen;
  
  public PlaceSearchScreens$DestinySearch(Location paramLocation, boolean paramBoolean)
  {
    driverDestination = paramLocation;
    fromDispatchableScreen = paramBoolean;
  }
  
  public Location getDriverDestination()
  {
    return driverDestination;
  }
  
  public boolean isFromDispatchableScreen()
  {
    return fromDispatchableScreen;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.placesearch.PlaceSearchScreens.DestinySearch
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */