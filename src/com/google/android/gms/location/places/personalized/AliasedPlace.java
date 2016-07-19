package com.google.android.gms.location.places.personalized;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzaa.zza;
import java.util.List;

public class AliasedPlace
  implements SafeParcelable
{
  public static final zza CREATOR = new zza();
  private final String aeL;
  private final List<String> agh;
  final int mVersionCode;
  
  AliasedPlace(int paramInt, String paramString, List<String> paramList)
  {
    mVersionCode = paramInt;
    aeL = paramString;
    agh = paramList;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof AliasedPlace)) {
        return false;
      }
      paramObject = (AliasedPlace)paramObject;
    } while ((aeL.equals(aeL)) && (agh.equals(agh)));
    return false;
  }
  
  public String getPlaceId()
  {
    return aeL;
  }
  
  public int hashCode()
  {
    return zzaa.hashCode(new Object[] { aeL, agh });
  }
  
  public String toString()
  {
    return zzaa.zzz(this).zzg("placeId", aeL).zzg("placeAliases", agh).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zza.zza(this, paramParcel, paramInt);
  }
  
  public List<String> zzbpa()
  {
    return agh;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.places.personalized.AliasedPlace
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */