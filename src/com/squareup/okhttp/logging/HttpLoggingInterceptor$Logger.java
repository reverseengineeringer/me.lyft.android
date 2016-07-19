package com.squareup.okhttp.logging;

import com.squareup.okhttp.internal.Platform;

public abstract interface HttpLoggingInterceptor$Logger
{
  public static final Logger DEFAULT = new Logger()
  {
    public void log(String paramAnonymousString)
    {
      Platform.get().log(paramAnonymousString);
    }
  };
  
  public abstract void log(String paramString);
}

/* Location:
 * Qualified Name:     com.squareup.okhttp.logging.HttpLoggingInterceptor.Logger
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */