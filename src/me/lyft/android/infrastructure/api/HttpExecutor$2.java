package me.lyft.android.infrastructure.api;

import com.squareup.okhttp.Request;
import com.squareup.okhttp.Request.Builder;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;
import me.lyft.android.common.Unit;
import rx.Observable.OnSubscribe;
import rx.Subscriber;

class HttpExecutor$2
  implements Observable.OnSubscribe<Unit>
{
  HttpExecutor$2(HttpExecutor paramHttpExecutor, Request.Builder paramBuilder) {}
  
  public void call(Subscriber<? super Unit> paramSubscriber)
  {
    try
    {
      Request localRequest = val$requestBuilder.build();
      HttpExecutor.access$000(this$0, localRequest).body().close();
      paramSubscriber.onNext(Unit.create());
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
 * Qualified Name:     me.lyft.android.infrastructure.api.HttpExecutor.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */