package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.wearable.DataItemAsset;

public class zzac
  extends zzc
  implements DataItemAsset
{
  public zzac(DataHolder paramDataHolder, int paramInt)
  {
    super(paramDataHolder, paramInt);
  }
  
  public String getDataItemKey()
  {
    return getString("asset_key");
  }
  
  public String getId()
  {
    return getString("asset_id");
  }
  
  public DataItemAsset zzcja()
  {
    return new zzaa(this);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wearable.internal.zzac
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */