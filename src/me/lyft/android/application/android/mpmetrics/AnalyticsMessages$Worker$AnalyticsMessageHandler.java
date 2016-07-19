package me.lyft.android.application.android.mpmetrics;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import org.json.JSONObject;

class AnalyticsMessages$Worker$AnalyticsMessageHandler
  extends Handler
{
  private final MPDbAdapter mDbAdapter;
  private String mEndpointHost;
  
  public AnalyticsMessages$Worker$AnalyticsMessageHandler(AnalyticsMessages.Worker paramWorker)
  {
    mDbAdapter = this$0.makeDbAdapter(AnalyticsMessages.access$100(this$0));
    mDbAdapter.cleanupEvents(System.currentTimeMillis() - 172800000L, MPDbAdapter.Table.EVENTS);
  }
  
  private void sendAllData()
  {
    AnalyticsMessages.access$000(this$1.this$0, "Sending records to Mixpanel");
    sendData(MPDbAdapter.Table.EVENTS, "/v1/track");
  }
  
  private void sendData(MPDbAdapter.Table paramTable, String paramString)
  {
    Object localObject = mDbAdapter.generateDataString(paramTable);
    String str;
    HttpPoster.PostResult localPostResult;
    if (localObject != null)
    {
      str = localObject[0];
      localObject = localObject[1];
      localPostResult = this$1.this$0.getPoster(mEndpointHost).postData((String)localObject, paramString);
      if (localPostResult != HttpPoster.PostResult.SUCCEEDED) {
        break label126;
      }
      AnalyticsMessages.access$000(this$1.this$0, String.format("Posted to %s%s", new Object[] { mEndpointHost, paramString }));
      AnalyticsMessages.access$000(this$1.this$0, "Sent Message\n" + (String)localObject);
      mDbAdapter.cleanupEvents(str, paramTable);
    }
    label126:
    do
    {
      return;
      if (localPostResult != HttpPoster.PostResult.FAILED_RECOVERABLE) {
        break;
      }
    } while (hasMessages(AnalyticsMessages.access$400()));
    sendEmptyMessageDelayed(AnalyticsMessages.access$400(), AnalyticsMessages.Worker.access$300(this$1));
    return;
    AnalyticsMessages.access$000(this$1.this$0, "Failed to send message\n" + (String)localObject);
    mDbAdapter.cleanupEvents(str, paramTable);
  }
  
  public void handleMessage(Message arg1)
  {
    Object localObject1 = null;
    int i = -1;
    try
    {
      if (what == AnalyticsMessages.access$200())
      {
        ??? = (Long)obj;
        AnalyticsMessages.access$000(this$1.this$0, "Changing flush interval to " + ???);
        AnalyticsMessages.Worker.access$302(this$1, ???.longValue());
        removeMessages(AnalyticsMessages.access$400());
      }
      for (;;)
      {
        if (i < 40) {
          break label433;
        }
        AnalyticsMessages.access$000(this$1.this$0, "Flushing queue due to bulk upload limit");
        AnalyticsMessages.Worker.access$700(this$1);
        sendAllData();
        return;
        if (what != AnalyticsMessages.access$500()) {
          break label209;
        }
        if (obj != null) {
          break;
        }
        ??? = (Message)localObject1;
        mEndpointHost = ???;
        AnalyticsMessages.access$000(this$1.this$0, "Setting endpoint API host to " + mEndpointHost);
      }
    }
    catch (RuntimeException localRuntimeException)
    {
      for (;;)
      {
        Log.e("MixpanelAPI", "Worker threw an unhandled exception- will not send any more mixpanel messages", localRuntimeException);
        synchronized (AnalyticsMessages.Worker.access$900(this$1))
        {
          AnalyticsMessages.Worker.access$1002(this$1, null);
          try
          {
            Looper.myLooper().quit();
            throw localRuntimeException;
            ??? = obj.toString();
            continue;
            label209:
            if (what == AnalyticsMessages.access$600())
            {
              ??? = (JSONObject)obj;
              AnalyticsMessages.access$000(this$1.this$0, "Queuing event for sending later");
              AnalyticsMessages.access$000(this$1.this$0, "    " + ???.toString());
              i = mDbAdapter.addJSON(???, MPDbAdapter.Table.EVENTS);
            }
            else if (what == AnalyticsMessages.access$400())
            {
              AnalyticsMessages.access$000(this$1.this$0, "Flushing queue due to scheduled or forced flush");
              AnalyticsMessages.Worker.access$700(this$1);
              sendAllData();
            }
            else
            {
              if (what == AnalyticsMessages.access$800())
              {
                Log.w("MixpanelAPI", "Worker recieved a hard kill. Dumping all events and force-killing. Thread id " + Thread.currentThread().getId());
                synchronized (AnalyticsMessages.Worker.access$900(this$1))
                {
                  mDbAdapter.deleteDB();
                  AnalyticsMessages.Worker.access$1002(this$1, null);
                  Looper.myLooper().quit();
                }
              }
              Log.e("MixpanelAPI", "Unexpected message recieved by Mixpanel worker: " + ???);
              continue;
              label433:
              if ((i > 0) && (!hasMessages(AnalyticsMessages.access$400())))
              {
                AnalyticsMessages.access$000(this$1.this$0, "Queue depth " + i + " - Adding flush in " + AnalyticsMessages.Worker.access$300(this$1));
                sendEmptyMessageDelayed(AnalyticsMessages.access$400(), AnalyticsMessages.Worker.access$300(this$1));
                return;
              }
            }
          }
          catch (Exception localException)
          {
            for (;;)
            {
              Log.e("MixpanelAPI", "Could not halt looper", localException);
            }
          }
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.android.mpmetrics.AnalyticsMessages.Worker.AnalyticsMessageHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */