package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.wearable.MessageEvent;

public class MessageEventParcelable
  extends AbstractSafeParcelable
  implements MessageEvent
{
  public static final Parcelable.Creator<MessageEventParcelable> CREATOR = new zzba();
  private final int EO;
  private final byte[] YX;
  private final String mPath;
  final int mVersionCode;
  private final String zzcus;
  
  MessageEventParcelable(int paramInt1, int paramInt2, String paramString1, byte[] paramArrayOfByte, String paramString2)
  {
    mVersionCode = paramInt1;
    EO = paramInt2;
    mPath = paramString1;
    YX = paramArrayOfByte;
    zzcus = paramString2;
  }
  
  public byte[] getData()
  {
    return YX;
  }
  
  public String getPath()
  {
    return mPath;
  }
  
  public int getRequestId()
  {
    return EO;
  }
  
  public String getSourceNodeId()
  {
    return zzcus;
  }
  
  public String toString()
  {
    int i = EO;
    String str = mPath;
    if (YX == null) {}
    for (Object localObject = "null";; localObject = Integer.valueOf(YX.length))
    {
      localObject = String.valueOf(localObject);
      return String.valueOf(str).length() + 43 + String.valueOf(localObject).length() + "MessageEventParcelable[" + i + "," + str + ", size=" + (String)localObject + "]";
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzba.zza(this, paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wearable.internal.MessageEventParcelable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */