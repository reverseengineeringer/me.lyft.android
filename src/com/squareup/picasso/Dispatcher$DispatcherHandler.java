package com.squareup.picasso;

import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class Dispatcher$DispatcherHandler
  extends Handler
{
  private final Dispatcher dispatcher;
  
  public Dispatcher$DispatcherHandler(Looper paramLooper, Dispatcher paramDispatcher)
  {
    super(paramLooper);
    dispatcher = paramDispatcher;
  }
  
  public void handleMessage(final Message paramMessage)
  {
    boolean bool = true;
    switch (what)
    {
    case 3: 
    case 8: 
    default: 
      Picasso.HANDLER.post(new Runnable()
      {
        public void run()
        {
          throw new AssertionError("Unknown handler message received: " + paramMessagewhat);
        }
      });
      return;
    case 1: 
      paramMessage = (Action)obj;
      dispatcher.performSubmit(paramMessage);
      return;
    case 2: 
      paramMessage = (Action)obj;
      dispatcher.performCancel(paramMessage);
      return;
    case 11: 
      paramMessage = obj;
      dispatcher.performPauseTag(paramMessage);
      return;
    case 12: 
      paramMessage = obj;
      dispatcher.performResumeTag(paramMessage);
      return;
    case 4: 
      paramMessage = (BitmapHunter)obj;
      dispatcher.performComplete(paramMessage);
      return;
    case 5: 
      paramMessage = (BitmapHunter)obj;
      dispatcher.performRetry(paramMessage);
      return;
    case 6: 
      paramMessage = (BitmapHunter)obj;
      dispatcher.performError(paramMessage, false);
      return;
    case 7: 
      dispatcher.performBatchComplete();
      return;
    case 9: 
      paramMessage = (NetworkInfo)obj;
      dispatcher.performNetworkStateChange(paramMessage);
      return;
    }
    Dispatcher localDispatcher = dispatcher;
    if (arg1 == 1) {}
    for (;;)
    {
      localDispatcher.performAirplaneModeChange(bool);
      return;
      bool = false;
    }
  }
}

/* Location:
 * Qualified Name:     com.squareup.picasso.Dispatcher.DispatcherHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */