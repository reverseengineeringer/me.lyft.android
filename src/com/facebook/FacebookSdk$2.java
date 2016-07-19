package com.facebook;

import android.content.Context;
import java.io.File;
import java.util.concurrent.Callable;

final class FacebookSdk$2
  implements Callable<File>
{
  public File call()
    throws Exception
  {
    return FacebookSdk.access$000().getCacheDir();
  }
}

/* Location:
 * Qualified Name:     com.facebook.FacebookSdk.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */