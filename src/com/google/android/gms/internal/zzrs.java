package com.google.android.gms.internal;

import android.os.Process;

class zzrs
  implements Runnable
{
  private final int mPriority;
  private final Runnable zzw;
  
  public zzrs(Runnable paramRunnable, int paramInt)
  {
    zzw = paramRunnable;
    mPriority = paramInt;
  }
  
  public void run()
  {
    Process.setThreadPriority(mPriority);
    zzw.run();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzrs
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */