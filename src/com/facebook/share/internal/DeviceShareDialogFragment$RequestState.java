package com.facebook.share.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

class DeviceShareDialogFragment$RequestState
  implements Parcelable
{
  public static final Parcelable.Creator<RequestState> CREATOR = new Parcelable.Creator()
  {
    public DeviceShareDialogFragment.RequestState createFromParcel(Parcel paramAnonymousParcel)
    {
      return new DeviceShareDialogFragment.RequestState(paramAnonymousParcel);
    }
    
    public DeviceShareDialogFragment.RequestState[] newArray(int paramAnonymousInt)
    {
      return new DeviceShareDialogFragment.RequestState[paramAnonymousInt];
    }
  };
  private long expiresIn;
  private String userCode;
  
  DeviceShareDialogFragment$RequestState() {}
  
  protected DeviceShareDialogFragment$RequestState(Parcel paramParcel)
  {
    userCode = paramParcel.readString();
    expiresIn = paramParcel.readLong();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public long getExpiresIn()
  {
    return expiresIn;
  }
  
  public String getUserCode()
  {
    return userCode;
  }
  
  public void setExpiresIn(long paramLong)
  {
    expiresIn = paramLong;
  }
  
  public void setUserCode(String paramString)
  {
    userCode = paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(userCode);
    paramParcel.writeLong(expiresIn);
  }
}

/* Location:
 * Qualified Name:     com.facebook.share.internal.DeviceShareDialogFragment.RequestState
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */