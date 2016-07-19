package com.lyft.rx;

import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.Scheduler;
import rx.Scheduler.Worker;
import rx.Subscriber;
import rx.functions.Action0;
import rx.schedulers.Schedulers;
import rx.subscriptions.Subscriptions;

public class CountdownTimer
{
  public static Observable<Integer> create(long paramLong, TimeUnit paramTimeUnit, int paramInt)
  {
    return Observable.create(new CountdownTimerObservable(paramLong, paramTimeUnit, paramInt));
  }
  
  private static class CountdownTimerObservable
    implements Observable.OnSubscribe<Integer>
  {
    private int currentCount;
    private final long timeDelay;
    private final TimeUnit timeUnit;
    
    public CountdownTimerObservable(long paramLong, TimeUnit paramTimeUnit, int paramInt)
    {
      timeDelay = paramLong;
      timeUnit = paramTimeUnit;
      currentCount = paramInt;
    }
    
    public void call(final Subscriber<? super Integer> paramSubscriber)
    {
      final Scheduler.Worker localWorker = Schedulers.io().createWorker();
      localWorker.schedule(new Action0()
      {
        /* Error */
        public void call()
        {
          // Byte code:
          //   0: aload_0
          //   1: getfield 26	com/lyft/rx/CountdownTimer$CountdownTimerObservable$1:val$subscriber	Lrx/Subscriber;
          //   4: aload_0
          //   5: getfield 24	com/lyft/rx/CountdownTimer$CountdownTimerObservable$1:this$0	Lcom/lyft/rx/CountdownTimer$CountdownTimerObservable;
          //   8: invokestatic 36	com/lyft/rx/CountdownTimer$CountdownTimerObservable:access$000	(Lcom/lyft/rx/CountdownTimer$CountdownTimerObservable;)I
          //   11: invokestatic 42	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   14: invokevirtual 48	rx/Subscriber:onNext	(Ljava/lang/Object;)V
          //   17: aload_0
          //   18: getfield 24	com/lyft/rx/CountdownTimer$CountdownTimerObservable$1:this$0	Lcom/lyft/rx/CountdownTimer$CountdownTimerObservable;
          //   21: invokestatic 36	com/lyft/rx/CountdownTimer$CountdownTimerObservable:access$000	(Lcom/lyft/rx/CountdownTimer$CountdownTimerObservable;)I
          //   24: ifne +26 -> 50
          //   27: aload_0
          //   28: getfield 26	com/lyft/rx/CountdownTimer$CountdownTimerObservable$1:val$subscriber	Lrx/Subscriber;
          //   31: invokevirtual 51	rx/Subscriber:onCompleted	()V
          //   34: aload_0
          //   35: getfield 28	com/lyft/rx/CountdownTimer$CountdownTimerObservable$1:val$worker	Lrx/Scheduler$Worker;
          //   38: invokevirtual 56	rx/Scheduler$Worker:unsubscribe	()V
          //   41: aload_0
          //   42: getfield 24	com/lyft/rx/CountdownTimer$CountdownTimerObservable$1:this$0	Lcom/lyft/rx/CountdownTimer$CountdownTimerObservable;
          //   45: invokestatic 59	com/lyft/rx/CountdownTimer$CountdownTimerObservable:access$010	(Lcom/lyft/rx/CountdownTimer$CountdownTimerObservable;)I
          //   48: pop
          //   49: return
          //   50: aload_0
          //   51: getfield 28	com/lyft/rx/CountdownTimer$CountdownTimerObservable$1:val$worker	Lrx/Scheduler$Worker;
          //   54: aload_0
          //   55: aload_0
          //   56: getfield 24	com/lyft/rx/CountdownTimer$CountdownTimerObservable$1:this$0	Lcom/lyft/rx/CountdownTimer$CountdownTimerObservable;
          //   59: invokestatic 63	com/lyft/rx/CountdownTimer$CountdownTimerObservable:access$100	(Lcom/lyft/rx/CountdownTimer$CountdownTimerObservable;)J
          //   62: aload_0
          //   63: getfield 24	com/lyft/rx/CountdownTimer$CountdownTimerObservable$1:this$0	Lcom/lyft/rx/CountdownTimer$CountdownTimerObservable;
          //   66: invokestatic 67	com/lyft/rx/CountdownTimer$CountdownTimerObservable:access$200	(Lcom/lyft/rx/CountdownTimer$CountdownTimerObservable;)Ljava/util/concurrent/TimeUnit;
          //   69: invokevirtual 71	rx/Scheduler$Worker:schedule	(Lrx/functions/Action0;JLjava/util/concurrent/TimeUnit;)Lrx/Subscription;
          //   72: pop
          //   73: goto -32 -> 41
          //   76: astore_1
          //   77: aload_0
          //   78: getfield 24	com/lyft/rx/CountdownTimer$CountdownTimerObservable$1:this$0	Lcom/lyft/rx/CountdownTimer$CountdownTimerObservable;
          //   81: invokestatic 36	com/lyft/rx/CountdownTimer$CountdownTimerObservable:access$000	(Lcom/lyft/rx/CountdownTimer$CountdownTimerObservable;)I
          //   84: ifne +27 -> 111
          //   87: aload_0
          //   88: getfield 26	com/lyft/rx/CountdownTimer$CountdownTimerObservable$1:val$subscriber	Lrx/Subscriber;
          //   91: invokevirtual 51	rx/Subscriber:onCompleted	()V
          //   94: aload_0
          //   95: getfield 28	com/lyft/rx/CountdownTimer$CountdownTimerObservable$1:val$worker	Lrx/Scheduler$Worker;
          //   98: invokevirtual 56	rx/Scheduler$Worker:unsubscribe	()V
          //   101: aload_0
          //   102: getfield 24	com/lyft/rx/CountdownTimer$CountdownTimerObservable$1:this$0	Lcom/lyft/rx/CountdownTimer$CountdownTimerObservable;
          //   105: invokestatic 59	com/lyft/rx/CountdownTimer$CountdownTimerObservable:access$010	(Lcom/lyft/rx/CountdownTimer$CountdownTimerObservable;)I
          //   108: pop
          //   109: aload_1
          //   110: athrow
          //   111: aload_0
          //   112: getfield 28	com/lyft/rx/CountdownTimer$CountdownTimerObservable$1:val$worker	Lrx/Scheduler$Worker;
          //   115: aload_0
          //   116: aload_0
          //   117: getfield 24	com/lyft/rx/CountdownTimer$CountdownTimerObservable$1:this$0	Lcom/lyft/rx/CountdownTimer$CountdownTimerObservable;
          //   120: invokestatic 63	com/lyft/rx/CountdownTimer$CountdownTimerObservable:access$100	(Lcom/lyft/rx/CountdownTimer$CountdownTimerObservable;)J
          //   123: aload_0
          //   124: getfield 24	com/lyft/rx/CountdownTimer$CountdownTimerObservable$1:this$0	Lcom/lyft/rx/CountdownTimer$CountdownTimerObservable;
          //   127: invokestatic 67	com/lyft/rx/CountdownTimer$CountdownTimerObservable:access$200	(Lcom/lyft/rx/CountdownTimer$CountdownTimerObservable;)Ljava/util/concurrent/TimeUnit;
          //   130: invokevirtual 71	rx/Scheduler$Worker:schedule	(Lrx/functions/Action0;JLjava/util/concurrent/TimeUnit;)Lrx/Subscription;
          //   133: pop
          //   134: goto -33 -> 101
          // Local variable table:
          //   start	length	slot	name	signature
          //   0	137	0	this	1
          //   76	34	1	localObject	Object
          // Exception table:
          //   from	to	target	type
          //   0	17	76	finally
        }
      });
      paramSubscriber.add(Subscriptions.create(new Action0()
      {
        public void call()
        {
          localWorker.unsubscribe();
        }
      }));
    }
  }
}

/* Location:
 * Qualified Name:     com.lyft.rx.CountdownTimer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */