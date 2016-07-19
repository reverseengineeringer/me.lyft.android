package me.lyft.android.infrastructure.api;

import com.squareup.okhttp.Request.Builder;
import java.io.IOException;
import me.lyft.android.common.Unit;
import rx.Observable;

public abstract interface IHttpExecutor
{
  public abstract <T> T execute(Request.Builder paramBuilder, Class<T> paramClass)
    throws IOException;
  
  public abstract <T> Observable<T> executeAsync(Request.Builder paramBuilder, Class<T> paramClass);
  
  public abstract Observable<Unit> executeWithoutResultAsync(Request.Builder paramBuilder);
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.api.IHttpExecutor
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */