package com.google.android.gms.playlog.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzab;

public class PlayLoggerContext
  extends AbstractSafeParcelable
{
  public static final zza CREATOR = new zza();
  public final int ash;
  public final int asi;
  public final String asj;
  public final String ask;
  public final boolean asl;
  public final String asm;
  public final boolean asn;
  public final int aso;
  public final String packageName;
  public final int versionCode;
  
  public PlayLoggerContext(int paramInt1, String paramString1, int paramInt2, int paramInt3, String paramString2, String paramString3, boolean paramBoolean1, String paramString4, boolean paramBoolean2, int paramInt4)
  {
    versionCode = paramInt1;
    packageName = paramString1;
    ash = paramInt2;
    asi = paramInt3;
    asj = paramString2;
    ask = paramString3;
    asl = paramBoolean1;
    asm = paramString4;
    asn = paramBoolean2;
    aso = paramInt4;
  }
  
  public PlayLoggerContext(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, String paramString4, boolean paramBoolean, int paramInt3)
  {
    versionCode = 1;
    packageName = ((String)zzab.zzaa(paramString1));
    ash = paramInt1;
    asi = paramInt2;
    asm = paramString2;
    asj = paramString3;
    ask = paramString4;
    if (!paramBoolean) {}
    for (boolean bool = true;; bool = false)
    {
      asl = bool;
      asn = paramBoolean;
      aso = paramInt3;
      return;
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof PlayLoggerContext)) {
        break;
      }
      paramObject = (PlayLoggerContext)paramObject;
    } while ((versionCode == versionCode) && (packageName.equals(packageName)) && (ash == ash) && (asi == asi) && (zzaa.equal(asm, asm)) && (zzaa.equal(asj, asj)) && (zzaa.equal(ask, ask)) && (asl == asl) && (asn == asn) && (aso == aso));
    return false;
    return false;
  }
  
  public int hashCode()
  {
    return zzaa.hashCode(new Object[] { Integer.valueOf(versionCode), packageName, Integer.valueOf(ash), Integer.valueOf(asi), asm, asj, ask, Boolean.valueOf(asl), Boolean.valueOf(asn), Integer.valueOf(aso) });
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PlayLoggerContext[");
    localStringBuilder.append("versionCode=").append(versionCode).append(',');
    localStringBuilder.append("package=").append(packageName).append(',');
    localStringBuilder.append("packageVersionCode=").append(ash).append(',');
    localStringBuilder.append("logSource=").append(asi).append(',');
    localStringBuilder.append("logSourceName=").append(asm).append(',');
    localStringBuilder.append("uploadAccount=").append(asj).append(',');
    localStringBuilder.append("loggingId=").append(ask).append(',');
    localStringBuilder.append("logAndroidId=").append(asl).append(',');
    localStringBuilder.append("isAnonymous=").append(asn).append(',');
    localStringBuilder.append("qosTier=").append(aso);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zza.zza(this, paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.playlog.internal.PlayLoggerContext
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */