package com.devicecollector;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import com.devicecollector.collectors.AbstractAsyncCollectorTask;
import com.devicecollector.collectors.CollectorEnum;
import com.devicecollector.collectors.CollectorStatusListener;
import com.devicecollector.collectors.LocalCollector;
import com.devicecollector.collectors.LocationCollectorTask;
import com.devicecollector.collectors.SoftErrorCode;
import com.devicecollector.collectors.WebCollectorTask;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CancellationException;

public class CollectorProcess
  extends AbstractCollectorProcess
  implements CollectorStatusListener
{
  private ArrayList<AbstractAsyncCollectorTask> collectors;
  private DataCollection dataCollection;
  private Exception errorCause;
  private DeviceCollector.ErrorCode errorCode;
  
  public CollectorProcess(Activity paramActivity, DeviceCollector.StatusListener paramStatusListener, EnumSet<CollectorEnum> paramEnumSet)
  {
    super(paramActivity, paramStatusListener, paramEnumSet);
  }
  
  private void checkIfDone()
  {
    debug("checking if we are done...", new Object[0]);
    if ((collectors != null) && (collectors.size() > 0))
    {
      Object localObject1 = new ArrayList();
      Object localObject2 = collectors.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        AbstractAsyncCollectorTask localAbstractAsyncCollectorTask = (AbstractAsyncCollectorTask)((Iterator)localObject2).next();
        if (localAbstractAsyncCollectorTask.isFinished()) {
          ((ArrayList)localObject1).add(localAbstractAsyncCollectorTask);
        }
      }
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (AbstractAsyncCollectorTask)((Iterator)localObject1).next();
        collectors.remove(localObject2);
      }
    }
    if ((dataCollection != null) && (dataCollection.getServerUrl() != null) && ((collectors == null) || (collectors.size() == 0)))
    {
      debug("All done, sending data...", new Object[0]);
      sendDataCollection();
      endProcess(null, null);
      return;
    }
    debug("[%s] collectors left", new Object[] { "" + collectors.size() });
  }
  
  private void endProcess(DeviceCollector.ErrorCode paramErrorCode, Exception paramException)
  {
    finished = true;
    if (paramErrorCode != null)
    {
      errorCode = paramErrorCode;
      errorCause = paramException;
    }
    if (lstnr != null) {
      if (errorCode == null)
      {
        debug("Telling the listener we succeeded...", new Object[0]);
        lstnr.onCollectorSuccess();
      }
    }
    for (;;)
    {
      try
      {
        notifyAll();
        finished = true;
        return;
      }
      finally {}
      debug("Telling the listener we had a bad error...", new Object[0]);
      lstnr.onCollectorError(errorCode, errorCause);
      break;
      debug("No listener to notify", new Object[0]);
    }
  }
  
  private void removeCollectorFromList(CollectorEnum paramCollectorEnum)
  {
    if (collectors != null)
    {
      Object localObject2 = null;
      Iterator localIterator = collectors.iterator();
      Object localObject1;
      do
      {
        localObject1 = localObject2;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject1 = (AbstractAsyncCollectorTask)localIterator.next();
      } while (!((AbstractAsyncCollectorTask)localObject1).getCollectorType().equals(paramCollectorEnum));
      if (localObject1 != null)
      {
        debug("Removing collector [%s]", new Object[] { ((AbstractAsyncCollectorTask)localObject1).getCollectorType() });
        collectors.remove(localObject1);
        return;
      }
      debug("Collector not found [%s]", new Object[] { paramCollectorEnum });
      return;
    }
    debug("No collectors being held", new Object[0]);
  }
  
  @SuppressLint({"NewApi"})
  private void sendDataCollection()
  {
    Object localObject1 = new AsyncTransmissionTask();
    Object localObject2 = new DataCollection[1];
    localObject2[0] = dataCollection;
    if (Build.VERSION.SDK_INT > 10) {
      ((AsyncTransmissionTask)localObject1).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, (Object[])localObject2);
    }
    for (;;)
    {
      debug("Final Collection:", new Object[0]);
      localObject1 = dataCollection.getPostData().keySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        debug("key:[%s] value:[%s]", new Object[] { localObject2, dataCollection.getPostData().get(localObject2) });
      }
      ((AsyncTransmissionTask)localObject1).execute((Object[])localObject2);
    }
  }
  
  private boolean skip(CollectorEnum paramCollectorEnum)
  {
    if ((skipList != null) && (skipList.contains(paramCollectorEnum)))
    {
      dataCollection.addError(paramCollectorEnum, SoftErrorCode.MERCHANT_SKIPPED);
      return true;
    }
    return false;
  }
  
  @SuppressLint({"NewApi"})
  protected Void doInBackground(String... paramVarArgs)
  {
    collectors = new ArrayList();
    dataCollection = new DataCollection(paramVarArgs[0], paramVarArgs[1], paramVarArgs[2]);
    long l;
    if (getTimeoutOverridden())
    {
      l = getTimeoutMs();
      paramVarArgs = new WebCollectorTask(activity, this, dataCollection, l);
      collectors.add(paramVarArgs);
      if (!skip(CollectorEnum.GEO_LOCATION))
      {
        paramVarArgs = new LocationCollectorTask(activity, this, dataCollection, l);
        collectors.add(paramVarArgs);
      }
      paramVarArgs = collectors.iterator();
    }
    for (;;)
    {
      if (!paramVarArgs.hasNext()) {
        break label214;
      }
      AbstractAsyncCollectorTask localAbstractAsyncCollectorTask = (AbstractAsyncCollectorTask)paramVarArgs.next();
      debug("Starting off " + localAbstractAsyncCollectorTask.getClass().getName(), new Object[0]);
      if (Build.VERSION.SDK_INT > 10)
      {
        localAbstractAsyncCollectorTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        continue;
        l = 5000L;
        break;
      }
      localAbstractAsyncCollectorTask.execute(new Void[0]);
    }
    label214:
    debug("Getting the quick data...", new Object[0]);
    paramVarArgs = new LocalCollector(activity, dataCollection);
    paramVarArgs.collectRequiredInfo();
    debug("Got Required Info", new Object[0]);
    paramVarArgs.collectOptionalInfo();
    debug("Got optional info...", new Object[0]);
    paramVarArgs.collectDeviceId();
    debug("Got Device Cookie Info", new Object[0]);
    debug("Done with quick data", new Object[0]);
    checkIfDone();
    return null;
  }
  
  public void onCancelled()
  {
    debug("Called cancel..", new Object[0]);
    if ((!finished) && (dataCollection != null) && (dataCollection.getServerUrl() != null))
    {
      debug("Cancelling each collector", new Object[0]);
      localIterator = collectors.iterator();
      while (localIterator.hasNext())
      {
        localAbstractAsyncCollectorTask = (AbstractAsyncCollectorTask)localIterator.next();
        if ((!localAbstractAsyncCollectorTask.isFinished()) && (!localAbstractAsyncCollectorTask.isCancelled()))
        {
          dataCollection.addError(localAbstractAsyncCollectorTask.getCollectorType(), SoftErrorCode.MERCHANT_CANCELLED);
          debug("Cancelling [" + localAbstractAsyncCollectorTask.getCollectorType() + "] collector...", new Object[0]);
          localAbstractAsyncCollectorTask.cancel(true);
          debug("Cancelled [" + localAbstractAsyncCollectorTask.getCollectorType() + "] collector.", new Object[0]);
        }
      }
      sendDataCollection();
      endProcess(null, null);
    }
    while (finished)
    {
      Iterator localIterator;
      AbstractAsyncCollectorTask localAbstractAsyncCollectorTask;
      return;
    }
    endProcess(DeviceCollector.ErrorCode.MERCHANT_CANCELLED, new CancellationException("Merchant Cancelled"));
  }
  
  public void onCollectorError(CollectorEnum paramCollectorEnum, SoftErrorCode paramSoftErrorCode, Exception paramException)
  {
    debug("Removing collector[%s] due to error [%s]", new Object[] { paramCollectorEnum, paramSoftErrorCode });
    removeCollectorFromList(paramCollectorEnum);
    if (CollectorEnum.WEB.equals(paramCollectorEnum))
    {
      finished = true;
      errorCode = DeviceCollector.ErrorCode.RUNTIME_FAILURE;
      errorCause = paramException;
      if (lstnr != null) {
        lstnr.onCollectorError(errorCode, errorCause);
      }
      try
      {
        notifyAll();
        return;
      }
      finally {}
    }
    checkIfDone();
  }
  
  public void onCollectorStart(CollectorEnum paramCollectorEnum)
  {
    debug("Long Collector starting:" + paramCollectorEnum, new Object[0]);
  }
  
  public void onCollectorSuccess(CollectorEnum paramCollectorEnum)
  {
    debug("Collector success [%s]", new Object[] { paramCollectorEnum });
    removeCollectorFromList(paramCollectorEnum);
    checkIfDone();
  }
}

/* Location:
 * Qualified Name:     com.devicecollector.CollectorProcess
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */