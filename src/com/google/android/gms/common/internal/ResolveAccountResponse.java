package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public class ResolveAccountResponse
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<ResolveAccountResponse> CREATOR = new zzad();
  final int mVersionCode;
  private ConnectionResult rv;
  private boolean tB;
  IBinder wY;
  private boolean yX;
  
  ResolveAccountResponse(int paramInt, IBinder paramIBinder, ConnectionResult paramConnectionResult, boolean paramBoolean1, boolean paramBoolean2)
  {
    mVersionCode = paramInt;
    wY = paramIBinder;
    rv = paramConnectionResult;
    tB = paramBoolean1;
    yX = paramBoolean2;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof ResolveAccountResponse)) {
        return false;
      }
      paramObject = (ResolveAccountResponse)paramObject;
    } while ((rv.equals(rv)) && (zzatc().equals(((ResolveAccountResponse)paramObject).zzatc())));
    return false;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzad.zza(this, paramParcel, paramInt);
  }
  
  public zzq zzatc()
  {
    return zzq.zza.zzdp(wY);
  }
  
  public ConnectionResult zzatd()
  {
    return rv;
  }
  
  public boolean zzate()
  {
    return tB;
  }
  
  public boolean zzatf()
  {
    return yX;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.internal.ResolveAccountResponse
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */