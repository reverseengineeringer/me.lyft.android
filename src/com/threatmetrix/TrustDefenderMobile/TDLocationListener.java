package com.threatmetrix.TrustDefenderMobile;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.util.Log;

class TDLocationListener
  implements LocationListener
{
  private static final String TAG = StringUtils.getLogTag(TDLocationListener.class);
  private Location m_currentBestLocation = null;
  
  private boolean isSameProvider(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      return paramString2 == null;
    }
    return paramString1.equals(paramString2);
  }
  
  public Location getLastLocation()
  {
    if (m_currentBestLocation != null) {
      return new Location(m_currentBestLocation);
    }
    return null;
  }
  
  boolean isBetterLocation(Location paramLocation1, Location paramLocation2)
  {
    if (paramLocation2 == null) {
      return true;
    }
    long l = paramLocation1.getTime() - paramLocation2.getTime();
    int j;
    int k;
    if (l > 120000L)
    {
      j = 1;
      if (l >= -120000L) {
        break label63;
      }
      k = 1;
      label41:
      if (l <= 0L) {
        break label69;
      }
    }
    label63:
    label69:
    for (int i = 1;; i = 0)
    {
      if (j == 0) {
        break label74;
      }
      return true;
      j = 0;
      break;
      k = 0;
      break label41;
    }
    label74:
    if (k != 0) {
      return false;
    }
    int m = (int)(paramLocation1.getAccuracy() - paramLocation2.getAccuracy());
    if (m > 0)
    {
      j = 1;
      if (m >= 0) {
        break label147;
      }
      k = 1;
      label109:
      if (m <= 200) {
        break label153;
      }
    }
    boolean bool;
    label147:
    label153:
    for (m = 1;; m = 0)
    {
      bool = isSameProvider(paramLocation1.getProvider(), paramLocation2.getProvider());
      if (k == 0) {
        break label159;
      }
      return true;
      j = 0;
      break;
      k = 0;
      break label109;
    }
    label159:
    if ((i != 0) && (j == 0)) {
      return true;
    }
    return (i != 0) && (m == 0) && (bool);
  }
  
  public void onLocationChanged(Location paramLocation)
  {
    Log.d(TAG, "onLocationChanged() : " + paramLocation.getProvider() + ":" + paramLocation.getLatitude() + ":" + paramLocation.getLongitude() + ":" + paramLocation.getAccuracy());
    if (isBetterLocation(paramLocation, m_currentBestLocation)) {
      m_currentBestLocation = paramLocation;
    }
  }
  
  public void onProviderDisabled(String paramString)
  {
    Log.d(TAG, "onProviderDisabled: " + paramString);
  }
  
  public void onProviderEnabled(String paramString)
  {
    Log.d(TAG, "onProviderEnabled: " + paramString);
  }
  
  public void onStatusChanged(String paramString, int paramInt, Bundle paramBundle)
  {
    paramBundle = TAG;
    StringBuilder localStringBuilder = new StringBuilder().append("onStatusChanged: ").append(paramString).append(" status: ");
    if (paramInt == 2) {
      paramString = "available ";
    }
    for (;;)
    {
      Log.d(paramBundle, paramString);
      return;
      if (paramInt == 1) {
        paramString = "temporarily unavailable";
      } else if (paramInt == 0) {
        paramString = "Out of Service";
      } else {
        paramString = "unknown";
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.threatmetrix.TrustDefenderMobile.TDLocationListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */