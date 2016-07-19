package com.threatmetrix.TrustDefenderMobile;

import android.location.Location;
import android.os.Build.VERSION;
import java.lang.reflect.Method;

public class LocationWrapper
  extends WrapperHelper
{
  static final Method m_isFromMockProvider = getMethod(Location.class, "isFromMockProvider", new Class[0]);
  private boolean m_isMockProvider = false;
  
  LocationWrapper(Location paramLocation)
  {
    if (Build.VERSION.SDK_INT >= 18)
    {
      paramLocation = (Boolean)invoke(paramLocation, m_isFromMockProvider, new Object[0]);
      if (paramLocation != null) {
        m_isMockProvider = paramLocation.booleanValue();
      }
    }
  }
  
  boolean isFromMockProvider()
  {
    return m_isMockProvider;
  }
}

/* Location:
 * Qualified Name:     com.threatmetrix.TrustDefenderMobile.LocationWrapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */