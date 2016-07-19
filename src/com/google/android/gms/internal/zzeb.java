package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.formats.NativeAd.Image;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.dynamic.zzd;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@zzir
public class zzeb
  extends NativeContentAd
{
  private final List<NativeAd.Image> zzbhh = new ArrayList();
  private final zzea zzbhj;
  private final zzdv zzbhk;
  
  public zzeb(zzea paramzzea)
  {
    zzbhj = paramzzea;
    try
    {
      paramzzea = zzbhj.getImages();
      if (paramzzea != null)
      {
        paramzzea = paramzzea.iterator();
        while (paramzzea.hasNext())
        {
          zzdu localzzdu = zze(paramzzea.next());
          if (localzzdu != null) {
            zzbhh.add(new zzdv(localzzdu));
          }
        }
      }
      try
      {
        paramzzea = zzbhj.zzla();
        if (paramzzea == null) {
          break label129;
        }
        paramzzea = new zzdv(paramzzea);
      }
      catch (RemoteException paramzzea)
      {
        for (;;)
        {
          zzb.zzb("Failed to get icon.", paramzzea);
          paramzzea = null;
        }
      }
    }
    catch (RemoteException paramzzea)
    {
      zzb.zzb("Failed to get image.", paramzzea);
    }
    zzbhk = paramzzea;
  }
  
  public CharSequence getAdvertiser()
  {
    try
    {
      String str = zzbhj.getAdvertiser();
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzb("Failed to get attribution.", localRemoteException);
    }
    return null;
  }
  
  public CharSequence getBody()
  {
    try
    {
      String str = zzbhj.getBody();
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzb("Failed to get body.", localRemoteException);
    }
    return null;
  }
  
  public CharSequence getCallToAction()
  {
    try
    {
      String str = zzbhj.getCallToAction();
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzb("Failed to get call to action.", localRemoteException);
    }
    return null;
  }
  
  public CharSequence getHeadline()
  {
    try
    {
      String str = zzbhj.getHeadline();
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzb("Failed to get headline.", localRemoteException);
    }
    return null;
  }
  
  public List<NativeAd.Image> getImages()
  {
    return zzbhh;
  }
  
  public NativeAd.Image getLogo()
  {
    return zzbhk;
  }
  
  zzdu zze(Object paramObject)
  {
    if ((paramObject instanceof IBinder)) {
      return zzdu.zza.zzy((IBinder)paramObject);
    }
    return null;
  }
  
  protected zzd zzkx()
  {
    try
    {
      zzd localzzd = zzbhj.zzkx();
      return localzzd;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzb("Failed to retrieve native ad engine.", localRemoteException);
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzeb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */