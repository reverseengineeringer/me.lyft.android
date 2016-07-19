package com.google.android.gms.internal;

import android.content.Context;
import android.net.Uri;
import android.os.RemoteException;
import android.view.MotionEvent;
import com.google.android.gms.dynamic.zze;

public final class zzbw
{
  private final zzca zzaip;
  
  public zzbw(String paramString, Context paramContext, boolean paramBoolean)
  {
    zzaip = zzbz.zzb(paramString, paramContext, paramBoolean);
  }
  
  public void zza(MotionEvent paramMotionEvent)
    throws RemoteException
  {
    zzaip.zzd(zze.zzae(paramMotionEvent));
  }
  
  public Uri zzc(Uri paramUri, Context paramContext)
    throws zzbx, RemoteException
  {
    paramUri = zze.zzae(paramUri);
    paramContext = zze.zzae(paramContext);
    paramUri = zzaip.zza(paramUri, paramContext);
    if (paramUri == null) {
      throw new zzbx();
    }
    return (Uri)zze.zzad(paramUri);
  }
  
  public Uri zzd(Uri paramUri, Context paramContext)
    throws zzbx, RemoteException
  {
    paramUri = zze.zzae(paramUri);
    paramContext = zze.zzae(paramContext);
    paramUri = zzaip.zzb(paramUri, paramContext);
    if (paramUri == null) {
      throw new zzbx();
    }
    return (Uri)zze.zzad(paramUri);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzbw
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */