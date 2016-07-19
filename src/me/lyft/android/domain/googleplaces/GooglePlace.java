package me.lyft.android.domain.googleplaces;

public class GooglePlace
{
  private final String address;
  private final Double lat;
  private final Double lng;
  private final String name;
  private final String phoneNumber;
  private final String placeId;
  private final GooglePlaceType placeType;
  
  public GooglePlace(String paramString1, String paramString2, String paramString3, String paramString4, GooglePlaceType paramGooglePlaceType, double paramDouble1, double paramDouble2)
  {
    placeId = paramString1;
    name = paramString2;
    phoneNumber = paramString3;
    address = paramString4;
    placeType = paramGooglePlaceType;
    lat = Double.valueOf(paramDouble1);
    lng = Double.valueOf(paramDouble2);
  }
  
  public String getAddress()
  {
    return address;
  }
  
  public Double getLat()
  {
    return lat;
  }
  
  public Double getLng()
  {
    return lng;
  }
  
  public String getName()
  {
    return name;
  }
  
  public String getPhoneNumber()
  {
    return phoneNumber;
  }
  
  public String getPlaceId()
  {
    return placeId;
  }
  
  public GooglePlaceType getPlaceType()
  {
    return placeType;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.googleplaces.GooglePlace
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */