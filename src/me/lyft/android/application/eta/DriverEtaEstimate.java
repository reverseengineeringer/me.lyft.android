package me.lyft.android.application.eta;

import java.util.ArrayList;
import java.util.List;

class DriverEtaEstimate
{
  private Long eta;
  private String id;
  private String locationQuery;
  private List<String> rideTypes = new ArrayList();
  
  public DriverEtaEstimate(String paramString1, String paramString2)
  {
    id = paramString1;
    locationQuery = paramString2;
  }
  
  public void addRideType(String paramString)
  {
    rideTypes.add(paramString);
  }
  
  public Long getEta()
  {
    return eta;
  }
  
  public String getId()
  {
    return id;
  }
  
  public String getLocationQuery()
  {
    return locationQuery;
  }
  
  public List<String> getRideTypes()
  {
    return rideTypes;
  }
  
  public void setEta(Long paramLong)
  {
    eta = paramLong;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.eta.DriverEtaEstimate
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */