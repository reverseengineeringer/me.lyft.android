package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzab;

public final class Scope
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<Scope> CREATOR = new zze();
  final int mVersionCode;
  private final String sf;
  
  Scope(int paramInt, String paramString)
  {
    zzab.zzh(paramString, "scopeUri must not be null or empty");
    mVersionCode = paramInt;
    sf = paramString;
  }
  
  public Scope(String paramString)
  {
    this(1, paramString);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof Scope)) {
      return false;
    }
    return sf.equals(sf);
  }
  
  public int hashCode()
  {
    return sf.hashCode();
  }
  
  public String toString()
  {
    return sf;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zze.zza(this, paramParcel, paramInt);
  }
  
  public String zzaoh()
  {
    return sf;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.api.Scope
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */