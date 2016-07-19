package com.google.android.gms.ads.internal.overlay;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.TextureView;
import com.google.android.gms.internal.zzir;

@zzir
@TargetApi(14)
public abstract class zzi
  extends TextureView
{
  public zzi(Context paramContext)
  {
    super(paramContext);
  }
  
  public abstract int getCurrentPosition();
  
  public abstract int getDuration();
  
  public abstract int getVideoHeight();
  
  public abstract int getVideoWidth();
  
  public abstract void pause();
  
  public abstract void play();
  
  public abstract void seekTo(int paramInt);
  
  public abstract void setMimeType(String paramString);
  
  public abstract void setVideoPath(String paramString);
  
  public abstract void stop();
  
  public abstract void zza(float paramFloat);
  
  public abstract void zza(float paramFloat1, float paramFloat2);
  
  public abstract void zza(zzh paramzzh);
  
  public abstract String zznk();
  
  public abstract void zznq();
  
  public abstract void zznr();
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.overlay.zzi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */