package com.google.android.gms.location.places;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zzf;
import com.google.android.gms.location.places.internal.zzd;
import com.google.android.gms.location.places.internal.zze;
import com.google.android.gms.location.places.internal.zze.zza;
import com.google.android.gms.location.places.internal.zzj;
import com.google.android.gms.location.places.internal.zzk;
import com.google.android.gms.location.places.internal.zzk.zza;

public class Places
{
  public static final Api<PlacesOptions> GEO_DATA_API;
  public static final GeoDataApi GeoDataApi = new zzd();
  public static final Api<PlacesOptions> PLACE_DETECTION_API;
  public static final PlaceDetectionApi PlaceDetectionApi = new zzj();
  public static final Api.zzf<zze> aeU = new Api.zzf();
  public static final Api.zzf<zzk> aeV = new Api.zzf();
  
  static
  {
    GEO_DATA_API = new Api("Places.GEO_DATA_API", new zze.zza(), aeU);
    PLACE_DETECTION_API = new Api("Places.PLACE_DETECTION_API", new zzk.zza(), aeV);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.places.Places
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */