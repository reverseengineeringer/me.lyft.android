package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

@Deprecated
public class ValidateAccountRequest
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<ValidateAccountRequest> CREATOR = new zzaj();
  final int mVersionCode;
  private final Scope[] ro;
  final IBinder wY;
  private final int ze;
  private final Bundle zf;
  private final String zg;
  
  ValidateAccountRequest(int paramInt1, int paramInt2, IBinder paramIBinder, Scope[] paramArrayOfScope, Bundle paramBundle, String paramString)
  {
    mVersionCode = paramInt1;
    ze = paramInt2;
    wY = paramIBinder;
    ro = paramArrayOfScope;
    zf = paramBundle;
    zg = paramString;
  }
  
  public String getCallingPackage()
  {
    return zg;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzaj.zza(this, paramParcel, paramInt);
  }
  
  public Scope[] zzati()
  {
    return ro;
  }
  
  public int zzatk()
  {
    return ze;
  }
  
  public Bundle zzatl()
  {
    return zf;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.internal.ValidateAccountRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */