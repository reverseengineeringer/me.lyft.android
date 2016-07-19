package com.google.android.gms.maps;

import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate;
import com.google.android.gms.maps.internal.zzaa.zza;
import com.google.android.gms.maps.internal.zzx.zza;
import com.google.android.gms.maps.internal.zzy.zza;
import com.google.android.gms.maps.internal.zzz.zza;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;
import com.google.android.gms.maps.model.StreetViewPanoramaLocation;
import com.google.android.gms.maps.model.StreetViewPanoramaOrientation;

public class StreetViewPanorama
{
  private final IStreetViewPanoramaDelegate ahw;
  
  protected StreetViewPanorama(IStreetViewPanoramaDelegate paramIStreetViewPanoramaDelegate)
  {
    ahw = ((IStreetViewPanoramaDelegate)zzab.zzaa(paramIStreetViewPanoramaDelegate));
  }
  
  public static abstract interface OnStreetViewPanoramaCameraChangeListener
  {
    public abstract void onStreetViewPanoramaCameraChange(StreetViewPanoramaCamera paramStreetViewPanoramaCamera);
  }
  
  public static abstract interface OnStreetViewPanoramaChangeListener
  {
    public abstract void onStreetViewPanoramaChange(StreetViewPanoramaLocation paramStreetViewPanoramaLocation);
  }
  
  public static abstract interface OnStreetViewPanoramaClickListener
  {
    public abstract void onStreetViewPanoramaClick(StreetViewPanoramaOrientation paramStreetViewPanoramaOrientation);
  }
  
  public static abstract interface OnStreetViewPanoramaLongClickListener
  {
    public abstract void onStreetViewPanoramaLongClick(StreetViewPanoramaOrientation paramStreetViewPanoramaOrientation);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.maps.StreetViewPanorama
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */