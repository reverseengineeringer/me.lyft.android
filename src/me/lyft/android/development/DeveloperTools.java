package me.lyft.android.development;

import android.annotation.TargetApi;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.logging.HttpLoggingInterceptor;
import com.squareup.okhttp.logging.HttpLoggingInterceptor.Level;
import me.lyft.android.ILyftPreferences;
import me.lyft.android.LyftApplication;
import me.lyft.android.logging.AnalyticsLogger;
import me.lyft.android.logging.AndroidLogger;
import me.lyft.android.logging.CrashlyticsLogger;
import me.lyft.android.logging.L;
import rx.Observable;
import rx.subjects.BehaviorSubject;

public class DeveloperTools
  implements IDeveloperTools
{
  private final HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
  private final LyftApplication lyftApplication;
  private ILyftPreferences preferences;
  private BehaviorSubject<Boolean> subject;
  
  public DeveloperTools(ILyftPreferences paramILyftPreferences, LyftApplication paramLyftApplication)
  {
    preferences = paramILyftPreferences;
    subject = BehaviorSubject.create(Boolean.valueOf(isDeveloperMode()));
    updateLoggers(isDeveloperMode());
    setHttpLoggingLevel(resolveHttpLoggingLevel());
    lyftApplication = paramLyftApplication;
  }
  
  private HttpLoggingInterceptor.Level resolveHttpLoggingLevel()
  {
    try
    {
      HttpLoggingInterceptor.Level localLevel = HttpLoggingInterceptor.Level.valueOf(preferences.getHttpLoggingLevel());
      return localLevel;
    }
    catch (Throwable localThrowable)
    {
      preferences.setHttpLoggingLevel(HttpLoggingInterceptor.Level.NONE.toString());
    }
    return HttpLoggingInterceptor.Level.NONE;
  }
  
  private void setHttpLoggingLevel(HttpLoggingInterceptor.Level paramLevel)
  {
    loggingInterceptor.setLevel(paramLevel);
    preferences.setHttpLoggingLevel(paramLevel.toString());
  }
  
  @TargetApi(19)
  private static void startStrictMode() {}
  
  private void updateLoggers(boolean paramBoolean)
  {
    L.removeAll();
    L.add(new CrashlyticsLogger());
    L.add(new AnalyticsLogger());
    if (paramBoolean) {
      L.add(new AndroidLogger());
    }
  }
  
  public Interceptor getHttpLoggingInterceptor()
  {
    return loggingInterceptor;
  }
  
  public int getHttpLoggingLevelOrdinal()
  {
    return loggingInterceptor.getLevel().ordinal();
  }
  
  public void initDeveloperTools()
  {
    LeakCanarySupport.installIfPresent(lyftApplication);
    StethoSupport.initStethoIfPresent(lyftApplication);
    startStrictMode();
  }
  
  public boolean isDeveloperMode()
  {
    return preferences.isDeveloperMode();
  }
  
  public Observable<Boolean> observeDeveloperMode()
  {
    return subject.asObservable();
  }
  
  public void setHttpLoggingLevel(int paramInt)
  {
    HttpLoggingInterceptor.Level[] arrayOfLevel = HttpLoggingInterceptor.Level.values();
    if ((paramInt < 0) || (paramInt >= arrayOfLevel.length)) {
      return;
    }
    setHttpLoggingLevel(arrayOfLevel[paramInt]);
  }
  
  public void toggleDeveloperMode()
  {
    if (!preferences.isDeveloperMode()) {}
    for (boolean bool = true;; bool = false)
    {
      preferences.setDeveloperMode(bool);
      subject.onNext(Boolean.valueOf(bool));
      updateLoggers(bool);
      return;
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.development.DeveloperTools
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */