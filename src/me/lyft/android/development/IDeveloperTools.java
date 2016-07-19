package me.lyft.android.development;

import com.squareup.okhttp.Interceptor;
import rx.Observable;

public abstract interface IDeveloperTools
{
  public abstract Interceptor getHttpLoggingInterceptor();
  
  public abstract int getHttpLoggingLevelOrdinal();
  
  public abstract void initDeveloperTools();
  
  public abstract boolean isDeveloperMode();
  
  public abstract Observable<Boolean> observeDeveloperMode();
  
  public abstract void setHttpLoggingLevel(int paramInt);
  
  public abstract void toggleDeveloperMode();
}

/* Location:
 * Qualified Name:     me.lyft.android.development.IDeveloperTools
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */