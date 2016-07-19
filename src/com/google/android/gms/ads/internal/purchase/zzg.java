package com.google.android.gms.ads.internal.purchase;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.internal.zzhv.zza;
import com.google.android.gms.internal.zzir;
import com.google.android.gms.internal.zzkh;

@zzir
public final class zzg
  extends zzhv.zza
  implements ServiceConnection
{
  private Context mContext;
  private int mResultCode;
  zzb zzbww;
  private String zzbxc;
  private zzf zzbxg;
  private boolean zzbxm = false;
  private Intent zzbxn;
  
  public zzg(Context paramContext, String paramString, boolean paramBoolean, int paramInt, Intent paramIntent, zzf paramzzf)
  {
    zzbxc = paramString;
    mResultCode = paramInt;
    zzbxn = paramIntent;
    zzbxm = paramBoolean;
    mContext = paramContext;
    zzbxg = paramzzf;
  }
  
  public void finishPurchase()
  {
    int i = zzu.zzga().zzd(zzbxn);
    if ((mResultCode != -1) || (i != 0)) {
      return;
    }
    zzbww = new zzb(mContext);
    Intent localIntent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
    localIntent.setPackage("com.android.vending");
    com.google.android.gms.common.stats.zzb.zzaut().zza(mContext, localIntent, this, 1);
  }
  
  public String getProductId()
  {
    return zzbxc;
  }
  
  public Intent getPurchaseData()
  {
    return zzbxn;
  }
  
  public int getResultCode()
  {
    return mResultCode;
  }
  
  public boolean isVerified()
  {
    return zzbxm;
  }
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    zzkh.zzcx("In-app billing service connected.");
    zzbww.zzas(paramIBinder);
    paramComponentName = zzu.zzga().zze(zzbxn);
    paramComponentName = zzu.zzga().zzca(paramComponentName);
    if (paramComponentName == null) {
      return;
    }
    if (zzbww.zzm(mContext.getPackageName(), paramComponentName) == 0) {
      zzh.zzs(mContext).zza(zzbxg);
    }
    com.google.android.gms.common.stats.zzb.zzaut().zza(mContext, this);
    zzbww.destroy();
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    zzkh.zzcx("In-app billing service disconnected.");
    zzbww.destroy();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.purchase.zzg
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */