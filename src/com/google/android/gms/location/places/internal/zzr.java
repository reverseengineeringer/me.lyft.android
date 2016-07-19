package com.google.android.gms.location.places.internal;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class zzr
  extends zzt
  implements Place
{
  private final String aeL = zzao("place_id", "");
  
  public zzr(DataHolder paramDataHolder, int paramInt, Context paramContext)
  {
    super(paramDataHolder, paramInt);
  }
  
  private List<String> zzbop()
  {
    return zzb("place_attributions", Collections.emptyList());
  }
  
  private PlaceEntity zzboz()
  {
    PlaceEntity localPlaceEntity = new PlaceEntity.zza().zzkt(getAddress().toString()).zzab(zzbop()).zzkr(getId()).zzby(zzboq()).zza(getLatLng()).zzg(zzbon()).zzks(getName().toString()).zzku(getPhoneNumber().toString()).zzua(getPriceLevel()).zzh(getRating()).zzaa(getPlaceTypes()).zza(getViewport()).zzr(getWebsiteUri()).zzbow();
    localPlaceEntity.setLocale(getLocale());
    return localPlaceEntity;
  }
  
  public CharSequence getAddress()
  {
    return zzao("place_address", "");
  }
  
  public String getId()
  {
    return aeL;
  }
  
  public LatLng getLatLng()
  {
    return (LatLng)zza("place_lat_lng", LatLng.CREATOR);
  }
  
  public Locale getLocale()
  {
    String str = zzao("place_locale_language", "");
    if (!TextUtils.isEmpty(str)) {
      return new Locale(str, zzao("place_locale_country", ""));
    }
    str = zzao("place_locale", "");
    if (!TextUtils.isEmpty(str)) {
      return new Locale(str);
    }
    return Locale.getDefault();
  }
  
  public CharSequence getName()
  {
    return zzao("place_name", "");
  }
  
  public CharSequence getPhoneNumber()
  {
    return zzao("place_phone_number", "");
  }
  
  public List<Integer> getPlaceTypes()
  {
    return zza("place_types", Collections.emptyList());
  }
  
  public int getPriceLevel()
  {
    return zzx("place_price_level", -1);
  }
  
  public float getRating()
  {
    return zzb("place_rating", -1.0F);
  }
  
  public LatLngBounds getViewport()
  {
    return (LatLngBounds)zza("place_viewport", LatLngBounds.CREATOR);
  }
  
  public Uri getWebsiteUri()
  {
    String str = zzao("place_website_uri", null);
    if (str == null) {
      return null;
    }
    return Uri.parse(str);
  }
  
  public float zzbon()
  {
    return zzb("place_level_number", 0.0F);
  }
  
  public boolean zzboq()
  {
    return zzn("place_is_permanently_closed", false);
  }
  
  public Place zzbov()
  {
    return zzboz();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.places.internal.zzr
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */