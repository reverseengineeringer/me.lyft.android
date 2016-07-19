package com.google.android.gms.ads.mediation;

import com.google.android.gms.ads.formats.NativeAd.Image;
import java.util.List;

public abstract class NativeContentAdMapper
  extends NativeAdMapper
{
  private String zzbfk;
  private List<NativeAd.Image> zzbfl;
  private String zzbfm;
  private String zzbfo;
  private String zzbfv;
  private NativeAd.Image zzcqt;
  
  public final String getAdvertiser()
  {
    return zzbfv;
  }
  
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
  
  public final List<NativeAd.Image> getImages()
  {
    return zzbfl;
  }
  
  public final NativeAd.Image getLogo()
  {
    return zzcqt;
  }
  
  public final void setAdvertiser(String paramString)
  {
    zzbfv = paramString;
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
  
  public final void setImages(List<NativeAd.Image> paramList)
  {
    zzbfl = paramList;
  }
  
  public final void setLogo(NativeAd.Image paramImage)
  {
    zzcqt = paramImage;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.mediation.NativeContentAdMapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */