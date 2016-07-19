package android.support.v7.widget;

import android.util.SparseArray;
import android.util.SparseIntArray;
import java.util.ArrayList;

public class RecyclerView$RecycledViewPool
{
  private int mAttachCount = 0;
  private SparseIntArray mMaxScrap = new SparseIntArray();
  private SparseArray<ArrayList<RecyclerView.ViewHolder>> mScrap = new SparseArray();
  
  private ArrayList<RecyclerView.ViewHolder> getScrapHeapForType(int paramInt)
  {
    ArrayList localArrayList2 = (ArrayList)mScrap.get(paramInt);
    ArrayList localArrayList1 = localArrayList2;
    if (localArrayList2 == null)
    {
      localArrayList2 = new ArrayList();
      mScrap.put(paramInt, localArrayList2);
      localArrayList1 = localArrayList2;
      if (mMaxScrap.indexOfKey(paramInt) < 0)
      {
        mMaxScrap.put(paramInt, 5);
        localArrayList1 = localArrayList2;
      }
    }
    return localArrayList1;
  }
  
  void attach(RecyclerView.Adapter paramAdapter)
  {
    mAttachCount += 1;
  }
  
  public void clear()
  {
    mScrap.clear();
  }
  
  void detach()
  {
    mAttachCount -= 1;
  }
  
  public RecyclerView.ViewHolder getRecycledView(int paramInt)
  {
    ArrayList localArrayList = (ArrayList)mScrap.get(paramInt);
    if ((localArrayList != null) && (!localArrayList.isEmpty()))
    {
      paramInt = localArrayList.size() - 1;
      RecyclerView.ViewHolder localViewHolder = (RecyclerView.ViewHolder)localArrayList.get(paramInt);
      localArrayList.remove(paramInt);
      return localViewHolder;
    }
    return null;
  }
  
  void onAdapterChanged(RecyclerView.Adapter paramAdapter1, RecyclerView.Adapter paramAdapter2, boolean paramBoolean)
  {
    if (paramAdapter1 != null) {
      detach();
    }
    if ((!paramBoolean) && (mAttachCount == 0)) {
      clear();
    }
    if (paramAdapter2 != null) {
      attach(paramAdapter2);
    }
  }
  
  public void putRecycledView(RecyclerView.ViewHolder paramViewHolder)
  {
    int i = paramViewHolder.getItemViewType();
    ArrayList localArrayList = getScrapHeapForType(i);
    if (mMaxScrap.get(i) <= localArrayList.size()) {
      return;
    }
    paramViewHolder.resetInternal();
    localArrayList.add(paramViewHolder);
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.RecyclerView.RecycledViewPool
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */