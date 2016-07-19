package me.lyft.android.infrastructure.api;

import com.squareup.okhttp.Request;
import com.squareup.okhttp.Request.Builder;
import rx.Observable.OnSubscribe;
import rx.Subscriber;

class HttpExecutor$3
  implements Observable.OnSubscribe<T>
{
  HttpExecutor$3(HttpExecutor paramHttpExecutor, Request.Builder paramBuilder, Class paramClass) {}
  
  public void call(Subscriber<? super T> paramSubscriber)
  {
    try
    {
      Request localRequest = val$requestBuilder.build();
      paramSubscriber.onNext(HttpExecutor.access$100(this$0, localRequest, val$clazz));
      paramSubscriber.onCompleted();
      return;
    }
    catch (Throwable localThrowable)
    {
      paramSubscriber.onError(localThrowable);
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.api.HttpExecutor.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */