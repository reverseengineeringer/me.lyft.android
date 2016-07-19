package com.squareup.okhttp.logging;

import com.squareup.okhttp.internal.Platform;

final class HttpLoggingInterceptor$Logger$1
  implements HttpLoggingInterceptor.Logger
{
  public void log(String paramString)
  {
    Platform.get().log(paramString);
  }
}

/* Location:
 * Qualified Name:     com.squareup.okhttp.logging.HttpLoggingInterceptor.Logger.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */