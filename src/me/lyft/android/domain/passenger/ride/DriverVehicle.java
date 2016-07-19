package me.lyft.android.domain.passenger.ride;

import me.lyft.android.common.Strings;

public class DriverVehicle
{
  private String color;
  private String licensePlate;
  private String make;
  private String model;
  private String photoUrl;
  private String transparentPhotoUrl;
  
  public DriverVehicle(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    make = paramString1;
    model = paramString2;
    color = paramString3;
    licensePlate = paramString4;
    photoUrl = paramString5;
    transparentPhotoUrl = paramString6;
  }
  
  public static DriverVehicle empty()
  {
    return NullDriverVehicle.getInstance();
  }
  
  public String getColor()
  {
    return color;
  }
  
  public String getLicensePlate()
  {
    return licensePlate;
  }
  
  public String getMake()
  {
    return make;
  }
  
  public String getModel()
  {
    return model;
  }
  
  public String getPhotoUrl()
  {
    return photoUrl;
  }
  
  public String getTransparentPhotoUrl()
  {
    return transparentPhotoUrl;
  }
  
  public boolean hasLicensePlate()
  {
    return !Strings.isNullOrEmpty(licensePlate);
  }
  
  static class NullDriverVehicle
    extends DriverVehicle
  {
    private static DriverVehicle INSTANCE = new NullDriverVehicle();
    
    private NullDriverVehicle()
    {
      super("", "", "", "", "");
    }
    
    public static DriverVehicle getInstance()
    {
      return INSTANCE;
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.passenger.ride.DriverVehicle
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */