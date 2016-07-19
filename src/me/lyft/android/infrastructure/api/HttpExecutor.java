package me.lyft.android.infrastructure.api;

import com.google.gson.JsonSyntaxException;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Request.Builder;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;
import java.io.IOException;
import java.net.URL;
import me.lyft.android.common.Unit;
import me.lyft.android.logging.L;
import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.Subscriber;
import rx.schedulers.Schedulers;

public final class HttpExecutor
  implements IHttpExecutor
{
  private final IApiErrorHandler errorHandler;
  private final IJsonBodySerializer jsonBodySerializer;
  protected final OkHttpClient okHttpClient;
  
  public HttpExecutor(OkHttpClient paramOkHttpClient, IJsonBodySerializer paramIJsonBodySerializer)
  {
    this(paramOkHttpClient, paramIJsonBodySerializer, new IApiErrorHandler()
    {
      public void handleUnsuccessfulResponse(Response paramAnonymousResponse)
        throws IOException
      {}
    });
  }
  
  public HttpExecutor(OkHttpClient paramOkHttpClient, IJsonBodySerializer paramIJsonBodySerializer, IApiErrorHandler paramIApiErrorHandler)
  {
    okHttpClient = paramOkHttpClient;
    errorHandler = paramIApiErrorHandler;
    jsonBodySerializer = paramIJsonBodySerializer;
  }
  
  private Response createAnExecuteCall(Request paramRequest)
    throws IOException
  {
    paramRequest = okHttpClient.newCall(paramRequest).execute();
    if (!paramRequest.isSuccessful()) {
      errorHandler.handleUnsuccessfulResponse(paramRequest);
    }
    return paramRequest;
  }
  
  private <T> T createAnExecuteCall(Request paramRequest, Class<T> paramClass)
    throws IOException
  {
    try
    {
      localObject = createAnExecuteCall(paramRequest);
      paramClass = jsonBodySerializer.deserialize((Response)localObject, paramClass);
      return paramClass;
    }
    catch (JsonSyntaxException paramClass)
    {
      Object localObject = paramClass.getCause();
      if ((localObject instanceof IOException)) {
        throw ((IOException)localObject);
      }
      L.e(paramClass, String.format("JsonSyntaxException occurred with deserializing response from : [%s %s]. Message [%s].", new Object[] { paramRequest.method(), paramRequest.url().getPath(), paramClass.getMessage() }), new Object[0]);
      throw paramClass;
    }
  }
  
  public <T> T execute(Request.Builder paramBuilder, Class<T> paramClass)
    throws IOException
  {
    return (T)createAnExecuteCall(paramBuilder.build(), paramClass);
  }
  
  public <T> Observable<T> executeAsync(final Request.Builder paramBuilder, final Class<T> paramClass)
  {
    Observable.create(new Observable.OnSubscribe()
    {
      public void call(Subscriber<? super T> paramAnonymousSubscriber)
      {
        try
        {
          Request localRequest = paramBuilder.build();
          paramAnonymousSubscriber.onNext(HttpExecutor.this.createAnExecuteCall(localRequest, paramClass));
          paramAnonymousSubscriber.onCompleted();
          return;
        }
        catch (Throwable localThrowable)
        {
          paramAnonymousSubscriber.onError(localThrowable);
        }
      }
    }).subscribeOn(Schedulers.io());
  }
  
  public Observable<Unit> executeWithoutResultAsync(final Request.Builder paramBuilder)
  {
    Observable.create(new Observable.OnSubscribe()
    {
      public void call(Subscriber<? super Unit> paramAnonymousSubscriber)
      {
        try
        {
          Request localRequest = paramBuilder.build();
          HttpExecutor.this.createAnExecuteCall(localRequest).body().close();
          paramAnonymousSubscriber.onNext(Unit.create());
          paramAnonymousSubscriber.onCompleted();
          return;
        }
        catch (Throwable localThrowable)
        {
          paramAnonymousSubscriber.onError(localThrowable);
        }
      }
    }).subscribeOn(Schedulers.io());
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.api.HttpExecutor
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */