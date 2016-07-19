package com.squareup.picasso;

import java.util.concurrent.FutureTask;

final class PicassoExecutorService$PicassoFutureTask
  extends FutureTask<BitmapHunter>
  implements Comparable<PicassoFutureTask>
{
  private final BitmapHunter hunter;
  
  public PicassoExecutorService$PicassoFutureTask(BitmapHunter paramBitmapHunter)
  {
    super(paramBitmapHunter, null);
    hunter = paramBitmapHunter;
  }
  
  public int compareTo(PicassoFutureTask paramPicassoFutureTask)
  {
    Picasso.Priority localPriority1 = hunter.getPriority();
    Picasso.Priority localPriority2 = hunter.getPriority();
    if (localPriority1 == localPriority2) {
      return hunter.sequence - hunter.sequence;
    }
    return localPriority2.ordinal() - localPriority1.ordinal();
  }
}

/* Location:
 * Qualified Name:     com.squareup.picasso.PicassoExecutorService.PicassoFutureTask
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */