package com.google.android.gms.location.places;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzaa.zza;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public final class NearbyAlertFilter
  extends zza
  implements SafeParcelable
{
  public static final zzd CREATOR = new zzd();
  final List<String> aen;
  final List<Integer> aeo;
  final List<UserDataType> aep;
  final String aeq;
  final boolean aer;
  private final Set<String> aes;
  private final Set<Integer> aet;
  private final Set<UserDataType> aeu;
  final int mVersionCode;
  
  NearbyAlertFilter(int paramInt, List<String> paramList, List<Integer> paramList1, List<UserDataType> paramList2, String paramString, boolean paramBoolean)
  {
    mVersionCode = paramInt;
    if (paramList1 == null)
    {
      paramList1 = Collections.emptyList();
      aeo = paramList1;
      if (paramList2 != null) {
        break label103;
      }
      paramList1 = Collections.emptyList();
      label31:
      aep = paramList1;
      if (paramList != null) {
        break label112;
      }
    }
    label103:
    label112:
    for (paramList = Collections.emptyList();; paramList = Collections.unmodifiableList(paramList))
    {
      aen = paramList;
      aet = zzz(aeo);
      aeu = zzz(aep);
      aes = zzz(aen);
      aeq = paramString;
      aer = paramBoolean;
      return;
      paramList1 = Collections.unmodifiableList(paramList1);
      break;
      paramList1 = Collections.unmodifiableList(paramList2);
      break label31;
    }
  }
  
  public static NearbyAlertFilter zzm(Collection<String> paramCollection)
  {
    if ((paramCollection == null) || (paramCollection.isEmpty())) {
      throw new IllegalArgumentException("NearbyAlertFilters must contain at least oneplace ID to match results with.");
    }
    return new NearbyAlertFilter(0, zzk(paramCollection), null, null, null, false);
  }
  
  public static NearbyAlertFilter zzn(Collection<Integer> paramCollection)
  {
    if ((paramCollection == null) || (paramCollection.isEmpty())) {
      throw new IllegalArgumentException("NearbyAlertFilters must contain at least oneplace type to match results with.");
    }
    return new NearbyAlertFilter(0, null, zzk(paramCollection), null, null, false);
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
      if (!(paramObject instanceof NearbyAlertFilter)) {
        return false;
      }
      paramObject = (NearbyAlertFilter)paramObject;
      if ((aeq == null) && (aeq != null)) {
        return false;
      }
    } while ((aet.equals(aet)) && (aeu.equals(aeu)) && (aes.equals(aes)) && ((aeq == null) || (aeq.equals(aeq))) && (aer == ((NearbyAlertFilter)paramObject).zzbnv()));
    return false;
  }
  
  public int hashCode()
  {
    return zzaa.hashCode(new Object[] { aet, aeu, aes, aeq, Boolean.valueOf(aer) });
  }
  
  public String toString()
  {
    zzaa.zza localzza = zzaa.zzz(this);
    if (!aet.isEmpty()) {
      localzza.zzg("types", aet);
    }
    if (!aes.isEmpty()) {
      localzza.zzg("placeIds", aes);
    }
    if (!aeu.isEmpty()) {
      localzza.zzg("requestedUserDataTypes", aeu);
    }
    if (aeq != null) {
      localzza.zzg("chainName", aeq);
    }
    localzza.zzg("Beacon required: ", Boolean.valueOf(aer));
    return localzza.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzd.zza(this, paramParcel, paramInt);
  }
  
  public boolean zzbnv()
  {
    return aer;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.places.NearbyAlertFilter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */