package com.squareup.picasso;

import android.os.Handler;
import android.os.Message;
import android.os.Process;
import java.lang.ref.ReferenceQueue;

class Picasso$CleanupThread
  extends Thread
{
  private final Handler handler;
  private final ReferenceQueue<Object> referenceQueue;
  
  Picasso$CleanupThread(ReferenceQueue<Object> paramReferenceQueue, Handler paramHandler)
  {
    referenceQueue = paramReferenceQueue;
    handler = paramHandler;
    setDaemon(true);
    setName("Picasso-refQueue");
  }
  
  public void run()
  {
    Process.setThreadPriority(10);
    try
    {
      for (;;)
      {
        Action.RequestWeakReference localRequestWeakReference = (Action.RequestWeakReference)referenceQueue.remove(1000L);
        Message localMessage = handler.obtainMessage();
        if (localRequestWeakReference != null)
        {
          what = 3;
          obj = action;
          handler.sendMessage(localMessage);
        }
        else
        {
          localMessage.recycle();
        }
      }
      return;
    }
    catch (Exception localException)
    {
      handler.post(new Runnable()
      {
        public void run()
        {
          throw new RuntimeException(localException);
        }
      });
      return;
    }
    catch (InterruptedException localInterruptedException) {}
  }
  
  void shutdown()
  {
    interrupt();
  }
}

/* Location:
 * Qualified Name:     com.squareup.picasso.Picasso.CleanupThread
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */