package com.google.android.gms.wearable;

import android.net.Uri;
import com.google.android.gms.common.data.Freezable;
import java.util.Map;

public abstract interface DataItem
  extends Freezable<DataItem>
{
  public abstract Map<String, DataItemAsset> getAssets();
  
  public abstract byte[] getData();
  
  public abstract Uri getUri();
}

/* Location:
 * Qualified Name:     com.google.android.gms.wearable.DataItem
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */