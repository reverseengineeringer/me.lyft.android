package io.fabric.sdk.android;

import io.fabric.sdk.android.services.common.TimingMetric;
import io.fabric.sdk.android.services.concurrency.Priority;
import io.fabric.sdk.android.services.concurrency.PriorityAsyncTask;

class InitializationTask<Result>
  extends PriorityAsyncTask<Void, Void, Result>
{
  final Kit<Result> kit;
  
  public InitializationTask(Kit<Result> paramKit)
  {
    kit = paramKit;
  }
  
  private TimingMetric createAndStartTimingMetric(String paramString)
  {
    paramString = new TimingMetric(kit.getIdentifier() + "." + paramString, "KitInitialization");
    paramString.startMeasuring();
    return paramString;
  }
  
  protected Result doInBackground(Void... paramVarArgs)
  {
    TimingMetric localTimingMetric = createAndStartTimingMetric("doInBackground");
    paramVarArgs = null;
    if (!isCancelled()) {
      paramVarArgs = kit.doInBackground();
    }
    localTimingMetric.stopMeasuring();
    return paramVarArgs;
  }
  
  public Priority getPriority()
  {
    return Priority.HIGH;
  }
  
  protected void onCancelled(Result paramResult)
  {
    kit.onCancelled(paramResult);
    paramResult = new InitializationException(kit.getIdentifier() + " Initialization was cancelled");
    kit.initializationCallback.failure(paramResult);
  }
  
  protected void onPostExecute(Result paramResult)
  {
    kit.onPostExecute(paramResult);
    kit.initializationCallback.success(paramResult);
  }
  
  /* Error */
  protected void onPreExecute()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 112	io/fabric/sdk/android/services/concurrency/PriorityAsyncTask:onPreExecute	()V
    //   4: aload_0
    //   5: ldc 113
    //   7: invokespecial 58	io/fabric/sdk/android/InitializationTask:createAndStartTimingMetric	(Ljava/lang/String;)Lio/fabric/sdk/android/services/common/TimingMetric;
    //   10: astore_2
    //   11: aload_0
    //   12: getfield 15	io/fabric/sdk/android/InitializationTask:kit	Lio/fabric/sdk/android/Kit;
    //   15: invokevirtual 115	io/fabric/sdk/android/Kit:onPreExecute	()Z
    //   18: istore_1
    //   19: aload_2
    //   20: invokevirtual 68	io/fabric/sdk/android/services/common/TimingMetric:stopMeasuring	()V
    //   23: iload_1
    //   24: ifne +9 -> 33
    //   27: aload_0
    //   28: iconst_1
    //   29: invokevirtual 119	io/fabric/sdk/android/InitializationTask:cancel	(Z)Z
    //   32: pop
    //   33: return
    //   34: astore_3
    //   35: aload_3
    //   36: athrow
    //   37: astore_3
    //   38: aload_2
    //   39: invokevirtual 68	io/fabric/sdk/android/services/common/TimingMetric:stopMeasuring	()V
    //   42: iconst_0
    //   43: ifne +9 -> 52
    //   46: aload_0
    //   47: iconst_1
    //   48: invokevirtual 119	io/fabric/sdk/android/InitializationTask:cancel	(Z)Z
    //   51: pop
    //   52: aload_3
    //   53: athrow
    //   54: astore_3
    //   55: invokestatic 125	io/fabric/sdk/android/Fabric:getLogger	()Lio/fabric/sdk/android/Logger;
    //   58: ldc 127
    //   60: ldc -127
    //   62: aload_3
    //   63: invokeinterface 135 4 0
    //   68: aload_2
    //   69: invokevirtual 68	io/fabric/sdk/android/services/common/TimingMetric:stopMeasuring	()V
    //   72: iconst_0
    //   73: ifne -40 -> 33
    //   76: aload_0
    //   77: iconst_1
    //   78: invokevirtual 119	io/fabric/sdk/android/InitializationTask:cancel	(Z)Z
    //   81: pop
    //   82: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	83	0	this	InitializationTask
    //   18	6	1	bool	boolean
    //   10	59	2	localTimingMetric	TimingMetric
    //   34	2	3	localUnmetDependencyException	io.fabric.sdk.android.services.concurrency.UnmetDependencyException
    //   37	16	3	localObject	Object
    //   54	9	3	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   11	19	34	io/fabric/sdk/android/services/concurrency/UnmetDependencyException
    //   11	19	37	finally
    //   35	37	37	finally
    //   55	68	37	finally
    //   11	19	54	java/lang/Exception
  }
}

/* Location:
 * Qualified Name:     io.fabric.sdk.android.InitializationTask
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */