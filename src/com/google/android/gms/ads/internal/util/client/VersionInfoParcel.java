package com.google.android.gms.ads.internal.util.client;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.zzir;

@zzir
public final class VersionInfoParcel
  extends AbstractSafeParcelable
{
  public static final zzd CREATOR = new zzd();
  public final int versionCode;
  public int zzcno;
  public int zzcnp;
  public boolean zzcnq;
  public String zzcs;
  
  public VersionInfoParcel(int paramInt1, int paramInt2, boolean paramBoolean) {}
  
  VersionInfoParcel(int paramInt1, String paramString, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    versionCode = paramInt1;
    zzcs = paramString;
    zzcno = paramInt2;
    zzcnp = paramInt3;
    zzcnq = paramBoolean;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzd.zza(this, paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.util.client.VersionInfoParcel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */