package rx.internal.operators;

import rx.Observable;
import rx.Observable.Operator;
import rx.Scheduler;
import rx.Scheduler.Worker;
import rx.Subscriber;
import rx.functions.Func2;
import rx.internal.producers.ProducerArbiter;
import rx.schedulers.Schedulers;
import rx.subscriptions.SerialSubscription;

public final class OperatorRetryWithPredicate<T>
  implements Observable.Operator<T, Observable<T>>
{
  final Func2<Integer, Throwable, Boolean> predicate;
  
  public OperatorRetryWithPredicate(Func2<Integer, Throwable, Boolean> paramFunc2)
  {
    predicate = paramFunc2;
  }
  
  public Subscriber<? super Observable<T>> call(Subscriber<? super T> paramSubscriber)
  {
    Scheduler.Worker localWorker = Schedulers.trampoline().createWorker();
    paramSubscriber.add(localWorker);
    SerialSubscription localSerialSubscription = new SerialSubscription();
    paramSubscriber.add(localSerialSubscription);
    ProducerArbiter localProducerArbiter = new ProducerArbiter();
    paramSubscriber.setProducer(localProducerArbiter);
    return new OperatorRetryWithPredicate.SourceSubscriber(paramSubscriber, predicate, localWorker, localSerialSubscription, localProducerArbiter);
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorRetryWithPredicate
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */