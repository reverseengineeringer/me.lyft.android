package com.google.android.gms.ads.internal.overlay;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.ads.internal.InterstitialAdParameterParcel;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zzd.zza;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzeo;
import com.google.android.gms.internal.zzev;
import com.google.android.gms.internal.zzir;
import com.google.android.gms.internal.zzll;

@zzir
public final class AdOverlayInfoParcel
  extends AbstractSafeParcelable
{
  public static final zzf CREATOR = new zzf();
  public final int orientation;
  public final String url;
  public final int versionCode;
  public final VersionInfoParcel zzaou;
  public final AdLauncherIntentInfoParcel zzbtn;
  public final zza zzbto;
  public final zzg zzbtp;
  public final zzll zzbtq;
  public final zzeo zzbtr;
  public final String zzbts;
  public final boolean zzbtt;
  public final String zzbtu;
  public final zzp zzbtv;
  public final int zzbtw;
  public final zzev zzbtx;
  public final String zzbty;
  public final InterstitialAdParameterParcel zzbtz;
  
  AdOverlayInfoParcel(int paramInt1, AdLauncherIntentInfoParcel paramAdLauncherIntentInfoParcel, IBinder paramIBinder1, IBinder paramIBinder2, IBinder paramIBinder3, IBinder paramIBinder4, String paramString1, boolean paramBoolean, String paramString2, IBinder paramIBinder5, int paramInt2, int paramInt3, String paramString3, VersionInfoParcel paramVersionInfoParcel, IBinder paramIBinder6, String paramString4, InterstitialAdParameterParcel paramInterstitialAdParameterParcel)
  {
    versionCode = paramInt1;
    zzbtn = paramAdLauncherIntentInfoParcel;
    zzbto = ((zza)zze.zzad(zzd.zza.zzfc(paramIBinder1)));
    zzbtp = ((zzg)zze.zzad(zzd.zza.zzfc(paramIBinder2)));
    zzbtq = ((zzll)zze.zzad(zzd.zza.zzfc(paramIBinder3)));
    zzbtr = ((zzeo)zze.zzad(zzd.zza.zzfc(paramIBinder4)));
    zzbts = paramString1;
    zzbtt = paramBoolean;
    zzbtu = paramString2;
    zzbtv = ((zzp)zze.zzad(zzd.zza.zzfc(paramIBinder5)));
    orientation = paramInt2;
    zzbtw = paramInt3;
    url = paramString3;
    zzaou = paramVersionInfoParcel;
    zzbtx = ((zzev)zze.zzad(zzd.zza.zzfc(paramIBinder6)));
    zzbty = paramString4;
    zzbtz = paramInterstitialAdParameterParcel;
  }
  
  public AdOverlayInfoParcel(zza paramzza, zzg paramzzg, zzp paramzzp, zzll paramzzll, int paramInt, VersionInfoParcel paramVersionInfoParcel, String paramString, InterstitialAdParameterParcel paramInterstitialAdParameterParcel)
  {
    versionCode = 4;
    zzbtn = null;
    zzbto = paramzza;
    zzbtp = paramzzg;
    zzbtq = paramzzll;
    zzbtr = null;
    zzbts = null;
    zzbtt = false;
    zzbtu = null;
    zzbtv = paramzzp;
    orientation = paramInt;
    zzbtw = 1;
    url = null;
    zzaou = paramVersionInfoParcel;
    zzbtx = null;
    zzbty = paramString;
    zzbtz = paramInterstitialAdParameterParcel;
  }
  
  public AdOverlayInfoParcel(zza paramzza, zzg paramzzg, zzp paramzzp, zzll paramzzll, boolean paramBoolean, int paramInt, VersionInfoParcel paramVersionInfoParcel)
  {
    versionCode = 4;
    zzbtn = null;
    zzbto = paramzza;
    zzbtp = paramzzg;
    zzbtq = paramzzll;
    zzbtr = null;
    zzbts = null;
    zzbtt = paramBoolean;
    zzbtu = null;
    zzbtv = paramzzp;
    orientation = paramInt;
    zzbtw = 2;
    url = null;
    zzaou = paramVersionInfoParcel;
    zzbtx = null;
    zzbty = null;
    zzbtz = null;
  }
  
  public AdOverlayInfoParcel(zza paramzza, zzg paramzzg, zzeo paramzzeo, zzp paramzzp, zzll paramzzll, boolean paramBoolean, int paramInt, String paramString, VersionInfoParcel paramVersionInfoParcel, zzev paramzzev)
  {
    versionCode = 4;
    zzbtn = null;
    zzbto = paramzza;
    zzbtp = paramzzg;
    zzbtq = paramzzll;
    zzbtr = paramzzeo;
    zzbts = null;
    zzbtt = paramBoolean;
    zzbtu = null;
    zzbtv = paramzzp;
    orientation = paramInt;
    zzbtw = 3;
    url = paramString;
    zzaou = paramVersionInfoParcel;
    zzbtx = paramzzev;
    zzbty = null;
    zzbtz = null;
  }
  
  public AdOverlayInfoParcel(zza paramzza, zzg paramzzg, zzeo paramzzeo, zzp paramzzp, zzll paramzzll, boolean paramBoolean, int paramInt, String paramString1, String paramString2, VersionInfoParcel paramVersionInfoParcel, zzev paramzzev)
  {
    versionCode = 4;
    zzbtn = null;
    zzbto = paramzza;
    zzbtp = paramzzg;
    zzbtq = paramzzll;
    zzbtr = paramzzeo;
    zzbts = paramString2;
    zzbtt = paramBoolean;
    zzbtu = paramString1;
    zzbtv = paramzzp;
    orientation = paramInt;
    zzbtw = 3;
    url = null;
    zzaou = paramVersionInfoParcel;
    zzbtx = paramzzev;
    zzbty = null;
    zzbtz = null;
  }
  
  public AdOverlayInfoParcel(AdLauncherIntentInfoParcel paramAdLauncherIntentInfoParcel, zza paramzza, zzg paramzzg, zzp paramzzp, VersionInfoParcel paramVersionInfoParcel)
  {
    versionCode = 4;
    zzbtn = paramAdLauncherIntentInfoParcel;
    zzbto = paramzza;
    zzbtp = paramzzg;
    zzbtq = null;
    zzbtr = null;
    zzbts = null;
    zzbtt = false;
    zzbtu = null;
    zzbtv = paramzzp;
    orientation = -1;
    zzbtw = 4;
    url = null;
    zzaou = paramVersionInfoParcel;
    zzbtx = null;
    zzbty = null;
    zzbtz = null;
  }
  
  public static void zza(Intent paramIntent, AdOverlayInfoParcel paramAdOverlayInfoParcel)
  {
    Bundle localBundle = new Bundle(1);
    localBundle.putParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", paramAdOverlayInfoParcel);
    paramIntent.putExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", localBundle);
  }
  
  public static AdOverlayInfoParcel zzb(Intent paramIntent)
  {
    try
    {
      paramIntent = paramIntent.getBundleExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
      paramIntent.setClassLoader(AdOverlayInfoParcel.class.getClassLoader());
      paramIntent = (AdOverlayInfoParcel)paramIntent.getParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
      return paramIntent;
    }
    catch (Exception paramIntent) {}
    return null;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzf.zza(this, paramParcel, paramInt);
  }
  
  IBinder zzoe()
  {
    return zze.zzae(zzbto).asBinder();
  }
  
  IBinder zzof()
  {
    return zze.zzae(zzbtp).asBinder();
  }
  
  IBinder zzog()
  {
    return zze.zzae(zzbtq).asBinder();
  }
  
  IBinder zzoh()
  {
    return zze.zzae(zzbtr).asBinder();
  }
  
  IBinder zzoi()
  {
    return zze.zzae(zzbtx).asBinder();
  }
  
  IBinder zzoj()
  {
    return zze.zzae(zzbtv).asBinder();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */