package bo.app;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import com.appboy.services.AppboyLocationService;
import com.appboy.support.AppboyLogger;

public final class em
  implements LocationListener
{
  public em(AppboyLocationService paramAppboyLocationService) {}
  
  public final void onLocationChanged(Location paramLocation)
  {
    if (paramLocation != null)
    {
      AppboyLocationService.a();
      Intent localIntent = new Intent(a.getApplicationContext().getPackageName() + ".SINGLE_APPBOY_LOCATION_UPDATE");
      localIntent.putExtra("location", paramLocation);
      localIntent.putExtra("origin", "Appboy location service");
      paramLocation = PendingIntent.getBroadcast(a.getApplicationContext(), 0, localIntent, 134217728);
    }
    try
    {
      AppboyLocationService.a(a).requestSingleUpdate("passive", paramLocation);
      return;
    }
    catch (SecurityException paramLocation)
    {
      AppboyLogger.w(AppboyLocationService.a(), "Could not request single location update. Security exception from insufficient permissions", paramLocation);
    }
  }
  
  public final void onProviderDisabled(String paramString)
  {
    if ((paramString != null) && (paramString.equals("passive"))) {
      AppboyLocationService.b(a);
    }
  }
  
  public final void onProviderEnabled(String paramString) {}
  
  public final void onStatusChanged(String paramString, int paramInt, Bundle paramBundle) {}
}

/* Location:
 * Qualified Name:     bo.app.em
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */