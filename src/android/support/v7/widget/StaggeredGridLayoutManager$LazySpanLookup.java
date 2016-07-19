package android.support.v7.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class StaggeredGridLayoutManager$LazySpanLookup
{
  int[] mData;
  List<FullSpanItem> mFullSpanItems;
  
  private int invalidateFullSpansAfter(int paramInt)
  {
    if (mFullSpanItems == null) {
      return -1;
    }
    FullSpanItem localFullSpanItem = getFullSpanItem(paramInt);
    if (localFullSpanItem != null) {
      mFullSpanItems.remove(localFullSpanItem);
    }
    int k = -1;
    int m = mFullSpanItems.size();
    int i = 0;
    for (;;)
    {
      int j = k;
      if (i < m)
      {
        if (mFullSpanItems.get(i)).mPosition >= paramInt) {
          j = i;
        }
      }
      else
      {
        if (j == -1) {
          break;
        }
        localFullSpanItem = (FullSpanItem)mFullSpanItems.get(j);
        mFullSpanItems.remove(j);
        return mPosition;
      }
      i += 1;
    }
  }
  
  private void offsetFullSpansForAddition(int paramInt1, int paramInt2)
  {
    if (mFullSpanItems == null) {
      return;
    }
    int i = mFullSpanItems.size() - 1;
    label20:
    FullSpanItem localFullSpanItem;
    if (i >= 0)
    {
      localFullSpanItem = (FullSpanItem)mFullSpanItems.get(i);
      if (mPosition >= paramInt1) {
        break label55;
      }
    }
    for (;;)
    {
      i -= 1;
      break label20;
      break;
      label55:
      mPosition += paramInt2;
    }
  }
  
  private void offsetFullSpansForRemoval(int paramInt1, int paramInt2)
  {
    if (mFullSpanItems == null) {
      return;
    }
    int i = mFullSpanItems.size() - 1;
    label20:
    FullSpanItem localFullSpanItem;
    if (i >= 0)
    {
      localFullSpanItem = (FullSpanItem)mFullSpanItems.get(i);
      if (mPosition >= paramInt1) {
        break label55;
      }
    }
    for (;;)
    {
      i -= 1;
      break label20;
      break;
      label55:
      if (mPosition < paramInt1 + paramInt2) {
        mFullSpanItems.remove(i);
      } else {
        mPosition -= paramInt2;
      }
    }
  }
  
  public void addFullSpanItem(FullSpanItem paramFullSpanItem)
  {
    if (mFullSpanItems == null) {
      mFullSpanItems = new ArrayList();
    }
    int j = mFullSpanItems.size();
    int i = 0;
    while (i < j)
    {
      FullSpanItem localFullSpanItem = (FullSpanItem)mFullSpanItems.get(i);
      if (mPosition == mPosition) {
        mFullSpanItems.remove(i);
      }
      if (mPosition >= mPosition)
      {
        mFullSpanItems.add(i, paramFullSpanItem);
        return;
      }
      i += 1;
    }
    mFullSpanItems.add(paramFullSpanItem);
  }
  
  void clear()
  {
    if (mData != null) {
      Arrays.fill(mData, -1);
    }
    mFullSpanItems = null;
  }
  
  void ensureSize(int paramInt)
  {
    if (mData == null)
    {
      mData = new int[Math.max(paramInt, 10) + 1];
      Arrays.fill(mData, -1);
    }
    while (paramInt < mData.length) {
      return;
    }
    int[] arrayOfInt = mData;
    mData = new int[sizeForPosition(paramInt)];
    System.arraycopy(arrayOfInt, 0, mData, 0, arrayOfInt.length);
    Arrays.fill(mData, arrayOfInt.length, mData.length, -1);
  }
  
  int forceInvalidateAfter(int paramInt)
  {
    if (mFullSpanItems != null)
    {
      int i = mFullSpanItems.size() - 1;
      while (i >= 0)
      {
        if (mFullSpanItems.get(i)).mPosition >= paramInt) {
          mFullSpanItems.remove(i);
        }
        i -= 1;
      }
    }
    return invalidateAfter(paramInt);
  }
  
  public FullSpanItem getFirstFullSpanItemInRange(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    Object localObject;
    if (mFullSpanItems == null)
    {
      localObject = null;
      return (FullSpanItem)localObject;
    }
    int j = mFullSpanItems.size();
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label117;
      }
      FullSpanItem localFullSpanItem = (FullSpanItem)mFullSpanItems.get(i);
      if (mPosition >= paramInt2) {
        return null;
      }
      if (mPosition >= paramInt1)
      {
        localObject = localFullSpanItem;
        if (paramInt3 == 0) {
          break;
        }
        localObject = localFullSpanItem;
        if (mGapDir == paramInt3) {
          break;
        }
        if (paramBoolean)
        {
          localObject = localFullSpanItem;
          if (mHasUnwantedGapAfter) {
            break;
          }
        }
      }
      i += 1;
    }
    label117:
    return null;
  }
  
  public FullSpanItem getFullSpanItem(int paramInt)
  {
    Object localObject;
    if (mFullSpanItems == null)
    {
      localObject = null;
      return (FullSpanItem)localObject;
    }
    int i = mFullSpanItems.size() - 1;
    for (;;)
    {
      if (i < 0) {
        break label61;
      }
      FullSpanItem localFullSpanItem = (FullSpanItem)mFullSpanItems.get(i);
      localObject = localFullSpanItem;
      if (mPosition == paramInt) {
        break;
      }
      i -= 1;
    }
    label61:
    return null;
  }
  
  int getSpan(int paramInt)
  {
    if ((mData == null) || (paramInt >= mData.length)) {
      return -1;
    }
    return mData[paramInt];
  }
  
  int invalidateAfter(int paramInt)
  {
    if (mData == null) {}
    while (paramInt >= mData.length) {
      return -1;
    }
    int i = invalidateFullSpansAfter(paramInt);
    if (i == -1)
    {
      Arrays.fill(mData, paramInt, mData.length, -1);
      return mData.length;
    }
    Arrays.fill(mData, paramInt, i + 1, -1);
    return i + 1;
  }
  
  void offsetForAddition(int paramInt1, int paramInt2)
  {
    if ((mData == null) || (paramInt1 >= mData.length)) {
      return;
    }
    ensureSize(paramInt1 + paramInt2);
    System.arraycopy(mData, paramInt1, mData, paramInt1 + paramInt2, mData.length - paramInt1 - paramInt2);
    Arrays.fill(mData, paramInt1, paramInt1 + paramInt2, -1);
    offsetFullSpansForAddition(paramInt1, paramInt2);
  }
  
  void offsetForRemoval(int paramInt1, int paramInt2)
  {
    if ((mData == null) || (paramInt1 >= mData.length)) {
      return;
    }
    ensureSize(paramInt1 + paramInt2);
    System.arraycopy(mData, paramInt1 + paramInt2, mData, paramInt1, mData.length - paramInt1 - paramInt2);
    Arrays.fill(mData, mData.length - paramInt2, mData.length, -1);
    offsetFullSpansForRemoval(paramInt1, paramInt2);
  }
  
  void setSpan(int paramInt, StaggeredGridLayoutManager.Span paramSpan)
  {
    ensureSize(paramInt);
    mData[paramInt] = mIndex;
  }
  
  int sizeForPosition(int paramInt)
  {
    int i = mData.length;
    while (i <= paramInt) {
      i *= 2;
    }
    return i;
  }
  
  static class FullSpanItem
    implements Parcelable
  {
    public static final Parcelable.Creator<FullSpanItem> CREATOR = new Parcelable.Creator()
    {
      public StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem createFromParcel(Parcel paramAnonymousParcel)
      {
        return new StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem(paramAnonymousParcel);
      }
      
      public StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem[] newArray(int paramAnonymousInt)
      {
        return new StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem[paramAnonymousInt];
      }
    };
    int mGapDir;
    int[] mGapPerSpan;
    boolean mHasUnwantedGapAfter;
    int mPosition;
    
    public FullSpanItem() {}
    
    public FullSpanItem(Parcel paramParcel)
    {
      mPosition = paramParcel.readInt();
      mGapDir = paramParcel.readInt();
      if (paramParcel.readInt() == 1) {}
      for (;;)
      {
        mHasUnwantedGapAfter = bool;
        int i = paramParcel.readInt();
        if (i > 0)
        {
          mGapPerSpan = new int[i];
          paramParcel.readIntArray(mGapPerSpan);
        }
        return;
        bool = false;
      }
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    int getGapForSpan(int paramInt)
    {
      if (mGapPerSpan == null) {
        return 0;
      }
      return mGapPerSpan[paramInt];
    }
    
    public String toString()
    {
      return "FullSpanItem{mPosition=" + mPosition + ", mGapDir=" + mGapDir + ", mHasUnwantedGapAfter=" + mHasUnwantedGapAfter + ", mGapPerSpan=" + Arrays.toString(mGapPerSpan) + '}';
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeInt(mPosition);
      paramParcel.writeInt(mGapDir);
      if (mHasUnwantedGapAfter) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        if ((mGapPerSpan == null) || (mGapPerSpan.length <= 0)) {
          break;
        }
        paramParcel.writeInt(mGapPerSpan.length);
        paramParcel.writeIntArray(mGapPerSpan);
        return;
      }
      paramParcel.writeInt(0);
    }
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.StaggeredGridLayoutManager.LazySpanLookup
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */