package com.appboy.services;

import android.content.Context;
import bo.app.am;
import bo.app.cd;
import bo.app.ci;
import bo.app.dm;
import bo.app.fq;
import com.appboy.Appboy;
import com.appboy.Constants;
import com.appboy.support.AppboyLogger;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.wearable.DataApi;
import com.google.android.gms.wearable.DataEvent;
import com.google.android.gms.wearable.DataEventBuffer;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.DataMap;
import com.google.android.gms.wearable.DataMapItem;
import com.google.android.gms.wearable.Wearable;
import com.google.android.gms.wearable.WearableListenerService;
import java.util.Iterator;

public class AppboyWearableListenerService
  extends WearableListenerService
{
  private static final String a = String.format("%s.%s", new Object[] { Constants.APPBOY_LOG_TAG_PREFIX, AppboyWearableListenerService.class.getName() });
  private ci<dm> b;
  private GoogleApiClient c;
  
  public void doAppboySdkActionFromDataMap(Context paramContext, DataMap paramDataMap)
  {
    am localam = fq.b(paramDataMap);
    if (localam == am.w)
    {
      paramContext = fq.a(paramDataMap);
      if (paramContext != null) {
        b.a(paramContext);
      }
      return;
    }
    AppboyLogger.i(a, "Received Wear sdk action of type: " + localam.name());
    fq.a(paramDataMap, Appboy.getInstance(paramContext));
  }
  
  public void onCreate()
  {
    super.onCreate();
    String str = a;
    c = new GoogleApiClient.Builder(this).addApiIfAvailable(Wearable.API, new Scope[0]).build();
    c.connect();
    b = new cd(super.getApplicationContext());
  }
  
  public void onDataChanged(DataEventBuffer paramDataEventBuffer)
  {
    if (c.hasConnectedApi(Wearable.API))
    {
      paramDataEventBuffer = paramDataEventBuffer.iterator();
      while (paramDataEventBuffer.hasNext())
      {
        Object localObject = (DataEvent)paramDataEventBuffer.next();
        if (((DataEvent)localObject).getType() == 1)
        {
          localObject = ((DataEvent)localObject).getDataItem();
          DataMap localDataMap = DataMapItem.fromDataItem((DataItem)localObject).getDataMap();
          doAppboySdkActionFromDataMap(super.getApplicationContext(), localDataMap);
          Wearable.DataApi.deleteDataItems(c, ((DataItem)localObject).getUri());
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.appboy.services.AppboyWearableListenerService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */