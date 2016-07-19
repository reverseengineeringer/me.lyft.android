package me.lyft.android.domain.drivers;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import me.lyft.android.domain.location.Location;

public class NearbyDriver
{
  @SerializedName("id")
  private String id;
  @SerializedName("location")
  private Location location;
  @SerializedName("recentLocations")
  private List<Location> recentLocations;
  
  public String getId()
  {
    return id;
  }
  
  public Location getLocation()
  {
    return location;
  }
  
  public List<Location> getRecentLocations()
  {
    return recentLocations;
  }
  
  public void setId(String paramString)
  {
    id = paramString;
  }
  
  public void setLocation(Location paramLocation)
  {
    location = paramLocation;
  }
  
  public void setRecentLocations(List<Location> paramList)
  {
    recentLocations = paramList;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.drivers.NearbyDriver
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */