package com.google.android.gms.wearable;

import android.net.Uri;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzaa;
import java.util.Arrays;

public class Asset
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<Asset> CREATOR = new zze();
  private byte[] YX;
  private String aIU;
  public ParcelFileDescriptor aIV;
  final int mVersionCode;
  public Uri uri;
  
  Asset(int paramInt, byte[] paramArrayOfByte, String paramString, ParcelFileDescriptor paramParcelFileDescriptor, Uri paramUri)
  {
    mVersionCode = paramInt;
    YX = paramArrayOfByte;
    aIU = paramString;
    aIV = paramParcelFileDescriptor;
    uri = paramUri;
  }
  
  public static Asset createFromRef(String paramString)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("Asset digest cannot be null");
    }
    return new Asset(1, null, paramString, null, null);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof Asset)) {
        return false;
      }
      paramObject = (Asset)paramObject;
    } while ((Arrays.equals(YX, YX)) && (zzaa.equal(aIU, aIU)) && (zzaa.equal(aIV, aIV)) && (zzaa.equal(uri, uri)));
    return false;
  }
  
  public byte[] getData()
  {
    return YX;
  }
  
  public String getDigest()
  {
    return aIU;
  }
  
  public int hashCode()
  {
    return Arrays.deepHashCode(new Object[] { YX, aIU, aIV, uri });
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Asset[@");
    localStringBuilder.append(Integer.toHexString(hashCode()));
    if (aIU == null) {
      localStringBuilder.append(", nodigest");
    }
    for (;;)
    {
      if (YX != null)
      {
        localStringBuilder.append(", size=");
        localStringBuilder.append(YX.length);
      }
      if (aIV != null)
      {
        localStringBuilder.append(", fd=");
        localStringBuilder.append(aIV);
      }
      if (uri != null)
      {
        localStringBuilder.append(", uri=");
        localStringBuilder.append(uri);
      }
      localStringBuilder.append("]");
      return localStringBuilder.toString();
      localStringBuilder.append(", ");
      localStringBuilder.append(aIU);
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zze.zza(this, paramParcel, paramInt | 0x1);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wearable.Asset
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */