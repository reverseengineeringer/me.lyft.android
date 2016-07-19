package com.google.android.gms.measurement.internal;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.measurement.AppMeasurement;

public class zzp
  extends zzaa
{
  private final long ajo = zzbtb().zzbqv();
  private final char akM;
  private final zza akN;
  private final zza akO;
  private final zza akP;
  private final zza akQ;
  private final zza akR;
  private final zza akS;
  private final zza akT;
  private final zza akU;
  private final zza akV;
  private final String yQ = zzbtb().zzbrh();
  
  zzp(zzx paramzzx)
  {
    super(paramzzx);
    if (zzbtb().zzabd())
    {
      if (zzbtb().zzabc()) {}
      for (c = 'P';; c = 'C')
      {
        akM = c;
        akN = new zza(6, false, false);
        akO = new zza(6, true, false);
        akP = new zza(6, false, true);
        akQ = new zza(5, false, false);
        akR = new zza(5, true, false);
        akS = new zza(5, false, true);
        akT = new zza(4, false, false);
        akU = new zza(3, false, false);
        akV = new zza(2, false, false);
        return;
      }
    }
    if (zzbtb().zzabc()) {}
    for (char c = 'p';; c = 'c')
    {
      akM = c;
      break;
    }
  }
  
  static String zza(boolean paramBoolean, String paramString, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    String str1 = paramString;
    if (paramString == null) {
      str1 = "";
    }
    String str2 = zzc(paramBoolean, paramObject1);
    paramObject2 = zzc(paramBoolean, paramObject2);
    paramObject3 = zzc(paramBoolean, paramObject3);
    StringBuilder localStringBuilder = new StringBuilder();
    paramString = "";
    if (!TextUtils.isEmpty(str1))
    {
      localStringBuilder.append(str1);
      paramString = ": ";
    }
    paramObject1 = paramString;
    if (!TextUtils.isEmpty(str2))
    {
      localStringBuilder.append(paramString);
      localStringBuilder.append(str2);
      paramObject1 = ", ";
    }
    paramString = (String)paramObject1;
    if (!TextUtils.isEmpty((CharSequence)paramObject2))
    {
      localStringBuilder.append((String)paramObject1);
      localStringBuilder.append((String)paramObject2);
      paramString = ", ";
    }
    if (!TextUtils.isEmpty((CharSequence)paramObject3))
    {
      localStringBuilder.append(paramString);
      localStringBuilder.append((String)paramObject3);
    }
    return localStringBuilder.toString();
  }
  
  static String zzc(boolean paramBoolean, Object paramObject)
  {
    if (paramObject == null) {
      return "";
    }
    if ((paramObject instanceof Integer)) {
      paramObject = Long.valueOf(((Integer)paramObject).intValue());
    }
    for (;;)
    {
      String str1;
      if ((paramObject instanceof Long))
      {
        if (!paramBoolean) {
          return String.valueOf(paramObject);
        }
        if (Math.abs(((Long)paramObject).longValue()) < 100L) {
          return String.valueOf(paramObject);
        }
        if (String.valueOf(paramObject).charAt(0) == '-') {}
        for (str1 = "-";; str1 = "")
        {
          paramObject = String.valueOf(Math.abs(((Long)paramObject).longValue()));
          long l1 = Math.round(Math.pow(10.0D, ((String)paramObject).length() - 1));
          long l2 = Math.round(Math.pow(10.0D, ((String)paramObject).length()) - 1.0D);
          return String.valueOf(str1).length() + 43 + String.valueOf(str1).length() + str1 + l1 + "..." + str1 + l2;
        }
      }
      if ((paramObject instanceof Boolean)) {
        return String.valueOf(paramObject);
      }
      if ((paramObject instanceof Throwable))
      {
        Object localObject1 = (Throwable)paramObject;
        String str2;
        int i;
        label274:
        Object localObject2;
        if (paramBoolean)
        {
          paramObject = localObject1.getClass().getName();
          paramObject = new StringBuilder((String)paramObject);
          str1 = zzlx(AppMeasurement.class.getCanonicalName());
          str2 = zzlx(zzx.class.getCanonicalName());
          localObject1 = ((Throwable)localObject1).getStackTrace();
          int j = localObject1.length;
          i = 0;
          if (i >= j) {
            break label362;
          }
          localObject2 = localObject1[i];
          if (!((StackTraceElement)localObject2).isNativeMethod()) {
            break label309;
          }
        }
        label309:
        String str3;
        do
        {
          do
          {
            i += 1;
            break label274;
            paramObject = ((Throwable)localObject1).toString();
            break;
            str3 = ((StackTraceElement)localObject2).getClassName();
          } while (str3 == null);
          str3 = zzlx(str3);
        } while ((!str3.equals(str1)) && (!str3.equals(str2)));
        ((StringBuilder)paramObject).append(": ");
        ((StringBuilder)paramObject).append(localObject2);
        label362:
        return ((StringBuilder)paramObject).toString();
      }
      if (paramBoolean) {
        return "-";
      }
      return String.valueOf(paramObject);
    }
  }
  
  private static String zzlx(String paramString)
  {
    String str;
    if (TextUtils.isEmpty(paramString)) {
      str = "";
    }
    int i;
    do
    {
      return str;
      i = paramString.lastIndexOf('.');
      str = paramString;
    } while (i == -1);
    return paramString.substring(0, i);
  }
  
  protected void zza(int paramInt, boolean paramBoolean1, boolean paramBoolean2, String paramString, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    if ((!paramBoolean1) && (zzaz(paramInt))) {
      zzo(paramInt, zza(false, paramString, paramObject1, paramObject2, paramObject3));
    }
    if ((!paramBoolean2) && (paramInt >= 5)) {
      zzb(paramInt, paramString, paramObject1, paramObject2, paramObject3);
    }
  }
  
  protected boolean zzaz(int paramInt)
  {
    return Log.isLoggable(yQ, paramInt);
  }
  
  public void zzb(int paramInt, String paramString, final Object paramObject1, Object paramObject2, Object paramObject3)
  {
    zzab.zzaa(paramString);
    zzw localzzw = aja.zzbum();
    if (localzzw == null)
    {
      zzo(6, "Scheduler not set. Not logging error/warn.");
      return;
    }
    if (!localzzw.isInitialized())
    {
      zzo(6, "Scheduler not initialized. Not logging error/warn.");
      return;
    }
    if (localzzw.zzbvh())
    {
      zzo(6, "Scheduler shutdown. Not logging error/warn.");
      return;
    }
    int i = paramInt;
    if (paramInt < 0) {
      i = 0;
    }
    paramInt = i;
    if (i >= "01VDIWEA?".length()) {
      paramInt = "01VDIWEA?".length() - 1;
    }
    String str = String.valueOf("1");
    char c1 = "01VDIWEA?".charAt(paramInt);
    char c2 = akM;
    long l = ajo;
    paramObject1 = String.valueOf(zza(true, paramString, paramObject1, paramObject2, paramObject3));
    paramObject2 = String.valueOf(str).length() + 23 + String.valueOf(paramObject1).length() + str + c1 + c2 + l + ":" + (String)paramObject1;
    paramObject1 = paramObject2;
    if (((String)paramObject2).length() > 1024) {
      paramObject1 = paramString.substring(0, 1024);
    }
    localzzw.zzl(new Runnable()
    {
      public void run()
      {
        zzt localzzt = aja.zzbta();
        if ((!localzzt.isInitialized()) || (localzzt.zzbvh()))
        {
          zzo(6, "Persisted config not initialized . Not logging error/warn.");
          return;
        }
        alu.zzew(paramObject1);
      }
    });
  }
  
  public zza zzbtr()
  {
    return akN;
  }
  
  public zza zzbts()
  {
    return akO;
  }
  
  public zza zzbtt()
  {
    return akQ;
  }
  
  public zza zzbtu()
  {
    return akR;
  }
  
  public zza zzbtv()
  {
    return akS;
  }
  
  public zza zzbtw()
  {
    return akT;
  }
  
  public zza zzbtx()
  {
    return akU;
  }
  
  public zza zzbty()
  {
    return akV;
  }
  
  public String zzbtz()
  {
    Object localObject = zzbtaalu.zzadv();
    if ((localObject == null) || (localObject == zzt.alt)) {
      return null;
    }
    String str = String.valueOf(String.valueOf(second));
    localObject = (String)first;
    return String.valueOf(str).length() + 1 + String.valueOf(localObject).length() + str + ":" + (String)localObject;
  }
  
  protected void zzo(int paramInt, String paramString)
  {
    Log.println(paramInt, yQ, paramString);
  }
  
  protected void zzwv() {}
  
  public class zza
  {
    private final boolean akY;
    private final boolean akZ;
    private final int mPriority;
    
    zza(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
    {
      mPriority = paramInt;
      akY = paramBoolean1;
      akZ = paramBoolean2;
    }
    
    public void log(String paramString)
    {
      zza(mPriority, akY, akZ, paramString, null, null, null);
    }
    
    public void zzd(String paramString, Object paramObject1, Object paramObject2, Object paramObject3)
    {
      zza(mPriority, akY, akZ, paramString, paramObject1, paramObject2, paramObject3);
    }
    
    public void zze(String paramString, Object paramObject1, Object paramObject2)
    {
      zza(mPriority, akY, akZ, paramString, paramObject1, paramObject2, null);
    }
    
    public void zzj(String paramString, Object paramObject)
    {
      zza(mPriority, akY, akZ, paramString, paramObject, null, null);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.measurement.internal.zzp
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */