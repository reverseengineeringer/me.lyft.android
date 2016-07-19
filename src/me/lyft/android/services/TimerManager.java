package me.lyft.android.services;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import javax.inject.Singleton;
import me.lyft.android.ILyftPreferences;
import me.lyft.android.common.Objects;
import rx.Observable;

@Singleton
public class TimerManager
{
  @Inject
  ILyftPreferences lyftPreferences;
  private Map<String, TimerManager.TimerCacheValue> timerCache = new HashMap();
  
  private Observable<Long> createTimerOrLoadFromCached(long paramLong, String paramString1, String paramString2)
  {
    Object localObject = (TimerManager.TimerCacheValue)timerCache.get(paramString1);
    if ((localObject != null) && (Objects.equals(((TimerManager.TimerCacheValue)localObject).getTag(), paramString2))) {
      return ((TimerManager.TimerCacheValue)localObject).getTimer().observe();
    }
    localObject = new TimerManager.Timer(paramLong);
    timerCache.put(paramString1, new TimerManager.TimerCacheValue(paramString2, (TimerManager.Timer)localObject));
    return ((TimerManager.Timer)localObject).observe();
  }
  
  private long getTimerRemainingTime(String paramString1, String paramString2, long paramLong)
  {
    TimerRecord localTimerRecord2 = lyftPreferences.getTimerRecord(paramString1);
    long l = System.currentTimeMillis();
    TimerRecord localTimerRecord1;
    if (localTimerRecord2 != null)
    {
      localTimerRecord1 = localTimerRecord2;
      if (Objects.equals(localTimerRecord2.getTag(), paramString2)) {}
    }
    else
    {
      localTimerRecord1 = new TimerRecord(paramString2, Long.valueOf(TimeUnit.SECONDS.toMillis(paramLong) + l));
      lyftPreferences.setTimerRecord(paramString1, localTimerRecord1);
    }
    paramString2 = Long.valueOf(localTimerRecord1.getTimestamp().longValue() - l);
    paramString1 = paramString2;
    if (paramString2.longValue() < 0L) {
      paramString1 = Long.valueOf(0L);
    }
    return TimeUnit.MILLISECONDS.toSeconds(paramString1.longValue());
  }
  
  public Observable<Long> getTimer(String paramString1, String paramString2, long paramLong)
  {
    return createTimerOrLoadFromCached(getTimerRemainingTime(paramString1, paramString2, paramLong), paramString1, paramString2);
  }
  
  public void resetTimer(String paramString)
  {
    TimerManager.TimerCacheValue localTimerCacheValue = (TimerManager.TimerCacheValue)timerCache.get(paramString);
    if (localTimerCacheValue != null)
    {
      localTimerCacheValue.getTimer().stop();
      lyftPreferences.setTimerRecord(paramString, null);
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.services.TimerManager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */