package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public final class IsReadyToPayRequest
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<IsReadyToPayRequest> CREATOR = new zzi();
  final int mVersionCode;
  
  IsReadyToPayRequest()
  {
    mVersionCode = 1;
  }
  
  IsReadyToPayRequest(int paramInt)
  {
    mVersionCode = paramInt;
  }
  
  public static zza zzchz()
  {
    IsReadyToPayRequest localIsReadyToPayRequest = new IsReadyToPayRequest();
    localIsReadyToPayRequest.getClass();
    return new zza(null);
  }
  
  public int getVersionCode()
  {
    return mVersionCode;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzi.zza(this, paramParcel, paramInt);
  }
  
  public final class zza
  {
    private zza() {}
    
    public IsReadyToPayRequest zzcia()
    {
      return IsReadyToPayRequest.this;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wallet.IsReadyToPayRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */