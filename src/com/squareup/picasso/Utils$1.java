package com.squareup.picasso;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

final class Utils$1
  extends Handler
{
  Utils$1(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    sendMessageDelayed(obtainMessage(), 1000L);
  }
}

/* Location:
 * Qualified Name:     com.squareup.picasso.Utils.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */