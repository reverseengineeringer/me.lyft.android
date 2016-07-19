package me.lyft.android.domain.driver.ride;

import me.lyft.android.common.INullable;
import me.lyft.android.common.Objects;
import me.lyft.android.domain.location.Location;
import me.lyft.android.domain.location.NullLocation;

public class DriverRidePassenger
  implements INullable
{
  private boolean driverCanPenalize;
  private String firstName;
  private String id;
  private boolean isDroppedoff;
  private boolean isPickedup;
  private boolean isSelf;
  private Location location;
  private int partySize;
  private String phoneNumber;
  private String photoUrl;
  private float rating;
  private boolean ratingCompleted;
  private String rideId;
  
  public DriverRidePassenger(String paramString1, boolean paramBoolean1, String paramString2, String paramString3, String paramString4, int paramInt, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, Location paramLocation)
  {
    id = paramString1;
    isSelf = paramBoolean1;
    firstName = paramString2;
    photoUrl = paramString3;
    phoneNumber = paramString4;
    partySize = paramInt;
    isPickedup = paramBoolean2;
    isDroppedoff = paramBoolean3;
    ratingCompleted = paramBoolean4;
    location = paramLocation;
  }
  
  public static DriverRidePassenger empty()
  {
    return NullDriverRidePassenger.instance;
  }
  
  public DriverRidePassenger asDroppedOff()
  {
    DriverRidePassenger localDriverRidePassenger = new DriverRidePassenger(id, isSelf, firstName, photoUrl, phoneNumber, partySize, true, true, ratingCompleted, location);
    localDriverRidePassenger.setRideId(rideId);
    return localDriverRidePassenger;
  }
  
  public DriverRidePassenger asPickedUp()
  {
    DriverRidePassenger localDriverRidePassenger = new DriverRidePassenger(id, isSelf, firstName, photoUrl, phoneNumber, partySize, true, false, ratingCompleted, location);
    localDriverRidePassenger.setRideId(rideId);
    return localDriverRidePassenger;
  }
  
  public DriverRidePassenger asRated()
  {
    DriverRidePassenger localDriverRidePassenger = new DriverRidePassenger(id, isSelf, firstName, photoUrl, phoneNumber, partySize, true, true, true, location);
    localDriverRidePassenger.setRideId(rideId);
    return localDriverRidePassenger;
  }
  
  public boolean driverCanPenalize()
  {
    return driverCanPenalize;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof DriverRidePassenger)) {}
    do
    {
      return false;
      paramObject = (DriverRidePassenger)paramObject;
    } while ((!Objects.equals(getId(), ((DriverRidePassenger)paramObject).getId())) || (!Objects.equals(getRideId(), ((DriverRidePassenger)paramObject).getRideId())) || (!Objects.equals(getFirstName(), ((DriverRidePassenger)paramObject).getFirstName())) || (!Objects.equals(getPhotoUrl(), ((DriverRidePassenger)paramObject).getPhotoUrl())) || (Math.abs(getRating() - ((DriverRidePassenger)paramObject).getRating()) >= 0.001F) || (!Objects.equals(getPhoneNumber(), ((DriverRidePassenger)paramObject).getPhoneNumber())) || (getPartySize() != ((DriverRidePassenger)paramObject).getPartySize()) || (isPickedup() != ((DriverRidePassenger)paramObject).isPickedup()) || (driverCanPenalize() != ((DriverRidePassenger)paramObject).driverCanPenalize()) || (isDroppedoff() != ((DriverRidePassenger)paramObject).isDroppedoff()) || (isRatingCompleted() != ((DriverRidePassenger)paramObject).isRatingCompleted()));
    return true;
  }
  
  public String getFirstName()
  {
    return firstName;
  }
  
  public String getId()
  {
    return id;
  }
  
  public Location getLocation()
  {
    return location;
  }
  
  public int getPartySize()
  {
    return partySize;
  }
  
  public String getPhoneNumber()
  {
    return phoneNumber;
  }
  
  public String getPhotoUrl()
  {
    return photoUrl;
  }
  
  public float getRating()
  {
    return rating;
  }
  
  public String getRideId()
  {
    return rideId;
  }
  
  public boolean isDroppedoff()
  {
    return isDroppedoff;
  }
  
  public boolean isNull()
  {
    return false;
  }
  
  public boolean isPickedup()
  {
    return isPickedup;
  }
  
  public boolean isRatingCompleted()
  {
    return ratingCompleted;
  }
  
  public boolean isSelf()
  {
    return isSelf;
  }
  
  public void setDriverCanPenalize(boolean paramBoolean)
  {
    driverCanPenalize = paramBoolean;
  }
  
  public void setRating(float paramFloat)
  {
    rating = paramFloat;
  }
  
  public void setRideId(String paramString)
  {
    rideId = paramString;
  }
  
  public static class NullDriverRidePassenger
    extends DriverRidePassenger
  {
    private static final DriverRidePassenger instance = new NullDriverRidePassenger();
    
    private NullDriverRidePassenger()
    {
      super(false, "", "", "", 0, false, false, false, NullLocation.getInstance());
    }
    
    public String getFirstName()
    {
      return "";
    }
    
    public String getId()
    {
      return "";
    }
    
    public String getPhoneNumber()
    {
      return "";
    }
    
    public String getPhotoUrl()
    {
      return "";
    }
    
    public boolean isNull()
    {
      return true;
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.driver.ride.DriverRidePassenger
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */