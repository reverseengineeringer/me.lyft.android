package com.facebook;

import android.util.Pair;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class GraphRequest$5
  implements Runnable
{
  GraphRequest$5(ArrayList paramArrayList, GraphRequestBatch paramGraphRequestBatch) {}
  
  public void run()
  {
    Iterator localIterator = val$callbacks.iterator();
    while (localIterator.hasNext())
    {
      Pair localPair = (Pair)localIterator.next();
      ((GraphRequest.Callback)first).onCompleted((GraphResponse)second);
    }
    localIterator = val$requests.getCallbacks().iterator();
    while (localIterator.hasNext()) {
      ((GraphRequestBatch.Callback)localIterator.next()).onBatchCompleted(val$requests);
    }
  }
}

/* Location:
 * Qualified Name:     com.facebook.GraphRequest.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */