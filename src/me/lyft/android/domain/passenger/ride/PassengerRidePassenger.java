package me.lyft.android.domain.passenger.ride;

import me.lyft.android.common.INullable;
import me.lyft.android.common.Objects;

public class PassengerRidePassenger
  implements INullable
{
  private String firstName;
  private String id;
  private boolean isSelf;
  private int partySize;
  private String photoUrl;
  
  public PassengerRidePassenger(String paramString1, boolean paramBoolean, String paramString2, String paramString3, int paramInt)
  {
    id = paramString1;
    isSelf = paramBoolean;
    firstName = paramString2;
    photoUrl = paramString3;
    partySize = paramInt;
  }
  
  public static PassengerRidePassenger empty()
  {
    return NullPassengerRidePassenger.instance;
  }
  
  @Deprecated
  public static PassengerRidePassenger emptySelf()
  {
    return new PassengerRidePassenger("", true, "", "", 0);
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof PassengerRidePassenger)) {}
    do
    {
      return false;
      paramObject = (PassengerRidePassenger)paramObject;
    } while ((!Objects.equals(getId(), ((PassengerRidePassenger)paramObject).getId())) || (!Objects.equals(getFirstName(), ((PassengerRidePassenger)paramObject).getFirstName())) || (!Objects.equals(getPhotoUrl(), ((PassengerRidePassenger)paramObject).getPhotoUrl())) || (getPartySize() != ((PassengerRidePassenger)paramObject).getPartySize()));
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
  
  public int getPartySize()
  {
    return partySize;
  }
  
  public String getPhotoUrl()
  {
    return photoUrl;
  }
  
  public boolean isNull()
  {
    return false;
  }
  
  public boolean isSelf()
  {
    return isSelf;
  }
  
  void setFirstName(String paramString)
  {
    firstName = paramString;
  }
  
  void setId(String paramString)
  {
    id = paramString;
  }
  
  void setPartySize(int paramInt)
  {
    partySize = paramInt;
  }
  
  void setPhotoUrl(String paramString)
  {
    photoUrl = paramString;
  }
  
  public static class NullPassengerRidePassenger
    extends PassengerRidePassenger
  {
    private static final PassengerRidePassenger instance = new NullPassengerRidePassenger();
    
    private NullPassengerRidePassenger()
    {
      super(false, "", "", 0);
    }
    
    public String getFirstName()
    {
      return "";
    }
    
    public String getId()
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
 * Qualified Name:     me.lyft.android.domain.passenger.ride.PassengerRidePassenger
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */