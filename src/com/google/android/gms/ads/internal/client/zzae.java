package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.Correlator;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.doubleclick.OnCustomRenderedAdLoadedListener;
import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzdp;
import com.google.android.gms.internal.zzgm;
import com.google.android.gms.internal.zzhx;
import com.google.android.gms.internal.zzib;
import com.google.android.gms.internal.zzir;
import java.util.concurrent.atomic.AtomicBoolean;

@zzir
public class zzae
{
  private final zzh zzahz;
  private boolean zzakp;
  private String zzall;
  private zza zzati;
  private AdListener zzatj;
  private AppEventListener zzauv;
  private AdSize[] zzauw;
  private final zzgm zzavz = new zzgm();
  private final AtomicBoolean zzawa;
  private final VideoController zzawb = new VideoController();
  final zzo zzawc = new zzo()
  {
    public void onAdFailedToLoad(int paramAnonymousInt)
    {
      zzae.zza(zzae.this).zza(zzjk());
      super.onAdFailedToLoad(paramAnonymousInt);
    }
    
    public void onAdLoaded()
    {
      zzae.zza(zzae.this).zza(zzjk());
      super.onAdLoaded();
    }
  };
  private Correlator zzawd;
  private zzu zzawe;
  private InAppPurchaseListener zzawf;
  private OnCustomRenderedAdLoadedListener zzawg;
  private PlayStorePurchaseListener zzawh;
  private VideoOptions zzawi;
  private String zzawj;
  private ViewGroup zzawk;
  private boolean zzawl;
  
  zzae(ViewGroup paramViewGroup, AttributeSet paramAttributeSet, boolean paramBoolean1, zzh paramzzh, zzu paramzzu, boolean paramBoolean2)
  {
    zzawk = paramViewGroup;
    zzahz = paramzzh;
    zzawe = paramzzu;
    zzawa = new AtomicBoolean(false);
    zzawl = paramBoolean2;
    if (paramAttributeSet != null) {
      paramzzh = paramViewGroup.getContext();
    }
    try
    {
      paramAttributeSet = new zzk(paramzzh, paramAttributeSet);
      zzauw = paramAttributeSet.zzl(paramBoolean1);
      zzall = paramAttributeSet.getAdUnitId();
      if (paramViewGroup.isInEditMode()) {
        zzm.zziw().zza(paramViewGroup, zza(paramzzh, zzauw[0], zzawl), "Ads by Google");
      }
      return;
    }
    catch (IllegalArgumentException paramAttributeSet)
    {
      zzm.zziw().zza(paramViewGroup, new AdSizeParcel(paramzzh, AdSize.BANNER), paramAttributeSet.getMessage(), paramAttributeSet.getMessage());
    }
  }
  
  zzae(ViewGroup paramViewGroup, AttributeSet paramAttributeSet, boolean paramBoolean1, zzh paramzzh, boolean paramBoolean2)
  {
    this(paramViewGroup, paramAttributeSet, paramBoolean1, paramzzh, null, paramBoolean2);
  }
  
  public zzae(ViewGroup paramViewGroup, boolean paramBoolean)
  {
    this(paramViewGroup, null, false, zzh.zzih(), paramBoolean);
  }
  
  private static AdSizeParcel zza(Context paramContext, AdSize paramAdSize, boolean paramBoolean)
  {
    paramContext = new AdSizeParcel(paramContext, paramAdSize);
    paramContext.zzk(paramBoolean);
    return paramContext;
  }
  
  private static AdSizeParcel zza(Context paramContext, AdSize[] paramArrayOfAdSize, boolean paramBoolean)
  {
    paramContext = new AdSizeParcel(paramContext, paramArrayOfAdSize);
    paramContext.zzk(paramBoolean);
    return paramContext;
  }
  
  private void zzjl()
  {
    try
    {
      zzd localzzd = zzawe.zzdn();
      if (localzzd == null) {
        return;
      }
      zzawk.addView((View)zze.zzad(localzzd));
      return;
    }
    catch (RemoteException localRemoteException)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to get an ad frame.", localRemoteException);
    }
  }
  
  public void destroy()
  {
    try
    {
      if (zzawe != null) {
        zzawe.destroy();
      }
      return;
    }
    catch (RemoteException localRemoteException)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to destroy AdView.", localRemoteException);
    }
  }
  
  public AdListener getAdListener()
  {
    return zzatj;
  }
  
  public AdSize getAdSize()
  {
    try
    {
      if (zzawe != null)
      {
        Object localObject = zzawe.zzdo();
        if (localObject != null)
        {
          localObject = ((AdSizeParcel)localObject).zzij();
          return (AdSize)localObject;
        }
      }
    }
    catch (RemoteException localRemoteException)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to get the current AdSize.", localRemoteException);
      if (zzauw != null) {
        return zzauw[0];
      }
    }
    return null;
  }
  
  public AdSize[] getAdSizes()
  {
    return zzauw;
  }
  
  public String getAdUnitId()
  {
    return zzall;
  }
  
  public AppEventListener getAppEventListener()
  {
    return zzauv;
  }
  
  public InAppPurchaseListener getInAppPurchaseListener()
  {
    return zzawf;
  }
  
  public String getMediationAdapterClassName()
  {
    try
    {
      if (zzawe != null)
      {
        String str = zzawe.getMediationAdapterClassName();
        return str;
      }
    }
    catch (RemoteException localRemoteException)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to get the mediation adapter class name.", localRemoteException);
    }
    return null;
  }
  
  public OnCustomRenderedAdLoadedListener getOnCustomRenderedAdLoadedListener()
  {
    return zzawg;
  }
  
  public void pause()
  {
    try
    {
      if (zzawe != null) {
        zzawe.pause();
      }
      return;
    }
    catch (RemoteException localRemoteException)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to call pause.", localRemoteException);
    }
  }
  
  public void resume()
  {
    try
    {
      if (zzawe != null) {
        zzawe.resume();
      }
      return;
    }
    catch (RemoteException localRemoteException)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to call resume.", localRemoteException);
    }
  }
  
  public void setAdListener(AdListener paramAdListener)
  {
    zzatj = paramAdListener;
    zzawc.zza(paramAdListener);
  }
  
  public void setAdSizes(AdSize... paramVarArgs)
  {
    if (zzauw != null) {
      throw new IllegalStateException("The ad size can only be set once on AdView.");
    }
    zza(paramVarArgs);
  }
  
  public void setAdUnitId(String paramString)
  {
    if (zzall != null) {
      throw new IllegalStateException("The ad unit ID can only be set once on AdView.");
    }
    zzall = paramString;
  }
  
  public void setAppEventListener(AppEventListener paramAppEventListener)
  {
    try
    {
      zzauv = paramAppEventListener;
      zzu localzzu;
      if (zzawe != null)
      {
        localzzu = zzawe;
        if (paramAppEventListener == null) {
          break label38;
        }
      }
      label38:
      for (paramAppEventListener = new zzj(paramAppEventListener);; paramAppEventListener = null)
      {
        localzzu.zza(paramAppEventListener);
        return;
      }
      return;
    }
    catch (RemoteException paramAppEventListener)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to set the AppEventListener.", paramAppEventListener);
    }
  }
  
  public void setCorrelator(Correlator paramCorrelator)
  {
    zzawd = paramCorrelator;
    try
    {
      if (zzawe != null)
      {
        zzu localzzu = zzawe;
        if (zzawd == null) {}
        for (paramCorrelator = null;; paramCorrelator = zzawd.zzde())
        {
          localzzu.zza(paramCorrelator);
          return;
        }
      }
      return;
    }
    catch (RemoteException paramCorrelator)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to set correlator.", paramCorrelator);
    }
  }
  
  public void setInAppPurchaseListener(InAppPurchaseListener paramInAppPurchaseListener)
  {
    if (zzawh != null) {
      throw new IllegalStateException("Play store purchase parameter has already been set.");
    }
    try
    {
      zzawf = paramInAppPurchaseListener;
      zzu localzzu;
      if (zzawe != null)
      {
        localzzu = zzawe;
        if (paramInAppPurchaseListener == null) {
          break label56;
        }
      }
      label56:
      for (paramInAppPurchaseListener = new zzhx(paramInAppPurchaseListener);; paramInAppPurchaseListener = null)
      {
        localzzu.zza(paramInAppPurchaseListener);
        return;
      }
      return;
    }
    catch (RemoteException paramInAppPurchaseListener)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to set the InAppPurchaseListener.", paramInAppPurchaseListener);
    }
  }
  
  public void setManualImpressionsEnabled(boolean paramBoolean)
  {
    zzakp = paramBoolean;
    try
    {
      if (zzawe != null) {
        zzawe.setManualImpressionsEnabled(zzakp);
      }
      return;
    }
    catch (RemoteException localRemoteException)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to set manual impressions.", localRemoteException);
    }
  }
  
  public void setOnCustomRenderedAdLoadedListener(OnCustomRenderedAdLoadedListener paramOnCustomRenderedAdLoadedListener)
  {
    zzawg = paramOnCustomRenderedAdLoadedListener;
    try
    {
      zzu localzzu;
      if (zzawe != null)
      {
        localzzu = zzawe;
        if (paramOnCustomRenderedAdLoadedListener == null) {
          break label38;
        }
      }
      label38:
      for (paramOnCustomRenderedAdLoadedListener = new zzdp(paramOnCustomRenderedAdLoadedListener);; paramOnCustomRenderedAdLoadedListener = null)
      {
        localzzu.zza(paramOnCustomRenderedAdLoadedListener);
        return;
      }
      return;
    }
    catch (RemoteException paramOnCustomRenderedAdLoadedListener)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to set the onCustomRenderedAdLoadedListener.", paramOnCustomRenderedAdLoadedListener);
    }
  }
  
  public void zza(zza paramzza)
  {
    try
    {
      zzati = paramzza;
      zzu localzzu;
      if (zzawe != null)
      {
        localzzu = zzawe;
        if (paramzza == null) {
          break label38;
        }
      }
      label38:
      for (paramzza = new zzb(paramzza);; paramzza = null)
      {
        localzzu.zza(paramzza);
        return;
      }
      return;
    }
    catch (RemoteException paramzza)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to set the AdClickListener.", paramzza);
    }
  }
  
  public void zza(zzad paramzzad)
  {
    try
    {
      if (zzawe == null) {
        zzjm();
      }
      if (zzawe.zzb(zzahz.zza(zzawk.getContext(), paramzzad))) {
        zzavz.zzh(paramzzad.zzjg());
      }
      return;
    }
    catch (RemoteException paramzzad)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to load ad.", paramzzad);
    }
  }
  
  public void zza(AdSize... paramVarArgs)
  {
    zzauw = paramVarArgs;
    try
    {
      if (zzawe != null) {
        zzawe.zza(zza(zzawk.getContext(), zzauw, zzawl));
      }
      zzawk.requestLayout();
      return;
    }
    catch (RemoteException paramVarArgs)
    {
      for (;;)
      {
        com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to set the ad size.", paramVarArgs);
      }
    }
  }
  
  public boolean zzb(AdSizeParcel paramAdSizeParcel)
  {
    return "search_v2".equals(zzaup);
  }
  
  public zzab zzjk()
  {
    if (zzawe == null) {
      return null;
    }
    try
    {
      zzab localzzab = zzawe.zzdr();
      return localzzab;
    }
    catch (RemoteException localRemoteException)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to retrieve VideoController.", localRemoteException);
    }
    return null;
  }
  
  void zzjm()
    throws RemoteException
  {
    if (((zzauw == null) || (zzall == null)) && (zzawe == null)) {
      throw new IllegalStateException("The ad size and ad unit ID must be set before loadAd is called.");
    }
    zzawe = zzjn();
    zzawe.zza(new zzc(zzawc));
    if (zzati != null) {
      zzawe.zza(new zzb(zzati));
    }
    if (zzauv != null) {
      zzawe.zza(new zzj(zzauv));
    }
    if (zzawf != null) {
      zzawe.zza(new zzhx(zzawf));
    }
    if (zzawh != null) {
      zzawe.zza(new zzib(zzawh), zzawj);
    }
    if (zzawg != null) {
      zzawe.zza(new zzdp(zzawg));
    }
    if (zzawd != null) {
      zzawe.zza(zzawd.zzde());
    }
    if (zzawi != null) {
      zzawe.zza(new VideoOptionsParcel(zzawi));
    }
    zzawe.setManualImpressionsEnabled(zzakp);
    zzjl();
  }
  
  protected zzu zzjn()
    throws RemoteException
  {
    Context localContext = zzawk.getContext();
    AdSizeParcel localAdSizeParcel = zza(localContext, zzauw, zzawl);
    if (zzb(localAdSizeParcel)) {
      return zzm.zzix().zza(localContext, localAdSizeParcel, zzall);
    }
    return zzm.zzix().zza(localContext, localAdSizeParcel, zzall, zzavz);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.client.zzae
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */