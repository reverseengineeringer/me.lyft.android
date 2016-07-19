package com.google.android.gms.location.places.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.location.places.PlacePhotoMetadata;

public class zzq
  extends zzt
  implements PlacePhotoMetadata
{
  private final String afX = getString("photo_fife_url");
  
  public zzq(DataHolder paramDataHolder, int paramInt)
  {
    super(paramDataHolder, paramInt);
  }
  
  public CharSequence getAttributions()
  {
    return zzao("photo_attributions", null);
  }
  
  public int getMaxHeight()
  {
    return zzx("photo_max_height", 0);
  }
  
  public int getMaxWidth()
  {
    return zzx("photo_max_width", 0);
  }
  
  public PlacePhotoMetadata zzboy()
  {
    return new zzp(afX, getMaxWidth(), getMaxHeight(), getAttributions(), vK);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.places.internal.zzq
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */