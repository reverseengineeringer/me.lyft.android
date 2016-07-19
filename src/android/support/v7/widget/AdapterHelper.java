package android.support.v7.widget;

import android.support.v4.util.Pools.Pool;
import android.support.v4.util.Pools.SimplePool;
import java.util.ArrayList;
import java.util.List;

class AdapterHelper
  implements OpReorderer.Callback
{
  final Callback mCallback;
  final boolean mDisableRecycler;
  private int mExistingUpdateTypes = 0;
  Runnable mOnItemProcessedCallback;
  final OpReorderer mOpReorderer;
  final ArrayList<UpdateOp> mPendingUpdates = new ArrayList();
  final ArrayList<UpdateOp> mPostponedList = new ArrayList();
  private Pools.Pool<UpdateOp> mUpdateOpPool = new Pools.SimplePool(30);
  
  AdapterHelper(Callback paramCallback)
  {
    this(paramCallback, false);
  }
  
  AdapterHelper(Callback paramCallback, boolean paramBoolean)
  {
    mCallback = paramCallback;
    mDisableRecycler = paramBoolean;
    mOpReorderer = new OpReorderer(this);
  }
  
  private void applyAdd(UpdateOp paramUpdateOp)
  {
    postponeAndUpdateViewHolders(paramUpdateOp);
  }
  
  private void applyMove(UpdateOp paramUpdateOp)
  {
    postponeAndUpdateViewHolders(paramUpdateOp);
  }
  
  private void applyRemove(UpdateOp paramUpdateOp)
  {
    int i2 = positionStart;
    int n = 0;
    int m = positionStart + itemCount;
    int i1 = -1;
    int i = positionStart;
    if (i < m)
    {
      int k = 0;
      int j = 0;
      if ((mCallback.findViewHolder(i) != null) || (canFindInPreLayout(i)))
      {
        if (i1 == 0)
        {
          dispatchAndUpdateViewHolders(obtainUpdateOp(2, i2, n, null));
          j = 1;
        }
        i1 = 1;
        k = j;
        j = i1;
        label90:
        if (k == 0) {
          break label152;
        }
        i -= n;
        m -= n;
      }
      label152:
      for (k = 1;; k = n + 1)
      {
        i += 1;
        n = k;
        i1 = j;
        break;
        if (i1 == 1)
        {
          postponeAndUpdateViewHolders(obtainUpdateOp(2, i2, n, null));
          k = 1;
        }
        j = 0;
        break label90;
      }
    }
    UpdateOp localUpdateOp = paramUpdateOp;
    if (n != itemCount)
    {
      recycleUpdateOp(paramUpdateOp);
      localUpdateOp = obtainUpdateOp(2, i2, n, null);
    }
    if (i1 == 0)
    {
      dispatchAndUpdateViewHolders(localUpdateOp);
      return;
    }
    postponeAndUpdateViewHolders(localUpdateOp);
  }
  
  private void applyUpdate(UpdateOp paramUpdateOp)
  {
    int k = positionStart;
    int j = 0;
    int i3 = positionStart;
    int i4 = itemCount;
    int i2 = -1;
    int i = positionStart;
    if (i < i3 + i4)
    {
      int n;
      int m;
      if ((mCallback.findViewHolder(i) != null) || (canFindInPreLayout(i)))
      {
        n = j;
        int i1 = k;
        if (i2 == 0)
        {
          dispatchAndUpdateViewHolders(obtainUpdateOp(4, k, j, payload));
          n = 0;
          i1 = i;
        }
        m = 1;
        k = i1;
      }
      for (;;)
      {
        j = n + 1;
        i += 1;
        i2 = m;
        break;
        n = j;
        m = k;
        if (i2 == 1)
        {
          postponeAndUpdateViewHolders(obtainUpdateOp(4, k, j, payload));
          n = 0;
          m = i;
        }
        j = 0;
        k = m;
        m = j;
      }
    }
    Object localObject = paramUpdateOp;
    if (j != itemCount)
    {
      localObject = payload;
      recycleUpdateOp(paramUpdateOp);
      localObject = obtainUpdateOp(4, k, j, localObject);
    }
    if (i2 == 0)
    {
      dispatchAndUpdateViewHolders((UpdateOp)localObject);
      return;
    }
    postponeAndUpdateViewHolders((UpdateOp)localObject);
  }
  
  private boolean canFindInPreLayout(int paramInt)
  {
    int k = mPostponedList.size();
    int i = 0;
    while (i < k)
    {
      UpdateOp localUpdateOp = (UpdateOp)mPostponedList.get(i);
      if (cmd == 8)
      {
        if (findPositionOffset(itemCount, i + 1) == paramInt) {
          return true;
        }
      }
      else if (cmd == 1)
      {
        int m = positionStart;
        int n = itemCount;
        int j = positionStart;
        for (;;)
        {
          if (j >= m + n) {
            break label115;
          }
          if (findPositionOffset(j, i + 1) == paramInt) {
            break;
          }
          j += 1;
        }
      }
      label115:
      i += 1;
    }
    return false;
  }
  
  private void dispatchAndUpdateViewHolders(UpdateOp paramUpdateOp)
  {
    if ((cmd == 1) || (cmd == 8)) {
      throw new IllegalArgumentException("should not dispatch add or move for pre layout");
    }
    int i1 = updatePositionWithPostponed(positionStart, cmd);
    int n = 1;
    int i = positionStart;
    int k;
    int m;
    label113:
    int i2;
    switch (cmd)
    {
    case 3: 
    default: 
      throw new IllegalArgumentException("op should be remove or update." + paramUpdateOp);
    case 4: 
      k = 1;
      m = 1;
      if (m >= itemCount) {
        break label307;
      }
      i2 = updatePositionWithPostponed(positionStart + k * m, cmd);
      int i3 = 0;
      j = i3;
      switch (cmd)
      {
      default: 
        j = i3;
      case 3: 
        if (j == 0) {}
        break;
      }
      break;
    }
    for (int j = n + 1;; j = n)
    {
      m += 1;
      n = j;
      break label113;
      k = 0;
      break;
      if (i2 == i1 + 1) {}
      for (j = 1;; j = 0) {
        break;
      }
      if (i2 == i1) {}
      for (j = 1;; j = 0) {
        break;
      }
      localObject = obtainUpdateOp(cmd, i1, n, payload);
      dispatchFirstPassAndUpdateViewHolders((UpdateOp)localObject, i);
      recycleUpdateOp((UpdateOp)localObject);
      j = i;
      if (cmd == 4) {
        j = i + n;
      }
      i1 = i2;
      n = 1;
      i = j;
    }
    label307:
    Object localObject = payload;
    recycleUpdateOp(paramUpdateOp);
    if (n > 0)
    {
      paramUpdateOp = obtainUpdateOp(cmd, i1, n, localObject);
      dispatchFirstPassAndUpdateViewHolders(paramUpdateOp, i);
      recycleUpdateOp(paramUpdateOp);
    }
  }
  
  private void postponeAndUpdateViewHolders(UpdateOp paramUpdateOp)
  {
    mPostponedList.add(paramUpdateOp);
    switch (cmd)
    {
    case 3: 
    case 5: 
    case 6: 
    case 7: 
    default: 
      throw new IllegalArgumentException("Unknown update op type for " + paramUpdateOp);
    case 1: 
      mCallback.offsetPositionsForAdd(positionStart, itemCount);
      return;
    case 8: 
      mCallback.offsetPositionsForMove(positionStart, itemCount);
      return;
    case 2: 
      mCallback.offsetPositionsForRemovingLaidOutOrNewView(positionStart, itemCount);
      return;
    }
    mCallback.markViewHoldersUpdated(positionStart, itemCount, payload);
  }
  
  private int updatePositionWithPostponed(int paramInt1, int paramInt2)
  {
    int i = mPostponedList.size() - 1;
    int j = paramInt1;
    UpdateOp localUpdateOp;
    if (i >= 0)
    {
      localUpdateOp = (UpdateOp)mPostponedList.get(i);
      int k;
      if (cmd == 8) {
        if (positionStart < itemCount)
        {
          k = positionStart;
          paramInt1 = itemCount;
          label66:
          if ((j < k) || (j > paramInt1)) {
            break label202;
          }
          if (k != positionStart) {
            break label157;
          }
          if (paramInt2 != 1) {
            break label137;
          }
          itemCount += 1;
          label106:
          paramInt1 = j + 1;
        }
      }
      for (;;)
      {
        i -= 1;
        j = paramInt1;
        break;
        k = itemCount;
        paramInt1 = positionStart;
        break label66;
        label137:
        if (paramInt2 != 2) {
          break label106;
        }
        itemCount -= 1;
        break label106;
        label157:
        if (paramInt2 == 1) {
          positionStart += 1;
        }
        for (;;)
        {
          paramInt1 = j - 1;
          break;
          if (paramInt2 == 2) {
            positionStart -= 1;
          }
        }
        label202:
        paramInt1 = j;
        if (j < positionStart) {
          if (paramInt2 == 1)
          {
            positionStart += 1;
            itemCount += 1;
            paramInt1 = j;
          }
          else
          {
            paramInt1 = j;
            if (paramInt2 == 2)
            {
              positionStart -= 1;
              itemCount -= 1;
              paramInt1 = j;
              continue;
              if (positionStart <= j)
              {
                if (cmd == 1)
                {
                  paramInt1 = j - itemCount;
                }
                else
                {
                  paramInt1 = j;
                  if (cmd == 2) {
                    paramInt1 = j + itemCount;
                  }
                }
              }
              else if (paramInt2 == 1)
              {
                positionStart += 1;
                paramInt1 = j;
              }
              else
              {
                paramInt1 = j;
                if (paramInt2 == 2)
                {
                  positionStart -= 1;
                  paramInt1 = j;
                }
              }
            }
          }
        }
      }
    }
    paramInt1 = mPostponedList.size() - 1;
    if (paramInt1 >= 0)
    {
      localUpdateOp = (UpdateOp)mPostponedList.get(paramInt1);
      if (cmd == 8) {
        if ((itemCount == positionStart) || (itemCount < 0))
        {
          mPostponedList.remove(paramInt1);
          recycleUpdateOp(localUpdateOp);
        }
      }
      for (;;)
      {
        paramInt1 -= 1;
        break;
        if (itemCount <= 0)
        {
          mPostponedList.remove(paramInt1);
          recycleUpdateOp(localUpdateOp);
        }
      }
    }
    return j;
  }
  
  public int applyPendingUpdatesToPosition(int paramInt)
  {
    int m = mPendingUpdates.size();
    int k = 0;
    int i = paramInt;
    paramInt = i;
    UpdateOp localUpdateOp;
    if (k < m)
    {
      localUpdateOp = (UpdateOp)mPendingUpdates.get(k);
      switch (cmd)
      {
      default: 
        paramInt = i;
      }
    }
    for (;;)
    {
      k += 1;
      i = paramInt;
      break;
      paramInt = i;
      if (positionStart <= i)
      {
        paramInt = i + itemCount;
        continue;
        paramInt = i;
        if (positionStart <= i)
        {
          if (positionStart + itemCount > i)
          {
            paramInt = -1;
            return paramInt;
          }
          paramInt = i - itemCount;
          continue;
          if (positionStart == i)
          {
            paramInt = itemCount;
          }
          else
          {
            int j = i;
            if (positionStart < i) {
              j = i - 1;
            }
            paramInt = j;
            if (itemCount <= j) {
              paramInt = j + 1;
            }
          }
        }
      }
    }
  }
  
  void consumePostponedUpdates()
  {
    int j = mPostponedList.size();
    int i = 0;
    while (i < j)
    {
      mCallback.onDispatchSecondPass((UpdateOp)mPostponedList.get(i));
      i += 1;
    }
    recycleUpdateOpsAndClearList(mPostponedList);
    mExistingUpdateTypes = 0;
  }
  
  void consumeUpdatesInOnePass()
  {
    consumePostponedUpdates();
    int j = mPendingUpdates.size();
    int i = 0;
    if (i < j)
    {
      UpdateOp localUpdateOp = (UpdateOp)mPendingUpdates.get(i);
      switch (cmd)
      {
      }
      for (;;)
      {
        if (mOnItemProcessedCallback != null) {
          mOnItemProcessedCallback.run();
        }
        i += 1;
        break;
        mCallback.onDispatchSecondPass(localUpdateOp);
        mCallback.offsetPositionsForAdd(positionStart, itemCount);
        continue;
        mCallback.onDispatchSecondPass(localUpdateOp);
        mCallback.offsetPositionsForRemovingInvisible(positionStart, itemCount);
        continue;
        mCallback.onDispatchSecondPass(localUpdateOp);
        mCallback.markViewHoldersUpdated(positionStart, itemCount, payload);
        continue;
        mCallback.onDispatchSecondPass(localUpdateOp);
        mCallback.offsetPositionsForMove(positionStart, itemCount);
      }
    }
    recycleUpdateOpsAndClearList(mPendingUpdates);
    mExistingUpdateTypes = 0;
  }
  
  void dispatchFirstPassAndUpdateViewHolders(UpdateOp paramUpdateOp, int paramInt)
  {
    mCallback.onDispatchFirstPass(paramUpdateOp);
    switch (cmd)
    {
    case 3: 
    default: 
      throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
    case 2: 
      mCallback.offsetPositionsForRemovingInvisible(paramInt, itemCount);
      return;
    }
    mCallback.markViewHoldersUpdated(paramInt, itemCount, payload);
  }
  
  int findPositionOffset(int paramInt)
  {
    return findPositionOffset(paramInt, 0);
  }
  
  int findPositionOffset(int paramInt1, int paramInt2)
  {
    int k = mPostponedList.size();
    int j = paramInt2;
    paramInt2 = paramInt1;
    paramInt1 = paramInt2;
    UpdateOp localUpdateOp;
    if (j < k)
    {
      localUpdateOp = (UpdateOp)mPostponedList.get(j);
      if (cmd == 8) {
        if (positionStart == paramInt2) {
          paramInt1 = itemCount;
        }
      }
    }
    for (;;)
    {
      j += 1;
      paramInt2 = paramInt1;
      break;
      int i = paramInt2;
      if (positionStart < paramInt2) {
        i = paramInt2 - 1;
      }
      paramInt1 = i;
      if (itemCount <= i)
      {
        paramInt1 = i + 1;
        continue;
        paramInt1 = paramInt2;
        if (positionStart <= paramInt2) {
          if (cmd == 2)
          {
            if (paramInt2 < positionStart + itemCount)
            {
              paramInt1 = -1;
              return paramInt1;
            }
            paramInt1 = paramInt2 - itemCount;
          }
          else
          {
            paramInt1 = paramInt2;
            if (cmd == 1) {
              paramInt1 = paramInt2 + itemCount;
            }
          }
        }
      }
    }
  }
  
  boolean hasAnyUpdateTypes(int paramInt)
  {
    return (mExistingUpdateTypes & paramInt) != 0;
  }
  
  boolean hasPendingUpdates()
  {
    return mPendingUpdates.size() > 0;
  }
  
  boolean hasUpdates()
  {
    return (!mPostponedList.isEmpty()) && (!mPendingUpdates.isEmpty());
  }
  
  public UpdateOp obtainUpdateOp(int paramInt1, int paramInt2, int paramInt3, Object paramObject)
  {
    UpdateOp localUpdateOp = (UpdateOp)mUpdateOpPool.acquire();
    if (localUpdateOp == null) {
      return new UpdateOp(paramInt1, paramInt2, paramInt3, paramObject);
    }
    cmd = paramInt1;
    positionStart = paramInt2;
    itemCount = paramInt3;
    payload = paramObject;
    return localUpdateOp;
  }
  
  boolean onItemRangeChanged(int paramInt1, int paramInt2, Object paramObject)
  {
    mPendingUpdates.add(obtainUpdateOp(4, paramInt1, paramInt2, paramObject));
    mExistingUpdateTypes |= 0x4;
    return mPendingUpdates.size() == 1;
  }
  
  boolean onItemRangeInserted(int paramInt1, int paramInt2)
  {
    mPendingUpdates.add(obtainUpdateOp(1, paramInt1, paramInt2, null));
    mExistingUpdateTypes |= 0x1;
    return mPendingUpdates.size() == 1;
  }
  
  boolean onItemRangeMoved(int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool = true;
    if (paramInt1 == paramInt2) {
      return false;
    }
    if (paramInt3 != 1) {
      throw new IllegalArgumentException("Moving more than 1 item is not supported yet");
    }
    mPendingUpdates.add(obtainUpdateOp(8, paramInt1, paramInt2, null));
    mExistingUpdateTypes |= 0x8;
    if (mPendingUpdates.size() == 1) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  boolean onItemRangeRemoved(int paramInt1, int paramInt2)
  {
    mPendingUpdates.add(obtainUpdateOp(2, paramInt1, paramInt2, null));
    mExistingUpdateTypes |= 0x2;
    return mPendingUpdates.size() == 1;
  }
  
  void preProcess()
  {
    mOpReorderer.reorderOps(mPendingUpdates);
    int j = mPendingUpdates.size();
    int i = 0;
    if (i < j)
    {
      UpdateOp localUpdateOp = (UpdateOp)mPendingUpdates.get(i);
      switch (cmd)
      {
      }
      for (;;)
      {
        if (mOnItemProcessedCallback != null) {
          mOnItemProcessedCallback.run();
        }
        i += 1;
        break;
        applyAdd(localUpdateOp);
        continue;
        applyRemove(localUpdateOp);
        continue;
        applyUpdate(localUpdateOp);
        continue;
        applyMove(localUpdateOp);
      }
    }
    mPendingUpdates.clear();
  }
  
  public void recycleUpdateOp(UpdateOp paramUpdateOp)
  {
    if (!mDisableRecycler)
    {
      payload = null;
      mUpdateOpPool.release(paramUpdateOp);
    }
  }
  
  void recycleUpdateOpsAndClearList(List<UpdateOp> paramList)
  {
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      recycleUpdateOp((UpdateOp)paramList.get(i));
      i += 1;
    }
    paramList.clear();
  }
  
  void reset()
  {
    recycleUpdateOpsAndClearList(mPendingUpdates);
    recycleUpdateOpsAndClearList(mPostponedList);
    mExistingUpdateTypes = 0;
  }
  
  static abstract interface Callback
  {
    public abstract RecyclerView.ViewHolder findViewHolder(int paramInt);
    
    public abstract void markViewHoldersUpdated(int paramInt1, int paramInt2, Object paramObject);
    
    public abstract void offsetPositionsForAdd(int paramInt1, int paramInt2);
    
    public abstract void offsetPositionsForMove(int paramInt1, int paramInt2);
    
    public abstract void offsetPositionsForRemovingInvisible(int paramInt1, int paramInt2);
    
    public abstract void offsetPositionsForRemovingLaidOutOrNewView(int paramInt1, int paramInt2);
    
    public abstract void onDispatchFirstPass(AdapterHelper.UpdateOp paramUpdateOp);
    
    public abstract void onDispatchSecondPass(AdapterHelper.UpdateOp paramUpdateOp);
  }
  
  static class UpdateOp
  {
    int cmd;
    int itemCount;
    Object payload;
    int positionStart;
    
    UpdateOp(int paramInt1, int paramInt2, int paramInt3, Object paramObject)
    {
      cmd = paramInt1;
      positionStart = paramInt2;
      itemCount = paramInt3;
      payload = paramObject;
    }
    
    String cmdToString()
    {
      switch (cmd)
      {
      case 3: 
      case 5: 
      case 6: 
      case 7: 
      default: 
        return "??";
      case 1: 
        return "add";
      case 2: 
        return "rm";
      case 4: 
        return "up";
      }
      return "mv";
    }
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        do
        {
          do
          {
            return true;
            if ((paramObject == null) || (getClass() != paramObject.getClass())) {
              return false;
            }
            paramObject = (UpdateOp)paramObject;
            if (cmd != cmd) {
              return false;
            }
          } while ((cmd == 8) && (Math.abs(itemCount - positionStart) == 1) && (itemCount == positionStart) && (positionStart == itemCount));
          if (itemCount != itemCount) {
            return false;
          }
          if (positionStart != positionStart) {
            return false;
          }
          if (payload == null) {
            break;
          }
        } while (payload.equals(payload));
        return false;
      } while (payload == null);
      return false;
    }
    
    public int hashCode()
    {
      return (cmd * 31 + positionStart) * 31 + itemCount;
    }
    
    public String toString()
    {
      return Integer.toHexString(System.identityHashCode(this)) + "[" + cmdToString() + ",s:" + positionStart + "c:" + itemCount + ",p:" + payload + "]";
    }
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.AdapterHelper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */