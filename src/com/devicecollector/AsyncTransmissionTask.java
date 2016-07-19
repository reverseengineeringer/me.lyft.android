package com.devicecollector;

import android.os.AsyncTask;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

public class AsyncTransmissionTask
  extends AsyncTask<DataCollection, Void, Void>
{
  protected Void doInBackground(DataCollection... paramVarArgs)
  {
    Object localObject1;
    ArrayList localArrayList;
    if ((paramVarArgs != null) && (paramVarArgs.length == 1))
    {
      Object localObject2 = paramVarArgs[0];
      if (((DataCollection)localObject2).getServerUrl() == null) {
        break label203;
      }
      paramVarArgs = new DefaultHttpClient();
      localObject1 = ((DataCollection)localObject2).getServerUrl() + "/m.html";
      Log.d("Transmitter", "Sending to:" + (String)localObject1);
      localObject1 = new HttpPost((String)localObject1);
      localArrayList = new ArrayList();
      try
      {
        localObject2 = ((DataCollection)localObject2).getPostData();
        Iterator localIterator = ((HashMap)localObject2).keySet().iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          localArrayList.add(new BasicNameValuePair(str, (String)((HashMap)localObject2).get(str)));
          continue;
          return null;
        }
      }
      catch (Exception paramVarArgs)
      {
        Log.d("Transmitter", paramVarArgs.getMessage());
      }
    }
    for (;;)
    {
      ((HttpPost)localObject1).setEntity(new UrlEncodedFormEntity(localArrayList));
      paramVarArgs.execute((HttpUriRequest)localObject1);
      continue;
      label203:
      Log.d("Transmitter", "No Server URL to send data to, skipping send");
    }
  }
}

/* Location:
 * Qualified Name:     com.devicecollector.AsyncTransmissionTask
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */