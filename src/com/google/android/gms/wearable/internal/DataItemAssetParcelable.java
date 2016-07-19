package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.wearable.DataItemAsset;

@KeepName
public class DataItemAssetParcelable
  extends AbstractSafeParcelable
  implements DataItemAsset
{
  public static final Parcelable.Creator<DataItemAssetParcelable> CREATOR = new zzab();
  final int mVersionCode;
  private final String zzaxn;
  private final String zzbgk;
  
  DataItemAssetParcelable(int paramInt, String paramString1, String paramString2)
  {
    mVersionCode = paramInt;
    zzbgk = paramString1;
    zzaxn = paramString2;
  }
  
  public DataItemAssetParcelable(DataItemAsset paramDataItemAsset)
  {
    mVersionCode = 1;
    zzbgk = ((String)com.google.android.gms.common.internal.zzab.zzaa(paramDataItemAsset.getId()));
    zzaxn = ((String)com.google.android.gms.common.internal.zzab.zzaa(paramDataItemAsset.getDataItemKey()));
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
    localStringBuilder.append("DataItemAssetParcelable[");
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
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzab.zza(this, paramParcel, paramInt);
  }
  
  public DataItemAsset zzcja()
  {
    return this;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wearable.internal.DataItemAssetParcelable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */