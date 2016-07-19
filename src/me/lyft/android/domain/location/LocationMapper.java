package me.lyft.android.domain.location;

import com.lyft.android.api.dto.DeprecatedPlaceDTO;
import com.lyft.android.api.dto.LocationDTO;
import com.lyft.android.api.dto.LocationDTOBuilder;
import com.lyft.android.api.dto.PlaceDTO;
import java.util.Date;
import me.lyft.android.common.DateUtils;
import me.lyft.android.common.Objects;
import me.lyft.android.common.Strings;
import me.lyft.android.domain.geo.EtaRecord;

public class LocationMapper
{
  public static Location fromLocationDTO(LocationDTO paramLocationDTO)
  {
    if (paramLocationDTO == null) {
      return NullLocation.getInstance();
    }
    Object localObject = (String)Objects.firstNonNull(source, "");
    localObject = new Location(((Double)Objects.firstNonNull(lat, Double.valueOf(0.0D))).doubleValue(), ((Double)Objects.firstNonNull(lng, Double.valueOf(0.0D))).doubleValue(), (String)localObject);
    if (bearing != null) {
      ((Location)localObject).setBearing(bearing);
    }
    try
    {
      ((Location)localObject).setTime(Long.valueOf(DateUtils.decode(recordedAt).getTime()));
      return (Location)localObject;
    }
    catch (Exception paramLocationDTO) {}
    return (Location)localObject;
  }
  
  public static Location fromPlaceDTO(DeprecatedPlaceDTO paramDeprecatedPlaceDTO)
  {
    if (paramDeprecatedPlaceDTO == null) {
      return NullLocation.getInstance();
    }
    Object localObject = (String)Objects.firstNonNull(source, "");
    localObject = new Location(((Double)Objects.firstNonNull(lat, Double.valueOf(0.0D))).doubleValue(), ((Double)Objects.firstNonNull(lng, Double.valueOf(0.0D))).doubleValue(), (String)localObject);
    ((Location)localObject).setAddress((String)Objects.firstNonNull(address, ""));
    ((Location)localObject).setRoutableAddress((String)Objects.firstNonNull(routableAddress, ""));
    ((Location)localObject).setPlaceId((String)Objects.firstNonNull(placeId, ""));
    ((Location)localObject).setPlaceName((String)Objects.firstNonNull(placeName, ""));
    ((Location)localObject).setNavigationMethod(navigationMethod);
    return (Location)localObject;
  }
  
  public static Location fromPlaceDTOV2(PlaceDTO paramPlaceDTO)
  {
    if (paramPlaceDTO == null) {
      return NullLocation.getInstance();
    }
    Object localObject = (String)Objects.firstNonNull(location_input_source, "");
    localObject = new Location(((Double)Objects.firstNonNull(lat, Double.valueOf(0.0D))).doubleValue(), ((Double)Objects.firstNonNull(lng, Double.valueOf(0.0D))).doubleValue(), (String)localObject);
    ((Location)localObject).setAddress((String)Objects.firstNonNull(address, ""));
    ((Location)localObject).setRoutableAddress((String)Objects.firstNonNull(routable_address, ""));
    ((Location)localObject).setPlaceId((String)Objects.firstNonNull(place_id, ""));
    ((Location)localObject).setPlaceName((String)Objects.firstNonNull(place_name, ""));
    return (Location)localObject;
  }
  
  public static DeprecatedPlaceDTO toDeprecatedPlaceDTO(Location paramLocation)
  {
    if ((paramLocation == null) || (paramLocation.isNull())) {
      return null;
    }
    double d1 = paramLocation.getLat();
    double d2 = paramLocation.getLng();
    String str1 = Strings.emptyToNull(paramLocation.getAddress());
    String str2 = Strings.emptyToNull(paramLocation.getSource());
    String str3 = paramLocation.getNavigationMethod();
    return new DeprecatedPlaceDTO(Double.valueOf(d1), Double.valueOf(d2), str1, Strings.emptyToNull(paramLocation.getPlaceName()), Strings.emptyToNull(paramLocation.getRoutableAddress()), str2, str3, Strings.emptyToNull(paramLocation.getPlaceId()));
  }
  
  public static LocationDTO toLocationDTO(Location paramLocation)
  {
    if ((paramLocation == null) || (paramLocation.isNull())) {
      return null;
    }
    return toLocationDTO(paramLocation, Strings.emptyToNull(paramLocation.getSource()));
  }
  
  public static LocationDTO toLocationDTO(Location paramLocation, String paramString)
  {
    String str = null;
    if ((paramLocation == null) || (paramLocation.isNull())) {
      return null;
    }
    double d1 = paramLocation.getLat();
    double d2 = paramLocation.getLng();
    Double localDouble1 = paramLocation.getBearing();
    Double localDouble2 = paramLocation.getSpeed();
    Double localDouble3 = paramLocation.getAccuracy();
    Long localLong = paramLocation.getTime();
    if (localLong != null) {
      str = DateUtils.convertEpochToISO(paramLocation.getTime().longValue());
    }
    return new LocationDTOBuilder().withLat(Double.valueOf(d1)).withLng(Double.valueOf(d2)).withSpeed(localDouble2).withBearing(localDouble1).withAccuracy(localDouble3).withRecordedAt(str).withRecordedAt(localLong).withSource(paramString).build();
  }
  
  public static LocationDTO toLocationDTO(Location paramLocation, String paramString1, String paramString2, boolean paramBoolean, EtaRecord paramEtaRecord)
  {
    if ((paramLocation == null) || (paramLocation.isNull())) {
      return null;
    }
    double d1 = paramLocation.getLat();
    double d2 = paramLocation.getLng();
    String str1;
    Double localDouble1;
    Double localDouble2;
    Double localDouble3;
    String str2;
    label70:
    Long localLong;
    if (paramBoolean)
    {
      str1 = "polling_fg";
      localDouble1 = paramLocation.getBearing();
      localDouble2 = paramLocation.getSpeed();
      localDouble3 = paramLocation.getAccuracy();
      if (paramLocation.getTime() == null) {
        break label175;
      }
      str2 = DateUtils.convertEpochToISO(paramLocation.getTime().longValue());
      localLong = paramLocation.getTime();
      if (!paramEtaRecord.isNull()) {
        break label181;
      }
    }
    label175:
    label181:
    for (paramLocation = null;; paramLocation = paramEtaRecord.getEta())
    {
      paramEtaRecord = paramEtaRecord.isInternal();
      return new LocationDTOBuilder().withLat(Double.valueOf(d1)).withLng(Double.valueOf(d2)).withSpeed(localDouble2).withBearing(localDouble1).withAccuracy(localDouble3).withRecordedAt(str2).withRideId(paramString1).withRideStatus(paramString2).withEta(paramLocation).withIsInternalEta(paramEtaRecord).withRecordedAt(localLong).withSource(str1).build();
      str1 = "polling_bg";
      break;
      str2 = null;
      break label70;
    }
  }
  
  public static PlaceDTO toPlaceDTO(Location paramLocation)
  {
    if ((paramLocation == null) || (paramLocation.isNull())) {
      return null;
    }
    double d1 = paramLocation.getLat();
    double d2 = paramLocation.getLng();
    String str1 = Strings.emptyToNull(paramLocation.getAddress());
    String str2 = Strings.emptyToNull(paramLocation.getSource());
    return new PlaceDTO(Double.valueOf(d1), Double.valueOf(d2), str1, Strings.emptyToNull(paramLocation.getPlaceName()), Strings.emptyToNull(paramLocation.getRoutableAddress()), str2, Strings.emptyToNull(paramLocation.getPlaceId()), null);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.location.LocationMapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */