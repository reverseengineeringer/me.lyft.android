package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.wearable.Node;

public class NodeParcelable
  extends AbstractSafeParcelable
  implements Node
{
  public static final Parcelable.Creator<NodeParcelable> CREATOR = new zzbc();
  private final int aLa;
  private final boolean aLb;
  private final String dH;
  final int mVersionCode;
  private final String zzbgk;
  
  NodeParcelable(int paramInt1, String paramString1, String paramString2, int paramInt2, boolean paramBoolean)
  {
    mVersionCode = paramInt1;
    zzbgk = paramString1;
    dH = paramString2;
    aLa = paramInt2;
    aLb = paramBoolean;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof NodeParcelable)) {
      return false;
    }
    return zzbgk.equals(zzbgk);
  }
  
  public String getDisplayName()
  {
    return dH;
  }
  
  public int getHopCount()
  {
    return aLa;
  }
  
  public String getId()
  {
    return zzbgk;
  }
  
  public int hashCode()
  {
    return zzbgk.hashCode();
  }
  
  public boolean isNearby()
  {
    return aLb;
  }
  
  public String toString()
  {
    String str1 = dH;
    String str2 = zzbgk;
    int i = aLa;
    boolean bool = aLb;
    return String.valueOf(str1).length() + 45 + String.valueOf(str2).length() + "Node{" + str1 + ", id=" + str2 + ", hops=" + i + ", isNearby=" + bool + "}";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzbc.zza(this, paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wearable.internal.NodeParcelable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */