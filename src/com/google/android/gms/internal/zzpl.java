package com.google.android.gms.internal;

import android.content.ContentResolver;
import android.content.Context;
import android.util.Log;
import com.google.android.gms.clearcut.zzb.zzb;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzab;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public class zzpl
  implements zzb.zzb
{
  private static final Charset UTF_8 = Charset.forName("UTF-8");
  static Boolean qK = null;
  final zza qL;
  
  public zzpl()
  {
    this(new zza(null));
  }
  
  public zzpl(Context paramContext)
  {
    this(new zza(paramContext));
  }
  
  zzpl(zza paramzza)
  {
    qL = ((zza)zzab.zzaa(paramzza));
  }
  
  static boolean zza(long paramLong1, long paramLong2, long paramLong3)
  {
    if ((paramLong2 < 0L) || (paramLong3 < 0L)) {
      throw new IllegalArgumentException(72 + "negative values not supported: " + paramLong2 + "/" + paramLong3);
    }
    return (paramLong3 > 0L) && (zzpm.zzd(paramLong1, paramLong3) < paramLong2);
  }
  
  static long zzag(long paramLong)
  {
    return zzpi.zzm(ByteBuffer.allocate(8).putLong(paramLong).array());
  }
  
  static long zzd(String paramString, long paramLong)
  {
    if ((paramString == null) || (paramString.isEmpty())) {
      return zzag(paramLong);
    }
    paramString = paramString.getBytes(UTF_8);
    ByteBuffer localByteBuffer = ByteBuffer.allocate(paramString.length + 8);
    localByteBuffer.put(paramString);
    localByteBuffer.putLong(paramLong);
    return zzpi.zzm(localByteBuffer.array());
  }
  
  static zzb zzgu(String paramString)
  {
    int i = 0;
    if (paramString == null) {
      return null;
    }
    String str = "";
    int j = paramString.indexOf(',');
    if (j >= 0)
    {
      str = paramString.substring(0, j);
      i = j + 1;
    }
    j = paramString.indexOf('/', i);
    if (j <= 0)
    {
      paramString = String.valueOf(paramString);
      if (paramString.length() != 0) {}
      for (paramString = "Failed to parse the rule: ".concat(paramString);; paramString = new String("Failed to parse the rule: "))
      {
        Log.e("LogSamplerImpl", paramString);
        return null;
      }
    }
    try
    {
      l1 = Long.parseLong(paramString.substring(i, j));
      l2 = Long.parseLong(paramString.substring(j + 1));
      if ((l1 < 0L) || (l2 < 0L))
      {
        Log.e("LogSamplerImpl", 72 + "negative values not supported: " + l1 + "/" + l2);
        return null;
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      long l1;
      long l2;
      paramString = String.valueOf(paramString);
      if (paramString.length() != 0) {}
      for (paramString = "parseLong() failed while parsing: ".concat(paramString);; paramString = new String("parseLong() failed while parsing: "))
      {
        Log.e("LogSamplerImpl", paramString, localNumberFormatException);
        return null;
      }
      return new zzb(localNumberFormatException, l1, l2);
    }
  }
  
  public boolean zzg(String paramString, int paramInt)
  {
    if ((paramString != null) && (!paramString.isEmpty())) {}
    for (;;)
    {
      if (paramString == null) {}
      long l;
      do
      {
        return true;
        if (paramInt < 0) {
          break label73;
        }
        paramString = String.valueOf(paramInt);
        break;
        l = qL.zzanb();
        paramString = zzgu(qL.zzgv(paramString));
      } while (paramString == null);
      return zza(zzd(qM, l), qN, qO);
      label73:
      paramString = null;
    }
  }
  
  static class zza
  {
    final ContentResolver mContentResolver;
    
    zza(Context paramContext)
    {
      if ((paramContext == null) || (!zzbm(paramContext)))
      {
        mContentResolver = null;
        return;
      }
      mContentResolver = paramContext.getContentResolver();
      zzaer.zzb(mContentResolver, new String[] { "gms:playlog:service:sampling_" });
    }
    
    private String getString(String paramString1, String paramString2)
    {
      if (mContentResolver == null) {
        return paramString2;
      }
      return zzaer.zza(mContentResolver, paramString1, paramString2);
    }
    
    private static boolean zzbm(Context paramContext)
    {
      if (zzpl.qK == null) {
        if (paramContext.checkCallingOrSelfPermission("com.google.android.providers.gsf.permission.READ_GSERVICES") != 0) {
          break label31;
        }
      }
      label31:
      for (boolean bool = true;; bool = false)
      {
        zzpl.qK = Boolean.valueOf(bool);
        return zzpl.qK.booleanValue();
      }
    }
    
    long zzanb()
    {
      if (mContentResolver == null) {
        return 0L;
      }
      return zzaer.getLong(mContentResolver, "android_id", 0L);
    }
    
    String zzgv(String paramString)
    {
      String str = String.valueOf("gms:playlog:service:sampling_");
      paramString = String.valueOf(paramString);
      if (paramString.length() != 0) {}
      for (paramString = str.concat(paramString);; paramString = new String(str)) {
        return getString(paramString, null);
      }
    }
  }
  
  static class zzb
  {
    public final String qM;
    public final long qN;
    public final long qO;
    
    public zzb(String paramString, long paramLong1, long paramLong2)
    {
      qM = paramString;
      qN = paramLong1;
      qO = paramLong2;
    }
    
    public boolean equals(Object paramObject)
    {
      if (paramObject == this) {}
      do
      {
        return true;
        if (!(paramObject instanceof zzb)) {
          return false;
        }
        paramObject = (zzb)paramObject;
      } while ((zzaa.equal(qM, qM)) && (zzaa.equal(Long.valueOf(qN), Long.valueOf(qN))) && (zzaa.equal(Long.valueOf(qO), Long.valueOf(qO))));
      return false;
    }
    
    public int hashCode()
    {
      return zzaa.hashCode(new Object[] { qM, Long.valueOf(qN), Long.valueOf(qO) });
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */