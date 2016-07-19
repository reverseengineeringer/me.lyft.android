package com.google.android.gms.internal;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.formats.NativeAd.Image;
import com.google.android.gms.ads.internal.formats.zzc;
import com.google.android.gms.ads.mediation.NativeAppInstallAdMapper;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@zzir
public class zzgw
  extends zzgr.zza
{
  private final NativeAppInstallAdMapper zzbpq;
  
  public zzgw(NativeAppInstallAdMapper paramNativeAppInstallAdMapper)
  {
    zzbpq = paramNativeAppInstallAdMapper;
  }
  
  public String getBody()
  {
    return zzbpq.getBody();
  }
  
  public String getCallToAction()
  {
    return zzbpq.getCallToAction();
  }
  
  public Bundle getExtras()
  {
    return zzbpq.getExtras();
  }
  
  public String getHeadline()
  {
    return zzbpq.getHeadline();
  }
  
  public List getImages()
  {
    Object localObject = zzbpq.getImages();
    if (localObject != null)
    {
      ArrayList localArrayList = new ArrayList();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        NativeAd.Image localImage = (NativeAd.Image)((Iterator)localObject).next();
        localArrayList.add(new zzc(localImage.getDrawable(), localImage.getUri(), localImage.getScale()));
      }
      return localArrayList;
    }
    return null;
  }
  
  public boolean getOverrideClickHandling()
  {
    return zzbpq.getOverrideClickHandling();
  }
  
  public boolean getOverrideImpressionRecording()
  {
    return zzbpq.getOverrideImpressionRecording();
  }
  
  public String getPrice()
  {
    return zzbpq.getPrice();
  }
  
  public double getStarRating()
  {
    return zzbpq.getStarRating();
  }
  
  public String getStore()
  {
    return zzbpq.getStore();
  }
  
  public void recordImpression()
  {
    zzbpq.recordImpression();
  }
  
  public void zzk(zzd paramzzd)
  {
    zzbpq.handleClick((View)zze.zzad(paramzzd));
  }
  
  public zzdu zzkw()
  {
    NativeAd.Image localImage = zzbpq.getIcon();
    if (localImage != null) {
      return new zzc(localImage.getDrawable(), localImage.getUri(), localImage.getScale());
    }
    return null;
  }
  
  public void zzl(zzd paramzzd)
  {
    zzbpq.trackView((View)zze.zzad(paramzzd));
  }
  
  public void zzm(zzd paramzzd)
  {
    zzbpq.untrackView((View)zze.zzad(paramzzd));
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzgw
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */