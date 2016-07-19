package com.google.android.gms.ads.internal.formats;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzdu.zza;
import com.google.android.gms.internal.zzir;

@zzir
public class zzc
  extends zzdu.zza
{
  private final Uri mUri;
  private final Drawable zzbfi;
  private final double zzbfj;
  
  public zzc(Drawable paramDrawable, Uri paramUri, double paramDouble)
  {
    zzbfi = paramDrawable;
    mUri = paramUri;
    zzbfj = paramDouble;
  }
  
  public double getScale()
  {
    return zzbfj;
  }
  
  public Uri getUri()
    throws RemoteException
  {
    return mUri;
  }
  
  public zzd zzkv()
    throws RemoteException
  {
    return zze.zzae(zzbfi);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.formats.zzc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */