package com.google.android.gms.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.NativeAppInstallAd.OnAppInstallAdLoadedListener;
import com.google.android.gms.ads.formats.NativeContentAd.OnContentAdLoadedListener;
import com.google.android.gms.ads.internal.client.zzc;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.client.zzm;
import com.google.android.gms.ads.internal.client.zzs;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.internal.zzej;
import com.google.android.gms.internal.zzek;
import com.google.android.gms.internal.zzgm;

public class AdLoader$Builder
{
  private final Context mContext;
  private final zzs zzaib;
  
  AdLoader$Builder(Context paramContext, zzs paramzzs)
  {
    mContext = paramContext;
    zzaib = paramzzs;
  }
  
  public AdLoader$Builder(Context paramContext, String paramString)
  {
    this((Context)zzab.zzb(paramContext, "context cannot be null"), zzm.zzix().zzb(paramContext, paramString, new zzgm()));
  }
  
  public AdLoader build()
  {
    try
    {
      AdLoader localAdLoader = new AdLoader(mContext, zzaib.zzes());
      return localAdLoader;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzb("Failed to build AdLoader.", localRemoteException);
    }
    return null;
  }
  
  public Builder forAppInstallAd(NativeAppInstallAd.OnAppInstallAdLoadedListener paramOnAppInstallAdLoadedListener)
  {
    try
    {
      zzaib.zza(new zzej(paramOnAppInstallAdLoadedListener));
      return this;
    }
    catch (RemoteException paramOnAppInstallAdLoadedListener)
    {
      zzb.zzd("Failed to add app install ad listener", paramOnAppInstallAdLoadedListener);
    }
    return this;
  }
  
  public Builder forContentAd(NativeContentAd.OnContentAdLoadedListener paramOnContentAdLoadedListener)
  {
    try
    {
      zzaib.zza(new zzek(paramOnContentAdLoadedListener));
      return this;
    }
    catch (RemoteException paramOnContentAdLoadedListener)
    {
      zzb.zzd("Failed to add content ad listener", paramOnContentAdLoadedListener);
    }
    return this;
  }
  
  public Builder withAdListener(AdListener paramAdListener)
  {
    try
    {
      zzaib.zzb(new zzc(paramAdListener));
      return this;
    }
    catch (RemoteException paramAdListener)
    {
      zzb.zzd("Failed to set AdListener.", paramAdListener);
    }
    return this;
  }
  
  public Builder withNativeAdOptions(NativeAdOptions paramNativeAdOptions)
  {
    try
    {
      zzaib.zza(new NativeAdOptionsParcel(paramNativeAdOptions));
      return this;
    }
    catch (RemoteException paramNativeAdOptions)
    {
      zzb.zzd("Failed to specify native ad options", paramNativeAdOptions);
    }
    return this;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.AdLoader.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */