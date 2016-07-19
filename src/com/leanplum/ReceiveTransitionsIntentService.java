package com.leanplum;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;
import com.google.android.gms.location.LocationClient;

public class ReceiveTransitionsIntentService
  extends IntentService
{
  public ReceiveTransitionsIntentService()
  {
    super("ReceiveTransitionsIntentService");
  }
  
  protected void onHandleIntent(Intent paramIntent)
  {
    int i;
    if (LocationClient.hasError(paramIntent))
    {
      i = LocationClient.getErrorCode(paramIntent);
      Log.d("Leanplum", "Location Client Error with code: " + i);
    }
    LocationManagerImpl localLocationManagerImpl;
    do
    {
      do
      {
        return;
        i = LocationClient.getGeofenceTransition(paramIntent);
        paramIntent = LocationClient.getTriggeringGeofences(paramIntent);
      } while ((i != 1) && (i != 2));
      localLocationManagerImpl = (LocationManagerImpl)c.b();
    } while (localLocationManagerImpl == null);
    localLocationManagerImpl.updateStatusForGeofences(paramIntent, i);
  }
}

/* Location:
 * Qualified Name:     com.leanplum.ReceiveTransitionsIntentService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */