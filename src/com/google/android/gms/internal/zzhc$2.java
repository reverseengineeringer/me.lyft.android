package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.overlay.zzg;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;

class zzhc$2
  implements zzg
{
  zzhc$2(zzhc paramzzhc) {}
  
  public void onPause()
  {
    zzb.zzcw("AdMobCustomTabsAdapter overlay is paused.");
  }
  
  public void onResume()
  {
    zzb.zzcw("AdMobCustomTabsAdapter overlay is resumed.");
  }
  
  public void zzdy()
  {
    zzb.zzcw("AdMobCustomTabsAdapter overlay is closed.");
    zzhc.zza(zzbqb).onAdClosed(zzbqb);
    zzhc.zzc(zzbqb).zzd(zzhc.zzb(zzbqb));
  }
  
  public void zzdz()
  {
    zzb.zzcw("Opening AdMobCustomTabsAdapter overlay.");
    zzhc.zza(zzbqb).onAdOpened(zzbqb);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzhc.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */