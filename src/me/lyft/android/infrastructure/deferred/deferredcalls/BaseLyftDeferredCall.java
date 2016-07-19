package me.lyft.android.infrastructure.deferred.deferredcalls;

import java.io.IOException;
import me.lyft.android.infrastructure.deferred.ICallDependencyFactory;
import me.lyft.android.infrastructure.deferred.IDeferredCall;
import me.lyft.android.infrastructure.lyft.ILyftApi;
import me.lyft.android.infrastructure.lyft.LyftApiException;

abstract class BaseLyftDeferredCall
  implements IDeferredCall
{
  public final void callUsing(ICallDependencyFactory paramICallDependencyFactory)
    throws Exception
  {
    callUsing((ILyftApi)paramICallDependencyFactory.get(ILyftApi.class));
  }
  
  abstract void callUsing(ILyftApi paramILyftApi)
    throws IOException;
  
  public boolean needToRetry(Exception paramException)
  {
    if ((paramException instanceof LyftApiException))
    {
      int i = ((LyftApiException)paramException).getStatusCode();
      return (i == 409) || (i >= 500);
    }
    return paramException instanceof IOException;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.deferred.deferredcalls.BaseLyftDeferredCall
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */