package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.wearable.zzb;

public class AmsEntityUpdateParcelable
  extends AbstractSafeParcelable
  implements zzb
{
  public static final Parcelable.Creator<AmsEntityUpdateParcelable> CREATOR = new zzf();
  private byte aJI;
  private final byte aJJ;
  private final String mValue;
  final int mVersionCode;
  
  AmsEntityUpdateParcelable(int paramInt, byte paramByte1, byte paramByte2, String paramString)
  {
    aJI = paramByte1;
    mVersionCode = paramInt;
    aJJ = paramByte2;
    mValue = paramString;
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
      paramObject = (AmsEntityUpdateParcelable)paramObject;
      if (aJI != aJI) {
        return false;
      }
      if (mVersionCode != mVersionCode) {
        return false;
      }
      if (aJJ != aJJ) {
        return false;
      }
    } while (mValue.equals(mValue));
    return false;
  }
  
  public String getValue()
  {
    return mValue;
  }
  
  public int hashCode()
  {
    return ((mVersionCode * 31 + aJI) * 31 + aJJ) * 31 + mValue.hashCode();
  }
  
  public String toString()
  {
    int i = mVersionCode;
    int j = aJI;
    int k = aJJ;
    String str = mValue;
    return String.valueOf(str).length() + 97 + "AmsEntityUpdateParcelable{mVersionCode=" + i + ", mEntityId=" + j + ", mAttributeId=" + k + ", mValue='" + str + "'" + "}";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzf.zza(this, paramParcel, paramInt);
  }
  
  public byte zzcio()
  {
    return aJI;
  }
  
  public byte zzcip()
  {
    return aJJ;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wearable.internal.AmsEntityUpdateParcelable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */