package com.google.android.gms.location.places;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzaa.zza;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public final class PlaceFilter
  extends zza
  implements SafeParcelable
{
  public static final zzg CREATOR = new zzg();
  private static final PlaceFilter aeD = new PlaceFilter();
  final boolean aeE;
  final List<String> aen;
  final List<Integer> aeo;
  final List<UserDataType> aep;
  private final Set<String> aes;
  private final Set<Integer> aet;
  private final Set<UserDataType> aeu;
  final int mVersionCode;
  
  public PlaceFilter()
  {
    this(false, null);
  }
  
  PlaceFilter(int paramInt, List<Integer> paramList, boolean paramBoolean, List<String> paramList1, List<UserDataType> paramList2)
  {
    mVersionCode = paramInt;
    if (paramList == null)
    {
      paramList = Collections.emptyList();
      aeo = paramList;
      aeE = paramBoolean;
      if (paramList2 != null) {
        break label97;
      }
      paramList = Collections.emptyList();
      label36:
      aep = paramList;
      if (paramList1 != null) {
        break label106;
      }
    }
    label97:
    label106:
    for (paramList = Collections.emptyList();; paramList = Collections.unmodifiableList(paramList1))
    {
      aen = paramList;
      aet = zzz(aeo);
      aeu = zzz(aep);
      aes = zzz(aen);
      return;
      paramList = Collections.unmodifiableList(paramList);
      break;
      paramList = Collections.unmodifiableList(paramList2);
      break label36;
    }
  }
  
  public PlaceFilter(Collection<Integer> paramCollection, boolean paramBoolean, Collection<String> paramCollection1, Collection<UserDataType> paramCollection2)
  {
    this(0, zzk(paramCollection), paramBoolean, zzk(paramCollection1), zzk(paramCollection2));
  }
  
  public PlaceFilter(boolean paramBoolean, Collection<String> paramCollection)
  {
    this(null, paramBoolean, paramCollection, null);
  }
  
  @Deprecated
  public static PlaceFilter zzboc()
  {
    return new zza(null).zzbod();
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
      if (!(paramObject instanceof PlaceFilter)) {
        return false;
      }
      paramObject = (PlaceFilter)paramObject;
    } while ((aet.equals(aet)) && (aeE == aeE) && (aeu.equals(aeu)) && (aes.equals(aes)));
    return false;
  }
  
  public Set<String> getPlaceIds()
  {
    return aes;
  }
  
  public int hashCode()
  {
    return zzaa.hashCode(new Object[] { aet, Boolean.valueOf(aeE), aeu, aes });
  }
  
  public String toString()
  {
    zzaa.zza localzza = zzaa.zzz(this);
    if (!aet.isEmpty()) {
      localzza.zzg("types", aet);
    }
    localzza.zzg("requireOpenNow", Boolean.valueOf(aeE));
    if (!aes.isEmpty()) {
      localzza.zzg("placeIds", aes);
    }
    if (!aeu.isEmpty()) {
      localzza.zzg("requestedUserDataTypes", aeu);
    }
    return localzza.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzg.zza(this, paramParcel, paramInt);
  }
  
  public Set<Integer> zzbob()
  {
    return aet;
  }
  
  @Deprecated
  public static final class zza
  {
    private boolean aeE = false;
    private Collection<Integer> aeF = null;
    private Collection<UserDataType> aeG = null;
    private String[] aeH = null;
    
    public PlaceFilter zzbod()
    {
      return new PlaceFilter(null, false, null, null);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.places.PlaceFilter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */