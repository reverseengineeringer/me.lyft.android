package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public class SignInRequest
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<SignInRequest> CREATOR = new zzh();
  final ResolveAccountRequest aux;
  final int mVersionCode;
  
  SignInRequest(int paramInt, ResolveAccountRequest paramResolveAccountRequest)
  {
    mVersionCode = paramInt;
    aux = paramResolveAccountRequest;
  }
  
  public SignInRequest(ResolveAccountRequest paramResolveAccountRequest)
  {
    this(1, paramResolveAccountRequest);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzh.zza(this, paramParcel, paramInt);
  }
  
  public ResolveAccountRequest zzbzu()
  {
    return aux;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.signin.internal.SignInRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */