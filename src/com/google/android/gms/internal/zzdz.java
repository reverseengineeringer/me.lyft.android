package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.formats.NativeAd.Image;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.dynamic.zzd;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@zzir
public class zzdz
  extends NativeAppInstallAd
{
  private final zzdy zzbhg;
  private final List<NativeAd.Image> zzbhh = new ArrayList();
  private final zzdv zzbhi;
  
  public zzdz(zzdy paramzzdy)
  {
    zzbhg = paramzzdy;
    try
    {
      paramzzdy = zzbhg.getImages();
      if (paramzzdy != null)
      {
        paramzzdy = paramzzdy.iterator();
        while (paramzzdy.hasNext())
        {
          zzdu localzzdu = zze(paramzzdy.next());
          if (localzzdu != null) {
            zzbhh.add(new zzdv(localzzdu));
          }
        }
      }
      try
      {
        paramzzdy = zzbhg.zzkw();
        if (paramzzdy == null) {
          break label129;
        }
        paramzzdy = new zzdv(paramzzdy);
      }
      catch (RemoteException paramzzdy)
      {
        for (;;)
        {
          zzb.zzb("Failed to get icon.", paramzzdy);
          paramzzdy = null;
        }
      }
    }
    catch (RemoteException paramzzdy)
    {
      zzb.zzb("Failed to get image.", paramzzdy);
    }
    zzbhi = paramzzdy;
  }
  
  public CharSequence getBody()
  {
    try
    {
      String str = zzbhg.getBody();
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
      String str = zzbhg.getCallToAction();
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
      String str = zzbhg.getHeadline();
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzb("Failed to get headline.", localRemoteException);
    }
    return null;
  }
  
  public NativeAd.Image getIcon()
  {
    return zzbhi;
  }
  
  public List<NativeAd.Image> getImages()
  {
    return zzbhh;
  }
  
  public CharSequence getPrice()
  {
    try
    {
      String str = zzbhg.getPrice();
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzb("Failed to get price.", localRemoteException);
    }
    return null;
  }
  
  public Double getStarRating()
  {
    try
    {
      double d = zzbhg.getStarRating();
      if (d == -1.0D) {
        return null;
      }
      return Double.valueOf(d);
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzb("Failed to get star rating.", localRemoteException);
    }
    return null;
  }
  
  public CharSequence getStore()
  {
    try
    {
      String str = zzbhg.getStore();
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzb("Failed to get store", localRemoteException);
    }
    return null;
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
      zzd localzzd = zzbhg.zzkx();
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
 * Qualified Name:     com.google.android.gms.internal.zzdz
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */