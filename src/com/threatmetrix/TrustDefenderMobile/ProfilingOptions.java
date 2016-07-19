package com.threatmetrix.TrustDefenderMobile;

import android.location.Location;
import java.util.List;

public class ProfilingOptions
{
  private List<String> m_customAttributes;
  private Location m_location;
  private String m_sessionID;
  
  List<String> getCustomAttributes()
  {
    return m_customAttributes;
  }
  
  Location getLocation()
  {
    return m_location;
  }
  
  String getSessionID()
  {
    return m_sessionID;
  }
  
  public ProfilingOptions setLocation(Location paramLocation)
  {
    m_location = paramLocation;
    return this;
  }
  
  public ProfilingOptions setSessionID(String paramString)
  {
    m_sessionID = paramString;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.threatmetrix.TrustDefenderMobile.ProfilingOptions
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */