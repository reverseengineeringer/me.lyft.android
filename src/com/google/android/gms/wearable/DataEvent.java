package com.google.android.gms.wearable;

import com.google.android.gms.common.data.Freezable;

public abstract interface DataEvent
  extends Freezable<DataEvent>
{
  public abstract DataItem getDataItem();
  
  public abstract int getType();
}

/* Location:
 * Qualified Name:     com.google.android.gms.wearable.DataEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */