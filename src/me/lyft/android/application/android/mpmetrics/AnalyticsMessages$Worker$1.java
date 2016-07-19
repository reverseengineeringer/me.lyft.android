package me.lyft.android.application.android.mpmetrics;

import java.util.concurrent.SynchronousQueue;

class AnalyticsMessages$Worker$1
  extends Thread
{
  AnalyticsMessages$Worker$1(AnalyticsMessages.Worker paramWorker, SynchronousQueue paramSynchronousQueue) {}
  
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
}

/* Location:
 * Qualified Name:     me.lyft.android.application.android.mpmetrics.AnalyticsMessages.Worker.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */