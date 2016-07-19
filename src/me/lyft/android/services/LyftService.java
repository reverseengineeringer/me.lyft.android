package me.lyft.android.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import me.lyft.android.LyftApplication;

public class LyftService
  extends Service
{
  protected LyftApplication getLyftApplication()
  {
    return (LyftApplication)getApplication();
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public void onCreate()
  {
    super.onCreate();
    getLyftApplication().inject(this);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.services.LyftService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */