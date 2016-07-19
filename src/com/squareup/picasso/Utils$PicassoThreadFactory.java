package com.squareup.picasso;

import java.util.concurrent.ThreadFactory;

class Utils$PicassoThreadFactory
  implements ThreadFactory
{
  public Thread newThread(Runnable paramRunnable)
  {
    return new Utils.PicassoThread(paramRunnable);
  }
}

/* Location:
 * Qualified Name:     com.squareup.picasso.Utils.PicassoThreadFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */