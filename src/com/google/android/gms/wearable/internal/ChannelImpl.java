package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.wearable.Channel;

public class ChannelImpl
  extends AbstractSafeParcelable
  implements Channel
{
  public static final Parcelable.Creator<ChannelImpl> CREATOR = new zzo();
  private final String aJb;
  private final String ct;
  private final String mPath;
  final int mVersionCode;
  
  ChannelImpl(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    mVersionCode = paramInt;
    ct = ((String)zzab.zzaa(paramString1));
    aJb = ((String)zzab.zzaa(paramString2));
    mPath = ((String)zzab.zzaa(paramString3));
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof ChannelImpl)) {
        return false;
      }
      paramObject = (ChannelImpl)paramObject;
    } while ((ct.equals(ct)) && (zzaa.equal(aJb, aJb)) && (zzaa.equal(mPath, mPath)) && (mVersionCode == mVersionCode));
    return false;
  }
  
  public String getNodeId()
  {
    return aJb;
  }
  
  public String getPath()
  {
    return mPath;
  }
  
  public String getToken()
  {
    return ct;
  }
  
  public int hashCode()
  {
    return ct.hashCode();
  }
  
  public String toString()
  {
    int i = mVersionCode;
    String str1 = ct;
    String str2 = aJb;
    String str3 = mPath;
    return String.valueOf(str1).length() + 66 + String.valueOf(str2).length() + String.valueOf(str3).length() + "ChannelImpl{versionCode=" + i + ", token='" + str1 + "'" + ", nodeId='" + str2 + "'" + ", path='" + str3 + "'" + "}";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzo.zza(this, paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wearable.internal.ChannelImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */