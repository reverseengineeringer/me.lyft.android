package com.google.android.gms.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.WorkSource;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.stats.zzf;
import com.google.android.gms.common.stats.zzh;
import com.google.android.gms.common.util.zzs;
import com.google.android.gms.common.util.zzw;
import com.google.android.gms.common.util.zzz;

public class zzvz
{
  private static boolean DEBUG = false;
  private static String TAG = "WakeLock";
  private static String auz = "*gcore*:";
  private final String AA;
  private final String Ay;
  private WorkSource acv;
  private final PowerManager.WakeLock auA;
  private final int auB;
  private final String auC;
  private boolean auD = true;
  private int auE;
  private int auF;
  private final Context mContext;
  
  public zzvz(Context paramContext, int paramInt, String paramString) {}
  
  @SuppressLint({"UnwrappedWakeLock"})
  public zzvz(Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3)
  {
    this(paramContext, paramInt, paramString1, paramString2, paramString3, null);
  }
  
  @SuppressLint({"UnwrappedWakeLock"})
  public zzvz(Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    zzab.zzh(paramString1, "Wake lock name can NOT be empty");
    auB = paramInt;
    auC = paramString2;
    AA = paramString4;
    mContext = paramContext.getApplicationContext();
    if (!"com.google.android.gms".equals(paramContext.getPackageName()))
    {
      paramString2 = String.valueOf(auz);
      paramString4 = String.valueOf(paramString1);
      if (paramString4.length() != 0) {
        paramString2 = paramString2.concat(paramString4);
      }
    }
    for (Ay = paramString2;; Ay = paramString1)
    {
      auA = ((PowerManager)paramContext.getSystemService("power")).newWakeLock(paramInt, paramString1);
      if (zzz.zzco(mContext))
      {
        paramString1 = paramString3;
        if (zzw.zzic(paramString3)) {
          paramString1 = paramContext.getPackageName();
        }
        acv = zzz.zzr(paramContext, paramString1);
        zzc(acv);
      }
      return;
      paramString2 = new String(paramString2);
      break;
    }
  }
  
  private void zzd(WorkSource paramWorkSource)
  {
    try
    {
      auA.setWorkSource(paramWorkSource);
      return;
    }
    catch (IllegalArgumentException paramWorkSource)
    {
      Log.wtf(TAG, paramWorkSource.toString());
    }
  }
  
  private void zzk(String paramString, long paramLong)
  {
    boolean bool = zznj(paramString);
    paramString = zzp(paramString, bool);
    try
    {
      if (auD)
      {
        int i = auE;
        auE = (i + 1);
        if ((i == 0) || (bool)) {}
      }
      else
      {
        if ((auD) || (auF != 0)) {
          break label113;
        }
      }
      zzh.zzave().zza(mContext, zzf.zza(auA, paramString), 7, Ay, paramString, AA, auB, zzz.zzb(acv), paramLong);
      auF += 1;
      label113:
      return;
    }
    finally {}
  }
  
  private void zzni(String paramString)
  {
    boolean bool = zznj(paramString);
    paramString = zzp(paramString, bool);
    try
    {
      if (auD)
      {
        int i = auE - 1;
        auE = i;
        if ((i == 0) || (bool)) {}
      }
      else
      {
        if ((auD) || (auF != 1)) {
          break label107;
        }
      }
      zzh.zzave().zza(mContext, zzf.zza(auA, paramString), 8, Ay, paramString, AA, auB, zzz.zzb(acv));
      auF -= 1;
      label107:
      return;
    }
    finally {}
  }
  
  private boolean zznj(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (!paramString.equals(auC));
  }
  
  private String zzp(String paramString, boolean paramBoolean)
  {
    if (auD)
    {
      if (paramBoolean) {
        return paramString;
      }
      return auC;
    }
    return auC;
  }
  
  public void acquire(long paramLong)
  {
    String str2;
    if ((!zzs.zzavm()) && (auD))
    {
      str2 = TAG;
      str1 = String.valueOf(Ay);
      if (str1.length() == 0) {
        break label62;
      }
    }
    label62:
    for (String str1 = "Do not acquire with timeout on reference counted WakeLocks before ICS. wakelock: ".concat(str1);; str1 = new String("Do not acquire with timeout on reference counted WakeLocks before ICS. wakelock: "))
    {
      Log.wtf(str2, str1);
      zzk(null, paramLong);
      auA.acquire(paramLong);
      return;
    }
  }
  
  public boolean isHeld()
  {
    return auA.isHeld();
  }
  
  public void release()
  {
    zzni(null);
    auA.release();
  }
  
  public void setReferenceCounted(boolean paramBoolean)
  {
    auA.setReferenceCounted(paramBoolean);
    auD = paramBoolean;
  }
  
  public void zzc(WorkSource paramWorkSource)
  {
    if ((paramWorkSource != null) && (zzz.zzco(mContext)))
    {
      if (acv == null) {
        break label39;
      }
      acv.add(paramWorkSource);
    }
    for (;;)
    {
      zzd(acv);
      return;
      label39:
      acv = paramWorkSource;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzvz
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */