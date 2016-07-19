package com.google.ads.mediation;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdLoader.Builder;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdRequest.Builder;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.NativeAdView;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.ads.formats.NativeAppInstallAd.OnAppInstallAdLoadedListener;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.ads.formats.NativeContentAd.OnContentAdLoadedListener;
import com.google.android.gms.ads.internal.client.zzm;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationAdapter.zza;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationNativeListener;
import com.google.android.gms.ads.mediation.NativeAppInstallAdMapper;
import com.google.android.gms.ads.mediation.NativeContentAdMapper;
import com.google.android.gms.ads.mediation.NativeMediationAdRequest;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener;
import com.google.android.gms.internal.zzir;
import com.google.android.gms.internal.zzlx;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

@zzir
public abstract class AbstractAdViewAdapter
  implements MediationBannerAdapter, MediationNativeAdapter, MediationRewardedVideoAdAdapter, zzlx
{
  protected AdView zzfb;
  protected InterstitialAd zzfc;
  private AdLoader zzfd;
  private Context zzfe;
  private InterstitialAd zzff;
  private MediationRewardedVideoAdListener zzfg;
  final RewardedVideoAdListener zzfh = new RewardedVideoAdListener()
  {
    public void onRewarded(RewardItem paramAnonymousRewardItem)
    {
      AbstractAdViewAdapter.zza(AbstractAdViewAdapter.this).onRewarded(AbstractAdViewAdapter.this, paramAnonymousRewardItem);
    }
    
    public void onRewardedVideoAdClosed()
    {
      AbstractAdViewAdapter.zza(AbstractAdViewAdapter.this).onAdClosed(AbstractAdViewAdapter.this);
      AbstractAdViewAdapter.zza(AbstractAdViewAdapter.this, null);
    }
    
    public void onRewardedVideoAdFailedToLoad(int paramAnonymousInt)
    {
      AbstractAdViewAdapter.zza(AbstractAdViewAdapter.this).onAdFailedToLoad(AbstractAdViewAdapter.this, paramAnonymousInt);
    }
    
    public void onRewardedVideoAdLeftApplication()
    {
      AbstractAdViewAdapter.zza(AbstractAdViewAdapter.this).onAdLeftApplication(AbstractAdViewAdapter.this);
    }
    
    public void onRewardedVideoAdLoaded()
    {
      AbstractAdViewAdapter.zza(AbstractAdViewAdapter.this).onAdLoaded(AbstractAdViewAdapter.this);
    }
    
    public void onRewardedVideoAdOpened()
    {
      AbstractAdViewAdapter.zza(AbstractAdViewAdapter.this).onAdOpened(AbstractAdViewAdapter.this);
    }
    
    public void onRewardedVideoStarted()
    {
      AbstractAdViewAdapter.zza(AbstractAdViewAdapter.this).onVideoStarted(AbstractAdViewAdapter.this);
    }
  };
  
  public String getAdUnitId(Bundle paramBundle)
  {
    return paramBundle.getString("pubid");
  }
  
  public View getBannerView()
  {
    return zzfb;
  }
  
  public Bundle getInterstitialAdapterInfo()
  {
    return new MediationAdapter.zza().zzbb(1).zzvp();
  }
  
  public void initialize(Context paramContext, MediationAdRequest paramMediationAdRequest, String paramString, MediationRewardedVideoAdListener paramMediationRewardedVideoAdListener, Bundle paramBundle1, Bundle paramBundle2)
  {
    zzfe = paramContext.getApplicationContext();
    zzfg = paramMediationRewardedVideoAdListener;
    zzfg.onInitializationSucceeded(this);
  }
  
  public boolean isInitialized()
  {
    return zzfg != null;
  }
  
  public void loadAd(MediationAdRequest paramMediationAdRequest, Bundle paramBundle1, Bundle paramBundle2)
  {
    if ((zzfe == null) || (zzfg == null))
    {
      zzb.e("AdMobAdapter.loadAd called before initialize.");
      return;
    }
    zzff = new InterstitialAd(zzfe);
    zzff.zzd(true);
    zzff.setAdUnitId(getAdUnitId(paramBundle1));
    zzff.setRewardedVideoAdListener(zzfh);
    zzff.loadAd(zza(zzfe, paramMediationAdRequest, paramBundle2, paramBundle1));
  }
  
  public void onDestroy()
  {
    if (zzfb != null)
    {
      zzfb.destroy();
      zzfb = null;
    }
    if (zzfc != null) {
      zzfc = null;
    }
    if (zzfd != null) {
      zzfd = null;
    }
    if (zzff != null) {
      zzff = null;
    }
  }
  
  public void onPause()
  {
    if (zzfb != null) {
      zzfb.pause();
    }
  }
  
  public void onResume()
  {
    if (zzfb != null) {
      zzfb.resume();
    }
  }
  
  public void requestBannerAd(Context paramContext, MediationBannerListener paramMediationBannerListener, Bundle paramBundle1, AdSize paramAdSize, MediationAdRequest paramMediationAdRequest, Bundle paramBundle2)
  {
    zzfb = new AdView(paramContext);
    zzfb.setAdSize(new AdSize(paramAdSize.getWidth(), paramAdSize.getHeight()));
    zzfb.setAdUnitId(getAdUnitId(paramBundle1));
    zzfb.setAdListener(new zzc(this, paramMediationBannerListener));
    zzfb.loadAd(zza(paramContext, paramMediationAdRequest, paramBundle2, paramBundle1));
  }
  
  public void requestInterstitialAd(Context paramContext, MediationInterstitialListener paramMediationInterstitialListener, Bundle paramBundle1, MediationAdRequest paramMediationAdRequest, Bundle paramBundle2)
  {
    zzfc = new InterstitialAd(paramContext);
    zzfc.setAdUnitId(getAdUnitId(paramBundle1));
    zzfc.setAdListener(new zzd(this, paramMediationInterstitialListener));
    zzfc.loadAd(zza(paramContext, paramMediationAdRequest, paramBundle2, paramBundle1));
  }
  
  public void requestNativeAd(Context paramContext, MediationNativeListener paramMediationNativeListener, Bundle paramBundle1, NativeMediationAdRequest paramNativeMediationAdRequest, Bundle paramBundle2)
  {
    paramMediationNativeListener = new zze(this, paramMediationNativeListener);
    AdLoader.Builder localBuilder = zza(paramContext, paramBundle1.getString("pubid")).withAdListener(paramMediationNativeListener);
    NativeAdOptions localNativeAdOptions = paramNativeMediationAdRequest.getNativeAdOptions();
    if (localNativeAdOptions != null) {
      localBuilder.withNativeAdOptions(localNativeAdOptions);
    }
    if (paramNativeMediationAdRequest.isAppInstallAdRequested()) {
      localBuilder.forAppInstallAd(paramMediationNativeListener);
    }
    if (paramNativeMediationAdRequest.isContentAdRequested()) {
      localBuilder.forContentAd(paramMediationNativeListener);
    }
    zzfd = localBuilder.build();
    zzfd.loadAd(zza(paramContext, paramNativeMediationAdRequest, paramBundle2, paramBundle1));
  }
  
  public void showInterstitial()
  {
    zzfc.show();
  }
  
  public void showVideo()
  {
    zzff.show();
  }
  
  protected abstract Bundle zza(Bundle paramBundle1, Bundle paramBundle2);
  
  AdLoader.Builder zza(Context paramContext, String paramString)
  {
    return new AdLoader.Builder(paramContext, paramString);
  }
  
  AdRequest zza(Context paramContext, MediationAdRequest paramMediationAdRequest, Bundle paramBundle1, Bundle paramBundle2)
  {
    AdRequest.Builder localBuilder = new AdRequest.Builder();
    Object localObject = paramMediationAdRequest.getBirthday();
    if (localObject != null) {
      localBuilder.setBirthday((Date)localObject);
    }
    int i = paramMediationAdRequest.getGender();
    if (i != 0) {
      localBuilder.setGender(i);
    }
    localObject = paramMediationAdRequest.getKeywords();
    if (localObject != null)
    {
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        localBuilder.addKeyword((String)((Iterator)localObject).next());
      }
    }
    localObject = paramMediationAdRequest.getLocation();
    if (localObject != null) {
      localBuilder.setLocation((Location)localObject);
    }
    if (paramMediationAdRequest.isTesting()) {
      localBuilder.addTestDevice(zzm.zziw().zzaq(paramContext));
    }
    if (paramMediationAdRequest.taggedForChildDirectedTreatment() != -1) {
      if (paramMediationAdRequest.taggedForChildDirectedTreatment() != 1) {
        break label210;
      }
    }
    label210:
    for (boolean bool = true;; bool = false)
    {
      localBuilder.tagForChildDirectedTreatment(bool);
      localBuilder.setIsDesignedForFamilies(paramMediationAdRequest.isDesignedForFamilies());
      localBuilder.addNetworkExtrasBundle(AdMobAdapter.class, zza(paramBundle1, paramBundle2));
      return localBuilder.build();
    }
  }
  
  static class zza
    extends NativeAppInstallAdMapper
  {
    private final NativeAppInstallAd zzfj;
    
    public zza(NativeAppInstallAd paramNativeAppInstallAd)
    {
      zzfj = paramNativeAppInstallAd;
      setHeadline(paramNativeAppInstallAd.getHeadline().toString());
      setImages(paramNativeAppInstallAd.getImages());
      setBody(paramNativeAppInstallAd.getBody().toString());
      setIcon(paramNativeAppInstallAd.getIcon());
      setCallToAction(paramNativeAppInstallAd.getCallToAction().toString());
      setStarRating(paramNativeAppInstallAd.getStarRating().doubleValue());
      setStore(paramNativeAppInstallAd.getStore().toString());
      setPrice(paramNativeAppInstallAd.getPrice().toString());
      setOverrideImpressionRecording(true);
      setOverrideClickHandling(true);
    }
    
    public void trackView(View paramView)
    {
      if ((paramView instanceof NativeAdView)) {
        ((NativeAdView)paramView).setNativeAd(zzfj);
      }
    }
  }
  
  static class zzb
    extends NativeContentAdMapper
  {
    private final NativeContentAd zzfk;
    
    public zzb(NativeContentAd paramNativeContentAd)
    {
      zzfk = paramNativeContentAd;
      setHeadline(paramNativeContentAd.getHeadline().toString());
      setImages(paramNativeContentAd.getImages());
      setBody(paramNativeContentAd.getBody().toString());
      setLogo(paramNativeContentAd.getLogo());
      setCallToAction(paramNativeContentAd.getCallToAction().toString());
      setAdvertiser(paramNativeContentAd.getAdvertiser().toString());
      setOverrideImpressionRecording(true);
      setOverrideClickHandling(true);
    }
    
    public void trackView(View paramView)
    {
      if ((paramView instanceof NativeAdView)) {
        ((NativeAdView)paramView).setNativeAd(zzfk);
      }
    }
  }
  
  static final class zzc
    extends AdListener
    implements com.google.android.gms.ads.internal.client.zza
  {
    final AbstractAdViewAdapter zzfl;
    final MediationBannerListener zzfm;
    
    public zzc(AbstractAdViewAdapter paramAbstractAdViewAdapter, MediationBannerListener paramMediationBannerListener)
    {
      zzfl = paramAbstractAdViewAdapter;
      zzfm = paramMediationBannerListener;
    }
    
    public void onAdClicked()
    {
      zzfm.onAdClicked(zzfl);
    }
    
    public void onAdClosed()
    {
      zzfm.onAdClosed(zzfl);
    }
    
    public void onAdFailedToLoad(int paramInt)
    {
      zzfm.onAdFailedToLoad(zzfl, paramInt);
    }
    
    public void onAdLeftApplication()
    {
      zzfm.onAdLeftApplication(zzfl);
    }
    
    public void onAdLoaded()
    {
      zzfm.onAdLoaded(zzfl);
    }
    
    public void onAdOpened()
    {
      zzfm.onAdOpened(zzfl);
    }
  }
  
  static final class zzd
    extends AdListener
    implements com.google.android.gms.ads.internal.client.zza
  {
    final AbstractAdViewAdapter zzfl;
    final MediationInterstitialListener zzfn;
    
    public zzd(AbstractAdViewAdapter paramAbstractAdViewAdapter, MediationInterstitialListener paramMediationInterstitialListener)
    {
      zzfl = paramAbstractAdViewAdapter;
      zzfn = paramMediationInterstitialListener;
    }
    
    public void onAdClicked()
    {
      zzfn.onAdClicked(zzfl);
    }
    
    public void onAdClosed()
    {
      zzfn.onAdClosed(zzfl);
    }
    
    public void onAdFailedToLoad(int paramInt)
    {
      zzfn.onAdFailedToLoad(zzfl, paramInt);
    }
    
    public void onAdLeftApplication()
    {
      zzfn.onAdLeftApplication(zzfl);
    }
    
    public void onAdLoaded()
    {
      zzfn.onAdLoaded(zzfl);
    }
    
    public void onAdOpened()
    {
      zzfn.onAdOpened(zzfl);
    }
  }
  
  static final class zze
    extends AdListener
    implements NativeAppInstallAd.OnAppInstallAdLoadedListener, NativeContentAd.OnContentAdLoadedListener, com.google.android.gms.ads.internal.client.zza
  {
    final AbstractAdViewAdapter zzfl;
    final MediationNativeListener zzfo;
    
    public zze(AbstractAdViewAdapter paramAbstractAdViewAdapter, MediationNativeListener paramMediationNativeListener)
    {
      zzfl = paramAbstractAdViewAdapter;
      zzfo = paramMediationNativeListener;
    }
    
    public void onAdClicked()
    {
      zzfo.onAdClicked(zzfl);
    }
    
    public void onAdClosed()
    {
      zzfo.onAdClosed(zzfl);
    }
    
    public void onAdFailedToLoad(int paramInt)
    {
      zzfo.onAdFailedToLoad(zzfl, paramInt);
    }
    
    public void onAdLeftApplication()
    {
      zzfo.onAdLeftApplication(zzfl);
    }
    
    public void onAdLoaded() {}
    
    public void onAdOpened()
    {
      zzfo.onAdOpened(zzfl);
    }
    
    public void onAppInstallAdLoaded(NativeAppInstallAd paramNativeAppInstallAd)
    {
      zzfo.onAdLoaded(zzfl, new AbstractAdViewAdapter.zza(paramNativeAppInstallAd));
    }
    
    public void onContentAdLoaded(NativeContentAd paramNativeContentAd)
    {
      zzfo.onAdLoaded(zzfl, new AbstractAdViewAdapter.zzb(paramNativeContentAd));
    }
  }
}

/* Location:
 * Qualified Name:     com.google.ads.mediation.AbstractAdViewAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */