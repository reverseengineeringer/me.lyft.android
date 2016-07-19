package com.google.android.gms.maps;

import com.google.android.gms.maps.internal.zzb.zza;

final class GoogleMap$zza
  extends zzb.zza
{
  private final GoogleMap.CancelableCallback agU;
  
  GoogleMap$zza(GoogleMap.CancelableCallback paramCancelableCallback)
  {
    agU = paramCancelableCallback;
  }
  
  public void onCancel()
  {
    agU.onCancel();
  }
  
  public void onFinish()
  {
    agU.onFinish();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.maps.GoogleMap.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */