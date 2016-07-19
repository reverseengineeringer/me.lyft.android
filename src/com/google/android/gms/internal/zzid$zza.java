package com.google.android.gms.internal;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.os.AsyncTask;
import android.os.Handler;
import android.view.View.MeasureSpec;
import android.webkit.WebView;

public final class zzid$zza
  extends AsyncTask<Void, Void, Boolean>
{
  private final WebView zzbyh;
  private Bitmap zzbyi;
  
  public zzid$zza(zzid paramzzid, WebView paramWebView)
  {
    zzbyh = paramWebView;
  }
  
  protected void onPreExecute()
  {
    try
    {
      zzbyi = Bitmap.createBitmap(zzid.zza(zzbyj), zzid.zzb(zzbyj), Bitmap.Config.ARGB_8888);
      zzbyh.setVisibility(0);
      zzbyh.measure(View.MeasureSpec.makeMeasureSpec(zzid.zza(zzbyj), 0), View.MeasureSpec.makeMeasureSpec(zzid.zzb(zzbyj), 0));
      zzbyh.layout(0, 0, zzid.zza(zzbyj), zzid.zzb(zzbyj));
      Canvas localCanvas = new Canvas(zzbyi);
      zzbyh.draw(localCanvas);
      zzbyh.invalidate();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  protected void zza(Boolean paramBoolean)
  {
    zzid.zzc(zzbyj);
    if ((paramBoolean.booleanValue()) || (zzbyj.zzqc()) || (zzid.zzd(zzbyj) <= 0L))
    {
      zzbyj.zzbyg = paramBoolean.booleanValue();
      zzid.zze(zzbyj).zza(zzbyj.zzbgj, true);
    }
    while (zzid.zzd(zzbyj) <= 0L) {
      return;
    }
    if (zzkh.zzaz(2)) {
      zzkh.zzcw("Ad not detected, scheduling another run.");
    }
    zzid.zzg(zzbyj).postDelayed(zzbyj, zzid.zzf(zzbyj));
  }
  
  protected Boolean zzb(Void... paramVarArgs)
  {
    for (;;)
    {
      int i;
      int m;
      try
      {
        int n = zzbyi.getWidth();
        int i1 = zzbyi.getHeight();
        if ((n == 0) || (i1 == 0))
        {
          paramVarArgs = Boolean.valueOf(false);
          return paramVarArgs;
        }
        i = 0;
        j = 0;
        int k;
        if (i < n)
        {
          k = 0;
          if (k >= i1) {
            break label139;
          }
          m = j;
          if (zzbyi.getPixel(i, k) != 0) {
            m = j + 1;
          }
        }
        else
        {
          if (j / (n * i1 / 100.0D) > 0.1D)
          {
            bool = true;
            paramVarArgs = Boolean.valueOf(bool);
            continue;
          }
          boolean bool = false;
          continue;
        }
        k += 10;
      }
      finally {}
      int j = m;
      continue;
      label139:
      i += 10;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzid.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */