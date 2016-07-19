package com.google.android.gms.internal;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import com.google.android.gms.ads.internal.formats.zzc;
import com.google.android.gms.common.util.zzo;
import java.io.IOException;
import java.io.InputStream;

class zzim$6
  implements zzkr.zza<zzc>
{
  zzim$6(zzim paramzzim, boolean paramBoolean, double paramDouble, String paramString) {}
  
  public zzc zzg(InputStream paramInputStream)
  {
    try
    {
      paramInputStream = zzo.zzk(paramInputStream);
      if (paramInputStream == null)
      {
        zzbzo.zza(2, zzcab);
        return null;
      }
    }
    catch (IOException paramInputStream)
    {
      for (;;)
      {
        paramInputStream = null;
      }
      paramInputStream = BitmapFactory.decodeByteArray(paramInputStream, 0, paramInputStream.length);
      if (paramInputStream == null)
      {
        zzbzo.zza(2, zzcab);
        return null;
      }
      paramInputStream.setDensity((int)(160.0D * zzcac));
    }
    return new zzc(new BitmapDrawable(Resources.getSystem(), paramInputStream), Uri.parse(zzbqy), zzcac);
  }
  
  public zzc zzqu()
  {
    zzbzo.zza(2, zzcab);
    return null;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzim.6
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */