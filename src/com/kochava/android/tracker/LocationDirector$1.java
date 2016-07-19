package com.kochava.android.tracker;

import com.kochava.android.util.Logging;

class LocationDirector$1
  extends Thread
{
  LocationDirector$1(LocationDirector paramLocationDirector) {}
  
  public void run()
  {
    try
    {
      Thread.sleep(LocationDirector.timeout * 1000);
      Logging.Log("timeout reached, calling reset");
      LocationDirector.access$000();
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;) {}
    }
  }
}

/* Location:
 * Qualified Name:     com.kochava.android.tracker.LocationDirector.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */