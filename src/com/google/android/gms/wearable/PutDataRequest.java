package com.google.android.gms.wearable;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.wearable.internal.DataItemAssetParcelable;
import java.security.SecureRandom;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class PutDataRequest
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<PutDataRequest> CREATOR = new zzh();
  private static final long aJe = TimeUnit.MINUTES.toMillis(30L);
  private static final Random aJf = new SecureRandom();
  private byte[] YX;
  private final Bundle aJg;
  private long aJh;
  private final Uri mUri;
  final int mVersionCode;
  
  PutDataRequest(int paramInt, Uri paramUri, Bundle paramBundle, byte[] paramArrayOfByte, long paramLong)
  {
    mVersionCode = paramInt;
    mUri = paramUri;
    aJg = paramBundle;
    aJg.setClassLoader(DataItemAssetParcelable.class.getClassLoader());
    YX = paramArrayOfByte;
    aJh = paramLong;
  }
  
  public byte[] getData()
  {
    return YX;
  }
  
  public Uri getUri()
  {
    return mUri;
  }
  
  public String toString()
  {
    return toString(Log.isLoggable("DataMap", 3));
  }
  
  public String toString(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder("PutDataRequest[");
    if (YX == null) {}
    for (Object localObject = "null";; localObject = Integer.valueOf(YX.length))
    {
      localObject = String.valueOf(localObject);
      localStringBuilder.append(String.valueOf(localObject).length() + 7 + "dataSz=" + (String)localObject);
      int i = aJg.size();
      localStringBuilder.append(23 + ", numAssets=" + i);
      localObject = String.valueOf(mUri);
      localStringBuilder.append(String.valueOf(localObject).length() + 6 + ", uri=" + (String)localObject);
      long l = aJh;
      localStringBuilder.append(35 + ", syncDeadline=" + l);
      if (paramBoolean) {
        break;
      }
      localStringBuilder.append("]");
      return localStringBuilder.toString();
    }
    localStringBuilder.append("]\n  assets: ");
    localObject = aJg.keySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str1 = (String)((Iterator)localObject).next();
      String str2 = String.valueOf(aJg.getParcelable(str1));
      localStringBuilder.append(String.valueOf(str1).length() + 7 + String.valueOf(str2).length() + "\n    " + str1 + ": " + str2);
    }
    localStringBuilder.append("\n  ]");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzh.zza(this, paramParcel, paramInt);
  }
  
  public Bundle zzcik()
  {
    return aJg;
  }
  
  public long zzcil()
  {
    return aJh;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wearable.PutDataRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */