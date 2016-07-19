package com.google.android.gms.location.places.internal;

import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.location.places.PlacePhotoMetadata;

public class zzp
  implements PlacePhotoMetadata
{
  private final String afX;
  private final CharSequence afY;
  private int mIndex;
  private final int zzbrm;
  private final int zzbrn;
  
  public zzp(String paramString, int paramInt1, int paramInt2, CharSequence paramCharSequence, int paramInt3)
  {
    afX = paramString;
    zzbrm = paramInt1;
    zzbrn = paramInt2;
    afY = paramCharSequence;
    mIndex = paramInt3;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof zzp)) {
        return false;
      }
      paramObject = (zzp)paramObject;
    } while ((zzbrm == zzbrm) && (zzbrn == zzbrn) && (zzaa.equal(afX, afX)) && (zzaa.equal(afY, afY)));
    return false;
  }
  
  public int hashCode()
  {
    return zzaa.hashCode(new Object[] { Integer.valueOf(zzbrm), Integer.valueOf(zzbrn), afX, afY });
  }
  
  public PlacePhotoMetadata zzboy()
  {
    return this;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.places.internal.zzp
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */