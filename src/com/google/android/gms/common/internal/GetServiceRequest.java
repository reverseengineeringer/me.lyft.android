package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.zzc;
import java.util.Collection;

public class GetServiceRequest
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<GetServiceRequest> CREATOR = new zzj();
  final int version;
  final int yi;
  int yj;
  String yk;
  IBinder yl;
  Scope[] ym;
  Bundle yn;
  Account yo;
  long yp;
  
  public GetServiceRequest(int paramInt)
  {
    version = 3;
    yj = zzc.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    yi = paramInt;
  }
  
  GetServiceRequest(int paramInt1, int paramInt2, int paramInt3, String paramString, IBinder paramIBinder, Scope[] paramArrayOfScope, Bundle paramBundle, Account paramAccount, long paramLong)
  {
    version = paramInt1;
    yi = paramInt2;
    yj = paramInt3;
    yk = paramString;
    if (paramInt1 < 2) {}
    for (yo = zzdo(paramIBinder);; yo = paramAccount)
    {
      ym = paramArrayOfScope;
      yn = paramBundle;
      yp = paramLong;
      return;
      yl = paramIBinder;
    }
  }
  
  private Account zzdo(IBinder paramIBinder)
  {
    Account localAccount = null;
    if (paramIBinder != null) {
      localAccount = zza.zza(zzq.zza.zzdp(paramIBinder));
    }
    return localAccount;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzj.zza(this, paramParcel, paramInt);
  }
  
  public GetServiceRequest zzb(zzq paramzzq)
  {
    if (paramzzq != null) {
      yl = paramzzq.asBinder();
    }
    return this;
  }
  
  public GetServiceRequest zzd(Account paramAccount)
  {
    yo = paramAccount;
    return this;
  }
  
  public GetServiceRequest zzf(Collection<Scope> paramCollection)
  {
    ym = ((Scope[])paramCollection.toArray(new Scope[paramCollection.size()]));
    return this;
  }
  
  public GetServiceRequest zzhm(String paramString)
  {
    yk = paramString;
    return this;
  }
  
  public GetServiceRequest zzn(Bundle paramBundle)
  {
    yn = paramBundle;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.internal.GetServiceRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */