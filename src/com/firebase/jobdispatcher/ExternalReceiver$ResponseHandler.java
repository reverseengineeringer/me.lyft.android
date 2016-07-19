package com.firebase.jobdispatcher;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

class ExternalReceiver$ResponseHandler
  extends Handler
{
  private final ExternalReceiver receiver;
  
  private ExternalReceiver$ResponseHandler(ExternalReceiver paramExternalReceiver)
  {
    receiver = paramExternalReceiver;
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (what)
    {
    default: 
      Log.wtf("FJD.ExternalReceiver", "handleMessage: unknown message type received: " + what);
      return;
    }
    if ((obj instanceof JobParameters))
    {
      ExternalReceiver.access$200(receiver, (JobParameters)obj, arg1);
      return;
    }
    Log.wtf("FJD.ExternalReceiver", "handleMessage: unknown obj returned");
  }
}

/* Location:
 * Qualified Name:     com.firebase.jobdispatcher.ExternalReceiver.ResponseHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */