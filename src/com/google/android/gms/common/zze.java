package com.google.android.gms.common;

import android.annotation.TargetApi;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageInstaller;
import android.content.pm.PackageInstaller.SessionInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Build;
import android.os.Bundle;
import android.os.UserManager;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.R.string;
import com.google.android.gms.common.util.zzd;
import com.google.android.gms.common.util.zzi;
import com.google.android.gms.common.util.zzl;
import com.google.android.gms.common.util.zzs;
import com.google.android.gms.common.util.zzy;
import com.google.android.gms.internal.zzrt;
import com.google.android.gms.internal.zzru;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

public class zze
{
  @Deprecated
  public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
  @Deprecated
  public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = ;
  public static final String GOOGLE_PLAY_STORE_PACKAGE = "com.android.vending";
  public static boolean rf = false;
  public static boolean rg = false;
  static boolean rh = false;
  private static String ri = null;
  private static int rj = 0;
  private static boolean rk = false;
  static final AtomicBoolean rl = new AtomicBoolean();
  private static final AtomicBoolean rm = new AtomicBoolean();
  
  @Deprecated
  public static PendingIntent getErrorPendingIntent(int paramInt1, Context paramContext, int paramInt2)
  {
    return zzc.zzand().getErrorResolutionPendingIntent(paramContext, paramInt1, paramInt2);
  }
  
  @Deprecated
  public static String getErrorString(int paramInt)
  {
    return ConnectionResult.getStatusString(paramInt);
  }
  
  @Deprecated
  public static String getOpenSourceSoftwareLicenseInfo(Context paramContext)
  {
    Object localObject = new Uri.Builder().scheme("android.resource").authority("com.google.android.gms").appendPath("raw").appendPath("third_party_licenses").build();
    try
    {
      InputStream localInputStream = paramContext.getContentResolver().openInputStream((Uri)localObject);
      try
      {
        paramContext = new Scanner(localInputStream).useDelimiter("\\A").next();
        localObject = paramContext;
        if (localInputStream != null)
        {
          localInputStream.close();
          return paramContext;
        }
      }
      catch (NoSuchElementException paramContext)
      {
        paramContext = paramContext;
        if (localInputStream == null) {
          break label97;
        }
        localInputStream.close();
        break label97;
      }
      finally
      {
        paramContext = finally;
        if (localInputStream != null) {
          localInputStream.close();
        }
        throw paramContext;
      }
      return (String)localObject;
    }
    catch (Exception paramContext)
    {
      localObject = null;
    }
    label97:
    return null;
  }
  
  public static Context getRemoteContext(Context paramContext)
  {
    try
    {
      paramContext = paramContext.createPackageContext("com.google.android.gms", 3);
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
    return null;
  }
  
  public static Resources getRemoteResource(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getResourcesForApplication("com.google.android.gms");
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
    return null;
  }
  
  @Deprecated
  public static int isGooglePlayServicesAvailable(Context paramContext)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    PackageInfo localPackageInfo;
    try
    {
      paramContext.getResources().getString(R.string.common_google_play_services_unknown_issue);
      if (!"com.google.android.gms".equals(paramContext.getPackageName())) {
        zzbs(paramContext);
      }
      if (!zzi.zzck(paramContext))
      {
        i = 1;
        localObject = null;
        if (i == 0) {}
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        try
        {
          localObject = localPackageManager.getPackageInfo("com.android.vending", 8256);
        }
        catch (PackageManager.NameNotFoundException paramContext)
        {
          Object localObject;
          Log.w("GooglePlayServicesUtil", "Google Play Store is missing.");
          return 9;
        }
        try
        {
          localPackageInfo = localPackageManager.getPackageInfo("com.google.android.gms", 64);
          paramContext = zzf.zzbz(paramContext);
          if (i == 0) {
            break label171;
          }
          localObject = paramContext.zza((PackageInfo)localObject, zzd.zzd.re);
          if (localObject != null) {
            break label143;
          }
          Log.w("GooglePlayServicesUtil", "Google Play Store signature invalid.");
          return 9;
        }
        catch (PackageManager.NameNotFoundException paramContext)
        {
          Log.w("GooglePlayServicesUtil", "Google Play services is missing.");
          return 1;
        }
        localThrowable = localThrowable;
        Log.e("GooglePlayServicesUtil", "The Google Play services resources were not found. Check your project configuration to ensure that the resources are included.");
        continue;
        i = 0;
      }
    }
    label143:
    if (paramContext.zza(localPackageInfo, new zzd.zza[] { localThrowable }) == null)
    {
      Log.w("GooglePlayServicesUtil", "Google Play services signature invalid.");
      return 9;
      label171:
      if (paramContext.zza(localPackageInfo, zzd.zzd.re) == null)
      {
        Log.w("GooglePlayServicesUtil", "Google Play services signature invalid.");
        return 9;
      }
    }
    int i = zzl.zzgw(GOOGLE_PLAY_SERVICES_VERSION_CODE);
    if (zzl.zzgw(versionCode) < i)
    {
      i = GOOGLE_PLAY_SERVICES_VERSION_CODE;
      int j = versionCode;
      Log.w("GooglePlayServicesUtil", 77 + "Google Play services out of date.  Requires " + i + " but found " + j);
      return 2;
    }
    ApplicationInfo localApplicationInfo = applicationInfo;
    paramContext = localApplicationInfo;
    if (localApplicationInfo == null) {}
    try
    {
      paramContext = localPackageManager.getApplicationInfo("com.google.android.gms", 0);
      if (!enabled) {
        return 3;
      }
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      Log.wtf("GooglePlayServicesUtil", "Google Play services missing when getting application info.", paramContext);
      return 1;
    }
    return 0;
  }
  
  @Deprecated
  public static boolean isUserRecoverableError(int paramInt)
  {
    switch (paramInt)
    {
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    default: 
      return false;
    }
    return true;
  }
  
  private static int zzank()
  {
    return com.google.android.gms.common.internal.zze.xB;
  }
  
  @Deprecated
  public static boolean zzanl()
  {
    return "user".equals(Build.TYPE);
  }
  
  @Deprecated
  @TargetApi(19)
  public static boolean zzb(Context paramContext, int paramInt, String paramString)
  {
    return zzy.zzb(paramContext, paramInt, paramString);
  }
  
  @Deprecated
  public static void zzbb(Context paramContext)
    throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException
  {
    int i = zzc.zzand().isGooglePlayServicesAvailable(paramContext);
    if (i != 0)
    {
      paramContext = zzc.zzand().zza(paramContext, i, "e");
      Log.e("GooglePlayServicesUtil", 57 + "GooglePlayServices not available due to error " + i);
      if (paramContext == null) {
        throw new GooglePlayServicesNotAvailableException(i);
      }
      throw new GooglePlayServicesRepairableException(i, "Google Play Services not available", paramContext);
    }
  }
  
  @Deprecated
  public static int zzbn(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo("com.google.android.gms", 0);
      return versionCode;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      Log.w("GooglePlayServicesUtil", "Google Play services is missing.");
    }
    return 0;
  }
  
  @Deprecated
  public static void zzbp(Context paramContext)
  {
    if (rl.getAndSet(true)) {}
    for (;;)
    {
      return;
      try
      {
        paramContext = (NotificationManager)paramContext.getSystemService("notification");
        if (paramContext != null)
        {
          paramContext.cancel(10436);
          return;
        }
      }
      catch (SecurityException paramContext) {}
    }
  }
  
  private static void zzbs(Context paramContext)
  {
    if (rm.get()) {}
    do
    {
      return;
      zzbx(paramContext);
      if (rj == 0) {
        throw new IllegalStateException("A required meta-data tag in your app's AndroidManifest.xml does not exist.  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />");
      }
    } while (rj == GOOGLE_PLAY_SERVICES_VERSION_CODE);
    int i = GOOGLE_PLAY_SERVICES_VERSION_CODE;
    int j = rj;
    paramContext = String.valueOf("com.google.android.gms.version");
    throw new IllegalStateException(String.valueOf(paramContext).length() + 290 + "The meta-data tag in your app's AndroidManifest.xml does not have the right value.  Expected " + i + " but found " + j + ".  You must have the following declaration within the <application> element:     <meta-data android:name=\"" + paramContext + "\" android:value=\"@integer/google_play_services_version\" />");
  }
  
  public static boolean zzbt(Context paramContext)
  {
    zzbx(paramContext);
    return rh;
  }
  
  public static boolean zzbu(Context paramContext)
  {
    return (zzbt(paramContext)) || (!zzanl());
  }
  
  public static String zzbv(Context paramContext)
  {
    Object localObject2 = getApplicationInfoname;
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject1 = paramContext.getPackageName();
      localObject2 = paramContext.getApplicationContext().getPackageManager();
    }
    try
    {
      paramContext = zzru.zzcq(paramContext).getApplicationInfo(paramContext.getPackageName(), 0);
      if (paramContext != null) {
        localObject1 = ((PackageManager)localObject2).getApplicationLabel(paramContext).toString();
      }
      return (String)localObject1;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;)
      {
        paramContext = null;
      }
    }
  }
  
  @TargetApi(18)
  public static boolean zzbw(Context paramContext)
  {
    if (zzs.zzavp())
    {
      paramContext = ((UserManager)paramContext.getSystemService("user")).getApplicationRestrictions(paramContext.getPackageName());
      if ((paramContext != null) && ("true".equals(paramContext.getString("restricted_profile")))) {
        return true;
      }
    }
    return false;
  }
  
  private static void zzbx(Context paramContext)
  {
    if (!rk) {
      zzby(paramContext);
    }
  }
  
  /* Error */
  private static void zzby(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 177	android/content/Context:getPackageName	()Ljava/lang/String;
    //   4: putstatic 40	com/google/android/gms/common/zze:ri	Ljava/lang/String;
    //   7: aload_0
    //   8: invokestatic 407	com/google/android/gms/internal/zzru:zzcq	(Landroid/content/Context;)Lcom/google/android/gms/internal/zzrt;
    //   11: astore_1
    //   12: aload_0
    //   13: invokestatic 447	com/google/android/gms/common/internal/zzz:zzcg	(Landroid/content/Context;)I
    //   16: putstatic 42	com/google/android/gms/common/zze:rj	I
    //   19: aload_1
    //   20: ldc 8
    //   22: bipush 64
    //   24: invokevirtual 448	com/google/android/gms/internal/zzrt:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   27: astore_1
    //   28: aload_1
    //   29: ifnull +35 -> 64
    //   32: aload_0
    //   33: invokestatic 203	com/google/android/gms/common/zzf:zzbz	(Landroid/content/Context;)Lcom/google/android/gms/common/zzf;
    //   36: aload_1
    //   37: iconst_1
    //   38: anewarray 234	com/google/android/gms/common/zzd$zza
    //   41: dup
    //   42: iconst_0
    //   43: getstatic 209	com/google/android/gms/common/zzd$zzd:re	[Lcom/google/android/gms/common/zzd$zza;
    //   46: iconst_1
    //   47: aaload
    //   48: aastore
    //   49: invokevirtual 213	com/google/android/gms/common/zzf:zza	(Landroid/content/pm/PackageInfo;[Lcom/google/android/gms/common/zzd$zza;)Lcom/google/android/gms/common/zzd$zza;
    //   52: ifnull +12 -> 64
    //   55: iconst_1
    //   56: putstatic 38	com/google/android/gms/common/zze:rh	Z
    //   59: iconst_1
    //   60: putstatic 44	com/google/android/gms/common/zze:rk	Z
    //   63: return
    //   64: iconst_0
    //   65: putstatic 38	com/google/android/gms/common/zze:rh	Z
    //   68: goto -9 -> 59
    //   71: astore_0
    //   72: ldc -41
    //   74: ldc_w 450
    //   77: aload_0
    //   78: invokestatic 452	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   81: pop
    //   82: iconst_1
    //   83: putstatic 44	com/google/android/gms/common/zze:rk	Z
    //   86: return
    //   87: astore_0
    //   88: iconst_1
    //   89: putstatic 44	com/google/android/gms/common/zze:rk	Z
    //   92: aload_0
    //   93: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	94	0	paramContext	Context
    //   11	26	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   0	28	71	android/content/pm/PackageManager$NameNotFoundException
    //   32	59	71	android/content/pm/PackageManager$NameNotFoundException
    //   64	68	71	android/content/pm/PackageManager$NameNotFoundException
    //   0	28	87	finally
    //   32	59	87	finally
    //   64	68	87	finally
    //   72	82	87	finally
  }
  
  @Deprecated
  public static boolean zzc(Context paramContext, int paramInt)
  {
    if (paramInt == 18) {
      return true;
    }
    if (paramInt == 1) {
      return zzm(paramContext, "com.google.android.gms");
    }
    return false;
  }
  
  @Deprecated
  public static boolean zzd(Context paramContext, int paramInt)
  {
    if (paramInt == 9) {
      return zzm(paramContext, "com.android.vending");
    }
    return false;
  }
  
  @Deprecated
  public static boolean zze(Context paramContext, int paramInt)
  {
    return zzy.zze(paramContext, paramInt);
  }
  
  @Deprecated
  public static Intent zzfb(int paramInt)
  {
    return zzc.zzand().zza(null, paramInt, null);
  }
  
  static boolean zzfc(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    return true;
  }
  
  @TargetApi(21)
  static boolean zzm(Context paramContext, String paramString)
  {
    if ((paramString.equals("com.google.android.gms")) && (zzd.zzabc())) {
      return false;
    }
    if (zzs.zzavs())
    {
      localObject = paramContext.getPackageManager().getPackageInstaller().getAllSessions().iterator();
      while (((Iterator)localObject).hasNext()) {
        if (paramString.equals(((PackageInstaller.SessionInfo)((Iterator)localObject).next()).getAppPackageName())) {
          return true;
        }
      }
    }
    Object localObject = paramContext.getPackageManager();
    try
    {
      if (getApplicationInfo8192enabled)
      {
        bool = zzbw(paramContext);
        if (bool) {}
      }
      for (boolean bool = true;; bool = false) {
        return bool;
      }
      return false;
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.zze
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */