package com.google.android.gms.ads.internal.purchase;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zzd.zza;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzhr;
import com.google.android.gms.internal.zzir;

@zzir
public final class GInAppPurchaseManagerInfoParcel
  extends AbstractSafeParcelable
{
  public static final zza CREATOR = new zza();
  public final int versionCode;
  public final zzk zzapr;
  public final zzhr zzbwq;
  public final Context zzbwr;
  public final zzj zzbws;
  
  GInAppPurchaseManagerInfoParcel(int paramInt, IBinder paramIBinder1, IBinder paramIBinder2, IBinder paramIBinder3, IBinder paramIBinder4)
  {
    versionCode = paramInt;
    zzapr = ((zzk)zze.zzad(zzd.zza.zzfc(paramIBinder1)));
    zzbwq = ((zzhr)zze.zzad(zzd.zza.zzfc(paramIBinder2)));
    zzbwr = ((Context)zze.zzad(zzd.zza.zzfc(paramIBinder3)));
    zzbws = ((zzj)zze.zzad(zzd.zza.zzfc(paramIBinder4)));
  }
  
  public GInAppPurchaseManagerInfoParcel(Context paramContext, zzk paramzzk, zzhr paramzzhr, zzj paramzzj)
  {
    versionCode = 2;
    zzbwr = paramContext;
    zzapr = paramzzk;
    zzbwq = paramzzhr;
    zzbws = paramzzj;
  }
  
  public static void zza(Intent paramIntent, GInAppPurchaseManagerInfoParcel paramGInAppPurchaseManagerInfoParcel)
  {
    Bundle localBundle = new Bundle(1);
    localBundle.putParcelable("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo", paramGInAppPurchaseManagerInfoParcel);
    paramIntent.putExtra("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo", localBundle);
  }
  
  public static GInAppPurchaseManagerInfoParcel zzc(Intent paramIntent)
  {
    try
    {
      paramIntent = paramIntent.getBundleExtra("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo");
      paramIntent.setClassLoader(GInAppPurchaseManagerInfoParcel.class.getClassLoader());
      paramIntent = (GInAppPurchaseManagerInfoParcel)paramIntent.getParcelable("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo");
      return paramIntent;
    }
    catch (Exception paramIntent) {}
    return null;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zza.zza(this, paramParcel, paramInt);
  }
  
  IBinder zzpo()
  {
    return zze.zzae(zzbws).asBinder();
  }
  
  IBinder zzpp()
  {
    return zze.zzae(zzapr).asBinder();
  }
  
  IBinder zzpq()
  {
    return zze.zzae(zzbwq).asBinder();
  }
  
  IBinder zzpr()
  {
    return zze.zzae(zzbwr).asBinder();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.purchase.GInAppPurchaseManagerInfoParcel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */