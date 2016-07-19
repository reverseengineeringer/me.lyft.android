package com.squareup.picasso;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.List;

final class Picasso$1
  extends Handler
{
  Picasso$1(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i;
    int j;
    Object localObject;
    switch (what)
    {
    default: 
      throw new AssertionError("Unknown handler message received: " + what);
    case 8: 
      paramMessage = (List)obj;
      i = 0;
      j = paramMessage.size();
    case 3: 
      while (i < j)
      {
        localObject = (BitmapHunter)paramMessage.get(i);
        picasso.complete((BitmapHunter)localObject);
        i += 1;
        continue;
        paramMessage = (Action)obj;
        if (getPicassologgingEnabled) {
          Utils.log("Main", "canceled", request.logId(), "target got garbage collected");
        }
        Picasso.access$000(picasso, paramMessage.getTarget());
      }
    }
    for (;;)
    {
      return;
      paramMessage = (List)obj;
      i = 0;
      j = paramMessage.size();
      while (i < j)
      {
        localObject = (Action)paramMessage.get(i);
        picasso.resumeAction((Action)localObject);
        i += 1;
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.squareup.picasso.Picasso.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */