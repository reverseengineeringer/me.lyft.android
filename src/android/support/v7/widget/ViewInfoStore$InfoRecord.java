package android.support.v7.widget;

import android.support.v4.util.Pools.Pool;
import android.support.v4.util.Pools.SimplePool;

class ViewInfoStore$InfoRecord
{
  static Pools.Pool<InfoRecord> sPool = new Pools.SimplePool(20);
  int flags;
  RecyclerView.ItemAnimator.ItemHolderInfo postInfo;
  RecyclerView.ItemAnimator.ItemHolderInfo preInfo;
  
  static void drainCache()
  {
    while (sPool.acquire() != null) {}
  }
  
  static InfoRecord obtain()
  {
    InfoRecord localInfoRecord2 = (InfoRecord)sPool.acquire();
    InfoRecord localInfoRecord1 = localInfoRecord2;
    if (localInfoRecord2 == null) {
      localInfoRecord1 = new InfoRecord();
    }
    return localInfoRecord1;
  }
  
  static void recycle(InfoRecord paramInfoRecord)
  {
    flags = 0;
    preInfo = null;
    postInfo = null;
    sPool.release(paramInfoRecord);
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.ViewInfoStore.InfoRecord
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */