package com.google.android.gms.ads.mediation;

import com.google.android.gms.ads.formats.NativeAd.Image;
import java.util.List;

public abstract class NativeAppInstallAdMapper
  extends NativeAdMapper
{
  private String zzbfk;
  private List<NativeAd.Image> zzbfl;
  private String zzbfm;
  private String zzbfo;
  private double zzbfp;
  private String zzbfq;
  private String zzbfr;
  private NativeAd.Image zzcqs;
  
  public final String getBody()
  {
    return zzbfm;
  }
  
  public final String getCallToAction()
  {
    return zzbfo;
  }
  
  public final String getHeadline()
  {
    return zzbfk;
  }
  
  public final NativeAd.Image getIcon()
  {
    return zzcqs;
  }
  
  public final List<NativeAd.Image> getImages()
  {
    return zzbfl;
  }
  
  public final String getPrice()
  {
    return zzbfr;
  }
  
  public final double getStarRating()
  {
    return zzbfp;
  }
  
  public final String getStore()
  {
    return zzbfq;
  }
  
  public final void setBody(String paramString)
  {
    zzbfm = paramString;
  }
  
  public final void setCallToAction(String paramString)
  {
    zzbfo = paramString;
  }
  
  public final void setHeadline(String paramString)
  {
    zzbfk = paramString;
  }
  
  public final void setIcon(NativeAd.Image paramImage)
  {
    zzcqs = paramImage;
  }
  
  public final void setImages(List<NativeAd.Image> paramList)
  {
    zzbfl = paramList;
  }
  
  public final void setPrice(String paramString)
  {
    zzbfr = paramString;
  }
  
  public final void setStarRating(double paramDouble)
  {
    zzbfp = paramDouble;
  }
  
  public final void setStore(String paramString)
  {
    zzbfq = paramString;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.mediation.NativeAppInstallAdMapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */