package com.google.android.gms.location.places.internal;

import android.text.style.CharacterStyle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.location.places.AutocompletePrediction;
import java.util.Collections;
import java.util.List;

public class zzb
  extends zzt
  implements AutocompletePrediction
{
  public zzb(DataHolder paramDataHolder, int paramInt)
  {
    super(paramDataHolder, paramInt);
  }
  
  private String zzbog()
  {
    return zzao("ap_description", "");
  }
  
  private String zzboh()
  {
    return zzao("ap_primary_text", "");
  }
  
  private String zzboi()
  {
    return zzao("ap_secondary_text", "");
  }
  
  private List<AutocompletePredictionEntity.SubstringEntity> zzboj()
  {
    return zza("ap_matched_subscriptions", AutocompletePredictionEntity.SubstringEntity.CREATOR, Collections.emptyList());
  }
  
  private List<AutocompletePredictionEntity.SubstringEntity> zzbok()
  {
    return zza("ap_primary_text_matched", AutocompletePredictionEntity.SubstringEntity.CREATOR, Collections.emptyList());
  }
  
  private List<AutocompletePredictionEntity.SubstringEntity> zzbol()
  {
    return zza("ap_secondary_text_matched", AutocompletePredictionEntity.SubstringEntity.CREATOR, Collections.emptyList());
  }
  
  public CharSequence getFullText(CharacterStyle paramCharacterStyle)
  {
    return zzc.zza(zzbog(), zzboj(), paramCharacterStyle);
  }
  
  public String getPlaceId()
  {
    return zzao("ap_place_id", null);
  }
  
  public List<Integer> getPlaceTypes()
  {
    return zza("ap_place_types", Collections.emptyList());
  }
  
  public AutocompletePrediction zzboe()
  {
    return AutocompletePredictionEntity.zza(getPlaceId(), getPlaceTypes(), zzbof(), zzbog(), zzboj(), zzboh(), zzbok(), zzboi(), zzbol());
  }
  
  public int zzbof()
  {
    return zzx("ap_personalization_type", 6);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.places.internal.zzb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */