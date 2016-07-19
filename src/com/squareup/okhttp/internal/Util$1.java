package com.squareup.okhttp.internal;

import java.util.concurrent.ThreadFactory;

final class Util$1
  implements ThreadFactory
{
  Util$1(String paramString, boolean paramBoolean) {}
  
  public Thread newThread(Runnable paramRunnable)
  {
    paramRunnable = new Thread(paramRunnable, val$name);
    paramRunnable.setDaemon(val$daemon);
    return paramRunnable;
  }
}

/* Location:
 * Qualified Name:     com.squareup.okhttp.internal.Util.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */