package me.lyft.android.infrastructure.instabug;

import me.lyft.android.common.INullable;
import me.lyft.android.maps.LyftMapView;

public abstract interface IInstabugService
  extends INullable
{
  public abstract void addMapView(LyftMapView paramLyftMapView);
  
  public abstract void dismissIfShowing();
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.instabug.IInstabugService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */