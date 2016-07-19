package com.google.android.gms.internal;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.formats.NativeAd.Image;
import com.google.android.gms.ads.internal.formats.zzc;
import com.google.android.gms.ads.mediation.NativeContentAdMapper;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@zzir
public class zzgx
  extends zzgs.zza
{
  private final NativeContentAdMapper zzbpr;
  
  public zzgx(NativeContentAdMapper paramNativeContentAdMapper)
  {
    zzbpr = paramNativeContentAdMapper;
  }
  
  public String getAdvertiser()
  {
    return zzbpr.getAdvertiser();
  }
  
  public String getBody()
  {
    return zzbpr.getBody();
  }
  
  public String getCallToAction()
  {
    return zzbpr.getCallToAction();
  }
  
  public Bundle getExtras()
  {
    return zzbpr.getExtras();
  }
  
  public String getHeadline()
  {
    return zzbpr.getHeadline();
  }
  
  public List getImages()
  {
    Object localObject = zzbpr.getImages();
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
    return zzbpr.getOverrideClickHandling();
  }
  
  public boolean getOverrideImpressionRecording()
  {
    return zzbpr.getOverrideImpressionRecording();
  }
  
  public void recordImpression()
  {
    zzbpr.recordImpression();
  }
  
  public void zzk(zzd paramzzd)
  {
    zzbpr.handleClick((View)zze.zzad(paramzzd));
  }
  
  public void zzl(zzd paramzzd)
  {
    zzbpr.trackView((View)zze.zzad(paramzzd));
  }
  
  public zzdu zzla()
  {
    NativeAd.Image localImage = zzbpr.getLogo();
    if (localImage != null) {
      return new zzc(localImage.getDrawable(), localImage.getUri(), localImage.getScale());
    }
    return null;
  }
  
  public void zzm(zzd paramzzd)
  {
    zzbpr.untrackView((View)zze.zzad(paramzzd));
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzgx
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */