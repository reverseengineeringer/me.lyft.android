package com.google.android.gms.location.places.personalized;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzaa.zza;

@Deprecated
public class PlaceAlias
  extends AbstractSafeParcelable
{
  public static final zzd CREATOR = new zzd();
  public static final PlaceAlias agj = new PlaceAlias(0, "Home");
  public static final PlaceAlias agk = new PlaceAlias(0, "Work");
  private final String agl;
  final int mVersionCode;
  
  PlaceAlias(int paramInt, String paramString)
  {
    mVersionCode = paramInt;
    agl = paramString;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof PlaceAlias)) {
      return false;
    }
    paramObject = (PlaceAlias)paramObject;
    return zzaa.equal(agl, agl);
  }
  
  public int hashCode()
  {
    return zzaa.hashCode(new Object[] { agl });
  }
  
  public String toString()
  {
    return zzaa.zzz(this).zzg("alias", agl).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzd.zza(this, paramParcel, paramInt);
  }
  
  public String zzbpc()
  {
    return agl;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.places.personalized.PlaceAlias
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */