package me.lyft.android.utils;

import android.annotation.SuppressLint;
import android.media.AudioManager;
import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;
import java.util.HashMap;
import javax.inject.Inject;
import javax.inject.Singleton;
import me.lyft.android.LyftApplication;

@Singleton
public class SoundManager
  implements SoundPool.OnLoadCompleteListener
{
  public static final int CANCEL_ERROR_SOUND = 2;
  public static final int DRIVER_COUNTDOWN_SOUND = 3;
  public static final int DRIVER_NEW_REQUEST_SOUND = 4;
  public static final int DRIVER_REQUEST = 6;
  public static final int DRIVER_REQUEST_DURATION_SEC = 2;
  public static final int NOTIFICATION_SOUND = 1;
  public static final int SLIDE_SOUND = 5;
  final AudioManager audioManager;
  @SuppressLint({"UseSparseArrays"})
  private HashMap<Integer, Integer> soundMap = new HashMap();
  private SoundPool soundPool;
  
  @Inject
  public SoundManager(LyftApplication paramLyftApplication, AudioManager paramAudioManager)
  {
    audioManager = paramAudioManager;
    soundPool = new SoundPool(5, 2, 0);
    soundMap.put(Integer.valueOf(1), Integer.valueOf(soundPool.load(paramLyftApplication, 2131099670, 0)));
    soundMap.put(Integer.valueOf(2), Integer.valueOf(soundPool.load(paramLyftApplication, 2131099653, 1)));
    soundMap.put(Integer.valueOf(3), Integer.valueOf(soundPool.load(paramLyftApplication, 2131099658, 2)));
    soundMap.put(Integer.valueOf(4), Integer.valueOf(soundPool.load(paramLyftApplication, 2131099659, 3)));
    soundMap.put(Integer.valueOf(5), Integer.valueOf(soundPool.load(paramLyftApplication, 2131099673, 4)));
    soundMap.put(Integer.valueOf(6), Integer.valueOf(soundPool.load(paramLyftApplication, 2131099660, 1)));
    soundPool.setOnLoadCompleteListener(this);
    getVolume();
  }
  
  private float getVolume()
  {
    return audioManager.getStreamVolume(2) / audioManager.getStreamMaxVolume(2);
  }
  
  public void onLoadComplete(SoundPool paramSoundPool, int paramInt1, int paramInt2) {}
  
  public void play(int paramInt)
  {
    try
    {
      soundPool.play(((Integer)soundMap.get(Integer.valueOf(paramInt))).intValue(), getVolume(), getVolume(), 1, 0, 1.0F);
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void release()
  {
    soundPool.release();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.utils.SoundManager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */