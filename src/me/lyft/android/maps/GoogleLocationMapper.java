package me.lyft.android.maps;

public class GoogleLocationMapper
{
  public static android.location.Location toAndroidLocation(me.lyft.android.domain.location.Location paramLocation)
  {
    android.location.Location localLocation = new android.location.Location("gps");
    localLocation.setLatitude(paramLocation.getLat());
    localLocation.setLongitude(paramLocation.getLng());
    localLocation.setTime(paramLocation.getTime().longValue());
    Double localDouble = paramLocation.getAccuracy();
    if (localDouble != null) {
      localLocation.setAccuracy(localDouble.floatValue());
    }
    localDouble = paramLocation.getBearing();
    if (localDouble != null) {
      localLocation.setBearing(localDouble.floatValue());
    }
    localDouble = paramLocation.getSpeed();
    if (localDouble != null) {
      localLocation.setSpeed(localDouble.floatValue());
    }
    paramLocation = paramLocation.getAltitude();
    if (paramLocation != null) {
      localLocation.setAltitude(paramLocation.doubleValue());
    }
    return localLocation;
  }
  
  public static me.lyft.android.domain.location.Location toDomainLocation(android.location.Location paramLocation)
  {
    me.lyft.android.domain.location.Location localLocation = new me.lyft.android.domain.location.Location(paramLocation.getLatitude(), paramLocation.getLongitude(), "defaultLocation");
    localLocation.setTime(Long.valueOf(paramLocation.getTime()));
    if (paramLocation.hasAccuracy())
    {
      d = paramLocation.getAccuracy();
      localLocation.setAccuracy(Double.valueOf(d));
      if (!paramLocation.hasBearing()) {
        break label103;
      }
    }
    label103:
    for (double d = paramLocation.getBearing();; d = -1.0D)
    {
      localLocation.setBearing(Double.valueOf(d));
      localLocation.setSpeed(Double.valueOf(paramLocation.getSpeed()));
      localLocation.setAltitude(Double.valueOf(paramLocation.getAltitude()));
      return localLocation;
      d = Double.MAX_VALUE;
      break;
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.maps.GoogleLocationMapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */