package com.google.android.gms.maps.model;

import com.google.android.gms.common.internal.zzab;

public final class LatLngBounds$Builder
{
  private double aiA = Double.NEGATIVE_INFINITY;
  private double aiB = NaN.0D;
  private double aiC = NaN.0D;
  private double aiz = Double.POSITIVE_INFINITY;
  
  private boolean zzi(double paramDouble)
  {
    boolean bool = false;
    if (aiB <= aiC) {
      return (aiB <= paramDouble) && (paramDouble <= aiC);
    }
    if ((aiB <= paramDouble) || (paramDouble <= aiC)) {
      bool = true;
    }
    return bool;
  }
  
  public LatLngBounds build()
  {
    if (!Double.isNaN(aiB)) {}
    for (boolean bool = true;; bool = false)
    {
      zzab.zza(bool, "no included points");
      return new LatLngBounds(new LatLng(aiz, aiB), new LatLng(aiA, aiC));
    }
  }
  
  public Builder include(LatLng paramLatLng)
  {
    aiz = Math.min(aiz, latitude);
    aiA = Math.max(aiA, latitude);
    double d = longitude;
    if (Double.isNaN(aiB))
    {
      aiB = d;
      aiC = d;
    }
    while (zzi(d)) {
      return this;
    }
    if (LatLngBounds.zzd(aiB, d) < LatLngBounds.zze(aiC, d))
    {
      aiB = d;
      return this;
    }
    aiC = d;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.maps.model.LatLngBounds.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */