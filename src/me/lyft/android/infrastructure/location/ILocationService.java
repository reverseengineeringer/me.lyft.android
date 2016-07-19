package me.lyft.android.infrastructure.location;

import java.util.concurrent.TimeUnit;
import me.lyft.android.domain.location.Location;
import rx.Observable;

public abstract interface ILocationService
{
  public static final long BACKGROUND_FASTEST_INTERVAL_MS = TimeUnit.MINUTES.toMillis(10L);
  public static final float BACKGROUND_SMALLEST_DISPLACEMENT_METERS = 500.0F;
  public static final long BACKGROUND_UPDATE_INTERVAL_MS;
  public static final long FASTEST_INTERVAL_MS;
  public static final float SMALLEST_DISPLACEMENT_METERS = 0.0F;
  public static final long UPDATE_INTERVAL_MS = TimeUnit.SECONDS.toMillis(1L);
  
  static
  {
    FASTEST_INTERVAL_MS = TimeUnit.SECONDS.toMillis(1L);
    BACKGROUND_UPDATE_INTERVAL_MS = TimeUnit.MINUTES.toMillis(10L);
  }
  
  public abstract Location getLastCachedLocation();
  
  public abstract Observable<Location> getLastLocation();
  
  public abstract Observable<Location> observeBackgroundLocationUpdates();
  
  public abstract Observable<Location> observeLocationUpdates();
  
  public abstract Observable<Location> observePassiveLocationUpdates();
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.location.ILocationService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */