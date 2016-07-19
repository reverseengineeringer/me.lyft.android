package com.facebook.login;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.Date;

class DeviceAuthDialog$RequestState
  implements Parcelable
{
  public static final Parcelable.Creator<RequestState> CREATOR = new Parcelable.Creator()
  {
    public DeviceAuthDialog.RequestState createFromParcel(Parcel paramAnonymousParcel)
    {
      return new DeviceAuthDialog.RequestState(paramAnonymousParcel);
    }
    
    public DeviceAuthDialog.RequestState[] newArray(int paramAnonymousInt)
    {
      return new DeviceAuthDialog.RequestState[paramAnonymousInt];
    }
  };
  private long interval;
  private long lastPoll;
  private String requestCode;
  private String userCode;
  
  DeviceAuthDialog$RequestState() {}
  
  protected DeviceAuthDialog$RequestState(Parcel paramParcel)
  {
    userCode = paramParcel.readString();
    requestCode = paramParcel.readString();
    interval = paramParcel.readLong();
    lastPoll = paramParcel.readLong();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public long getInterval()
  {
    return interval;
  }
  
  public String getRequestCode()
  {
    return requestCode;
  }
  
  public String getUserCode()
  {
    return userCode;
  }
  
  public void setInterval(long paramLong)
  {
    interval = paramLong;
  }
  
  public void setLastPoll(long paramLong)
  {
    lastPoll = paramLong;
  }
  
  public void setRequestCode(String paramString)
  {
    requestCode = paramString;
  }
  
  public void setUserCode(String paramString)
  {
    userCode = paramString;
  }
  
  public boolean withinLastRefreshWindow()
  {
    if (lastPoll == 0L) {}
    while (new Date().getTime() - lastPoll - interval * 1000L >= 0L) {
      return false;
    }
    return true;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(userCode);
    paramParcel.writeString(requestCode);
    paramParcel.writeLong(interval);
    paramParcel.writeLong(lastPoll);
  }
}

/* Location:
 * Qualified Name:     com.facebook.login.DeviceAuthDialog.RequestState
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */