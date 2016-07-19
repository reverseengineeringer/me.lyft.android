package com.google.android.gms.ads;

import android.location.Location;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.internal.client.zzad.zza;
import com.google.android.gms.ads.mediation.MediationAdapter;
import java.util.Date;

public final class AdRequest$Builder
{
  private final zzad.zza zzaid = new zzad.zza();
  
  public AdRequest$Builder()
  {
    zzaid.zzag(AdRequest.DEVICE_ID_EMULATOR);
  }
  
  public Builder addKeyword(String paramString)
  {
    zzaid.zzaf(paramString);
    return this;
  }
  
  public Builder addNetworkExtrasBundle(Class<? extends MediationAdapter> paramClass, Bundle paramBundle)
  {
    zzaid.zza(paramClass, paramBundle);
    if ((paramClass.equals(AdMobAdapter.class)) && (paramBundle.getBoolean("_emulatorLiveAds"))) {
      zzaid.zzah(AdRequest.DEVICE_ID_EMULATOR);
    }
    return this;
  }
  
  public Builder addTestDevice(String paramString)
  {
    zzaid.zzag(paramString);
    return this;
  }
  
  public AdRequest build()
  {
    return new AdRequest(this, null);
  }
  
  public Builder setBirthday(Date paramDate)
  {
    zzaid.zza(paramDate);
    return this;
  }
  
  public Builder setGender(int paramInt)
  {
    zzaid.zzt(paramInt);
    return this;
  }
  
  public Builder setIsDesignedForFamilies(boolean paramBoolean)
  {
    zzaid.zzo(paramBoolean);
    return this;
  }
  
  public Builder setLocation(Location paramLocation)
  {
    zzaid.zzb(paramLocation);
    return this;
  }
  
  public Builder tagForChildDirectedTreatment(boolean paramBoolean)
  {
    zzaid.zzn(paramBoolean);
    return this;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.AdRequest.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */