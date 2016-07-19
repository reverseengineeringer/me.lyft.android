package me.lyft.android.infrastructure.api;

import com.squareup.okhttp.Response;
import java.io.IOException;

public abstract interface IApiErrorHandler
{
  public abstract void handleUnsuccessfulResponse(Response paramResponse)
    throws IOException;
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.api.IApiErrorHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */