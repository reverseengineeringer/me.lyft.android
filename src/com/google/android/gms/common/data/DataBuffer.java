package com.google.android.gms.common.data;

import com.google.android.gms.common.api.Releasable;

public abstract interface DataBuffer<T>
  extends Releasable, Iterable<T>
{
  public abstract T get(int paramInt);
  
  public abstract int getCount();
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.data.DataBuffer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */