package com.lyft.rx;

import rx.Scheduler.Worker;
import rx.functions.Action0;

class CountdownTimer$CountdownTimerObservable$2
  implements Action0
{
  CountdownTimer$CountdownTimerObservable$2(CountdownTimer.CountdownTimerObservable paramCountdownTimerObservable, Scheduler.Worker paramWorker) {}
  
  public void call()
  {
    val$worker.unsubscribe();
  }
}

/* Location:
 * Qualified Name:     com.lyft.rx.CountdownTimer.CountdownTimerObservable.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */