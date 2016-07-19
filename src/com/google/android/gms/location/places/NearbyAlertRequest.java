package com.google.android.gms.location.places;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzaa.zza;
import java.util.Set;

public final class NearbyAlertRequest
  extends AbstractSafeParcelable
{
  public static final zze CREATOR = new zze();
  private final int acH;
  private final int aev;
  @Deprecated
  private final PlaceFilter aew;
  private final NearbyAlertFilter aex;
  private final boolean aey;
  private final int aez;
  private int mPriority = 110;
  private final int mVersionCode;
  
  NearbyAlertRequest(int paramInt1, int paramInt2, int paramInt3, PlaceFilter paramPlaceFilter, NearbyAlertFilter paramNearbyAlertFilter, boolean paramBoolean, int paramInt4, int paramInt5)
  {
    mVersionCode = paramInt1;
    acH = paramInt2;
    aev = paramInt3;
    if (paramNearbyAlertFilter != null) {
      aex = paramNearbyAlertFilter;
    }
    for (;;)
    {
      aew = null;
      aey = paramBoolean;
      aez = paramInt4;
      mPriority = paramInt5;
      return;
      if (paramPlaceFilter != null)
      {
        if ((paramPlaceFilter.getPlaceIds() != null) && (!paramPlaceFilter.getPlaceIds().isEmpty())) {
          aex = NearbyAlertFilter.zzm(paramPlaceFilter.getPlaceIds());
        } else if ((paramPlaceFilter.zzbob() != null) && (!paramPlaceFilter.zzbob().isEmpty())) {
          aex = NearbyAlertFilter.zzn(paramPlaceFilter.zzbob());
        } else {
          aex = null;
        }
      }
      else {
        aex = null;
      }
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof NearbyAlertRequest)) {
        return false;
      }
      paramObject = (NearbyAlertRequest)paramObject;
    } while ((acH == acH) && (aev == aev) && (zzaa.equal(aex, aex)) && (mPriority == mPriority));
    return false;
  }
  
  public int getPriority()
  {
    return mPriority;
  }
  
  public int getVersionCode()
  {
    return mVersionCode;
  }
  
  public int hashCode()
  {
    return zzaa.hashCode(new Object[] { Integer.valueOf(acH), Integer.valueOf(aev), aex, Integer.valueOf(mPriority) });
  }
  
  public String toString()
  {
    return zzaa.zzz(this).zzg("transitionTypes", Integer.valueOf(acH)).zzg("loiteringTimeMillis", Integer.valueOf(aev)).zzg("nearbyAlertFilter", aex).zzg("priority", Integer.valueOf(mPriority)).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zze.zza(this, paramParcel, paramInt);
  }
  
  public int zzbns()
  {
    return acH;
  }
  
  public int zzbnw()
  {
    return aev;
  }
  
  @Deprecated
  public PlaceFilter zzbnx()
  {
    return null;
  }
  
  public NearbyAlertFilter zzbny()
  {
    return aex;
  }
  
  public boolean zzbnz()
  {
    return aey;
  }
  
  public int zzboa()
  {
    return aez;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.places.NearbyAlertRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */