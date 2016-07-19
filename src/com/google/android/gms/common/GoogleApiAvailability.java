package com.google.android.gms.common;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.view.View;
import android.widget.ProgressBar;
import com.google.android.gms.R.string;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.internal.zzqj;
import com.google.android.gms.internal.zzqj.zza;
import com.google.android.gms.internal.zzqp;

public class GoogleApiAvailability
  extends zzc
{
  public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = zzc.GOOGLE_PLAY_SERVICES_VERSION_CODE;
  private static final GoogleApiAvailability qU = new GoogleApiAvailability();
  
  public static GoogleApiAvailability getInstance()
  {
    return qU;
  }
  
  public PendingIntent getErrorResolutionPendingIntent(Context paramContext, int paramInt1, int paramInt2)
  {
    return super.getErrorResolutionPendingIntent(paramContext, paramInt1, paramInt2);
  }
  
  public PendingIntent getErrorResolutionPendingIntent(Context paramContext, ConnectionResult paramConnectionResult)
  {
    if (paramConnectionResult.hasResolution()) {
      return paramConnectionResult.getResolution();
    }
    int j = paramConnectionResult.getErrorCode();
    int i = j;
    if (com.google.android.gms.common.util.zzi.zzck(paramContext))
    {
      i = j;
      if (j == 2) {
        i = 42;
      }
    }
    return getErrorResolutionPendingIntent(paramContext, i, 0);
  }
  
  public int isGooglePlayServicesAvailable(Context paramContext)
  {
    return super.isGooglePlayServicesAvailable(paramContext);
  }
  
  public final boolean isUserResolvableError(int paramInt)
  {
    return super.isUserResolvableError(paramInt);
  }
  
  public boolean showErrorDialogFragment(Activity paramActivity, int paramInt1, int paramInt2)
  {
    return GooglePlayServicesUtil.showErrorDialogFragment(paramInt1, paramActivity, paramInt2);
  }
  
  public boolean showErrorDialogFragment(Activity paramActivity, int paramInt1, int paramInt2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    return GooglePlayServicesUtil.showErrorDialogFragment(paramInt1, paramActivity, paramInt2, paramOnCancelListener);
  }
  
  public Dialog zza(Activity paramActivity, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    Object localObject2 = new ProgressBar(paramActivity, null, 16842874);
    ((ProgressBar)localObject2).setIndeterminate(true);
    ((ProgressBar)localObject2).setVisibility(0);
    Object localObject1 = new AlertDialog.Builder(paramActivity);
    ((AlertDialog.Builder)localObject1).setView((View)localObject2);
    localObject2 = GooglePlayServicesUtil.zzbv(paramActivity);
    ((AlertDialog.Builder)localObject1).setMessage(paramActivity.getResources().getString(R.string.common_google_play_services_updating_text, new Object[] { localObject2 }));
    ((AlertDialog.Builder)localObject1).setTitle(R.string.common_google_play_services_updating_title);
    ((AlertDialog.Builder)localObject1).setPositiveButton("", null);
    localObject1 = ((AlertDialog.Builder)localObject1).create();
    GooglePlayServicesUtil.zza(paramActivity, paramOnCancelListener, "GooglePlayServicesUpdatingDialog", (Dialog)localObject1);
    return (Dialog)localObject1;
  }
  
  public PendingIntent zza(Context paramContext, int paramInt1, int paramInt2, String paramString)
  {
    return super.zza(paramContext, paramInt1, paramInt2, paramString);
  }
  
  public Intent zza(Context paramContext, int paramInt, String paramString)
  {
    return super.zza(paramContext, paramInt, paramString);
  }
  
  public zzqj zza(Context paramContext, zzqj.zza paramzza)
  {
    Object localObject = new IntentFilter("android.intent.action.PACKAGE_ADDED");
    ((IntentFilter)localObject).addDataScheme("package");
    zzqj localzzqj = new zzqj(paramzza);
    paramContext.registerReceiver(localzzqj, (IntentFilter)localObject);
    localzzqj.setContext(paramContext);
    localObject = localzzqj;
    if (!zzm(paramContext, "com.google.android.gms"))
    {
      paramzza.zzaor();
      localzzqj.unregister();
      localObject = null;
    }
    return (zzqj)localObject;
  }
  
  public void zza(Context paramContext, ConnectionResult paramConnectionResult, int paramInt)
  {
    PendingIntent localPendingIntent = getErrorResolutionPendingIntent(paramContext, paramConnectionResult);
    if (localPendingIntent != null) {
      GooglePlayServicesUtil.zza(paramConnectionResult.getErrorCode(), paramContext, GoogleApiActivity.zza(paramContext, localPendingIntent, paramInt));
    }
  }
  
  public boolean zza(Activity paramActivity, zzqp paramzzqp, int paramInt1, int paramInt2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    paramzzqp = GooglePlayServicesUtil.zza(paramInt1, paramActivity, com.google.android.gms.common.internal.zzi.zza(paramzzqp, zza(paramActivity, paramInt1, "d"), paramInt2), paramOnCancelListener);
    if (paramzzqp == null) {
      return false;
    }
    GooglePlayServicesUtil.zza(paramActivity, paramOnCancelListener, "GooglePlayServicesErrorDialog", paramzzqp);
    return true;
  }
  
  public int zzbn(Context paramContext)
  {
    return super.zzbn(paramContext);
  }
  
  public boolean zzc(Context paramContext, int paramInt)
  {
    return super.zzc(paramContext, paramInt);
  }
  
  @Deprecated
  public Intent zzfa(int paramInt)
  {
    return super.zzfa(paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.GoogleApiAvailability
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */