package com.google.android.gms.common;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.Notification;
import android.app.Notification.BigTextStyle;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.NotificationCompat.Builder;
import android.util.Log;
import android.util.TypedValue;
import com.google.android.gms.R.drawable;
import com.google.android.gms.R.string;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.internal.zzh;
import com.google.android.gms.common.util.zzs;
import java.util.concurrent.atomic.AtomicBoolean;

public final class GooglePlayServicesUtil
  extends zze
{
  public static final String GMS_ERROR_DIALOG = "GooglePlayServicesErrorDialog";
  @Deprecated
  public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
  @Deprecated
  public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = zze.GOOGLE_PLAY_SERVICES_VERSION_CODE;
  public static final String GOOGLE_PLAY_STORE_PACKAGE = "com.android.vending";
  
  @Deprecated
  public static Dialog getErrorDialog(int paramInt1, Activity paramActivity, int paramInt2)
  {
    return getErrorDialog(paramInt1, paramActivity, paramInt2, null);
  }
  
  @Deprecated
  public static Dialog getErrorDialog(int paramInt1, Activity paramActivity, int paramInt2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    return zza(paramInt1, paramActivity, com.google.android.gms.common.internal.zzi.zza(paramActivity, GoogleApiAvailability.getInstance().zza(paramActivity, paramInt1, "d"), paramInt2), paramOnCancelListener);
  }
  
  @Deprecated
  public static PendingIntent getErrorPendingIntent(int paramInt1, Context paramContext, int paramInt2)
  {
    return zze.getErrorPendingIntent(paramInt1, paramContext, paramInt2);
  }
  
  @Deprecated
  public static String getErrorString(int paramInt)
  {
    return zze.getErrorString(paramInt);
  }
  
  @Deprecated
  public static String getOpenSourceSoftwareLicenseInfo(Context paramContext)
  {
    return zze.getOpenSourceSoftwareLicenseInfo(paramContext);
  }
  
  public static Context getRemoteContext(Context paramContext)
  {
    return zze.getRemoteContext(paramContext);
  }
  
  public static Resources getRemoteResource(Context paramContext)
  {
    return zze.getRemoteResource(paramContext);
  }
  
  @Deprecated
  public static int isGooglePlayServicesAvailable(Context paramContext)
  {
    return zze.isGooglePlayServicesAvailable(paramContext);
  }
  
  @Deprecated
  public static boolean isUserRecoverableError(int paramInt)
  {
    return zze.isUserRecoverableError(paramInt);
  }
  
  @Deprecated
  public static boolean showErrorDialogFragment(int paramInt1, Activity paramActivity, int paramInt2)
  {
    return showErrorDialogFragment(paramInt1, paramActivity, paramInt2, null);
  }
  
  @Deprecated
  public static boolean showErrorDialogFragment(int paramInt1, Activity paramActivity, int paramInt2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    return showErrorDialogFragment(paramInt1, paramActivity, null, paramInt2, paramOnCancelListener);
  }
  
  public static boolean showErrorDialogFragment(int paramInt1, Activity paramActivity, Fragment paramFragment, int paramInt2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    Intent localIntent = GoogleApiAvailability.getInstance().zza(paramActivity, paramInt1, "d");
    if (paramFragment == null) {}
    for (paramFragment = com.google.android.gms.common.internal.zzi.zza(paramActivity, localIntent, paramInt2);; paramFragment = com.google.android.gms.common.internal.zzi.zza(paramFragment, localIntent, paramInt2))
    {
      paramFragment = zza(paramInt1, paramActivity, paramFragment, paramOnCancelListener);
      if (paramFragment != null) {
        break;
      }
      return false;
    }
    zza(paramActivity, paramOnCancelListener, "GooglePlayServicesErrorDialog", paramFragment);
    return true;
  }
  
  @Deprecated
  public static void showErrorNotification(int paramInt, Context paramContext)
  {
    int i = paramInt;
    if (com.google.android.gms.common.util.zzi.zzck(paramContext))
    {
      i = paramInt;
      if (paramInt == 2) {
        i = 42;
      }
    }
    if ((zzc(paramContext, i)) || (zzd(paramContext, i)))
    {
      zzbr(paramContext);
      return;
    }
    zza(i, paramContext);
  }
  
  @TargetApi(14)
  public static Dialog zza(int paramInt, Activity paramActivity, com.google.android.gms.common.internal.zzi paramzzi, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    Object localObject2 = null;
    if (paramInt == 0) {
      return null;
    }
    int i = paramInt;
    if (com.google.android.gms.common.util.zzi.zzck(paramActivity))
    {
      i = paramInt;
      if (paramInt == 2) {
        i = 42;
      }
    }
    paramInt = i;
    if (zzc(paramActivity, i)) {
      paramInt = 18;
    }
    Object localObject1 = localObject2;
    if (zzs.zzavm())
    {
      TypedValue localTypedValue = new TypedValue();
      paramActivity.getTheme().resolveAttribute(16843529, localTypedValue, true);
      localObject1 = localObject2;
      if ("Theme.Dialog.Alert".equals(paramActivity.getResources().getResourceEntryName(resourceId))) {
        localObject1 = new AlertDialog.Builder(paramActivity, 5);
      }
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = new AlertDialog.Builder(paramActivity);
    }
    ((AlertDialog.Builder)localObject2).setMessage(zzh.zzc(paramActivity, paramInt, zzbv(paramActivity)));
    if (paramOnCancelListener != null) {
      ((AlertDialog.Builder)localObject2).setOnCancelListener(paramOnCancelListener);
    }
    paramOnCancelListener = zzh.zzh(paramActivity, paramInt);
    if (paramOnCancelListener != null) {
      ((AlertDialog.Builder)localObject2).setPositiveButton(paramOnCancelListener, paramzzi);
    }
    paramActivity = zzh.zzf(paramActivity, paramInt);
    if (paramActivity != null) {
      ((AlertDialog.Builder)localObject2).setTitle(paramActivity);
    }
    return ((AlertDialog.Builder)localObject2).create();
  }
  
  private static void zza(int paramInt, Context paramContext)
  {
    zza(paramInt, paramContext, null);
  }
  
  static void zza(int paramInt, Context paramContext, PendingIntent paramPendingIntent)
  {
    zza(paramInt, paramContext, null, paramPendingIntent);
  }
  
  private static void zza(int paramInt, Context paramContext, String paramString)
  {
    zza(paramInt, paramContext, paramString, GoogleApiAvailability.getInstance().zza(paramContext, paramInt, 0, "n"));
  }
  
  @TargetApi(20)
  private static void zza(int paramInt, Context paramContext, String paramString, PendingIntent paramPendingIntent)
  {
    Object localObject = paramContext.getResources();
    String str3 = zzbv(paramContext);
    String str2 = zzh.zzg(paramContext, paramInt);
    String str1 = str2;
    if (str2 == null) {
      str1 = ((Resources)localObject).getString(R.string.common_google_play_services_notification_ticker);
    }
    str2 = zzh.zzd(paramContext, paramInt, str3);
    if (com.google.android.gms.common.util.zzi.zzck(paramContext))
    {
      zzab.zzbm(zzs.zzavn());
      paramPendingIntent = new Notification.Builder(paramContext).setSmallIcon(R.drawable.common_ic_googleplayservices).setPriority(2).setAutoCancel(true).setStyle(new Notification.BigTextStyle().bigText(String.valueOf(str1).length() + 1 + String.valueOf(str2).length() + str1 + " " + str2)).addAction(R.drawable.common_full_open_on_phone, ((Resources)localObject).getString(R.string.common_open_on_phone), paramPendingIntent).build();
      if (!zzfc(paramInt)) {
        break label374;
      }
      rl.set(false);
    }
    label374:
    for (paramInt = 10436;; paramInt = 39789)
    {
      paramContext = (NotificationManager)paramContext.getSystemService("notification");
      if (paramString == null) {
        break label381;
      }
      paramContext.notify(paramString, paramInt, paramPendingIntent);
      return;
      localObject = ((Resources)localObject).getString(R.string.common_google_play_services_notification_ticker);
      if (zzs.zzavj())
      {
        paramPendingIntent = new Notification.Builder(paramContext).setSmallIcon(17301642).setContentTitle(str1).setContentText(str2).setContentIntent(paramPendingIntent).setTicker((CharSequence)localObject).setAutoCancel(true);
        if (zzs.zzavr()) {
          paramPendingIntent.setLocalOnly(true);
        }
        if (zzs.zzavn()) {
          paramPendingIntent.setStyle(new Notification.BigTextStyle().bigText(str2));
        }
        for (paramPendingIntent = paramPendingIntent.build();; paramPendingIntent = paramPendingIntent.getNotification())
        {
          if (Build.VERSION.SDK_INT == 19) {
            extras.putBoolean("android.support.localOnly", true);
          }
          break;
        }
      }
      paramPendingIntent = new NotificationCompat.Builder(paramContext).setSmallIcon(17301642).setTicker((CharSequence)localObject).setWhen(System.currentTimeMillis()).setAutoCancel(true).setContentIntent(paramPendingIntent).setContentTitle(str1).setContentText(str2).build();
      break;
    }
    label381:
    paramContext.notify(paramInt, paramPendingIntent);
  }
  
  @TargetApi(11)
  public static void zza(Activity paramActivity, DialogInterface.OnCancelListener paramOnCancelListener, String paramString, Dialog paramDialog)
  {
    try
    {
      bool = paramActivity instanceof FragmentActivity;
      if (bool)
      {
        paramActivity = ((FragmentActivity)paramActivity).getSupportFragmentManager();
        SupportErrorDialogFragment.newInstance(paramDialog, paramOnCancelListener).show(paramActivity, paramString);
        return;
      }
    }
    catch (NoClassDefFoundError localNoClassDefFoundError)
    {
      for (;;)
      {
        boolean bool = false;
      }
      if (zzs.zzavj())
      {
        paramActivity = paramActivity.getFragmentManager();
        ErrorDialogFragment.newInstance(paramDialog, paramOnCancelListener).show(paramActivity, paramString);
        return;
      }
      throw new RuntimeException("This Activity does not support Fragments.");
    }
  }
  
  private static void zzbr(Context paramContext)
  {
    paramContext = new zza(paramContext);
    paramContext.sendMessageDelayed(paramContext.obtainMessage(1), 120000L);
  }
  
  @Deprecated
  public static boolean zzc(Context paramContext, int paramInt)
  {
    return zze.zzc(paramContext, paramInt);
  }
  
  @Deprecated
  public static boolean zzd(Context paramContext, int paramInt)
  {
    return zze.zzd(paramContext, paramInt);
  }
  
  @Deprecated
  public static Intent zzfb(int paramInt)
  {
    return zze.zzfb(paramInt);
  }
  
  private static class zza
    extends Handler
  {
    private final Context zzaqj;
    
    zza(Context paramContext) {}
    
    public void handleMessage(Message paramMessage)
    {
      int i;
      switch (what)
      {
      default: 
        i = what;
        Log.w("GooglePlayServicesUtil", 50 + "Don't know how to handle this message: " + i);
      }
      do
      {
        return;
        i = GooglePlayServicesUtil.isGooglePlayServicesAvailable(zzaqj);
      } while (!GooglePlayServicesUtil.isUserRecoverableError(i));
      GooglePlayServicesUtil.zzb(i, zzaqj);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.GooglePlayServicesUtil
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */