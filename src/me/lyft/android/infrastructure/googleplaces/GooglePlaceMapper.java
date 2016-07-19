package me.lyft.android.infrastructure.googleplaces;

import com.google.android.gms.location.places.AutocompletePrediction;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import me.lyft.android.domain.googleplaces.GooglePlace;
import me.lyft.android.domain.googleplaces.GooglePlaceType;
import me.lyft.android.domain.location.Location;
import me.lyft.android.domain.location.SphericalUtils;

class GooglePlaceMapper
{
  private static final List<Integer> CATEGORIES_BAR;
  private static final List<Integer> CATEGORIES_BUSINESS;
  private static final List<Integer> CATEGORIES_CAFE;
  private static final List<Integer> CATEGORIES_GEOCODE;
  private static final List<Integer> CATEGORIES_RESTAURANT;
  private static final Map<Integer, GooglePlaceType> CATEGORY_MAP;
  private static final int DIAMETER_IN_METERS = 20000;
  private static final double HYPOTENUSE_IN_KM = Math.sqrt(8.0E8D);
  
  static
  {
    CATEGORIES_GEOCODE = Arrays.asList(new Integer[] { Integer.valueOf(1012), Integer.valueOf(1015) });
    CATEGORIES_BAR = Arrays.asList(new Integer[] { Integer.valueOf(9), Integer.valueOf(67) });
    CATEGORIES_CAFE = Arrays.asList(new Integer[] { Integer.valueOf(15) });
    CATEGORIES_RESTAURANT = Arrays.asList(new Integer[] { Integer.valueOf(79), Integer.valueOf(38), Integer.valueOf(60), Integer.valueOf(61) });
    CATEGORIES_BUSINESS = Arrays.asList(new Integer[] { Integer.valueOf(1), Integer.valueOf(5), Integer.valueOf(6), Integer.valueOf(7), Integer.valueOf(8), Integer.valueOf(10), Integer.valueOf(11), Integer.valueOf(12), Integer.valueOf(17), Integer.valueOf(18), Integer.valueOf(19), Integer.valueOf(20), Integer.valueOf(21), Integer.valueOf(24), Integer.valueOf(25), Integer.valueOf(26), Integer.valueOf(27), Integer.valueOf(28), Integer.valueOf(29), Integer.valueOf(30), Integer.valueOf(31), Integer.valueOf(32), Integer.valueOf(33), Integer.valueOf(34), Integer.valueOf(35), Integer.valueOf(36), Integer.valueOf(37), Integer.valueOf(39), Integer.valueOf(40), Integer.valueOf(42), Integer.valueOf(43), Integer.valueOf(44), Integer.valueOf(45), Integer.valueOf(46), Integer.valueOf(47), Integer.valueOf(49), Integer.valueOf(50), Integer.valueOf(51), Integer.valueOf(52), Integer.valueOf(53), Integer.valueOf(54), Integer.valueOf(55), Integer.valueOf(56), Integer.valueOf(57), Integer.valueOf(58), Integer.valueOf(59), Integer.valueOf(63), Integer.valueOf(64), Integer.valueOf(65), Integer.valueOf(66), Integer.valueOf(68), Integer.valueOf(71), Integer.valueOf(72), Integer.valueOf(73), Integer.valueOf(75), Integer.valueOf(76), Integer.valueOf(77), Integer.valueOf(78), Integer.valueOf(80), Integer.valueOf(82), Integer.valueOf(83), Integer.valueOf(84), Integer.valueOf(87), Integer.valueOf(88), Integer.valueOf(93), Integer.valueOf(94), Integer.valueOf(95) });
    HashMap localHashMap = new HashMap();
    insertToMap(localHashMap, CATEGORIES_BAR, GooglePlaceType.BAR);
    insertToMap(localHashMap, CATEGORIES_CAFE, GooglePlaceType.CAFE);
    insertToMap(localHashMap, CATEGORIES_RESTAURANT, GooglePlaceType.RESTAURANT);
    insertToMap(localHashMap, CATEGORIES_BUSINESS, GooglePlaceType.BUSINESS);
    insertToMap(localHashMap, CATEGORIES_GEOCODE, GooglePlaceType.GEOCODE);
    CATEGORY_MAP = Collections.unmodifiableMap(localHashMap);
  }
  
  static LatLngBounds calculateBounds(Location paramLocation)
  {
    me.lyft.android.domain.location.LatLng localLatLng = SphericalUtils.computeOffset(paramLocation, HYPOTENUSE_IN_KM, 225.0D);
    paramLocation = SphericalUtils.computeOffset(paramLocation, HYPOTENUSE_IN_KM, 45.0D);
    return new LatLngBounds(new com.google.android.gms.maps.model.LatLng(localLatLng.getLat(), localLatLng.getLng()), new com.google.android.gms.maps.model.LatLng(paramLocation.getLat(), paramLocation.getLng()));
  }
  
  static GooglePlaceType convertGooglePlayPlaceType(List<Integer> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Integer localInteger = (Integer)paramList.next();
      if (CATEGORY_MAP.containsKey(localInteger)) {
        return (GooglePlaceType)CATEGORY_MAP.get(localInteger);
      }
    }
    return GooglePlaceType.OTHER;
  }
  
  static GooglePlacePrediction fromGooglePlayAutocomplete(AutocompletePrediction paramAutocompletePrediction)
  {
    return new GooglePlacePrediction(paramAutocompletePrediction.getPlaceId(), paramAutocompletePrediction.getFullText(null).toString(), convertGooglePlayPlaceType(paramAutocompletePrediction.getPlaceTypes()));
  }
  
  static GooglePlace fromGooglePlayPlace(Place paramPlace)
  {
    return new GooglePlace(paramPlace.getId(), paramPlace.getName().toString(), paramPlace.getPhoneNumber().toString(), paramPlace.getAddress().toString(), convertGooglePlayPlaceType(paramPlace.getPlaceTypes()), getLatLnglatitude, getLatLnglongitude);
  }
  
  private static void insertToMap(Map<Integer, GooglePlaceType> paramMap, List<Integer> paramList, GooglePlaceType paramGooglePlaceType)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      paramMap.put((Integer)paramList.next(), paramGooglePlaceType);
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.googleplaces.GooglePlaceMapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */