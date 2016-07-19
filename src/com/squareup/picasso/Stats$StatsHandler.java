package com.squareup.picasso;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class Stats$StatsHandler
  extends Handler
{
  private final Stats stats;
  
  public Stats$StatsHandler(Looper paramLooper, Stats paramStats)
  {
    super(paramLooper);
    stats = paramStats;
  }
  
  public void handleMessage(final Message paramMessage)
  {
    switch (what)
    {
    default: 
      Picasso.HANDLER.post(new Runnable()
      {
        public void run()
        {
          throw new AssertionError("Unhandled stats message." + paramMessagewhat);
        }
      });
      return;
    case 0: 
      stats.performCacheHit();
      return;
    case 1: 
      stats.performCacheMiss();
      return;
    case 2: 
      stats.performBitmapDecoded(arg1);
      return;
    case 3: 
      stats.performBitmapTransformed(arg1);
      return;
    }
    stats.performDownloadFinished((Long)obj);
  }
}

/* Location:
 * Qualified Name:     com.squareup.picasso.Stats.StatsHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */