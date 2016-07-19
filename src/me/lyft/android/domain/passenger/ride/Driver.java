package me.lyft.android.domain.passenger.ride;

import java.util.Collections;
import java.util.List;
import me.lyft.android.common.INullable;
import me.lyft.android.domain.location.Location;
import me.lyft.android.domain.location.NullLocation;

public class Driver
  implements INullable
{
  private String icon;
  private String id;
  private Location location;
  private String name;
  private String phoneNumber;
  private String photo;
  private Double rating;
  private List<Location> recentLocations;
  private String status;
  private DriverVehicle vehicle;
  
  public Driver(String paramString1, String paramString2, String paramString3, String paramString4, DriverVehicle paramDriverVehicle, Location paramLocation, Double paramDouble, List<Location> paramList, String paramString5, String paramString6)
  {
    id = paramString1;
    name = paramString2;
    photo = paramString3;
    phoneNumber = paramString4;
    vehicle = paramDriverVehicle;
    location = paramLocation;
    status = paramString6;
    paramString1 = paramDouble;
    if (paramDouble == null) {
      paramString1 = null;
    }
    rating = paramString1;
    recentLocations = paramList;
    icon = paramString5;
  }
  
  public static Driver empty()
  {
    return NullDriver.getInstance();
  }
  
  public String getIcon()
  {
    return icon;
  }
  
  public String getId()
  {
    return id;
  }
  
  public Location getLocation()
  {
    return location;
  }
  
  public String getName()
  {
    return name;
  }
  
  public String getPhoneNumber()
  {
    return phoneNumber;
  }
  
  public String getPhoto()
  {
    return photo;
  }
  
  public Double getRating()
  {
    return rating;
  }
  
  public List<Location> getRecentLocations()
  {
    return recentLocations;
  }
  
  public String getStatus()
  {
    return status;
  }
  
  public DriverVehicle getVehicle()
  {
    return vehicle;
  }
  
  public boolean hasLocation()
  {
    return !location.isNull();
  }
  
  public boolean isNull()
  {
    return false;
  }
  
  static class NullDriver
    extends Driver
  {
    private static final Driver INSTANCE = new NullDriver();
    
    private NullDriver()
    {
      super("", "", "", DriverVehicle.empty(), NullLocation.getInstance(), Double.valueOf(0.0D), Collections.emptyList(), "", "");
    }
    
    public static Driver getInstance()
    {
      return INSTANCE;
    }
    
    public boolean isNull()
    {
      return true;
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.passenger.ride.Driver
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */