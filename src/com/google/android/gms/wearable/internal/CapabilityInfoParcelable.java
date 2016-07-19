package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.wearable.CapabilityInfo;
import com.google.android.gms.wearable.Node;
import java.util.List;
import java.util.Set;

public class CapabilityInfoParcelable
  extends AbstractSafeParcelable
  implements CapabilityInfo
{
  public static final Parcelable.Creator<CapabilityInfoParcelable> CREATOR = new zzk();
  private Set<Node> aJV;
  private final List<NodeParcelable> aJY;
  private final String mName;
  final int mVersionCode;
  private final Object zzail = new Object();
  
  CapabilityInfoParcelable(int paramInt, String paramString, List<NodeParcelable> paramList)
  {
    mVersionCode = paramInt;
    mName = paramString;
    aJY = paramList;
    aJV = null;
    zzciw();
  }
  
  private void zzciw()
  {
    zzab.zzaa(mName);
    zzab.zzaa(aJY);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (CapabilityInfoParcelable)paramObject;
      if (mVersionCode != mVersionCode) {
        return false;
      }
      if (mName != null)
      {
        if (mName.equals(mName)) {}
      }
      else {
        while (mName != null) {
          return false;
        }
      }
      if (aJY == null) {
        break;
      }
    } while (aJY.equals(aJY));
    for (;;)
    {
      return false;
      if (aJY == null) {
        break;
      }
    }
  }
  
  public String getName()
  {
    return mName;
  }
  
  public int hashCode()
  {
    int j = 0;
    int k = mVersionCode;
    if (mName != null) {}
    for (int i = mName.hashCode();; i = 0)
    {
      if (aJY != null) {
        j = aJY.hashCode();
      }
      return (i + k * 31) * 31 + j;
    }
  }
  
  public String toString()
  {
    String str1 = mName;
    String str2 = String.valueOf(aJY);
    return String.valueOf(str1).length() + 18 + String.valueOf(str2).length() + "CapabilityInfo{" + str1 + ", " + str2 + "}";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzk.zza(this, paramParcel, paramInt);
  }
  
  public List<NodeParcelable> zzcix()
  {
    return aJY;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wearable.internal.CapabilityInfoParcelable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */