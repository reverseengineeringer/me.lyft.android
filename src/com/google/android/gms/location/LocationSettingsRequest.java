package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class LocationSettingsRequest
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<LocationSettingsRequest> CREATOR = new zzg();
  private final List<LocationRequest> PJ;
  private final boolean adk;
  private final boolean adl;
  private final int mVersionCode;
  
  LocationSettingsRequest(int paramInt, List<LocationRequest> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    mVersionCode = paramInt;
    PJ = paramList;
    adk = paramBoolean1;
    adl = paramBoolean2;
  }
  
  private LocationSettingsRequest(List<LocationRequest> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    this(3, paramList, paramBoolean1, paramBoolean2);
  }
  
  public int getVersionCode()
  {
    return mVersionCode;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzg.zza(this, paramParcel, paramInt);
  }
  
  public List<LocationRequest> zzbew()
  {
    return Collections.unmodifiableList(PJ);
  }
  
  public boolean zzbnh()
  {
    return adk;
  }
  
  public boolean zzbni()
  {
    return adl;
  }
  
  public static final class Builder
  {
    private boolean adk = false;
    private boolean adl = false;
    private final ArrayList<LocationRequest> adm = new ArrayList();
    
    public Builder addLocationRequest(LocationRequest paramLocationRequest)
    {
      adm.add(paramLocationRequest);
      return this;
    }
    
    public LocationSettingsRequest build()
    {
      return new LocationSettingsRequest(adm, adk, adl, null);
    }
    
    public Builder setAlwaysShow(boolean paramBoolean)
    {
      adk = paramBoolean;
      return this;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.LocationSettingsRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */