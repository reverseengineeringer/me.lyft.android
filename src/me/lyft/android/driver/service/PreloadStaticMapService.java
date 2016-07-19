package me.lyft.android.driver.service;

import com.squareup.picasso.RequestCreator;
import java.util.Iterator;
import java.util.List;
import me.lyft.android.ILyftPreferences;
import me.lyft.android.application.ride.IDriverRideProvider;
import me.lyft.android.domain.driver.ride.DriverRide;
import me.lyft.android.domain.driver.ride.DriverStop;
import me.lyft.android.domain.location.Location;
import me.lyft.android.managers.ImageLoader;
import me.lyft.android.utils.GoogleMapsUrlBuilder;

public class PreloadStaticMapService
  implements IPreloadStaticMapService
{
  private static final int STATIC_MAP_SIZE_PX = 640;
  private final ImageLoader imageLoader;
  private final ILyftPreferences lyftPreferences;
  private final IDriverRideProvider rideProvider;
  
  public PreloadStaticMapService(ILyftPreferences paramILyftPreferences, IDriverRideProvider paramIDriverRideProvider, ImageLoader paramImageLoader)
  {
    lyftPreferences = paramILyftPreferences;
    rideProvider = paramIDriverRideProvider;
    imageLoader = paramImageLoader;
  }
  
  private void preloadStaticMap(Location paramLocation)
  {
    paramLocation = new GoogleMapsUrlBuilder().setCenter(paramLocation.toQueryString()).setSize(640, 640).setZoom(14).build();
    imageLoader.load(paramLocation).fetch();
  }
  
  public void preloadNavigationMaps()
  {
    if (!lyftPreferences.isAutoNavigationEnabled())
    {
      Iterator localIterator = rideProvider.getDriverRide().getStopsFromCurrentRoute().iterator();
      while (localIterator.hasNext()) {
        preloadStaticMap(((DriverStop)localIterator.next()).getLocation());
      }
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.driver.service.PreloadStaticMapService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */