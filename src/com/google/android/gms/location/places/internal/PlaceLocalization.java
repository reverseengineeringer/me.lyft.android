package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzaa.zza;
import java.util.List;

@Deprecated
public final class PlaceLocalization
  extends AbstractSafeParcelable
{
  public static final zzo CREATOR = new zzo();
  public final String address;
  public final String afU;
  public final String afV;
  public final List<String> afW;
  public final String name;
  public final int versionCode;
  
  public PlaceLocalization(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, List<String> paramList)
  {
    versionCode = paramInt;
    name = paramString1;
    address = paramString2;
    afU = paramString3;
    afV = paramString4;
    afW = paramList;
  }
  
  public static PlaceLocalization zza(String paramString1, String paramString2, String paramString3, String paramString4, List<String> paramList)
  {
    return new PlaceLocalization(0, paramString1, paramString2, paramString3, paramString4, paramList);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof PlaceLocalization)) {
        return false;
      }
      paramObject = (PlaceLocalization)paramObject;
    } while ((zzaa.equal(name, name)) && (zzaa.equal(address, address)) && (zzaa.equal(afU, afU)) && (zzaa.equal(afV, afV)) && (zzaa.equal(afW, afW)));
    return false;
  }
  
  public int hashCode()
  {
    return zzaa.hashCode(new Object[] { name, address, afU, afV });
  }
  
  public String toString()
  {
    return zzaa.zzz(this).zzg("name", name).zzg("address", address).zzg("internationalPhoneNumber", afU).zzg("regularOpenHours", afV).zzg("attributions", afW).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzo localzzo = CREATOR;
    zzo.zza(this, paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.places.internal.PlaceLocalization
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */