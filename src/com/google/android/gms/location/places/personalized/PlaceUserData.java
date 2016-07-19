package com.google.android.gms.location.places.personalized;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzaa.zza;
import java.util.List;

@Deprecated
public class PlaceUserData
  extends AbstractSafeParcelable
{
  public static final zzf CREATOR = new zzf();
  private final String aeL;
  private final List<PlaceAlias> agh;
  private final String cf;
  final int mVersionCode;
  
  PlaceUserData(int paramInt, String paramString1, String paramString2, List<PlaceAlias> paramList)
  {
    mVersionCode = paramInt;
    cf = paramString1;
    aeL = paramString2;
    agh = paramList;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof PlaceUserData)) {
        return false;
      }
      paramObject = (PlaceUserData)paramObject;
    } while ((cf.equals(cf)) && (aeL.equals(aeL)) && (agh.equals(agh)));
    return false;
  }
  
  public String getPlaceId()
  {
    return aeL;
  }
  
  public int hashCode()
  {
    return zzaa.hashCode(new Object[] { cf, aeL, agh });
  }
  
  public String toString()
  {
    return zzaa.zzz(this).zzg("accountName", cf).zzg("placeId", aeL).zzg("placeAliases", agh).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzf.zza(this, paramParcel, paramInt);
  }
  
  public List<PlaceAlias> zzbpa()
  {
    return agh;
  }
  
  public String zzbpd()
  {
    return cf;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.places.personalized.PlaceUserData
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */