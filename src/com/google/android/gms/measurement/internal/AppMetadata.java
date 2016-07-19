package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzab;

public class AppMetadata
  extends AbstractSafeParcelable
{
  public static final zzb CREATOR = new zzb();
  public final String abU;
  public final String ajA;
  public final long ajB;
  public final long ajC;
  public final String ajD;
  public final boolean ajE;
  public final boolean ajF;
  public final long ajG;
  public final String ajH;
  public final String ajz;
  public final String packageName;
  public final int versionCode;
  
  AppMetadata(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, long paramLong1, long paramLong2, String paramString5, boolean paramBoolean1, boolean paramBoolean2, long paramLong3, String paramString6)
  {
    versionCode = paramInt;
    packageName = paramString1;
    ajz = paramString2;
    abU = paramString3;
    if (paramInt >= 5)
    {
      ajG = paramLong3;
      ajA = paramString4;
      ajB = paramLong1;
      ajC = paramLong2;
      ajD = paramString5;
      if (paramInt < 3) {
        break label92;
      }
    }
    label92:
    for (ajE = paramBoolean1;; ajE = true)
    {
      ajF = paramBoolean2;
      ajH = paramString6;
      return;
      paramLong3 = -2147483648L;
      break;
    }
  }
  
  AppMetadata(String paramString1, String paramString2, String paramString3, long paramLong1, String paramString4, long paramLong2, long paramLong3, String paramString5, boolean paramBoolean1, boolean paramBoolean2, String paramString6)
  {
    zzab.zzhs(paramString1);
    versionCode = 6;
    packageName = paramString1;
    paramString1 = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      paramString1 = null;
    }
    ajz = paramString1;
    abU = paramString3;
    ajG = paramLong1;
    ajA = paramString4;
    ajB = paramLong2;
    ajC = paramLong3;
    ajD = paramString5;
    ajE = paramBoolean1;
    ajF = paramBoolean2;
    ajH = paramString6;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzb.zza(this, paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.measurement.internal.AppMetadata
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */