package com.google.android.gms.clearcut;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.internal.zzapg.zzd;
import com.google.android.gms.playlog.internal.PlayLoggerContext;
import java.util.Arrays;

public class LogEventParcelable
  extends AbstractSafeParcelable
{
  public static final zzd CREATOR = new zzd();
  public PlayLoggerContext qk;
  public byte[] ql;
  public int[] qm;
  public String[] qn;
  public int[] qo;
  public byte[][] qp;
  public boolean qq;
  public final zzapg.zzd qr;
  public final zzb.zzc qs;
  public final zzb.zzc qt;
  public final int versionCode;
  
  LogEventParcelable(int paramInt, PlayLoggerContext paramPlayLoggerContext, byte[] paramArrayOfByte, int[] paramArrayOfInt1, String[] paramArrayOfString, int[] paramArrayOfInt2, byte[][] paramArrayOfByte1, boolean paramBoolean)
  {
    versionCode = paramInt;
    qk = paramPlayLoggerContext;
    ql = paramArrayOfByte;
    qm = paramArrayOfInt1;
    qn = paramArrayOfString;
    qr = null;
    qs = null;
    qt = null;
    qo = paramArrayOfInt2;
    qp = paramArrayOfByte1;
    qq = paramBoolean;
  }
  
  public LogEventParcelable(PlayLoggerContext paramPlayLoggerContext, zzapg.zzd paramzzd, zzb.zzc paramzzc1, zzb.zzc paramzzc2, int[] paramArrayOfInt1, String[] paramArrayOfString, int[] paramArrayOfInt2, byte[][] paramArrayOfByte, boolean paramBoolean)
  {
    versionCode = 1;
    qk = paramPlayLoggerContext;
    qr = paramzzd;
    qs = paramzzc1;
    qt = paramzzc2;
    qm = paramArrayOfInt1;
    qn = paramArrayOfString;
    qo = paramArrayOfInt2;
    qp = paramArrayOfByte;
    qq = paramBoolean;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof LogEventParcelable)) {
        break;
      }
      paramObject = (LogEventParcelable)paramObject;
    } while ((versionCode == versionCode) && (zzaa.equal(qk, qk)) && (Arrays.equals(ql, ql)) && (Arrays.equals(qm, qm)) && (Arrays.equals(qn, qn)) && (zzaa.equal(qr, qr)) && (zzaa.equal(qs, qs)) && (zzaa.equal(qt, qt)) && (Arrays.equals(qo, qo)) && (Arrays.deepEquals(qp, qp)) && (qq == qq));
    return false;
    return false;
  }
  
  public int hashCode()
  {
    return zzaa.hashCode(new Object[] { Integer.valueOf(versionCode), qk, ql, qm, qn, qr, qs, qt, qo, qp, Boolean.valueOf(qq) });
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("LogEventParcelable[").append(versionCode).append(", ").append(qk).append(", ").append("LogEventBytes: ");
    if (ql == null) {}
    for (String str = null;; str = new String(ql)) {
      return str + ", " + "TestCodes: " + Arrays.toString(qm) + ", " + "MendelPackages: " + Arrays.toString(qn) + ", " + "LogEvent: " + qr + ", " + "ExtensionProducer: " + qs + ", " + "VeProducer: " + qt + ", " + "ExperimentIDs: " + Arrays.toString(qo) + ", " + "ExperimentTokens: " + Arrays.toString(qp) + ", " + "AddPhenotypeExperimentTokens: " + qq + "]";
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzd.zza(this, paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.clearcut.LogEventParcelable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */