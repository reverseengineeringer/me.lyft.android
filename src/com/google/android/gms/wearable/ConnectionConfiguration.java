package com.google.android.gms.wearable;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzaa;

public class ConnectionConfiguration
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<ConnectionConfiguration> CREATOR = new zzg();
  private final int FF;
  private final String MA;
  private final boolean aIY;
  private String aIZ;
  private boolean aJa;
  private String aJb;
  private boolean af;
  private final int it;
  private final String mName;
  final int mVersionCode;
  
  ConnectionConfiguration(int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, String paramString3, boolean paramBoolean3, String paramString4)
  {
    mVersionCode = paramInt1;
    mName = paramString1;
    MA = paramString2;
    it = paramInt2;
    FF = paramInt3;
    aIY = paramBoolean1;
    af = paramBoolean2;
    aIZ = paramString3;
    aJa = paramBoolean3;
    aJb = paramString4;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof ConnectionConfiguration)) {}
    do
    {
      return false;
      paramObject = (ConnectionConfiguration)paramObject;
    } while ((!zzaa.equal(Integer.valueOf(mVersionCode), Integer.valueOf(mVersionCode))) || (!zzaa.equal(mName, mName)) || (!zzaa.equal(MA, MA)) || (!zzaa.equal(Integer.valueOf(it), Integer.valueOf(it))) || (!zzaa.equal(Integer.valueOf(FF), Integer.valueOf(FF))) || (!zzaa.equal(Boolean.valueOf(aIY), Boolean.valueOf(aIY))) || (!zzaa.equal(Boolean.valueOf(aJa), Boolean.valueOf(aJa))));
    return true;
  }
  
  public String getAddress()
  {
    return MA;
  }
  
  public String getName()
  {
    return mName;
  }
  
  public String getNodeId()
  {
    return aJb;
  }
  
  public int getRole()
  {
    return FF;
  }
  
  public int getType()
  {
    return it;
  }
  
  public int hashCode()
  {
    return zzaa.hashCode(new Object[] { Integer.valueOf(mVersionCode), mName, MA, Integer.valueOf(it), Integer.valueOf(FF), Boolean.valueOf(aIY), Boolean.valueOf(aJa) });
  }
  
  public boolean isConnected()
  {
    return af;
  }
  
  public boolean isEnabled()
  {
    return aIY;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("ConnectionConfiguration[ ");
    String str = String.valueOf(mName);
    if (str.length() != 0)
    {
      str = "mName=".concat(str);
      localStringBuilder.append(str);
      str = String.valueOf(MA);
      if (str.length() == 0) {
        break label314;
      }
      str = ", mAddress=".concat(str);
      label62:
      localStringBuilder.append(str);
      int i = it;
      localStringBuilder.append(19 + ", mType=" + i);
      i = FF;
      localStringBuilder.append(19 + ", mRole=" + i);
      boolean bool = aIY;
      localStringBuilder.append(16 + ", mEnabled=" + bool);
      bool = af;
      localStringBuilder.append(20 + ", mIsConnected=" + bool);
      str = String.valueOf(aIZ);
      if (str.length() == 0) {
        break label327;
      }
      str = ", mPeerNodeId=".concat(str);
      label219:
      localStringBuilder.append(str);
      bool = aJa;
      localStringBuilder.append(21 + ", mBtlePriority=" + bool);
      str = String.valueOf(aJb);
      if (str.length() == 0) {
        break label340;
      }
    }
    label314:
    label327:
    label340:
    for (str = ", mNodeId=".concat(str);; str = new String(", mNodeId="))
    {
      localStringBuilder.append(str);
      localStringBuilder.append("]");
      return localStringBuilder.toString();
      str = new String("mName=");
      break;
      str = new String(", mAddress=");
      break label62;
      str = new String(", mPeerNodeId=");
      break label219;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzg.zza(this, paramParcel, paramInt);
  }
  
  public String zzcii()
  {
    return aIZ;
  }
  
  public boolean zzcij()
  {
    return aJa;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wearable.ConnectionConfiguration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */