package com.google.android.gms.maps;

import android.graphics.Bitmap;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.maps.internal.zzac.zza;

class GoogleMap$11
  extends zzac.zza
{
  GoogleMap$11(GoogleMap paramGoogleMap, GoogleMap.SnapshotReadyCallback paramSnapshotReadyCallback) {}
  
  public void onSnapshotReady(Bitmap paramBitmap)
    throws RemoteException
  {
    agJ.onSnapshotReady(paramBitmap);
  }
  
  public void zzaf(zzd paramzzd)
    throws RemoteException
  {
    agJ.onSnapshotReady((Bitmap)zze.zzad(paramzzd));
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.maps.GoogleMap.11
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */