package me.lyft.android.application.android.mpmetrics;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.squareup.okhttp.OkHttpClient;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import me.lyft.android.infrastructure.json.IJsonSerializer;
import org.json.JSONObject;

class AnalyticsMessages
{
  private static int ENQUEUE_EVENTS = 1;
  private static int FLUSH_QUEUE = 2;
  private static int KILL_WORKER = 5;
  private static final String LOGTAG = "MixpanelAPI";
  private static int SET_ENDPOINT_HOST = 6;
  private static int SET_FALLBACK_HOST = 7;
  private static int SET_FLUSH_INTERVAL = 4;
  private static final Map<Context, AnalyticsMessages> sInstances = new HashMap();
  private final Context mContext;
  private final IJsonSerializer mJsonSerializer;
  private final AtomicBoolean mLogMixpanelMessages;
  private final Worker mWorker;
  private OkHttpClient okHttpClient;
  
  AnalyticsMessages(Context paramContext, IJsonSerializer paramIJsonSerializer, OkHttpClient paramOkHttpClient)
  {
    mContext = paramContext;
    okHttpClient = paramOkHttpClient;
    mLogMixpanelMessages = new AtomicBoolean(false);
    mWorker = new Worker();
    mJsonSerializer = paramIJsonSerializer;
  }
  
  public static AnalyticsMessages getInstance(Context paramContext, IJsonSerializer paramIJsonSerializer, OkHttpClient paramOkHttpClient)
  {
    synchronized (sInstances)
    {
      Context localContext = paramContext.getApplicationContext();
      if (!sInstances.containsKey(localContext))
      {
        paramContext = new AnalyticsMessages(localContext, paramIJsonSerializer, paramOkHttpClient);
        sInstances.put(localContext, paramContext);
        return paramContext;
      }
      paramContext = (AnalyticsMessages)sInstances.get(localContext);
    }
  }
  
  private void logAboutMessageToMixpanel(String paramString)
  {
    if (!mLogMixpanelMessages.get()) {
      return;
    }
    Log.i("MixpanelAPI", paramString + " (Thread " + Thread.currentThread().getId() + ")");
  }
  
  public void eventsMessage(JSONObject paramJSONObject)
  {
    Message localMessage = Message.obtain();
    what = ENQUEUE_EVENTS;
    obj = paramJSONObject;
    mWorker.runMessage(localMessage);
  }
  
  protected HttpPoster getPoster(String paramString)
  {
    return new HttpPoster(paramString, null, mJsonSerializer, okHttpClient);
  }
  
  public void hardKill()
  {
    Message localMessage = Message.obtain();
    what = KILL_WORKER;
    mWorker.runMessage(localMessage);
  }
  
  boolean isDead()
  {
    return mWorker.isDead();
  }
  
  protected MPDbAdapter makeDbAdapter(Context paramContext)
  {
    return new MPDbAdapter(paramContext);
  }
  
  public void postToServer()
  {
    Message localMessage = Message.obtain();
    what = FLUSH_QUEUE;
    mWorker.runMessage(localMessage);
  }
  
  public void setEndpointHost(String paramString)
  {
    Message localMessage = Message.obtain();
    what = SET_ENDPOINT_HOST;
    obj = paramString;
    mWorker.runMessage(localMessage);
  }
  
  public void setFallbackHost(String paramString)
  {
    Message localMessage = Message.obtain();
    what = SET_FALLBACK_HOST;
    obj = paramString;
    mWorker.runMessage(localMessage);
  }
  
  public void setFlushInterval(long paramLong)
  {
    Message localMessage = Message.obtain();
    what = SET_FLUSH_INTERVAL;
    obj = new Long(paramLong);
    mWorker.runMessage(localMessage);
  }
  
  private class Worker
  {
    private long mAveFlushFrequency = 0L;
    private long mFlushCount = 0L;
    private long mFlushInterval = 60000L;
    private Handler mHandler = restartWorkerThread();
    private final Object mHandlerLock = new Object();
    private long mLastFlushTime = -1L;
    
    public Worker() {}
    
    private Handler restartWorkerThread()
    {
      final Object localObject = new SynchronousQueue();
      Thread local1 = new Thread()
      {
        /* Error */
        public void run()
        {
          // Byte code:
          //   0: invokestatic 36	android/os/Looper:prepare	()V
          //   3: aload_0
          //   4: getfield 22	me/lyft/android/application/android/mpmetrics/AnalyticsMessages$Worker$1:val$handlerQueue	Ljava/util/concurrent/SynchronousQueue;
          //   7: new 38	me/lyft/android/application/android/mpmetrics/AnalyticsMessages$Worker$AnalyticsMessageHandler
          //   10: dup
          //   11: aload_0
          //   12: getfield 20	me/lyft/android/application/android/mpmetrics/AnalyticsMessages$Worker$1:this$1	Lme/lyft/android/application/android/mpmetrics/AnalyticsMessages$Worker;
          //   15: invokespecial 41	me/lyft/android/application/android/mpmetrics/AnalyticsMessages$Worker$AnalyticsMessageHandler:<init>	(Lme/lyft/android/application/android/mpmetrics/AnalyticsMessages$Worker;)V
          //   18: invokevirtual 47	java/util/concurrent/SynchronousQueue:put	(Ljava/lang/Object;)V
          //   21: invokestatic 50	android/os/Looper:loop	()V
          //   24: return
          //   25: astore_1
          //   26: new 31	java/lang/RuntimeException
          //   29: dup
          //   30: ldc 52
          //   32: aload_1
          //   33: invokespecial 55	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
          //   36: athrow
          //   37: astore_1
          //   38: ldc 57
          //   40: ldc 59
          //   42: aload_1
          //   43: invokestatic 65	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
          //   46: pop
          //   47: return
          // Local variable table:
          //   start	length	slot	name	signature
          //   0	48	0	this	1
          //   25	8	1	localInterruptedException	InterruptedException
          //   37	6	1	localRuntimeException	RuntimeException
          // Exception table:
          //   from	to	target	type
          //   3	21	25	java/lang/InterruptedException
          //   21	24	37	java/lang/RuntimeException
        }
      };
      local1.setPriority(1);
      local1.start();
      try
      {
        localObject = (Handler)((SynchronousQueue)localObject).take();
        return (Handler)localObject;
      }
      catch (InterruptedException localInterruptedException)
      {
        throw new RuntimeException("Couldn't retrieve handler fromGooglePlayPlace worker thread");
      }
    }
    
    private void updateFlushFrequency()
    {
      long l1 = System.currentTimeMillis();
      long l2 = mFlushCount + 1L;
      if (mLastFlushTime > 0L)
      {
        mAveFlushFrequency = ((l1 - mLastFlushTime + mAveFlushFrequency * mFlushCount) / l2);
        long l3 = mAveFlushFrequency / 1000L;
        AnalyticsMessages.this.logAboutMessageToMixpanel("Average send frequency approximately " + l3 + " seconds.");
      }
      mLastFlushTime = l1;
      mFlushCount = l2;
    }
    
    public boolean isDead()
    {
      for (;;)
      {
        synchronized (mHandlerLock)
        {
          if (mHandler == null)
          {
            bool = true;
            return bool;
          }
        }
        boolean bool = false;
      }
    }
    
    public void runMessage(Message paramMessage)
    {
      if (isDead())
      {
        AnalyticsMessages.this.logAboutMessageToMixpanel("Dead mixpanel worker dropping a message: " + paramMessage);
        return;
      }
      synchronized (mHandlerLock)
      {
        if (mHandler != null) {
          mHandler.sendMessage(paramMessage);
        }
        return;
      }
    }
    
    private class AnalyticsMessageHandler
      extends Handler
    {
      private final MPDbAdapter mDbAdapter = makeDbAdapter(mContext);
      private String mEndpointHost;
      
      public AnalyticsMessageHandler()
      {
        mDbAdapter.cleanupEvents(System.currentTimeMillis() - 172800000L, MPDbAdapter.Table.EVENTS);
      }
      
      private void sendAllData()
      {
        AnalyticsMessages.this.logAboutMessageToMixpanel("Sending records to Mixpanel");
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
          localPostResult = getPoster(mEndpointHost).postData((String)localObject, paramString);
          if (localPostResult != HttpPoster.PostResult.SUCCEEDED) {
            break label126;
          }
          AnalyticsMessages.this.logAboutMessageToMixpanel(String.format("Posted to %s%s", new Object[] { mEndpointHost, paramString }));
          AnalyticsMessages.this.logAboutMessageToMixpanel("Sent Message\n" + (String)localObject);
          mDbAdapter.cleanupEvents(str, paramTable);
        }
        label126:
        do
        {
          return;
          if (localPostResult != HttpPoster.PostResult.FAILED_RECOVERABLE) {
            break;
          }
        } while (hasMessages(AnalyticsMessages.FLUSH_QUEUE));
        sendEmptyMessageDelayed(AnalyticsMessages.FLUSH_QUEUE, mFlushInterval);
        return;
        AnalyticsMessages.this.logAboutMessageToMixpanel("Failed to send message\n" + (String)localObject);
        mDbAdapter.cleanupEvents(str, paramTable);
      }
      
      public void handleMessage(Message arg1)
      {
        Object localObject1 = null;
        int i = -1;
        try
        {
          if (what == AnalyticsMessages.SET_FLUSH_INTERVAL)
          {
            ??? = (Long)obj;
            AnalyticsMessages.this.logAboutMessageToMixpanel("Changing flush interval to " + ???);
            AnalyticsMessages.Worker.access$302(AnalyticsMessages.Worker.this, ???.longValue());
            removeMessages(AnalyticsMessages.FLUSH_QUEUE);
          }
          for (;;)
          {
            if (i < 40) {
              break label433;
            }
            AnalyticsMessages.this.logAboutMessageToMixpanel("Flushing queue due to bulk upload limit");
            AnalyticsMessages.Worker.this.updateFlushFrequency();
            sendAllData();
            return;
            if (what != AnalyticsMessages.SET_ENDPOINT_HOST) {
              break label209;
            }
            if (obj != null) {
              break;
            }
            ??? = (Message)localObject1;
            mEndpointHost = ???;
            AnalyticsMessages.this.logAboutMessageToMixpanel("Setting endpoint API host to " + mEndpointHost);
          }
        }
        catch (RuntimeException localRuntimeException)
        {
          for (;;)
          {
            Log.e("MixpanelAPI", "Worker threw an unhandled exception- will not send any more mixpanel messages", localRuntimeException);
            synchronized (mHandlerLock)
            {
              AnalyticsMessages.Worker.access$1002(AnalyticsMessages.Worker.this, null);
              try
              {
                Looper.myLooper().quit();
                throw localRuntimeException;
                ??? = obj.toString();
                continue;
                label209:
                if (what == AnalyticsMessages.ENQUEUE_EVENTS)
                {
                  ??? = (JSONObject)obj;
                  AnalyticsMessages.this.logAboutMessageToMixpanel("Queuing event for sending later");
                  AnalyticsMessages.this.logAboutMessageToMixpanel("    " + ???.toString());
                  i = mDbAdapter.addJSON(???, MPDbAdapter.Table.EVENTS);
                }
                else if (what == AnalyticsMessages.FLUSH_QUEUE)
                {
                  AnalyticsMessages.this.logAboutMessageToMixpanel("Flushing queue due to scheduled or forced flush");
                  AnalyticsMessages.Worker.this.updateFlushFrequency();
                  sendAllData();
                }
                else
                {
                  if (what == AnalyticsMessages.KILL_WORKER)
                  {
                    Log.w("MixpanelAPI", "Worker recieved a hard kill. Dumping all events and force-killing. Thread id " + Thread.currentThread().getId());
                    synchronized (mHandlerLock)
                    {
                      mDbAdapter.deleteDB();
                      AnalyticsMessages.Worker.access$1002(AnalyticsMessages.Worker.this, null);
                      Looper.myLooper().quit();
                    }
                  }
                  Log.e("MixpanelAPI", "Unexpected message recieved by Mixpanel worker: " + ???);
                  continue;
                  label433:
                  if ((i > 0) && (!hasMessages(AnalyticsMessages.FLUSH_QUEUE)))
                  {
                    AnalyticsMessages.this.logAboutMessageToMixpanel("Queue depth " + i + " - Adding flush in " + mFlushInterval);
                    sendEmptyMessageDelayed(AnalyticsMessages.FLUSH_QUEUE, mFlushInterval);
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
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.android.mpmetrics.AnalyticsMessages
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */