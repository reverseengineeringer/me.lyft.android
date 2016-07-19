package com.google.android.gms.common.stats;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Debug;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.common.util.zzt;
import com.google.android.gms.internal.zzre;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class zzb
{
  private static Integer Ad;
  private static final Object yz = new Object();
  private static zzb zX;
  private final List<String> Aa;
  private final List<String> Ab;
  private zze Ac;
  private zze Ae;
  private final List<String> zY;
  private final List<String> zZ;
  
  private zzb()
  {
    if (getLogLevel() == zzd.LOG_LEVEL_OFF)
    {
      zY = Collections.EMPTY_LIST;
      zZ = Collections.EMPTY_LIST;
      Aa = Collections.EMPTY_LIST;
      Ab = Collections.EMPTY_LIST;
      return;
    }
    Object localObject = (String)zzc.zza.Ai.get();
    if (localObject == null)
    {
      localObject = Collections.EMPTY_LIST;
      zY = ((List)localObject);
      localObject = (String)zzc.zza.Aj.get();
      if (localObject != null) {
        break label200;
      }
      localObject = Collections.EMPTY_LIST;
      label83:
      zZ = ((List)localObject);
      localObject = (String)zzc.zza.Ak.get();
      if (localObject != null) {
        break label213;
      }
      localObject = Collections.EMPTY_LIST;
      label106:
      Aa = ((List)localObject);
      localObject = (String)zzc.zza.Al.get();
      if (localObject != null) {
        break label226;
      }
    }
    label200:
    label213:
    label226:
    for (localObject = Collections.EMPTY_LIST;; localObject = Arrays.asList(((String)localObject).split(",")))
    {
      Ab = ((List)localObject);
      Ac = new zze(1024, ((Long)zzc.zza.Am.get()).longValue());
      Ae = new zze(1024, ((Long)zzc.zza.Am.get()).longValue());
      return;
      localObject = Arrays.asList(((String)localObject).split(","));
      break;
      localObject = Arrays.asList(((String)localObject).split(","));
      break label83;
      localObject = Arrays.asList(((String)localObject).split(","));
      break label106;
    }
  }
  
  private static int getLogLevel()
  {
    if (Ad == null) {}
    for (;;)
    {
      try
      {
        if (!com.google.android.gms.common.util.zzd.zzabc()) {
          continue;
        }
        i = ((Integer)zzc.zza.Ah.get()).intValue();
        Ad = Integer.valueOf(i);
      }
      catch (SecurityException localSecurityException)
      {
        int i;
        Ad = Integer.valueOf(zzd.LOG_LEVEL_OFF);
        continue;
      }
      return Ad.intValue();
      i = zzd.LOG_LEVEL_OFF;
    }
  }
  
  private static String zza(StackTraceElement[] paramArrayOfStackTraceElement, int paramInt)
  {
    if (paramInt + 4 >= paramArrayOfStackTraceElement.length) {
      return "<bottom of call stack>";
    }
    paramArrayOfStackTraceElement = paramArrayOfStackTraceElement[(paramInt + 4)];
    String str1 = String.valueOf(paramArrayOfStackTraceElement.getClassName());
    String str2 = String.valueOf(paramArrayOfStackTraceElement.getMethodName());
    paramInt = paramArrayOfStackTraceElement.getLineNumber();
    return String.valueOf(str1).length() + 13 + String.valueOf(str2).length() + str1 + "." + str2 + ":" + paramInt;
  }
  
  private void zza(Context paramContext, String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    long l2 = System.currentTimeMillis();
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if ((getLogLevel() & zzd.Ar) != 0)
    {
      localObject1 = localObject2;
      if (paramInt != 13) {
        localObject1 = zzm(3, 5);
      }
    }
    long l1 = 0L;
    if ((getLogLevel() & zzd.At) != 0) {
      l1 = Debug.getNativeHeapAllocatedSize();
    }
    if ((paramInt == 1) || (paramInt == 4) || (paramInt == 14)) {}
    for (paramString1 = new ConnectionEvent(l2, paramInt, null, null, null, null, (String)localObject1, paramString1, SystemClock.elapsedRealtime(), l1);; paramString1 = new ConnectionEvent(l2, paramInt, paramString2, paramString3, paramString4, paramString5, (String)localObject1, paramString1, SystemClock.elapsedRealtime(), l1))
    {
      paramContext.startService(new Intent().setComponent(zzd.An).putExtra("com.google.android.gms.common.stats.EXTRA_LOG_EVENT", paramString1));
      return;
    }
  }
  
  private void zza(Context paramContext, String paramString1, String paramString2, Intent paramIntent, int paramInt)
  {
    Object localObject2 = null;
    if ((!zzauu()) || (Ac == null)) {}
    do
    {
      return;
      if ((paramInt != 4) && (paramInt != 1)) {
        break;
      }
    } while (!Ac.zzhz(paramString1));
    Object localObject1 = null;
    String str = null;
    paramIntent = (Intent)localObject2;
    for (;;)
    {
      zza(paramContext, paramString1, paramInt, paramIntent, paramString2, str, (String)localObject1);
      return;
      localObject1 = zzd(paramContext, paramIntent);
      if (localObject1 == null)
      {
        Log.w("ConnectionTracker", String.format("Client %s made an invalid request %s", new Object[] { paramString2, paramIntent.toUri(0) }));
        return;
      }
      str = processName;
      localObject1 = name;
      paramIntent = zzt.zzavu();
      if (!zzb(paramIntent, paramString2, str, (String)localObject1)) {
        break;
      }
      Ac.zzhy(paramString1);
    }
  }
  
  public static zzb zzaut()
  {
    synchronized (yz)
    {
      if (zX == null) {
        zX = new zzb();
      }
      return zX;
    }
  }
  
  private boolean zzauu()
  {
    return false;
  }
  
  private String zzb(ServiceConnection paramServiceConnection)
  {
    return String.valueOf(Process.myPid() << 32 | System.identityHashCode(paramServiceConnection));
  }
  
  private boolean zzb(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    int i = getLogLevel();
    return (!zY.contains(paramString1)) && (!zZ.contains(paramString2)) && (!Aa.contains(paramString3)) && (!Ab.contains(paramString4)) && ((!paramString3.equals(paramString1)) || ((i & zzd.As) == 0));
  }
  
  private boolean zzc(Context paramContext, Intent paramIntent)
  {
    paramIntent = paramIntent.getComponent();
    if (paramIntent == null) {
      return false;
    }
    return com.google.android.gms.common.util.zzd.zzq(paramContext, paramIntent.getPackageName());
  }
  
  private static ServiceInfo zzd(Context paramContext, Intent paramIntent)
  {
    paramContext = paramContext.getPackageManager().queryIntentServices(paramIntent, 128);
    if ((paramContext == null) || (paramContext.size() == 0))
    {
      Log.w("ConnectionTracker", String.format("There are no handler of this intent: %s\n Stack trace: %s", new Object[] { paramIntent.toUri(0), zzm(3, 20) }));
      return null;
    }
    if (paramContext.size() > 1)
    {
      Log.w("ConnectionTracker", String.format("Multiple handlers found for this intent: %s\n Stack trace: %s", new Object[] { paramIntent.toUri(0), zzm(3, 20) }));
      paramContext = paramContext.iterator();
      while (paramContext.hasNext()) {
        Log.w("ConnectionTracker", nextserviceInfo.name);
      }
      return null;
    }
    return get0serviceInfo;
  }
  
  private static String zzm(int paramInt1, int paramInt2)
  {
    StackTraceElement[] arrayOfStackTraceElement = Thread.currentThread().getStackTrace();
    StringBuffer localStringBuffer = new StringBuffer();
    int i = paramInt1;
    while (i < paramInt2 + paramInt1)
    {
      localStringBuffer.append(zza(arrayOfStackTraceElement, i)).append(" ");
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  @SuppressLint({"UntrackedBindService"})
  public void zza(Context paramContext, ServiceConnection paramServiceConnection)
  {
    paramContext.unbindService(paramServiceConnection);
    zza(paramContext, zzb(paramServiceConnection), null, null, 1);
  }
  
  public void zza(Context paramContext, ServiceConnection paramServiceConnection, String paramString, Intent paramIntent)
  {
    zza(paramContext, zzb(paramServiceConnection), paramString, paramIntent, 3);
  }
  
  public boolean zza(Context paramContext, Intent paramIntent, ServiceConnection paramServiceConnection, int paramInt)
  {
    return zza(paramContext, paramContext.getClass().getName(), paramIntent, paramServiceConnection, paramInt);
  }
  
  @SuppressLint({"UntrackedBindService"})
  public boolean zza(Context paramContext, String paramString, Intent paramIntent, ServiceConnection paramServiceConnection, int paramInt)
  {
    if (zzc(paramContext, paramIntent))
    {
      Log.w("ConnectionTracker", "Attempted to bind to a service in a STOPPED package.");
      return false;
    }
    boolean bool = paramContext.bindService(paramIntent, paramServiceConnection, paramInt);
    if (bool) {
      zza(paramContext, zzb(paramServiceConnection), paramString, paramIntent, 2);
    }
    return bool;
  }
  
  public void zzb(Context paramContext, ServiceConnection paramServiceConnection)
  {
    zza(paramContext, zzb(paramServiceConnection), null, null, 4);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.stats.zzb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */