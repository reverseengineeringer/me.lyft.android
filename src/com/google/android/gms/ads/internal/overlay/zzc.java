package com.google.android.gms.ads.internal.overlay;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnInfoListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.view.Surface;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View.MeasureSpec;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.common.util.zze;
import com.google.android.gms.internal.zzir;
import com.google.android.gms.internal.zzkh;
import com.google.android.gms.internal.zzkl;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@zzir
@TargetApi(14)
public class zzc
  extends zzi
  implements AudioManager.OnAudioFocusChangeListener, MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnVideoSizeChangedListener, TextureView.SurfaceTextureListener
{
  private static final Map<Integer, String> zzbrv = new HashMap();
  private final zzx zzbrw;
  private final boolean zzbrx;
  private int zzbry = 0;
  private int zzbrz = 0;
  private MediaPlayer zzbsa;
  private Uri zzbsb;
  private int zzbsc;
  private int zzbsd;
  private int zzbse;
  private int zzbsf;
  private int zzbsg;
  private float zzbsh = 1.0F;
  private boolean zzbsi;
  private boolean zzbsj;
  private zzw zzbsk;
  private boolean zzbsl;
  private int zzbsm;
  private zzh zzbsn;
  
  static
  {
    zzbrv.put(Integer.valueOf(64532), "MEDIA_ERROR_IO");
    zzbrv.put(Integer.valueOf(64529), "MEDIA_ERROR_MALFORMED");
    zzbrv.put(Integer.valueOf(64526), "MEDIA_ERROR_UNSUPPORTED");
    zzbrv.put(Integer.valueOf(-110), "MEDIA_ERROR_TIMED_OUT");
    zzbrv.put(Integer.valueOf(100), "MEDIA_ERROR_SERVER_DIED");
    zzbrv.put(Integer.valueOf(1), "MEDIA_ERROR_UNKNOWN");
    zzbrv.put(Integer.valueOf(1), "MEDIA_INFO_UNKNOWN");
    zzbrv.put(Integer.valueOf(700), "MEDIA_INFO_VIDEO_TRACK_LAGGING");
    zzbrv.put(Integer.valueOf(3), "MEDIA_INFO_VIDEO_RENDERING_START");
    zzbrv.put(Integer.valueOf(701), "MEDIA_INFO_BUFFERING_START");
    zzbrv.put(Integer.valueOf(702), "MEDIA_INFO_BUFFERING_END");
    zzbrv.put(Integer.valueOf(800), "MEDIA_INFO_BAD_INTERLEAVING");
    zzbrv.put(Integer.valueOf(801), "MEDIA_INFO_NOT_SEEKABLE");
    zzbrv.put(Integer.valueOf(802), "MEDIA_INFO_METADATA_UPDATE");
    zzbrv.put(Integer.valueOf(901), "MEDIA_INFO_UNSUPPORTED_SUBTITLE");
    zzbrv.put(Integer.valueOf(902), "MEDIA_INFO_SUBTITLE_TIMED_OUT");
  }
  
  public zzc(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, zzx paramzzx)
  {
    super(paramContext);
    setSurfaceTextureListener(this);
    zzbrw = paramzzx;
    zzbsl = paramBoolean1;
    zzbrx = paramBoolean2;
    zzbrw.zza(this);
  }
  
  private void zzad(int paramInt)
  {
    if (paramInt == 3) {
      zzbrw.zzpk();
    }
    for (;;)
    {
      zzbry = paramInt;
      return;
      if (zzbry == 3) {
        zzbrw.zzpl();
      }
    }
  }
  
  private void zzae(int paramInt)
  {
    zzbrz = paramInt;
  }
  
  private void zzb(float paramFloat)
  {
    if (zzbsa != null) {}
    try
    {
      zzbsa.setVolume(paramFloat, paramFloat);
      return;
    }
    catch (IllegalStateException localIllegalStateException) {}
    zzkh.zzcy("AdMediaPlayerView setMediaPlayerVolume() called before onPrepared().");
    return;
  }
  
  private void zznl()
  {
    zzkh.v("AdMediaPlayerView init MediaPlayer");
    Object localObject1 = getSurfaceTexture();
    if ((zzbsb == null) || (localObject1 == null)) {
      return;
    }
    zzy(false);
    try
    {
      zzbsa = zzu.zzgd().zzox();
      zzbsa.setOnBufferingUpdateListener(this);
      zzbsa.setOnCompletionListener(this);
      zzbsa.setOnErrorListener(this);
      zzbsa.setOnInfoListener(this);
      zzbsa.setOnPreparedListener(this);
      zzbsa.setOnVideoSizeChangedListener(this);
      zzbse = 0;
      if (!zzbsl) {
        break label276;
      }
      zzbsk = new zzw(getContext());
      zzbsk.zza((SurfaceTexture)localObject1, getWidth(), getHeight());
      zzbsk.start();
      localObject2 = zzbsk.zzoz();
      if (localObject2 == null) {
        break label264;
      }
      localObject1 = localObject2;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        Object localObject2 = String.valueOf(zzbsb);
        zzkh.zzd(String.valueOf(localObject2).length() + 36 + "Failed to initialize MediaPlayer at " + (String)localObject2, localIOException);
        onError(zzbsa, 1, 0);
        return;
        zzbsk.zzoy();
        zzbsk = null;
      }
    }
    catch (IllegalStateException localIllegalStateException)
    {
      for (;;) {}
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;) {}
    }
    zzbsa.setDataSource(getContext(), zzbsb);
    localObject1 = zzu.zzge().zza((SurfaceTexture)localObject1);
    zzbsa.setSurface((Surface)localObject1);
    zzbsa.setAudioStreamType(3);
    zzbsa.setScreenOnWhilePlaying(true);
    zzbsa.prepareAsync();
    zzad(1);
  }
  
  private void zznm()
  {
    if (!zzbrx) {}
    while ((!zznp()) || (zzbsa.getCurrentPosition() <= 0) || (zzbrz == 3)) {
      return;
    }
    zzkh.v("AdMediaPlayerView nudging MediaPlayer");
    zzb(0.0F);
    zzbsa.start();
    int i = zzbsa.getCurrentPosition();
    long l = zzu.zzfu().currentTimeMillis();
    while ((zznp()) && (zzbsa.getCurrentPosition() == i) && (zzu.zzfu().currentTimeMillis() - l <= 250L)) {}
    zzbsa.pause();
    zznu();
  }
  
  private void zznn()
  {
    AudioManager localAudioManager = zznv();
    if ((localAudioManager != null) && (!zzbsj))
    {
      if (localAudioManager.requestAudioFocus(this, 3, 2) == 1) {
        zzns();
      }
    }
    else {
      return;
    }
    zzkh.zzcy("AdMediaPlayerView audio focus request failed");
  }
  
  private void zzno()
  {
    zzkh.v("AdMediaPlayerView abandon audio focus");
    AudioManager localAudioManager = zznv();
    if ((localAudioManager != null) && (zzbsj))
    {
      if (localAudioManager.abandonAudioFocus(this) == 1) {
        zzbsj = false;
      }
    }
    else {
      return;
    }
    zzkh.zzcy("AdMediaPlayerView abandon audio focus failed");
  }
  
  private boolean zznp()
  {
    return (zzbsa != null) && (zzbry != -1) && (zzbry != 0) && (zzbry != 1);
  }
  
  private void zzns()
  {
    zzkh.v("AdMediaPlayerView audio focus gained");
    zzbsj = true;
    zznu();
  }
  
  private void zznt()
  {
    zzkh.v("AdMediaPlayerView audio focus lost");
    zzbsj = false;
    zznu();
  }
  
  private void zznu()
  {
    if ((!zzbsi) && (zzbsj))
    {
      zzb(zzbsh);
      return;
    }
    zzb(0.0F);
  }
  
  private AudioManager zznv()
  {
    return (AudioManager)getContext().getSystemService("audio");
  }
  
  private void zzy(boolean paramBoolean)
  {
    zzkh.v("AdMediaPlayerView release");
    if (zzbsk != null)
    {
      zzbsk.zzoy();
      zzbsk = null;
    }
    if (zzbsa != null)
    {
      zzbsa.reset();
      zzbsa.release();
      zzbsa = null;
      zzad(0);
      if (paramBoolean)
      {
        zzbrz = 0;
        zzae(0);
      }
      zzno();
    }
  }
  
  public int getCurrentPosition()
  {
    if (zznp()) {
      return zzbsa.getCurrentPosition();
    }
    return 0;
  }
  
  public int getDuration()
  {
    if (zznp()) {
      return zzbsa.getDuration();
    }
    return -1;
  }
  
  public int getVideoHeight()
  {
    if (zzbsa != null) {
      return zzbsa.getVideoHeight();
    }
    return 0;
  }
  
  public int getVideoWidth()
  {
    if (zzbsa != null) {
      return zzbsa.getVideoWidth();
    }
    return 0;
  }
  
  public void onAudioFocusChange(int paramInt)
  {
    if (paramInt > 0) {
      zzns();
    }
    while (paramInt >= 0) {
      return;
    }
    zznt();
  }
  
  public void onBufferingUpdate(MediaPlayer paramMediaPlayer, int paramInt)
  {
    zzbse = paramInt;
  }
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    zzkh.v("AdMediaPlayerView completion");
    zzad(5);
    zzae(5);
    zzkl.zzclg.post(new Runnable()
    {
      public void run()
      {
        if (zzc.zza(zzc.this) != null) {
          zzc.zza(zzc.this).zzon();
        }
      }
    });
  }
  
  public boolean onError(final MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    paramMediaPlayer = (String)zzbrv.get(Integer.valueOf(paramInt1));
    final String str = (String)zzbrv.get(Integer.valueOf(paramInt2));
    zzkh.zzcy(String.valueOf(paramMediaPlayer).length() + 38 + String.valueOf(str).length() + "AdMediaPlayerView MediaPlayer error: " + paramMediaPlayer + ":" + str);
    zzad(-1);
    zzae(-1);
    zzkl.zzclg.post(new Runnable()
    {
      public void run()
      {
        if (zzc.zza(zzc.this) != null) {
          zzc.zza(zzc.this).zzl(paramMediaPlayer, str);
        }
      }
    });
    return true;
  }
  
  public boolean onInfo(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    paramMediaPlayer = (String)zzbrv.get(Integer.valueOf(paramInt1));
    String str = (String)zzbrv.get(Integer.valueOf(paramInt2));
    zzkh.v(String.valueOf(paramMediaPlayer).length() + 37 + String.valueOf(str).length() + "AdMediaPlayerView MediaPlayer info: " + paramMediaPlayer + ":" + str);
    return true;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int k = getDefaultSize(zzbsc, paramInt1);
    int m = getDefaultSize(zzbsd, paramInt2);
    int j = m;
    int i = k;
    int n;
    if (zzbsc > 0)
    {
      j = m;
      i = k;
      if (zzbsd > 0)
      {
        j = m;
        i = k;
        if (zzbsk == null)
        {
          m = View.MeasureSpec.getMode(paramInt1);
          paramInt1 = View.MeasureSpec.getSize(paramInt1);
          n = View.MeasureSpec.getMode(paramInt2);
          paramInt2 = View.MeasureSpec.getSize(paramInt2);
          if ((m != 1073741824) || (n != 1073741824)) {
            break label242;
          }
          if (zzbsc * paramInt2 >= zzbsd * paramInt1) {
            break label209;
          }
          i = zzbsc * paramInt2 / zzbsd;
          j = paramInt2;
        }
      }
    }
    for (;;)
    {
      setMeasuredDimension(i, j);
      if (zzbsk != null) {
        zzbsk.zzg(i, j);
      }
      if (Build.VERSION.SDK_INT == 16)
      {
        if (((zzbsf > 0) && (zzbsf != i)) || ((zzbsg > 0) && (zzbsg != j))) {
          zznm();
        }
        zzbsf = i;
        zzbsg = j;
      }
      return;
      label209:
      if (zzbsc * paramInt2 > zzbsd * paramInt1)
      {
        j = zzbsd * paramInt1 / zzbsc;
        i = paramInt1;
        continue;
        label242:
        if (m == 1073741824)
        {
          j = zzbsd * paramInt1 / zzbsc;
          if ((n == Integer.MIN_VALUE) && (j > paramInt2))
          {
            j = paramInt2;
            i = paramInt1;
          }
        }
        else
        {
          if (n == 1073741824)
          {
            k = zzbsc * paramInt2 / zzbsd;
            j = paramInt2;
            i = k;
            if (m != Integer.MIN_VALUE) {
              continue;
            }
            j = paramInt2;
            i = k;
            if (k <= paramInt1) {
              continue;
            }
            j = paramInt2;
            i = paramInt1;
            continue;
          }
          k = zzbsc;
          i = zzbsd;
          if ((n == Integer.MIN_VALUE) && (i > paramInt2)) {
            k = zzbsc * paramInt2 / zzbsd;
          }
          for (;;)
          {
            j = paramInt2;
            i = k;
            if (m != Integer.MIN_VALUE) {
              break;
            }
            j = paramInt2;
            i = k;
            if (k <= paramInt1) {
              break;
            }
            j = zzbsd * paramInt1 / zzbsc;
            i = paramInt1;
            break;
            paramInt2 = i;
          }
        }
        i = paramInt1;
      }
      else
      {
        j = paramInt2;
        i = paramInt1;
      }
    }
  }
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    zzkh.v("AdMediaPlayerView prepared");
    zzad(2);
    zzbrw.zzol();
    zzkl.zzclg.post(new Runnable()
    {
      public void run()
      {
        if (zzc.zza(zzc.this) != null) {
          zzc.zza(zzc.this).zzol();
        }
      }
    });
    zzbsc = paramMediaPlayer.getVideoWidth();
    zzbsd = paramMediaPlayer.getVideoHeight();
    if (zzbsm != 0) {
      seekTo(zzbsm);
    }
    zznm();
    int i = zzbsc;
    int j = zzbsd;
    zzkh.zzcx(62 + "AdMediaPlayerView stream dimensions: " + i + " x " + j);
    if (zzbrz == 3) {
      play();
    }
    zznn();
    zznu();
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    zzkh.v("AdMediaPlayerView surface created");
    zznl();
    zzkl.zzclg.post(new Runnable()
    {
      public void run()
      {
        if (zzc.zza(zzc.this) != null) {
          zzc.zza(zzc.this).zzok();
        }
      }
    });
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    zzkh.v("AdMediaPlayerView surface destroyed");
    if ((zzbsa != null) && (zzbsm == 0)) {
      zzbsm = zzbsa.getCurrentPosition();
    }
    if (zzbsk != null) {
      zzbsk.zzoy();
    }
    zzkl.zzclg.post(new Runnable()
    {
      public void run()
      {
        if (zzc.zza(zzc.this) != null)
        {
          zzc.zza(zzc.this).onPaused();
          zzc.zza(zzc.this).zzoo();
        }
      }
    });
    zzy(true);
    return true;
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    int j = 1;
    zzkh.v("AdMediaPlayerView surface changed");
    int i;
    if (zzbrz == 3)
    {
      i = 1;
      if ((zzbsc != paramInt1) || (zzbsd != paramInt2)) {
        break label95;
      }
    }
    for (;;)
    {
      if ((zzbsa != null) && (i != 0) && (j != 0))
      {
        if (zzbsm != 0) {
          seekTo(zzbsm);
        }
        play();
      }
      if (zzbsk != null) {
        zzbsk.zzg(paramInt1, paramInt2);
      }
      return;
      i = 0;
      break;
      label95:
      j = 0;
    }
  }
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture)
  {
    zzbrw.zzb(this);
  }
  
  public void onVideoSizeChanged(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    zzkh.v(57 + "AdMediaPlayerView size changed: " + paramInt1 + " x " + paramInt2);
    zzbsc = paramMediaPlayer.getVideoWidth();
    zzbsd = paramMediaPlayer.getVideoHeight();
    if ((zzbsc != 0) && (zzbsd != 0)) {
      requestLayout();
    }
  }
  
  public void pause()
  {
    zzkh.v("AdMediaPlayerView pause");
    if ((zznp()) && (zzbsa.isPlaying()))
    {
      zzbsa.pause();
      zzad(4);
      zzkl.zzclg.post(new Runnable()
      {
        public void run()
        {
          if (zzc.zza(zzc.this) != null) {
            zzc.zza(zzc.this).onPaused();
          }
        }
      });
    }
    zzae(4);
  }
  
  public void play()
  {
    zzkh.v("AdMediaPlayerView play");
    if (zznp())
    {
      zzbsa.start();
      zzad(3);
      zzkl.zzclg.post(new Runnable()
      {
        public void run()
        {
          if (zzc.zza(zzc.this) != null) {
            zzc.zza(zzc.this).zzom();
          }
        }
      });
    }
    zzae(3);
  }
  
  public void seekTo(int paramInt)
  {
    zzkh.v(34 + "AdMediaPlayerView seek " + paramInt);
    if (zznp())
    {
      zzbsa.seekTo(paramInt);
      zzbsm = 0;
      return;
    }
    zzbsm = paramInt;
  }
  
  public void setMimeType(String paramString) {}
  
  public void setVideoPath(String paramString)
  {
    setVideoURI(Uri.parse(paramString));
  }
  
  public void setVideoURI(Uri paramUri)
  {
    zzbsb = paramUri;
    zzbsm = 0;
    zznl();
    requestLayout();
    invalidate();
  }
  
  public void stop()
  {
    zzkh.v("AdMediaPlayerView stop");
    if (zzbsa != null)
    {
      zzbsa.stop();
      zzbsa.release();
      zzbsa = null;
      zzad(0);
      zzae(0);
      zzno();
    }
    zzbrw.onStop();
  }
  
  public String toString()
  {
    String str1 = String.valueOf(getClass().getName());
    String str2 = String.valueOf(Integer.toHexString(hashCode()));
    return String.valueOf(str1).length() + 1 + String.valueOf(str2).length() + str1 + "@" + str2;
  }
  
  public void zza(float paramFloat)
  {
    zzbsh = paramFloat;
    zznu();
  }
  
  public void zza(float paramFloat1, float paramFloat2)
  {
    if (zzbsk != null) {
      zzbsk.zzb(paramFloat1, paramFloat2);
    }
  }
  
  public void zza(zzh paramzzh)
  {
    zzbsn = paramzzh;
  }
  
  public String zznk()
  {
    if (zzbsl) {}
    for (String str = " spherical";; str = "")
    {
      str = String.valueOf(str);
      if (str.length() == 0) {
        break;
      }
      return "MediaPlayer".concat(str);
    }
    return new String("MediaPlayer");
  }
  
  public void zznq()
  {
    zzbsi = true;
    zznu();
  }
  
  public void zznr()
  {
    zzbsi = false;
    zznu();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.overlay.zzc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */