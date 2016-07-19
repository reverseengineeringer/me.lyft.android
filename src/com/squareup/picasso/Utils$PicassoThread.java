package com.squareup.picasso;

import android.os.Process;

class Utils$PicassoThread
  extends Thread
{
  public Utils$PicassoThread(Runnable paramRunnable)
  {
    super(paramRunnable);
  }
  
  public void run()
  {
    Process.setThreadPriority(10);
    super.run();
  }
}

/* Location:
 * Qualified Name:     com.squareup.picasso.Utils.PicassoThread
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */