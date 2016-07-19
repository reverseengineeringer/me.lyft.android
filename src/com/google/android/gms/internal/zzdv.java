package com.google.android.gms.internal;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.ads.formats.NativeAd.Image;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.dynamic.zze;

@zzir
public class zzdv
  extends NativeAd.Image
{
  private final Drawable mDrawable;
  private final Uri mUri;
  private final double zzbfj;
  private final zzdu zzbhf;
  
  public zzdv(zzdu paramzzdu)
  {
    zzbhf = paramzzdu;
    try
    {
      paramzzdu = zzbhf.zzkv();
      if (paramzzdu == null) {
        break label83;
      }
      paramzzdu = (Drawable)zze.zzad(paramzzdu);
    }
    catch (RemoteException paramzzdu)
    {
      try
      {
        paramzzdu = zzbhf.getUri();
        mUri = paramzzdu;
        double d1 = 1.0D;
        try
        {
          double d2 = zzbhf.getScale();
          d1 = d2;
        }
        catch (RemoteException paramzzdu)
        {
          for (;;)
          {
            zzb.zzb("Failed to get scale.", paramzzdu);
          }
        }
        zzbfj = d1;
        return;
        paramzzdu = paramzzdu;
        zzb.zzb("Failed to get drawable.", paramzzdu);
        paramzzdu = null;
      }
      catch (RemoteException paramzzdu)
      {
        for (;;)
        {
          zzb.zzb("Failed to get uri.", paramzzdu);
          paramzzdu = (zzdu)localObject;
        }
      }
    }
    mDrawable = paramzzdu;
  }
  
  public Drawable getDrawable()
  {
    return mDrawable;
  }
  
  public double getScale()
  {
    return zzbfj;
  }
  
  public Uri getUri()
  {
    return mUri;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzdv
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */