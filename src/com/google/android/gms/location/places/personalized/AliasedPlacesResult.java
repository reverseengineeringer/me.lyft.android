package com.google.android.gms.location.places.personalized;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public class AliasedPlacesResult
  implements Result, SafeParcelable
{
  public static final Parcelable.Creator<AliasedPlacesResult> CREATOR = new zzb();
  private final List<AliasedPlace> agi;
  private final Status cc;
  final int mVersionCode;
  
  AliasedPlacesResult(int paramInt, Status paramStatus, List<AliasedPlace> paramList)
  {
    mVersionCode = paramInt;
    cc = paramStatus;
    agi = paramList;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public Status getStatus()
  {
    return cc;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzb.zza(this, paramParcel, paramInt);
  }
  
  public List<AliasedPlace> zzbpb()
  {
    return agi;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.places.personalized.AliasedPlacesResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */