package com.google.android.gms.ads.internal.formats;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import com.google.android.gms.internal.zzir;
import java.util.List;

@zzir
public class zza
{
  private static final int zzbew = Color.rgb(12, 174, 206);
  private static final int zzbex = Color.rgb(204, 204, 204);
  static final int zzbey = zzbex;
  static final int zzbez = zzbew;
  private final int mBackgroundColor;
  private final int mTextColor;
  private final String zzbfa;
  private final List<Drawable> zzbfb;
  private final int zzbfc;
  private final int zzbfd;
  private final int zzbfe;
  
  public zza(String paramString, List<Drawable> paramList, Integer paramInteger1, Integer paramInteger2, Integer paramInteger3, int paramInt1, int paramInt2)
  {
    zzbfa = paramString;
    zzbfb = paramList;
    if (paramInteger1 != null)
    {
      i = paramInteger1.intValue();
      mBackgroundColor = i;
      if (paramInteger2 == null) {
        break label87;
      }
      i = paramInteger2.intValue();
      label42:
      mTextColor = i;
      if (paramInteger3 == null) {
        break label95;
      }
    }
    label87:
    label95:
    for (int i = paramInteger3.intValue();; i = 12)
    {
      zzbfc = i;
      zzbfd = paramInt1;
      zzbfe = paramInt2;
      return;
      i = zzbey;
      break;
      i = zzbez;
      break label42;
    }
  }
  
  public int getBackgroundColor()
  {
    return mBackgroundColor;
  }
  
  public String getText()
  {
    return zzbfa;
  }
  
  public int getTextColor()
  {
    return mTextColor;
  }
  
  public int getTextSize()
  {
    return zzbfc;
  }
  
  public List<Drawable> zzkr()
  {
    return zzbfb;
  }
  
  public int zzks()
  {
    return zzbfd;
  }
  
  public int zzkt()
  {
    return zzbfe;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.formats.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */