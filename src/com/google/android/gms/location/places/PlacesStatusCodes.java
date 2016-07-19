package com.google.android.gms.location.places;

import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzab;

public class PlacesStatusCodes
  extends CommonStatusCodes
{
  public static String getStatusCodeString(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return CommonStatusCodes.getStatusCodeString(paramInt);
    case 9000: 
      return "PLACES_API_QUOTA_FAILED";
    case 9001: 
      return "PLACES_API_USAGE_LIMIT_EXCEEDED";
    case 9002: 
      return "PLACES_API_KEY_INVALID";
    case 9003: 
      return "PLACES_API_ACCESS_NOT_CONFIGURED";
    case 9004: 
      return "PLACES_API_INVALID_ARGUMENT";
    case 9005: 
      return "PLACES_API_RATE_LIMIT_EXCEEDED";
    case 9006: 
      return "PLACES_API_DEVICE_RATE_LIMIT_EXCEEDED";
    case 9007: 
      return "PLACES_API_KEY_EXPIRED";
    case 9051: 
      return "PLACE_ALIAS_NOT_FOUND";
    case 9101: 
      return "PLACE_PROXIMITY_UNKNOWN";
    case 9102: 
      return "NEARBY_ALERTS_NOT_AVAILABLE";
    }
    return "PLACES_API_INVALID_APP";
  }
  
  public static Status zzgz(int paramInt)
  {
    return zzn(paramInt, getStatusCodeString(paramInt));
  }
  
  public static Status zzn(int paramInt, String paramString)
  {
    zzab.zzaa(paramString);
    return new Status(paramInt, paramString);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.places.PlacesStatusCodes
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */