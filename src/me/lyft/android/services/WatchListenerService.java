package me.lyft.android.services;

import android.net.Uri;
import com.google.android.gms.wearable.DataEvent;
import com.google.android.gms.wearable.DataEventBuffer;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.DataMap;
import com.google.android.gms.wearable.DataMapItem;
import com.google.android.gms.wearable.MessageEvent;
import com.google.android.gms.wearable.Node;
import com.google.android.gms.wearable.WearableListenerService;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import me.lyft.android.LyftApplication;
import me.lyft.android.application.ride.IWearRideRequestService;
import me.lyft.android.common.Unit;
import me.lyft.android.logging.L;
import me.lyft.android.rx.SimpleSubscriber;
import rx.Observable;

public class WatchListenerService
  extends WearableListenerService
{
  private static final String LATITUDE_PARAM = "latitude";
  private static final String LONGITUDE_PARAM = "longitude";
  private static final long REQUEST_TIMEOUT = TimeUnit.SECONDS.toMillis(5L);
  private static final String RIDE_REQUEST_DATA_PATH = "/ride_request";
  private static final String TIMESTAMP_PARAM = "timestamp";
  @Inject
  IWearRideRequestService wearRideRequestService;
  
  private void requestRide(DataItem paramDataItem)
  {
    paramDataItem = DataMapItem.fromDataItem(paramDataItem).getDataMap();
    long l = paramDataItem.getLong("timestamp");
    double d1 = paramDataItem.getDouble("latitude");
    double d2 = paramDataItem.getDouble("longitude");
    if (System.currentTimeMillis() - l < REQUEST_TIMEOUT) {
      wearRideRequestService.requestRide(d1, d2).subscribe(new SimpleSubscriber()
      {
        public void onError(Throwable paramAnonymousThrowable)
        {
          super.onError(paramAnonymousThrowable);
          L.w(paramAnonymousThrowable, "failed to request ride from watch", new Object[0]);
        }
        
        public void onNext(Unit paramAnonymousUnit)
        {
          super.onNext(paramAnonymousUnit);
        }
      });
    }
  }
  
  public LyftApplication getLyftApplication()
  {
    return (LyftApplication)getApplicationContext();
  }
  
  public void onCreate()
  {
    super.onCreate();
    L.d("onAttached", new Object[0]);
    getLyftApplication().inject(this);
  }
  
  public void onDataChanged(DataEventBuffer paramDataEventBuffer)
  {
    L.d("onDataChanged: " + paramDataEventBuffer + " for " + getPackageName(), new Object[0]);
    for (;;)
    {
      Object localObject;
      try
      {
        paramDataEventBuffer = paramDataEventBuffer.iterator();
        if (paramDataEventBuffer.hasNext())
        {
          localObject = (DataEvent)paramDataEventBuffer.next();
          if (((DataEvent)localObject).getType() == 1)
          {
            localObject = ((DataEvent)localObject).getDataItem();
            if (!((DataItem)localObject).getUri().getPath().equalsIgnoreCase("/ride_request")) {
              continue;
            }
            requestRide((DataItem)localObject);
          }
        }
        else
        {
          return;
        }
      }
      catch (Throwable paramDataEventBuffer)
      {
        L.e(paramDataEventBuffer, "Failed to handle watch message", new Object[0]);
      }
      int i = ((DataEvent)localObject).getType();
      if (i != 2) {}
    }
  }
  
  public void onMessageReceived(MessageEvent paramMessageEvent)
  {
    L.d("onMessageReceived: " + paramMessageEvent.getPath() + " " + " for " + getPackageName(), new Object[0]);
  }
  
  public void onPeerConnected(Node paramNode)
  {
    super.onPeerConnected(paramNode);
    L.d("onPeerConnected", new Object[0]);
  }
  
  public void onPeerDisconnected(Node paramNode)
  {
    super.onPeerDisconnected(paramNode);
    L.d("onPeerDisconnected", new Object[0]);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.services.WatchListenerService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */