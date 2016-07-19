package com.google.android.gms.internal;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View.MeasureSpec;
import android.webkit.WebView;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.zzu;

@zzir
public class zzid
  implements Runnable
{
  private final int zzaie;
  private final int zzaif;
  protected final zzll zzbgj;
  private final Handler zzbyb;
  private final long zzbyc;
  private long zzbyd;
  private zzlm.zza zzbye;
  protected boolean zzbyf;
  protected boolean zzbyg;
  
  public zzid(zzlm.zza paramzza, zzll paramzzll, int paramInt1, int paramInt2)
  {
    this(paramzza, paramzzll, paramInt1, paramInt2, 200L, 50L);
  }
  
  public zzid(zzlm.zza paramzza, zzll paramzzll, int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    zzbyc = paramLong1;
    zzbyd = paramLong2;
    zzbyb = new Handler(Looper.getMainLooper());
    zzbgj = paramzzll;
    zzbye = paramzza;
    zzbyf = false;
    zzbyg = false;
    zzaif = paramInt2;
    zzaie = paramInt1;
  }
  
  public void run()
  {
    if ((zzbgj == null) || (zzqc()))
    {
      zzbye.zza(zzbgj, true);
      return;
    }
    new zza(zzbgj.getWebView()).execute(new Void[0]);
  }
  
  public void zza(AdResponseParcel paramAdResponseParcel)
  {
    zza(paramAdResponseParcel, new zzlv(this, zzbgj, zzccj));
  }
  
  public void zza(AdResponseParcel paramAdResponseParcel, zzlv paramzzlv)
  {
    zzbgj.setWebViewClient(paramzzlv);
    zzll localzzll = zzbgj;
    if (TextUtils.isEmpty(zzbts)) {}
    for (paramzzlv = null;; paramzzlv = zzu.zzfq().zzcp(zzbts))
    {
      localzzll.loadDataWithBaseURL(paramzzlv, body, "text/html", "UTF-8", null);
      return;
    }
  }
  
  public void zzqa()
  {
    zzbyb.postDelayed(this, zzbyc);
  }
  
  public void zzqb()
  {
    try
    {
      zzbyf = true;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public boolean zzqc()
  {
    try
    {
      boolean bool = zzbyf;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public boolean zzqd()
  {
    return zzbyg;
  }
  
  protected final class zza
    extends AsyncTask<Void, Void, Boolean>
  {
    private final WebView zzbyh;
    private Bitmap zzbyi;
    
    public zza(WebView paramWebView)
    {
      zzbyh = paramWebView;
    }
    
    protected void onPreExecute()
    {
      try
      {
        zzbyi = Bitmap.createBitmap(zzid.zza(zzid.this), zzid.zzb(zzid.this), Bitmap.Config.ARGB_8888);
        zzbyh.setVisibility(0);
        zzbyh.measure(View.MeasureSpec.makeMeasureSpec(zzid.zza(zzid.this), 0), View.MeasureSpec.makeMeasureSpec(zzid.zzb(zzid.this), 0));
        zzbyh.layout(0, 0, zzid.zza(zzid.this), zzid.zzb(zzid.this));
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
      zzid.zzc(zzid.this);
      if ((paramBoolean.booleanValue()) || (zzqc()) || (zzid.zzd(zzid.this) <= 0L))
      {
        zzbyg = paramBoolean.booleanValue();
        zzid.zze(zzid.this).zza(zzbgj, true);
      }
      while (zzid.zzd(zzid.this) <= 0L) {
        return;
      }
      if (zzkh.zzaz(2)) {
        zzkh.zzcw("Ad not detected, scheduling another run.");
      }
      zzid.zzg(zzid.this).postDelayed(zzid.this, zzid.zzf(zzid.this));
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
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzid
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */