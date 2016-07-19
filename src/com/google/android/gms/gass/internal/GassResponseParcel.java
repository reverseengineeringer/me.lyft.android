package com.google.android.gms.gass.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.zzae.zza;
import com.google.android.gms.internal.zzapb;
import com.google.android.gms.internal.zzapc;

public final class GassResponseParcel
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<GassResponseParcel> CREATOR = new zzd();
  private zzae.zza aaw;
  private byte[] aax;
  public final int versionCode;
  
  GassResponseParcel(int paramInt, byte[] paramArrayOfByte)
  {
    versionCode = paramInt;
    aaw = null;
    aax = paramArrayOfByte;
    zzawr();
  }
  
  private void zzawp()
  {
    if (!zzawq()) {}
    try
    {
      aaw = zzae.zza.zzc(aax);
      aax = null;
      zzawr();
      return;
    }
    catch (zzapb localzzapb)
    {
      throw new IllegalStateException(localzzapb);
    }
  }
  
  private boolean zzawq()
  {
    return aaw != null;
  }
  
  private void zzawr()
  {
    if ((aaw == null) && (aax != null)) {}
    while ((aaw != null) && (aax == null)) {
      return;
    }
    if ((aaw != null) && (aax != null)) {
      throw new IllegalStateException("Invalid internal representation - full");
    }
    if ((aaw == null) && (aax == null)) {
      throw new IllegalStateException("Invalid internal representation - empty");
    }
    throw new IllegalStateException("Impossible");
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzd.zza(this, paramParcel, paramInt);
  }
  
  public byte[] zzblz()
  {
    if (aax != null) {
      return aax;
    }
    return zzapc.zzf(aaw);
  }
  
  public zzae.zza zzbma()
  {
    zzawp();
    return aaw;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.gass.internal.GassResponseParcel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */