package com.google.android.gms.internal;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.os.Handler;
import android.os.Looper;
import java.util.HashMap;

final class zzaer$1
  extends Thread
{
  zzaer$1(String paramString, ContentResolver paramContentResolver)
  {
    super(paramString);
  }
  
  public void run()
  {
    Looper.prepare();
    aMd.registerContentObserver(zzaer.CONTENT_URI, true, new ContentObserver(new Handler(Looper.myLooper()))
    {
      public void onChange(boolean paramAnonymousBoolean)
      {
        try
        {
          zzaer.zzcjl().clear();
          zzaer.zzbb(new Object());
          if (zzaer.zzcjm().length > 0) {
            zzaer.zzb(aMd, zzaer.zzcjm());
          }
          return;
        }
        finally {}
      }
    });
    Looper.loop();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzaer.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */