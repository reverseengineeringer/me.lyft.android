package com.google.android.gms.ads.internal.formats;

import android.os.Bundle;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.internal.zzdu;
import com.google.android.gms.internal.zzea.zza;
import com.google.android.gms.internal.zzir;
import java.util.List;

@zzir
public class zze
  extends zzea.zza
  implements zzh.zza
{
  private Bundle mExtras;
  private Object zzail = new Object();
  private String zzbfk;
  private List<zzc> zzbfl;
  private String zzbfm;
  private String zzbfo;
  private zza zzbfs;
  private zzh zzbft;
  private zzdu zzbfu;
  private String zzbfv;
  
  public zze(String paramString1, List paramList, String paramString2, zzdu paramzzdu, String paramString3, String paramString4, zza paramzza, Bundle paramBundle)
  {
    zzbfk = paramString1;
    zzbfl = paramList;
    zzbfm = paramString2;
    zzbfu = paramzzdu;
    zzbfo = paramString3;
    zzbfv = paramString4;
    zzbfs = paramzza;
    mExtras = paramBundle;
  }
  
  public void destroy()
  {
    zzbfk = null;
    zzbfl = null;
    zzbfm = null;
    zzbfu = null;
    zzbfo = null;
    zzbfv = null;
    zzbfs = null;
    mExtras = null;
    zzail = null;
    zzbft = null;
  }
  
  public String getAdvertiser()
  {
    return zzbfv;
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
  
  public void zzb(zzh paramzzh)
  {
    synchronized (zzail)
    {
      zzbft = paramzzh;
      return;
    }
  }
  
  public zzd zzkx()
  {
    return com.google.android.gms.dynamic.zze.zzae(zzbft);
  }
  
  public String zzky()
  {
    return "1";
  }
  
  public zza zzkz()
  {
    return zzbfs;
  }
  
  public zzdu zzla()
  {
    return zzbfu;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.formats.zze
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */