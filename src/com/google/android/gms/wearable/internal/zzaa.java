package com.google.android.gms.wearable.internal;

import com.google.android.gms.wearable.DataItemAsset;

public class zzaa
  implements DataItemAsset
{
  private final String zzaxn;
  private final String zzbgk;
  
  public zzaa(DataItemAsset paramDataItemAsset)
  {
    zzbgk = paramDataItemAsset.getId();
    zzaxn = paramDataItemAsset.getDataItemKey();
  }
  
  public String getDataItemKey()
  {
    return zzaxn;
  }
  
  public String getId()
  {
    return zzbgk;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DataItemAssetEntity[");
    localStringBuilder.append("@");
    localStringBuilder.append(Integer.toHexString(hashCode()));
    if (zzbgk == null) {
      localStringBuilder.append(",noid");
    }
    for (;;)
    {
      localStringBuilder.append(", key=");
      localStringBuilder.append(zzaxn);
      localStringBuilder.append("]");
      return localStringBuilder.toString();
      localStringBuilder.append(",");
      localStringBuilder.append(zzbgk);
    }
  }
  
  public DataItemAsset zzcja()
  {
    return this;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wearable.internal.zzaa
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */