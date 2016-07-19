package rx.internal.operators;

import java.util.Iterator;
import rx.Observable.Operator;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Func2;
import rx.observers.Subscribers;

public final class OperatorZipIterable<T1, T2, R>
  implements Observable.Operator<R, T1>
{
  final Iterable<? extends T2> iterable;
  final Func2<? super T1, ? super T2, ? extends R> zipFunction;
  
  public OperatorZipIterable(Iterable<? extends T2> paramIterable, Func2<? super T1, ? super T2, ? extends R> paramFunc2)
  {
    iterable = paramIterable;
    zipFunction = paramFunc2;
  }
  
  public Subscriber<? super T1> call(Subscriber<? super R> paramSubscriber)
  {
    Object localObject = iterable.iterator();
    try
    {
      if (!((Iterator)localObject).hasNext())
      {
        paramSubscriber.onCompleted();
        localObject = Subscribers.empty();
        return (Subscriber<? super T1>)localObject;
      }
    }
    catch (Throwable localThrowable)
    {
      Exceptions.throwOrReport(localThrowable, paramSubscriber);
      return Subscribers.empty();
    }
    return new OperatorZipIterable.1(this, paramSubscriber, paramSubscriber, localThrowable);
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorZipIterable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */