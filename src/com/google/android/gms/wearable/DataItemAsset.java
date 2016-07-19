package com.google.android.gms.wearable;

import com.google.android.gms.common.data.Freezable;

public abstract interface DataItemAsset
  extends Freezable<DataItemAsset>
{
  public abstract String getDataItemKey();
  
  public abstract String getId();
}

/* Location:
 * Qualified Name:     com.google.android.gms.wearable.DataItemAsset
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */