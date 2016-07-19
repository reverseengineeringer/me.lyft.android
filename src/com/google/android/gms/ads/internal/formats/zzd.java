package com.google.android.gms.ads.internal.formats;

import android.os.Bundle;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzdu;
import com.google.android.gms.internal.zzdy.zza;
import com.google.android.gms.internal.zzir;
import java.util.List;

@zzir
public class zzd
  extends zzdy.zza
  implements zzh.zza
{
  private Bundle mExtras;
  private Object zzail = new Object();
  private String zzbfk;
  private List<zzc> zzbfl;
  private String zzbfm;
  private zzdu zzbfn;
  private String zzbfo;
  private double zzbfp;
  private String zzbfq;
  private String zzbfr;
  private zza zzbfs;
  private zzh zzbft;
  
  public zzd(String paramString1, List paramList, String paramString2, zzdu paramzzdu, String paramString3, double paramDouble, String paramString4, String paramString5, zza paramzza, Bundle paramBundle)
  {
    zzbfk = paramString1;
    zzbfl = paramList;
    zzbfm = paramString2;
    zzbfn = paramzzdu;
    zzbfo = paramString3;
    zzbfp = paramDouble;
    zzbfq = paramString4;
    zzbfr = paramString5;
    zzbfs = paramzza;
    mExtras = paramBundle;
  }
  
  public void destroy()
  {
    zzbfk = null;
    zzbfl = null;
    zzbfm = null;
    zzbfn = null;
    zzbfo = null;
    zzbfp = 0.0D;
    zzbfq = null;
    zzbfr = null;
    zzbfs = null;
    mExtras = null;
    zzail = null;
    zzbft = null;
  }
  
  public String getBody()
  {
    return zzbfm;
  }
  
  public String getCallToAction()
  {
    return zzbfo;
  }
  
  public String getCustomTemplateId()
  {
    return "";
  }
  
  public Bundle getExtras()
  {
    return mExtras;
  }
  
  public String getHeadline()
  {
    return zzbfk;
  }
  
  public List getImages()
  {
    return zzbfl;
  }
  
  public String getPrice()
  {
    return zzbfr;
  }
  
  public double getStarRating()
  {
    return zzbfp;
  }
  
  public String getStore()
  {
    return zzbfq;
  }
  
  public void zzb(zzh paramzzh)
  {
    synchronized (zzail)
    {
      zzbft = paramzzh;
      return;
    }
  }
  
  public zzdu zzkw()
  {
    return zzbfn;
  }
  
  public com.google.android.gms.dynamic.zzd zzkx()
  {
    return zze.zzae(zzbft);
  }
  
  public String zzky()
  {
    return "2";
  }
  
  public zza zzkz()
  {
    return zzbfs;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.formats.zzd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */