package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public class SignInResponse
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<SignInResponse> CREATOR = new zzi();
  private final ResolveAccountResponse auy;
  final int mVersionCode;
  private final ConnectionResult rv;
  
  public SignInResponse(int paramInt)
  {
    this(new ConnectionResult(paramInt, null), null);
  }
  
  SignInResponse(int paramInt, ConnectionResult paramConnectionResult, ResolveAccountResponse paramResolveAccountResponse)
  {
    mVersionCode = paramInt;
    rv = paramConnectionResult;
    auy = paramResolveAccountResponse;
  }
  
  public SignInResponse(ConnectionResult paramConnectionResult, ResolveAccountResponse paramResolveAccountResponse)
  {
    this(1, paramConnectionResult, paramResolveAccountResponse);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzi.zza(this, paramParcel, paramInt);
  }
  
  public ConnectionResult zzatd()
  {
    return rv;
  }
  
  public ResolveAccountResponse zzbzv()
  {
    return auy;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.signin.internal.SignInResponse
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */