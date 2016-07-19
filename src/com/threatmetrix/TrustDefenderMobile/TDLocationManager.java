package com.threatmetrix.TrustDefenderMobile;

import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Looper;
import android.util.Log;
import java.util.Iterator;
import java.util.List;

class TDLocationManager
{
  private static final String TAG = StringUtils.getLogTag(TDLocationManager.class);
  private int m_accuracy;
  private Context m_context;
  private long m_highPowerUpdateTime;
  private boolean m_isManualLocation = false;
  private Location m_location;
  private TDLocationListener m_locationListener;
  private LocationManager m_locationManager;
  private long m_lowPowerUpdateTime;
  private boolean m_paused = false;
  
  private void getLastLocation()
  {
    float f1 = Float.MAX_VALUE;
    long l1 = 0L;
    Object localObject1 = null;
    Log.d(TAG, "Attempting to find an existing location to prime things");
    Iterator localIterator = m_locationManager.getAllProviders().iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = (String)localIterator.next();
      if (localObject2 == null)
      {
        Log.e(TAG, "null provider (wut?)");
      }
      else
      {
        Log.d(TAG, "getLastLocation() : " + (String)localObject2);
        localObject2 = m_locationManager.getLastKnownLocation((String)localObject2);
        if (localObject2 != null)
        {
          Log.d(TAG, "getLastLocation() : " + ((Location)localObject2).getProvider() + ":" + ((Location)localObject2).getLatitude() + ":" + ((Location)localObject2).getLongitude() + ":" + ((Location)localObject2).getAccuracy());
          float f2 = ((Location)localObject2).getAccuracy();
          long l2 = ((Location)localObject2).getTime();
          if ((l2 > m_lowPowerUpdateTime) && (f2 < f1))
          {
            localObject1 = localObject2;
            f1 = f2;
            l1 = l2;
          }
          else if ((l2 < m_lowPowerUpdateTime) && (f1 == Float.MAX_VALUE) && (l2 > l1))
          {
            localObject1 = localObject2;
            l1 = l2;
          }
        }
      }
    }
    if (localObject1 != null) {
      setLocation((Location)localObject1, false);
    }
  }
  
  private boolean registerLocationServices()
  {
    Log.d(TAG, "registerLocationServices: low power " + m_lowPowerUpdateTime + " high power " + m_highPowerUpdateTime + " with accuracy " + m_accuracy);
    m_locationManager = ((LocationManager)m_context.getSystemService("location"));
    boolean bool2;
    if (m_locationManager == null)
    {
      Log.e(TAG, "Insufficient permissions to acquire location manager");
      bool2 = false;
    }
    boolean bool1;
    do
    {
      return bool2;
      if (m_locationListener != null) {
        m_locationManager.removeUpdates(m_locationListener);
      }
      Criteria localCriteria1 = new Criteria();
      localCriteria1.setAccuracy(m_accuracy);
      localCriteria1.setAltitudeRequired(false);
      localCriteria1.setBearingAccuracy(0);
      localCriteria1.setCostAllowed(false);
      localCriteria1.setSpeedAccuracy(0);
      localCriteria1.setSpeedRequired(false);
      localCriteria1.setVerticalAccuracy(0);
      Criteria localCriteria2 = new Criteria();
      localCriteria2.setPowerRequirement(1);
      localCriteria2.setAccuracy(2);
      String str1 = m_locationManager.getBestProvider(localCriteria1, true);
      if (str1 != null) {
        Log.d(TAG, "fine provider: " + str1);
      }
      String str2 = m_locationManager.getBestProvider(localCriteria2, true);
      if (str2 != null) {
        Log.d(TAG, "course provider: " + str2);
      }
      if ((str1 == null) && (str2 == null))
      {
        m_locationListener = null;
        m_locationManager = null;
        Log.e(TAG, "Unable to find location provider, possibly incorrect permissions. Check that android.permission.ACCESS_COARSE_LOCATION or android.permission.ACCESS_FINE_LOCATION is set");
        return false;
      }
      getLastLocation();
      bool1 = false;
      boolean bool3 = bool1;
      if (str1 != null)
      {
        bool3 = bool1;
        if (str2 != null) {
          bool3 = str1.equals(str2);
        }
      }
      bool2 = false;
      m_locationListener = new TDLocationListener();
      if (m_location != null) {
        m_locationListener.onLocationChanged(m_location);
      }
      try
      {
        m_locationManager.requestLocationUpdates(m_lowPowerUpdateTime, (float)0L, localCriteria2, m_locationListener, Looper.getMainLooper());
        bool2 = true;
        bool1 = true;
        Log.d(TAG, "LocationManager created: " + m_locationManager.getBestProvider(localCriteria2, true));
        bool2 = bool1;
      }
      catch (SecurityException localSecurityException2)
      {
        for (;;)
        {
          Log.e(TAG, "Security settings error:" + localSecurityException2.getLocalizedMessage());
        }
      }
      bool1 = bool2;
      if (!bool3) {
        bool1 = bool2;
      }
      try
      {
        m_locationManager.requestLocationUpdates(m_highPowerUpdateTime, (float)0L, localCriteria1, m_locationListener, null);
        bool1 = true;
        bool2 = true;
        Log.d(TAG, "LocationManager created: " + m_locationManager.getBestProvider(localCriteria1, true));
        bool1 = bool2;
      }
      catch (SecurityException localSecurityException1)
      {
        for (;;)
        {
          Log.e(TAG, "Security settings error:" + localSecurityException1.getLocalizedMessage());
        }
      }
      bool2 = bool1;
    } while (bool1);
    m_locationListener = null;
    m_locationManager = null;
    return bool1;
  }
  
  boolean enabled()
  {
    return (m_locationManager != null) && (m_locationListener != null);
  }
  
  public Location getLocation()
  {
    Location localLocation2 = m_location;
    Location localLocation1 = localLocation2;
    if (localLocation2 == null)
    {
      localLocation1 = localLocation2;
      if (m_locationListener != null) {
        localLocation1 = m_locationListener.getLastLocation();
      }
    }
    return localLocation1;
  }
  
  public boolean isManualLocation()
  {
    return m_isManualLocation;
  }
  
  public boolean registerLocationServices(Context paramContext, long paramLong1, long paramLong2, int paramInt)
  {
    m_context = paramContext;
    m_lowPowerUpdateTime = paramLong1;
    m_highPowerUpdateTime = paramLong2;
    m_accuracy = paramInt;
    return registerLocationServices();
  }
  
  void setLocation(Location paramLocation)
  {
    setLocation(paramLocation, true);
  }
  
  void setLocation(Location paramLocation, boolean paramBoolean)
  {
    if (paramLocation != null)
    {
      m_location = new Location(paramLocation);
      m_isManualLocation = paramBoolean;
      return;
    }
    m_location = null;
    m_isManualLocation = false;
  }
  
  public void unregister()
  {
    if (enabled()) {
      m_locationManager.removeUpdates(m_locationListener);
    }
  }
}

/* Location:
 * Qualified Name:     com.threatmetrix.TrustDefenderMobile.TDLocationManager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */