package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzab;

public class UserAttributeParcel
  extends AbstractSafeParcelable
{
  public static final zzaj CREATOR = new zzaj();
  public final String akg;
  public final long anQ;
  public final Long anR;
  public final Float anS;
  public final Double anT;
  public final String name;
  public final int versionCode;
  public final String zr;
  
  UserAttributeParcel(int paramInt, String paramString1, long paramLong, Long paramLong1, Float paramFloat, String paramString2, String paramString3, Double paramDouble)
  {
    versionCode = paramInt;
    name = paramString1;
    anQ = paramLong;
    anR = paramLong1;
    anS = null;
    if (paramInt == 1)
    {
      paramString1 = (String)localObject;
      if (paramFloat != null) {
        paramString1 = Double.valueOf(paramFloat.doubleValue());
      }
    }
    for (anT = paramString1;; anT = paramDouble)
    {
      zr = paramString2;
      akg = paramString3;
      return;
    }
  }
  
  UserAttributeParcel(zzak paramzzak)
  {
    this(mName, anU, zzcnr, zzcjj);
  }
  
  UserAttributeParcel(String paramString1, long paramLong, Object paramObject, String paramString2)
  {
    zzab.zzhs(paramString1);
    versionCode = 2;
    name = paramString1;
    anQ = paramLong;
    akg = paramString2;
    if (paramObject == null)
    {
      anR = null;
      anS = null;
      anT = null;
      zr = null;
      return;
    }
    if ((paramObject instanceof Long))
    {
      anR = ((Long)paramObject);
      anS = null;
      anT = null;
      zr = null;
      return;
    }
    if ((paramObject instanceof String))
    {
      anR = null;
      anS = null;
      anT = null;
      zr = ((String)paramObject);
      return;
    }
    if ((paramObject instanceof Double))
    {
      anR = null;
      anS = null;
      anT = ((Double)paramObject);
      zr = null;
      return;
    }
    throw new IllegalArgumentException("User attribute given of un-supported type");
  }
  
  public Object getValue()
  {
    if (anR != null) {
      return anR;
    }
    if (anT != null) {
      return anT;
    }
    if (zr != null) {
      return zr;
    }
    return null;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzaj.zza(this, paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.measurement.internal.UserAttributeParcel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */